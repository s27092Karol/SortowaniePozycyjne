import tools.Formatter;
import tools.RandomNumbersGenerator;
import tools.SortowaniePozycyjne;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> longNumbersAsString = new RandomNumbersGenerator(50, 20).generateAsString();
        System.out.println("Przed posortowaniem:\n");
        longNumbersAsString.forEach(n-> System.out.println(new Formatter(n).everyThree(",", true)));
        SortowaniePozycyjne sort = new SortowaniePozycyjne(longNumbersAsString);
        longNumbersAsString=sort.sort();
        System.out.println("\nPo sortowaniu:\n");
        longNumbersAsString.forEach(n-> System.out.println(new Formatter(n).everyThree(",", true)));
    }
}