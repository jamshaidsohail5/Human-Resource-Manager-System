package Controller;

import Database.DatabaseWork;
import Model.EmailUtility;
import Model.smereplies;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by jamsh on 3/30/2017.
 */
@WebServlet(name = "SendingUsertheinterview", urlPatterns = {"/sendinguserthinterviewtime"})
public class SendingUsertheinterview extends HttpServlet {

    private String host;
    private String port;
    private String user;
    private String pass;
    private String res;


    public void init(){
        ServletContext context = getServletContext();
        host = context.getInitParameter("host");
        port = context.getInitParameter("port");
        user = context.getInitParameter("user");
        pass = context.getInitParameter("pass");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("1");
        DatabaseWork db = new DatabaseWork();
        System.out.println("2");
        String jobtitle = request.getParameter("jobti");
        System.out.println("3");
        ArrayList<String> users = new ArrayList<String>();
        System.out.println("4");
        users = db.retrieving_users_with_specified_job(jobtitle);
        System.out.println("5");
        HttpSession session = request.getSession();
        System.out.println("6");
        String username = (String) session.getAttribute("username");

        ArrayList<String> array_containing_emails = new ArrayList<String>();

        for(int  i = 0;i<users.size();i++)
        {
            array_containing_emails.add(db.retrieving_email(users.get(i)));
        }

        for(int i = 0 ; i < array_containing_emails.size();i++)
        {

            String recipient=res;
            String subject="Interview Call";
            String content="Dear \n"+
                    users.get(i)+" you are called for interview on date\n for job \n"
                    +jobtitle+"\nthanks";
            String resultMessage = "";

            try {
                EmailUtility.sendEmail(host, port, user, pass, recipient, subject,content);
            }
            catch (Exception ex) {
                ex.printStackTrace();
                resultMessage = "There were an error: " + ex.getMessage();
            } finally {

            }

        }





        smereplies s = new smereplies();
        s.setSmename(request.getParameter("smena"));
        s.setSpecialization(request.getParameter("tim"));
        s.setDate(request.getParameter("jobti"));
        db.deleting_sme_replies(s);


        request.setAttribute("pathofimage",db.retrieving_image_path(username));
        request.setAttribute("pathofimage1",db.retrieving_profile_image_path(username));
        getServletContext().getRequestDispatcher("/hrpersonal/hrpersonalhome.jsp").forward(
                request, response);


    }

}
