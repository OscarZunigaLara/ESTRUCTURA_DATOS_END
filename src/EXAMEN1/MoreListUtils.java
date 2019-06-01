// Nombre:
// Matricula:
package EXAMEN1;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.LinkedList;

public class MoreListUtils {

    /**
     * Inserts all of the elements contained in one list into anotherList
     * at the specified position
     *
     * @param lst1 the list to be modified
     * @param lst2 the list of elements to be inserted, this list should
     * not be modified
     * @param index index of the position to insert the elements
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index
     * > size())
     */
    public static <E> void merge(LinkedList<E> lst1, LinkedList<E> lst2, int index) {

        if (index< 0){
            throw new IndexOutOfBoundsException("i<0");
        }

        if (index>lst1.size()){
            throw new IndexOutOfBoundsException("i>lst.size()");
        }

        int iiiii;
        iiiii= 0;
        for (int i = index; i<lst2.size()+index;i++){

//        System.out.println(i);//       System.out.println("iiiiii"+iiiii);
            lst1.add(i,lst2.get(iiiii));
            iiiii++;
            //System.out.println(lst1);


        }






    }

    /**
     * Returns a new list containing all the elements of the provided list
     * in the reverse order
     * @param lst the list to be reversed, this list should not be modified
     * @return a new list containing all the elements of lst in the reverse order
     */
    public static <E> LinkedList<E> reverse(LinkedList<E> lst) {

        LinkedList<Integer> ooowww = new LinkedList<>();

        LinkedList<E> wwwooo = new LinkedList<E>();


        //System.out.println(ooowww);

        for (int i = 0; i < lst.size(); i++){

            int m = (Integer) lst.get(i);
            ooowww.add(i,m);
        }

        //System.out.println("clone"+ooowww + ooowww.size());

        int llll;
        llll = 0;

        int p;

        E kkkk;

        p = lst.size()-1;
        for (llll = 0; llll <lst.size();llll++){

            wwwooo.add(llll,(E)lst.get(p));
            p--;

            //System.out.println(wwwooo);

        }


        return wwwooo;
    }
}