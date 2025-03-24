package Modulo.SGE.Estoque.Repository;

import Modulo.Commons.Interfaces.IRepository;
import Modulo.SGE.Estoque.Entity.Estoque;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class EstoqueRepo implements IRepository<Estoque> {
    private List<Estoque> estoques = new ArrayList<>();

    @Override
    public Estoque add(Estoque i) {
        estoques.add(i);
        return i;
    }

    @Override
    public boolean remove(int id) {
        return estoques.removeIf(i -> i.getId() == id);
    }

    @Override
    public Estoque update(int id, Object key, Object newValue) {
        Estoque i = listOne(id);
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
    public Estoque listOne(int id) {
        return estoques.stream().filter(i -> i.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Estoque> listAll() {
        return new ArrayList<>(estoques);
    }
}