package Modulo.Commons.Interfaces;

import java.util.List;

public interface IRepository<T> {

    T AdicionarRepo(T i);

    boolean RemoverRepo(int id);

    T AtualizarRepo(int id, Object key, Object newValue);

    T ListarPorIdRepo(int id);

    List<T> ListarTodosRepo();
}