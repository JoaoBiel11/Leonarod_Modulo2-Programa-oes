package com.example.atv10_04.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Livro implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String autor;
    private String ISBN;
    @Column(unique = true)
    private String genero;

    @ManyToMany(mappedBy = "livros")
    private Set<Emprestimo> emprestimos;

    public Livro(Long id, String nome, String autor, String  ISBN, String genero){
        this.id = id;
        this.nome = nome;
        this.autor = autor;
        this.ISBN = ISBN;
        this.genero = genero;
    }
}