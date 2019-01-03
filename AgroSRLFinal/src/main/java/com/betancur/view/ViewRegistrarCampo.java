/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.betancur.view;

import com.betancur.controller.ControllerEmpresa;
import com.betancur.controller.ControllerRegistrarCampo;
import com.betancur.model.Campo;
import com.betancur.model.Empresa;
import com.betancur.model.Lote;
import com.betancur.model.TipoSuelo;
import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import java.util.AbstractList;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ariel
 */
public class ViewRegistrarCampo extends javax.swing.JPanel {
    int filaSeleccionada = 0;
    int seleccion = 0;
    ControllerRegistrarCampo controlador;
    
    //Paneles
    PanelContenedor contenedorSingleton;
    ModuloPrincipal moduloPrincipal;
    PanelRegistroConfirmacion registroConfirmado;
    
    private ValidadorDeCampos validador;
    
    private Campo nuevoCampo;
    private Lote nuevoLote;
    
    DefaultComboBoxModel modelComboBoxTipoSuelo = new DefaultComboBoxModel();
    
    DefaultTableModel modeloTablaLotes = new DefaultTableModel();
    
    /**
     * Creates new form ModuloGestorDeReclamos
     */
    public ViewRegistrarCampo() {
        initComponents();
        
        contenedorSingleton = PanelContenedor.getInstance();
        
        this.validador = new ValidadorDeCampos();
        
        //limitador de campos
        //Superficie de campo a Entero de 4 cifras
        validador.validarSoloNumero(jtf_superficieCampo);
        validador.LimitarCaracteres(jtf_superficieCampo, 4);
        
        //Superficie de Lote a Entero de 4 cifras
        validador.validarSoloNumero(jtf_numeroDeLote);
        validador.LimitarCaracteres(jtf_numeroDeLote, 2);
        
        //Superficie de Lote a Entero de 4 cifras
        validador.validarSoloNumero(jtf_superficieLote);
        validador.LimitarCaracteres(jtf_superficieLote, 4);
        
        
        
        
        controlador = new ControllerRegistrarCampo();
        
        this.modeloTablaLotes.addColumn("N°");
        this.modeloTablaLotes.addColumn("Superficie");
        this.modeloTablaLotes.addColumn("Tipo de Suelo");
        
        this.jTable_listaDeLotes.getTableHeader().setReorderingAllowed(false) ;
        this.jTable_listaDeLotes.setModel(modeloTablaLotes);
        
        for(TipoSuelo recorridoTipoSuelo : controlador.getTipoSuelo()) {
            this.modelComboBoxTipoSuelo.addElement(recorridoTipoSuelo);
        }
        
        this.jcb_tipoSueloLote.setModel(modelComboBoxTipoSuelo);
        
        this.filaSeleccionada = -1;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlbl_nombreCampo = new javax.swing.JLabel();
        jtf_nombreCampo = new javax.swing.JTextField();
        jlbl_mensajeNombreCampo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jtf_nombreUsuario = new javax.swing.JTextField();
        jlbl_superficieCampo = new javax.swing.JLabel();
        jtf_superficieCampo = new javax.swing.JTextField();
        jlbl_ha = new javax.swing.JLabel();
        jbtn_cancelarCampo = new javax.swing.JButton();
        jbtn_RegistrarCampo = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_listaDeLotes = new javax.swing.JTable();
        jbtn_quitar = new javax.swing.JButton();
        jbtn_editar = new javax.swing.JButton();
        jlbl_lotes = new javax.swing.JLabel();
        jlbl_mensajeLote1 = new javax.swing.JLabel();
        jlbl_numeroDeLote = new javax.swing.JLabel();
        jtf_numeroDeLote = new javax.swing.JTextField();
        jlbl_superficieLote = new javax.swing.JLabel();
        jtf_superficieLote = new javax.swing.JTextField();
        jlbl_tipoDeSueloLote = new javax.swing.JLabel();
        jcb_tipoSueloLote = new javax.swing.JComboBox<>();
        jlbl_mensajeLote2 = new javax.swing.JLabel();
        jbtn_agregarLote = new javax.swing.JButton();

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        setLayout(null);

        jlbl_nombreCampo.setText("Nombre:");
        add(jlbl_nombreCampo);
        jlbl_nombreCampo.setBounds(30, 20, 80, 20);

        jtf_nombreCampo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtf_nombreCampoKeyTyped(evt);
            }
        });
        add(jtf_nombreCampo);
        jtf_nombreCampo.setBounds(120, 20, 140, 20);
        add(jlbl_mensajeNombreCampo);
        jlbl_mensajeNombreCampo.setBounds(280, 20, 230, 20);

        jLabel1.setText("Usuario:");
        add(jLabel1);
        jLabel1.setBounds(520, 20, 60, 20);

        jtf_nombreUsuario.setEnabled(false);
        add(jtf_nombreUsuario);
        jtf_nombreUsuario.setBounds(610, 20, 130, 20);

        jlbl_superficieCampo.setText("Superficie:");
        add(jlbl_superficieCampo);
        jlbl_superficieCampo.setBounds(30, 60, 80, 20);

        jtf_superficieCampo.setEnabled(false);
        jtf_superficieCampo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtf_superficieCampoKeyTyped(evt);
            }
        });
        add(jtf_superficieCampo);
        jtf_superficieCampo.setBounds(120, 60, 140, 20);

        jlbl_ha.setText("ha.");
        add(jlbl_ha);
        jlbl_ha.setBounds(280, 60, 50, 20);

        jbtn_cancelarCampo.setText("Cancelar");
        jbtn_cancelarCampo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_cancelarCampoActionPerformed(evt);
            }
        });
        add(jbtn_cancelarCampo);
        jbtn_cancelarCampo.setBounds(460, 500, 90, 23);

        jbtn_RegistrarCampo.setText("Registrar Campo");
        jbtn_RegistrarCampo.setEnabled(false);
        jbtn_RegistrarCampo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_RegistrarCampoActionPerformed(evt);
            }
        });
        add(jbtn_RegistrarCampo);
        jbtn_RegistrarCampo.setBounds(570, 500, 180, 23);
        add(jSeparator2);
        jSeparator2.setBounds(20, 540, 730, 2);
        add(jSeparator4);
        jSeparator4.setBounds(20, 482, 730, 10);
        add(jSeparator5);
        jSeparator5.setBounds(30, 102, 720, 10);

        jTable_listaDeLotes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N°", "Superficie", "Tipo de Suelo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_listaDeLotes.setEnabled(false);
        jTable_listaDeLotes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_listaDeLotesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_listaDeLotes);
        if (jTable_listaDeLotes.getColumnModel().getColumnCount() > 0) {
            jTable_listaDeLotes.getColumnModel().getColumn(0).setResizable(false);
            jTable_listaDeLotes.getColumnModel().getColumn(1).setResizable(false);
            jTable_listaDeLotes.getColumnModel().getColumn(2).setResizable(false);
        }

        add(jScrollPane1);
        jScrollPane1.setBounds(362, 130, 390, 290);

        jbtn_quitar.setText("Quitar");
        jbtn_quitar.setEnabled(false);
        jbtn_quitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_quitarActionPerformed(evt);
            }
        });
        add(jbtn_quitar);
        jbtn_quitar.setBounds(670, 440, 80, 23);

        jbtn_editar.setText("Editar");
        jbtn_editar.setEnabled(false);
        add(jbtn_editar);
        jbtn_editar.setBounds(573, 440, 80, 23);

        jlbl_lotes.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jlbl_lotes.setText("Lotes");
        add(jlbl_lotes);
        jlbl_lotes.setBounds(30, 120, 100, 44);

        jlbl_mensajeLote1.setText("Tenga en cuenta que debe ingresar al menos 1 Lote");
        add(jlbl_mensajeLote1);
        jlbl_mensajeLote1.setBounds(30, 170, 300, 40);

        jlbl_numeroDeLote.setText("Nro:");
        add(jlbl_numeroDeLote);
        jlbl_numeroDeLote.setBounds(30, 230, 70, 20);

        jtf_numeroDeLote.setEnabled(false);
        jtf_numeroDeLote.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtf_numeroDeLoteKeyTyped(evt);
            }
        });
        add(jtf_numeroDeLote);
        jtf_numeroDeLote.setBounds(110, 230, 80, 20);

        jlbl_superficieLote.setText("Superficie:");
        add(jlbl_superficieLote);
        jlbl_superficieLote.setBounds(30, 270, 70, 20);

        jtf_superficieLote.setEnabled(false);
        jtf_superficieLote.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtf_superficieLoteKeyTyped(evt);
            }
        });
        add(jtf_superficieLote);
        jtf_superficieLote.setBounds(110, 270, 80, 20);

        jlbl_tipoDeSueloLote.setText("Tipo de Suelo");
        add(jlbl_tipoDeSueloLote);
        jlbl_tipoDeSueloLote.setBounds(30, 310, 90, 20);

        jcb_tipoSueloLote.setEnabled(false);
        add(jcb_tipoSueloLote);
        jcb_tipoSueloLote.setBounds(110, 310, 80, 20);
        add(jlbl_mensajeLote2);
        jlbl_mensajeLote2.setBounds(30, 350, 260, 20);

        jbtn_agregarLote.setText("Agregar Lote");
        jbtn_agregarLote.setEnabled(false);
        jbtn_agregarLote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_agregarLoteActionPerformed(evt);
            }
        });
        add(jbtn_agregarLote);
        jbtn_agregarLote.setBounds(100, 390, 130, 23);
    }// </editor-fold>//GEN-END:initComponents

    //Paso 1: verificar Nombre del campo
    //1a- crea nuevoCampo
    //1b- nuevoCampo.nombre tiene el valor ingresado por el usuario
    //1c- nuevoCampo.empresa tiene el valor de la empresa en la cual se esta trabajando
    private void jtf_nombreCampoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_nombreCampoKeyTyped
        boolean nombreDeCampoValido = false;
        char teclaPresionada = evt.getKeyChar();
        if (teclaPresionada == KeyEvent.VK_ENTER) {
            
            //JTF no debe estar vacio
             if (jtf_nombreCampo.getText().isEmpty())
            {
                 this.jlbl_mensajeNombreCampo.setText("Ingrese un valor valido"); 
            }
            else
            {
                nombreDeCampoValido = controlador.verificarNombreDeCampo(jtf_nombreCampo.getText());                
                if(nombreDeCampoValido == true){
                    this.jtf_superficieCampo.requestFocus();
                    this.jtf_nombreCampo.setEnabled(false);
                    this.jtf_superficieCampo.setEnabled(true);  
                    this.jlbl_mensajeNombreCampo.setBackground(Color.GREEN);
                    this.jlbl_mensajeNombreCampo.setText("Nombre correcto");
                    this.nuevoCampo = new Campo();                    
                    this.nuevoCampo.setNombreCampo(jtf_nombreCampo.getText());
                }else{
                    this.jtf_nombreCampo.setText("");
                    this.jlbl_mensajeNombreCampo.setBackground(Color.RED);
                    this.jlbl_mensajeNombreCampo.setText("Este nombre ya esta en uso.");
                }
            }
        }
    }//GEN-LAST:event_jtf_nombreCampoKeyTyped

    private void jbtn_cancelarCampoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_cancelarCampoActionPerformed
        moduloPrincipal = new ModuloPrincipal();
        contenedorSingleton.cargarModulo(moduloPrincipal);
    }//GEN-LAST:event_jbtn_cancelarCampoActionPerformed

    //Paso 2: ingresar superficie al campo
    //2a- nuevoCampo.superficie toma el valor ingresado por el usuario
    private void jtf_superficieCampoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_superficieCampoKeyTyped
        float superficieAux  = 0;
        char teclaPresionada = evt.getKeyChar();
        if (teclaPresionada == KeyEvent.VK_ENTER) {
            if (jtf_superficieCampo.getText().isEmpty())
            {
                 this.jlbl_mensajeNombreCampo.setText("Ingrese superficie para el campo"); 
            }
            else
            {
                superficieAux  = Float.parseFloat(jtf_superficieCampo.getText());
                if(superficieAux>0 ){
                    this.nuevoCampo.setSuperficieCampo(superficieAux);

                    this.jtf_superficieCampo.setEnabled(false);
                    this.jtf_numeroDeLote.setEnabled(true);                
                    this.jtf_numeroDeLote.requestFocus();
                    this.jlbl_mensajeNombreCampo.setText(""); 
                }
            }
        }
    }//GEN-LAST:event_jtf_superficieCampoKeyTyped
    
    //Paso 4: Ingresar superficie de lote
    //4a- nuevoLote.superficieLote ingresada por el usuario debe de cumplir las siguientes caracteristicas:
    //4a-caracteristica- Ser mayor a 0(Cero)
    //4a-caracteristica- Ser mayor o igual a la superficie disponible del campo
    private void jtf_superficieLoteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_superficieLoteKeyTyped
        char teclaPresionada = evt.getKeyChar();
        float superficieAux = 0;
        if (teclaPresionada == KeyEvent.VK_ENTER) {
            if (jtf_superficieLote.getText().isEmpty())
            {
                 this.jlbl_mensajeLote2.setText("Ingrese superficie para el Lote"); 
            }
            else
            {
                superficieAux  = Float.parseFloat(jtf_superficieLote.getText());
                if(superficieAux>0 ){                
                    if (controlador.verificarSuperficieLote(this.nuevoCampo)>=superficieAux) {

                        nuevoLote.setSuperficieLote(superficieAux);

                        this.jtf_superficieLote.setEnabled(false);
                        this.jcb_tipoSueloLote.setEnabled(true);
                        this.jcb_tipoSueloLote.requestFocus();
                        this.jbtn_agregarLote.setEnabled(true);
                        this.jlbl_mensajeLote2.setText("Superficie de lote OK ");
                    }else{

                        this.jlbl_mensajeLote2.setText("Ingrese un numero igual o inferior a "+controlador.verificarSuperficieLote(this.nuevoCampo));
                    }                
                }            
            }
        }        
    }//GEN-LAST:event_jtf_superficieLoteKeyTyped

    //Paso 3: Ingresar numero de lote
    //3a- crea nuevoLote
    //3b- nuevoLote.unCampo es igual a nuevoCampo creado en el paso 1
    //3c- nuevoLote.numeroLote es igual al valor ingresado por el usuario
    private void jtf_numeroDeLoteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_numeroDeLoteKeyTyped
        
        char teclaPresionada = evt.getKeyChar();
        int numeroDeLote  =0;
        if (teclaPresionada == KeyEvent.VK_ENTER) {
            if (jtf_numeroDeLote.getText().isEmpty())
            {
                 this.jlbl_mensajeLote2.setText("Ingrese numero para el lote"); 
            }
            else
            {
                numeroDeLote  = Integer.parseInt(jtf_numeroDeLote.getText());
                if(numeroDeLote>0 ){
                    
                    if (!controlador.verificarNumeroLote(this.nuevoCampo, numeroDeLote)) {
                        
                        this.nuevoLote = new Lote();
                        this.nuevoLote.setCampo(this.nuevoCampo);
                        this.nuevoLote.setNumeroLote(numeroDeLote);                    
                        this.jtf_numeroDeLote.setEnabled(false);

                        this.jtf_numeroDeLote.setEnabled(false);
                        this.jtf_superficieLote.setEnabled(true);                
                        this.jtf_superficieLote.requestFocus();

                        this.jlbl_mensajeLote2.setText("Numero de lote OK ");

                    }else{

                        this.jlbl_mensajeLote2.setText("El numero: "+jtf_numeroDeLote.getText()+" ya esta en uso");
                    }    
                    
                }else{
                    this.jlbl_mensajeLote2.setText("El numero de lote debe ser mayor a "+jtf_numeroDeLote.getText());
                }
            }
        }

    }//GEN-LAST:event_jtf_numeroDeLoteKeyTyped

    
    //Paso 5: Agregar lote al campo
    private void jbtn_agregarLoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_agregarLoteActionPerformed
        
        this.jbtn_agregarLote.setEnabled(false);
        this.jcb_tipoSueloLote.setEnabled(false);
        
        TipoSuelo tipoSueloAux = null;
        
        tipoSueloAux =((TipoSuelo)jcb_tipoSueloLote.getSelectedItem());
        
        controlador.agregarTipoSueloAlLote(tipoSueloAux, nuevoLote);
        
        
        //agrega el nuevo lote al campo
        nuevoCampo.getListaDeLotes().add(nuevoLote);
        
        
        //prepara el objeto a ser insertado en la tabla con los valores del lote
        Object []object = new Object[3];
        object[0] = nuevoLote.getNumeroLote();
        object[1] = nuevoLote.getSuperficieLote(); 
        object[2] = nuevoLote.getTipoSuelo().getNumero(); 
         

        //Agrega datos del lote a la tabla
        modeloTablaLotes.addRow(object);
        
        if (nuevoCampo.getListaDeLotes().isEmpty()) {
            this.jbtn_RegistrarCampo.setEnabled(false);
        }else{
            this.jbtn_RegistrarCampo.setEnabled(true);
            if (controlador.verificarSuperficieLote(this.nuevoCampo)>0) {
                this.jtf_numeroDeLote.setText("");
                this.jtf_superficieLote.setText("");
                this.jbtn_agregarLote.setEnabled(false);
                this.jtf_numeroDeLote.setEnabled(true);
                this.jtf_numeroDeLote.requestFocus();
                this.jcb_tipoSueloLote.setSelectedIndex(0);
            }else{
                this.jbtn_RegistrarCampo.setEnabled(true);
            }
            
        }
        
        
       
        
        
        
    }//GEN-LAST:event_jbtn_agregarLoteActionPerformed

    private void jbtn_RegistrarCampoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_RegistrarCampoActionPerformed
        //Seteamos el JOptionPane con los siguientes parametros:
        //1-Mensaje
        //2-Titulo del JOptionPane
        //3-Tipo de JOptionPane YES_NO_OPTION 
        int confirmacion = JOptionPane.showConfirmDialog(null, "¿Confirma el registro del campo?", "Registrar Campo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        
        if (this.nuevoCampo!=null) {
            if (this.nuevoCampo.getListaDeLotes().isEmpty()) {
                //Campo sin Lote
                System.out.println("lotes vacios");
            }else{
                //Campo con Lote Completo
                
                //Acepta el Registro del Campo
                if(confirmacion==0){
                    //crea nuevo panel
                    registroConfirmado = new PanelRegistroConfirmacion();
                    registroConfirmado.setSize(800, 600);
                    registroConfirmado.cargar(this.nuevoCampo);
                    contenedorSingleton.cargarModulo(registroConfirmado);        
                            
                    controlador.finalizarRegistroNuevoCampo(this.nuevoCampo);
                    
                }
                
                //Cancela el Registro del Campo
                if(confirmacion==0){
                    
                }
                
                //Cancela el dialogo, acccion igual a boton cancela
                if(confirmacion==-1){
                    
                }
            }
        }else{
            //Campo No completado
            System.out.println("campo vacio");
        }
        
        
    }//GEN-LAST:event_jbtn_RegistrarCampoActionPerformed

    
    /**
     * jTable_listaDeLotesMouseClicked
     * Controla los clicks realizados en la tabla de lotes
     * @param evt 
     */
    private void jTable_listaDeLotesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_listaDeLotesMouseClicked
        
        this.filaSeleccionada = 0;
        this.seleccion = jTable_listaDeLotes.rowAtPoint(evt.getPoint());
        String aux = String.valueOf(jTable_listaDeLotes.getValueAt(seleccion, 0));
       
        this.filaSeleccionada = Integer.parseInt(aux); 
        
        //filaSeleccionada es el numero de lote
        
        if(filaSeleccionada>=0){
           
            this.jbtn_editar.setEnabled(true);
            this.jbtn_editar.setBackground(Color.green);
            this.jbtn_quitar.setEnabled(true);
            this.jbtn_quitar.setBackground(Color.red);

            //inhabilita el numero de lote
            this.jtf_numeroDeLote.setEnabled(false);

            //setear Lotes

            this.jtf_numeroDeLote.setText(String.valueOf(this.nuevoCampo.getListaDeLotes().get(seleccion).getNumeroLote()));
            this.jtf_superficieLote.setText(String.valueOf(this.nuevoCampo.getListaDeLotes().get(seleccion).getSuperficieLote()));

            this.jcb_tipoSueloLote.setSelectedItem(this.nuevoCampo.getListaDeLotes().get(seleccion).getTipoSuelo());
            //this.jcb_tipoSueloLote.setSelectedIndex((this.nuevoCampo.getListaDeLotes().get(filaSeleccionada-1).getTipoSuelo().getNumero())-1);


            this.jbtn_cancelarCampo.setEnabled(false);
            this.jbtn_RegistrarCampo.setEnabled(false);
            
            
            
        }
        
    }//GEN-LAST:event_jTable_listaDeLotesMouseClicked

    
    /**
     * formMouseClicked
     * Controla el click realizado sobre el formulario principal
     * Click en formulario, sin registro filaSeleccionada = 0
     * Click en formulario con registro filaSeleccionada = a registro seleccionado
     * Click fuera de formulario filaSeleccionada = 0
     * @param evt 
     */
    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        this.filaSeleccionada = 0;
        if(filaSeleccionada==0){
            this.jbtn_editar.setEnabled(false);
            this.jbtn_editar.setBackground(null);
            this.jbtn_quitar.setEnabled(false);
            this.jbtn_quitar.setBackground(null);
            
            
            this.jtf_numeroDeLote.setEnabled(false);
            this.jtf_superficieLote.setEnabled(false);
            this.jcb_tipoSueloLote.setEnabled(false);
             
            //habilita el numero de lote            
            if (nuevoCampo!=null&&!nuevoCampo.getListaDeLotes().isEmpty()) {
                
                if (controlador.verificarSuperficieLote(this.nuevoCampo)>0) {
                    this.jtf_numeroDeLote.setText("");
                    this.jtf_superficieLote.setText("");
                    this.jbtn_agregarLote.setEnabled(false);
                    this.jtf_numeroDeLote.setEnabled(true);
                    this.jtf_numeroDeLote.requestFocus();
                    this.jcb_tipoSueloLote.setSelectedIndex(0);
                }else{                    
                }
                this.jbtn_RegistrarCampo.setEnabled(true);
                this.jbtn_cancelarCampo.setEnabled(true);
            }else{
                this.jtf_numeroDeLote.setText("");
                this.jtf_superficieLote.setText("");
                this.jbtn_agregarLote.setEnabled(false);
                this.jtf_numeroDeLote.setEnabled(true);
                this.jtf_numeroDeLote.requestFocus();
                this.jcb_tipoSueloLote.setSelectedIndex(0);
                
            }
        }
    }//GEN-LAST:event_formMouseClicked

    private void jbtn_quitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_quitarActionPerformed
        if (seleccion>=0) {
            //System.out.println("numeroLote: "+this.nuevoCampo.getListaDeLotes().get(filaSeleccionada).getNumeroLote());
            if (nuevoCampo!=null&&!nuevoCampo.getListaDeLotes().isEmpty()) {                
                if (controlador.verificarSuperficieLote(this.nuevoCampo)>0) {
                    /*
                    this.jtf_numeroDeLote.setText("");
                    this.jtf_superficieLote.setText("");
                    this.jbtn_agregarLote.setEnabled(false);
                    this.jtf_numeroDeLote.setEnabled(true);
                    this.jtf_numeroDeLote.requestFocus();
                    this.jcb_tipoSueloLote.setSelectedIndex(0);
                    */
                    //nuevoCampo.getListaDeLotes().remove(seleccion);
                    modeloTablaLotes.removeRow(seleccion);
                    repaint();
                    
                }else{   
                    
                }
                
                nuevoCampo.getListaDeLotes().remove(seleccion);
                modeloTablaLotes.removeRow(seleccion);
                repaint();
                
                this.jbtn_editar.setEnabled(false);
                this.jbtn_editar.setBackground(null);
                this.jbtn_quitar.setEnabled(false);
                this.jbtn_quitar.setBackground(null);
                
                this.jbtn_RegistrarCampo.setEnabled(true);
                this.jbtn_cancelarCampo.setEnabled(true);
            }else{
                
                /*
                this.jtf_numeroDeLote.setText("");
                this.jtf_superficieLote.setText("");
                this.jbtn_agregarLote.setEnabled(false);
                this.jtf_numeroDeLote.setEnabled(true);
                this.jtf_numeroDeLote.requestFocus();
                this.jcb_tipoSueloLote.setSelectedIndex(0);
                */
            }
        }
    }//GEN-LAST:event_jbtn_quitarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTable jTable_listaDeLotes;
    private javax.swing.JButton jbtn_RegistrarCampo;
    private javax.swing.JButton jbtn_agregarLote;
    private javax.swing.JButton jbtn_cancelarCampo;
    private javax.swing.JButton jbtn_editar;
    private javax.swing.JButton jbtn_quitar;
    private javax.swing.JComboBox<String> jcb_tipoSueloLote;
    private javax.swing.JLabel jlbl_ha;
    private javax.swing.JLabel jlbl_lotes;
    private javax.swing.JLabel jlbl_mensajeLote1;
    private javax.swing.JLabel jlbl_mensajeLote2;
    private javax.swing.JLabel jlbl_mensajeNombreCampo;
    private javax.swing.JLabel jlbl_nombreCampo;
    private javax.swing.JLabel jlbl_numeroDeLote;
    private javax.swing.JLabel jlbl_superficieCampo;
    private javax.swing.JLabel jlbl_superficieLote;
    private javax.swing.JLabel jlbl_tipoDeSueloLote;
    private javax.swing.JTextField jtf_nombreCampo;
    private javax.swing.JTextField jtf_nombreUsuario;
    private javax.swing.JTextField jtf_numeroDeLote;
    private javax.swing.JTextField jtf_superficieCampo;
    private javax.swing.JTextField jtf_superficieLote;
    // End of variables declaration//GEN-END:variables

    
}
