package com.devsuperior.workshopmongo.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Document(collection = "user")
@Builder
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private String name;
    private String email;

    public User(String id, String name, String email){
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
