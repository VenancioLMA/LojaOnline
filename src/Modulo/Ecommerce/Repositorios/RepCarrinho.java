package Modulo.Ecommerce.Repositorios;

import Modulo.Commons.Interfaces.IRepository;
import Modulo.Ecommerce.Entidades.Carrinho;
import Modulo.SGE.Estoque.Entity.Item;

import java.util.ArrayList;

import java.util.List;

public class RepCarrinho implements IRepository<Carrinho> {
    List<Carrinho> carrinho = new ArrayList<>();

    @Override
    public Carrinho add(Carrinho i) {
        carrinho.add(i);
        return i;
    }

    @Override
    public boolean remove(int id) {
        return carrinho.removeIf(i -> i.getId() == id);
    }

    @Override
    public Carrinho update(int id, Object key, Object newValue) {
        return null;
    }

    @Override
    public Carrinho listOne(int id) {
        return null;
    }

    @Override
    public List<Carrinho> listAll() {
        return List.of();
    }


//    List<Item> itens = new ArrayList<>();
//
//    public void AdicionarItem(Item item) {
//
//    }
//    public void RemoverItem(Item item) {
//        itens.remove(item);
//    }
//    public void AlterarItem(Item item) {
//        itens.set(itens.indexOf(item), item);
//    }
//
//    public List<Item> getItens() {
//        return itens;
//    }
//
//    public void setItens(List<Item> itens) {
//        this.itens = itens;
//    }
}
