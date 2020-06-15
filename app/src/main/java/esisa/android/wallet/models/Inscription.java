package esisa.android.wallet.models;

public class Inscription {
    private int id;
    private String fullname;
    private String number;
    private String email;
    private String password;
    private String cpassword;

    public Inscription() {
    }

    public Inscription(int id,String fullname, String number, String email, String password, String cpassword) {
        this.id=id;
        this.fullname = fullname;
        this.number = number;
        this.email = email;
        this.password = password;
        this.cpassword = cpassword;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCpassword() {
        return cpassword;
    }

    public void setCpassword(String cpassword) {
        this.cpassword = cpassword;
    }

    @Override
    public String toString() {
        return "Inscription{" +
                "id=" + id +
                ", fullname='" + fullname + '\'' +
                ", number='" + number + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", cpassword='" + cpassword + '\'' +
                '}';
    }
}
