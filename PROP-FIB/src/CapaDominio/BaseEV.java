package CapaDominio;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class BaseEV{
    private Map<Palabra,Integer> base;
    
//************* Constructora ***************************************************
    public BaseEV(){
        base = new HashMap<>();
    }
    
//************ Getters *********************************************************
    public Map<Palabra,Integer> getBase(){
        return base;
    }
    
//************* Setters ********************************************************
    public void setBase(Map<Palabra,Integer> newbase){
        base = newbase;  
    }   
    
//************ Metodos *********************************************************
// Metodo para añadir palabras a la Base del Espacio Vectorial
    public void addContenido(List<Palabra> contenido){
        Iterator<Palabra> it = contenido.iterator();
        while(it.hasNext()){
            Palabra pal = it.next();
            if(base.containsKey(pal)) base.put(pal,base.get(pal)+1);
            else base.put(pal,1);
        }
    }
    
//Metodo para quitar un subjconjunto de palabras.
    public void quitar(List<Palabra> palabras){
        Iterator<Palabra> it = palabras.iterator();
        while(it.hasNext()){
            Palabra pal = it.next();            
            if(base.containsKey(pal)) base.remove(pal);                                
        }
    }
    
//Metodo para Ordenar, de forma decreciente, y Ajustar el tamaño de la Base al valor que recibe como parametro
    public void orderBase(Integer finish){        
        base = sortByValue(base);
        Map<Palabra,Integer> aux = new LinkedHashMap<>();
        Iterator<Palabra> it = base.keySet().iterator();
        Integer cont = 0;
        
        while(it.hasNext() && !finish.equals(cont)){
            Palabra val = it.next();
            aux.put(val,base.get(val));
            cont++;
        }
        base = aux;     
    }

//Metodo para Ordenar el EV por frecuencia de aparicion de palabra (Mayor-Menor)   
    private static <K, V extends Comparable<? super V>> Map<K, V> sortByValue( Map<K, V> map ){
        List<Map.Entry<K, V>> list = new LinkedList<>( map.entrySet() );
        Collections.sort( list, new Comparator<Map.Entry<K, V>>() {
            @Override
            public int compare( Map.Entry<K, V> o1, Map.Entry<K, V> o2 ) {
                return ( o2.getValue() ).compareTo( o1.getValue() );
            }
        } );
        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list) {
        result.put( entry.getKey(), entry.getValue() );
        }
        return result;
    }
}
