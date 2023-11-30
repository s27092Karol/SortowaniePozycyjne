package tools;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
public class RandomNumbersGenerator {
    private int length, amount;
    public RandomNumbersGenerator(int length, int amount) {
        this.length = length;
        this.amount = amount;
    }
    public List<String> generateAsString(){
        Random random = new Random();
        List<String> numbers = new LinkedList<>();
        for (int i=0; i<amount; i++){
            String num = "";
            for(int j=0; j<length; j++){
                Integer randomNr = random.nextInt( 9);
                num += randomNr.toString();
            }
            numbers.add(num);
        }
        return numbers;
    }
}
