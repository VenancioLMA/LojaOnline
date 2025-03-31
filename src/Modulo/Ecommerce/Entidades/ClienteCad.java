package Modulo.Ecommerce.Entidades;

import Modulo.Commons.Endereco;

public class ClienteCad {
    private int idCliente;
    private String nome;
    private String cpf;
    private String dataNascimento;
    private String sexo;
    private String telefone;
    private Endereco endereco;
    private String email;
    private Carrinho carrinho;

    public ClienteCad(int idCliente, String nome, String cpf, String dataNascimento, String sexo, String telefone, Endereco endereco, String email) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.telefone = telefone;
        this.endereco = endereco;
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco enderecos) {
        this.endereco = enderecos;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    @Override
    public String toString() {
        return "Cliente Cadastrado:\n" +
                "ID Cliente: " + idCliente + "\n" +
                "Nome: " + nome + "\n" +
                "CPF: " + cpf + "\n" +
                "Data de Nascimento: " + dataNascimento + "\n" +
                "Sexo: " + sexo + "\n" +
                "Telefone: " + telefone + "\n" +
                "Endereços: " + "\n" +
                "Email: " + email + "\n" +
                "Carrinho: " + carrinho + "\n";
    }

}
