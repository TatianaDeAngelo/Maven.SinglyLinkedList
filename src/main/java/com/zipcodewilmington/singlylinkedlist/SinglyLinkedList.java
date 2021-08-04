package com.zipcodewilmington.singlylinkedlist;

/**
 * Created by leon on 1/10/18.
 * https://www.andrew.cmu.edu/course/15-121/lectures/Linked%20Lists/linked%20lists.html
 * https://www.geeksforgeeks.org/implementing-a-linked-list-in-java-using-class/
 * https://www.csie.ntu.edu.tw/~cyy/courses/oop/13summer/chap15java5th.pdf
 * https://www.csc.ncsu.edu/courses/csc216-common/Heckman/lectures/13_InnerClasses_Iterators.pdf
 *  https://stackoverflow.com/questions/32929732/linked-list-inner-class
 */
public class SinglyLinkedList <T extends Comparable<T>>  {

    private Node head;
    private Node tail;
    private int size;

    public SinglyLinkedList() {
        this.size = 0;
    }

    private class Node { //inner node class
        T data;
        Node next;

        public Node(T data) {
            data = data;
            next = null;
        }
    }

/**
 * Method definitions:
 * add -- add an element to the list
 * remove -- remove an element (specified by numeric index) from the list
 * contains -- returns true if the element is in the list, false otherwise
 * find -- returns the element's index if it is in the list, -1 otherwise
 * size -- returns the current size of the list
 * get -- returns the element at the specified index
 * copy -- returns a new linked list containing the same values (look up deep versus shallow copy)
 * sort -- sorts the list using your algorithm of choice. You must perform the sorting yourself (no fair using someone else's library)
 */

    public void add(T data) {//add an element to the list
        Node newNode = new Node(data);

        if(head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        this.size++;
    }

    public void remove(int index) { //remove an element at specific index(int index)
        Node current = head;
        Node nextEl;

        if (current != null && index == 0) {
            head = current.next;
        }

        for (int i = 0; i < index - 1; i++) { //to not reach end
             current = current.next;
             nextEl = current.next;
             current.next = nextEl;
            
        }

        this.size--;
    }

    public boolean contains(T conElement){ //return true if element is in list
        Node current = head;
        int count = 0;

        while (current != null) {
            if (current.data.equals(conElement)) {
                return true;
            }

            current = current.next;
            count++;
        }

        return false;
    }


} //final brace
