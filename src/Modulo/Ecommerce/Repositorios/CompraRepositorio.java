package Modulo.Ecommerce.Repositorios;

import Modulo.Ecommerce.Entidades.Compra;
import java.util.ArrayList;
import java.util.List;

public class CompraRepositorio {

    private List<Compra> compras = new ArrayList<>();
    private int proximoId = 1;

    // Método para adicionar uma nova compra
    public void adicionarCompra(Compra compra) {
        // Atribuindo um ID à compra antes de adicioná-la
        compra.setId(proximoId++);
        compras.add(compra);
    }

    // Método para remover uma compra
    public void removerCompra(Compra compra) {
        compras.remove(compra);
    }

    // Método para buscar uma compra pelo ID
    public Compra buscarCompraPorId(int id) {
        for (Compra compra : compras) {
            if (compra.getId() == id) {
                return compra;
            }
        }
        return null; // Retorna null se a compra não for encontrada
    }

    // Método para listar todas as compras
    public List<Compra> listarCompras() {
        return new ArrayList<>(compras);
    }

    // Método para atualizar uma compra existente
    public void atualizarCompra(Compra compra) {
        for (int i = 0; i < compras.size(); i++) {
            if (compras.get(i).getId() == compra.getId()) {
                compras.set(i, compra);
                break;
            }
        }
    }
}