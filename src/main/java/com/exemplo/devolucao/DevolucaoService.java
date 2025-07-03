package com.exemplo.devolucao;

import com.exemplo.devolucao.Devolucao;
import com.exemplo.devolucao.DevolucaoDao;

import java.util.List;

public class DevolucaoService {
    private DevolucaoDao devolucaoDao = new DevolucaoDao();

    public void inserir(Devolucao devolucao) {
        devolucaoDao.inserir(devolucao);
    }

    public List<Devolucao> listar() {
        return devolucaoDao.listar();
    }

    public Devolucao buscarPorId(int id) {
        return devolucaoDao.buscarPorId(id);
    }

    public void atualizar(Devolucao devolucao) {
        devolucaoDao.atualizar(devolucao);
    }

    public void deletar(int id) {
        devolucaoDao.excluir(id);
    }
}
