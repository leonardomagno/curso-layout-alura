package alura.com.br.util;

public class DiasUtil {

    public static final String PLURAL = " Dias";
    public static final String SINGULAR = " Dia";

    public static String formataEmTexto(int quantidadeDeDias) {
        if (quantidadeDeDias > 1) {
           return quantidadeDeDias + PLURAL;
        }
            return quantidadeDeDias + SINGULAR;
    }
}
