package pl.coderslab.warsztaty1.zad2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int[] playersNumbers = new int[6];
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < 6; i++) {
            while(true) {
                System.out.println("Podaj liczbę nr " + (i + 1) + " z zakresu 1-49");
                try {
                    int chosenNumber = Integer.parseInt(scan.next());
                    if (chosenNumber < 1 || chosenNumber > 49) {
                        System.out.println("Ta liczba nie należy do zakresu 1-49");
                    } else {
                        boolean numberExists = false;
                        for (int j = 0; j < 6; j++) {
                            if (chosenNumber == playersNumbers[j]) {
                                numberExists = true;
                            }
                        }
                        if (numberExists) {
                            System.out.println("Ta liczba została już podana");
                        } else {
                            playersNumbers[i] = chosenNumber;
                            break;
                        }
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("To nie jest liczba");
                }
            }
        }
        Arrays.sort(playersNumbers);
        System.out.println("Wybrano liczby: " + Arrays.toString(playersNumbers));

        Integer[] arr = new Integer[49];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        Collections.shuffle(Arrays.asList(arr));
        int[] drawnNumbers = new int[6];
        for (int i = 0; i < 6; i++) {
            drawnNumbers[i] = arr[i];
        }
        Arrays.sort(drawnNumbers);
        System.out.println("Wylosowano liczby: " + Arrays.toString(drawnNumbers));

        int matchedNumbers = 0;
        for (int i = 0; playersNumbers.length < 6; i++) {
            for (int j = 0; drawnNumbers.length < 6; j++) {
                if (playersNumbers[i] == drawnNumbers[j]) {
                    matchedNumbers++;
                }
            }
        }
        if(matchedNumbers > 2) {
            System.out.println("Trafiłeś 3 lub więcej liczb.");
        } else {
            System.out.println("Nie trafiłeś nawet trójki");
        }



    }
}
