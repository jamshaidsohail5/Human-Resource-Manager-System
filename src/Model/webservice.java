	package Model;

    import Database.DatabaseWork;

    import javax.jws.WebMethod;
    import javax.jws.WebService;
    import java.util.ArrayList;
    import java.util.HashMap;

    @WebService
public class webservice {
    @WebMethod
    public  String getUserDetails(String username) {

        StringBuffer sb = new StringBuffer();
        DatabaseWork db = new DatabaseWork();
        HashMap composers = db.getUsers(username);
        int id1 = 1;
        sb.append("<candidate>");
        sb.append("<id>" + composers.get("id") + "</id>");
        sb.append("<name>" + composers.get("name") + " " + composers.get("secondName") + "</name>");
        sb.append("<email>" + composers.get("email") + "</email>");
        sb.append("<CNIC>" + composers.get("CNIC") + "</CNIC>");
        sb.append("<phone>" + composers.get("phone") + "</phone>");
        sb.append("<addr>" + composers.get("addr") + "</addr>");
        sb.append("<city>" + composers.get("city") + "</city>");
        sb.append("</candidate>");
        id1++;
        sb.append("<jobs>");

        ArrayList<jobapplicationdata> arrayList=db.retrieving_jobs_application();
        for (int i=0;i<arrayList.size();i++){
            if (arrayList.get(i).getUsername().equals( composers.get("uname"))){
                sb.append("<jobName>");
                sb.append("<name>" + arrayList.get(i).getJobtitle() + "</name>");
                sb.append("<jobName>");
            }
        }
        sb.append("</jobs>");
        return sb.toString();

    }
}

