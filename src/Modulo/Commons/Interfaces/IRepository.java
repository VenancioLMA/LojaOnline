package Modulo.Commons.Interfaces;

import java.util.List;

public interface IRepository<T> {

    T Adicionar(T i);

    boolean Remover(int id);

    T Atualizar(int id, Object key, Object newValue);

    T ListarPorId(int id);

    List<T> ListarTodos();
}