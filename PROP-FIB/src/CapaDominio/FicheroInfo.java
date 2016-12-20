package CapaDominio;

public class FicheroInfo {
    public String Titulo;
    public String Autor;
    public String Link;
    public String Temas;

//************* Constructora ***************************************************
    public FicheroInfo(){
        this.Titulo = "";
        this.Autor = "";
        this.Link = "";
        this.Temas = "";
    }
    
    public FicheroInfo(String titulo, String autor, String link, String temas){
        this.Titulo = titulo;
        this.Autor = autor;
        this.Link = link;
        this.Temas = temas;
    }
}
