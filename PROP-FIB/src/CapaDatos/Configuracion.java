package CapaDatos;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Configuracion extends Fichero{
    
//************* Constructora ***************************************************
    public Configuracion(String path){
        super(path);
    }

//************ Metodos *********************************************************    
// Devuelve un String con la direccion de la ruta asociada al fichero   
    public String getPathConfig(){
        return rOneLine(1);
    }
   
// Devuelve un String con el idioma asociado al fichero
    public String getIdiomaConfig(){
        return rOneLine(2);
    }
    
    public String getBaseLength(){
        return rOneLine(3);
    }
    
    public String getIndexRecreate(){
        return rOneLine(4);
    }
    
    public void modificarConfiguracionFichero(String path,String idioma,String baseSize,String index) throws IOException {
        FileWriter fw = null;
        PrintWriter pw = null;
        try {
            fw = new FileWriter(file);
            pw = new PrintWriter(fw);
            pw.println(path);
            pw.println(idioma);
            pw.println(baseSize);
            pw.println(index);            
        } catch (IOException e) {System.out.println(e);
        } finally {
           try {
           if (null != fw)
              fw.close();
           } catch (IOException e2) {
              e2.printStackTrace();
           }
        }
    }
}
