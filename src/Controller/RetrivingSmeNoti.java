package Controller;

import Database.DatabaseWork;
import Model.smeemails;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "RetrivingSmeNoti", urlPatterns = {"/retrievingsmenoti"})
public class RetrivingSmeNoti extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DatabaseWork db  = new DatabaseWork();
        boolean flag;
        HttpSession session = request.getSession();
        String Username = (String) session.getAttribute("username");
        flag = db.checking_sme_notification(Username);


        String notifications;
        notifications = "";
        if(flag == true)
        {

            String specialization = db.retrieving_sme_specialization(Username);
            notifications += "<div style='width:600px;height:200px;border:1px solid #000; margin-top:100px;margin-left:450px;'>";
            notifications += "<form action = 'savinginterviewtimeanddate' method = 'post' enctype='multipart/form-data'>";
            notifications += "<p>Dear <p>"+Username+"</p>  you have to take the interview for the job <p>"+specialization+".</p></p>";
            notifications += "<p>Please Confirm the time below!</p>";
            notifications += "<input type='date' name = "+"time1"+" placeholder = 'Enter Date(03/31/2017)' required></input>";
            notifications += "<input type='submit' value = 'apply' class='btn btn-danger' required></input>";
            notifications += "</form></div>";
            request.setAttribute("NOTS",notifications);
            request.getRequestDispatcher("/SME/noti1.jsp").forward(request, response);
        }
        else if(flag == false)
        {
            System.out.println("4");
            notifications ="";
            request.setAttribute("NOT",notifications);
            request.getRequestDispatcher("/SME/noti1.jsp").forward(request, response);
        }
    }
}
