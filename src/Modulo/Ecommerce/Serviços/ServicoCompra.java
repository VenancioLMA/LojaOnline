package Modulo.Ecommerce.Serviços;

import Modulo.Ecommerce.Entidades.Compra;
import Modulo.Ecommerce.Entidades.ClienteCad;
import Modulo.Ecommerce.Entidades.Carrinho;
import Modulo.Ecommerce.Repositorios.CompraRepositorio;

import java.util.List;

public class ServicoCompra {

    private CompraRepositorio compraRepositorio;

    public ServicoCompra(CompraRepositorio compraRepositorio) {
        this.compraRepositorio = compraRepositorio;
    }

    public Compra criarCompra(ClienteCad cliente, Carrinho carrinho) {
        Compra compra = new Compra(false, cliente, carrinho);
        compraRepositorio.adicionarCompra(compra);
        return compra;
    }

    public boolean finalizarCompra(int compraId, ServicoPagamento.MetodoPagamento metodoPagamento) {
        Compra compra = compraRepositorio.buscarCompraPorId(compraId);
        if (compra != null) {
            compra.setMetodoPagamento(metodoPagamento);
            compra.finalizarCompra();
            compraRepositorio.atualizarCompra(compra);
            return compra.getCompra();
        }
        return false;
    }

    public void cancelarCompra(int compraId) {
        Compra compra = compraRepositorio.buscarCompraPorId(compraId);
        if (compra != null) {
            compra.setCompra(false);
            compraRepositorio.atualizarCompra(compra);
        }
    }

    public Compra buscarCompraPorId(int compraId) {
        return compraRepositorio.buscarCompraPorId(compraId);
    }

    public List<Compra> listarCompras() {
        return compraRepositorio.listarCompras();
    }

    public void removerCompra(int compraId) {
        Compra compra = compraRepositorio.buscarCompraPorId(compraId);
        if (compra != null) {
            compraRepositorio.removerCompra(compra);
        }
    }
}