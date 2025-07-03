package com.exemplo.epi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/epi")
public class EpiController {

    private EpiDao epiDao = new EpiDao();

    @GetMapping
    public ArrayList<Epi> listar() {
        return epiDao.listar();
    }

    @PostMapping("/novo")
    public RedirectView adicionarEPI(@ModelAttribute Epi epi) {
        epiDao.inserir(epi);
        return new RedirectView("/form-epi.html");
    }

    @PostMapping("/editar")
    public RedirectView atualizarEPI(@ModelAttribute Epi epi) {
        epiDao.atualizar(epi);
        return new RedirectView("/form-epi.html");
    }

    @GetMapping("/excluir/{id}")
    public RedirectView excluirEPI(@PathVariable("id") int id) {
        epiDao.excluir(id);
        return new RedirectView("/form-epi.html");
    }

    @GetMapping("/buscar/{id}")
    public Epi buscarPorId(@PathVariable("id") int id) {
        return epiDao.buscarPorId(id);
    }

}
