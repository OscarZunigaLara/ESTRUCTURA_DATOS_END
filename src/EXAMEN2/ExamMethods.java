package EXAMEN2;


import java.util.LinkedList;
import java.util.Stack;

/**
 *
 * @author
 */
public class ExamMethods {

    public static String zapCopies(String str) {

        if (str.length()==0) return str;
        else {
            return zapCopies(str, 0,"");
        }

    }
    public static String zapCopies(String str, int CHARPOS,String newSTR) {
        ///System.out.println(CHARPOS);

        if (CHARPOS+1 == str.length()) return newSTR + str.charAt(CHARPOS);

        if (str.charAt(CHARPOS) == str.charAt(CHARPOS+1)){
            return zapCopies(str,CHARPOS+1,newSTR);
        }else {
            newSTR = newSTR + str.charAt(CHARPOS);
            //System.out.println(newSTR);
            return zapCopies(str,CHARPOS+1,newSTR);
        }


    }



    public static String noX(String str) {
        int iii = str.length();
        String newString = "";



        if (iii == 0) return newString;

        return noX(newString+str, 0,"");
    }

    public static String noX(String str, int CHARPOS,String newSTR) {
        int iii = str.length();
        //System.out.println("STR" + str);

        if (CHARPOS == str.length()) return newSTR;


        if (str.charAt(CHARPOS) == 'x') {
            return noX(str, CHARPOS + 1, newSTR);
        } else {
            return noX(str, CHARPOS + 1, newSTR + str.charAt(CHARPOS));
        }
    }

    /*
    public static void solitaireSort(int[] a) {
        LinkedList<Stack<Integer>> pilas = new LinkedList<>();
        // Recorrer arreglo elemento por elemento
        // Por cada elemento, recorrer pilas
        // Si el tope de la pila es mayor igual al elemento, insertar elemento en la pila
        // Si no podemos insertar el elemento en ninguna pila, crear una nueva pila

        // Una vez que hayamos procesado todos los elementos,
        // Por cada posicion del arreglo inicial,
        // Encontrar el elemento tope mas pequeño de todas las pilas,
        // remover dicho elemento y ponerlo en la posicion del arreglo
        // Sugerible: Si la pila se queda vacia tras remover el elemento, eliminar la pila
    }

     */
}