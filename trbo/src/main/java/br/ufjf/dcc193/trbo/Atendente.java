package br.ufjf.dcc193.trbo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Atendente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nomeCompleto;
    private String codigoAcesso;
    private String telefone;
    private String celular;
    private String email;

    public Atendente() {

    }

    public Atendente(String nomeCompleto, String codigoAcesso, String telefone, String celular, String email) {
        this.nomeCompleto = nomeCompleto;
        this.codigoAcesso = codigoAcesso;
        this.telefone = telefone;
        this.celular = celular;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getCodigoAcesso() {
        return codigoAcesso;
    }

    public void setCodigoAcesso(String codigoAcesso) {
        this.codigoAcesso = codigoAcesso;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Atendente [celular=" + celular + ", codigoAcesso=" + codigoAcesso + ", email=" + email + ", id=" + id
                + ", nomeCompleto=" + nomeCompleto + ", telefone=" + telefone + "]";
    }
}