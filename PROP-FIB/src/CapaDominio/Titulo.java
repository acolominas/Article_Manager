package CapaDominio;

import java.util.ArrayList;
import java.util.List;


public class Titulo {
    private String nombre;
   
//************* Constructora ***************************************************
    public Titulo(String frase) {
        this.nombre = frase;
    }
    
//************ Getters *********************************************************
    public String getNombre(){
        return nombre;
    }
    
//************* Setters ********************************************************
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
//************ Metodos *********************************************************
// Devuelve una Lista que contiene las palabras que forman el titulo
    public List<Palabra> convertToPalabra(){
       List<Palabra> content = new ArrayList<>();
       String delimitators = "[ .,;?!¡¿\'\"\\[\\]]+";
       String[] wordseparate = nombre.split(delimitators);
       for(String ws: wordseparate){
              content.add(new Palabra(ws)); 
       }
       return content;
    }
}
