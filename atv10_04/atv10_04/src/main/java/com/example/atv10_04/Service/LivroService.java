package com.example.atv10_04.Service;

import com.example.atv10_04.DTO.LivroDTO;
import com.example.atv10_04.Entity.Livro;
import com.example.atv10_04.Repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService{
    @Autowired
    private LivroRepository livroRepository;

    public List<Livro> getAll(){
        return livroRepository.findAll();
    }

    public Optional<LivroDTO> getById(Long id){
        Optional<Livro> optionalLivro = livroRepository.findById(id);
        LivroDTO livroDTO = new LivroDTO();
        if(optionalLivro.isPresent()){
            return Optional.of(livroDTO.fromLivro(optionalLivro.get()));
        }else {
            return Optional.empty();
        }
    }

    public LivroDTO create (LivroDTO livroDTO){
        Livro livro = livroDTO.toLivro();
        livro = livroRepository.save(livro);
        return livroDTO.fromLivro(livro);
    }

    public Optional<LivroDTO> updateLivro(Long id, LivroDTO livroDTO){
        Optional<Livro> optionalLivro = livroRepository.findById(id);
        if(optionalLivro.isPresent()){
            Livro livro = optionalLivro.get();
            livro.setNome(livroDTO.getNome());
            livro.setAutor(livroDTO.getAutor());
            livro.setISBN(livroDTO.getISBN());
            livro.setEmprestimos(livroDTO.toLivro().getEmprestimos());

            Livro livroUpdate = livroRepository.save(livro);

            return Optional.of(livroDTO.fromLivro(livroUpdate));
        }else {
            return Optional.empty();
        }
    }

    public boolean delete(Long id){
        if(livroRepository.existsById(id)){
            livroRepository.deleteById(id);
            return true;
        }else {
            return false;
        }
    }
}
