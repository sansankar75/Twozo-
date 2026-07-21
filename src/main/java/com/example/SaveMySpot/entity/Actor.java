package com.example.SaveMySpot.entity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "actor")
public class Actor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actor_id")
    private int actorId;

    @Column(name = "actor_name", nullable = false, length = 100)
    private String actorName;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    public int getActorId() {
        return actorId;
    }
    public void setActorId(int actorId) {
        this.actorId = actorId;
    }
    public String getActorName() {
        return actorName;
    }
    public void setActorName(String actorName) {
        this.actorName = actorName;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public Date getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }


        @Override
        public String toString () {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDate = dateOfBirth != null ? sdf.format(dateOfBirth) : "N/A";

            return "Actor{" +
                    "actorId=" + actorId +
                    ", actorName='" + (actorName != null ? actorName : "N/A") + '\'' +
                    ", imageUrl='" + (imageUrl != null ? imageUrl : "N/A") + '\'' +
                    ", dateOfBirth=" + formattedDate +
                    '}';
        }
    }