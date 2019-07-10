package br.ufjf.dcc193.trbo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ControllerUsuario {

    @Autowired
    RepositorioUsuario repositorioUsuario;

    @RequestMapping("usuario")
    public String listarUsuario(Model model){
        repositorioUsuario.save(new Usuario("aaaa","","","","",""));
        model.addAttribute("usuarios", repositorioUsuario.findAll());

        return "usuario/listar";
    }

    @RequestMapping("usuario/cadastrar")
    public String cadastrarUsuario(Model model){
        model.addAttribute("usuario", new Usuario());
        return "usuario/cadastrar";
    }
    
    @RequestMapping("usuario/deletar/{id}")
    public String deletarUsuario(@PathVariable Long id, Model model){
        repositorioUsuario.deleteById(id);
        return "redirect:/usuario";
    }

    @RequestMapping("usuario/editar/{id}")
    public String editarUsuario(@PathVariable Long id, Model model){
        model.addAttribute("usuario", repositorioUsuario.findById(id).get());
        return "usuario/editar";
    }

    @RequestMapping("usuario/editar/salvar")
    public String editarSalvarUsuario(Usuario usuario){
        repositorioUsuario.save(usuario);
        return "redirect:/usuario";
    }

    @RequestMapping("usuario/salvar")
    public String salvarTrabalho(Usuario usuario){
        repositorioUsuario.save(usuario);
        return "redirect:/usuario";
    }
}