package Controller;

import Database.DatabaseWork;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "SavingInterviewTime", urlPatterns = {"/savinginterviewtimeanddate"})
public class SavingInterviewTime extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String startDateStr = Jsoup.clean(request.getParameter("time1"), Whitelist.basic());
        DatabaseWork db = new DatabaseWork();
        HttpSession session = request.getSession();
        String Username = (String) session.getAttribute("username");
        db.deleting_sme_email(Username);
        String specialization = db.retrieving_sme_specialization(Username);
        db.saving_interview_date_and_time(startDateStr,Username,specialization);
        request.setAttribute("pathofimage",db.retrieving_image_path(Username));
        request.setAttribute("pathofimage1",db.retrieving_profile_image_path(Username));
        request.getRequestDispatcher("/SME/smehome.jsp").forward(request, response);
    }
}
