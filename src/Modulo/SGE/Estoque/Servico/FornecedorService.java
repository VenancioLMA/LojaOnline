package Modulo.SGE.Estoque.Servico;

import Modulo.Commons.Endereco;
import Modulo.SGE.Estoque.Entity.Fornecedor;
import Modulo.SGE.Estoque.Repository.FornecedorRepo;

import java.util.List;

public class FornecedorService {
    private final FornecedorRepo repo;

    public FornecedorRepo CadastrarItemAleatorio(Fornecedor fornecedor) {
        repo.Adicionar(fornecedor);
        return repo;
    }

    public FornecedorService(FornecedorRepo repo) {
        this.repo = repo;
    }

    public FornecedorRepo CadastrarFornecedor(int id, String email, String cnpj, String razaoSocial, Endereco endereco) {
        Fornecedor i = new Fornecedor(id, email, cnpj, razaoSocial, endereco);
        repo.Adicionar(i);
        return repo;
    }

    public List<Fornecedor> ListarTodosFornecedor() {
        return repo.ListarTodos();
    }

    public Fornecedor ListarFornecedorPorId(int id) throws Exception {
        Fornecedor i = repo.ListarPorId(id);
        if (i != null) {
            return i;
        }
        throw new Exception("Fornecedor não encontrado");
    }


    public FornecedorRepo RemoverFornecedor(int id) throws Exception {
        if (!repo.Remover(id)) {
            throw new Exception("Fornecedor não encontrado");
        }
        return repo;
    }

    public FornecedorRepo AtualizarFornecedor(int id, String atributo, Object novoValor) {
        repo.Atualizar(id, atributo, novoValor);
        return repo;
    }
}
