package Modulo.Commons.Interfaces;

import java.util.List;

public interface IService<T> {
    public void Adicionar(T i);

    public void Remover(int id) throws Exception;

    public void Alterar(int id, Object chave, Object novoValor);

    public List<T> ListarTodos();

    public T ListarPorId(int id) throws Exception;
}
