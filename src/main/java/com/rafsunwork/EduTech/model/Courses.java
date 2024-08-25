package com.rafsunwork.EduTech.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "courses")
public class Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    @Column(name="thumbnail")
    private String thumbnail;

    @Column(name="price")
    private Number price;

    @Column(name="hours")
    private String hours;

    @Column(name="category_id")
    private Long category_id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_Course_Id", referencedColumnName = "id")
    private List<Books> referenceBook;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
    public Number getPrice() {
        return price;
    }

    public void setPrice(Number price) {
        this.price = price;
    }

    public String getHours(){
        return hours;
    }
    public void setHours(String hours){
        this.hours = hours;
    }

    public  Long getCategory_id(){
        return  category_id;
    }
    public void setCategory_id(Long category_id){
        this.category_id = category_id;
    }

    public List<Books> getReferenceBook(){
        return referenceBook;
    }
    public void setReferenceBook(List<Books> books){
        this.referenceBook = books;
    }
}
