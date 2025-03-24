package Modulo.Ecommerce.Repositorios;

import Modulo.Commons.Interfaces.IRepository;
import Modulo.Ecommerce.Entidades.Carrinho;

import java.util.ArrayList;
import java.util.List;

public class RepoCarrinho implements IRepository<Carrinho> {
    List<Carrinho> carrinhos = new ArrayList<>();


    @Override
    public Carrinho add(Carrinho i) {
        return null;
    }

    @Override
    public boolean remove(int id) {
        return false;
    }

    @Override
    public Carrinho update(int id, Object key, Object newValue) {
        return null;
    }

    @Override
    public Carrinho listOne(int id) {
        return null;
    }

    @Override
    public List<Carrinho> listAll() {
        return List.of();
    }
}
