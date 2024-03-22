package ejerciciosTryCatchThrows;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class division1 {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int operador1 = 0;
        int operador2 = 0;

        System.out.println("Introduce operadores: ");

        try {
            operador1 = sc.nextInt();
            operador2 = sc.nextInt();

        } catch (NoSuchElementException e) {
            System.out.println("Los valores introducidos no son válidos, vuelve a introducir");
            System.exit(0);
        }finally {
            sc.close();
        }

        double resultado = (double) operador1 /operador2;

        System.out.println(resultado);

    }
}
