package com.zipcodewilmington.singlylinkedlist;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by leon on 1/10/18.
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





}
