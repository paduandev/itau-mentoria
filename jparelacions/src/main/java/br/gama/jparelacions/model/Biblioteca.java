package br.gama.jparelacions.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Getter
@Setter
public class Biblioteca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_endereco")
    @JsonIgnoreProperties("biblioteca")
    private Endereco endereco;
}
