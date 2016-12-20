package CapaDominio;

public class CalculadoraSimilitud {

//************* Constructora ***************************************************    
    public CalculadoraSimilitud(){}
    
//************ Metodos *********************************************************
// Devulve el valor asociado a la similitud entre los vectores pasados como parametro
    public double obtenerSimilitud(EspacioVectorial v1, EspacioVectorial v2){
        return v1.productoEscalar(v2)/(v1.getDistance()*v2.getDistance());       
    }
}
