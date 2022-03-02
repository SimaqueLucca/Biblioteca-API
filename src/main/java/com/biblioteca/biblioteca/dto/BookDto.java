package com.biblioteca.biblioteca.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BookDto {

    private String name;
    private String author;
    private Date release;
    private String status;
}
