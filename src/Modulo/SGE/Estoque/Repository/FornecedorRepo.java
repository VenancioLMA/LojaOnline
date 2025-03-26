package Modulo.SGE.Estoque.Repository;

import Modulo.Commons.Interfaces.IRepository;
import Modulo.SGE.Estoque.Entity.Fornecedor;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class FornecedorRepo implements IRepository<Fornecedor> {
    private final List<Fornecedor> list = new ArrayList<>();

    @Override
    public Fornecedor AdicionarRepo(Fornecedor i) {
        list.add(i);
        return i;
    }

    @Override
    public boolean RemoverRepo(int id) {
        return list.removeIf(i -> i.getId() == id);
    }

    @Override
    public Fornecedor AtualizarRepo(int id, Object key, Object newValue) {
        Fornecedor i = ListarPorIdRepo(id);
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
    public Fornecedor ListarPorIdRepo(int id) {
        return list.stream().filter(i -> i.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Fornecedor> ListarTodosRepo() {
        return new ArrayList<>(list);
    }

    @Override
    public String toString() {
        return "FornecedorRepo{" +
                "list=" + list +
                '}';
    }
}
