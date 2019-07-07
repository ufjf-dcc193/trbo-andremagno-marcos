package br.ufjf.dcc193.trbo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
public class ControllerUsuario {

    @Autowired
    RepositorioUsuario repositorioUsuario;

}