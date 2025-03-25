package Modulo.Ecommerce.Repositorios;

import Modulo.Commons.Interfaces.IRepository;
import Modulo.Ecommerce.Entidades.ClienteCad;

import java.util.List;

public class RepositorioCliente implements IRepository<ClienteCad> {
    @Override
    public ClienteCad Adicionar(ClienteCad i) {
        return null;
    }

    @Override
    public boolean Remover(int id) {
        return false;
    }

    @Override
    public ClienteCad Atualizar(int id, Object key, Object newValue) {
        return null;
    }

    @Override
    public ClienteCad ListarPorId(int id) {
        return null;
    }

    @Override
    public List<ClienteCad> ListarTodos() {
        return List.of();
    }
}
