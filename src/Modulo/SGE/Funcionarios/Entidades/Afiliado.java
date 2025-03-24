package Modulo.SGE.Funcionarios.Entidades;

import Modulo.SGE.Funcionarios.Enum.Sexo;

import java.text.ParseException;
import java.util.Date;

import static Modulo.SGE.Utils.Funcs.formataDataSaida;
import static java.lang.Integer.parseInt;

public class Afiliado extends Funcionario {
    private String codigoAfiliado;
    private double comissao;
    private int totalVendas;

    public Afiliado(int id, String nome, String email, Sexo sexo, String cpf, String dataDeNascimento, int salario) throws ParseException {
        super(id, nome, email, sexo, cpf, dataDeNascimento, salario);
        this.codigoAfiliado = geraCodigoAfiliado();
        this.comissao = 10;
        this.totalVendas = 0;
    }

    @Override
    protected double calcularSalarioFuncionario(int i) {
        return calcularComissao();
    }

    protected double calcularComissao() {
        return this.comissao * this.totalVendas;
    }

    protected String geraCodigoAfiliado() {
        return this.nome.replaceAll("\\s+", " ") + this.cpf.substring(0, 2);
    }

    @Override
    public String toString() {
        return "Afiliado{" +
                "totalVendas=" + totalVendas +
                ", id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", sexo=" + sexo +
                ", cpf='" + cpf + '\'' +
                ", ctps='" + ctps + '\'' +
                ", dataDeNascimento=" + formataDataSaida(dataDeNascimento) +
                ", salario=" + salario +
                ", status=" + status +
                ", comissao=" + comissao +
                ", codigoAfiliado='" + codigoAfiliado + '\'' +
                '}';
    }
}
