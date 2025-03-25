package Modulo.SGE.Estoque.Servico;

import Modulo.SGE.Estoque.Entity.Fornecedor;
import Modulo.SGE.Estoque.Entity.Item;
import Modulo.SGE.Estoque.Enum.TamanhoItem;
import Modulo.SGE.Estoque.Repository.ItemRepo;

import java.util.List;

public class ItemService {
    private final ItemRepo repo;

    public ItemService(ItemRepo repo) {
        this.repo = repo;
    }

    public ItemRepo CadastrarItem(Item item) {
        repo.Adicionar(item);
        return repo;
    }

    public ItemRepo CadastrarItem(int id, int preco, String descricao, TamanhoItem tamanho, int quantidade, Fornecedor fornecedor) {
        Item item = new Item(id, preco, descricao, tamanho, quantidade, fornecedor);
        repo.Adicionar(item);
        return repo;
    }

    public List<Item> ListarTodosItens() {
        return repo.ListarTodos();
    }

    public Item ListarItemPorId(int id) throws Exception {
        Item item = repo.ListarPorId(id);
        if (item != null) {
            return item;
        }
        throw new Exception("Usuario nao encontrado");
    }


    public ItemRepo RemoverItem(int id) throws Exception {
        if (!repo.Remover(id)) {
            throw new Exception("Usuário não encontrado");
        }
        return repo;
    }

    public ItemRepo EditarItem(int id, String atributo, Object novoValor) {
        repo.Atualizar(id, atributo, novoValor);
        return repo;
    }
}
