package sample;

import java.io.Serializable;

public class Admin implements Serializable {
    private int id;
    private String login;
    private String pass;
    private String name;
    private String surname;
    private String group;
   // private int hash = pass.hashCode();
    private static final long serialVersionUID=1L;


    public Admin(int id, String login, String pass, String name, String surname, String group) {
        this.id = id;
        this.login = login;
        this.pass = pass;
        this.name = name;
        this.surname = surname;
        this.group = group;
    }


    public Admin(String login, String pass, String name, String surname, String group) {
        this.login = login;
        this.pass = pass;
        this.name = name;
        this.surname = surname;
        this.group = group;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }


}
