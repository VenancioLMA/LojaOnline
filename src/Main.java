import Modulo.Ecommerce.Entidades.ClienteCad;
import Modulo.SGE.Entity.Endereco;
import Modulo.Ecommerce.Entidades.ClienteCad;
import Modulo.SGE.Entity.Endereco;
import Modulo.SGE.Entity.Item;
import static Modulo.SGE.Enum.TamanhoItem.P ;
public class Main {
    public static void main(String[] args) {

//        Sistema.iniciar();



                Endereco endereco = new Endereco("Rua dos Alfeneiros", "04", "50720000");
                ClienteCad Cliente1 = new ClienteCad(1, "A", "1", "15/02/2002", "Masculino", "12992921", "Rua dos alfeneiros, Num 04", "sdfnsdnfsifnisdf");
                System.out.println("Olha o homi do dinheiro");
                System.out.println(Cliente1.toString());
                System.out.println(endereco.toString());


                endereco.DesabilitarEndereco();

                System.out.println(endereco.toString());


            }

        }


