package br.ufjf.dcc193.trbo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioEvento extends JpaRepository<Evento, Long> {

    
}