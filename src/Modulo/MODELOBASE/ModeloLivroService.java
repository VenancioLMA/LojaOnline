package Modulo.MODELOBASE;

import java.util.Date;
import java.util.List;

public class ModeloLivroService {
    private final ModeloLivroRepositorio repositorio;


    public ModeloLivroService(ModeloLivroRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    // Cadastra um novo livro no sistema
    public ModeloLivroRepositorio CadastrarLivro(int id, String nome, Date dataLancamento) {
        ModeloLivro modeloLivro = new ModeloLivro(id, nome, dataLancamento);
        repositorio.Adicionar(modeloLivro);
        return repositorio;
    }

    // Retorna todos os livros cadastrados
    public List<ModeloLivro> ListarTodosItens() {
        return repositorio.ListarTodos();
    }


    // Busca um livro pelo seu ID, lançando uma exceção se não for encontrado
    public ModeloLivro ListarItemPorId(int id) throws Exception {
        ModeloLivro modeloLivro = repositorio.ListarPorId(id);
        if (modeloLivro != null) {
            return modeloLivro;
        }
        throw new Exception("Livro nao encontrado");
    }

    // Remove um livro do sistema
    public ModeloLivroRepositorio RemoverItem(int id) throws Exception {
        if (!repositorio.Remover(id)) {
            throw new Exception("Livro não encontrado");
        }
        return repositorio;
    }

    // Atualiza um atributo de um livro específico
    public ModeloLivroRepositorio EditarItem(int id, String atributo, Object novoValor) {
        repositorio.Atualizar(id, atributo, novoValor);
        return repositorio;
    }

    @Override
    public String toString() {
        return "ModeloLivroService{" +
                "repositorio=" + repositorio +
                '}';
    }
}
