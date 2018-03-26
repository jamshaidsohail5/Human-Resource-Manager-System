package Controller;

import Database.DatabaseWork;
import Model.EmailUtility;
import Model.rejectionrecord;
import Model.smeemailstuff;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "SendingSmeEmails", urlPatterns = {"/confirmingemailsfromsme"})
public class SendingSmeEmails extends HttpServlet {

    private String host;
    private String port;
    private String user;
    private String pass;
    private String res;
    DatabaseWork db = new DatabaseWork();

    public void init() {

        // reads SMTP server setting from web.xml file
        ServletContext context = getServletContext();
        host = context.getInitParameter("host");
        port = context.getInitParameter("port");
        user = context.getInitParameter("user");
        pass = context.getInitParameter("pass");
     }



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        smeemailstuff s = new smeemailstuff();
        HttpSession session = request.getSession();
        String username= (String) session.getAttribute("username");
        String Username = Jsoup.clean(request.getParameter("username"), Whitelist.basic());
        String jobtitle  = Jsoup.clean(request.getParameter("jobtitle"),Whitelist.basic());



        rejectionrecord r = new rejectionrecord();
        r.setUsername(Username);
        r.setJobtitle(jobtitle);
        db.storing_job_success_applications(r);
        db.removing_job_application_record(Username,jobtitle);


        String recipient=db.retrieving_email(Username);
        String subject="Application Acceptance";
        String content="Dear " + Username + "!\n "+ " Congratulations we have accepted your \nfor " +jobtitle +".\nInterview time will be announced latter.\n"
                    +"Regards\n Hrpersonal";

        try {
            EmailUtility.sendEmail(host, port, user, pass, recipient, subject,content);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        } finally {

            s = db.retrieving_sme_email(jobtitle);
            recipient = s.getSmeemail();
            subject ="Confirming time";
            content = "Dear " + s.getSmename() + "!\n " + " Please Confirm the time of your \navailability.You have to take the interview of an applicant for job " + jobtitle
                        + ".\nRegards\n Hrpersonal";

            try {
                EmailUtility.sendEmail(host, port, user, pass, recipient, subject,content);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            } finally {


                rejectionrecord r1 = new rejectionrecord();
                r1.setJobtitle(jobtitle);
                r1.setUsername(s.getSmename());
                db.storing_sme_emails(r1);

                request.setAttribute("pathofimage",db.retrieving_image_path(username));
                request.setAttribute("pathofimage1",db.retrieving_profile_image_path(username));
                getServletContext().getRequestDispatcher("/hrpersonal/hrpersonalhome.jsp").forward(
                          request, response);
                }
            }
    }
}
