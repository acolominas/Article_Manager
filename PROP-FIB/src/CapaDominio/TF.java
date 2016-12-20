package CapaDominio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TF extends EspacioVectorial{
    
//************* Constructora ***************************************************
    public TF (Map<Palabra,Integer> base, Documento d){
        super(base.size());
        vec(base,d);
        distance = super.calcularDistance();
    }

//************ Metodos *********************************************************    
// Util para construir el vector asociado al documento que recibe como parametro
    private void vec(Map<Palabra,Integer> base, Documento d){
        ArrayList<Palabra> con = new ArrayList<>();
        con = (ArrayList<Palabra>) d.getContenido().convertToPalabra();
        Set<Palabra> set = base.keySet();
        ArrayList<Palabra> m = new ArrayList<>(set);
        Iterator<Palabra> it = con.iterator();
        while(it.hasNext()){
            Palabra pal = it.next();
            if(base.containsKey(pal)){
                Integer i = m.indexOf(pal);
                espVect[i]++;
            }
        }
    }
}
