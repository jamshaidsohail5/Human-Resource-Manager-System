package Model;

/**
 * Created by jamsh on 3/24/2017.
 */
public class jobapplicationdata {
    private String Username;
    private String Jobtitle;
    private String cvpath;

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getJobtitle() {
        return Jobtitle;
    }

    public void setJobtitle(String jobtitle) {
        Jobtitle = jobtitle;
    }

    public String getCvpath() {
        return cvpath;
    }

    public void setCvpath(String cvpath) {
        this.cvpath = cvpath;
    }
}
