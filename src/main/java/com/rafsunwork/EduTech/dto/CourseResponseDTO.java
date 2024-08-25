package com.rafsunwork.EduTech.dto;

import java.util.List;

public class CourseResponseDTO {
    private Long id;
    private String title;
    private String description;
    private String thumbnail;
    private Number price;
    private String hours;
    private List<BookRequestDTO> referenceBook;

    //setter getter

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getThumbnail(){
        return thumbnail;
    }

    public void setThumbnail(String thumbnail){
        this.thumbnail = thumbnail;
    }

    public Number getPrice(){
        return price;
    }

    public void setPrice(Number price){
        this.price = price;
    }
    public String getHours(){
        return hours;
    }

    public void setHours(String hours){
        this.hours = hours;
    }

    public List<BookRequestDTO> getReferenceBook(){
        return referenceBook;
    }

    public void setReferenceBook(List<BookRequestDTO> referenceBook){
        this.referenceBook = referenceBook;
    }
}
