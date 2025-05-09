package com.example.atv10_04.Controller;

import com.example.atv10_04.DTO.EmprestimoDTO;
import com.example.atv10_04.Entity.Emprestimo;
import com.example.atv10_04.Service.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/emprestimo")

public class EmprestimoController {

    @Autowired
    private EmprestimoService emprestimoService;

    @GetMapping
    public List<Emprestimo> getAll(){
        return emprestimoService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmprestimoDTO> getById(@PathVariable Long id){
        Optional<EmprestimoDTO> emprestimoDTOOptional = emprestimoService.getById(id);
        if(emprestimoDTOOptional.isPresent()){
            return ResponseEntity.ok(emprestimoDTOOptional.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<EmprestimoDTO> create(@RequestBody EmprestimoDTO emprestimoDTO){
        EmprestimoDTO clienteDTOSave = emprestimoService.create(emprestimoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteDTOSave);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmprestimoDTO> updateEmprestimo(@PathVariable Long id, @RequestBody EmprestimoDTO emprestimoDTO){
        Optional<EmprestimoDTO> emprestimoDTOOptional = emprestimoService.updateEmprestimo(id, emprestimoDTO);
        if(emprestimoDTOOptional.isPresent()){
            return ResponseEntity.ok(emprestimoDTOOptional.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        if(emprestimoService.delete(id)){
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}