import java.util.Random;

public class ArvoreNatal {

    public static String reset = "\u001B[0m";
    public static String limpaT = "\033[H\033[2J";
    public static String vermelho = "\u001B[38;2;242;5;80m";
    public static String verde = "\u001B[38;2;5;179;110m";
    public static String laranja = "\u001B[38;2;242;125;4m";
    public static String branco = "\u001B[38;2;250;248;248m";
    public static String marron = "\u001B[38;2;67;41;31m";
    public static String bege = "\u001B[38;2;250;240;186m";
    public static String ciano = "\u001B[38;2;0;105;115m";

    public static String[] cores = {
            vermelho,
            verde,
            laranja,
            branco,
            marron,
            bege,
            ciano
    };

    public static String[] arvore = {
            "          * ",
            "         *** ",
            "        ***** ",
            "       ******* ",
            "      ********* ",
            "     *********** ",
            "    ************* ",
            "         |||         "
    };

    public static String[] letra = {
            "A spark in the winter night",
            "Warm hands...",
            "A glance that melts the cold",
            "A heart quietly unfolding",
            "Soft echoes in the dark",
            "A promise gently rising",
            "Love finding its way again"

    };

    public static void main(String[] args) {
        String[] arvoreNatal = new String[arvore.length];
        Random r = new Random();
        String linhaColorida;

        int linhaAtualLetra = 0;
        int charAtualLetra = 0;
        int delay = 117;

        while (true) {

            int i = 0;
            for (String c : arvore) {
                linhaColorida = "";
                for (char d : c.toCharArray()) {
                    linhaColorida += cores[r.nextInt(cores.length)] + d + verde;
                }
                arvoreNatal[i] = linhaColorida;
                i++;
            }

            System.out.print(limpaT);

            for (int linha = 0; linha < 8; linha++) {

                String linhaArvore = arvoreNatal[linha];

                String linhaLetra = "";

                if (linha == linhaAtualLetra) {
                    linhaLetra = letra[linhaAtualLetra].substring(0, charAtualLetra);
                } else if (linha < linhaAtualLetra) {
                    linhaLetra = letra[linha];
                }

                String espacamento = "     ";

                System.out.println(linhaArvore + espacamento + linhaLetra);
            }

            charAtualLetra++;

            if (linhaAtualLetra < 8 && charAtualLetra > letra[linhaAtualLetra].length()) {
                linhaAtualLetra++;
                charAtualLetra = 0;
            }

            try {
                Thread.sleep(delay);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}