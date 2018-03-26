package Model;

/**
 * Created by jamsh on 3/27/2017.
 */
public class smeemails {
    private boolean flag;
    private String jobtitle;

    public smeemails(boolean flag, String jobtitle) {
        this.flag = flag;
        this.jobtitle = jobtitle;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getJobtitle() {
        return jobtitle;
    }

    public void setJobtitle(String jobtitle) {
        this.jobtitle = jobtitle;
    }

    public smeemails(smeemails rightobj)
    {
     this.flag = rightobj.flag;
     this.jobtitle = rightobj.jobtitle;
    }
}
