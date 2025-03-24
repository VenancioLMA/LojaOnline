package Modulo.Ecommerce.Repositorios;

import Modulo.Commons.Interfaces.IRepository;
import Modulo.Ecommerce.Serviços.ServicoCompras;

import java.util.List;

public class RepoCompras implements IRepository<ServicoCompras> {
    @Override
    public ServicoCompras add(ServicoCompras i) {
        return null;
    }

    @Override
    public boolean remove(int id) {
        return false;
    }

    @Override
    public ServicoCompras update(int id, Object key, Object newValue) {
        return null;
    }

    @Override
    public ServicoCompras listOne(int id) {
        return null;
    }

    @Override
    public List<ServicoCompras> listAll() {
        return List.of();
    }
}
