package EXAMEN2;

import java.util.Objects;
import java.util.Queue;
import java.util.Stack;

import java.util.NoSuchElementException;

public class ArrayStack <T> implements ExamStack <T> {
    public int size = 10;
    private Object[] arr;
    int dondeEstoy = 0;

    public ArrayStack(int size){
        this.size = size;
        arr = new Object[size];
    }


    public boolean isFull(){
        if (arr.length == dondeEstoy)return true;
        else
            return false;
    }


    @Override
    public void push(T item) throws IndexOutOfBoundsException{
        if (dondeEstoy>= arr.length){
            dondeEstoy--;
            new Exception();
            String e = ("IndexOutOfBoundsException e");
            throw new IndexOutOfBoundsException();
        }
        //System.out.println("PUSH");
        arr[dondeEstoy] = item;
        System.out.println(arr[dondeEstoy]);
        dondeEstoy++;
        for(int i = 0;i<dondeEstoy;i++){
            ///System.out.println("asdfasdff"+arr[i]);
        }
    }


    @Override
    public T pop() throws NoSuchElementException {
        //System.out.println("pop" +dondeEstoy);

        if (dondeEstoy <0){
            new Exception();
            String e = ("NoSuchElementException e");
            throw new NoSuchElementException();
        }else {
            //System.out.println("POP");
            T res;
            if (isFull()) {
                dondeEstoy = arr.length - 1;
            }
            Object POPER = arr[dondeEstoy];
            //System.out.println(POPER);

            res = (T) POPER;

            arr[dondeEstoy] = null;
            dondeEstoy--;

            return res;
        }
    }

    @Override
    public T peek()throws NoSuchElementException {
        if (dondeEstoy>= arr.length){
            new Exception();
            String e = ("IndexOutOfBoundsException e");
            throw new IndexOutOfBoundsException();
        }
        //System.out.println("PEEK");
        T res;
        if (isFull()){
            dondeEstoy = arr.length-1;
        }
        Object POPER = arr[dondeEstoy];
        //System.out.println(POPER);
        res = (T)POPER;
        return res;

    }
}