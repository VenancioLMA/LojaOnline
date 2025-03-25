import Modulo.MODELOBASE.ModeloLivro;
import Modulo.MODELOBASE.ModeloLivroRepositorio;
import Modulo.MODELOBASE.ModeloLivroService;
import Modulo.SGE.Estoque.Servico.EstoqueService;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

import static Modulo.Utils.Funcs.gerarEstoqueAleatorio;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
//        Sistema.iniciar();

//        EstoqueService estoqueService = new EstoqueService(gerarEstoqueAleatorio(5));
//        System.out.println(estoqueService.ListarTodosItemsDentroDoEstoque());
//        System.out.println(estoqueService.ListarItemDentroDoEstoquePorIdDoItem(sc.nextInt()));

        // inicio do sistema ecommerce

        // listar todos itens disponiveis no estoque (FEITO)

        // usuario escolhe os itens do carrinho

        // usuario escolhe a forma de pagamento

        // compra eh montada

        // verifica se a forma de pagamento eh valida

        // compra eh enviada para o estoque

        // estoque confirma o recebimento

        // estoque envia o item


        // Criamos uma instância da classe ModeloLivro, representando um livro no sistema
        Date date = new Date(121, 6, 22); // Data fixa para exemplo
        ModeloLivro modeloLivro = new ModeloLivro(7, "Verity", date);

        // Criamos o repositório responsável pelo armazenamento dos livros
        ModeloLivroRepositorio modeloLivroRepositorio = new ModeloLivroRepositorio();

        // Adicionamos o livro ao repositório
        modeloLivroRepositorio.Adicionar(modeloLivro);

        // Criamos um serviço para intermediar a comunicação entre a aplicação e o repositório
        ModeloLivroService modeloLivroService = new ModeloLivroService(modeloLivroRepositorio);

        // Cadastramos um novo livro através do serviço
        modeloLivroService.CadastrarLivro(8, "O Jogo", date);

        // Exibimos todos os livros cadastrados no sistema
        System.out.println(modeloLivroService.ListarTodosItens());

        // Exibimos um livro específico pelo seu ID
        System.out.println(modeloLivroService.ListarItemPorId(8));
    }
}