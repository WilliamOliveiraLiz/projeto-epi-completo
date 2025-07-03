package com.exemplo.epi;

import com.exemplo.conexao.Conexao;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;

@Repository
public class EpiDao {
    public void inserir(Epi e) {
        String sql = "INSERT INTO epi (nome, quantidade) VALUES (?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, e.getNome());
            stmt.setInt(2, e.getQuantidade());

            stmt.executeUpdate();
            System.out.println("EPI inserido com sucesso!");

        } catch (SQLException ex) {
            System.out.println("Erro ao inserir EPI: " + ex.getMessage());
        }
    }

    public ArrayList<Epi> listar() {
        ArrayList<Epi> lista = new ArrayList<>();
        String sql = "SELECT * FROM epi";

        try (Connection conn = Conexao.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Epi e = new Epi(
                        rs.getInt("id_epi"),
                        rs.getString("nome"),
                        rs.getString("validade"),
                        rs.getInt("quantidade")
                );
                lista.add(e);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar EPIs: " + e.getMessage());
        }

        return lista;
    }

    public void atualizar(Epi e) {
        String sql = "UPDATE epi SET nome = ?, quantidade = ? WHERE id_epi = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, e.getNome());
            stmt.setInt(2, e.getQuantidade());
            stmt.setInt(3, e.getId());

            int linhas = stmt.executeUpdate();
            System.out.println(linhas > 0 ? "EPI atualizado!" : "EPI não encontrado.");

        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar EPI: " + ex.getMessage());
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM epi WHERE id_epi = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int linhas = stmt.executeUpdate();
            System.out.println(linhas > 0 ? "EPI excluído!" : "EPI não encontrado.");

        } catch (SQLException e) {
            System.out.println("Erro ao excluir EPI: " + e.getMessage());
        }
    }

    public Epi buscarPorId(int id) {
        String sql = "SELECT * FROM epi WHERE id_epi = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Epi(
                        rs.getInt("id_epi"),
                        rs.getString("nome"),
                        rs.getString("validade"),
                        rs.getInt("quantidade")
                );
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar EPI: " + e.getMessage());
        }

        return null;
    }
}