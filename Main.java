package Norberg.Edward;

public class Main {

    /* Generalized queue which allows the used to add/remove the k:th element. The test shows a random assortment of method
    *  calls that demonstrate the functionality of the queue. Add() adds an element to the first position in the queue.
    *  AddAt() lets the user add an integer at a chosen index k.
    *  removeAt() lets the user remove an element with index k from the queue. Note that for the AddAt() method, the value of k may be
    *  up to 1 higher than the number of items in the queue at the time the method is called. This will place the element
    *  in the last position of the queue  */

    public static void main(String[] args) {

        Queue<Integer> newQueue = new Queue<>();

        //first parameter is the input data, the second is the index of the place in the queue where the data should
        //be stored (first index is k=1)

        System.out.println("\nAddAt method calls (technically not included is assignment):");

        newQueue.add(4);
        newQueue.add(30);
        newQueue.add(-2);
        newQueue.addAt(5, 1);
        newQueue.addAt(10, 1);
        newQueue.addAt(15, 2);
        newQueue.addAt(37, 3);
        newQueue.addAt(45, 2);
        newQueue.addAt(70, 4);
        newQueue.add(4);


        System.out.println("\nremoveAt method calls:");
        int i = newQueue.removeAt(1);
        int j = newQueue.removeAt(3);
        int k = newQueue.removeAt(2);
        int l = newQueue.removeAt(3);
        int m = newQueue.removeAt(1);
        int n = newQueue.removeAt(1);

        System.out.println("\nthe removed items, in order of removal: " +i+ ", " +j+ ", "+k+ ", " +l+ ", " +m+ ", " + n);
    }
}
