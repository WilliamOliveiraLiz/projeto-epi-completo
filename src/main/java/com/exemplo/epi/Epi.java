package com.exemplo.epi;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Epi {
    private int id;
    private String nome;
    private String validade;
    private int quantidade;

    public Epi(){

    }

    public Epi(String nome, String validade,  int id, int quantidade) {
        this.id = id;
        this.nome = nome;
        this.validade = validade;
        this.quantidade = quantidade;
    }
    public Epi(int idEpi, String nome, String validade, int quantidade) {
        this.nome = nome;
        this.validade = validade;
        this.quantidade = quantidade;
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

    public int getQuantidade(){return quantidade;}

    public void setQuantidade(){this.quantidade = quantidade;}

    @Override
    public String toString(){
        return "ID: "+id+ ", Nome: "+nome+", Quantidade: "+quantidade+", Validade: "+validade;
    }
}
