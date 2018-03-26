package Controller;

import Database.CheckTypes;
import Database.DatabaseWork;
import Model.CoverProfilePic;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "ProfilePicStorage" , urlPatterns = {"/profilepicservlet"})
@MultipartConfig
public class ProfilePicUploadServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String Username = (String) session.getAttribute("username");
        CheckTypes ty = new CheckTypes();
        DatabaseWork db = new DatabaseWork();
        CoverProfilePic in = new CoverProfilePic();
        in.setUsername(Username);

        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if (isMultipart) {
            System.out.println("entered");
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            System.out.println("a1");
            // Parse the request
            try {
                List<FileItem> items = upload.parseRequest(request);
                Iterator<FileItem> iter = items.iterator();
                String field;
                String value;
                while (iter.hasNext()) {
                    FileItem item = iter.next();
                    System.out.println("a2");
                    if (!item.isFormField()) {
                        try {
                            String fileName = item.getName();
                            value = item.getString();
                            in.setProfile(fileName);
                            if (!"".equals(value)) {
                                String root = getServletContext().getRealPath("/");
                                File path = new File(root + "/profilephotos");
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
            } catch (FileUploadException e) {
                // TODO Auto-generated catch block
                System.out.println("error");
                e.printStackTrace();
            }
        }

        String type = ty.return_type(Username);
        if(type.compareTo("Applicant")==0 ) {
            String result = db.uploadprofile(in);
            result = "Profile Photo loaded successfully";
            System.out.println("13");
            request.setAttribute("result", result);
            request.setAttribute("pathofimage", db.retrieving_image_path(Username));
            request.setAttribute("pathofimage1", db.retrieving_profile_image_path(Username));
            request.getRequestDispatcher("/Applicant/applicanthome.jsp").forward(request, response);
        }
        else if(type.compareTo("hrpersonal")==0 )
        {
            String result = db.uploadprofile(in);
            result = "Profile Photo loaded successfully";
            System.out.println("13");
            request.setAttribute("result", result);
            request.setAttribute("pathofimage", db.retrieving_image_path(Username));
            request.setAttribute("pathofimage1", db.retrieving_profile_image_path(Username));
            request.getRequestDispatcher("/hrpersonal/hrpersonalhome.jsp").forward(request, response);
        }
        else if(type.compareTo("hrmanager") ==0 )
        {
            String result = db.uploadprofile(in);
            result = "Profile Photo loaded successfully";
            System.out.println("13");
            request.setAttribute("result", result);
            request.setAttribute("pathofimage", db.retrieving_image_path(Username));
            request.setAttribute("pathofimage1", db.retrieving_profile_image_path(Username));
            request.getRequestDispatcher("/Applicant/applicanthome.jsp").forward(request, response);

        }
        else if(type.compareTo("sme") ==0)
        {
            String result = db.uploadprofile(in);
            result = "Profile Photo loaded successfully";
            System.out.println("13");
            request.setAttribute("result", result);
            request.setAttribute("pathofimage", db.retrieving_image_path(Username));
            request.setAttribute("pathofimage1", db.retrieving_profile_image_path(Username));
            request.getRequestDispatcher("/Applicant/applicanthome.jsp").forward(request, response);

        }
    }
}
