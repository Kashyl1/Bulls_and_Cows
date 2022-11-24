package bullscows;

import java.util.Scanner;

public class Gra extends Liczby{
    Scanner scanner = new Scanner(System.in);
    void gra() {
        int dlugosc = generujLiczbe();
        int symbole = symbole();
        if (dlugosc > symbole) {
            System.out.println();
            System.out.println("Error: Nie można wygenerować większej długości niż symboli! Długość: " + dlugosc + " Unikatowe symbole: " + symbole);
            System.exit(0);
        }
        String haslo = losowyGenerator(dlugosc, symbole);
        wiadomosc(symbole);
        System.out.println(haslo);
        int k = 1;
        while(true) {
            System.out.println("Runda " + k + " :");
            k++;
            String strzal = wpisz();
            int bull = Bull(haslo, strzal);
            int cows = cows(haslo, strzal);
            if (bull == 0 && cows == 0) {
                System.out.println("Ocena: Brak powiązań.");
            }
            if (bull > 0 && cows == 0) {
                System.out.println("Ocena: " + bull + " bulls.");

            }
            if (bull == 0 && cows > 0) {
                System.out.println("Ocena: " + cows + " cow(s).");
            }
            if (bull > 0 && cows > 0) {
                System.out.println("Ocena: " + bull + " bull(s) and " + cows + " cow(s).");
            }
            if (bull == strzal.length()) {
                System.out.println("Brawo! Odgadłeś kod!");
                break;
            }
        }
    }
    String wpisz() {
        return scanner.next();
    }
    int generujLiczbe() {
        System.out.println("Wpisz długość kodu (1-36)");
        int rozmiar = 0;
        if (scanner.hasNextInt()) {
            rozmiar = scanner.nextInt();
            if (rozmiar > 36) {
                System.out.println("Error: Nie można wygenerować rozmiaru " + rozmiar +
                        " ponieważ nie ma tylu unikatowych znaków");
                rozmiar = generujLiczbe();
            }
            if (rozmiar <= 0) {
                System.out.println("Error: Rozmiar nie może być mniejszy niż 1");
                rozmiar = generujLiczbe();
            }
            return rozmiar;
        }
            else {
                System.out.println("Error: Wpisałeś złą liczbe długości kodu!");
                System.exit(0);
            }
        return rozmiar;
    }
    int symbole() {
        System.out.println("Wpisz liczbę unikatowych symboli (1-36):");
        int symbole = 0;
        if (scanner.hasNextInt()) {
             symbole = scanner.nextInt();
            if (symbole > 36) {
                System.out.println("Error: Maksymalna liczba symboli to 36! (0-9, a-z)");
                symbole = symbole();
            } else if (symbole <= 0) {
                System.out.println("Error! Minimalna liczba symboli to 1! (0-9, a-z)");
                symbole = symbole();
            } return symbole;
        } else {
                System.out.println("Error: Wpisałeś złą liczbe symboli!");
                System.exit(0);
            }
        return symbole;

     }
     void wiadomosc(int symbole) {
         System.out.print("Kod jest przygotowywany: ");
         if (symbole <= 10) {
             for (int i = 0; i < symbole; i++) {
                 System.out.print("*");
             }
             symbole -= 1;
             System.out.println(" (0-" + symbole + ")");
         } else {
             for (int i = 0; i < symbole; i++) {
                 System.out.print("*");
             }
             char a = (char) ((char)symbole + 86);
             System.out.println(" (0-9, a-" + a + ").");
         }
         System.out.println("Czas zacząć gre!");
     }
}
