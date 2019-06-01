package RecursiveSMALLER;

import java.util.Arrays;

public class RECURSIVESMALLER<T> {

    int [] arr = new int[]{5,6,7,8,9,10,-58,54,63, 2};


    @Override
    public String toString() {
        return "RECURSIVESMALLER{" +
                "arr=" + Arrays.toString(arr) +
                '}';
    }


    public int smaller(){
        int smaller = arr[0];

        //System.out.println(smaller);

        return  smaller(0,smaller);


    }

    public int smaller(int ii, int smaller){

        if (arr.length == ii)return smaller;

/*
        System.out.println("ARR");
        System.out.println(arr[ii]);
        System.out.println("smaller:    ");
        System.out.println(smaller);
*/

        if (smaller > arr[ii]) return smaller(ii+1, arr[ii] );
        else {
            return smaller(ii+1, smaller);
        }
    }

}
