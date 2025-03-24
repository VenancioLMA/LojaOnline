package Modulo.SGE.Funcionarios.Entidades;

import Modulo.Commons.Enums.Status;
import Modulo.SGE.Funcionarios.Enum.Sexo;

import java.text.ParseException;
import java.util.Date;

import static Modulo.Utils.Funcs.formataDataEntrada;

public abstract class Funcionario {
    protected int id;
    protected String nome;
    protected String email;
    protected Sexo sexo;
    protected String cpf;
    protected String ctps;
    protected Date dataDeNascimento;
    protected double salario;
    protected Status status;

    public Funcionario(int id, String nome, String email, Sexo sexo, String cpf, String dataDeNascimento, int salario) throws ParseException {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.sexo = sexo;
        this.cpf = cpf;
        this.ctps = this.cpf;
        this.dataDeNascimento = formataDataEntrada(dataDeNascimento);
        this.status = habilitarFuncionario();
        this.salario = calcularSalarioFuncionario(salario);
    }

    protected abstract double calcularSalarioFuncionario(int i);

    private Status desabilitarFuncionario() {
        return this.status = Status.Desabilitado;
    }

    private Status habilitarFuncionario() {
        return this.status = Status.Habilitado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCtps() {
        return ctps;
    }

    public void setCtps(String ctps) {
        this.ctps = ctps;
    }

    public Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(Date dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
