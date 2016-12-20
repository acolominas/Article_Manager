package CapaDominio;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.Stack;

public class ExpresionBooleana {
    private Deque<Operador> stackNodo;
    private Deque<Nodo> stackHoja;
    private String exp;
    
    public ExpresionBooleana(String exp){
        this.exp = exp;
        this.stackNodo = null;
        this.stackHoja = null;
    }
    
    public void SetExp(String expre){
        this.exp = expre;
    }
    
    public void SetStackNodo(Deque<Operador> sn){
        this.stackNodo = sn;
    }
    
    public void SetStackHoja(Deque<Nodo> sh){
        this.stackHoja = sh;
    }
    
    public String getExp(){
        return this.exp;
    }
    
    public Deque<Operador> getStackNodo(){
        return this.stackNodo;
    }
    
    public Deque<Nodo> getStackHoja(){
        return this.stackHoja;
    }
    
    public boolean validarExpresion(String idioma){
        StopWords sw = new StopWords(idioma);
        String delimitators = "[ .,;?{}¿\'\"\\[\\]]+";
        String[] wordseparate = exp.split(delimitators);
        for(String ws: wordseparate){
            if(sw.contienePalabra(ws)) return false;
        }
        return armarExp(wordseparate);
    }
    
    private boolean armarExp(String [] wordseparate){
       Deque<Operador> pilaNodos = new ArrayDeque<Operador>();
       Deque<Nodo> pilaHojas = new ArrayDeque<Nodo>();
       for(String ws: wordseparate){
           switch(ws){
               case "(":
                   Operador oppi = new Operador(ws);
                   pilaNodos.push(oppi);
               break;
               case ")":
                   while(!pilaNodos.isEmpty() && !pilaNodos.peek().getValor().equals("(")){
                       if(pilaNodos.peek().getNroperandos() == 1 && pilaHojas.size() >= 1){
                                Nodo subarbol = new Nodo(pilaNodos.pop().getValor());
                                subarbol.setHojaIqz(pilaHojas.pop());
                                pilaHojas.push(subarbol);
                       }
                       else if(pilaNodos.peek().getNroperandos() == 2 && pilaHojas.size() >= 2){
                               Nodo subarbol = new Nodo(pilaNodos.pop().getValor());
                               subarbol.setHojaIqz(pilaHojas.pop());
                               subarbol.setHojaDer(pilaHojas.pop());
                               pilaHojas.push(subarbol);
                       }
                       else return false;
                   }
                   if(pilaNodos.peek().getValor().equals("(")) pilaNodos.pop();
               break;
               case "&":
                   Operador op = new Operador(ws);
                   if(pilaNodos.isEmpty()) pilaNodos.push(op);
                   else if(pilaNodos.peek().esPriority(op)){
                       while(!pilaNodos.isEmpty() && pilaNodos.peek().esPriority(op)){
                           if(pilaNodos.peek().getNroperandos() == 1 && pilaHojas.size() >= 1){
                                Nodo subarbol = new Nodo(pilaNodos.pop().getValor());
                                subarbol.setHojaIqz(pilaHojas.pop());
                                pilaHojas.push(subarbol);
                            }
                           else if(pilaNodos.peek().getNroperandos() == 2 && pilaHojas.size() >= 2){
                               Nodo subarbol = new Nodo(pilaNodos.pop().getValor());
                               subarbol.setHojaIqz(pilaHojas.pop());
                               subarbol.setHojaDer(pilaHojas.pop());
                               pilaHojas.push(subarbol);
                           }
                       }   
                    pilaNodos.push(op);
                   }
                   else pilaNodos.push(op);
               break;               
               case "|":
                   Operador op1 = new Operador(ws);
                   if(pilaNodos.isEmpty()) pilaNodos.push(op1);
                   else if(pilaNodos.peek().esPriority(op1)){
                       while(!pilaNodos.isEmpty() && pilaNodos.peek().esPriority(op1)){
                           if(pilaNodos.peek().getNroperandos() == 1 && pilaHojas.size() >= 1){
                                Nodo subarbol = new Nodo(pilaNodos.pop().getValor());
                                subarbol.setHojaIqz(pilaHojas.pop());
                                pilaHojas.push(subarbol);
                            }
                           else if(pilaNodos.peek().getNroperandos() == 2 && pilaHojas.size() >= 2){
                               Nodo subarbol = new Nodo(pilaNodos.pop().getValor());
                               subarbol.setHojaIqz(pilaHojas.pop());
                               subarbol.setHojaDer(pilaHojas.pop());
                               pilaHojas.push(subarbol);
                           }
                       }
                     pilaNodos.push(op1);
                   }
                   else pilaNodos.push(op1);
               break;
               case "!":
                   Operador op2 = new Operador(ws);
                   pilaNodos.push(op2);
               break;
               default:
                   Nodo hoja = new Nodo(ws);
                   pilaHojas.push(hoja);
               break;
           }
       }
       
       while(pilaNodos.size()>1){
            if(pilaNodos.peek().getNroperandos() == 1 && pilaHojas.size() >=1){
                Nodo subarbol = new Nodo(pilaNodos.pop().getValor());
                subarbol.setHojaIqz(pilaHojas.pop());
                pilaHojas.push(subarbol);
            }
            else if(pilaNodos.peek().getNroperandos() == 2 && pilaHojas.size() >= 2){
                Nodo subarbol = new Nodo(pilaNodos.pop().getValor());
                subarbol.setHojaIqz(pilaHojas.pop());
                subarbol.setHojaDer(pilaHojas.pop());
                pilaHojas.push(subarbol);
            }
            else return false;
        }
       this.stackHoja = pilaHojas;
       this.stackNodo = pilaNodos;
       return true;
    }
    
    public ArrayList<String> expPosfijo(){
        ArrayList<String> posfijo = new ArrayList<String>();
        Arbol arbol = new Arbol("");
        if(this.stackNodo.isEmpty() && this.stackHoja.size() == 1){
            arbol.setRaiz(this.stackHoja.pop());
        }
        else if(this.stackNodo.size() == 1 && !stackHoja.isEmpty()){
            Nodo raiz = new Nodo(this.stackNodo.pop().getValor());
            arbol.setRaiz(raiz);
            if(arbol.getRaiz().getValor().equals("!")){
                arbol.getRaiz().setHojaIqz(this.stackHoja.pop());
            }
            else if(arbol.getRaiz().getValor().equals("&") | arbol.getRaiz().getValor().equals("|")){
                arbol.getRaiz().addHijos(this.stackHoja.pop(), this.stackHoja.pop());
            }
            else System.out.println("ERROR: El número de nodos y hojas del arbol no es correcto... ");
        }
        return arbol.getRaiz().postOrder(posfijo);
    }
}
