package CapaDominio;

public class Operador {
    private final String valor;
    private final int prioridad;
    private final int nroperandos;
    
    public Operador(String val){
        this.valor = val;
        switch(val){
            case "(":
                this.prioridad = 10;
                this.nroperandos = 0;
            break;
            case "!": 
                this.prioridad = 1;
                this.nroperandos = 1;
            break;
            
            case "&":
                this.prioridad = 2;
                this.nroperandos = 2;
            break;
            
            case "|":
                this.prioridad = 3;
                this.nroperandos = 2;
            break;
            
            default:
                this.prioridad = 3;
                this.nroperandos = 2;
                System.out.println("Operador No valido!!");
            break;
        }
    }
    
    public String getValor(){
        return valor;
    }
    
    public int getNroperandos(){
        return nroperandos;
    }
    
    public int getPriority(){
        return prioridad;
    }
    
    public boolean esPriority(Operador op2){
        if(op2 == null) return true;
        return this.prioridad < op2.getPriority();
    }
}
