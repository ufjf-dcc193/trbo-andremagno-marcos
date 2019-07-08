package br.ufjf.dcc193.trbo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ControllerAtendente {

    @Autowired
    RepositorioAtendente repositorioAtendente;

    @RequestMapping("atendente")
    public String listarAtendente(Model model){
        model.addAttribute("atendentes", repositorioAtendente.findAll());
        return "atendente/listar";
    }

    @RequestMapping("atendente/cadastrar")
    public String cadastrarAtendente(Model model){
        model.addAttribute("atendente", new Atendente());
        return "atendente/cadastrar";
    }
    
    @RequestMapping("atendente/deletar/{id}")
    public String deletarAtendente(@PathVariable Long id, Model model){
        repositorioAtendente.deleteById(id);
        return "redirect:/atendente";
    }

    @RequestMapping("atendente/editar/{id}")
    public String editarAtendente(@PathVariable Long id, Model model){
        model.addAttribute("atendente", repositorioAtendente.findById(id).get());
        return "atendente/editar";
    }

    @RequestMapping("atendente/editar/salvar")
    public String editarSalvarAtendente(Atendente atendente){
        repositorioAtendente.save(atendente);
        return "redirect:/atendente";
    }

    @RequestMapping("atendente/salvar")
    public String salvarTrabalho(Atendente atendente){
        repositorioAtendente.save(atendente);
        return "redirect:/atendente";
    }
}