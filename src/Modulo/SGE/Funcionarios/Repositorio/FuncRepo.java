package Modulo.SGE.Funcionarios.Repositorio;

import Modulo.Commons.Interfaces.IRepository;
import Modulo.SGE.Funcionarios.Entidades.Funcionario;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class FuncRepo implements IRepository<Funcionario> {
    List<Funcionario> funcionariosList = new ArrayList<>();

    @Override
    public Funcionario add(Funcionario i) {
        funcionariosList.add(i);
        return i;
    }

    @Override
    public boolean remove(int id) {
        return funcionariosList.removeIf(i -> i.getId() == id);
    }

    @Override
    public Funcionario update(int id, Object key, Object newValue) {
        Funcionario i = listOne(id);
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
    public Funcionario listOne(int id) {
        return funcionariosList.stream().filter(i -> i.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Funcionario> listAll() {
        return new ArrayList<>(funcionariosList);
    }
}
