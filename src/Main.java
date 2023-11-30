import tools.Formatter;
import tools.RandomNumbersGenerator;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        /**
         * Na potrzeby zadania zrobilem dodatkową funkcję RandomNumbersGenerator która generuje losowe liczby
         * o określonej długości i ilości i zwraca w postaci String. Dodałem też Formatter który dodaje odstęp albo ','
         * co 3 cyfry aby było bardziej czytelnie.
         *
         * Sam algorytm sortowania pozycyjnego znajduje sie w pliku SortowaniePozycyjne.java
         */
        List<String> longNumbersAsString = new RandomNumbersGenerator(50, 20).generateAsString(); //Losuje 20 losowych liczb o dlugosci 50

        System.out.println("Przed posortowaniem:\n");
        longNumbersAsString.forEach(n-> System.out.println(new Formatter(n).everyThree(",", true))); //drukuje wszystkie liczby przed posortowaniem

        SortowaniePozycyjne sort = new SortowaniePozycyjne(longNumbersAsString); //tworze obiekt SortowaniePozycyjne
        longNumbersAsString=sort.sort(); //wywołuję metodę sortowania pozycyjnego
        System.out.println("\nPo sortowaniu:\n");
        longNumbersAsString.forEach(n-> System.out.println(new Formatter(n).everyThree(",", true))); //drukuje wszystkie liczby po sortowaniu
    }
}