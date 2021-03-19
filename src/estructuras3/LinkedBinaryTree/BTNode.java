/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras3.LinkedBinaryTree;

import estructuras3.arbol.Position;

/**
 *
 * @author ajvasquez
 */
public class BTNode<E>implements Position<E> {
    private E elemento;
    private BTNode<E>derecho;
    private BTNode<E>izquierdo;
    private BTNode<E>padre;

    public BTNode(E elemento, BTNode<E> derecho, BTNode<E> izquierdo, BTNode<E> padre) {
        this.elemento = elemento;
        this.derecho = derecho;
        this.izquierdo = izquierdo;
        this.padre = padre;
    }
    
    public BTNode(){
        elemento = null;
        derecho =null;
        izquierdo = null;
        padre=null;
    }
    public E getElemento() {
        return elemento;
    }

    public void setElemento(E elemento) {
        this.elemento = elemento;
    }

    public BTNode<E> getDerecho() {
        return derecho;
    }

    public void setDerecho(BTNode<E> derecho) {
        this.derecho = derecho;
    }

    public BTNode<E> getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(BTNode<E> izquierdo) {
        this.izquierdo = izquierdo;
    }

    public BTNode<E> getPadre() {
        return padre;
    }

    public void setPadre(BTNode<E> padre) {
        this.padre = padre;
    }

    @Override
    public E elemento() {
      return elemento;
    }
}
