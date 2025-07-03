package com.exemplo.epi;

import com.exemplo.epi.Epi;
import com.exemplo.epi.EpiDao;

import java.util.List;

public class EpiService {
    private EpiDao epiDao = new EpiDao();

    public void salvar(Epi epi) {
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

    public void deletar(int id) {
        epiDao.excluir(id);
    }
}
