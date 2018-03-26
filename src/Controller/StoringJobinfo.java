package Controller;

import Database.DatabaseWork;
import Model.JobInfo;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by jamsh on 3/19/2017.
 */
@WebServlet(name = "StoringJobinfo", urlPatterns = {"/storingjobinfo"})
@MultipartConfig
public class StoringJobinfo extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DatabaseWork db = new DatabaseWork();
        JobInfo jobInfo = new JobInfo();
        System.out.println("aq");


        HttpSession session = request.getSession();
        System.out.println("aq1");


        String Username = (String) session.getAttribute("username");
        System.out.println("aq2");


        jobInfo.setTitle(Jsoup.clean(request.getParameter("title"),Whitelist.basic()));

        System.out.println("aq3");

        jobInfo.setRequirements(Jsoup.clean(request.getParameter("requirements"),Whitelist.basic()));
        System.out.println("aq4");

        db.storing_job_info(jobInfo);
        System.out.println("aq5");

        request.setAttribute("pathofimage", db.retrieving_image_path(Username));
        request.setAttribute("pathofimage1", db.retrieving_profile_image_path(Username));
        request.getRequestDispatcher("/hrpersonal/hrpersonalhome.jsp").forward(request, response);
    }
}
