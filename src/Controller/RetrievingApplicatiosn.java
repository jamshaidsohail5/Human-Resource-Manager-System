package Controller;

import Database.DatabaseWork;
import Model.jobapplicationdata;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "RetrievingApplications", urlPatterns = {"/retrievingapplications"})
public class RetrievingApplicatiosn extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DatabaseWork db =new DatabaseWork();
        ArrayList<jobapplicationdata> arr = db.retrieving_jobs_application();

        String totalJobs = "";
        for (int i=0 ; i<arr.size();i++)
        {
            totalJobs +=   "<div style='width:600px;height:200px;border:1px solid #000;margin-left:450px;margin-top:100px;'>";
            totalJobs +=   "<p style = 'padding-top:10px;padding-left:10px;'><p>"+arr.get(i).getUsername()+"</p> has applied for job <p>"+arr.get(i).getJobtitle()+"</p></p>";
            totalJobs +=   "<input type='file' name='file3' size='40' src = '"+arr.get(i).getCvpath()+"' style = 'padding-top:30px;padding-left:20px;'>";
            totalJobs +=   "<form action = 'confirmingemailsfromsme' method = 'post'>";
            totalJobs +=   "<input type='submit'  name = 'accept' value = 'Accept' class='btn btn-danger' style = 'margin-left:20px;margin-top:0px;'></input>";
            totalJobs +=   "<input type = 'text' name = 'username' style = 'margin-top:20px;' placeholder = 'Enter username here'>";
            totalJobs +=   "<input type = 'text' name = 'jobtitle' placeholder = 'Enter jobtitle here'>";
            totalJobs +=   "</form>";
            totalJobs +=   "<form action = 'sendingrejectiontoapplicant' method = 'post'>";
            totalJobs +=   "<input type='submit' name = 'reject' value = 'Reject' class='btn btn-danger' style = 'margin-left:20px;'></input>";
            totalJobs +=   "<input type = 'text' name = 'username1' placeholder = 'Enter username here'>";
            totalJobs +=   "<input type = 'text' name = 'jobtitle1' placeholder = 'Enter jobtitle here'>";
            totalJobs +=   "</form></div>";
        }

        request.setAttribute("APP",totalJobs);
        getServletContext().getRequestDispatcher("/hrpersonal/notifications.jsp").forward(
                request, response);
    }
}
