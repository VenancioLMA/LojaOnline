package Modulo.SGE.Funcionarios.Entidades;

import Modulo.SGE.Funcionarios.Enum.Sexo;

import java.text.ParseException;
import java.util.Date;

import static Modulo.SGE.Utils.Funcs.formataDataSaida;

public class Estoquista extends Funcionario {
    public Estoquista(int id, String nome, String email, Sexo sexo, String cpf, String dataDeNascimento, int salario) throws ParseException {
        super(id, nome, email, sexo, cpf, dataDeNascimento, salario);
    }

    @Override
    protected double calcularSalarioFuncionario(int i) {
        return i;
    }

    @Override
    public String toString() {
        return "Estoquista{" +
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
