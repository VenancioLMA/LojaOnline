package Modulo.Entrega;

import Modulo.Commons.Endereco;
import Modulo.Commons.Enums.Status;
import Modulo.Ecommerce.Entidades.Carrinho;
import Modulo.Ecommerce.Entidades.ClienteCad;
import Modulo.SGE.Funcionarios.Entidades.Entregador;

public class EntregaModel {
    private int id;
    private ClienteCad clienteCad;
    private Carrinho carrinho;
    private Endereco endereco;
    private StatusEntrega status;
    private Entregador entregador;

    public EntregaModel(int id, ClienteCad clienteCad, Endereco endereco, StatusEntrega status, Entregador entregador) {
        this.id = id;
        this.clienteCad = clienteCad;
        this.endereco = clienteCad.getEndereco();
        this.carrinho = clienteCad.getCarrinho();
        this.entregador = entregador;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ClienteCad getClienteCad() {
        return clienteCad;
    }

    public void setClienteCad(ClienteCad clienteCad) {
        this.clienteCad = clienteCad;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public StatusEntrega getStatus() {
        return status;
    }

    public void setStatus(StatusEntrega status) {
        this.status = status;
    }

    public Entregador getEntregador() {
        return entregador;
    }

    public void setEntregador(Entregador entregador) {
        this.entregador = entregador;
    }

    @Override
    public String toString() {
        return "EntregaModel{" +
                "id='" + id + '\'' +
                ", clienteCad=" + clienteCad +
                ", carrinho=" + carrinho +
                ", endereco=" + endereco +
                ", status=" + status +
                ", entregador=" + entregador +
                '}';
    }
}
