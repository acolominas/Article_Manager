

package CapaPresentacion;

import CapaDatos.Configuracion;
import CapaDominio.Arbol;
import CapaDominio.ColDocs;
import CapaDominio.Documento;
import CapaDominio.EvaluarExpresion;
import CapaDominio.ExpresionBooleana;
import CapaDominio.FicheroInfo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class VistaBiblioteca extends javax.swing.JFrame {
    
     private int num_doc;
     private ColDocs docs;
     private String path_origin;
     private final int baseSize;
     private final String idioma;
     private final double indexRecreateBase;
     private final Configuracion config;
     private boolean modConfig;     
    
    public VistaBiblioteca() {
        this.config = new Configuracion("config.txt");
        this.path_origin = config.getPathConfig();
        this.idioma = config.getIdiomaConfig();
        this.baseSize = Integer.parseInt(config.getBaseLength());
        Integer index = Integer.parseInt(config.getIndexRecreate());
        this.indexRecreateBase = index;            
        this.docs = new ColDocs(this.path_origin,this.idioma,this.baseSize,this.indexRecreateBase/100.0);
        this.num_doc = docs.num_docs();               
        initComponents();
        labelNum.setText(Integer.toString(num_doc));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonConf = new javax.swing.JButton();
        buttonSalir = new javax.swing.JButton();
        buttonAbout = new javax.swing.JButton();
        buttonAlta = new javax.swing.JButton();
        buttonEliminar = new javax.swing.JButton();
        buttonModificar = new javax.swing.JButton();
        buttonParecidos = new javax.swing.JButton();
        buttonContenido = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        buttonListarTitulos = new javax.swing.JButton();
        buttonAutoresPrefijo = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        buttonExpresion = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        labelNum = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonConf.setText("Cambiar Configuración");
        buttonConf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonConfActionPerformed(evt);
            }
        });
        getContentPane().add(buttonConf, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 130, 200, -1));

        buttonSalir.setText("Salir");
        buttonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSalirActionPerformed(evt);
            }
        });
        getContentPane().add(buttonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 210, 200, -1));

        buttonAbout.setText("About");
        buttonAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAboutActionPerformed(evt);
            }
        });
        getContentPane().add(buttonAbout, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 170, 200, -1));

        buttonAlta.setText("Alta Documento");
        buttonAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAltaActionPerformed(evt);
            }
        });
        getContentPane().add(buttonAlta, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 160, -1));

        buttonEliminar.setText("Eliminar Documento");
        buttonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(buttonEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 160, -1));

        buttonModificar.setText("Modificar Documento");
        buttonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonModificarActionPerformed(evt);
            }
        });
        getContentPane().add(buttonModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 160, -1));

        buttonParecidos.setText("Documentos Parecidos");
        buttonParecidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonParecidosActionPerformed(evt);
            }
        });
        getContentPane().add(buttonParecidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, -1, -1));

        buttonContenido.setText("Mostrar Documento");
        buttonContenido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonContenidoActionPerformed(evt);
            }
        });
        getContentPane().add(buttonContenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, 141, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("# Consultas _______________________________________________________");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("! Gestión de Documentos___________");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        buttonListarTitulos.setText("Listar Titulos de un Autor");
        buttonListarTitulos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonListarTitulosActionPerformed(evt);
            }
        });
        getContentPane().add(buttonListarTitulos, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 320, 171, -1));

        buttonAutoresPrefijo.setText("Listar Autores por prefijo");
        buttonAutoresPrefijo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAutoresPrefijoActionPerformed(evt);
            }
        });
        getContentPane().add(buttonAutoresPrefijo, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 360, 171, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("                                  Biblioteca                                              ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        buttonExpresion.setText("Expresión");
        buttonExpresion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExpresionActionPerformed(evt);
            }
        });
        getContentPane().add(buttonExpresion, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 320, 120, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Numero de Articulos");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        labelNum.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        labelNum.setText("num");
        getContentPane().add(labelNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 50, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("? Informacion & Opciones________");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Universitat Politècnica de Catalunya - Facultat d'Informàtica de Barcelona");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 430, -1, -1));
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 490, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonConfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonConfActionPerformed
        //OK
        VistaConfiguracion vc = new VistaConfiguracion(this,true);             
        vc.setIdioma(idioma);
        vc.setRuta(path_origin);
        vc.setBaseSize(baseSize);
        vc.setRecreate(indexRecreateBase);
        vc.setVisible(true); 
        if(vc.getAceptar()){
            if(vc.getRuta().isEmpty() || vc.getIdioma().isEmpty() || vc.getBaseSize().isEmpty() || vc.getRecreate().isEmpty()){
                errorDatosVacios();
            }
            else{
                try {
                    config.modificarConfiguracionFichero(vc.getRuta(),vc.getIdioma(),vc.getBaseSize(),vc.getRecreate());
                } catch (IOException ex) {
                    Logger.getLogger(VistaBiblioteca.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }           
    }//GEN-LAST:event_buttonConfActionPerformed

    private void buttonAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAboutActionPerformed
        VistaAbout va = new VistaAbout();
        va.setVisible(true);
    }//GEN-LAST:event_buttonAboutActionPerformed

    private void buttonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSalirActionPerformed
        if(this.docs.existeModificaciones()){
            VistaCambios vc = new VistaCambios(this,true);
            vc.setVisible(true);
            if(vc.getAceptar()){
                try {
                    this.docs.aplicarModificaciones();
                } catch (IOException ex) {
                    Logger.getLogger(VistaBiblioteca.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        System.exit(0);
    }//GEN-LAST:event_buttonSalirActionPerformed

    private void buttonAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAltaActionPerformed
        //OK
        VistaAlta va = new VistaAlta(this,true);
        va.setVisible(true);
        if(va.getAceptar()){
            String titulo = va.getTitulo();
            String autor = va.getAutor();
            String link = va.getLink();
            String temas = va.getTemas();
            String contenido = va.getContenido();
            boolean correcto = !titulo.isEmpty() & !autor.isEmpty() & !temas.isEmpty() & !contenido.isEmpty();
            if (!correcto){
                errorDatosVacios();
            }
            else{
                FicheroInfo fi = new FicheroInfo(titulo,autor,link,temas);
                Integer res = null;
                try {
                    res = docs.altaDoc(fi,contenido,path_origin);
                } catch (IOException ex) {
                    Logger.getLogger(VistaBiblioteca.class.getName()).log(Level.SEVERE, null, ex);
                }
                if(res != -1 ){
                    JOptionPane.showMessageDialog(va, "El Documento se creo con Exito con el ID num: " + res, "Documento creado", JOptionPane.INFORMATION_MESSAGE);
                    
                }
                else {
                    JOptionPane.showMessageDialog(va, "Hubo un problema, el Documento no se creo! Intentelo de nuevo", "Documento no creado", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_buttonAltaActionPerformed

    private void buttonParecidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonParecidosActionPerformed
        //OK
        VistaParecidos vp = new VistaParecidos(this,true);
        vp.setVisible(true);
        if(vp.getAceptar()){
            if (isNumeric(vp.getId()) & isNumeric(vp.getK())){
                Integer id = Integer.parseInt(vp.getId());
                Integer k = Integer.parseInt(vp.getK());
                String metodo = vp.getMetodo();
                if(docs.getCjto_doc().containsKey(id) & k > 0 & metodo != null){
                    List<Integer> ids = new ArrayList();
                    ids = docs.obtenerSimilitudes(id,metodo, k);
                    Map<Integer,String> res = new HashMap<Integer,String>();
                    for(Integer i: ids) res.put(i,docs.getCjto_doc().get(i).getTitulo().getNombre());
                    VistaParecidosRes vpr = new VistaParecidosRes(this,true,res);
                    vpr.setVisible(true);
                }
                else{
                    errorDatos();
                }
            }
            else{
                errorDatos();
            }
        }
    }//GEN-LAST:event_buttonParecidosActionPerformed

    private void buttonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEliminarActionPerformed
        //OK
        boolean exit = false;
        while(!exit){
            VistaSelect vs = new VistaSelect(this,true);
            vs.setVisible(true);
            if(vs.getCancelar()) exit = true;
            if(vs.getAceptar()) { 
                if(isNumeric(vs.getTextID())){
                    Integer id = Integer.parseInt(vs.getTextID());   
                    if (docs.getCjto_doc().containsKey(id)) {
                        exit = true;
                        docs.eliminarDoc(id);
                    }
                    else errorNoEncontrado();                    
                }else errorDatos();
            }
        }
    }//GEN-LAST:event_buttonEliminarActionPerformed

    private void buttonListarTitulosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonListarTitulosActionPerformed
        //OK
        VistaAutorTitulos vat = new VistaAutorTitulos(this,true);
        vat.setVisible(true);
        if(vat.getAceptar()){
            ArrayList<String> titulos = new ArrayList<String>();
            String autor = vat.getAutor();
            if(this.docs.getAutitulos().containsKey(autor)){
                titulos = this.docs.listarTitulos(autor);
                VistaTitulosRes vtr = new VistaTitulosRes(this,true,titulos);
                vtr.setVisible(true);
            }
            else{
                errorNoEncontrado();
            }
        }
    }//GEN-LAST:event_buttonListarTitulosActionPerformed

    private void buttonAutoresPrefijoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAutoresPrefijoActionPerformed
        //OK
        VistaAutores va = new VistaAutores(this,true);  
        va.setVisible(true);
        if(va.getAceptar()){
            ArrayList<String> res = new ArrayList<String>();
            String prefijo = va.getPrefijo();
            if(prefijo.equals("")) errorDatosVacios();
            else{
                res = this.docs.listarAutores(prefijo);
                if(res.isEmpty()) errorNoEncontrado();
                else{
                    VistaPrefijoRes vpr = new VistaPrefijoRes(this,true,res);
                    vpr.setVisible(true);
                }
            }
        }
    }//GEN-LAST:event_buttonAutoresPrefijoActionPerformed

    private void buttonContenidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonContenidoActionPerformed
        //OK
        boolean exit = false;
        while(!exit){
            VistaSelect vs = new VistaSelect(this,true);        
            vs.setVisible(true);
            if(vs.getCancelar()) exit = true;
            if(vs.getAceptar()) {
                if(isNumeric(vs.getTextID())){
                    Integer id = Integer.parseInt(vs.getTextID());
                    if (docs.getCjto_doc().containsKey(id)) {
                        Documento doc = docs.getCjto_doc().get(id);
                        VistaDocumento vd = new VistaDocumento(this,true);
                        vd.setTitulo(doc.getTitulo().getNombre());
                        vd.setAutor(doc.getAutor());
                        vd.setLink(doc.getLink());
                        vd.setTemas(doc.getTemasString());
                        vd.setContenido(doc.getContenido().getNombre());
                        vd.setVisible(true);
                        exit = true;
                    }
                    else {
                        errorNoEncontrado();
                    }
                }
                else{
                    errorDatos();
                }
            }
        }          
    }//GEN-LAST:event_buttonContenidoActionPerformed

    private void buttonExpresionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExpresionActionPerformed
        VistaExpresion ve = new VistaExpresion(this,true); 
        ve.setVisible(true);
        if(ve.getAceptar()){
            String expresion = ve.getExpresion();            
            if(!expresion.equals("")){                
                ExpresionBooleana ex = new ExpresionBooleana(expresion);
                if(ex.validarExpresion(idioma)){                    
                    ArrayList<String> postfijo = ex.expPosfijo();
                    EvaluarExpresion evalexp = new EvaluarExpresion(postfijo);                    
                    Map<Integer,String> res = new HashMap<Integer,String>();
                    Iterator<Integer> it = this.docs.getCjto_doc().keySet().iterator();                    
                    while(it.hasNext()){
                        Integer id = it.next();                        
                        if(evalexp.evaluar(this.docs.getCjto_doc().get(id))) res.put(id, this.docs.getCjto_doc().get(id).getTitulo().getNombre());
                    }
                    VistaExpRes vis = new VistaExpRes(this,true,res);
                    vis.setVisible(true);   
                }
                else errorExpresion();
            }
            else errorExpresion();
        }
    }//GEN-LAST:event_buttonExpresionActionPerformed

    private void buttonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonModificarActionPerformed
        //OK
        boolean exit = false;
        while (!exit){
            VistaSelect vs = new VistaSelect(this,true);        
            vs.setVisible(true);
            if(vs.getCancelar()) exit = true;
            if(vs.getAceptar()) {
                if(isNumeric(vs.getTextID())){
                    Integer id = Integer.parseInt(vs.getTextID());
                    if (docs.getCjto_doc().containsKey(id)) {
                        exit = true;
                        Documento doc = docs.getCjto_doc().get(id);
                        VistaModificar md = new VistaModificar(this,true);                
                        md.setTitle(doc.getTitulo().getNombre());
                        md.setAutor(doc.getAutor());
                        md.setLink(doc.getLink());
                        md.setTemas(doc.getTemasString());
                        md.setContenido(doc.getContenido().getNombre());
                        md.setVisible(true);
                        if(md.getAceptar()){
                            String titulo = md.getTitle();
                            String autor = md.getAutor();
                            String link = md.getLink();
                            String temas = md.getTemas();
                            String contenido = md.getContenido();
                            boolean correcto = !titulo.isEmpty() & !autor.isEmpty() & !temas.isEmpty() & !contenido.isEmpty();
                            if (!correcto){
                                errorDatosVacios();
                            }
                            else{
                                titulo = (titulo.equals(doc.getTitulo().getNombre())) ? doc.getTitulo().getNombre() : titulo;
                                autor = (autor.equals(doc.getAutor())) ? doc.getAutor() : autor;
                                link = (link.equals(doc.getLink())) ? doc.getLink() : link;
                                temas = (temas.equals(doc.getTemasString())) ? doc.getTemasString() : temas;
                                contenido = (contenido.equals(doc.getContenido().getNombre())) ? doc.getContenido().getNombre() : contenido;
                                boolean res = this.docs.modificarDoc(id,new FicheroInfo(titulo,autor,link,temas),contenido);
                                if(res) {
                                    JOptionPane.showMessageDialog(md, "El Documento con el ID num: " + id+" se ha modificado correctamente", "Documento creado", JOptionPane.INFORMATION_MESSAGE);
                                }
                                else{
                                    JOptionPane.showMessageDialog(md,"ERROR.El Documento no se ha modificado!","Error", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                        }
                    }
                    else errorNoEncontrado();                    
                } else errorDatos();               
            }
        }
    }//GEN-LAST:event_buttonModificarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaBiblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaBiblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaBiblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaBiblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaBiblioteca().setVisible(true);
            }
        });
    }
    
    private static boolean isNumeric(String cadena){
    	try {
    		Integer.parseInt(cadena);
    		return true;
    	} catch (NumberFormatException nfe){
    		return false;
    	}
    }
    
    private void errorDatos(){
        JOptionPane.showMessageDialog(this, "Los Datos introducidos no son correctos", "Datos Incorrectos", JOptionPane.WARNING_MESSAGE);
    }
    
    private void errorDatosVacios(){
        JOptionPane.showMessageDialog(this,"Exiten campos vacios!","Error", JOptionPane.WARNING_MESSAGE);  
    }
    
    private void errorNoEncontrado(){
        JOptionPane.showMessageDialog(this, "El dato solicitado no existe en la colección", "No Encontrado", JOptionPane.WARNING_MESSAGE);
    }
    
    private void errorExpresion(){
        JOptionPane.showMessageDialog(this, "La expresión no es valida", "Expresion no valida", JOptionPane.WARNING_MESSAGE);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAbout;
    private javax.swing.JButton buttonAlta;
    private javax.swing.JButton buttonAutoresPrefijo;
    private javax.swing.JButton buttonConf;
    private javax.swing.JButton buttonContenido;
    private javax.swing.JButton buttonEliminar;
    private javax.swing.JButton buttonExpresion;
    private javax.swing.JButton buttonListarTitulos;
    private javax.swing.JButton buttonModificar;
    private javax.swing.JButton buttonParecidos;
    private javax.swing.JButton buttonSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel labelNum;
    // End of variables declaration//GEN-END:variables
}
