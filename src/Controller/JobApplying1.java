package Controller;

import Database.DatabaseWork;
import Model.EmailUtility;
import Model.jobapplicationdata;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "JobApplying1", urlPatterns = {"/jobapplying"})
public class JobApplying1 extends HttpServlet {

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
        res = context.getInitParameter("res");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
         jobapplicationdata in = new jobapplicationdata();
        DatabaseWork db = new DatabaseWork();
         in.setUsername(username);



        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if(isMultipart)
        {
            System.out.println("entered");
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            System.out.println("a1");
            // Parse the request
            try
            {
                List<FileItem> items=upload.parseRequest(request);
                Iterator<FileItem> iter = items.iterator();
                String field;
                String value;
                while (iter.hasNext()) {
                    FileItem item = iter.next();
                    System.out.println("a2");
                    //in.setJobtitle(request.getParameter("jobtitle1"));
                    if (item.isFormField()) //your code for getting form fields
                    {
                        System.out.println("a3");
                        field = item.getFieldName();
                        if(field.equals("jobtitle"))
                        {
                            System.out.println("a4");
                            value = item.getString();
                            in.setJobtitle(Jsoup.clean(value, Whitelist.basic()));

                            System.out.println(value);
                        }

                    }
                    if (!item.isFormField()) {
                        try {
                            String fileName = item.getName();
                            value = item.getString();
                            in.setCvpath(Jsoup.clean(fileName,Whitelist.basic()));
                            if(!"".equals(value))
                            {
                                String root = getServletContext().getRealPath("/");
                                File path = new File(root + "/cvs");
                                if (!path.exists()) {
                                    path.mkdirs();
                                }
                                File uploadedFile = new File(path + "/" + fileName);
                                item.write(uploadedFile);
                            }
                        } catch (Exception e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }
            }
            catch (FileUploadException e) {
                // TODO Auto-generated catch block
                System.out.println("error");
                e.printStackTrace();
            }
            // Process the uploaded items

            db.adding_job_application_information(in);




            String recipient=res;
            String subject="Job Applying";
            String content="Dear Hrpersonal\n"+
                    username+"has applied for job.\n"
                    +"thanks";
            String resultMessage = "";


            try {
                    EmailUtility.sendEmail(host, port, user, pass, recipient, subject,content);
                }
            catch (Exception ex) {
                ex.printStackTrace();
                resultMessage = "There were an error: " + ex.getMessage();
            } finally {
                request.setAttribute("Message", resultMessage);
                request.setAttribute("pathofimage",db.retrieving_image_path(username));
                request.setAttribute("pathofimage1",db.retrieving_profile_image_path(username));
                getServletContext().getRequestDispatcher("/Applicant/applicanthome.jsp").forward(
                        request, response);
            }
        }
    }
}


