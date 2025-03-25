package Modulo.SGE.Estoque.Entity;

import java.util.ArrayList;
import java.util.List;

public class Estoque {
    private int id;
    private List<Item> items;

    public Estoque(int id) {
        this.id = id;
        this.items = new ArrayList<>();
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

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void setItem(Item item) {
        if (!items.contains(item)) {
            this.items.add(item);
        }
    }

    @Override
    public String toString() {
        return "Estoque{" + "id=" + id + ", items=" + items + '}';
    }
}
