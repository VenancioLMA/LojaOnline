package Modulo.Ecommerce.Repositorios;

import Modulo.Commons.Interfaces.IRepository;
import Modulo.Ecommerce.Serviços.ServicoCompra;


import java.util.List;

public class RepoCompras implements IRepository<ServicoCompra> {

    @Override
    public ServicoCompra AdicionarRepo(ServicoCompra i) {
        return null;
    }

    @Override
    public boolean RemoverRepo(int id) {
        return false;
    }

    @Override
    public ServicoCompra AtualizarRepo(int id, Object key, Object newValue) {
        return null;
    }

    @Override
    public ServicoCompra ListarPorIdRepo(int id) {
        return null;
    }

    @Override
    public List<ServicoCompra> ListarTodosRepo() {
        return List.of();
    }
}
