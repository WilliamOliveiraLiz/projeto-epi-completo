package com.exemplo.epi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/epis")
public class EpiController {

    private EpiDao epiDao = new EpiDao();

    @GetMapping
    public ArrayList<Epi> listar() {
        return epiDao.listar();
    }

    @PostMapping("/novo")
    public RedirectView inserir(@ModelAttribute Epi epi) {
        epiDao.inserir(epi);
        return new RedirectView("/form-epis.html");
    }

    @PostMapping("/editar")
    public RedirectView atualizar(@ModelAttribute Epi epi) {
        epiDao.atualizar(epi);
        return new RedirectView("/form-epis.html");
    }

    @GetMapping("/excluir/{id}")
    public RedirectView excluir(@PathVariable("id") int id) {
        epiDao.excluir(id);
        return new RedirectView("/form-epis.html");
    }

    @GetMapping("/buscar/{id}")
    public Epi buscarPorId(@PathVariable("id") int id) {
        return epiDao.buscarPorId(id);
    }

}
