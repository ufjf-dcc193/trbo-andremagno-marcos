package br.ufjf.dcc193.trbo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioEvento extends JpaRepository<Evento, Long> {


    @Query("SELECT a FROM Evento a WHERE a.atendimento =:atendimento")
    List<Evento> getEventosByAtendimento(@Param("atendimento") Atendimento idAtendimento);
 
    
}