package esisa.android.wallet.models;

import java.io.Serializable;

public class Client implements Serializable {

    private String fullName;
    private String phoneNUmber;
    private String Email;
    private String Password;
    private String ConfirmedPassword;
    private String imageProfile;

    public Client() {
    }

    public Client(String fullName, String phoneNUmber, String email, String password, String confirmedPassword, String Image) {
        this.fullName = fullName;
        this.phoneNUmber = phoneNUmber;
        this.Email = email;
        this.Password = password;
        this.ConfirmedPassword = confirmedPassword;
        this.imageProfile = Image;
    }

    public String getImageProfile() {
        return imageProfile;
    }

    public void setImageProfile(String imageProfile) {
        this.imageProfile = imageProfile;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNUmber() {
        return phoneNUmber;
    }

    public void setPhoneNUmber(String phoneNUmber) {
        this.phoneNUmber = phoneNUmber;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getConfirmedPassword() {
        return ConfirmedPassword;
    }

    public void setConfirmedPassword(String confirmedPassword) {
        ConfirmedPassword = confirmedPassword;
    }

    @Override
    public String toString() {
        return "Client{" +
                "fullName='" + fullName + '\'' +
                ", phoneNUmber='" + phoneNUmber + '\'' +
                ", Email='" + Email + '\'' +
                ", Password='" + Password + '\'' +
                ", ConfirmedPassword='" + ConfirmedPassword + '\'' +
                ", imageProfile='" + imageProfile + '\'' +
                '}';
    }
}
