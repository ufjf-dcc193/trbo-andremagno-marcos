package br.ufjf.dcc193.trbo;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Atendimento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    
    @OneToOne(fetch = FetchType.EAGER)
    private Categoria categoria;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataFechamento;
    private String descricao;

    @OneToOne(fetch = FetchType.EAGER)
    private Atendente atendente;
    @OneToOne(fetch = FetchType.EAGER)
    private Atendente atendenteInicial;
    @OneToOne(optional = true)
    private Usuario usuario;
    private String status;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "atendimento", cascade = CascadeType.ALL)
    private List<Evento> eventos;

    public Atendimento() {

    }

    public Atendimento(Atendente atendenteInicial, Categoria categoria, Date dataCriacao, Date dataFechamento, String descricao,
            Atendente atendente, Usuario usuario, String status, List<Evento> eventos) {
        this.categoria = categoria;
        this.dataCriacao = dataCriacao;
        this.dataFechamento = dataFechamento;
        this.descricao = descricao;
        this.atendente = atendente;
        this.usuario = usuario;
        this.status = status;
        this.eventos = eventos;
        this.atendenteInicial=atendenteInicial;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

 
   
    
   public void setAtendenteInicial(Atendente atendenteInicial) {
       this.atendenteInicial = atendenteInicial;
   }

   public Atendente getAtendenteInicial() {
       return atendenteInicial;
   }
    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(Date dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Atendente getAtendente() {
        return atendente;
    }

    public void setAtendente(Atendente atendente) {
        this.atendente = atendente;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }

    @Override
    public String toString() {
        return "Atendimento [atendente=" + atendente + ", categoria=" + categoria + ", dataCriacao=" + dataCriacao
                + ", dataFechamento=" + dataFechamento + ", descricao=" + descricao + ", eventos=" + eventos + ", id="
                + id + ", status=" + status + ", usuario=" + usuario + "]";
    }   
}