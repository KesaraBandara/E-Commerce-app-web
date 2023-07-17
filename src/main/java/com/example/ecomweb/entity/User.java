package com.example.ecomweb.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", length = 20)
    private int userId;

    @Column  (name = "fname", length = 20,nullable = false)
    private String fName;

    @Column  (name = "lname", length = 20,nullable = false)
    private String  lName;

    @Column  (name = "email", length = 20,nullable = false)
    private String email;

    @Column  (name = "password", length = 20,nullable = false)
    private String password;

    @Column  (name = "cpassword", length = 20,nullable = false)
    private String cPassword;

    public User() {
    }

    public User(int userId, String fName, String lName, String email, String password, String cPassword) {
        this.userId = userId;
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.password = password;
        this.cPassword = cPassword;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
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

    public String getcPassword() {
        return cPassword;
    }

    public void setcPassword(String cPassword) {
        this.cPassword = cPassword;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", cPassword='" + cPassword + '\'' +
                '}';
    }
}
