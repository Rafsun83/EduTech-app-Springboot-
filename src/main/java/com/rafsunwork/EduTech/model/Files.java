package com.rafsunwork.EduTech.model;

import jakarta.persistence.*;
import lombok.Builder;



@SuppressWarnings("all")
@Entity
@Table(name = "files")
@Builder
public class Files {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fileName")
    private String name;

    @Column(name = "fileType")
    private String type;

    @Lob
    @Column(name = "fileData", columnDefinition = "LONGBLOB")
    private byte[] fileData;

    //Setter getter

    public Long getId(){
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

    public String getType(){
        return type;
    }
    public void setType(String type){
        this.type = type;
    }

    public byte[] getPath(){
        return fileData;
    }
    public void setPath(byte[] fileData){
        this.fileData = fileData;
    }
}
