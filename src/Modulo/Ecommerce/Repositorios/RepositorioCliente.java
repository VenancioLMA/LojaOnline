package Modulo.Ecommerce.Repositorios;

import Modulo.Commons.Interfaces.IRepository;
import Modulo.Ecommerce.Entidades.ClienteCad;

import java.util.List;

public class RepositorioCliente implements IRepository<ClienteCad> {
    @Override
    public ClienteCad add(ClienteCad i) {
        return null;
    }

    @Override
    public boolean remove(int id) {
        return false;
    }

    @Override
    public ClienteCad update(int id, Object key, Object newValue) {
        return null;
    }

    @Override
    public ClienteCad listOne(int id) {
        return null;
    }

    @Override
    public List<ClienteCad> listAll() {
        return List.of();
    }
}
