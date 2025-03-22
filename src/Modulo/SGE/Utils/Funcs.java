package Modulo.SGE.Utils;

import Modulo.SGE.Entity.Endereco;
import Modulo.SGE.Entity.Estoque;
import Modulo.SGE.Entity.Fornecedor;
import Modulo.SGE.Entity.Item;
import Modulo.SGE.Enum.TamanhoItem;

import java.util.ArrayList;
import java.util.Random;

public class Funcs {
    static final Random random = new Random();

    public static ArrayList<Estoque> ListarItensEstoque(Estoque estoque) {
        ArrayList<Estoque> itens = new ArrayList<>();
        itens.add(estoque);
        return itens;
    }

    public static Item gerarCamisaAleatoria(Fornecedor fornecedor) {
        final String[] NOMES_CAMISAS = {
                "Camisa Polo Azul", "Camisa Social Branca", "Camisa Esportiva Preta",
                "Camisa Casual Verde", "Camisa Xadrez Vermelha"
        };

        final TamanhoItem[] TAMANHOS = TamanhoItem.values();

        int id = random.nextInt(100); // Preço entre 50 e 200
        int preco = random.nextInt(151) + 50; // Preço entre 50 e 200
        String descricao = NOMES_CAMISAS[random.nextInt(NOMES_CAMISAS.length)];
        TamanhoItem tamanho = TAMANHOS[random.nextInt(TAMANHOS.length)];
        int quantidade = random.nextInt(51) + 10; // Estoque entre 10 e 60

        return new Item(id, preco, descricao, tamanho, quantidade, fornecedor);
    }

    public static Fornecedor gerarFornecedorAleatorio() {
        final String[] NOMES_EMPRESAS = {
                "Andretti Clothing", "FashionX", "Top Style", "Urban Wear", "Elite Moda"
        };

        final String[] NOMES_RUAS = {
                "Avenida Paulista", "Rua das Flores", "Alameda Santos", "Avenida Brasil", "Rua XV de Novembro"
        };

        String nomeEmpresa = NOMES_EMPRESAS[random.nextInt(NOMES_EMPRESAS.length)];
        String email = nomeEmpresa.toLowerCase().replace(" ", "") + "@contato.com.br";
        String cnpj = gerarCNPJ();

        Endereco endereco = new Endereco(
                NOMES_RUAS[random.nextInt(NOMES_RUAS.length)],
                String.valueOf(random.nextInt(500) + 1), // Número entre 1 e 500
                gerarCEP()
        );

        return new Fornecedor(email, cnpj, nomeEmpresa, endereco);
    }

    private static String gerarCNPJ() {
        return String.format("%02d%03d%03d%04d%02d",
                random.nextInt(100), random.nextInt(1000),
                random.nextInt(1000), random.nextInt(10000),
                random.nextInt(100));
    }

    private static String gerarCEP() {
        return String.format("%05d%03d", random.nextInt(100000), random.nextInt(1000));
    }

    public static void imprimirEstoque(Estoque<Item> estoque) {
        int i = 0;
        for (Item item : estoque.getItems()) {

            System.out.println("🔹 Numero do produto: " + item.getId());
            System.out.println("🛒 Produto: " + item.getDescricao());
            System.out.println("💰 Preço: R$ " + item.getPreco());
            System.out.println("📏 Tamanho: " + item.getTamanho());
            System.out.println("📦 Quantidade: " + item.getQuantidade());

            Fornecedor fornecedor = item.getFornecedor();
            System.out.println("\n🔹 Fornecedor: " + fornecedor.getRazaoSocial());
            System.out.println("📧 Contato: " + fornecedor.getEmail());
            System.out.println("🏢 CNPJ: " + fornecedor.getCnpj());

            Endereco endereco = fornecedor.getEndereco();

            System.out.println("📍 Endereço: " + endereco.toString());
            System.out.println();
            System.out.println("====================================\n");
        }
    }

    public static int geraIDAleatorio() {
        int id;
        return id = random.nextInt(100);
    }

}
