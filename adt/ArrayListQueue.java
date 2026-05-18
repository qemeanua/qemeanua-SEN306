package adt;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.ArrayList;
import java.util.List;

public class ArrayListQueue implements QueueADT {

    public ArrayListQueue() {
        //empty because nothing special needs to be done when creating the queue
    }
    private List<Integer> list = new ArrayList<>();

    @Override
    public void enqueue(int element) {
        list.add(element);
    }

    @Override
    public int dequeue() {
        if (isEmpty()) throw new RuntimeException("Queue empty");
        return list.remove(0);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int size() {
        return list.size();
    }
}
