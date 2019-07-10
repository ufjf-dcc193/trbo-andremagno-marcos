package br.ufjf.dcc193.trbo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ControllerEvento {

    @Autowired
    RepositorioAtendimento repositorioAtendimento;
    @Autowired
    RepositorioCategoria repositorioCategoria;
    @Autowired
    RepositorioAtendente repositorioAtendente;
    @Autowired
    RepositorioUsuario repositorioUsuario;
    @Autowired
    RepositorioEvento repositorioEvento;

    @RequestMapping("/evento")
    public String listarEvento(Model model){
        model.addAttribute("eventos", repositorioEvento.findAll());
        return "evento/listar";
    }

}