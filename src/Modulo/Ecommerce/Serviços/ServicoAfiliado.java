

import Modulo.Commons.Interfaces.IService;
import Modulo.Entrega.EntregaModel;

import java.util.List;

public class ServicoAfiliado implements IService{
    @Override
    public void Adicionar(Object i) {

    }

    @Override
    public boolean Remover(int id) throws Exception {

        return false;
    }

    @Override
    public EntregaModel Alterar(int id, Object chave, Object novoValor) {

        return null;
    }

    @Override
    public List ListarTodos() {
        return List.of();
    }

    @Override
    public Object ListarPorId(int id) throws Exception {
        return null;
    }
}
