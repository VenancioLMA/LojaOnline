package Modulo.Ecommerce.Serviços;


import Modulo.Commons.Interfaces.IService;

import java.io.Serializable;
import java.util.List;

public class ServicoPagamento implements IService{
    @Override
    public void Adicionar(Object i) {

    }

    @Override
    public void Remover(int id) throws Exception {

    }

    @Override
    public void Alterar(int id, Object chave, Object novoValor) {

    }

    @Override
    public List ListarTodos() {
        return List.of();
    }

    @Override
    public Object ListarPorId(int id) throws Exception {
        return null;
    }

    public enum MetodoPagamento {
        Credito, Debito, Pix,
    }
    public boolean processarPagamento(double valor, MetodoPagamento metodo) {
        if (valor <= 0) {
            System.out.println("Valor inválido para pagamento.");
            return false;
        }
        try {
            switch (metodo) {
                case Debito:
                    return pagarCredito(valor);
                case Credito:
                    return pagarDebito(valor);
                case Pix:
                    return pagarPix(valor);
                default:
                    System.out.println("Método de pagamento inválido.");
                    return false;
            }
        } catch (Exception e) {
            System.out.println("Erro ao processar pagamento: " + e.getMessage());
            return false;
        }
    }
    private boolean pagarCredito(double valor) {
        //CREDITO
        System.out.println("Pagamento de R$" + valor + " realizado no crédito.");
        return true;
    }
    private boolean pagarDebito(double valor) {
        //DEBITO
        System.out.println("Pagamento de R$" + valor + " realizado no débito.");
        return true;
    }
    private boolean pagarPix(double valor) {
        //PIX
        System.out.println("Pagamento de R$" + valor + " realizado via PIX.");
        return true;
    }
}