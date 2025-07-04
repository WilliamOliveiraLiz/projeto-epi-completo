package com.exemplo.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.sql.CallableStatement;
import java.util.List;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioDao usuarioDAO = new UsuarioDao();
    private CallableStatement rs;

    @GetMapping
    public ModelAndView listar() {
        List<Usuario> lista = usuarioDAO.listar();
        ModelAndView mv = new ModelAndView("listar_usuarios");
        mv.addObject("usuarios", lista);
        return mv;
    }

    @PostMapping
    public String inserir(Usuario usuario) {
        usuarioDAO.inserir(usuario);
        return "redirect:/usuarios";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable int id) {
        usuarioDAO.excluir(id);
        return "redirect:/usuarios";
    }

    @GetMapping("/cadastro")
    public String abrirFormulario() {
        return "cadastro_usuario";
    }
}
