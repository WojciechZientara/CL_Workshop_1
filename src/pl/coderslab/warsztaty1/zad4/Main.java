package pl.coderslab.warsztaty1.zad4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.PatternSyntaxException;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x = 1;
        int y = 0;
        int z = 0;
        while (true) {
            try {
                System.out.println("Wybierz kod kostki w formacie xDy+z, gdzie:\n" +
                        "x - liczba rzutów kośćmi (jeśli rzucamy raz, ten parametr jest pomijany)\n" +
                        "y - rodzaj kostek, których należy użyć (np. D6, D10)\n" +
                        "z – (opcjonalnie) liczba, którą należy dodać (lub odjąć) do wyniku rzutów.");
                String dice = scan.next();
                if (dice.indexOf("D") == -1) {
                    throw new NumberFormatException();
                }
                String[] arrDsplit = dice.split("D");
                if (!arrDsplit[0].equals("") && Integer.parseInt(arrDsplit[0]) < 1) {
                    throw new NumberFormatException();
                } else if (!arrDsplit[0].equals("")) {
                    x = Integer.parseInt(arrDsplit[0]);
                }

                String[] arrPlusSplit = arrDsplit[1].split("\\+");
                String[] arrMinusSplit = arrDsplit[1].split("-");
                if (arrPlusSplit.length > 1) {
                    y = Integer.parseInt(arrPlusSplit[0]);
                    z = Integer.parseInt(arrPlusSplit[1]);
                } else if (arrMinusSplit.length > 1) {
                    y = Integer.parseInt(arrMinusSplit[0]);
                    z = Integer.parseInt("-" + arrMinusSplit[1]);
                } else {
                    y = Integer.parseInt(arrPlusSplit[0]);
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Wprowadzono zły format kostki.");
            }

        }

        Random rand = new Random();
        int result = 0;
        for (int i = 0; i < x; i++) {
            int randInt = rand.nextInt(y + 1);
            result += randInt;
            System.out.println("Rzut " + (i + 1) + ": " + randInt);
        }
        System.out.println("Wynik: " + (result + z));
    }
}
