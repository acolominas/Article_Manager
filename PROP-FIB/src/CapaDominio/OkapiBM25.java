package CapaDominio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class OkapiBM25 extends EspacioVectorial{
    
//************* Constructora ***************************************************
    public OkapiBM25(Map<Palabra,Integer> base, Documento d, double avgDL, Integer ndocs){
        super(base.size());
        vec(base,d,avgDL,ndocs);
        distance = super.calcularDistance();
    }
    
    private void vec(Map<Palabra,Integer> base, Documento d, double avgDL, Integer ndoc){
        TF tf = d.getTF();        
        if (tf == null){
            tf = new TF(base,d);
            d.setTF(tf);
        }
        
        ArrayList<Palabra> con = new ArrayList<>();
        con = (ArrayList<Palabra>) d.getContenido().convertToPalabra();
        Set<Palabra> set = base.keySet();
        ArrayList<Palabra> m = new ArrayList<>(set);
        Iterator<Palabra> it = con.iterator();
        double [] vectf = tf.getEspVect();        
        double k1 = 2.0;
        double b = 0.75;        
        while(it.hasNext()){
            Palabra pal = it.next();
            if(base.containsKey(pal)){
                Integer i = m.indexOf(pal);
                double frec = base.get(pal);
                double nd = ndoc;
                double df = frec/nd;
                double idf = Math.log10(ndoc/df) + 1;
                double aux = (vectf[i]*(k1+1))/(vectf[i] + k1*(1-b+b*ndoc/avgDL));
                espVect[i]= idf*aux;
            }
        }
    }
}
