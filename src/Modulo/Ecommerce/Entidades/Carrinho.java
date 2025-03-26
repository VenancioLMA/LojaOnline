package Modulo.Ecommerce.Entidades;

import Modulo.SGE.Estoque.Entity.Item;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    int id;
    String descricao;

    List<Item> items = new ArrayList<Item>();

    public void adicionarItem(Item item) {
        items.add(item);
    }
}
