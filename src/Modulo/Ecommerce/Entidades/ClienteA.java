package Modulo.Ecommerce.Entidades;
import Modulo.SGE.Estoque.Entity.Item;

import java.util.ArrayList;
import java.util.List;

public abstract class ClienteA {
    List<Item> carrinho = new ArrayList<>();

    public void adicionarAoCarrinho(Item item) {
        carrinho.add(item);
    }

    public List<Item> getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(List<Item> carrinho) {
        this.carrinho = carrinho;
    }
}
