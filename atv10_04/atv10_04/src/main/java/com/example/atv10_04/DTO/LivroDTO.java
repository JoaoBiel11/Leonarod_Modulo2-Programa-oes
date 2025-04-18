package com.example.atv10_04.DTO;

import com.example.atv10_04.Entity.Livro;
import jakarta.persistence.Column;
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
    @Column(unique = true)
    private String ISBN;
    private String genero;

    public Livro toLivro(){
        return new Livro(
                this.idLivro,
                this.nome,
                this.autor,
                this.ISBN,
                this.genero
        );
    }

    public LivroDTO fromLivro(Livro livro){
        return new LivroDTO(
                livro.getId(),
                livro.getNome(),
                livro.getAutor(),
                livro.getISBN(),
                livro.getGenero()
        );
    }

}
