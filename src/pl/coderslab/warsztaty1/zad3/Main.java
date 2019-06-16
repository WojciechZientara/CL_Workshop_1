package pl.coderslab.warsztaty1.zad3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int min = 0;
        int max = 1000;
        while (true) {
            System.out.println("Pomyśl liczbę od 0 do 1000, a ja ją zgadnę w max. 10 próbach");
            try {
                int chosenNumber = Integer.parseInt(scan.next());
                if (chosenNumber < min || chosenNumber > max) {
                    System.out.println("Wybrana liczba nie należy do zakresu 0-1000.");
                } else {
                    guessNumber(chosenNumber, min, max);
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("To nie jest liczba naturalna od 0 do 1000.");
            }

        }
    }

    static void guessNumber(int chosenNumber, int min, int max) {
        Scanner scan = new Scanner(System.in);
        int tryNumber = 1;
        while (true) {
            int guess = ((max-min)/2) + min;
            System.out.println("Próba numer " + tryNumber);
            System.out.println("Zgaduję: " + guess);
            int answer = 0;
            System.out.println("Pobierz odpowiedź z zestawu:\n1) za dużo,\n2) za mało,\n3) zgadłeś");
            while (true) {
                try {
                    answer = Integer.parseInt(scan.next());
                    if (answer < 1 || answer > 3) {
                        System.out.println("Wybrano niepoprawną odpowiedź.");
                        System.out.println("Pobierz odpowiedź z zestawu:\n1) za dużo,\n2) za mało,\n3) zgadłeś");
                        scan.reset();
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("\"Wybrano niepoprawną odpowiedź.");
                    System.out.println("Pobierz odpowiedź z zestawu:\n1) za dużo,\n2) za mało,\n3) zgadłeś");
                }
            }
            if (answer == 1) {
                max = guess;
            } else if (answer == 2) {
                min = guess;
            } else {
                System.out.println("Wygrałem!");
                break;
            }
            tryNumber++;


        }

    }
}
