package com.example.atv10_04.Controller;

import com.example.atv10_04.DTO.EmprestimoDTORequest;
import com.example.atv10_04.DTO.EmprestimoDTOResponse;
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
        public ResponseEntity<List<Emprestimo>> getAll(){
            return ResponseEntity.status(HttpStatus.OK).body(emprestimoService.getAll());
        }

        @GetMapping("/{id}")
        public ResponseEntity<EmprestimoDTOResponse> getById(@PathVariable Long id){
            Optional<EmprestimoDTOResponse> emprestimoDTO = emprestimoService.getById(id);
            if (emprestimoDTO.isPresent()) {
                return ResponseEntity.ok(emprestimoDTO.get());
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }

        }

        @PostMapping
        public ResponseEntity<EmprestimoDTOResponse> created(@RequestBody EmprestimoDTORequest emprestimoDtoRequest){
            EmprestimoDTOResponse emprestimo = emprestimoService.saveDto(emprestimoDtoRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body(emprestimo);
        }

        @PutMapping("/{id}")
        public ResponseEntity<EmprestimoDTOResponse> update(@PathVariable Long id, @RequestBody EmprestimoDTORequest cursoDTORequest){
            Optional<EmprestimoDTOResponse> cursoDTOResponseOp = emprestimoService.updateEmprestimo(id, cursoDTORequest);
            if (cursoDTOResponseOp.isPresent()){
                return ResponseEntity.ok(cursoDTOResponseOp.get());
            }else {
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

