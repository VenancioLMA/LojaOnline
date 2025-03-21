package Modulo.SGE.Utils;

public class CaptalizarTexto {
    public static String capitalizarPalavras(String i) {
        if (i == null || i.isEmpty()) {
            return "";
        }

        String[] palavras = i.split("\\s+"); // divide a string em palavras, ignorando múltiplos espaços
        StringBuilder resultado = new StringBuilder();

        for (String palavra : palavras) {
            if (!palavra.isEmpty()) {
                resultado.append(Character.toUpperCase(palavra.charAt(0))) // primeira letra maiúscula
                        .append(palavra.substring(1).toLowerCase()) // restante da palavra em minúsculas
                        .append(" ");
            }
        }
        return resultado.toString().trim();
    }
}
