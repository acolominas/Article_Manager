package CapaDatos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class Fichero {
    protected final File file;
    protected final String path;

//************* Constructora ***************************************************
    public Fichero(String path){
        this.file = new File(path);
        this.path = path;
    }    

//************ Getters *********************************************************
    public String getPath(){
        return path;
    }
    
    public File getFile(){
        return file;
    }

//************ Metodos *********************************************************
// Devuelve un String de la linea leida del fichero, el parametro que recibe indica el nro de linea a leer 
    protected String rOneLine(int numLine){
        int num = 1;
        String info = "";        
        try {            
            FileInputStream fis = new FileInputStream(file);          
            InputStreamReader isr = new InputStreamReader(fis,"utf8");
            BufferedReader br = new BufferedReader(isr);            
            String line = br.readLine();  
            while (null != line && num < numLine+1) {                
                if (num == numLine) info += line;
                line = br.readLine();
                num++;
            }
            fis.close();
        }catch (IOException e) {System.out.println(e);}       
        return info;
    }
   
// Devuelve un String de la/s linea/as leidas del fichero
// el 1er parametro indica desde que linea inicia la lectura
//el 2do parametro indica que se añade delimitadores (",") si es True
    protected String rMultipleLine(int startLine,boolean delimitator){
        int num = 1;
        String info = "";
        try {    
            FileInputStream fis = new FileInputStream(file);          
            InputStreamReader isr = new InputStreamReader(fis,"utf8");
            BufferedReader br = new BufferedReader(isr);            
            String line = br.readLine();            
            while (null != line) {
		if (num >= startLine) {
                    info += line;
                    if(delimitator) info += ","; 
                }
		line = br.readLine();
                num++;
            }                      
            br.close();
            fis.close();
        }catch (IOException e) {System.out.println(e);}        
        return info; 
    }
    protected void wOneLine(int numLine,String newline){
               
    }
}
