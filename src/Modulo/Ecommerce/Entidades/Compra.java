package Modulo.Ecommerce.Entidades;

import Modulo.Ecommerce.Serviços.ServicoPagamento;
import Modulo.Ecommerce.Entidades.Carrinho;

public class Compra {

    private int id;
    private ClienteCad cliente;
    private Carrinho carrinho;
    private ServicoPagamento.MetodoPagamento metodoPagamento;
    private boolean compra;

    public Compra(boolean compra, ClienteCad cliente, Carrinho carrinho) {
        this.compra = compra;
        this.cliente = cliente;
        this.carrinho = carrinho;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCompra(boolean compra) {
        this.compra = compra;
    }

    public boolean getCompra() {
        return compra;
    }

    public void setCliente(ClienteCad cliente) {
        this.cliente = cliente;
    }

    public ClienteCad getCliente() {
        return cliente;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setMetodoPagamento(ServicoPagamento.MetodoPagamento metodoPagamento) {
        this.metodoPagamento = metodoPagamento;

        if (metodoPagamento == null) {
            this.compra = false;
            System.out.println("Compra Cancelada: Método de pagamento inválido.");
        }
    }

    public ServicoPagamento.MetodoPagamento getMetodoPagamento() {
        return metodoPagamento;
    }

    public boolean temItensNoCarrinho() {
        return carrinho != null && !carrinho.getItems().isEmpty();
    }

    public void finalizarCompra() {
        if (!temItensNoCarrinho()) {
            System.out.println("Compra não pode ser finalizada: Carrinho vazio.");
            this.compra = false;
        } else if (metodoPagamento == null) {
            System.out.println("Compra não pode ser finalizada: Método de pagamento não selecionado.");
            this.compra = false;
        } else {
            this.compra = true;
            System.out.println("Compra finalizada com sucesso!");
        }
    }
}