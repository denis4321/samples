/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch09.jdbc.sample5.myfilteredrowset;

/**
 *
 * @author Denys.Prokopiuk
 */
public class Main {
    
    public static void main(String[] args) {
        MyFilteredRowSetDAO dao = new MyFilteredRowSetDAO();
        dao.makeCall();
    }
    
}
