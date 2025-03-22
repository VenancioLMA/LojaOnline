package Modulo.SGE.Entity;

import Modulo.SGE.Enum.TamanhoItem;

import java.util.ArrayList;

public class Estoque<T extends Item> {
    ArrayList<T> items;

    public Estoque() {
        this.items = new ArrayList<>();
    }

    public Estoque<T> adicionarItem(T item) {
        items.add(item);
        return this;
    }

    public Estoque<T> adicionarItem(ArrayList<T> item) {
        items.addAll(item);
        return this;
    }

    public Estoque<T> removerItem(T item) {
        items.remove(item);
        return this;
    }

    public ArrayList<T> getItems() {
        return items;
    }

}
