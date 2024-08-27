package com.rafsunwork.EduTech.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Instructors")
public class Instructors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "degree")
    private String degree;

    @Column(name = "position")
    private String position;

    @Column(name = "prevExperience")
    private String previousExperience;

    @Column(name = "email")
    private String email;

    @Column(name = "imageUrl")
    private  String img_url;


    //setter getter
    public  Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getDegree(){
        return degree;
    }
    public void setDegree(String degree){
        this.degree = degree;
    }

    public String getPosition(){
        return position;
    }
    public void setPosition(String position){
        this.position = position;
    }

    public String getPreviousExperience(){
        return previousExperience;
    }
    public void setPreviousExperience(String previousExperience)
    {
        this.previousExperience = previousExperience;
    }

    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    public String getImg_url(){
        return img_url;
    }
    public void setImg_url(String imgUrl){
        this.img_url = imgUrl;
    }
}
