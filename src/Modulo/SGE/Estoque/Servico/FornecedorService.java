package Modulo.SGE.Estoque.Servico;

import Modulo.Commons.Endereco;
import Modulo.Commons.Interfaces.IService;
import Modulo.SGE.Estoque.Entity.Estoque;
import Modulo.SGE.Estoque.Entity.Fornecedor;
import Modulo.SGE.Estoque.Repository.FornecedorRepo;

import java.util.List;

public class FornecedorService implements IService<Fornecedor> {
    private final FornecedorRepo repo;

    public FornecedorService(FornecedorRepo repo) {
        this.repo = repo;
    }

    @Override
    public void Adicionar(Fornecedor i) {
        repo.AdicionarRepo(i);
    }

    @Override
    public void Remover(int id) throws Exception {
        if (!repo.RemoverRepo(id)) {
            throw new Exception("Fornecedor não encontrado");
        }
    }

    @Override
    public void Alterar(int id, Object chave, Object novoValor) {
        repo.AtualizarRepo(id, chave, novoValor);
    }

    @Override
    public List<Fornecedor> ListarTodos() {
        return repo.ListarTodosRepo();
    }

    @Override
    public Fornecedor ListarPorId(int id) throws Exception {
        Fornecedor i = repo.ListarPorIdRepo(id);
        if (i != null) {
            return i;
        }
        throw new Exception("Fornecedor não encontrado");
    }

    public FornecedorRepo CadastrarItemAleatorio(Fornecedor fornecedor) {
        repo.AdicionarRepo(fornecedor);
        return repo;
    }

    public FornecedorRepo CadastrarFornecedor(int id, String email, String cnpj, String razaoSocial, Endereco endereco) {
        Fornecedor i = new Fornecedor(id, email, cnpj, razaoSocial, endereco);
        repo.AdicionarRepo(i);
        return repo;
    }
}
