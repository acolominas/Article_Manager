package CapaDominio;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class EvaluarExpresion {
    private ArrayList<String> postfijo;
    
    public EvaluarExpresion(ArrayList<String> exp){
        this.postfijo = exp;
    }
    
    public boolean evaluar(Documento conte){
        Deque<String> stack = new ArrayDeque<String>();
        String aux = "";
        String eval = "false";
        if(postfijo.size() == 1){
            if(conte.contienePalabra(postfijo.get(0))) eval = "true";
            else eval = "false";
        }
        else{
                for(int i=0;i < postfijo.size(); i++){
                    aux = postfijo.get(i);
                    switch(aux){
                        case "!":
                            String not = stack.pop();
                            if(conte.contienePalabra(not)) stack.push(eval="false");
                            else stack.push(eval="true");
                        break;
                        case "&":
                            String and1 = stack.pop();
                            String and2 = stack.pop();
                            switch(and1){
                                case "false":
                                    stack.push(eval="false");
                                break;
                                case "true":
                                    if(and2 == "true") stack.push(eval="true");
                                    else if(and2 != "false"){
                                        if (conte.contienePalabra(and2)) stack.push(eval="true");
                                        else stack.push(eval="false");
                                    }
                                    else stack.push(eval="false");
                                break;
                                default:
                                    if(conte.contienePalabra(and1)){
                                        if(and2 == "true") stack.push(eval="true");
                                        else if(and2 != "false"){
                                            if (conte.contienePalabra(and2)) stack.push(eval="true");
                                            else stack.push(eval="false");
                                        }
                                        else stack.push(eval="false");
                                    }
                                    else stack.push(eval="false");
                                break;
                            }
                        break;
                        case "|":
                            String or1 = stack.pop();
                            String or2 = stack.pop();
                            switch(or1){
                                case "true": stack.push(eval="true");
                                break;
                                case "false":
                                    if(or2 == "false") stack.push(eval="false");
                                    else if(or2 != "true"){
                                        if(conte.contienePalabra(or2)) stack.push(eval="true");
                                        else stack.push(eval="false");
                                    }
                                    else stack.push(eval="false");
                                break;
                                default:
                                    if(conte.contienePalabra(or1)) stack.push(eval="true");
                                    else if(or2 == "true") stack.push(eval="true");
                                    else if(or2 != "false"){
                                        if(conte.contienePalabra(or2)) stack.push(eval="true");
                                        else stack.push(eval="false");
                                    } 
                                    else stack.push(eval="false");
                                break;
                            }
                        break;
                        default:
                            stack.push(aux);
                        break;
                    }
                }
            }
        return eval.equals("true");
    }
    
}
