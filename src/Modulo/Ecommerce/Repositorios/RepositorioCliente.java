package Modulo.Ecommerce.Repositorios;

import Modulo.Commons.Interfaces.IRepository;
import Modulo.Ecommerce.Entidades.ClienteCad;

import java.util.List;

public class RepositorioCliente implements IRepository<ClienteCad> {
    @Override
    public ClienteCad AdicionarRepo(ClienteCad i) {
        return null;
    }

    @Override
    public boolean RemoverRepo(int id) {
        return false;
    }

    @Override
    public ClienteCad AtualizarRepo(int id, Object key, Object newValue) {
        return null;
    }

    @Override
    public ClienteCad ListarPorIdRepo(int id) {
        return null;
    }

    @Override
    public List<ClienteCad> ListarTodosRepo() {
        return List.of();
    }
}
