package br.gama.kafkaproducer.model;

import java.io.Serializable;

import lombok.Getter;

@Getter
public class User implements Serializable {
    private int id;
    private String name;
}
