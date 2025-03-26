package Modulo.SGE.Estoque.Repository;

import Modulo.Commons.Interfaces.IRepository;
import Modulo.SGE.Estoque.Entity.Estoque;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class EstoqueRepo implements IRepository<Estoque> {
    private final List<Estoque> list = new ArrayList<>();

    @Override
    public Estoque AdicionarRepo(Estoque i) {
        list.add(i);
        return i;
    }

    @Override
    public boolean RemoverRepo(int id) {
        return list.removeIf(i -> i.getId() == id);
    }

    @Override
    public Estoque AtualizarRepo(int id, Object key, Object newValue) {
        Estoque i = ListarPorIdRepo(id);
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
    public Estoque ListarPorIdRepo(int id) {
        return list.stream().filter(i -> i.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Estoque> ListarTodosRepo() {
        return new ArrayList<>(list);
    }

    @Override
    public String toString() {
        return "EstoqueRepo{" +
                "list=" + list +
                '}';
    }
}