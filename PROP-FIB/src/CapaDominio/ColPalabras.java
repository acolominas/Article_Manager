package CapaDominio;

import java.util.ArrayList;
import java.util.List;


public abstract class ColPalabras {
    private List<Palabra> cjto_pal;
    
//************* Constructora ***************************************************
    public ColPalabras(){
        this.cjto_pal = new ArrayList<>();
    }
    
//************ Getters *********************************************************
    public List<Palabra> getCjto_pal(){
        return  cjto_pal;
    }

//************* Setters ********************************************************
    public void setPalabras(List<Palabra> cjto_pal){        
        this.cjto_pal = cjto_pal;
    }
}
