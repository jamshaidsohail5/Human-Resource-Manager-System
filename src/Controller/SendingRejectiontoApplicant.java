package Controller;

import Database.DatabaseWork;
import Model.EmailUtility;
import Model.rejectionrecord;
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

@WebServlet(name = "SendingRejectiontoApplicant", urlPatterns = {"/sendingrejectiontoapplicant"})
public class SendingRejectiontoApplicant extends HttpServlet {
    private String host;
    private String port;
    private String user;
    private String pass;
    private String res;

    public void init() {
        // reads SMTP server setting from web.xml file
        ServletContext context = getServletContext();
        host = context.getInitParameter("host");
        port = context.getInitParameter("port");
        user = context.getInitParameter("user");
        pass = context.getInitParameter("pass");
        //res = context.getInitParameter("res");
    }



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DatabaseWork db =new DatabaseWork();
        rejectionrecord r = new rejectionrecord();

        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        String Username = Jsoup.clean(request.getParameter("username1"), Whitelist.basic());
        String jobtitle = Jsoup.clean(request.getParameter("jobtitle1"),Whitelist.basic());
        r.setUsername(Username);
        r.setJobtitle(jobtitle);
        db.adding_rejection_to_db(r);
        db.removing_job_application_record(Username,jobtitle);


        String recipient=db.retrieving_email(Username);
        String subject="Application Rejection";
        String content="Dear " +Username+ "!\n "+ " Sorry you are not eligible for the job " +jobtitle +".\n"
                    +"Regards\n Hrpersonal";

        try {
            EmailUtility.sendEmail(host, port, user, pass, recipient, subject,content);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            request.setAttribute("pathofimage",db.retrieving_image_path(username));
            request.setAttribute("pathofimage1",db.retrieving_profile_image_path(username));
            getServletContext().getRequestDispatcher("/hrpersonal/hrpersonalhome.jsp").forward(
                        request, response);
            }
        }
}
