package Modulo.SGE.Estoque.Servico;

import Modulo.Commons.Interfaces.IService;
import Modulo.Entrega.EntregaModel;
import Modulo.SGE.Estoque.Entity.Estoque;
import Modulo.SGE.Estoque.Entity.Item;
import Modulo.SGE.Estoque.Repository.EstoqueRepo;

import java.util.ArrayList;
import java.util.List;

public class EstoqueService implements IService<Estoque> {
    private final EstoqueRepo repo;

    public EstoqueService(EstoqueRepo repo) {
        this.repo = repo;
    }

    @Override
    public void Adicionar(Estoque i) {
        repo.AdicionarRepo(i);
    }

    @Override
    public boolean Remover(int id) throws Exception {
        if (!repo.RemoverRepo(id)) {
            throw new Exception("Estoque não encontrado");
        }
        return false;
    }

    @Override
    public EntregaModel Alterar(int id, Object chave, Object novoValor) {
        repo.AtualizarRepo(id, chave, novoValor);
        return null;
    }

    @Override
    public List<Estoque> ListarTodos() {
        return repo.ListarTodosRepo();
    }

    @Override
    public Estoque ListarPorId(int id) throws Exception {
        Estoque i = repo.ListarPorIdRepo(id);
        if (i != null) {
            return i;
        }
        throw new Exception("Estoque não encontrado");
    }

    public EstoqueRepo CadastrarItemEstoque(int estoqueId, Item item) throws Exception {
        Estoque estoque = ListarPorId(estoqueId);
        if (estoque != null) {
            estoque.setItem(item);
            Alterar(estoqueId, "items", estoque);
        }

        return repo;
    }

    public List<Item> ListarTodosItemsDentroDoEstoquePorId(int id) throws Exception {
        return ListarPorId(id).getItems();
    }

    public List<Item> ListarTodosItemsDentroDoEstoque() {
        List<Item> items = new ArrayList<>();
        for (Estoque estoque : ListarTodos()) {
            items.addAll(estoque.getItems());
        }
        return items;
    }

    public Item ListarItemDentroDoEstoquePorIdDoItem(int id) {
        for (Estoque estoque : ListarTodos()) {
            for (Item item : estoque.getItems()) {
                if (item.getId() == id) {
                    return item;
                }
            }
        }
        return null;
    }
}
