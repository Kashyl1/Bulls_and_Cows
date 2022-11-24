package bullscows;

import java.util.*;

public class Liczby {
     String losowyGenerator(int rozmiar, int symbole) { // Generowanie losowej liczby z unikatowymi symbolami
        List<Character> randomList = new ArrayList<>(List.of('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n' , 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'));
        for (int i = 35; i >= symbole; i--) { // Usuwanie symboli z listy
            randomList.remove(i);
        }
        Collections.shuffle(randomList); // Zmienianie losowo listy
        StringBuilder result = new StringBuilder();
        for (Character ch : randomList.subList(0, rozmiar)) {
            result.append(ch); // Dodawane do StringBuildera kodu
        }
        return result.toString();
    }
    int cows(String haslo, String strzal) { // Szuka czy trafiłeś dokładnie ten sam symbol w tym samym miejscu
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
    int Bull(String haslo, String strzal) { // Szuka czy trafiłeś symbol który jest w kodzie
        int bull = 0;
        for (int i = 0; i < strzal.length(); i++) {
            if (String.valueOf(haslo.charAt(i)).equals(String.valueOf(strzal.charAt(i))))
                bull++;
        }
        return bull;
    }
}
