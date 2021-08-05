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

        public Node(T nodeData) {
            data = nodeData; //had to change name, tests failing
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

    public boolean contains(T findElement) { //return true if element is in list
        Node current = head;
        int index = 0;

        while (current != null) {
            if (current.data.equals(findElement)) {
                return true;
            }
            current = current.next;
            index++;
        }

        return false;
    }

    public int find (T findElement) {//return the element's index if it is in the list, -1 otherwise, similar to contains approach
        Node current = head;
        int index = 0;

        while (current != null) {
            if (current.data.equals(findElement)) {
                return index; //changed count to index because it specifies "index"
            }
            current = current.next;
            index++;
        }

        return -1;
    }

    public int size() {//return the current size of the list

        return this.size;
    }

    public T get(int index) { //return the element at the specified index, generic
        Node current = head; //had to update because tests were all return 1 and not the number at the index
        T getData = null;
        int count = 0;

        if (current == null) {
            return getData;
        }

        while (current != null) {
            if (index == count) {
                getData = current.data;
                return getData;
            }

            count++;
            current = current.next;
        }
        return getData;
    }


    /**
     * A deep copy means actually creating a new array and copying over the values.
     * https://www.geeksforgeeks.org/deep-shallow-lazy-copy-java-examples/
     * The deep copy of an object will have an exact copy of all the fields of source
     * object like a shallow copy, but unlike sallow copy if the source object has any
     * reference to object as fields, then a replica of the object is created by calling
     * clone method. This means that both source and destination objects are independent
     * of each other. Any change made in the cloned object will not impact the source object.
     *
     * "For that, LinkedList needs to support copying (or at least a way to iterate over its elements). "
     *
     * Clone() returns a shallow copy of this linkedList
     *
     *
     */



    public SinglyLinkedList<T> copy() { //returns a new linked list containing the same values (look up deep versus shallow copy)
        SinglyLinkedList<T> deepCopy = new SinglyLinkedList<T>();
        Node current = head;

        while (current != null) {
            deepCopy.add(current.data);
            current = current.next;
        }

        return deepCopy; //still unsure if this is correct because most code was shallow or recursive
    }

    public void sort() { // sort the list using your algorithm of choice.
        Node current = head;
        Node next = null;
        T temp;

        while (current != null) {
            next = current.next;

            while (next != null) {
                if (current.data.compareTo(next.data) > 0) {
                    temp = current.data; //running thru to make the new list
                    current.data = next.data;
                    next.data = temp;
                }
                next = next.next;
            }
            current = current.next;
        }
    }

} //final brace
//might come back and attempt other optional parts, very hard, handheld lab
//need more practice