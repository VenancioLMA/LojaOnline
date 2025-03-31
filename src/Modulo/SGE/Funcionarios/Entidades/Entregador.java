package Modulo.SGE.Funcionarios.Entidades;

import Modulo.SGE.Funcionarios.Enum.Sexo;

import java.text.ParseException;

public class Entregador extends Funcionario {

    public Entregador(int id, String nome, String email, Sexo sexo, String cpf, String dataDeNascimento, int salario) throws ParseException {
        super(id, nome, email, sexo, cpf, dataDeNascimento, salario);
    }

    @Override
    protected double calcularSalarioFuncionario(int i) {
        return i;
    }
}
