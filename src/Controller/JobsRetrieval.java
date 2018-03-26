package Controller;

import Database.DatabaseWork;
import Model.JobInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by jamsh on 3/19/2017.
 */
@WebServlet(name = "JobsRetrieval" , urlPatterns = {"/jobsretrieval"})
public class JobsRetrieval extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        System.out.println("1");
        DatabaseWork db  = new DatabaseWork();
        System.out.println(("2"));
        ArrayList<JobInfo> arr = new ArrayList<>();
        System.out.println("3");
        arr = db.retrieving_jobs();
        System.out.println("8");


       // request.setAttribute("arr",arr);

        String totalJobs = "";
        for (int i=0 ; i<arr.size();i++)
        {
            totalJobs +=   "<div style='width:600px;height:200px;border:1px solid #000; margin-top:100px;margin-left:450px;'>";
            totalJobs +=   "<form action = 'jobapplying' method = 'post' enctype='multipart/form-data' >";
            totalJobs +=   "<label style='padding-left:270px;' >"+arr.get(i).getTitle()+"</label>";
            totalJobs +=   "<h4 style = 'margin-left:40px;'>Requirements</h4><ul>";
            totalJobs +=   "<li>"+arr.get(i).getRequirements()+"</li></ul>";
            totalJobs += "<input type='text' name ="+"jobtitle"+" placeholder = 'Enter Job Title here' style = 'margin-left:40px; ></input>";
            totalJobs +=    "<label style = 'padding-left:10px;'>Upload your cv here!</label>";
            totalJobs +=    "<input type='file' name='file2' size='40' style = 'padding-left:350px;margin-top:-20px;'>";
            totalJobs += "<input type='submit' value = 'apply' class='btn btn-danger' style = 'margin-left:40px;'></input></form></div>";
        }

       // System.out.println(totalJobs);
        request.setAttribute("JOBS",totalJobs);
        request.getRequestDispatcher("/Applicant/seejobs.jsp").forward(request, response);

    }
}
