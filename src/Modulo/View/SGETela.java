package Modulo.View;

import Modulo.SGE.Entity.Estoque;
import Modulo.SGE.Entity.Fornecedor;
import Modulo.SGE.Entity.Item;
import Modulo.SGE.Enum.TamanhoItem;
import Modulo.View.Interface.Tela;

import java.util.ArrayList;
import java.util.Scanner;

import static Modulo.SGE.Utils.Funcs.*;

public class SGETela implements Tela {
    private Estoque<Item> estoque = new Estoque<>();
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void exibir() {
        int opcao;
        do {
            limparTela();
            System.out.println("\n===== 📦 SISTEMA DE GERENCIAMENTO DE ESTOQUE (SGE) =====");
            System.out.println("1️⃣ - Listar estoque");
            System.out.println("2️⃣ - Adicionar item (aleatório)");
            System.out.println("3️⃣ - Adicionar item (personalizado)");
            System.out.println("4️⃣ - Remover item");
            System.out.println("0️⃣ - Voltar ao menu principal");
            System.out.println("========================================================\n");
            System.out.print("🔷 Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> listarEstoqueTela();
                case 2 -> adicionarItemAleatorio();
                case 3 -> adicionarItemPersonalizado();
                case 4 -> removerItem();
                case 0 -> System.out.println("🔙 Voltando ao menu principal...");
                default -> System.out.println("❌ Opção inválida, tente novamente.");
            }
        } while (opcao != 0);
    }

    private void limparTela() {
//        Runtime.getRuntime().exec("cls");
//        ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
//            Process startProcess = pb.inheritIO().start();
//            startProcess.waitFor();
        for (int i = 0; i < 25; i++) System.out.println();
    }

    private void animarTexto(String texto, int delay) {
        for (char c : texto.toCharArray()) {
            System.out.print(c);
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }

    private void pausar(int tempoMs) {
        try {
            Thread.sleep(tempoMs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void listarEstoque() {
        animarTexto("\n======= 📦 ESTOQUE ATUAL 📦 =======\n", 20);

        if (estoque.getItems().isEmpty()) {
            animarTexto("⚠️ Estoque vazio.", 30);

            animarTexto("\n==================================\n", 20);
        } else {
            int index = 1;
            imprimirEstoque(estoque);
        }

        pausar(2000);
    }

    private void listarEstoqueTela() {
        limparTela();

        listarEstoque();

        int opcao;

        do {
            System.out.println("0️⃣ - Voltar ao menu principal");
            System.out.print("🔷 Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 0 -> System.out.println("🔙 Voltando ao menu SGE...");
                default -> System.out.println("❌ Opção inválida, tente novamente.");
            }
        } while (opcao != 0);


    }

    private void adicionarItemAleatorio() {
        limparTela();
        animarTexto("🔄 Gerando item aleatório...", 40);

        Item itemNovo = gerarCamisaAleatoria(gerarFornecedorAleatorio());

        if (verificaIdExistente(itemNovo)) {
            estoque.adicionarItem(itemNovo);
            animarTexto("✅ Item adicionado com sucesso!", 30);
        } else {
            animarTexto("⚠️ Erro: ID já existente. Gerando novo item...", 30);
            pausar(1000);
            adicionarItemAleatorio();
        }

        animarTexto("✅ Item adicionado com sucesso!", 30);
        pausar(2000);
    }

    private void adicionarItemPersonalizado() {
        limparTela();
        animarTexto("📝 Criando um novo item no estoque...\n", 40);

        System.out.println("🔷 Gerando ID aleatorio: ");
        int id = geraIDAleatorio();

        System.out.print("🔷 Digite a descrição do item: ");
        String descricao = scanner.nextLine();

        System.out.print("💰 Digite o preço do item: ");
        int preco = scanner.nextInt();

        System.out.println("📏 Escolha o tamanho:");
        TamanhoItem[] tamanhos = TamanhoItem.values();
        for (int i = 0; i < tamanhos.length; i++) {
            System.out.println((i + 1) + " - " + tamanhos[i]);
        }
        int tamanhoIndex = scanner.nextInt() - 1;
        System.out.print("📏 :");
        scanner.nextLine();

        System.out.print("📦 Digite a quantidade em estoque: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine(); // Consumir quebra de linha

        animarTexto("🛍️ Criando um fornecedor aleatório...", 40);
        Fornecedor fornecedor = gerarFornecedorAleatorio();

        Item novoItem = new Item(id, preco, descricao, tamanhos[tamanhoIndex], quantidade, fornecedor);
        ArrayList<Item> lista = new ArrayList<>();
        lista.add(novoItem);

        estoque.adicionarItem(lista);
        animarTexto("✅ Item adicionado com sucesso!", 30);
        pausar(2000);
    }

    private void removerItem() {
        limparTela();
        if (estoque.getItems().isEmpty()) {
            animarTexto("⚠️ Estoque já está vazio.", 30);
            return;
        }

        listarEstoque();
        System.out.print("❌ Digite o número do item para remover: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consumir quebra de linha

        if (index > 0 && index <= estoque.getItems().size()) {
            Item removido = estoque.getItems().remove(index - 1);
            animarTexto("✅ Item removido com sucesso: " + removido.getDescricao(), 30);
        } else {
            animarTexto("❌ Número inválido, tente novamente.", 30);
        }
        pausar(2000);
    }

    private boolean verificaIdExistente(Item item) {
        for (Item i : estoque.getItems()) {
            if (i.getId() == item.getId()) {
                return false;
            }
        }
        return true;
    }
}
