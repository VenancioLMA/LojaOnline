package Modulo.SGE.Estoque.Servico;

import Modulo.Commons.Interfaces.IService;
import Modulo.SGE.Estoque.Entity.Fornecedor;
import Modulo.SGE.Estoque.Entity.Item;
import Modulo.SGE.Estoque.Enum.TamanhoItem;
import Modulo.SGE.Estoque.Repository.ItemRepo;

import java.util.List;

public class ItemService implements IService<Item> {
    private final ItemRepo repo;

    public ItemService(ItemRepo repo) {
        this.repo = repo;
    }

    @Override
    public void Adicionar(Item i) {
        repo.AdicionarRepo(i);
    }

    @Override
    public void Remover(int id) throws Exception {
        if (!repo.RemoverRepo(id)) {
            throw new Exception("Item não encontrado");
        }
    }

    @Override
    public void Alterar(int id, Object chave, Object novoValor) {
        repo.AtualizarRepo(id, chave, novoValor);
    }

    @Override
    public List<Item> ListarTodos() {
        return repo.ListarTodosRepo();
    }

    @Override
    public Item ListarPorId(int id) throws Exception {
        Item i = repo.ListarPorIdRepo(id);
        if (i != null) {
            return i;
        }
        throw new Exception("Item não encontrado");
    }

    public ItemRepo CadastrarItem(Item item) {
        repo.AdicionarRepo(item);
        return repo;
    }

    public ItemRepo CadastrarItem(int id, int preco, String descricao, TamanhoItem tamanho, int quantidade, Fornecedor fornecedor) {
        Item item = new Item(id, preco, descricao, tamanho, quantidade, fornecedor);
        repo.AdicionarRepo(item);
        return repo;
    }
}
