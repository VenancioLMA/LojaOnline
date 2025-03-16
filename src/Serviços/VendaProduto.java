package Serviços;

public class VendaProduto {
    int id_produto;
    String nome_produto;
    double preco_produto;
    String descricao_produto;
    int quantidade_produto;

    public VendaProduto(int id_produto, String nome_produto, double preco_produto, String descricao_produto, int quantidade_produto) {
        this.id_produto = id_produto;
        this.nome_produto = nome_produto;
        this.preco_produto = preco_produto;
        this.descricao_produto = descricao_produto;
        this.quantidade_produto = quantidade_produto;
    }
    public int getId_produto() {
        return id_produto;
    }
    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }
    public String getNome_produto() {
        return nome_produto;
    }
    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }
    public double getPreco_produto() {
        return preco_produto;
    }
    public void setPreco_produto(double preco_produto) {
        this.preco_produto = preco_produto;
    }
    public String getDescricao_produto() {
        return descricao_produto;
    }
    public void setDescricao_produto(String descricao_produto) {
        this.descricao_produto = descricao_produto;
    }
    public int getQuantidade_produto() {
        return quantidade_produto;
    }
    public void setQuantidade_produto(int quantidade_produto) {
        this.quantidade_produto = quantidade_produto;
    }
}