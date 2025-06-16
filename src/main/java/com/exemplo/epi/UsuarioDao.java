package com.exemplo.epi;

import java.sql.*;
import java.util.ArrayList;

public class UsuarioDao {

    public void inserir(com.example.Usuario u) {
        String sql = "INSERT INTO usuario (nome, email, senha, perfil) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getEmail());
            stmt.setString(3, u.getSenha());
            stmt.setString(4, u.getPerfil());

            stmt.executeUpdate();
            System.out.println("Usuário inserido com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao inserir usuário: " + e.getMessage());
        }
    }

    public ArrayList<com.example.Usuario> listar() {
        ArrayList<com.example.Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuario";

        try (Connection conn = Conexao.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                com.example.Usuario u = new com.example.Usuario(
                        rs.getInt("id_usuario"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("senha"),
                        rs.getString("perfil")
                );
                lista.add(u);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar usuários: " + e.getMessage());
        }

        return lista;
    }

    public void atualizar(com.example.Usuario u) {
        String sql = "UPDATE usuario SET nome = ?, email = ?, senha = ?, perfil = ? WHERE id_usuario = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getEmail());
            stmt.setString(3, u.getSenha());
            stmt.setString(4, u.getPerfil());
            stmt.setInt(5, u.getId());

            int linhas = stmt.executeUpdate();
            System.out.println(linhas > 0 ? "Usuário atualizado!" : "Usuário não encontrado.");

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar usuário: " + e.getMessage());
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM usuario WHERE id_usuario = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int linhas = stmt.executeUpdate();
            System.out.println(linhas > 0 ? "Usuário excluído!" : "Usuário não encontrado.");

        } catch (SQLException e) {
            System.out.println("Erro ao excluir usuário: " + "Usuario possui emprestimos pendentes");
        }
    }
}
