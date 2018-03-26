package Controller;

import Database.DatabaseWork;
import Model.smereplies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "retrievingsmereplies", urlPatterns = {"/retrievingsmereplies"})
public class retrievingsmereplies extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DatabaseWork db = new DatabaseWork();
        ArrayList<smereplies> arr = new ArrayList<smereplies>();
        arr  = db.retrieving_sme_replies();

        String replies;
        replies = "";
        for(int  i = 0 ;i < arr.size();i++)
        {
            replies += "<div style='width:600px;height:200px;border:1px solid #000; margin-top:100px;margin-left:450px;'>";
            replies += "<form action = '/sendinguserthinterviewtime' method = 'post' enctype='multipart/form-data'>";
            replies += "<p><p>"+arr.get(i).getSmename()+"</p> is available at time <p>"+arr.get(i).getDate()+"</p> for job <p>"+arr.get(i).getSpecialization()+"</p></p>";
            replies += "<input type='submit' style = 'margin-left:10px;' value = 'seen' class='btn btn-danger' required></input>";
            replies += "<input type ='text' name = 'smena' style = 'margin-top:10px;display:block;' placeholder = 'Enter Sme Name' >";
            replies += "<input type ='text' name = 'tim' style = 'margin-text:10px;display:block;' placeholder = 'Enter Time Here' >";
            replies += "<input type ='text' name = 'jobti' style = 'margin-text:10px;display:block;' placeholder = 'Enter Job Title here'>";
            replies += "</form></div>";
        }

        request.setAttribute("REP",replies);
        request.getRequestDispatcher("/hrpersonal/noti2.jsp").forward(request, response);
    }
}
