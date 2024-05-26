package Exercices.ExoJava.Exo3Java;


import java.util.Scanner;

public class Exo3 {
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Entrez un nombre pour vérifier s'il est pair : ");
        int number = scanner.nextInt();

        if (isEven(number)) {
            System.out.println(number + " est un nombre pair.");
        } else {
            System.out.println(number + " est un nombre impair.");
        }

        scanner.close();
    }
}
