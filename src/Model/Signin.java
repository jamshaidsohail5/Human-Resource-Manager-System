package Model;

import Database.DatabaseWork;

/**
 * Created by jamsh on 3/17/2017.
 */
public class Signin {

    private String username;
    private String password;
    private DatabaseWork db;


    public boolean verify_user()
    {
        db = new DatabaseWork();
        boolean flag = db.validate_login(this);
        return flag;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {

        return username;
    }

    public String getPassword() {
        return password;
    }



}
