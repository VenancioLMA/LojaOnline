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

    public static Item gerarItemAleatorio(Fornecedor fornecedor) {
        final String[] TIPOS_ITENS = {"Camisa", "Calça", "Sapato", "Jaqueta", "Bermuda"};
        final String[] CORES = {"Azul", "Branco", "Preto", "Verde", "Vermelho", "Cinza"};
        final String[] ESTILOS = {"Casual", "Esportivo", "Social", "Xadrez", "Liso"};
        final TamanhoItem[] TAMANHOS = TamanhoItem.values();


        String desc = TIPOS_ITENS[random.nextInt(TIPOS_ITENS.length)] + " " + ESTILOS[random.nextInt(ESTILOS.length)] + " " + CORES[random.nextInt(CORES.length)];

        return new Item(
                random.nextInt(100),
                random.nextInt(151) + 50,
                desc,
                TAMANHOS[random.nextInt(TAMANHOS.length)],
                random.nextInt(51) + 10,
                fornecedor
        );
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

    public static Funcionario gerarFuncionarioAleatorio() throws ParseException {
        final String[][] DADOS = {
                {"Carlos Silva", "carlos@email.com", "Masculino"},
                {"Mariana Souza", "mariana@email.com", "Feminino"},
                {"João Pereira", "joao@email.com", "Masculino"},
                {"Ana Oliveira", "ana@email.com", "Feminino"},
                {"Roberto Lima", "roberto@email.com", "Masculino"}
        };

        final String[] CPFS = {"12345678900", "98765432100", "45612378900", "32165498700", "78945612300"};
        final String[] DATAS_NASC = {"1990/05/12", "1985/08/22", "1993/11/30", "2000/07/19", "1997/04/25"};
        final Class<?>[] TIPOS_FUNCIONARIOS = {Financeiro.class, Estoquista.class, Afiliado.class, Administrativo.class};

        int index = random.nextInt(DADOS.length);
        int id = random.nextInt(1000);
        String nome = DADOS[index][0];
        String email = DADOS[index][1];
        Sexo sexo = Sexo.valueOf(DADOS[index][2]);
        String cpf = CPFS[index];
        String dataNascimento = DATAS_NASC[index];
        int salario = random.nextInt(5000) + 2000; // Salário entre 2000 e 7000
        Class<?> tipoFuncionario = TIPOS_FUNCIONARIOS[random.nextInt(TIPOS_FUNCIONARIOS.length)];

        try {
            if (tipoFuncionario == Financeiro.class) {
                return new Financeiro(id, nome, email, sexo, cpf, dataNascimento, salario);
            } else if (tipoFuncionario == Estoquista.class) {
                return new Estoquista(id, nome, email, sexo, cpf, dataNascimento, salario);
            } else if (tipoFuncionario == Afiliado.class) {
                return new Afiliado(id, nome, email, sexo, cpf, dataNascimento, salario);
            } else if (tipoFuncionario == Administrativo.class) {
                return new Administrativo(id, nome, email, sexo, cpf, dataNascimento, salario);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static Estoque gerarEstoqueAleatorio(){
        Estoque estoque = new Estoque(random.nextInt(100));
        estoque.adicionarItem(geraItemComFornecedor());
        return estoque;
    }


    public static Item geraItemComFornecedor() {
        Item i = new Item(gerarItemAleatorio(gerarFornecedorAleatorio()));
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
