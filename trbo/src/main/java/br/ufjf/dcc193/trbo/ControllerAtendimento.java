package br.ufjf.dcc193.trbo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ControllerAtendimento {

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

    @RequestMapping("/atendimento")
    public String gestaoAtendimento(Model model){
        model.addAttribute("atendimentos", repositorioAtendimento.findAll());
        return "atendimento/gestao";
    }

    @RequestMapping("/atendimento/novo")
    public String novoAtendimento(Model model){
        model.addAttribute("atendimento", new Atendimento());
        model.addAttribute("atendentes", repositorioAtendente.findAll());
        model.addAttribute("categorias", repositorioCategoria.findAll());
        model.addAttribute("usuarios", repositorioUsuario.findAll());
        return "atendimento/novo";
    }
    
    @RequestMapping("/atendimento/fechar/{id}")
    public String fecharAtendimento(@PathVariable Long id, Model model){
        repositorioAtendimento.deleteById(id);
        return "redirect:/atendimento";
    }

    @RequestMapping("/atendimento/alterar/{id}")
    public String alterarAtendimento(@PathVariable Long id, Model model){
        model.addAttribute("atendimento", repositorioAtendimento.findById(id).get());
        model.addAttribute("atendentes", repositorioAtendente.findAll());
        model.addAttribute("categorias", repositorioCategoria.findAll());
        model.addAttribute("usuarios", repositorioUsuario.findAll());
        return "atendimento/alterar";
    }
    
    @RequestMapping("/atendimento/alterar/salvar")
    public String alterarSalvarAtendimento(Atendimento atendimento){
        repositorioAtendimento.save(atendimento);
        return "redirect:/atendimento";
    }

    @RequestMapping("/atendimento/salvar")
    public String salvarTrabalho(Atendimento atendimento){

        atendimento.setStatus("revisao");
        atendimento.setDataCriacao(new Date());

        repositorioAtendimento.save(atendimento);

        Evento eventoAbertura = new Evento(atendimento, atendimento.getDataCriacao(), "abertura", "descricao");
        repositorioEvento.save(eventoAbertura);


        return "redirect:/atendimento";
    }

    @RequestMapping("/atendimentoNaoFechados")
    public String listanaoFechados(Model model){

        List<Atendimento> listAten= repositorioAtendimento.findAll();
        List<Atendimento> listAtenFechado= new ArrayList<>();
        for(int i=0;i<=listAten.size();i++){
            if(listAten.get(i).getStatus()=="fechado"){
                listAtenFechado.add(listAten.get(i));
            }
        }

        model.addAttribute("atendimentos", listAtenFechado);
        return "atendimento/listNaoFechados";
    }

}