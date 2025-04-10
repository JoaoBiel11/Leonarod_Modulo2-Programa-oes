package com.example.atv10_04.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLivro;
    private String nome;
    private String autor;

    @Column(nullable = false, unique = true)
    private String ISBN;
    private String genero;

    @ManyToOne
    @JoinColumn(name = "idEmprestimo", referencedColumnName = "idEmprestimo")
    @JsonIgnoreProperties("livros")
    private Emprestimo emprestimo;

}