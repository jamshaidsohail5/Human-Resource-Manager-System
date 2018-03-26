package Controller;

import Model.SignUpclass;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by jamsh on 3/15/2017.
 */
@javax.servlet.annotation.WebServlet(name = "SignupServlet", urlPatterns = {"/signupservlet"})
public class SignupServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {




        System.out.println("1");


        SignUpclass obj = new SignUpclass();
        obj.setName(Jsoup.clean(request.getParameter("textName"), Whitelist.basic()));
        obj.setSecondName(Jsoup.clean(request.getParameter("textSecondname"), Whitelist.basic()));
        obj.setUsername(Jsoup.clean(request.getParameter("textUsername"), Whitelist.basic()));
        obj.setPassword(Jsoup.clean(request.getParameter("textPassword"), Whitelist.basic()));
        obj.setSpecialization(Jsoup.clean(request.getParameter("textSpecialization"), Whitelist.basic()));
        obj.setCnic(Jsoup.clean(request.getParameter("textCnic"), Whitelist.basic()));
        obj.setCellno(Jsoup.clean(request.getParameter("textCellno"), Whitelist.basic()));
        obj.setPostalCode(Jsoup.clean(request.getParameter("textPostalcode"), Whitelist.basic()));
        obj.setApplicantAdress(Jsoup.clean(request.getParameter("textAdress"), Whitelist.basic()));
        obj.setEmail(Jsoup.clean(request.getParameter("textEmail"), Whitelist.basic()));
        obj.setCity(Jsoup.clean(request.getParameter("textCity"), Whitelist.basic()));

        System.out.println("2");

      // boolean flag =  obj.check_user();

        System.out.println("9");


        String username = request.getParameter("aj_username");
         obj.setUsername(username);
        boolean ajaxcheck =obj.checkUserName(username);

        if(ajaxcheck)
        {
            PrintWriter out = response.getWriter();
            out.print("<label style='color:GREEN;'>Okay!</label>");
        } else
        {
            PrintWriter out = response.getWriter();
            out.print("<label style='color:RED;'>UserName Already existed</label>");
        }


/*
        if(flag == false) {

           String message;
           message = "UserName Already existed Please choose a different UserName !";
           request.setAttribute("message", message);
           request.getRequestDispatcher("/Signup.jsp").forward(request, response);

       }
       else if(flag == true)
       {

           String message;
           message = "Account Created Successfully.Now Log in!";
           request.setAttribute("accountCreation",message);
           request.getRequestDispatcher("/login.jsp").forward(request,response);

       }
*/
    }

}
