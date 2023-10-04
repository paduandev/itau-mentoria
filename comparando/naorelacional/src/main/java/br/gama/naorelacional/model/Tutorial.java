package br.gama.naorelacional.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "tutoriais")
public class Tutorial {
    
    @Id
    private String id;
    private String title;
    private String description;
    private boolean published;


}
