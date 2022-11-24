package bullscows;

import java.util.*;

public class Liczby {
     String losowyGenerator(int rozmiar, int symbole) {
        List<Character> randomList = new ArrayList<>(List.of('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n' , 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'));
        for (int i = 35; i >= symbole; i--) {
            randomList.remove(i);
        }
        Collections.shuffle(randomList);
        StringBuilder result = new StringBuilder();
        for (Character ch : randomList.subList(0, rozmiar)) {
            result.append(ch);
        }
        return result.toString();
    }
    int cows(String haslo, String strzal) {
        int cows = 0;
        for (int i = 0; i < strzal.length(); i++) {

            for (int j = 0; j < strzal.length(); j++) {
                if (String.valueOf(haslo.charAt(i)).equals(String.valueOf(strzal.charAt(j)))
                    && !String.valueOf(haslo.charAt(i)).equals(String.valueOf(strzal.charAt(i)))) {
                    cows++;
                }
            }
        } return cows;
    }
    int Bull(String haslo, String strzal) {
        int bull = 0;
        for (int i = 0; i < strzal.length(); i++) {
            if (String.valueOf(haslo.charAt(i)).equals(String.valueOf(strzal.charAt(i))))
                bull++;
        }
        return bull;
    }
}
