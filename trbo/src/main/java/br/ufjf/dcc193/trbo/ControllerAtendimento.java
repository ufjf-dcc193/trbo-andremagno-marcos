package br.ufjf.dcc193.trbo;

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
        /*repositorioAtendente.save(new Atendente("Marcos","asdfa","","","asdf@adsf"));

		repositorioUsuario.save(new Usuario("Andre","","","","",""));
		
		repositorioCategoria.save(new Categoria("TTTTTTTtt",""));*/
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

    @RequestMapping("/atendimento/detalhes/{id}")
    public String detalhesAtendimento(@PathVariable Long id, Model model){
        model.addAttribute("atendimento", repositorioAtendimento.findById(id).get());
        model.addAttribute("eventos", repositorioEvento.getEventosByAtendimento(repositorioAtendimento.findById(id).get()));
        return "atendimento/detalhes";
    }
    
    @RequestMapping("/atendimento/alterar/salvar")
    public String alterarSalvarAtendimento(Atendimento atendimento){

        
        
        if(atendimento.getStatus().equals("fechado")){
            atendimento.setDataFechamento(new Date());
        }
        atendimento.setDataCriacao(repositorioAtendimento.findById(atendimento.getId()).get().getDataCriacao());
        repositorioAtendimento.save(atendimento);
        

        Evento eventoAlteracao = new Evento(atendimento, atendimento.getDataCriacao(), "alteracao", atendimento.getDescricao());
        
        
        repositorioEvento.save(eventoAlteracao);

        return "redirect:/atendimento";
    }

    @RequestMapping("/atendimento/salvar")
    public String salvarTrabalho(Atendimento atendimento){

        atendimento.setStatus("revisao");
        atendimento.setDataCriacao(new Date());

        repositorioAtendimento.save(atendimento);

        Evento eventoAbertura = new Evento(atendimento, atendimento.getDataCriacao(), "abertura", atendimento.getDescricao());
        
        
        
        repositorioEvento.save(eventoAbertura);


        return "redirect:/atendimento";
    }

    @RequestMapping("/atendimentoNaoFechadosPorCategoria/{id}")
    public String listanaoFechadosPorCategoria(@PathVariable Long id, Model model){
        List<Atendimento> listAten= repositorioAtendimento.getAtendimentoByStatusCategoria(repositorioCategoria.findById(id).get());
        model.addAttribute("atendimentos", listAten);
        model.addAttribute("categoria", repositorioCategoria.findById(id).get());
        return "atendimento/listNaoFechadosCategoria";
    }
    @RequestMapping("/atendimentoNaoFechadosAtendente/{id}")
    public String listanaoFechados(@PathVariable Long id, Model model){
        model.addAttribute("aten", repositorioAtendente.findById(id).get());
        List<Atendimento> listAten= repositorioAtendimento.getAtendimentoByAtemdemteAndStatus(repositorioAtendente.findById(id).get());
        model.addAttribute("atendimentos", listAten);
        return "atendimento/listNaoFechadosPorAtendente";
    }
    @RequestMapping("/atendimentoPorUsuario/{id}")
    public String listaUsuario(@PathVariable Long id, Model model){
        model.addAttribute("user", repositorioUsuario.findById(id).get());
        List<Atendimento> listAten= repositorioAtendimento.getAtendimentoByUsuario(repositorioUsuario.findById(id).get());
        model.addAttribute("atendimentos", listAten);
        return "atendimento/listPorUsuario";
    }

}