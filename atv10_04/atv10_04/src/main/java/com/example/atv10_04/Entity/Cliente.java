package com.example.atv10_04.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    @OneToOne(mappedBy = "emprestimo", cascade = CascadeType.ALL)
    Emprestimo emprestimo;

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idCliente;

    private String nome;
    private String sobrenome;

    @Column(nullable = false, unique = true)
    private String cpf;
}
