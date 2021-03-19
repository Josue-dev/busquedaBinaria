/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras3.arbol;

import java.util.Iterator;

/**
 *
 * @author ajvasquez
 */
public interface Arbol<E> {
    public int zise();//nos devolvera el tamaño
    public boolean isEmpty();//nos devolvera true si esta vacio
    Iterator iterator();//nos devolvera un iterador con todos sus elementos
    Iterable positions();//devolvemos ua coleccion con todos sus nodos
    Position<E> root(); //devolvemos la raiz del arbol
    Position<E>parent(Position<E> p);//devuelve el padre del nodo
    Iterable children(Position<E>p);//devuelve una lista con todos sus hijos nodos de un nodo
    boolean isLeaf(Position<E>p);//preguntamos si el nodo es hoja o no
    boolean isInternal(Position<E>p);//Preguntamos si un nodo es interno o no
    boolean isRoot(Position<E>p);//preguntamos si este nodo es raiz
    E replace(Position<E>p, E elemento);//reemplaza el elemento del nodo (p) poe el elemento (e);
    
}
