package Modulo.Ecommerce.Repositorios;

import Modulo.Commons.Interfaces.IRepository;
import Modulo.Ecommerce.Entidades.Carrinho;

import java.util.ArrayList;
import java.util.List;

public class RepoCarrinho implements IRepository<Carrinho> {
    List<Carrinho> carrinhos = new ArrayList<>();


    @Override
    public Carrinho AdicionarRepo(Carrinho i) {
        return null;
    }

    @Override
    public boolean RemoverRepo(int id) {
        return false;
    }

    @Override
    public Carrinho AtualizarRepo(int id, Object key, Object newValue) {
        return null;
    }

    @Override
    public Carrinho ListarPorIdRepo(int id) {
        return null;
    }

    @Override
    public List<Carrinho> ListarTodosRepo() {
        return List.of();
    }
}
