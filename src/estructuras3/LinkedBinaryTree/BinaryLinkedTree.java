/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras3.LinkedBinaryTree;

import Exceptions.ArbolVacioException;
import Exceptions.BadPosition;
import Exceptions.InaccesibleException;

import estructuras3.arbol.Position;
import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;

/**
 *
 * @author ajvasquez
 */
public class BinaryLinkedTree<E> implements InterfazBinaryTree<E>{
    BTNode<E>root;
    int size;

    @Override
    public Position<E> izquierda(Position<E> p) {
        BTNode<E> nodo = checkPosition(p);
        BTNode<E>izquierdo;
        if(this.hasIzquierda(p)){
            izquierdo=nodo.getIzquierdo();
        }else{
            throw new InaccesibleException("No existe hijo izquierdo");
        }
        return izquierdo;
    }

    @Override
    public Position<E> derecho(Position<E> p) {
        BTNode<E> nodo = checkPosition(p);
        BTNode<E>derecho;
        if(this.hasDerecho(p)){
            derecho=nodo.getDerecho();
        }else{
            throw new InaccesibleException("No existe hijo derecho");
        }
        return derecho;
    }

    @Override
    public boolean hasIzquierda(Position<E> p) {
          BTNode<E> nodo = checkPosition(p);
        if(nodo.getIzquierdo()==null){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public boolean hasDerecho(Position<E> p) {
        BTNode<E> nodo = checkPosition(p);
        if(nodo.getDerecho()==null){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public int zise() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        if(size==0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Iterator iterator() {
      Iterable<Position<E>>pos = (Iterable<Position<E>>)positions();
      List<Position<E>> resultado = new ArrayList<Position<E>>();
      for(Position<E> p : pos){
          resultado.add(p);
      }
      return resultado.iterator();
    }

    @Override
    public Iterable positions() {
       List<Position<E>> lista = new ArrayList<Position<E>>();
        preOrden(this.root(), lista);
        return lista;
    }

    @Override
    public Position<E> root()throws ArbolVacioException {
        if(this.isEmpty()==true)throw new ArbolVacioException("El arbol esta vacio");
       return this.root;
    }

    @Override
    public Position<E> parent(Position<E> p) {
       BTNode<E> nodo = checkPosition(p);
       BTNode<E>parent;
        if(nodo.equals(root)){
            throw new InaccesibleException("El nodo raiz no tiene hijos");
        }else{
            parent = nodo.getPadre();
        }
        return parent;
    }

    @Override
    public Iterable children(Position<E> p) {
        BTNode<E>nodo = checkPosition(p);
        List<Position<E>>hijos = new ArrayList<Position<E>>();
        if(!this.isLeaf(p)){
             if(nodo.getIzquierdo()!=null){
                 hijos.add((Position<E>)nodo.getIzquierdo());
            }
            if(nodo.getDerecho()!=null){
                hijos.add((Position<E>)nodo.getDerecho());
            }
        }
       return hijos;
        
        
    }

    @Override
    public boolean isLeaf(Position<E> p) {
        BTNode<E>nodo = checkPosition(p);
        if((nodo.getIzquierdo()==null)&&(nodo.getDerecho()==null)){
                return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean isInternal(Position<E> p) {
        return !this.isLeaf(p);
    }

    @Override
    public boolean isRoot(Position<E> p) {
          BTNode<E>nodo = checkPosition(p);
          return nodo.equals(root);
    }

    @Override
    public E replace(Position<E> p, E elemento) {
        BTNode<E>nodo = checkPosition(p);
        E element = nodo.getElemento();
        nodo.setElemento(elemento);
        return element;
    }
    /*añadir por la derecha*/
    public BTNode<E>addDerecho(Position<E>p, E elemento){
         BTNode<E>nodo = checkPosition(p);
         BTNode<E> newnode = this.crearNodo(elemento, null, null, nodo);
         if(nodo.getDerecho()==null){
             nodo.setDerecho(newnode);
             this.size++;
         }else{
             throw new InaccesibleException("Ya se encuentra un elemento en la posicion derecha");
         }
         return newnode;
    }
     /*añadir por la izquierda*/
    public BTNode<E>addIzquierda(Position<E>p, E elemento){
         BTNode<E>nodo = checkPosition(p);
         BTNode<E> newnode = this.crearNodo(elemento, null, null, nodo);
         if(nodo.getIzquierdo()==null){
             nodo.setIzquierdo(newnode);
             this.size++;
         }else{
             throw new InaccesibleException("Ya se encuentra un elemento en la posicion izquierda");
         }
         return newnode;
    }
    /*Añadir la raiz*/
    
    public BTNode<E>addRoot(E elemento){
        BTNode<E> newnode = this.crearNodo(elemento, null, null, null);
        if(this.root==null){
            this.root = newnode;
            this.size++;
        }else{
            throw new BadPosition("Ya se encuentra se encuentra un elemento raiz");
        }
        return newnode;
    }
    
    /*METODO PARA ELIMINAR NODOS*/
    public E remove(Position<E>p){
         BTNode<E>nodo = checkPosition(p);
         BTNode<E>nIzquierdo = nodo.getIzquierdo();
          BTNode<E>nDerecho = nodo.getDerecho();
          E element = nodo.getElemento();
          if((nIzquierdo!=null)&& (nDerecho!=null) ){
              throw new BadPosition("No se pueden eliminar nodos con dos hijos");
          }else{
              BTNode<E> hijo;
              if(nDerecho!=null){//solo hijo derecho
                  hijo = nDerecho;
              }
              if(nIzquierdo!=null){//solo hijo izquierdo
                  hijo = nIzquierdo;
              }
              else{
                  //nodo hoja
                  hijo=null;
              }
              if(nodo.equals(root)){//si el nodo es raiz
                  if(hijo==null){
                      root=null;
                      size=0;
                  }else{
                      hijo.setPadre(null);
                      root=hijo;
                  }
              }else{
                  //nodo no es raiz
                  BTNode<E>abuelo = nodo.getPadre();
                  if(nodo.equals(abuelo.getIzquierdo())){
                      abuelo.setIzquierdo(hijo);
                      hijo.setPadre(abuelo);
                  }else if(nodo.equals(abuelo.getDerecho())){
                      abuelo.setDerecho(hijo);
                     
                  }
                  if(hijo!=null){
                    hijo.setPadre(abuelo);
                  }
                  
              }
              this.size--;
          }
          return element;
    }
    /*METODOS AUXILIARES*/
    
    protected BTNode<E>checkPosition(Position<E>p)throws BadPosition{
         if((p==null) || !(p instanceof BTNode))
            throw new BadPosition("Posicion no valida");
        BTNode<E> n = (BTNode<E>)p;
        return n;
    }
    
    protected BTNode<E> crearNodo(E elemento, BTNode<E>r,BTNode<E>l,BTNode<E>p){
        return new BTNode<E>(elemento,r ,l,p);
    }
    
    protected void preOrden(Position<E>p, List<Position<E>>lista){
        lista.add(p);
        if(hasIzquierda(p)){
            preOrden(izquierda(p), lista);
        }
        if(hasDerecho(p)){
            preOrden(derecho(p),lista);
        }
    }
    
}
