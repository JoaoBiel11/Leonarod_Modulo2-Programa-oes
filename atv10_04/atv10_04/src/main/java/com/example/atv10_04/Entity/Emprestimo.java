package com.example.atv10_04.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmprestimo;
    private LocalDate data_inicial;
    private LocalDate data_final;


    @OneToOne
    @JoinColumn(name = "idCliente", referencedColumnName = "idCliente")
    private Cliente cliente;

    @OneToMany(mappedBy = "emprestimo", cascade = CascadeType.ALL)
    private List<Livro> livros;

    public Emprestimo() {
    }

    public Emprestimo(Long idEmprestimo, LocalDate data_inicial, LocalDate data_final, Cliente cliente, List<Livro> livros) {
        this.idEmprestimo = idEmprestimo;
        this.data_inicial = data_inicial;
        this.data_final = data_final;
        this.cliente = cliente;
        this.livros = livros;
    }

    public Emprestimo(LocalDate data_inicial, LocalDate data_final, Cliente cliente, List<Livro> livros) {
        this.data_inicial = data_inicial;
        this.data_final = data_final;
        this.cliente = cliente;
        this.livros = livros;
    }
}
