package com.exemplo.emprestimo;

import java.util.List;

public class EmprestimoService {
    private EmprestimoDao emprestimoDao = new EmprestimoDao();

    public void inserir(Emprestimo emprestimo) {
        emprestimoDao.inserir(emprestimo);
    }

    public List<Emprestimo> listar() {
        return emprestimoDao.listarEmprestimos();
    }

    public Emprestimo buscarPorId(int id) {
        return emprestimoDao.buscarPorId(id);
    }

    public void atualizar(Emprestimo emprestimo) {
        emprestimoDao.atualizar(emprestimo);
    }

    public void excluir(int id) {
        emprestimoDao.excluir(id);
    }
}
