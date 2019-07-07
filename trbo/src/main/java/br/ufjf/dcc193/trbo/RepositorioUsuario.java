package br.ufjf.dcc193.trbo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioUsuario extends JpaRepository<Usuario, Long> {

    
}