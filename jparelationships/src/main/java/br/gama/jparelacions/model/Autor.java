package br.gama.jparelacions.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;

    @ManyToMany
    @JoinTable(name = "livro_autor",
    joinColumns = 
    @JoinColumn(name="id_autor", referencedColumnName = "id"),
    inverseJoinColumns = 
    @JoinColumn(name="id_livro", referencedColumnName = "id"))
    @JsonIgnoreProperties("autores")
    private List<Livro> livros;
}
