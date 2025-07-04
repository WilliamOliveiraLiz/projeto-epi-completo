package com.exemplo.emprestimo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/emprestimos")
public class EmprestimoContoller {

    private EmprestimoDao emprestimoDAO = new EmprestimoDao();

    @GetMapping("/emprestimos")
    @ResponseBody
    public List<Emprestimo> listar() {
        return emprestimoDAO.listarEmprestimos();
    }

    @PostMapping
    public String inserir(Emprestimo emprestimo) {
        emprestimoDAO.inserir(emprestimo);
        return "redirect:/emprestimos";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") int id) {
        emprestimoDAO.excluir(id);
        return "redirect:/emprestimos";
    }

    @GetMapping("/cadastro")
    public String abrirFormulario() {
        return "cadastro_emprestimo";
    }
}
