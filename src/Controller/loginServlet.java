package Controller;

import Database.CheckTypes;
import Database.DatabaseWork;
import Model.Signin;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by jamsh on 3/17/2017.
 */
@WebServlet(name = "loginServlet", urlPatterns = {"/signinservlet"})
public class loginServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Signin obj  = new Signin();
        CheckTypes check = new CheckTypes();
        DatabaseWork db = new DatabaseWork();


        obj.setUsername(Jsoup.clean(request.getParameter("TextUserName"),Whitelist.basic()));
        obj.setPassword(Jsoup.clean(request.getParameter("TextPassword"),Whitelist.basic()));
        boolean flag = obj.verify_user();
        if(flag == true)
        {
            System.out.println("a");
            String username;
            username = Jsoup.clean(request.getParameter("TextUserName"),Whitelist.basic());
            String usertype = check.return_type(username);
            System.out.println("g");


            if(usertype.compareTo("hrmanager") == 0)
            {
                HttpSession session = request.getSession();
                session.setAttribute("username",username);
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }
            else if(usertype.compareTo("hrpersonal") == 0)
            {
                HttpSession session = request.getSession();
                session.setAttribute("username",username);
                request.setAttribute("pathofimage",db.retrieving_image_path(username));
                request.setAttribute("pathofimage1",db.retrieving_profile_image_path(username));

                request.getRequestDispatcher("/hrpersonal/hrpersonalhome.jsp").forward(request,response);
            }
            else if(usertype.compareTo("sme") ==0)
            {
                HttpSession session = request.getSession();
                session.setAttribute("username",username);
                request.setAttribute("pathofimage",db.retrieving_image_path(username));
                request.setAttribute("pathofimage1",db.retrieving_profile_image_path(username));
                request.getRequestDispatcher("/SME/smehome.jsp").forward(request,response);
            }

            else if(usertype.compareTo("Applicant") == 0)
            {
                HttpSession session = request.getSession(false);
                session.setAttribute("username", username);
                request.setAttribute("pathofimage",db.retrieving_image_path(username));
                request.setAttribute("pathofimage1",db.retrieving_profile_image_path(username));
                request.getRequestDispatcher("/Applicant/applicanthome.jsp").forward(request, response);
            }
        }
        else if(flag == false)
        {
            System.out.println("alo");
            String message;
            message = "Username or Password Incorect!";
            request.setAttribute("message",message);
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }
}
