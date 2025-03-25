package Modulo.Ecommerce.Repositorios;

import Modulo.Commons.Interfaces.IRepository;
import Modulo.Ecommerce.Entidades.Carrinho;

import java.util.ArrayList;
import java.util.List;

public class RepoCarrinho implements IRepository<Carrinho> {
    List<Carrinho> carrinhos = new ArrayList<>();


    @Override
    public Carrinho Adicionar(Carrinho i) {
        return null;
    }

    @Override
    public boolean Remover(int id) {
        return false;
    }

    @Override
    public Carrinho Atualizar(int id, Object key, Object newValue) {
        return null;
    }

    @Override
    public Carrinho ListarPorId(int id) {
        return null;
    }

    @Override
    public List<Carrinho> ListarTodos() {
        return List.of();
    }
}
