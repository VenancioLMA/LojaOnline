package Modulo.SGE.Estoque.Servico;

import Modulo.SGE.Estoque.Entity.Estoque;
import Modulo.SGE.Estoque.Entity.Item;
import Modulo.SGE.Estoque.Repository.EstoqueRepo;

import java.util.ArrayList;
import java.util.List;

public class EstoqueService {
    private final EstoqueRepo repo;

    public EstoqueService(EstoqueRepo repo) {
        this.repo = repo;
    }

    public EstoqueRepo CadastrarItemEstoque(int estoqueId, Item item) throws Exception {
        Estoque estoque = ListarEstoquePorId(estoqueId);
        if (estoque != null) {
            estoque.setItem(item);
            AtualizarEstoque(estoqueId, "items", estoque);
        }

        return repo;
    }

    public EstoqueRepo CadastrarEstoque(int id) {
        Estoque i = new Estoque(id);
        repo.Adicionar(i);
        return repo;
    }

    public List<Estoque> ListarTodosEstoque() {
        return repo.ListarTodos();
    }

    public Estoque ListarEstoquePorId(int id) throws Exception {
        Estoque i = repo.ListarPorId(id);
        if (i != null) {
            return i;
        }
        throw new Exception("Estoque não encontrado");
    }


    public EstoqueRepo RemoverEstoque(int id) throws Exception {
        if (!repo.Remover(id)) {
            throw new Exception("Estoque não encontrado");
        }
        return repo;
    }

    public EstoqueRepo AtualizarEstoque(int id, String atributo, Object novoValor) {
        repo.Atualizar(id, atributo, novoValor);
        return repo;
    }

    public List<Item> ListarTodosItemsDentroDoEstoquePorId(int id) throws Exception {
        return ListarEstoquePorId(id).getItems();
    }

    public List<Item> ListarTodosItemsDentroDoEstoque() {
        List<Item> items = new ArrayList<>();
        for (Estoque estoque : ListarTodosEstoque()) {
            items.addAll(estoque.getItems());
        }
        return items;
    }

    public Item ListarItemDentroDoEstoquePorIdDoItem(int id) {
        for (Estoque estoque : ListarTodosEstoque()) {
            for (Item item : estoque.getItems()) {
                if (item.getId() == id) {
                    return item;
                }
            }
        }
        return null;
    }


}
