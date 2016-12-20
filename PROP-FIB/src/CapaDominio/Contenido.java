package CapaDominio;

import java.util.ArrayList;
import java.util.List;

public class Contenido {
    private String nombre;
    
//************* Constructora ***************************************************
   public Contenido(String contenido){
        this.nombre = contenido;
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
// Devuelve una Lista de tipo Palabra que contiene las palabras que forman el contenido   
   public List<Palabra> convertToPalabra(){
       List<Palabra> content = new ArrayList<>();
       String delimitators = "[ .,;?()!¡¿\'\"\\[\\]]+";
       String[] wordseparate = nombre.split(delimitators);
       for(String ws: wordseparate){
              content.add(new Palabra(ws)); 
       }
       return content;
   }
}