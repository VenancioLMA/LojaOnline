import Modulo.SGE.Entity.Endereco;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Endereco endereco = new Endereco("Rua joselita costa", "2", "50720000");

        System.out.println(endereco.toString());

        endereco.DesabilitarEndereco();

        System.out.println(endereco.toString());
    }
}
