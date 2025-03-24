package Modulo.SGE.Repository;

import Modulo.SGE.Entity.Item;

import java.util.List;

public class RepositorioAleatorio implements IRepository<Item> {

    @Override
    public Item add(Item i) {
        return null;
    }

    public void add() {
    }

    @Override
    public boolean remove(int id) {
        return false;
    }

    @Override
    public Item update(int id, Object key, Object newValue) {
        return null;
    }

    @Override
    public Item listOne(int id) {
        return null;
    }

    @Override
    public List<Item> listAll() {
        return List.of();
    }
}
