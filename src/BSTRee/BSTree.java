/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BSTRee;

import estructuras3.LinkedBinaryTree.BinaryLinkedTree;
import estructuras3.arbol.Position;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author ajvasquez
 */
public class BSTree<E>  {
    int size;
   BinaryLinkedTree<E> tree;
   Comparator<E> comparator;
   
   public BSTree(){
       size=0;
       tree=new BinaryLinkedTree<E>();
       tree.addRoot(null);
       comparator=new ComparadorSimple<E>();
   }
   
   public BSTree(Comparator<E>comp){
       size=0;
       tree=null;
       comparator=comp;
   }
   
   public boolean isEmpty(){
       if(size==0){
           return true;
           
       }else{
           return false;
       }
   }
   
   public int size(){
       return size();
   }
   /* metodo nos servira para insertar borrar y buscar*/
   protected Position<E> busquedaEnArbol(Position<E> p,E value){
       if(tree.isLeaf(p)){//en caso del que el nodo sea externo posicion null lista para expandir
           return p;
       }else{
           E valueActual = p.elemento();
           int comparacion = comparator.compare(value, valueActual);
           if(comparacion<0){
               return busquedaEnArbol(tree.izquierda(p),value);
           }else if(comparacion>0){
               return busquedaEnArbol(tree.derecho(p), value);
           }else{
               return p;//arbol encontrado devuelve valor y posicion
           }
       }
   }
   
   //crear nuevo nodo con dos hijos
   protected Position<E>expandirHoja(Position<E> p, E value1, E value2){
       tree.addIzquierda(p, value1);
       tree.addDerecho(p, value2);
       return p;
   }
   
   protected Position<E>insertarEnHoja(Position<E> p, E value){
       this.expandirHoja(p, null, null);
       this.Replace(p, value);
       this.size++;
       return p;
       
   }
   
   protected Position<E>Replace(Position<E>p, E value){
       tree.replace(p, value);
       return p;
   }
   
   public Position<E> insert(E value){
       Position<E>p =this.busquedaEnArbol(tree.root(), value);
       if(p.elemento() !=value){
            this.insertarEnHoja(p, value);
       }
      
       return p;
   }
   
   public Position<E>sucesor(Position<E>p){
       Position<E> sucesor=p;
       if(!tree.isLeaf(tree.derecho(p))){
           sucesor = tree.derecho(p);
       }
       while(tree.isInternal(tree.izquierda(sucesor))){
           sucesor = tree.izquierda(sucesor);
       }
       return sucesor;
   }
   
   public Position<E> remove(E value){
       Position<E> posrem= this.busquedaEnArbol(tree.root(), value);
       Position<E> aux =posrem;
       //caso 1 es un nodo con sus externos son null
       if((tree.izquierda(posrem)==null)&&(tree.derecho(posrem)==null)){
           posrem = null;
           this.size--;
       }
       if(((tree.izquierda(posrem)!=null)&&(tree.derecho(posrem)==null))||((tree.izquierda(posrem)==null)&&(tree.derecho(posrem)!=null))){
           tree.remove(posrem);
           this.size--;
       }else{
            Position<E> sucesor=this.sucesor(posrem);
            this.Replace(posrem, sucesor.elemento());
            tree.remove(tree.izquierda(sucesor));
            //tree.remove(tree.derecho(sucesor));
            tree.remove(sucesor);
            this.size--;
       }
       return posrem;
       
   }
   
   public Position<E>buscar(E value){
       return busquedaEnArbol(tree.root(),value);
   }
   public void addList(List<E>lista){
      List<E>l = lista;
      Iterator<E> it = l.listIterator();
      while(it.hasNext()){
          E value = it.next();
          this.insert(value);
      }
   }
   
}
