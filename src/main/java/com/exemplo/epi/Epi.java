package com.exemplo.epi;

public class Epi {
    private int id;
    private String nome;
    private String validade;

    public Epi(String nome, String validade,  int id) {
        this.id = id;
        this.nome = nome;
        this.validade = validade;
    }
    public Epi(int id, String nome, String validade) {
        this.nome = nome;
        this.validade = validade;
    }

    public int getId() {return id;}

    public String getNome() {
        return nome;
    }

    public String getValidade() {
        return validade;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }
}
