package PALINDRIMO;

import java.util.ArrayList;
import java.util.Stack;

public class PALI {

    String palin;
    int largo;

    PALI(String palin){
        this.palin = palin;
        this.largo = palin.length();
    }



    public String getPalin() {
        return palin;
    }

    public void setPalin(String palin) {
        this.palin = palin;
    }

    public int getLargo() {
        return largo;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }

    @Override
    public String toString() {
        return "PALI{" +
                "palin='" + palin + '\'' +
                ", largo=" + largo +
                '}';
    }

    public  Stack<String> mete(){
        Stack<String> original  = new Stack<String>();

        for (int i = palin.length(); i > 0; i--){
            System.out.print(i);
            char CHARAT = palin.charAt(i-1);
            String charat = Character.toString(CHARAT);

            original.push(charat);

        }
        System.out.print(original);

        return original;

    }

    public void check(){

        boolean error = false;
        Stack original =  mete();

        for (int i = palin.length(); i> 0 ; i--){

            if (Character.toString(palin.charAt(i-i)).equals(original.pop())){
                error = false;
            }
            else {
                //System.out.print(palin.charAt(i-1));
                error = true;
            }
        }

        if (error) System.out.printf("HAY ERROR");
        else System.out.printf("NO HAY ERROR");




    }

}