package com.biblioteca.biblioteca.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Date;

@Getter
@Setter
@Document(collection = "TB_BOOKS")
public class BookModel {

    @MongoId(value = FieldType.OBJECT_ID)
    private String id;

    private String name;
    private String author;
    private Date release;
    private String status;

}
