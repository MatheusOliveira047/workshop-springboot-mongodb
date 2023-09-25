package com.mattcode.workshop.dto;

import com.mattcode.workshop.domain.User;

import java.io.Serial;
import java.io.Serializable;

public class AuthorDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String id;
    private String name;

    public AuthorDTO(){

    }

    public AuthorDTO(User obj){
        id = obj.getId();
        name = obj.getName();
    }

    public String getId() {
        return id;
    }

    public AuthorDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public AuthorDTO setName(String name) {
        this.name = name;
        return this;
    }
}
