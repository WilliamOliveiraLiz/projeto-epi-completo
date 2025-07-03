package com.exemplo.emprestimo;

public class Emprestimo {
    private int id;
    private int idUsuario;
    private int idEpi;
    private String dataRetirada;
    private String dataPrevistaDevolucao;
    private boolean confirmacaoRetirada;

    public Emprestimo() {}

    public Emprestimo(int idUsuario, int idEpi, String dataRetirada, String dataPrevistaDevolucao, boolean confirmacaoRetirada) {
        this.idUsuario = idUsuario;
        this.idEpi = idEpi;
        this.dataRetirada = dataRetirada;
        this.dataPrevistaDevolucao = dataPrevistaDevolucao;
        this.confirmacaoRetirada = confirmacaoRetirada;
    }

    public Emprestimo(int id, int idUsuario, int idEpi, String dataRetirada, String dataPrevistaDevolucao, boolean confirmacaoRetirada) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.idEpi = idEpi;
        this.dataRetirada = dataRetirada;
        this.dataPrevistaDevolucao = dataPrevistaDevolucao;
        this.confirmacaoRetirada = confirmacaoRetirada;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    public int getIdEpi() {
        return idEpi;
    }
    public void setIdEpi(int idEpi) {
        this.idEpi = idEpi;
    }
    public String getDataRetirada() {
        return dataRetirada;
    }
    public void setDataRetirada(String dataRetirada) {
        this.dataRetirada = dataRetirada;
    }
    public String getDataPrevistaDevolucao() {
        return dataPrevistaDevolucao;
    }
    public void setDataPrevistaDevolucao(String dataPrevistaDevolucao) {
        this.dataPrevistaDevolucao = dataPrevistaDevolucao;
    }
    public boolean isConfirmacaoRetirada() {
        return confirmacaoRetirada;
    }
    public void setConfirmacaoRetirada(boolean confirmacaoRetirada) {
        this.confirmacaoRetirada = confirmacaoRetirada;
    }
}
