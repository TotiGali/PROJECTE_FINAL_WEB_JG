/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.comoba;

/**
 *
 * @author jordi
 */
public class COMOBA_Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Usuari usuari1 = new Usuari("Sergi10", "1234567685987034225", "sergi245386572@ejemplo.com");
        
        UserDAO.printUserDetails();
        
        UserDAO.insertUser("user4","password4","user4@emial.com");
    }
    
}
