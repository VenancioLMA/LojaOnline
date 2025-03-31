import Modulo.Commons.Endereco;
import Modulo.Ecommerce.Entidades.Carrinho;
import Modulo.Ecommerce.Entidades.ClienteCad;
import Modulo.Ecommerce.Entidades.Compra;
import Modulo.Ecommerce.Repositorios.CompraRepositorio;
import Modulo.Ecommerce.Repositorios.RepositorioCliente;
import Modulo.Ecommerce.Serviços.ServicoCompra;
import Modulo.Ecommerce.Serviços.ServicoPagamento;
import Modulo.Entrega.EntregaService;
import Modulo.Entrega.StatusEntrega;
import Modulo.SGE.Estoque.Entity.Item;
import Modulo.SGE.Estoque.Servico.EstoqueService;
import Modulo.SGE.Funcionarios.Entidades.Entregador;
import Modulo.Utils.Funcs;

//
import Modulo.SGE.Funcionarios.Enum.Sexo;
import java.text.ParseException;
//

import java.util.List;
import java.util.Scanner;

import static Modulo.Utils.Funcs.geraIDAleatorio;
import static Modulo.View.SGETela.*;

public class Main {

    public static void main(String[] args) {
        animarTexto("Sistema de E-commerce iniciado.", 80);

        EstoqueService estoqueService = new EstoqueService(Funcs.gerarEstoqueAleatorio(5));

        animarTexto("Itens disponíveis no estoque:", 80);
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

        limparTela();

        animarTexto("\n--- Cadastro do Cliente ---", 80);
        sc.nextLine(); // Limpar o buffer do scanner
        animarTexto("Nome: ", 70);
        String nome = sc.nextLine();
        animarTexto("CPF: ", 70);
        String cpf = sc.nextLine();
        animarTexto("Data de Nascimento (dd/MM/yyyy): ", 70);
        String dataNascimento = sc.nextLine();
        animarTexto("Sexo (Masculino/Feminino): ", 70);
        String sexo = sc.nextLine();
        animarTexto("Telefone: ", 70);
        String telefone = sc.nextLine();
        animarTexto("Email: ", 70);
        String email = sc.nextLine();
        animarTexto("Endereço (Rua): ", 70);
        String rua = sc.nextLine();
        animarTexto("Endereço (Num): ", 70);
        String num = sc.nextLine();
        animarTexto("Endereço (CEP): ", 70);
        String cep = sc.nextLine();

        Endereco endereco = new Endereco(rua, num, cep);

        ClienteCad cliente = new ClienteCad(geraIDAleatorio(), nome, cpf, dataNascimento, sexo, telefone, endereco, email);
        cliente.setCarrinho(carrinho);

        RepositorioCliente repositorioCliente = new RepositorioCliente();
        repositorioCliente.AdicionarRepo(cliente);
        animarTexto("\nCliente cadastrado com suscesso", 70);

        pausar(25);

        limparTela();
        // Usuário escolhe a forma de pagamento
        animarTexto("\nEscolha a forma de pagamento (1 - Cartão, 2 - Boleto, 3 - Pix):", 40);
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
        }

        exibirTextoComAnimacao("Concluindo pagamento", 5000);

        CompraRepositorio compraRepositorio = new CompraRepositorio();
        ServicoCompra servicoCompra = new ServicoCompra(compraRepositorio);
        Compra compra = servicoCompra.criarCompra(cliente, carrinho);

        boolean compraFinalizada = servicoCompra.finalizarCompra(compra.getId(), metodoPagamento);

        if (compraFinalizada) {
            System.out.println("Compra finalizada com sucesso!");

            System.out.println("\nEnviando compra para o estoque...");

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


        EntregaService entregaService = new EntregaService();

        try {
            Entregador entregador = new Entregador(
                    1, // ID do entregador
                    "João Silva", // Nome do entregador
                    "joao.silva@entregador.com", // Email do entregador
                    Sexo.Masculino, // Sexo do entregador
                    "123.456.789-00", // CPF do entregador
                    "01/01/1990", // Data de nascimento do entregador
                    2500 // Salário do entregador
            );

            int idEntrega = geraIDAleatorio();
            entregaService.criarEntrega(idEntrega, cliente, cliente.getEndereco(), StatusEntrega.EmRota, entregador);

            System.out.println("\n--- Processando Entrega ---");
            while (!carrinho.getItems().isEmpty()) {
                Item item = carrinho.getItems().get(0);
                System.out.println("Entregando item: " + item.getDescricao());
                carrinho.getItems().remove(0);
                pausar(1000);
            }

            entregaService.atualizarStatus(idEntrega, StatusEntrega.Finalizada);
            System.out.println("Entrega finalizada com sucesso!");

            // Exibe os detalhes da entrega
            System.out.println("\n--- Detalhes da Entrega ---");
            System.out.println("ID da Entrega: " + idEntrega);
            System.out.println("Cliente: " + cliente.getNome());
            System.out.println("Endereço: " + cliente.getEndereco().toString());
            System.out.println("Entregador: " + entregador.getNome());
            System.out.println("Status: " + StatusEntrega.Finalizada);

        } catch (ParseException e) {
            System.out.println("Erro ao criar o entregador: " + e.getMessage());
        }
    }
}