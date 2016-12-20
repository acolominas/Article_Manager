package CapaDominio;

import static java.lang.Math.sqrt;

public abstract class EspacioVectorial {
    
    protected double[] espVect;
    protected double distance;
    
//************* Constructora ***************************************************
    public EspacioVectorial(Integer tam){
        this.espVect = new double[tam];
        this.distance = 0.0;
        for(int i=0;i<tam;++i) espVect[i]=0;
    }

//************* Setters ********************************************************
    public void  setDistance(double dis){
        this.distance = dis;
    }
    
    public void setEspVect(double[] espVect){
        this.espVect = espVect;
    }
    
//************ Getters *********************************************************
    public double[] getEspVect(){
        return espVect;
    }
    
    public double getDistance(){
        return distance;
    }
    
//************ Metodos *********************************************************
// Devuelve el valor del producto escalar del vector asociado
    public double productoEscalar(EspacioVectorial v2){
        double prod = 0;
        Integer tam = espVect.length;
        for(int i=0;i<tam;i++) prod+=v2.espVect[i]*this.espVect[i];
        return prod;
    }

// Devuelve el valor de la distancia del vector asociado
    protected double calcularDistance(){
        double dist = 0;
        for(double in : espVect){
            dist += in*in;
        }
        dist=sqrt(dist);
        return dist;
    }    
}
