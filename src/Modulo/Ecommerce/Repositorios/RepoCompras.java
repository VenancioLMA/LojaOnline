package Modulo.Ecommerce.Repositorios;

import Modulo.Commons.Interfaces.IRepository;
import Modulo.Ecommerce.Serviços.ServicoCompras;

import java.util.List;

public class RepoCompras implements IRepository<ServicoCompras> {
    @Override
    public ServicoCompras AdicionarRepo(ServicoCompras i) {
        return null;
    }

    @Override
    public boolean RemoverRepo(int id) {
        return false;
    }

    @Override
    public ServicoCompras AtualizarRepo(int id, Object key, Object newValue) {
        return null;
    }

    @Override
    public ServicoCompras ListarPorIdRepo(int id) {
        return null;
    }

    @Override
    public List<ServicoCompras> ListarTodosRepo() {
        return List.of();
    }
}
