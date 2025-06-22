package com.exemplo.epi;

import com.mysql.cj.jdbc.CallableStatement;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args, CallableStatement rs) throws SQLException {
        Scanner sc = new Scanner(System.in);
        EPIDao epiDao = new EPIDao();
        UsuarioDao usuarioDao = new UsuarioDao();
        EmprestimoDao emprestimoDao = new EmprestimoDao();
        DevolucaoDao devolucaoDao = new DevolucaoDao();

        int opcao;

        do {
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1. Epi");
            System.out.println("2. Usuário");
            System.out.println("3. Empréstimo");
            System.out.println("4. Devolução");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> menuEPI(sc, epiDao, rs);
                case 2 -> menuUsuario(sc, usuarioDao);
                case 3 -> menuEmprestimo(sc, emprestimoDao);
                case 4 -> menuDevolucao(sc, devolucaoDao);
                case 0 -> System.out.println("Encerrando o programa...");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        sc.close();
    }
    private static void menuEPI(Scanner sc, EPIDao dao, CallableStatement rs) throws SQLException {
        int op;
        do {
            System.out.println("\n-- MENU EPI --");
            System.out.println("1. Cadastrar");
            System.out.println("2. Listar");
            System.out.println("3. Atualizar");
            System.out.println("4. Excluir");
            System.out.println("0. Voltar");
            System.out.print("Escolha: ");
            op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1 -> {
                    System.out.print("Nome do EPI: ");
                    String nome = sc.nextLine();
                    System.out.print("Validade (YYYY-MM-DD): ");
                    String validade = sc.nextLine();

                    dao.inserir(new Epi(rs.getInt("id_epi"), nome, validade));
                }
                case 2 -> {
                    ArrayList<Epi> lista = dao.listarEPIs();
                    for (Epi e : lista) {
                        System.out.println("ID: " + e.getId() + " | Nome: " + e.getNome() + " | Validade: " + e.getValidade());
                    }
                }
                case 3 -> {
                    System.out.print("ID do EPI a atualizar: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Novo nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Nova validade (YYYY-MM-DD): ");
                    String validade = sc.nextLine();

                    dao.atualizarEPI(new Epi(rs.getInt("id_epi"), nome, validade));
                }
                case 4 -> {
                    System.out.print("ID do EPI a excluir: ");
                    int id = sc.nextInt();
                    dao.excluirEPI(id);
                }
            }
        } while (op != 0);
    }

    private static void menuUsuario(Scanner sc, UsuarioDao dao) {
        int op;
        do {
            System.out.println("\n-- MENU USUÁRIO --");
            System.out.println("1. Cadastrar");
            System.out.println("2. Listar");
            System.out.println("3. Atualizar");
            System.out.println("4. Excluir");
            System.out.println("0. Voltar");
            System.out.print("Escolha: ");
            op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1 -> {
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("Senha: ");
                    String senha = sc.nextLine();
                    System.out.print("Perfil (administrador/colaborador): ");
                    String perfil = sc.nextLine();

                    dao.inserir(new Usuario(nome, email, senha, perfil));
                }
                case 2 -> {
                    ArrayList<Usuario> usuarios = dao.listar();
                    for (Usuario u : usuarios) {
                        System.out.println("ID: " + u.getId() + " | Nome: " + u.getNome() + " | Email: " + u.getEmail() + " | Perfil: " + u.getPerfil());
                    }
                }
                case 3 -> {
                    System.out.print("ID do usuário a atualizar: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Novo nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Novo email: ");
                    String email = sc.nextLine();
                    System.out.print("Nova senha: ");
                    String senha = sc.nextLine();
                    System.out.print("Novo perfil: ");
                    String perfil = sc.nextLine();

                    dao.atualizar(new Usuario(id, nome, email, senha, perfil));
                }
                case 4 -> {
                    System.out.print("ID do usuário a excluir: ");
                    int id = sc.nextInt();
                    dao.excluir(id);
                }
            }
        } while (op != 0);
    }

    private static void menuEmprestimo(Scanner sc, EmprestimoDao dao) {
        int op;
        do {
            System.out.println("\n-- MENU EMPRÉSTIMO --");
            System.out.println("1. Cadastrar");
            System.out.println("2. Listar");
            System.out.println("3. excluir");
            System.out.println("0. Voltar");
            System.out.print("Escolha: ");
            op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1 -> {
                    System.out.print("ID do usuário: ");
                    int idUsuario = sc.nextInt();
                    System.out.print("ID do EPI: ");
                    int idEpi = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Data de retirada (YYYY-MM-DD): ");
                    String dataRetirada = sc.nextLine();
                    System.out.print("Data prevista de devolução (YYYY-MM-DD): ");
                    String dataPrevista = sc.nextLine();
                    System.out.print("Confirmar retirada (true/false): ");
                    boolean confirmacao = sc.nextBoolean();

                    dao.inserir(new Emprestimo(idUsuario, idEpi, dataRetirada, dataPrevista, confirmacao));
                }
                case 2 -> {
                    ArrayList<Emprestimo> lista = dao.listar();
                    for (Emprestimo e : lista) {
                        System.out.println("ID: " + e.getId() + " | Usuário: " + e.getIdUsuario() +
                                " | EPI: " + e.getIdEpi() +
                                " | Retirada: " + e.getDataRetirada() +
                                " | Prev. Devolução: " + e.getDataPrevistaDevolucao() +
                                " | Confirmado: " + e.isConfirmacaoRetirada());
                    }
                }
                case 3 -> {
                    System.out.print("ID do emprestimo a excluir: ");
                    int id = sc.nextInt();
                    dao.excluir(id);
                }
            }
        } while (op != 0);
    }

    private static void menuDevolucao(Scanner sc, DevolucaoDao dao) {
        int op;
        do {
            System.out.println("\n-- MENU DEVOLUÇÃO --");
            System.out.println("1. Registrar");
            System.out.println("2. Listar");
            System.out.println("3. excluir");
            System.out.println("0. Voltar");
            System.out.print("Escolha: ");
            op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1 -> {
                    System.out.print("ID do empréstimo: ");
                    int idEmprestimo = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Data de devolução (YYYY-MM-DD HH:MM:SS): ");
                    String dataDevolucao = sc.nextLine();

                    dao.inserir(new Devolucao(idEmprestimo, dataDevolucao));
                }
                case 2 -> {
                    ArrayList<Devolucao> lista = dao.listar();
                    for (Devolucao d : lista) {
                        System.out.println("ID: " + d.getId() + " | Empréstimo: " + d.getIdEmprestimo() + " | Devolução: " + d.getDataDevolucao());
                    }
                }
                case 3 -> {
                    System.out.print("ID da devolução a excluir: ");
                    int id = sc.nextInt();
                    dao.excluir(id);
                }
            }
        } while (op != 0);
    }
}
