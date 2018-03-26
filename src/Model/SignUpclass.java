package Model;

import Database.DatabaseWork;

import java.sql.*;

/**
 * Created by jamsh on 3/17/2017.
 */
public class SignUpclass {

   private int id;
   private String name;
   private String SecondName;
   private String Username;
   private String password;
   private String Cnic;
   private String cellno;
   private String profilePic;
   private String coverPhoto;
   private String PostalCode;
   private String city;
   private String applicantAdress;
    private String Specialization;
    private DatabaseWork db;


    public void setSpecialization(String specialization) {
        Specialization = specialization;
    }

    public void setDb(DatabaseWork db) {
        this.db = db;
    }

    private String email;

    public String getSpecialization() {
        return Specialization;
    }

    public DatabaseWork getDb() {
        return db;
    }


   public boolean check_user()
   {
       db = new DatabaseWork();
       System.out.println("3");
    boolean flag = db.connecting_to_db_and_verify(this);
       System.out.println("8");
    return flag;
   }

   public  boolean checkUserName(String Data)
   {
       return  db.validate_username(Data);
   }






    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSecondName(String secondName) {
        SecondName = secondName;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCnic(String cnic) {
        Cnic = cnic;
    }

    public void setCellno(String cellno) {
        this.cellno = cellno;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public void setCoverPhoto(String coverPhoto) {
        this.coverPhoto = coverPhoto;
    }

    public void setPostalCode(String postalCode) {
        PostalCode = postalCode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setApplicantAdress(String applicantAdress) {
        this.applicantAdress = applicantAdress;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {

        return id;
    }

    public String getName() {
        return name;
    }

    public String getSecondName() {
        return SecondName;
    }

    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return password;
    }

    public String getCnic() {
        return Cnic;
    }

    public String getCellno() {
        return cellno;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public String getCoverPhoto() {
        return coverPhoto;
    }

    public String getPostalCode() {
        return PostalCode;
    }

    public String getCity() {
        return city;
    }

    public String getApplicantAdress() {
        return applicantAdress;
    }

    public String getEmail() {
        return email;
    }
}
