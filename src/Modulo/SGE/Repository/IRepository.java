package Modulo.SGE.Repository;

import Modulo.Commons.Endereco;
import Modulo.SGE.Entity.Fornecedor;

import java.util.List;

public interface IRepository<T> {

    T add(T i);

    boolean remove(int id);

    T update(int id, Object key, Object newValue);

    T listOne(int id);

    List<T> listAll();

}