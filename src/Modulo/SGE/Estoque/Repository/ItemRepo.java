package Modulo.SGE.Estoque.Repository;

import Modulo.Commons.Interfaces.IRepository;
import Modulo.SGE.Estoque.Entity.Item;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ItemRepo implements IRepository<Item> {
    private final List<Item> list = new ArrayList<>();

    @Override
    public Item AdicionarRepo(Item i) {
        list.add(i);
        return i;
    }

    @Override
    public boolean RemoverRepo(int id) {
        return list.removeIf(i -> i.getId() == id);
    }

    @Override
    public Item AtualizarRepo(int id, Object key, Object newValue) {
        Item i = ListarPorIdRepo(id);
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
    public Item ListarPorIdRepo(int id) {
        return list.stream().filter(i -> i.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Item> ListarTodosRepo() {
        return new ArrayList<>(list);
    }
}
