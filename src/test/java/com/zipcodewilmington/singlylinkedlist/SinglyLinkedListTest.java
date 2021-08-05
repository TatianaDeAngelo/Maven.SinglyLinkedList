package com.zipcodewilmington.singlylinkedlist;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by leon on 1/10/18.
 *
 */
public class SinglyLinkedListTest {

    @Test
    public void addTest() {
        //Given
        SinglyLinkedList<Integer> myList = new SinglyLinkedList<Integer>();

        //When
        myList.add(1);
        myList.add(2);


        Integer expected = 2;
        Integer actual = myList.size();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeTest() {
        //Given
        SinglyLinkedList<Integer> myList = new SinglyLinkedList<Integer>();

        //When
        myList.add(5);
        myList.add(7);
        myList.add(9);
        myList.add(11);

        myList.remove(2);
        Integer expected = 3;
        Integer actual = myList.size();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void containsTest() {
        //Given
        SinglyLinkedList<Integer> myList = new SinglyLinkedList<Integer>();

        myList.add(3);
        myList.add(5);
        myList.add(7);

        //When
        boolean actual = myList.contains(5);

        //Then
        Assert.assertTrue(actual);

    }

    @Test
    public void findTest() {
        //Given
        SinglyLinkedList<Integer> myList = new SinglyLinkedList<Integer>();

        myList.add(3);
        myList.add(5);
        myList.add(7);

        //When
        Integer expected = 2;
        Integer actual = myList.find(7);

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void sizeTest() {
        //Given
        SinglyLinkedList<Integer> myList = new SinglyLinkedList<Integer>();

        myList.add(1);
        myList.add(3);
        myList.add(5);
        myList.add(7);
        myList.add(9);
        myList.add(11);

        //When
        Integer expected = 6;
        Integer actual = myList.size();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getTest() {
        //Given
        SinglyLinkedList<Integer> myList = new SinglyLinkedList<Integer>();

        myList.add(1);
        myList.add(3);
        myList.add(5);
        myList.add(7);
        myList.add(9);
        myList.add(11);

        //When
        Integer expected = 7;
        Integer actual = myList.get(3);

        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void copyTest() {
        //Given
        SinglyLinkedList<Integer> myList = new SinglyLinkedList<Integer>();

        myList.add(1);
        myList.add(3);
        myList.add(5);

        //When
        Integer expected = 3;


        //Then
        Assert.assertEquals(expected, myList.copy().get(1));;
    }

    @Test
    public void sortTest() {
        //Given
        SinglyLinkedList<Integer> myList = new SinglyLinkedList<Integer>();

        myList.add(101);
        myList.add(3);
        myList.add(45);
        myList.add(70);
        myList.add(29);
        myList.add(11);

        //When
       myList.sort();
       Integer expected = 29;
       Integer actual = myList.get(2);

        //Then
        Assert.assertEquals(expected, actual);
    }



}
