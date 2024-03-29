package br.ufjf.dcc193.trbo;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioAtendimento extends JpaRepository<Atendimento, Long> {
    
    @Query("SELECT a FROM Atendimento a WHERE a.categoria =:categoria and a.status !='fechado'")
    List<Atendimento> getAtendimentoByStatusCategoria(@Param("categoria") Categoria idCategoria);
    
    @Query("SELECT a FROM Atendimento a WHERE a.atendente =:atendente and a.status !='fechado'")
    List<Atendimento> getAtendimentoByAtemdemteAndStatus(@Param("atendente") Atendente iAtendente);
 

    @Query("SELECT a FROM Atendimento a WHERE a.usuario =:usuario")
    List<Atendimento> getAtendimentoByUsuario(@Param("usuario") Usuario idusuario);
    
}