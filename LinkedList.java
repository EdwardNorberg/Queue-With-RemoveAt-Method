package Norberg.Edward;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<Item> implements Iterable<Item> {

    Node<Item> head;
    int nrOfElements;

    //declare a new iterator
    Ite<Item> newIterator;


    public LinkedList() {
        nrOfElements = 0;
    } //constructor, sets nrOfElements initially to 0

    public int size() {
        return nrOfElements;
    } //not actually used


    public void add(Item data) {
        Node<Item> node = new Node<>(data);
        if(nrOfElements == 0){
            head = node;

        } else {
            node.next = head;
            head = node;
        }
        nrOfElements++;


    }

    public void addAt(Item data, int k) {

        Node<Item> node = new Node<>(data);
        //instantiates the new iterator, pointing it to the head of the LinkedList
        newIterator = new Ite<>(head); //not sure if this is good practice

        //if k is more than one larger than number of elements, or k is negative
        //then throw exception
        if(k-1 > nrOfElements || k <= 0) {throw new NoSuchElementException(); }

        if(k > 1) { //the case if k is more than 1

            if(nrOfElements > 0) { //if it's not the first element to be added to the list
                int index = 1;
                while (index != k - 1) {

                    newIterator.next(); //do not actually use return value of next() method, only side effect
                    index++;
                }

                node.next = newIterator.current.next;
                newIterator.current.next = node;


            } else if( nrOfElements == 0) { //it it's the first element

                //If LinkedList is empty, set new node to both head and tail, and set nodes next to itself
                head = node;
                node.next = node;
            }
            nrOfElements++;

        } else if (k == 1) { //the case if k is equal to one, almost same as addFirst method from LAB 1.4

            if(nrOfElements == 0){
                //If LinkedList is empty, set new node to head
                head = node;

            } else {
                //Set new nodes next to the old head, and make the new node head
                node.next = head;
                head = node;

            }
            nrOfElements++;
        }

    }



    public Item removeAt(int k) {

        int index = 1;
        newIterator = new Ite<>(head);

        if (k > nrOfElements || k <= 0) { //k must be a index of an existing element for method to work
            throw new NoSuchElementException();
        }


        if (k > 1) {

            while (index != k - 1) { //iterate through list until one element from the one which will be removed

                newIterator.next();
                index++;
            }

            //save the data from the removed node, then set the current.next = current.next.next
            Item data = newIterator.current.next.data;
            newIterator.current.next = newIterator.current.next.next;
            nrOfElements--;
            //then return the data
            return data;



        } else if(k == 1) {

            Item data = head.data;

            if (nrOfElements >= 2) {
                head = head.next;

                nrOfElements--;

            } else if (nrOfElements == 1) {
                //if we remove the last node, set all references to null
                head = null;

                nrOfElements--;
            }

            //return the data of the removed node
            return data;

        }
        return null;

    }


    public String toString() {
        //instantiate the iterator here because we want to iterate through the queue when the list looks like
        // it does at the moment the toString() method is called
        newIterator = new Ite<>(head);

        int toStringIndex = 0;
        StringBuilder st = new StringBuilder();
        st.append("[");

        while(newIterator.index < nrOfElements && newIterator.hasNext()) {
            st.append(newIterator.next()).append(",");
            toStringIndex++;
        }

        //unless the queue is empty, remove the last comma
        if (toStringIndex != 0) {
            st.setLength(st.length() - 1);
        }

        st.append("]");

        return st.toString();


    }


    //Almost identical to the Sedgewick & Wayne implementation of iterator for the linked list class

    public Iterator<Item> iterator() {
        return new Ite<>(head);
    }

    public class Ite<Item> implements Iterator<Item> {

        Node<Item> current;
        int index;

        public Ite(Node<Item> head) { //constructor
            current = head;
            index = 0;
        }

        //only if list is empty will this return as false
        public boolean hasNext() { return current != null; }

        /*Current starts of at head. When next is called, the data in current is stored,
        then current iterates to the next one*/

        public Item next() {

            //if the queue is empty, throw NoSuchElementException
            if(current == null) {
                throw new NoSuchElementException();
            } else {
                Item temp = current.data;
                current = current.next;
                index++;
                return temp;

            }
        }
    }

}
