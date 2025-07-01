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

    private final EpiService epiService;

    public EPIController(EpiService epiService) {
        this.epiService = epiService;
    }

    @GetMapping
    public ArrayList<Epi> listarEPIs() {
        return epiService.buscarTodosEPIs();
    }

    @PostMapping("/novo")
    public RedirectView adicionarEPI(@ModelAttribute Epi epi) {
        epiService.adicionarEpi(epi);
        return new RedirectView("/form-epi.html");
    }

    @PostMapping("/editar")
    public RedirectView atualizarEPI(@ModelAttribute Epi epi) {
        epiService.atualizarEPI(epi);
        return new RedirectView("/form-epi.html");
    }

    @GetMapping("/excluir/{id}")
    public RedirectView excluirEPI(@PathVariable("id") int id) {
        epiService.deletarEPI(id);
        return new RedirectView("/form-epi.html");
    }

    @GetMapping("/buscar/{id}")
    public Epi buscarPorId(@PathVariable("id") int id) {
        return epiService.buscarEpiPorId(id);
    }


}
