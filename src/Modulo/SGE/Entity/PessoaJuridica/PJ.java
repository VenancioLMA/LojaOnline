package Modulo.SGE.Entity.PessoaJuridica;

import Modulo.Commons.Endereco;

public abstract class PJ {
    protected String email;
    protected String cnpj;
    protected String razaoSocial;
    protected Endereco endereco;

    public PJ(String email, String cnpj, String razaoSocial, Endereco endereco) {
        this.email = email;
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
