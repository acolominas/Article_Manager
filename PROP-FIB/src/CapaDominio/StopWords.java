package CapaDominio;

import CapaDatos.BadWords;
import java.util.ArrayList;
import java.util.List;

public class StopWords extends ColPalabras{   
    private BadWords ficheroSW;

//************* Constructora ***************************************************
    public StopWords(String Idioma){        
        super();
        String path;
        switch(Idioma){
                case "EN":  path = "SW\\swEN.txt"; break;               
                case "ES":  path = "SW\\swES.txt"; break;
                default:    path = "SW\\swCAT.txt"; break;
        }        
        this.ficheroSW = new BadWords(path);
        super.setPalabras(convertToPalabra(ficheroSW.getStopWords()));        
    }

//************ Getters *********************************************************
    public BadWords getFichero(){
        return this.ficheroSW;
    }
    
//************* Setters ********************************************************
    public void setFichero(BadWords fi){
        this.ficheroSW = fi;
    }
    
//************ Metodos *********************************************************    
// Devuelve una Lista de tipo Palabra que contiene las palabras que forman el StopWord
    private List<Palabra> convertToPalabra(String stop_words){
        List<Palabra> content = new ArrayList<>();
        String delimitators = "[ .,;?!¡¿\'\"\\[\\]]+";
        String[] wordseparate = stop_words.split(delimitators);
        for(String p : wordseparate) content.add(new Palabra(p));       
        return content;
    }
    
    public boolean contienePalabra(String palabra){
        Palabra pa = new Palabra(palabra);
        return super.getCjto_pal().contains(pa);
    }
}
