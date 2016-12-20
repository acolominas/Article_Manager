package CapaDatos;

import CapaDominio.FicheroInfo;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Articulo extends Fichero {
    
//************* Constructora ***************************************************
    public Articulo(String path){
        super(path);
    }

//************ Metodos *********************************************************    
// Devuelve un FicheroInfo con los atributos titulo, autor, link y tema asociados
    public FicheroInfo getArticuloInfo(){
        FicheroInfo fi = new FicheroInfo(rOneLine(1),rOneLine(2),rOneLine(3),rOneLine(4));
        return fi;
    }
    
// Devuelve un String con el contenido asociado al fichero
    public String getArticuloContenido() {
        return rMultipleLine(5,false);
    }
    
    // Util para modificar el fichero en la Base de Datos
    public void modificarArticuloFichero(FicheroInfo fi,String cont) throws IOException {
        FileWriter fw = null;
        PrintWriter pw = null;
        try {
            fw = new FileWriter(file);
            pw = new PrintWriter(fw);
            pw.println(fi.Titulo);
            pw.println(fi.Autor);
            pw.println(fi.Link);
            pw.println(fi.Temas);
            pw.println(cont);
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

// Util para eliminar el fichero de la Base de Datos   
    public void eliminarFichero(){
        super.file.delete();
    }
}
