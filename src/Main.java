import Modulo.Ecommerce.Entidades.Carrinho;
import Modulo.Ecommerce.Serviços.ServicoCompras;
import Modulo.Ecommerce.Serviços.ServicoPagamento;
import Modulo.SGE.Estoque.Entity.Item;
import Modulo.SGE.Estoque.Enum.TamanhoItem;
import Modulo.SGE.Estoque.Repository.EstoqueRepo;
import Modulo.SGE.Estoque.Entity.Fornecedor;

import java.text.ParseException;
import static Modulo.SGE.Servico.VerificaEstoque.VerificaEstoque;

public class Main {
    public static void main(String[] args) throws ParseException {

//        Sistema.iniciar();

        // inicio do sistema ecommerce

        // listar todos itens disponiveis no estoque
        //Ok
        // usuario escolhe os itens do carrinho
        //Ok
        // usuario escolhe a forma de pagamento
        //Ok
        // compra eh montada

        ServicoCompras servicoCompras = new ServicoCompras();



            ServicoPagamento servicoPagamento = new ServicoPagamento();

            double valorCompra = 500.00;

            //servicoPagamento.processarPagamento(valorCompra, ServicoPagamento.MetodoPagamento.Credito);

            //servicoPagamento.processarPagamento(valorCompra, ServicoPagamento.MetodoPagamento.Debito);

            //servicoPagamento.processarPagamento(valorCompra, ServicoPagamento.MetodoPagamento.Pix);





            //


            System.out.println(VerificaEstoque());
        }
    }
