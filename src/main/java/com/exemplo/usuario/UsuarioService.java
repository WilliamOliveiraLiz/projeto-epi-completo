package com.exemplo.usuario;

import com.exemplo.usuario.Usuario;
import com.exemplo.usuario.UsuarioDao;

import java.util.List;

    public class UsuarioService {
        private UsuarioDao usuarioDao = new UsuarioDao();

        public void salvar(Usuario usuario) {
            usuarioDao.inserir(usuario);
        }

        public List<Usuario> listar() {
            return usuarioDao.listar();
        }

        public Usuario buscarPorId(int id) {
            return usuarioDao.buscarPorId(id);
        }

        public void atualizar(Usuario usuario) {
            usuarioDao.atualizar(usuario);
        }

        public void deletar(int id) {
            usuarioDao.excluir(id);
        }
    }
