import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortowaniePozycyjne {
    private List<String> unsorted; //Lista liczb przed sortowaniem
    private int length; //długość liczb
    public SortowaniePozycyjne(List<String> unsorted) { //konstruktor
        this.unsorted = unsorted;
        length=unsorted.get(0).length();
    }

    //metoda toZero jest wykorzystywana później w metodzie sort do wyzerowania wszystkich elementów przekazanej tablicy
    private void toZero (Integer[] number){
        for(int i=0; i<number.length; i++){
            number[i]=0;
        }
    }


    //SORTOWANIE POZYCYJNE
    public List<String> sort(){

        List<String> A = new ArrayList<>(unsorted); //tworzę nową liste A liczb przed sortowaniem
        Integer[] B = new Integer[10]; //tablica B przechowuje ile razy dana cyfra sie pojawia w liczbie na danej pozycji
        Integer[] C = new Integer[10]; //tablica C przechowuje indeksy po których później się podmienia cyfry na danej pozycji
        Map<Integer, String> D = new HashMap<>(); //Mapa (daje mape ze wzgledu na indeksy od 1 a nie od 0) przechowuje posortowane juz liczby

        for(int index=length-1; index>=0; index--){

            //za każdym razem musze wyzerowac tablice B i C
            toZero(B);
            toZero(C);

            //ide po elementach z A i ich wartość to indeks w B i na tym indeksie zwiekszam wartość o 1
            for(String num : A){
                B[num.charAt(index)-48]++;
            }

            C[0]=B[0];

            //tak jak na zajeciach ide w dół i dodaje do siebie wartości
            for(int i=1; i<C.length; i++){
                C[i]=C[i-1]+B[i];
            }

            //przypisuje wartość z A do D po indeksach z C
            for(int i=A.size()-1; i>=0; i--){
                D.put(C[A.get(i).charAt(index)-48], A.get(i));
                C[A.get(i).charAt(index)-48]--;
            }

            //dodatkowy krok, zwzgl na indeksowanie w D od 1 a nie od 0 jak w Javowej liście, przepisuje teraz wartości z D spowrotem do A ze zmienionymi indeksami o 1
            for(int i=0; i<D.size(); i++){
                A.set(i, D.get(i+1));
            }
        }

        return A;
    }
}
