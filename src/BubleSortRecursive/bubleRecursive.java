package BubleSortRecursive;

import java.util.Arrays;

public class bubleRecursive {
    int [] arr = new int[]{5,4,7,3,9,10,-58,54,63, 2};


    public int bubleSort(){

        //System.out.println(smaller);

        return  bubleSort(0);


    }


    @Override
    public String toString() {
        return "bubleRecursive{" +
                "arr=" + Arrays.toString(arr) +
                '}';
    }

    public int bubleSort(int iii){
        System.out.println(arr.length);
        System.out.println(iii);
        System.out.println(arr[iii]);
        if (arr[iii] > arr[iii+1]){
            int pequeno = arr[iii+1];
            int grande = arr[iii];

            arr[iii] = pequeno;
            arr[iii+1] = grande;

        }

        System.out.println(toString());

        if (arr.length+1 == iii){
            System.out.println("reinicio");
            return bubleSort(0);
        }

        return  bubleSort(iii+1);


    }


}
