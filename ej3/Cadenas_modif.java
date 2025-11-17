package ej3;

import java.io.FileWriter;
import java.util.Random;

public class Cadenas_modif {

    private static final String CARPETA_TRABAJO = "C:\\temp";

    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Uso: java UD1.ej3.Cadenas_modif <id_proceso> <num_cadenas>");
            return;
        }

        int idProceso = Integer.parseInt(args[0]);
        int numCadenas = Integer.parseInt(args[1]);
        String alfabeto = "abcdefghijklmnopqrstuvwxyz";
        Random random = new Random();

        try {
            FileWriter fw = new FileWriter(CARPETA_TRABAJO + "\\cadenas_" + idProceso + ".txt");

            for (int n = 0; n < numCadenas; n++) {
                int longitud = random.nextInt(20) + 1;

                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < longitud; i++) {
                    char letra = alfabeto.charAt(random.nextInt(alfabeto.length()));
                    sb.append(letra);
                }

                System.out.println(idProceso + " - " + sb.toString());
                fw.write(sb.toString() + "\n");
            }

            fw.close();
        } catch (Exception e) {
            System.err.println("Error al escribir archivo: " + e.getMessage());
        }
    }
}
