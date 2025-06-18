package com.exemplo.epi;

import com.mysql.cj.jdbc.CallableStatement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.sql.SQLException;
import java.util.List;

@Controller
public class EpiController {

    @Autowired
    private EPIDao EPIDao = new EPIDao();
    private CallableStatement rs;

    @PostMapping("/epis")
    public String salvar(@RequestParam String nome, @RequestParam String validade) {
        int id;
        try {
            EPIDao.inserir(new Epi(rs.getInt("id_epi"), nome, validade));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "redirect:/epis";
    }

    @GetMapping("/epis")
    @ResponseBody
    public List<Epi> listar() {
        return EPIDao.listarEPIs();
    }
}
