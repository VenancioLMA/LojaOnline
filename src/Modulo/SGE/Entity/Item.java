package Modulo.SGE.Entity;

import Modulo.SGE.Enum.TamanhoItem;

public class Item {
    private int preco;
    private String descricao;
    private Enum<TamanhoItem> tamanho;
    private int quantidade;
//    private Fornecedor fornecedor;

    public Item(int preco, String descricao, Enum<TamanhoItem> tamanho, int quantidade) {
        this.preco = preco;
        this.descricao = descricao;
        this.tamanho = tamanho;
        this.quantidade = quantidade;
//        this.fornecedor = fornecedor; Fornecedor fornecedor
    }
}
