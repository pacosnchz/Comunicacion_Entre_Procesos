package ej3;

import java.util.Random;

public class Cadenas {

    public static void main(String[] args) {

        if (args.length != 1) {
            System.err.println("Uso: java UD1.ej3.Cadenas <num_cadenas>");
            return;
        }

        int numCadenas = Integer.parseInt(args[0]);
        String alfabeto = "abcdefghijklmnopqrstuvwxyz";
        Random random = new Random();

        for (int n = 0; n < numCadenas; n++) {
            int longitud = random.nextInt(20) + 1;

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < longitud; i++) {
                char letra = alfabeto.charAt(random.nextInt(alfabeto.length()));
                sb.append(letra);
            }

            System.out.println(sb.toString());
        }
    }
}
