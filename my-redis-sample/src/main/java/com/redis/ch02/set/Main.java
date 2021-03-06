/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redis.ch02.set;

import com.redis.ch01.list.*;
import java.util.List;
import java.util.Set;
import redis.clients.jedis.Jedis;

/**
 *
 * @author denis
 */
public class Main {

    public static void main(String[] args) {
        //Connecting to Redis server on localhost 
        Jedis jedis = new Jedis("localhost");
        System.out.println("Connection to server sucessfully");

        //store data in redis list 
        jedis.lpush("tutorial-list", "Redis");
        jedis.lpush("tutorial-list", "Mongodb");
        jedis.lpush("tutorial-list", "Mysql");
        jedis.lpush("tutorial-list", "Mysql");
        // Get the stored data and print it 
        Set<String> set = jedis.keys("tutorial-list");
        for (String s: set) {
            System.out.println("Stored string in redis:: " + s);
        }
    }

}
