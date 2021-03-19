/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras3.LinkedBinaryTree;

import estructuras3.arbol.Arbol;
import estructuras3.arbol.Position;

/**
 *
 * @author ajvasquez
 */
public interface InterfazBinaryTree<E> extends Arbol<E> {
    public Position<E> izquierda(Position<E>p);//dado un nodo del arbol me dara un nodo n para apuntar y acceder 
    public Position<E> derecho(Position<E>p);
    public boolean hasIzquierda(Position<E>p);
    public boolean hasDerecho(Position<E>p);
}
