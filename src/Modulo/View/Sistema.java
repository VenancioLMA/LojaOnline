package Modulo.View;

import Modulo.View.Interface.Tela;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Sistema {
    private static final Map<Integer, Tela> telas = new HashMap<>();

    static {
//        telas.put(1, new EcommerceTela());  // Opção 1: E-commerce
        telas.put(2, new SGETela());        // Opção 2: SGE (Sistema de Gerenciamento de Estoque)
    }

    public static void iniciar() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n======= 🏠 MENU PRINCIPAL =======");
            System.out.println("1️⃣ - Entrar no E-commerce");
            System.out.println("2️⃣ - Acessar o Sistema de Estoque");
            System.out.println("0️⃣ - Sair");
            System.out.println("=================================\n");
            System.out.print("🔷 Escolha uma opção: ");

            int opcao = scanner.nextInt();

            if (opcao == 0) {
                System.out.println("🚪 Saindo do sistema...");
                break;
            }

            Tela telaSelecionada = telas.get(opcao);

            if (telaSelecionada != null) {
                telaSelecionada.exibir();
            } else {
                System.out.println("❌ Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }
}
