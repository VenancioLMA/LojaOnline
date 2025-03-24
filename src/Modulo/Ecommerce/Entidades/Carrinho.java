package Modulo.Ecommerce.Entidades;

import Modulo.SGE.Estoque.Entity.Item;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    int id;
    String descricao;
    List<Item> carrinho = new ArrayList<Item>();

}
