package Modulo.SGE.Repository;

import Modulo.SGE.Entity.Item;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ItemRepo implements IRepository<Item> {
    private List<Item> itens = new ArrayList<>();

    @Override
    public Item add(Item i) {
        itens.add(i);
        return i;
    }

    @Override
    public boolean remove(int id) {
        return itens.removeIf(i -> i.getId() == id);
    }

    @Override
    public Item update(int id, Object key, Object newValue) {
        Item i = listOne(id);
        try {
            for (Field field : i.getClass().getDeclaredFields()) {
                if (field.getName().equalsIgnoreCase(key.toString())) {
                    field.setAccessible(true);
                    field.set(i, newValue);
                    return i;
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Item listOne(int id) {
        return itens.stream().filter(i -> i.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Item> listAll() {
        return new ArrayList<>(itens);
    }
}
