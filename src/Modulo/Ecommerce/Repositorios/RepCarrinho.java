package Modulo.Ecommerce.Repositorios;
import Modulo.SGE.Entity.Item;

import java.util.ArrayList;

import java.util.List;

public class RepCarrinho {
    List<Item> itens = new ArrayList<>();

    public void AdicionarItem(Item item) {
        itens.add(item);
    }
    public void RemoverItem(Item item) {
        itens.remove(item);
    }
    public void AlterarItem(Item item) {
        itens.set(itens.indexOf(item), item);
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }
}
