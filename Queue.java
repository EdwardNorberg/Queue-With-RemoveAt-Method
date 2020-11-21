package Norberg.Edward;

public class Queue<Item> {

    LinkedList<Item> ll = new LinkedList<>();

    public void addAt(Item data, int k) {
        ll.addAt(data, k);
        System.out.println(this.toString());
    }

    public void add(Item data) {
        ll.add(data);
        System.out.println(this.toString());
    }

    public Item removeAt(int k) {
        Item data = ll.removeAt(k);
        System.out.println(this.toString());
        return data;

    }

    public String toString(){
        return ll.toString();
    }



}
