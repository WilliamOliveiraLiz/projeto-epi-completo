package com.exemplo.epi;

import java.util.List;

public class EpiService {
    private EpiDao epiDao = new EpiDao();

    public void inserir(Epi epi) {
        epiDao.inserir(epi);
    }

    public List<Epi> listar() {
        return epiDao.listar();
    }

    public Epi buscarPorId(int id) {
        return epiDao.buscarPorId(id);
    }

    public void atualizar(Epi epi) {
        epiDao.atualizar(epi);
    }

    public void excluir(int id) {
        epiDao.excluir(id);
    }
}
