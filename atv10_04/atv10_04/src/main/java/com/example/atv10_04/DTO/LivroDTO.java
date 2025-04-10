package com.example.atv10_04.DTO;

import com.example.atv10_04.Entity.Emprestimo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LivroDTO {

    private Long idLivro;
    private String nome;
    private String autor;
    private String ISBN;
    private String genero;
    private Emprestimo emprestimo;


}
