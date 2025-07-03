package com.exemplo.emprestimo;

import com.exemplo.emprestimo.EmprestimoDao;
import com.exemplo.emprestimo.Emprestimo;

import java.util.List;

public class EmprestimoService {
    private EmprestimoDao emprestimoDao = new EmprestimoDao();

    public void salvar(Emprestimo emprestimo) {
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

    public void deletar(int id) {
        emprestimoDao.excluir(id);
    }
}
