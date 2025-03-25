package Modulo.Ecommerce.Repositorios;

import Modulo.Commons.Interfaces.IRepository;
import Modulo.Ecommerce.Serviços.ServicoCompras;

import java.util.List;

public class RepoCompras implements IRepository<ServicoCompras> {
    @Override
    public ServicoCompras Adicionar(ServicoCompras i) {
        return null;
    }

    @Override
    public boolean Remover(int id) {
        return false;
    }

    @Override
    public ServicoCompras Atualizar(int id, Object key, Object newValue) {
        return null;
    }

    @Override
    public ServicoCompras ListarPorId(int id) {
        return null;
    }

    @Override
    public List<ServicoCompras> ListarTodos() {
        return List.of();
    }
}
