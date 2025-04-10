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


    public Livro fromDTO(LivroDTO livroDTO){
        Livro livro = new Livro();
        livro.setNome(livroDTO.getNome());
        livro.setAutor(livroDTO.getAutor());
        livro.setISBN(livroDTO.getISBN());
        livro.setGenero(livroDTO.getGenero());


        return livro;
    }

    public LivroDTO toDTO(Livro livro){
        LivroDTO livroDTO = new LivroDTO();
        livroDTO.setIdLivro(livro.getIdLivro());
        livroDTO.setNome(livro.getNome());
        livroDTO.setAutor(livro.getAutor());
        livroDTO.setISBN(livro.getISBN());
        livroDTO.setGenero(livro.getGenero());


        return livroDTO;
    }

    public List<Livro> getAll(){
        return livroRepository.findAll();
    }

    public Optional<LivroDTO> getById(Long id){
        Optional<Livro> optionalLivro = livroRepository.findById(id);
        if(optionalLivro.isPresent()){
            return Optional.of(this.toDTO(optionalLivro.get()));
        }else {
            return Optional.empty();
        }
//        return livroRepository.findById(id).map(this::toDTO);
    }

    public LivroDTO saveDto(LivroDTO livroDTO){
        Livro livro = this.fromDTO(livroDTO);
        Livro livroBd = livroRepository.save(livro);
        return this.toDTO(livroBd);
    }

    public Optional<LivroDTO> updateLivro(Long id, LivroDTO livroDTO){
        Optional<Livro> optionalLivro = livroRepository.findById(id);
        if(optionalLivro.isPresent()){
            Livro livro = optionalLivro.get();
            livro.setNome(livroDTO.getNome());
            livro.setAutor(livroDTO.getAutor());
            livro.setEmprestimo(livroDTO.getEmprestimo());

            Livro livroUpdate = livroRepository.save(livro);

            return Optional.of(this.toDTO(livroUpdate));
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
