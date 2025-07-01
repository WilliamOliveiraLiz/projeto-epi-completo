package com.exemplo.epi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

public class EpiService {


    @Service
    public class EPIService {

        private final EpiRepository epiRepository;

        @Autowired
        public EPIService(EpiRepository epiRepository) {
            this.epiRepository = epiRepository;
        }

        public ArrayList<Epi> buscarTodosEPIs() {
            return new ArrayList<>(epiRepository.findAll());
        }

        public void adicionarEPI(Epi epi) {
            epiRepository.save(epi);
        }

        public void atualizarEPI(Epi epi) {
            epiRepository.save(epi); // Se o id existir, atualiza; se não existir, cria
        }

        public void deletarEPI(int id) {
            epiRepository.deleteById(id);
        }

        public Epi buscarEPIPorId(int id) {
            Optional<Epi> optionalEpi = epiRepository.findById(id);
            return optionalEpi.orElse(null); // Retorna null caso não encontre
        }
    }

}
