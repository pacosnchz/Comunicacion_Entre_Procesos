package ej3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Lanzador {

    // Nombre del JAR real que has construido con IntelliJ
    private static final String CP = "Comunicacion_Entre_Procesos.jar";

    // Clase que se ejecutará como proceso hijo
    private static final String MAIN_CLASS = "ej3.Cadenas_modif";

    public static void main(String[] args) {

        if (args.length != 2) {
            System.err.println("Uso: java ej3.Lanzador <num_instancias> <num_cadenas>");
            return;
        }

        int numInstancias = Integer.parseInt(args[0]);
        int numCadenas = Integer.parseInt(args[1]);

        for (int i = 1; i <= numInstancias; i++) {
            try {
                ProcessBuilder pb = new ProcessBuilder(
                        "java",
                        "-cp",
                        CP,
                        MAIN_CLASS,
                        String.valueOf(i),
                        String.valueOf(numCadenas)
                );

                pb.redirectErrorStream(true);
                Process p = pb.start();

                BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));

                Thread lector = new Thread(() -> {
                    String linea;
                    try {
                        while ((linea = br.readLine()) != null) {
                            System.out.println(linea);
                        }
                    } catch (Exception ignored) {}
                });

                lector.start();

            } catch (Exception ex) {
                System.err.println("Error lanzando proceso: " + ex.getMessage());
            }
        }
    }
}
