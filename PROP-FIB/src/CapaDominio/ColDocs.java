package CapaDominio;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ColDocs {
    private Map<Integer,Documento> cjto_doc;
    private Map<String,Map<String,Integer>> autitulos;
    private Map<Integer,Pair<Documento,String>> modificaciones;
    private BaseEV base;
    private StopWords sw;
    private double avgDl;
    private double num_adds;
    private int baseSize;
    private double indexBase;
    
//************* Constructora ***************************************************
    public ColDocs(String path, String idioma,int baseSize,double indexBase){
        File dir = new File(path);
        if (!dir.exists()) System.out.println(" No hay ficheros en el directorio especificado");
        else {
            this.baseSize = baseSize;
            this.indexBase = indexBase;
            avgDl = 0;
            num_adds = 0;
            cjto_doc = new HashMap<>();
            autitulos = new HashMap<>();
            modificaciones = new HashMap<>();
            base = new BaseEV();
            sw = new StopWords(idioma);
            String [] docs = dir.list();
            Arrays.sort(docs);
            int val = 1;
            for (String dc : docs){
            	dc = path + "\\" + dc;
                Documento d = new Documento(val,dc);
                this.cjto_doc.put(val,d);
                addTitulos(d);                
                base.addContenido(d.getContenido().convertToPalabra());
                base.addContenido(d.getTemas());
                base.addContenido(d.getTitulo().convertToPalabra());
                avgDl += d.getContenido().convertToPalabra().size();
                val++;
            }
            avgDl /= cjto_doc.size();
            base.quitar(sw.getCjto_pal());
            base.orderBase(baseSize);
            calcularVectores();            
        }
    }
   
//************ Getters *********************************************************
    public Map<Integer,Documento> getCjto_doc(){
        return this.cjto_doc;
    }
    
    public Map<String,Map<String,Integer>> getAutitulos(){
        return this.autitulos;
    }
    
    public Map<Integer,Pair<Documento,String>> getModificaciones(){
        return this.modificaciones;
    }
    
    public BaseEV getBase(){
        return this.base;
    }
    
    public StopWords getSw(){
        return this.sw;
    }
    
    public double getAvgDL(){
        return avgDl;
    }
//************* Setters ********************************************************    
    public void setCjto_doc(Map<Integer, Documento> m){
        this.cjto_doc = m;
    }
    
    public void setAutitulos(Map<String,Map<String,Integer>> au){
        this.autitulos = au;
    }
    
    public void setModificaciones(Map<Integer,Pair<Documento,String>> mod){
        this.modificaciones = mod;
    }
    
    public void setBase(BaseEV b){
        this.base = b;
    }
    
    public void setSw(StopWords s){
        this.sw = s;
    }
    
    public void setAvgDL(double avg){
        this.avgDl = avg;
    }
//************ Metodos *********************************************************
// num_docs devuelve el nro de documentos totales dentro de la coleccion
    public int num_docs(){
        return getCjto_doc().size();
    }

// devuelve True si el documento se creo con exito de lo contrario False
    public int altaDoc(FicheroInfo info, String conte, String path) throws IOException{
        int alta = -1;
        Integer val = Collections.max(cjto_doc.keySet());
        val++;
        num_adds++;
        String dn = (path + "\\" + val + ".txt");
        Documento dnew = new Documento(val,dn,info,conte);
        //CREAMOS LOS VECTORES
        dnew.setTF(new TF(base.getBase(),dnew));
        dnew.setTF_IDF(new TFIDF(base.getBase(),dnew,cjto_doc.size()));
        dnew.setOkapi(new OkapiBM25(base.getBase(),dnew,avgDl,cjto_doc.size()));
        cjto_doc.put(val, dnew);
        modificaciones.put(val, new Pair(dnew,"guardar"));
        addTitulos(dnew);
        
        if(num_adds/cjto_doc.size() > indexBase) {
            calcularBase();
            calcularVectores();
        }
        
        if(cjto_doc.containsKey(val)) alta = val;
        
        return alta;
    }
    
// Util para modificar atributos de un documento de la coleccion
    public boolean modificarDoc(Integer id, FicheroInfo fi, String contenido){
        Documento dmod = this.cjto_doc.get(id);
        dmod.modificarDocumento(fi, contenido);
        //ACTUALIZAMOS VECTORES   
        dmod.setTF(new TF(base.getBase(),dmod));
        dmod.setTF_IDF(new TFIDF(base.getBase(),dmod,cjto_doc.size()));
        dmod.setOkapi(new OkapiBM25(base.getBase(),dmod,avgDl,cjto_doc.size()));
        
        this.cjto_doc.put(id, dmod);
        Map<String,Integer> map = new HashMap<>();
        map.put(fi.Titulo,id);        
        this.autitulos.put(fi.Autor,map);
        this.modificaciones.put(id,new Pair(dmod,"guardar"));
        return this.modificaciones.containsKey(id);
    }
    
// Util para eliminar un documento de la coleccion 
    public boolean eliminarDoc(Integer id){
        Documento delim = this.cjto_doc.get(id);
        this.cjto_doc.remove(id);
        this.modificaciones.put(id,new Pair(delim,"eliminar"));
        return this.modificaciones.containsKey(id);
    }
    
// Util para cargar el Mapa de Autores con cada uno de sus Titulos
    private void addTitulos(Documento d){
        if(this.autitulos.containsKey(d.getAutor())){
                    this.autitulos.get(d.getAutor()).put(d.getTitulo().getNombre(),d.getId());
                } else {
                    Map<String,Integer> map = new HashMap<>();
                    map.put(d.getTitulo().getNombre(), d.getId());
                    this.autitulos.put(d.getAutor(), map);
                }
    }
    
// Util para Listar todos los titulos del autor que recibe como parametro
    public ArrayList<String> listarTitulos(String autor){
        Map<String,Integer> map = this.autitulos.get(autor);
        Iterator<String> it = map.keySet().iterator();
        ArrayList<String> titulos = new ArrayList<String>();
        while(it.hasNext()){
            titulos.add(it.next());
        }
        return titulos;
    }
    
// Util para mostrar por pantalla el contenido del (id) documento que recibe como parametro 
    public String verContenido(Integer id){
        String contenido = this.cjto_doc.get(id).getContenido().getNombre();
        return contenido;
        //System.out.println(contenido);
    }
    
// Devuelve True si existen modificaciones en los documentos de la coleccion, de lo contrario False
    public boolean existeModificaciones(){
        return !this.modificaciones.isEmpty();
    }
    
// Util para aplicar todas las modificaciones realizadas de forma permanente
    public void aplicarModificaciones() throws IOException{
        Iterator<Integer> it = this.modificaciones.keySet().iterator();
        while(it.hasNext()){
            Integer key = it.next();
            Pair<Documento,String> esd = this.modificaciones.get(key);
            if(esd.second.equals("guardar")) esd.first.guardarDocumento();
            if(esd.second.equals("eliminar")) esd.first.eliminarDocumento();
        }
    }
    
// Util para Listar todos los autores que coinciden con el prefijo recibido como parametro
    public ArrayList<String> listarAutores(String pre){
        Set<String> autores = this.autitulos.keySet();
        Iterator<String> it = autores.iterator();
        ArrayList<String> aut = new ArrayList<String>();
        while(it.hasNext()){
            String aux = it.next();
            if(aux.startsWith(pre)) aut.add(aux);
        }
        return aut;
    }
    // generar vectores similitudes
    public List<Integer> obtenerSimilitudes(Integer id1,String metodo,Integer k){        
        Iterator<Integer> it = cjto_doc.keySet().iterator();
        Documento d1 = cjto_doc.get(id1);
        double valor;
        CalculadoraSimilitud c = new CalculadoraSimilitud(); 
        Pair p = null;
        List<Pair<Integer,Double>> list = new ArrayList();
        while (it.hasNext()){
            Integer id2 = it.next();
            if(!id1.equals(id2)){
                Documento d2 = cjto_doc.get(id2);
                switch(metodo){
                    case "TF":                                        
                        valor = c.obtenerSimilitud(d1.getTF(),d2.getTF());
                        p = new Pair(id2,valor);
                        
                        break;
                    case "TF_IDF":                        
                        valor = c.obtenerSimilitud(d1.getTF_IDF(),d2.getTF_IDF());
                        p = new Pair(id2,valor);
                        break;
                    case "OKAPI":                        
                        valor = c.obtenerSimilitud(d1.getOkapi(),d2.getOkapi());
                        p = new Pair(id2,valor);
                        break;
                    default: break;
                }
                list.add(p);
            }
        }
              
        order(list);        
        List<Integer> ids = new ArrayList();
        Integer count = 1;        
        Iterator<Pair<Integer,Double>> it2 = list.iterator();
        while(it2.hasNext() && count <= k){
            Pair<Integer,Double> p2 = it2.next();
            ids.add(p2.first);
            ++count;
        }        
        return ids;
    }  
      
    private void order(List<Pair<Integer,Double>> list){
        Collections.sort(list, new Comparator<Pair<Integer,Double>>() {
        @Override
        public int compare(Pair<Integer,Double> p1, Pair<Integer,Double> p2)
        {
            return  p2.second.compareTo(p1.second);
        }
        });        
    }
    
    private void calcularBase(){
        avgDl = 0;
        num_adds = 0;
        //recalcular_base            
        Iterator<Integer> it2 = cjto_doc.keySet().iterator();
        BaseEV base2 =  new BaseEV();
        while(it2.hasNext()){
            Integer id = it2.next();
            Documento d = cjto_doc.get(id);                
            base2.addContenido(d.getContenido().convertToPalabra());
            base2.addContenido(d.getTemas());
            base2.addContenido(d.getTitulo().convertToPalabra());
            avgDl += d.getContenido().convertToPalabra().size();
        }
        avgDl /= cjto_doc.size();
        base2.quitar(sw.getCjto_pal());
        base2.orderBase(baseSize);
        base = base2;        
    }
    private void calcularVectores(){
    Iterator<Integer> it = cjto_doc.keySet().iterator();
        while(it.hasNext()){
            Integer id = it.next();
            Documento d = cjto_doc.get(id);
            d.setTF(new TF(base.getBase(),d));
            d.setTF_IDF(new TFIDF(base.getBase(),d,cjto_doc.size()));
            d.setOkapi(new OkapiBM25(base.getBase(),d,avgDl,cjto_doc.size()));
            cjto_doc.put(id, d);
        }            
    }
}