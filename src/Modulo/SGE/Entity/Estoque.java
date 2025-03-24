package Modulo.SGE.Entity;

import Modulo.SGE.Enum.TamanhoItem;

import java.util.ArrayList;
import java.util.List;

public class Estoque {
    private int id;
    private List<Item> items;

    public Estoque() {
        this.items = new ArrayList<>();
    }

    public Estoque adicionarItem(Item item) {
        items.add(item);
        return this;
    }

    public Estoque adicionarItens(List<Item> itens) {
        items.addAll(itens);
        return this;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Item> getItems() {
        return items;
    }
}
