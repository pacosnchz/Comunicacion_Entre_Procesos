package ej3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Frecuencia {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = 0, e = 0, i = 0, o = 0, u = 0;
        String linea;

        try {
            while ((linea = br.readLine()) != null) {
                linea = linea.toLowerCase();

                for (char c : linea.toCharArray()) {
                    switch (c) {
                        case 'a': a++; break;
                        case 'e': e++; break;
                        case 'i': i++; break;
                        case 'o': o++; break;
                        case 'u': u++; break;
                    }
                }
            }

            System.out.println("a = " + a);
            System.out.println("e = " + e);
            System.out.println("i = " + i);
            System.out.println("o = " + o);
            System.out.println("u = " + u);

        } catch (Exception ex) {
            System.err.println("Error al leer: " + ex.getMessage());
        }
    }
}
