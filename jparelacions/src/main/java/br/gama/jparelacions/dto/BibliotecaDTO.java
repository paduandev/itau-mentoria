package br.gama.jparelacions.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BibliotecaDTO {
    private long id;
    private String name;

    public BibliotecaDTO(long id, String name) {
        this.id = id;
        this.name = name;
    }

}
