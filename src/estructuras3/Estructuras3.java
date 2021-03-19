/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras3;

import BSTRee.BSTree;
import estructuras3.LinkedBinaryTree.BinaryLinkedTree;
import estructuras3.arbol.Position;
import java.util.Scanner;

/**
 *Deveremos crear la persistencia de datos para que la app cresca
 * @author ajvasquez
 */
public class Estructuras3 {

    /**
     * @param args the command line arguments
     */
    static BinaryLinkedTree<String> a = new BinaryLinkedTree<String>();//tiene que ser static para acceder desde el main
    static BSTree<Integer>b = new BSTree<Integer>();
    public static void main(String[] args) {
        
        b.insert(10);
        b.insert(11);
        b.insert(8);
        b.insert(5);
        b.insert(1);
        
        int pausa;
        pausa=0;
        
        
        
        
       /* Scanner sc = new Scanner(System.in);
        
        String cadenaUno="";
        String cadenaDos="";
     
        System.out.println("De que tema quieres que te adivine");
        cadenaUno = sc.nextLine();
        a.addRoot(cadenaUno);
        System.out.println("Dame un ejemplo de un  "  + a.root().elemento());
        cadenaUno = sc.nextLine();
        a.addIzquierda(a.root(), cadenaUno);//añadimos por izquierda
        while(cadenaDos.compareToIgnoreCase("fin")!=0){
            Estructuras3.recorreArbol(a.root());
        }//fin del while
       */
    }//fin del main
    
    public static void recorreArbol(Position<String>p){
        Scanner sc = new Scanner(System.in);
        String respuestaUno="";
        if(a.isLeaf(p)){//en caso de que sea hoja
            System.out.println(p.elemento()+ "?");
            respuestaUno = sc.nextLine();
            if(respuestaUno.compareToIgnoreCase("si")==0){
                System.out.println("Bien he acertado la respuesta!!! Volvemos a empezar");
                Estructuras3.recorreArbol(a.root());
            }else{
                System.out.println("Vaya no acerte la respuesta!!");
                System.out.println("Por favor escribeme la solución");
                String solucion = sc.nextLine();
                System.out.println("Escribe la diferencia  " + solucion + "  y  " +  p.elemento());
                String nodoInterno = sc.nextLine();
                String oldLeaf = p.elemento();//guardamos lo que habia antes de reemplazar
                a.replace(p, nodoInterno);
                a.addIzquierda(p, solucion);
                a.addDerecho(p, oldLeaf);
                System.out.println("Volvemos a empezar");
                Estructuras3.recorreArbol(a.root());
            }
        }else{
             System.out.println(p.elemento()+ "?");
             respuestaUno = sc.nextLine();
             if(respuestaUno.compareToIgnoreCase("si")==0){
                 if(a.hasIzquierda(p)){
                     Estructuras3.recorreArbol(a.izquierda(p));
                 }else{
                     System.out.println("En que estabas pensando?");
                     String respuesta = sc.nextLine();
                     a.addIzquierda(p, respuesta);
                     System.out.println("Volvemos a empezar");
                     Estructuras3.recorreArbol(a.root());
                 }
             }else{//en caso de respuwsta negativa
                  if(a.hasDerecho(p)){
                     Estructuras3.recorreArbol(a.derecho(p));
                 }else{
                     System.out.println("En que estabas pensando?");
                     String respuesta = sc.nextLine();
                     a.addDerecho(p, respuesta);
                     System.out.println("Volvemos a empezar");
                     Estructuras3.recorreArbol(a.root());
                 }
             }
        }
    }
    
}
