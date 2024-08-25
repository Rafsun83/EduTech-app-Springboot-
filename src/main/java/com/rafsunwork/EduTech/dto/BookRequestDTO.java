package com.rafsunwork.EduTech.dto;

public class BookRequestDTO {
    private String title;

    public BookRequestDTO(String title){
        this.title = title;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }
}
