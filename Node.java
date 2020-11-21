package Norberg.Edward;

public class Node<Item> {

    //only need next since the linked list isn't double linked
    Item data;
    Node<Item> next;

    public Node(Item data) { this.data = data; } //constructor

}
