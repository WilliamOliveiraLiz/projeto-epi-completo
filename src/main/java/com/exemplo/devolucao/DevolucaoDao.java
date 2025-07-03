package com.exemplo.devolucao;

import com.exemplo.conexao.Conexao;

import java.sql.*;
import java.util.ArrayList;

public class DevolucaoDao {

    public void inserir(Devolucao d) {
        String sql = "INSERT INTO devolucao (id_emprestimo, data_devolucao) VALUES (?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, d.getIdEmprestimo());
            stmt.setString(2, d.getDataDevolucao());

            stmt.executeUpdate();
            System.out.println("Devolução registrada!");

        } catch (SQLException e) {
            System.out.println("Erro ao registrar devolução: " + e.getMessage());
        }
    }

    public ArrayList<Devolucao> listar() {
        ArrayList<Devolucao> lista = new ArrayList<>();
        String sql = "SELECT * FROM devolucao";

        try (Connection conn = Conexao.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Devolucao d = new Devolucao(
                        rs.getInt("id_devolucao"),
                        rs.getInt("id_emprestimo"),
                        rs.getString("data_devolucao")
                );
                lista.add(d);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar devoluções: " + e.getMessage());
        }

        return lista;
    }

    public void atualizar(Devolucao d) {
        String sql = "UPDATE devolucao SET id_emprestimo = ?, data_devolucao = ? WHERE id_devolucao = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, d.getIdEmprestimo());
            stmt.setString(2, d.getDataDevolucao());
            stmt.setInt(3, d.getId());

            int linhas = stmt.executeUpdate();
            System.out.println(linhas > 0 ? "Devolução atualizada!" : "Devolução não encontrada.");

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar a devolução: " + e.getMessage());
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM devolucao WHERE id_devolucao = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int linhas = stmt.executeUpdate();
            System.out.println(linhas > 0 ? "Devolução excluída!" : "Devolução não encontrado.");

        } catch (SQLException e) {
            System.out.println("Erro ao excluir o devolução: " + e.getMessage());
        }
    }

    public Devolucao buscarPorId(int id) {
        String sql = "SELECT * FROM devolucao WHERE id_devolucao = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Devolucao(
                        rs.getInt("id_devolucao"),
                        rs.getInt("id_emprestimo"),
                        rs.getString("data_devolucao")
                );
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar devolução: " + e.getMessage());
        }
        return null;
    }
}