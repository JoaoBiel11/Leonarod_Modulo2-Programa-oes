package com.example.atv10_04.Repository;

import com.example.atv10_04.Entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
