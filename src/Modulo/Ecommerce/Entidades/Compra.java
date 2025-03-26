package Modulo.Ecommerce.Entidades;


import Modulo.Ecommerce.Serviços.ServicoPagamento;

public class Compra {
    private ClienteCad cliente;
    private Carrinho carrinho;
    private ServicoPagamento.MetodoPagamento metodoPagamento;
    private boolean compra;

    public Compra(boolean compra, ClienteCad cliente, Carrinho carrinho) {
        this.compra = compra;
        this.cliente = cliente;
        this.carrinho = carrinho;
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

        if (compra == false){
            System.out.println("Compra Cancelada");

        }

    }






}
