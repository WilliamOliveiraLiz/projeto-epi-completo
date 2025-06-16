package com.exemplo.epi;

import java.sql.*;
import java.util.ArrayList;

public class EmprestimoDao {

    public void inserir(Emprestimo e) {
        String sql = "INSERT INTO emprestimo (id_emprestimo, id_usuario, id_epi, data_retirada, data_prevista_devolucao, confirmacao_retirada) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, e.getId());
            stmt.setInt(2, e.getIdUsuario());
            stmt.setInt(3, e.getIdEpi());
            stmt.setString(4, e.getDataRetirada());
            stmt.setString(5, e.getDataPrevistaDevolucao());
            stmt.setBoolean(6, e.isConfirmacaoRetirada());

            stmt.executeUpdate();
            System.out.println("Empréstimo registrado!");

        } catch (SQLException ex) {
            System.out.println("Erro ao registrar empréstimo: " + ex.getMessage());
        }
    }

    public ArrayList<Emprestimo> listar() {
        ArrayList<Emprestimo> lista = new ArrayList<>();
        String sql = "SELECT * FROM emprestimo";

        try (Connection conn = Conexao.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Emprestimo e = new Emprestimo(
                        rs.getInt("id_emprestimo"),
                        rs.getInt("id_usuario"),
                        rs.getInt("id_epi"),
                        rs.getString("data_retirada"),
                        rs.getString("data_prevista_devolucao"),
                        rs.getBoolean("confirmacao_retirada")
                );
                lista.add(e);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar empréstimos: " + e.getMessage());
        }

        return lista;
    }
    public void excluir(int id) {
        String sql = "DELETE FROM emprestimo WHERE id_emprestimo = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int linhas = stmt.executeUpdate();
            System.out.println(linhas > 0 ? "Emprestimo excluído!" : "Emprestimo não encontrado.");

        } catch (SQLException e) {
            System.out.println("Erro ao excluir o emprestimo: " + e.getMessage());
        }
    }
}
