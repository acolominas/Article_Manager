package CapaDominio;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Arbol {
    
    private Nodo raiz;
    
    public Arbol(String valor){
        this.raiz = new Nodo(valor);
    }
    
    public Arbol(){
        this.raiz = null;
    }
    
    public void setRaiz(Nodo raiz){
        this.raiz = raiz;
    }
    
    public Nodo getRaiz(){
        return raiz;
    }
    
    public void addSubarbol(Deque<Nodo> nodo){
        if(raiz.getValor().equals("!")){
            this.raiz.setHojaIqz(nodo.pop());
        }
        else if(raiz.getValor().equals("&") | raiz.getValor().equals("|")){
            Nodo subarbolizq = nodo.pop();
            Nodo subarbolder = nodo.pop();
            this.raiz.addHijos(subarbolizq, subarbolder);
        }
        else System.out.println("ERROR: El número de nodos y hojas del arbol no es correcto... ");
    }
}
