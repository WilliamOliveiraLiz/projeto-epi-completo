package com.exemplo.epi;

public class Epi {
    private int id;
    private String nome;
    private String validade;
    private int quantidade;

    public Epi(String nome, int quantidade, String validade) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.validade = validade;
    }

    public Epi(int id, String nome, String validade, int quantidade) {
        this.id = id;
        this.nome = nome;
        this.validade = validade;
        this.quantidade = quantidade;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getValidade() { return validade; }
    public void setValidade(String validade) { this.validade = validade; }

    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }

    @Override
    public String toString() {
        return "ID: " + id + ", Nome: " + nome + ", Quantidade: " + quantidade + ", Validade: " + validade;
    }
}
