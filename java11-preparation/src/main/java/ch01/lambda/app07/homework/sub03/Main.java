/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch01.lambda.app07.homework.sub03;

/**
 *
 * @author DProkopiuk
 */
public class Main {

    public static void main(String[] args) {
        Runnable r = () -> System.out.println("myAction");
        Thread t = new Thread(r);
        t.start();
        Thread t2 = new Thread(() -> System.out.println("myAction2"));
        t2.start();
    }

    public static void main2(String[] args) {
        Thread t = new Thread() {

            public void run() {
                System.out.println("Do action!");
            }
        };
        t.start();
    }

}
