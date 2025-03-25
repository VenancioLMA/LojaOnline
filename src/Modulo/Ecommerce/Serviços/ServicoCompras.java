package Modulo.Ecommerce.Serviços;
import Modulo.Ecommerce.Entidades.Carrinho;
import Modulo.Ecommerce.Repositorios.RepoCarrinho;
import Modulo.SGE.Estoque.Entity.Estoque;
import Modulo.SGE.Estoque.Entity.Item;

import java.util.ArrayList;
import java.util.List;

public class ServicoCompras {
  private List<Item> itemArraylist;
  private List<Carrinho> carrinhos;
  private List<Carrinho> carrinho;

  public ServicoCompras() {
      this.itemArraylist = new ArrayList<>();
      this.carrinhos = new ArrayList<>();

  }
  public void adicionarItem(Carrinho carrinho) {
      this.carrinhos.add(carrinho);
  }
  public void removerItem(Carrinho carrinho) {
      this.carrinhos.remove(carrinho);
  }
    public void alterarItem(Carrinho carrinho) {
        int index = carrinhos.indexOf(carrinho);
        if (index != -1) {
            this.carrinhos.set(index, carrinho);
            System.out.println("Carrinho atualizado.");
        } else {
            System.out.println("Carrinho não encontrado.");
        }
    }

  public List<ServicoCompras> listAll() {
        return List.of();
    }

    public void verificarItem(Carrinho carrinho) {
      verificarItem(Carrinho carrinho);
    }
    public void verificarEstoque(Estoque estoque) {
      verificarEstoque(Estoque estoque);
    }

  public double calculaValorTotal() {
      double total = 0;
      for (Item item : itemArraylist) {
          total += item.getPreco();
      }
      return total;
  }
    public void finalizarCompra() {
        if (carrinho.isEmpty()) {
            System.out.println("Carrinho vazio. Adicione itens antes de finalizar a compra.");
            return;
        }

        System.out.println("Compra feita! Total: R$" + calcularTotal());
        carrinho.clear();
    }

    private String calcularTotal() {
        return "";
    }
}









   }





