package Database;

import Model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by jamsh on 3/17/2017.
 */
public class DatabaseWork {

    private static Connection con;
    private static Statement st;
    static ResultSet rs;


    public boolean connecting_to_db_and_verify(SignUpclass obj) {
        System.out.println("4");
        boolean flag;
        flag = false;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "dbprojectdatabase", "root", "");

            String query = "insert into users (Name,SecondName,UserName,loginpassword,CNIC,CellNo,postalcode,city,applicantaddress,email,typeofuser,specialization)" +
                    " values (?,?,?,?,?,?,?,?,?,?,?,?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, obj.getName());
            preparedStmt.setString(2, obj.getSecondName());
            preparedStmt.setString(3, obj.getUsername());
            preparedStmt.setString(4, obj.getPassword());
            preparedStmt.setString(5, obj.getCnic());
            preparedStmt.setString(6, obj.getCellno());
            preparedStmt.setString(7, obj.getPostalCode());
            preparedStmt.setString(8, obj.getCity());
            preparedStmt.setString(9, obj.getApplicantAdress());
            preparedStmt.setString(10, obj.getEmail());
            preparedStmt.setString(11, "Applicant");
            preparedStmt.setString(12, obj.getSpecialization());

            System.out.println("6");


            // execute the preparedstatement
            preparedStmt.execute();
            con.close();
            flag = true;
            System.out.println("7");
        } catch (ClassNotFoundException e) {
            System.out.println("exception class not found");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("sql exception");
            flag = false;
            e.printStackTrace();
        }
        return flag;
    }

    public boolean validate_login(Signin obj) {
        boolean flag;
        flag = false;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "dbprojectdatabase", "root", "");

            //String query = "Select * from users" + " where UserName = '" +obj.getUsername() + " AND loginpassword = " + obj.getPassword();
            //String query = "Select * from users;";
            String query = "Select * from users";


            System.out.println(obj.getUsername());
            System.out.println(obj.getPassword());
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);


            while (rs.next()) {

                String usern = rs.getString("UserName");
                String pass = rs.getString("loginpassword");
                if ((usern.compareTo(obj.getUsername()) == 0) && (pass.compareTo(obj.getPassword()) == 0)) {
                    flag = true;
                }
            }
            st.close();
        } catch (ClassNotFoundException e) {
            System.out.println("exception class not found");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("sql exception");
            flag = false;
            e.printStackTrace();
        }
        return flag;
    }

    public static boolean validate_username(String username) {
        boolean flag;
        flag = false;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "dbprojectdatabase", "root", "");

            //String query = "Select * from users" + " where UserName = '" +username;
            String query = "SELECT * FROM users";

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);




            while (rs.next()) {

                String usern = rs.getString("UserName");
                if ((usern.compareTo(username) == 0)) {
                    return false;
                }
            }

            st.close();
        } catch (ClassNotFoundException e) {
            System.out.println("exception class not found");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("sql exception");
            flag = false;
            e.printStackTrace();
        }
        return true;
    }



    public String uploadcover(CoverProfilePic obj) {
        System.out.println("8");
        String message = null;

        try {
            // connects to the database
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "dbprojectdatabase", "root", "");

            // constructs SQL statement
            String sql = "UPDATE users set coverphoto = ?  where UserName = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            System.out.println("9");


            statement.setString(1, "coverphotos/" + obj.getCoverPhoto());
            statement.setString(2, obj.getUsername());


            // sends the statement to the database server
            int row = statement.executeUpdate();
            if (row > 0) {
                message = "File uploaded and saved into database";
                System.out.println("11");
            }
        } catch (SQLException ex) {
            message = "ERROR: " + ex.getMessage();
            ex.printStackTrace();
            System.out.println("Error while uploading picture to dbms");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                // closes the database connection
                try {
                    con.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            System.out.println("12");

        }
        return message;
    }

    public String uploadprofile(CoverProfilePic obj) {
        String message = null;

        try {
            // connects to the database
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "dbprojectdatabase", "root", "");

            // constructs SQL statement
            String sql = "UPDATE users set profilepic = ?  where UserName = ?";
            PreparedStatement statement = con.prepareStatement(sql);


            statement.setString(1, "profilephotos/" + obj.getProfile());
            statement.setString(2, obj.getUsername());


            // fetches input stream of the upload file for the blob column
            System.out.println("10");

            // sends the statement to the database server
            int row = statement.executeUpdate();
            if (row > 0) {
                message = "File uploaded and saved into database";
                System.out.println("11");
            }
        } catch (SQLException ex) {
            message = "ERROR: " + ex.getMessage();
            ex.printStackTrace();
            System.out.println("Error while uploading picture to dbms");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                // closes the database connection
                try {
                    con.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            System.out.println("12");

        }
        return message;

    }

    public String retrieving_image_path(String Username) {
        String path;
        path = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "dbprojectdatabase", "root", "");

            String query = "Select * from users";


            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);


            while (rs.next()) {

                String usern = rs.getString("UserName");
                if ((usern.compareTo(Username) == 0)) {
                    path = rs.getString("coverphoto");
                }
            }
            st.close();
        } catch (ClassNotFoundException e) {
            System.out.println("exception class not found");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("sql exception");
            e.printStackTrace();
        }
        return path;
    }

    public String retrieving_profile_image_path(String Username) {
        String path;
        path = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "dbprojectdatabase", "root", "");

            String query = "Select * from users";


            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);


            while (rs.next()) {

                String usern = rs.getString("UserName");
                if ((usern.compareTo(Username) == 0)) {
                    path = rs.getString("profilepic");
                }
            }
            st.close();
        } catch (ClassNotFoundException e) {
            System.out.println("exception class not found");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("sql exception");
            e.printStackTrace();
        }
        return path;
    }

    public boolean storing_job_info(JobInfo obj) {
        String message = null;

        try {
            // connects to the database
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "dbprojectdatabase", "root", "");
            String query = "insert into jobsdetail (jobtitle,requirements)" +
                    " values (?,?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, obj.getTitle());
            preparedStmt.setString(2, obj.getRequirements());


            // execute the preparedstatement
            preparedStmt.execute();
            con.close();
        } catch (ClassNotFoundException e) {
            System.out.println("exception class not found");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("exception while inserting job details into the db");
            e.printStackTrace();
        }

        return true;
    }

    public ArrayList<JobInfo> retrieving_jobs() {
        System.out.println("4");
        ArrayList<JobInfo> temp = new ArrayList<>();
        String path;
        path = null;
        System.out.println("5");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "dbprojectdatabase", "root", "");

            String query = "Select * from jobsdetail";
            System.out.println("6");


            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);


            while (rs.next()) {
                String jobtitle = rs.getString("jobtitle");
                String requirements = rs.getString("requirements");
                JobInfo in = new JobInfo();
                in.setRequirements(requirements);
                in.setTitle(jobtitle);
                temp.add(in);
                System.out.println("7");
            }
            st.close();
        } catch (ClassNotFoundException e) {
            System.out.println("exception class not found");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("error while retriving the images from the database");
            e.printStackTrace();
        }

        return temp;
    }

    public ArrayList<jobapplicationdata> retrieving_jobs_application() {
        ArrayList<jobapplicationdata> list = new ArrayList<jobapplicationdata>();


        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "dbprojectdatabase", "root", "");

            String query = "Select * from applicantapplying;";


            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);


            while (rs.next()) {

                String usern = rs.getString("username");
                String jobtitle = rs.getString("jobtitle");
                String cvfile = rs.getString("cvfile");
                jobapplicationdata j = new jobapplicationdata();
                j.setUsername(usern);
                j.setJobtitle(jobtitle);
                j.setCvpath(cvfile);
                list.add(j);
            }
            st.close();
        } catch (ClassNotFoundException e) {
            System.out.println("exception class not found");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Sql Exception while retrieving Users Job");
            e.printStackTrace();
        }
        return list;
    }

    public void adding_job_application_information(jobapplicationdata obj) {
        boolean flag;
        flag = false;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "dbprojectdatabase", "root", "");

            String query = "insert into applicantapplying (username,jobtitle,cvfile)" +
                    " values (?,?,?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, obj.getUsername());
            preparedStmt.setString(2, obj.getJobtitle());
            preparedStmt.setString(3, "cvs/" + obj.getCvpath());

            System.out.println("6");


            // execute the preparedstatement
            preparedStmt.execute();
            con.close();

            System.out.println("7");
        } catch (ClassNotFoundException e) {
            System.out.println("exception class not found");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("sql exception");
            e.printStackTrace();
        }

    }

    public String retrieving_email(String username) {
        String email;
        email = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "dbprojectdatabase", "root", "");

            String query = "Select * from users";


            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);


            while (rs.next()) {

                String usern = rs.getString("UserName");
                if ((usern.compareTo(username) == 0)) {
                    email = rs.getString("email");
                }
            }
            st.close();
        } catch (ClassNotFoundException e) {
            System.out.println("exception class not found");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("sql exception");
            e.printStackTrace();
        }
        return email;
    }

    public void adding_rejection_to_db(rejectionrecord obj) {

        boolean flag;
        flag = false;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "dbprojectdatabase", "root", "");

            String query = "insert into cvrejectionletter (username,jobtitle)" +
                    " values (?,?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, obj.getUsername());
            preparedStmt.setString(2, obj.getJobtitle());

            System.out.println("6");


            // execute the preparedstatement
            preparedStmt.execute();
            con.close();

            System.out.println("7");
        } catch (ClassNotFoundException e) {
            System.out.println("exception class not found");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("sql exception while inserting cv rejection letter");
            e.printStackTrace();
        }

    }

    public smeemailstuff retrieving_sme_email(String jobtitle) {

        smeemailstuff s = new smeemailstuff();

        String email;
        email = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "dbprojectdatabase", "root", "");

            String query = "Select * from users;";


            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);


            while (rs.next()) {

                String usern = rs.getString("typeofuser");
                String specialization = rs.getString("specialization");
                if ((usern.compareTo("sme") == 0) && (specialization.compareTo(jobtitle) == 0)) {
                    s.setSmename(rs.getString("UserName"));
                    s.setSmeemail(rs.getString("email"));
                }
            }
            st.close();
        } catch (ClassNotFoundException e) {
            System.out.println("exception class not found");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("sql exception while retrieving emails of smes");
            e.printStackTrace();
        }
        return s;
    }

    public void removing_job_application_record(String UserName, String jobtitle)
    {
        String message = null;

        try {
            // connects to the database
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "dbprojectdatabase", "root", "");

            // constructs SQL statement
            String sql = "DELETE from applicantapplying where username  = ? and jobtitle = ?";
            PreparedStatement statement = con.prepareStatement(sql);


            statement.setString(1, UserName);
            statement.setString(2, jobtitle);


            // fetches input stream of the upload file for the blob column
            System.out.println("10");

            // sends the statement to the database server
            int row = statement.executeUpdate();
            if (row > 0) {
                message = "File uploaded and saved into database";
                System.out.println("11");
            }
        } catch (SQLException ex) {
            message = "ERROR: " + ex.getMessage();
            ex.printStackTrace();
            System.out.println("Error while uploading picture to dbms");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                // closes the database connection
                try {
                    con.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            System.out.println("12");

        }
    }
    public void storing_job_success_applications(rejectionrecord obj)
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "dbprojectdatabase", "root", "");

            String query = "insert into cvacceptanceletter (username,jobtitle)" +
                    " values (?,?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, obj.getUsername());
            preparedStmt.setString(2, obj.getJobtitle());

            System.out.println("6");


            // execute the preparedstatement
            preparedStmt.execute();
            con.close();

            System.out.println("7");
        } catch (ClassNotFoundException e) {
            System.out.println("exception class not found");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("sql exception while inserting cv acceptance letter");
            e.printStackTrace();
        }


    }
    public void storing_sme_emails(rejectionrecord obj)
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "dbprojectdatabase", "root", "");

            String query = "insert into lettertosme (username,jobtitle)" +
                    " values (?,?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, obj.getUsername());
            preparedStmt.setString(2, obj.getJobtitle());

            System.out.println("6");


            // execute the preparedstatement
            preparedStmt.execute();
            con.close();

            System.out.println("7");
        } catch (ClassNotFoundException e) {
            System.out.println("exception class not found");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("sql exception while inserting letter to sme");
            e.printStackTrace();
        }
    }

    public boolean checking_sme_notification(String username)
    {
        System.out.println("q1");
     boolean flag;
     flag = false;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "dbprojectdatabase", "root", "");
            String query = "Select * from lettertosme";


            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {

                String usern = rs.getString("username");
                System.out.println(usern);
                if ((usern.compareTo(username) == 0)) {
                    flag = true;
                }
            }
            st.close();
        } catch (ClassNotFoundException e) {
            System.out.println("exception class not found");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("sql exception while retrieving emails of smes");
            e.printStackTrace();
        }
        return flag;
    }


    public String retrieving_sme_specialization(String username)
    {
        String specialization;
        specialization = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "dbprojectdatabase", "root", "");

            String query = "Select * from users";


            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {

                String usern = rs.getString("UserName");
                if ((usern.compareTo(username) == 0)) {
                    specialization = rs.getString("specialization");
                }
            }
            st.close();
        } catch (ClassNotFoundException e) {
            System.out.println("exception class not found");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("sql exception while retrieving emails of smes");
            e.printStackTrace();
        }
        return specialization;
    }


    public void deleting_sme_email(String smeusername)
    {
        String message = null;

        try {
            // connects to the database
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "dbprojectdatabase", "root", "");

            // constructs SQL statement
            String sql = "DELETE from lettertosme where username  = ?";
            PreparedStatement statement = con.prepareStatement(sql);


            statement.setString(1, smeusername);



            // fetches input stream of the upload file for the blob column
            System.out.println("10");

            // sends the statement to the database server
            int row = statement.executeUpdate();
            if (row > 0) {
                message = "File uploaded and saved into database";
                System.out.println("11");
            }
        } catch (SQLException ex) {
            message = "ERROR: " + ex.getMessage();
            ex.printStackTrace();
            System.out.println("Error while deleting the sme email");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                // closes the database connection
                try {
                    con.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public void saving_interview_date_and_time(String time,String smename,String spec)
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "dbprojectdatabase", "root", "");

            String query = "insert into replyfromsme (timeanddate,smename,specialization)" +
                    " values (?,?,?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = con.prepareStatement(query);
            java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
            preparedStmt.setTimestamp(1, date);
            preparedStmt.setString(2, smename);
            preparedStmt.setString(3,spec);


            System.out.println("6");


            // execute the preparedstatement
            preparedStmt.execute();
            con.close();

            System.out.println("7");
        } catch (ClassNotFoundException e) {
            System.out.println("exception class not found");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("sql exception while inserting letter to sme");
            e.printStackTrace();
        }
    }

    public ArrayList<smereplies> retrieving_sme_replies()
    {
        ArrayList<smereplies> arr = new ArrayList<smereplies>();
        String specialization;
        specialization = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "dbprojectdatabase", "root", "");

            String query = "Select * from replyfromsme";


            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {

                String date = rs.getString("timeanddate");
                String name = rs.getString("smename");
                String spec = rs.getString("specialization");
                smereplies s = new smereplies();
                s.setSmename(name);
                s.setDate(date);
                s.setSpecialization(spec);
                arr.add(s);
            }
            st.close();
        } catch (ClassNotFoundException e) {
            System.out.println("exception class not found");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("sql exception while retrieving emails of smes");
            e.printStackTrace();
        }
        return arr;
    }
    public void deleting_sme_replies(smereplies obj)
    {

        String message = null;

        try {
            // connects to the database
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "dbprojectdatabase", "root", "");

            // constructs SQL statement
            String sql = "DELETE from replyfromsme where smename  = ? and specialization = ?";
            PreparedStatement statement = con.prepareStatement(sql);


            statement.setString(1, obj.getSmename());
            statement.setString(2,obj.getSpecialization());



            // fetches input stream of the upload file for the blob column
            System.out.println("10");

            // sends the statement to the database server
            int row = statement.executeUpdate();
            if (row > 0) {
                message = "File uploaded and saved into database";
                System.out.println("11");
            }
        } catch (SQLException ex) {
            message = "ERROR: " + ex.getMessage();
            ex.printStackTrace();
            System.out.println("Error while deleting the sme email");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                // closes the database connection
                try {
                    con.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public ArrayList<String> retrieving_users_with_specified_job(String jobtitle)
    {
        ArrayList<String> arr = new ArrayList<String>();

        String specialization;
        specialization = "";
        String title;
        title = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "dbprojectdatabase", "root", "");

            String query = "Select * from cvacceptanceletter";



            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            System.out.println("5");

            while (rs.next()) {
                System.out.println("6");

                 title = rs.getString("jobtitle");

                if(title.compareTo(jobtitle)==0)
                {
                    System.out.println("7");
                    arr.add(rs.getString("username"));
                }

            }
            st.close();
        } catch (ClassNotFoundException e) {
            System.out.println("exception class not found");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("sql exception while retrieving emails of smes");
            e.printStackTrace();
        }
        return arr;
    }
    public HashMap getUsers(String username) {
        boolean flag;
        HashMap hashMap=new HashMap();
        flag = false;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "dbprojectdatabase", "root", "");

            //String query = "Select * from users" + " where UserName = '" +username;
            String query = "SELECT * FROM users WHERE UserName='"+username+"'";

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);




            while (rs.next()) {
                hashMap.put("id",rs.getString("ID"));
                hashMap.put("name",rs.getString("Name"));
                hashMap.put("uname",rs.getString("UserName"));
                hashMap.put("secondName",rs.getString("SecondName"));
                hashMap.put("CNIC",rs.getString("CNIC"));
                hashMap.put("phone",rs.getString("CellNo"));
                hashMap.put("city",rs.getString("city"));
                hashMap.put("email",rs.getString("email"));
                hashMap.put("addr",rs.getString("applicantaddress"));
            }

            st.close();
        } catch (ClassNotFoundException e) {
            System.out.println("exception class not found");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("sql exception");
            flag = false;
            e.printStackTrace();
        }
        return hashMap;
    }
}



        /*try{
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/"+"dbprojectdatabase","root","");
            st=con.createStatement();
            rs=st.executeQuery("select * from applicants");
            while(rs.next())
            {
                results +=("ID: "+rs.getInt(1));
                results +=("Name: "+rs.getString(2));
            }
            //System.out.println("result: "+results);
        } catch (ClassNotFoundException e) {
            System.out.println("exception class not found");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("sql exception");
            e.printStackTrace();
        }*/

