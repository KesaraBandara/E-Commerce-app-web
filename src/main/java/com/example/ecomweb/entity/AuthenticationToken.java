package com.example.ecomweb.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "tokens")
public class AuthenticationToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column  (name = "token", length = 70,nullable = false)
    private String token;

    @Column(name = "created_date")
    private Date createdDate;

    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private User user;

    public AuthenticationToken(User user) {
        this.user = user;
        this.createdDate = new Date();
        this.token = UUID.randomUUID().toString();
    }


    public AuthenticationToken() {

    }

    public AuthenticationToken(Integer id, String token, Date createdDate, User user) {
        this.id = id;
        this.token = token;
        this.createdDate = createdDate;
        this.user = user;
    }




    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public User getConsultant() {
        return user;
    }

    public void setConsultant(User consultant) {
        this.user = consultant;
    }

    @Override
    public String toString() {
        return "AuthenticationToken{" +
                "id=" + id +
                ", token='" + token + '\'' +
                ", createdDate=" + createdDate +
                ", user=" + user +
                '}';
    }
    public User getUser() {
        return user;
    }
}