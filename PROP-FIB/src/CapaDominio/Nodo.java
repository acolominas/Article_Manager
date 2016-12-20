
package CapaDominio;

import java.util.ArrayList;
import java.util.Deque;

public class Nodo {
    private String valor;
    private Nodo padre;
    private Nodo hojaIzq;
    private Nodo hojaDer;
    
    public Nodo(String valor){
        this.valor = valor;
        this.padre = null;
        this.hojaDer = null;
        this.hojaIzq = null;
    }
    
    public void setValor(String v){
        this.valor = v;
    }
    
    public void setPadre(Nodo p){
        this.padre = p;
    }
    
    public void setHojaIqz(Nodo izq){
        this.hojaIzq = izq;
    }
    
    
    public void setHojaDer(Nodo der){
        this.hojaDer = der;
    }
    
    public String getValor(){
        return this.valor;
    }
    
    public Nodo getPadre(){
        return this.padre;
    }
    
    public Nodo getHojaIzq(){
        return this.hojaIzq;
    }
    
    public Nodo getHojaDer(){
        return this.hojaDer;
    }
    
    public void addsubarbol(Deque<Nodo> nodo){
        if(this.getValor().equals("!")){
            this.setHojaIqz(nodo.pop());
        }
        else if(this.getValor().equals("&") | this.getValor().equals("|")){
            Nodo subarbolizq = nodo.pop();
            Nodo subarbolder = nodo.pop();
            this.addHijos(subarbolizq, subarbolder);
            subarbolizq.setPadre(this);
            subarbolder.setPadre(this);
            subarbolizq.addsubarbol(nodo);
            subarbolder.addsubarbol(nodo);
        }
        else System.out.println("ERROR: El número de nodos y hojas del arbol no es correcto... "); 
    }
    
    public void addHijos(Nodo hizq, Nodo hder){
        this.setHojaIqz(hizq);
        this.setHojaDer(hder);
    }
    
    public ArrayList<String> postOrder(ArrayList<String> postfijo){
        if(this.hojaIzq != null){
            this.hojaIzq.postOrder(postfijo);
        }
        if(this.hojaDer != null){
            this.hojaDer.postOrder(postfijo);
        }
        postfijo.add(this.valor);
        return postfijo;
    }
}
