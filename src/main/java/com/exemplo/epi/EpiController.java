package com.exemplo.epi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/epi")
public class EpiController {

    private final EpiDao epiDao = new EpiDao();

    @PostMapping("/novo")
    public RedirectView salvar(
            @RequestParam("nome") String nome,
            @RequestParam("validade") String validade,
            @RequestParam("quantidade") int quantidade) {

        Epi epi = new Epi(0, nome, validade, quantidade);
        System.out.println("Recebido: " + epi);
        epiDao.inserir(epi);
        return new RedirectView("/epis.html");
    }

    @GetMapping
    @ResponseBody
    public String teste() {
        return "API ativa!";
    }
}
