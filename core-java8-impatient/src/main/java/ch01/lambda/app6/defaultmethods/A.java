/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch01.lambda.app6.defaultmethods;

/**
 *
 * @author prokopiukd
 */
public interface A {

    public default void process() {
        System.out.println("A.process()");
    }

}
