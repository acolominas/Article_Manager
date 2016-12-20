package CapaDominio;

import CapaDatos.Articulo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Documento {
    private final Integer id;
    private Titulo titulo;
    private String autor;
    private String link;
    private List<Palabra> temas;
    private Contenido contenido;
    private TF vecTF;
    private TFIDF vecTF_IDF;
    private OkapiBM25 vecOkapi;
    private final Articulo path;
    
    //CREADORA AUTOMATICA DESDE FICHERO
    public Documento(Integer id,String path){
        this.id = id;
        this.path = new Articulo(path);
        FicheroInfo fi = this.path.getArticuloInfo();
        this.titulo = new Titulo(fi.Titulo);
        this.autor = fi.Autor;
        this.link = fi.Link;
        this.temas = convertToPalabra(fi.Temas);
        this.contenido = null;
        this.vecTF = null;
        this.vecTF_IDF = null;
        this.vecOkapi = null;
    }
    
    //CREADORA DESDE MENU
    public Documento(Integer id, String path, FicheroInfo fi, String cont){
        this.id = id;
        this.path = new Articulo(path);
        this.titulo = new Titulo(fi.Titulo);
        this.autor = fi.Autor;
        this.link = fi.Link;
        this.temas = convertToPalabra(fi.Temas);
        this.contenido = new Contenido(cont);
        this.vecTF = null;
        this.vecTF_IDF = null;
        this.vecOkapi = null;
    }        

//************** Getters *******************************************************        
    public Integer getId() {
        return id;
    }
    
    public Titulo getTitulo(){
        return titulo;
    }
    
    public String getAutor(){
        return autor;
    }
    
    public String getLink(){
        return link;
    }
    
    public List<Palabra> getTemas(){
        return temas;
    }
    
    public String getTemasString(){
        return convertToString(temas);
    }

    public Contenido getContenido(){
        if (this.contenido == null) contenido = new Contenido(path.getArticuloContenido());
        return contenido;
    }
    
    public TF getTF(){
        return vecTF;
    }
    
    public TFIDF getTF_IDF(){
        return vecTF_IDF;
    }
    
    public OkapiBM25 getOkapi(){
        return vecOkapi;
    }

//************* Setters ********************************************************
    public void setTitulo(Titulo titulo){
        this.titulo.setNombre(titulo.getNombre());
    }
    
    public void setAutor(String autor){
        this.autor = autor;
    }
    
    public void setLink(String link){
        this.link = link;
    }
    
    public void setTemas(List<Palabra> listpal){
        this.temas = listpal;
    }
    
    public void setContenido(Contenido contenido){
        this.contenido = contenido;
    }
    
    public void setTF(TF tf){
        this.vecTF = tf;
    }
    
    public void setTF_IDF(TFIDF tfidf){
        this.vecTF_IDF = tfidf;
    }
    
    public void setOkapi(OkapiBM25 okapi){
        this.vecOkapi = okapi;
    }
//************ Metodos *********************************************************    
// Util para guardar el documento en la Base de Datos
    public void guardarDocumento() throws IOException{
        FicheroInfo fi = new FicheroInfo(titulo.getNombre(),autor,link,convertToString(temas));
        path.modificarArticuloFichero(fi,contenido.getNombre());        
    }
    
// Util para modificar los atributos del documento
    public void modificarDocumento(FicheroInfo fi,String cont){
        this.titulo.setNombre(fi.Titulo);
        this.autor = fi.Autor;
        this.link = fi.Link;
        this.temas = convertToPalabra(fi.Temas);
        this.contenido.setNombre(cont);
    }   
       
// Util para eliminar el Documento
    public void eliminarDocumento(){
        path.eliminarFichero();
    }
    
// Devuelve una Lista de tipo Palabra, despues de convertir el String que recibe como parametro
    private List<Palabra> convertToPalabra(String temas){
        List<Palabra> ret = new ArrayList<>();
        String [] tema = temas.split(",");
        for(String t : tema) ret.add(new Palabra(t));
        return ret;
    }
    
// Devuelve una String, despues de convertir la Lista de palabras que recibe como parametro
    private String convertToString(List<Palabra> temas){
        String ret = "";
        ret = temas.stream().map((tm) -> tm.getNombre() + ",").reduce(ret, String::concat);
        return ret;
    }
    
    // Devuelve True si el String que recibe como parametro se encuentra en el Contenido
   public boolean contienePalabra(String palabra){
       Palabra pa = new Palabra(palabra);
       return this.contenido.convertToPalabra().contains(pa);
   }
}