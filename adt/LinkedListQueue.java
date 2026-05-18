package adt;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author USER
 */
import java.util.LinkedList;
import java.util.List;

public class LinkedListQueue implements QueueADT {
    private final LinkedList<Integer> list = new LinkedList<>();

    @Override
    public void enqueue(int element){
        list.addLast(element); //to add to the back of the queue
        
    }
    
    @Override
        public int dequeue(){
            if (isEmpty()) throw new RuntimeException("Queue is empty");
            return list.removeFirst(); //remove from the front
        }
 
    
    @Override
    public boolean isEmpty(){
        return list.isEmpty();
            
    }

@Override
    public int size(){
        return list.size();

    }



    
    
}
