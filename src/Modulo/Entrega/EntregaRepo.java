package Modulo.Entrega;

import java.util.Stack;

public class EntregaRepo implements IServicePilha<EntregaModel> {
    Stack<EntregaModel> list = new Stack<>();


    @Override
    public void salvar(EntregaModel i) {
        list.push(i);
    }

    @Override
    public EntregaModel removerDoTopo() {
        return list.pop();
    }

    @Override
    public EntregaModel consultarTopo() {
        return list.peek();
    }

    @Override
    public EntregaModel buscarPorId(int id) {
        for (EntregaModel entrega : list) {
            if (entrega.getId() == id) {
                return entrega;
            }
        }
        return null;
    }

    @Override
    public Stack<EntregaModel> listarTodos() {
        return list;
    }
}
