package steps.utils.webservice;

import java.util.Objects;

public class Users {

    public int id;
    public String username;
    public String realname;
    public String password;
    public String email;


    public Users(int id, String username, String realname, String password, String email) {
        this.id = id;
        this.username = username;
        this.realname = realname;
        this.password = password;
        this.email = email;
    }

    public Users() {
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getRealname() {
        return realname;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
