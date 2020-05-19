package esisa.android.wallet.models;

import java.io.Serializable;

public class Authentification implements Serializable {
    private int id;
    private String Login;
    private String Password;

    public Authentification() {
    }

    public Authentification(int id, String login, String password) {
        this.id = id;
        Login = login;
        Password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    @Override
    public String toString() {
        return "Authentification{" +
                "id=" + id +
                ", Login='" + Login + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }
}
