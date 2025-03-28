package Modulo.Ecommerce.Entidades;

import Modulo.SGE.Estoque.Entity.Item;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    private List<Item> items = new ArrayList<>();

    public void adicionarItem(Item item) {
        items.add(item);
    }

    public List<Item> getItems() {
        return items;
    }
}