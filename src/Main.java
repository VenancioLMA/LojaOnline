import Modulo.Commons.Endereco;
import Modulo.Ecommerce.Entidades.Carrinho;
import Modulo.Ecommerce.Entidades.ClienteCad;
import Modulo.Ecommerce.Entidades.Compra;
import Modulo.Ecommerce.Repositorios.CompraRepositorio;
import Modulo.Ecommerce.Repositorios.RepositorioCliente;
import Modulo.Ecommerce.Serviços.ServicoCompra;
import Modulo.Ecommerce.Serviços.ServicoPagamento;
import Modulo.SGE.Estoque.Entity.Item;
import Modulo.SGE.Estoque.Servico.EstoqueService;
import Modulo.Utils.Funcs;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Sistema.iniciar();

        EstoqueService estoqueService = new EstoqueService(Funcs.gerarEstoqueAleatorio(5));

        System.out.println("Itens disponíveis no estoque:");
        List<Item> itensEstoque = estoqueService.ListarTodosItemsDentroDoEstoque();
        itensEstoque.forEach(System.out::println);

        Scanner sc = new Scanner(System.in);
        Carrinho carrinho = new Carrinho();
        System.out.println("Escolha os itens pelo ID (digite -1 para parar):");
        int idItem;
        while (true) {
            System.out.print("ID do item: ");
            idItem = sc.nextInt();
            if (idItem == -1) break;
            Item item = estoqueService.ListarItemDentroDoEstoquePorIdDoItem(idItem);
            if (item != null) {
                carrinho.adicionarItem(item);
                System.out.println("Item adicionado ao carrinho.");
            } else {
                System.out.println("Item não encontrado.");
            }
        }

        System.out.println("\n--- Cadastro do Cliente ---");
        sc.nextLine(); // Limpar o buffer do scanner
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("CPF: ");
        String cpf = sc.nextLine();
        System.out.print("Data de Nascimento (dd/MM/yyyy): ");
        String dataNascimento = sc.nextLine();
        System.out.print("Sexo (Masculino/Feminino): ");
        String sexo = sc.nextLine();
        System.out.print("Telefone: ");
        String telefone = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Endereço (Rua, Número, CEP): ");
        String endereco = sc.nextLine();

        ClienteCad cliente = new ClienteCad(1, nome, cpf, dataNascimento, sexo, telefone, endereco, email);
        cliente.setCarrinho(carrinho);

        RepositorioCliente repositorioCliente = new RepositorioCliente();
        repositorioCliente.AdicionarRepo(cliente);
        System.out.println("\nCliente cadastrado com suscesso");

        // Usuário escolhe a forma de pagamento
        System.out.println("\nEscolha a forma de pagamento (1 - Cartão, 2 - Boleto, 3 - Pix):");
        int formaPagamento = sc.nextInt();
        ServicoPagamento.MetodoPagamento metodoPagamento = null;
        switch (formaPagamento) {
            case 1:
                metodoPagamento = ServicoPagamento.MetodoPagamento.Credito;
                break;
            case 2:
                metodoPagamento = ServicoPagamento.MetodoPagamento.Debito;
                break;
            case 3:
                metodoPagamento = ServicoPagamento.MetodoPagamento.Pix;
                break;
            default:
                System.out.println("Forma de pagamento inválida.");
                return;
        }

        CompraRepositorio compraRepositorio = new CompraRepositorio();
        ServicoCompra servicoCompra = new ServicoCompra(compraRepositorio);
        Compra compra = servicoCompra.criarCompra(cliente, carrinho);

        boolean compraFinalizada = servicoCompra.finalizarCompra(compra.getId(), metodoPagamento);
        if (compraFinalizada) {
            System.out.println("Compra finalizada com sucesso!");

            System.out.println("\nEnviando compra para o estoque...");
            for (Item item : carrinho.getItems()) {
                try {
                    estoqueService.Remover(item.getId()); // Remove o item do estoque
                } catch (Exception e) {
                    System.out.println("Erro ao remover item do estoque: " + e.getMessage());
                }
            }

            System.out.println("Estoque confirmou o recebimento da compra.");

            System.out.println("Estoque está enviando os itens...");
            for (Item item : carrinho.getItems()) {
                System.out.println("- Item enviado: " + item.getDescricao());
            }

            System.out.println("\n--- Detalhes da Compra ---");
            System.out.println("Cliente: " + cliente.getNome());
            System.out.println("Itens Comprados:");
            for (Item item : carrinho.getItems()) {
                System.out.println("- " + item.getDescricao() + " (R$" + item.getPreco() + ")");
            }
            System.out.println("Forma de Pagamento: " + metodoPagamento);
        } else {
            System.out.println("Erro ao finalizar a compra.");
        }

        System.out.println("\nObrigado por comprar conosco!");
    }
}

class Sistema {
    public static void iniciar() {
        System.out.println("Sistema de E-commerce iniciado.");
    }
}