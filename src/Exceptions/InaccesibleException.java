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
public class InaccesibleException extends RuntimeException {
    public InaccesibleException(String msg){
        super (msg);
    }
    
}
