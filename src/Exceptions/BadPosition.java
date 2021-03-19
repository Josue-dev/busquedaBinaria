/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

/**
 *
 * @author ajvasquez
 */
public class BadPosition extends RuntimeException{
    public BadPosition(String msg){
        super(msg);
    }
    
}
