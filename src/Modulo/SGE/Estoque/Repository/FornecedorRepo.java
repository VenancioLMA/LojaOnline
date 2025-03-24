package Modulo.SGE.Estoque.Repository;

import Modulo.Commons.Interfaces.IRepository;
import Modulo.SGE.Estoque.Entity.Fornecedor;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class FornecedorRepo implements IRepository<Fornecedor> {
    private List<Fornecedor> fornecedores = new ArrayList<>();

    @Override
    public Fornecedor add(Fornecedor i) {
        fornecedores.add(i);
        return i;
    }

    @Override
    public boolean remove(int id) {
        return fornecedores.removeIf(i -> i.getId() == id);
    }

    @Override
    public Fornecedor update(int id, Object key, Object newValue) {
        Fornecedor i = listOne(id);
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
    public Fornecedor listOne(int id) {
        return fornecedores.stream().filter(i -> i.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Fornecedor> listAll() {
        return new ArrayList<>(fornecedores);
    }
}
