package com.exemplo.devolucao;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/devolucoes")
public class DevolucaoController {

    private DevolucaoDao devolucaoDAO = new DevolucaoDao();

    @GetMapping("/devolucao")
    @ResponseBody
    public List<Devolucao> devolucoes(){
        return devolucaoDAO.listar();
    }

    @PostMapping
    public String salvarDevolucao(Devolucao devolucao) {
        devolucaoDAO.inserir(devolucao);
        return "redirect:/devolucoes";
    }

    @GetMapping("/excluir/{id}")
    public String excluirDevolucao(@PathVariable("id") int id) {
        devolucaoDAO.excluir(id);
        return "redirect:/devolucoes";
    }

    @GetMapping("/cadastro")
    public String abrirFormulario() {
        return "cadastro_devolucao";
    }
}
