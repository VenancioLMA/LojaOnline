package Modulo.Utils;

import Modulo.Commons.Endereco;
import Modulo.SGE.Estoque.Entity.Estoque;
import Modulo.SGE.Estoque.Entity.Fornecedor;
import Modulo.SGE.Estoque.Entity.Item;
import Modulo.SGE.Estoque.Enum.TamanhoItem;
import Modulo.SGE.Funcionarios.Entidades.*;
import Modulo.SGE.Funcionarios.Enum.Sexo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class Funcs {

    static final SimpleDateFormat formatoEntrada = new SimpleDateFormat("dd/MM/yyyy");
    static final SimpleDateFormat formataSaida = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy", new Locale("pt", "BR"));

    static final Random random = new Random();

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

        int id = geraIDAleatorio();
        String nomeEmpresa = NOMES_EMPRESAS[random.nextInt(NOMES_EMPRESAS.length)];
        String email = nomeEmpresa.toLowerCase().replace(" ", "") + "@contato.com.br";
        String cnpj = gerarCNPJ();
        Endereco endereco = geraEnderecoAleatorio();

        return new Fornecedor(id, email, cnpj, nomeEmpresa, endereco);
    }

    public static Item geraItemComFornecedor() {
        Item i = new Item(gerarCamisaAleatoria(gerarFornecedorAleatorio()));
        return i;
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

    public static int geraIDAleatorio() {
        int id;
        return id = random.nextInt(100);
    }

    public static Endereco geraEnderecoAleatorio() {
        final String[] RUAS = {
                "Avenida Paulista", "Rua das Flores", "Avenida Brasil",
                "Rua XV de Novembro", "Rua Sete de Setembro", "Avenida Independência"
        };

        String rua = RUAS[random.nextInt(RUAS.length)];
        String numero = String.valueOf(random.nextInt(1000) + 1); // Números de 1 a 1000
        String cep = gerarCEP();

        return new Endereco(rua, numero, cep);
    }

    public static Date formataDataEntrada(String data) throws ParseException {
        Date dataConvertida = formatoEntrada.parse(data);
        return dataConvertida;
    }

    public static String formataDataSaida(Date i) {
        return formataSaida.format(i);
    }

}
