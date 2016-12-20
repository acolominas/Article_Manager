package CapaDatos;

public class BadWords extends Fichero{
    
//************* Constructora ***************************************************
    public BadWords(String path){
        super(path);
    }

//************ Metodos *********************************************************
// Devuelve un String con las palabras no deseadas (StopWords)    
    public String getStopWords(){
        return super.rMultipleLine(1,true);
    }
    
}
