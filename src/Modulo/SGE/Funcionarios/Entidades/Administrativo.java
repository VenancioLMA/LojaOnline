package Modulo.SGE.Funcionarios.Entidades;

import Modulo.SGE.Funcionarios.Enum.Sexo;

import java.text.ParseException;

import static Modulo.Utils.Funcs.formataDataSaida;

public class Administrativo extends Funcionario {
    public Administrativo(int id, String nome, String email, Sexo sexo, String cpf, String dataDeNascimento, int salario) throws ParseException {
        super(id, nome, email, sexo, cpf, dataDeNascimento, salario);
    }

    @Override
    protected double calcularSalarioFuncionario(int i) {
        return i;
    }

    @Override
    public String toString() {
        return "Administrativo{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", sexo=" + sexo +
                ", cpf='" + cpf + '\'' +
                ", ctps='" + ctps + '\'' +
                ", dataDeNascimento=" + formataDataSaida(dataDeNascimento) +
                ", salario=" + salario +
                ", status=" + status +
                '}';
    }
}
