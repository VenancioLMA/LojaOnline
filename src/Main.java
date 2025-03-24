import Modulo.SGE.Funcionarios.Entidades.Afiliado;
import Modulo.SGE.Funcionarios.Entidades.Estoquista;
import Modulo.SGE.Funcionarios.Enum.Sexo;
import Modulo.SGE.Funcionarios.Repositorio.FuncRepo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws ParseException {

//        Sistema.iniciar();

        FuncRepo funcRepo = new FuncRepo();
        String date = "24/03/2002";

        Afiliado afiliado = new Afiliado(1, "Arlei Nascimento", "arlei@gmail.com", Sexo.Masculino, "71527256405", date, 0);
        Estoquista estoquista = new Estoquista(2, "Laxus", "laxus@gmail.com", Sexo.Masculino, "11111111105", date, 0);

        funcRepo.add(afiliado);
        funcRepo.add(estoquista);

        System.out.println(funcRepo.listAll());
    }
}
