package com.rafsunwork.EduTech.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="books")
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="title")
    private String title;

    @Column(name = "summary")
    private String summary;

    @Column(name = "thumbnail")
    private String thumbnail;

    @Column(name = "totalPage")
    private String total_page;

    @Column(name = "pdfUrl")
    private String pdf_url;

    @Column(name="author")
    private List<String> author;

//    @Column(name = "reference_book_id")
//    private Long ref_book_id;



    //Setter Getter
    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getSummary(){
        return summary;
    }

    public void setSummary(String summary){
        this.summary = summary;
    }

    public String getThumbnail(){
        return thumbnail;
    }

    public void setThumbnail(String thumbnail){
        this.thumbnail = thumbnail;
    }

    public String getTotal_page(){
        return total_page;
    }
    public void setTotal_page(String totalPage){
        this.total_page = totalPage;
    }

    public String getPdf_url(){
        return pdf_url;
    }

    public void  setPdf_url(String pdfUrl){
        this.pdf_url = pdfUrl;
    }

    public List<String> getAuthor(){
        return author;
    }

    public void setAuthor(List<String> author){
        this.author = author;
    }




}
