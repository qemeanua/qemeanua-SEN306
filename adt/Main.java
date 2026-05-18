/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package adt;

/**
 *
 * @author USER
 */
public class Main {
    public static void main(String[] args) {
        QueueADT queue = new ArrayListQueue(); // or LinkedList later
        queue.enqueue(10);
        queue.enqueue(20);
        System.out.println(queue.dequeue()); // 10
        System.out.println(queue.dequeue()); //this prints 20
    }
}


//stored as QueueADT but is actually the lists. this way i can swap w/o chaning the res of my code.
//override -- not making a new methos but fulfilling the one from the interface