package Modulo.SGE.Entity;

import Modulo.Commons.Endereco;
import Modulo.SGE.Entity.PessoaJuridica.PJ;

public class Fornecedor extends PJ {
    public int id;

    public Fornecedor(int id, String email, String cnpj, String razaoSocial, Endereco endereco) {
        super(email, cnpj, razaoSocial, endereco);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Fornecedor{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", razaoSocial='" + razaoSocial + '\'' +
                ", endereco=" + endereco +
                '}';
    }
}
