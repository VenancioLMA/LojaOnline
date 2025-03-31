package Modulo.Entrega;

import java.util.Stack;

public interface IServicePilha<T> {
    void salvar(T i);

    T removerDoTopo();

    T consultarTopo();

    T buscarPorId(int i);

    Stack<T> listarTodos();
}
