package tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortowaniePozycyjne {
    private List<String> unsorted;
    private int length;
    public SortowaniePozycyjne(List<String> unsorted) {
        this.unsorted = unsorted;
        length=unsorted.get(0).length();
    }
    private void toZero (Integer[] number){
        for(int i=0; i<number.length; i++){
            number[i]=0;
        }
    }
    public List<String> sort(){
        List<String> A = new ArrayList<>(unsorted);
        Integer[] B = new Integer[10];
        Integer[] C = new Integer[10];
        Map<Integer, String> D = new HashMap<>();
        for(int index=length-1; index>=0; index--){
            toZero(B);
            toZero(C);
            for(String num : A){
                B[num.charAt(index)-48]++;
            }
            C[0]=B[0];
            for(int i=1; i<C.length; i++){
                C[i]=C[i-1]+B[i];
            }
            for(int i=A.size()-1; i>=0; i--){
                D.put(C[A.get(i).charAt(index)-48], A.get(i));
                C[A.get(i).charAt(index)-48]--;
            }
            for(int i=0; i<D.size(); i++){
                A.set(i, D.get(i+1));
            }
        }
        return A;
    }
}
