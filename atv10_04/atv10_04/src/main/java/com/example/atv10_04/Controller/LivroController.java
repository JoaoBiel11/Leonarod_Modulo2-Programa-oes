package com.example.atv10_04.Controller;

import com.example.atv10_04.DTO.LivroDTO;
import com.example.atv10_04.Entity.Livro;
import com.example.atv10_04.Service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping
    public ResponseEntity<List<Livro>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(livroService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroDTO> getById(@PathVariable Long id){
        Optional<LivroDTO> livroDTO = livroService.getById(id);
        if(livroDTO.isPresent()){
            return ResponseEntity.ok(livroDTO.get());
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<LivroDTO> created(@RequestBody LivroDTO livroDto){
        LivroDTO aluno = livroService.saveDto(livroDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(aluno);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        if(livroService.delete(id)){
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<LivroDTO> update(@PathVariable Long id, @RequestBody LivroDTO livroDTO){
        Optional<LivroDTO> livroDTOOptional = livroService.updateLivro(id, livroDTO);
        if (livroDTOOptional.isPresent()){
            return ResponseEntity.ok(livroDTOOptional.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}

