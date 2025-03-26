package Modulo.SGE.Funcionarios.Repositorio;

import Modulo.Commons.Interfaces.IRepository;
import Modulo.SGE.Funcionarios.Entidades.Funcionario;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class FuncRepo implements IRepository<Funcionario> {
    List<Funcionario> funcionariosList = new ArrayList<>();

    @Override
    public Funcionario AdicionarRepo(Funcionario i) {
        funcionariosList.add(i);
        return i;
    }

    @Override
    public boolean RemoverRepo(int id) {
        return funcionariosList.removeIf(i -> i.getId() == id);
    }

    @Override
    public Funcionario AtualizarRepo(int id, Object key, Object newValue) {
        Funcionario i = ListarPorIdRepo(id);
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
    public Funcionario ListarPorIdRepo(int id) {
        return funcionariosList.stream().filter(i -> i.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Funcionario> ListarTodosRepo() {
        return new ArrayList<>(funcionariosList);
    }
}
