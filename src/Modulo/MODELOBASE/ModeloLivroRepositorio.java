package Modulo.MODELOBASE;
import Modulo.Commons.Interfaces.IRepository;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ModeloLivroRepositorio implements IRepository<ModeloLivro> {
    private final List<ModeloLivro> lista = new ArrayList<>();

    // Adiciona um livro ao repositório
    @Override
    public ModeloLivro AdicionarRepo(ModeloLivro modeloLivro) {
        lista.add(modeloLivro);
        return modeloLivro;
    }

    // Remove um livro pelo seu ID
    @Override
    public boolean RemoverRepo(int id) {
        return lista.removeIf(modeloLivro -> modeloLivro.getId() == id);
    }

    // Atualiza um atributo específico de um livro
    @Override
    public ModeloLivro AtualizarRepo(int id, Object key, Object newValue) {
        ModeloLivro modeloLivro = ListarPorIdRepo(id);
        try {
            for (Field field : modeloLivro.getClass().getDeclaredFields()) {
                if (field.getName().equalsIgnoreCase(key.toString())) {
                    field.setAccessible(true);
                    field.set(modeloLivro, newValue);
                    return modeloLivro;
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Retorna um livro específico pelo seu ID
    @Override
    public ModeloLivro ListarPorIdRepo(int id) {
        return lista.stream().filter(i -> i.getId() == id).findFirst().orElse(null);
    }

    // Retorna todos os livros cadastrados
    @Override
    public List<ModeloLivro> ListarTodosRepo() {
        return new ArrayList<>(lista);
    }
}

