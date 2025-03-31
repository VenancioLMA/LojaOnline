package Modulo.Entrega;

import Modulo.Commons.Endereco;
import Modulo.Ecommerce.Entidades.ClienteCad;
import Modulo.SGE.Funcionarios.Entidades.Entregador;

import java.util.Stack;

// EntregaService.java
public class EntregaService {
    private EntregaRepo repository = new EntregaRepo();

    // Cria uma nova entrega e a coloca no topo da pilha
    public void criarEntrega(int id, ClienteCad cliente, Endereco endereco, StatusEntrega status, Entregador entregador) {
        EntregaModel novaEntrega = new EntregaModel(id, cliente, endereco, status, entregador);
        repository.salvar(novaEntrega);
    }

    public void atualizarStatus(int id, StatusEntrega novoStatus) {
        EntregaModel entrega = repository.buscarPorId(id);
        if (entrega != null) {
            entrega.setStatus(novoStatus);
        }
    }

    public void processarProximaEntrega() {
        EntregaModel entrega = repository.removerDoTopo();
        if (entrega != null) {
            System.out.println("Entrega " + entrega.getId() + " processada.");
        }
    }

    public EntregaModel consultarProximaEntrega() {
        return repository.consultarTopo();
    }

    public void listarEntregas() {
        Stack<EntregaModel> entregas = repository.listarTodos();
        for (EntregaModel entrega : entregas) {
            System.out.println("Entrega ID: " + entrega.getId() + " - Status: " + entrega.getStatus());
        }
    }
}