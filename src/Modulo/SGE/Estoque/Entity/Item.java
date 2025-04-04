package Modulo.SGE.Estoque.Entity;

import Modulo.SGE.Estoque.Enum.TamanhoItem;

public class Item {

    private int id;
    private int preco;
    private String descricao;
    private TamanhoItem tamanho;
    private int quantidade;
    private Fornecedor fornecedor;

    public Item(int id, int preco, String descricao, TamanhoItem tamanho, int quantidade, Fornecedor fornecedor) {
        this.id = id;
        this.preco = preco;
        this.descricao = descricao;
        this.tamanho = tamanho;
        this.quantidade = quantidade;
        this.fornecedor = fornecedor;
    }

    public Item(Item item) {
        this.id = item.getId();
        this.preco = item.getPreco();
        this.descricao = item.getDescricao();
        this.tamanho = item.getTamanho();
        this.quantidade = item.getQuantidade();
        this.fornecedor = item.getFornecedor();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TamanhoItem getTamanho() {
        return tamanho;
    }

    public void setTamanho(TamanhoItem tamanho) {
        this.tamanho = tamanho;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", preco=" + preco +
                ", descricao='" + descricao + '\'' +
                ", tamanho=" + tamanho +
                ", quantidade=" + quantidade +
                ", fornecedor=" + fornecedor +
                '}';
    }
}


