package Modulo.Commons.Interfaces;

import Modulo.Entrega.EntregaModel;

import java.util.List;

public interface IService<T> {
    public void Adicionar(T i);

    public boolean Remover(int id) throws Exception;

    public EntregaModel Alterar(int id, Object chave, Object novoValor);

    public List<T> ListarTodos();

    public T ListarPorId(int id) throws Exception;
}
