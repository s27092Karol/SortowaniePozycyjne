package tools;

public class Formatter {
    private String s;

    public Formatter(String s) {
        this.s = s;
    }
    public String everyThree(String separateWith, boolean decimalFormat){
        StringBuilder formatted = new StringBuilder();
        int counter=0;
        for(int i = s.length()-1; i>=0; i--){
            char c = s.charAt(i);
            if(counter>2){
                counter=0;
                i++;
                formatted.append(separateWith);
                continue;
            }
            else {
                counter++;
                formatted.append(c);
            }
        }
        String format="";
        if(decimalFormat) format = ".00";
        return formatted.reverse().append(format).toString();
    }
}
