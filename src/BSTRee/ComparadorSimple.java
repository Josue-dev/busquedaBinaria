/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BSTRee;

import java.util.Comparator;

/**
 *
 * @author ajvasquez
 */
public class ComparadorSimple<E> implements Comparator<E> {

    @Override
    public int compare(E a, E b) {
        return ((Comparable<E>)a).compareTo(b);//con este metodo compararemos diferentes tipos de datos segun el usuario decida
        
    }
    
}
