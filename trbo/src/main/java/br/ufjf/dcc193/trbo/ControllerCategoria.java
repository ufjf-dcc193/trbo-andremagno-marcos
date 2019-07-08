package br.ufjf.dcc193.trbo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ControllerCategoria {

    @Autowired
    RepositorioCategoria repositorioCategoria;

    @RequestMapping("categoria")
    public String listarCategoria(Model model){
        model.addAttribute("categorias", repositorioCategoria.findAll());
        return "categoria/listar";
    }

    @RequestMapping("categoria/cadastrar")
    public String cadastrarCategoria(Model model){
        model.addAttribute("categoria", new Categoria());
        return "categoria/cadastrar";
    }
    
    @RequestMapping("categoria/deletar/{id}")
    public String deletarCategoria(@PathVariable Long id, Model model){
        repositorioCategoria.deleteById(id);
        return "redirect:/categoria";
    }

    @RequestMapping("categoria/editar/{id}")
    public String editarCategoria(@PathVariable Long id, Model model){
        model.addAttribute("categoria", repositorioCategoria.findById(id).get());
        return "categoria/editar";
    }

    @RequestMapping("categoria/editar/salvar")
    public String editarSalvarCategoria(Categoria categoria){
        repositorioCategoria.save(categoria);
        return "redirect:/categoria";
    }

    @RequestMapping("categoria/salvar")
    public String salvarTrabalho(Categoria categoria){
        repositorioCategoria.save(categoria);
        return "redirect:/categoria";
    }
}