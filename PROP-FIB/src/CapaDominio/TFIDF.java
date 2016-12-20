package CapaDominio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TFIDF extends EspacioVectorial{

//************* Constructora ***************************************************    
    public TFIDF(Map<Palabra,Integer> base, Documento d, Integer nroDocs) {
        super(base.size());
        vec(base,d,nroDocs);
        distance = super.calcularDistance();
    }
    
//************ Metodos *********************************************************
// Util para construir el vector asociado al documento que recibe como parametro
    private void vec(Map<Palabra,Integer> base, Documento d, Integer ndoc){
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
        while(it.hasNext()){
            Palabra pal = it.next();
            if(base.containsKey(pal)){
                double frec = base.get(pal);
                double nd = ndoc;
                double df = frec/nd;
                double idf = Math.log10(ndoc/df) + 1;
                Integer i = m.indexOf(pal);
                espVect[i]= vectf[i]*idf;
            }
        }
    }
}
