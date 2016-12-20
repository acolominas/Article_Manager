package CapaDominio;

public class Palabra {
    private String nombre;
   
//************* Constructora ***************************************************
   public Palabra(){
       this.nombre = "";
   }
   public Palabra (String palabra) {   
    this.nombre = palabra.toLowerCase();
   }

//************ Getters *********************************************************
   public String getNombre() {
       return nombre;
   }

//************* Setters ********************************************************
   public void setNombre(String nom){
       this.nombre = nom;
   }
//************ Metodos *********************************************************
// Devuelve un codigo(entero) utilizado como identificador del objeto
   @Override
   public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
    return result;
    }
   
// Devuelve True si el objeto que recibe como parametro tiene el mismo nombre
   @Override
   public boolean equals(Object obj){      
      if (obj instanceof Palabra) {
        Palabra p1 = (Palabra) obj;
          return this.nombre.equals(p1.nombre);
      } else return false; 
   }
}
