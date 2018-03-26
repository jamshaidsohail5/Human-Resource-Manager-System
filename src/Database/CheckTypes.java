package Database;

import java.sql.*;

public class CheckTypes {


    private static Connection con;
    private static Statement st;
    static ResultSet rs;

    public String return_type(String username)
    {

        String result = null;
        String userName = null;
        boolean flag;
        flag = false;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "dbprojectdatabase", "root", "");

            System.out.println("b");
            //String query = "Select typeofuser from users" + " where UserName = " + username+ ";";
            String query = "select * from users";

            System.out.println("c");

            Statement st = con.createStatement();
            System.out.println("d");

            ResultSet rs = st.executeQuery(query);
            System.out.println("e");

            while (rs.next())
            {
                System.out.println("f");

                userName = rs.getString("UserName");
                if(userName.compareTo(username) ==0)
                {
                    System.out.println("f1");

                    result = rs.getString("typeofuser");

                }

            }
            st.close();
        }
        catch (ClassNotFoundException e) {
            System.out.println("exception class not found");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("sql exception while retrieving type of username");
            e.printStackTrace();
        }
        
        return result;
    }

}
