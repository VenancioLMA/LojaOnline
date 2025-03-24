package Modulo.SGE.Servico;

import Modulo.SGE.Estoque.Entity.Estoque;
import Modulo.SGE.Estoque.Entity.Item;
import Modulo.SGE.Estoque.Repository.EstoqueRepo;

import java.util.List;

import static Modulo.Utils.Funcs.gerarEstoqueAleatorio;

public class VerificaEstoque {
    public static List<Estoque> VerificaEstoque(){
        EstoqueRepo estoqueRepo = new EstoqueRepo();
        estoqueRepo.add(gerarEstoqueAleatorio());

        return estoqueRepo.listAll();
    }
}
