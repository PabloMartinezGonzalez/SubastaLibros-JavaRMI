/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica7;

import jade.core.AID;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author pablo
 */
public class VVendedor extends javax.swing.JFrame {

    private AgenteVendedor vendedor;
    private ArrayList<Subasta> subastasActivas;

    public ArrayList<Subasta> getSubastasActivas() {
        return subastasActivas;
    }

    public VVendedor() {
        initComponents();
        this.subastasActivas = new ArrayList<>();
    }

    /**
     * Creates new form vendedor
     *
     * @param nombreVendedor
     * @param vendedor
     */
    public VVendedor(String nombreVendedor, AgenteVendedor vendedor) {
        initComponents();
        vendedortxt.setText(nombreVendedor.toUpperCase());
        this.vendedor = vendedor;
        this.subastasActivas = new ArrayList<>();
        //actualizarTabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label1 = new java.awt.Label();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nombreLibro = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        precioLibro = new javax.swing.JTextField();
        anadirASubasta = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaSubastas = new javax.swing.JTable();
        jIncremento = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jSaludo = new javax.swing.JLabel();
        vendedortxt = new javax.swing.JLabel();

        label1.setText("label1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 219, 219));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("SUBASTAS ACTIVAS:");

        jLabel4.setText("NOMBRE:");

        nombreLibro.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nombreLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreLibroActionPerformed(evt);
            }
        });

        jLabel5.setText("PRECIO:");

        precioLibro.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        precioLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                precioLibroActionPerformed(evt);
            }
        });

        anadirASubasta.setBackground(new java.awt.Color(247, 243, 255));
        anadirASubasta.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        anadirASubasta.setText("AÑADIR SUBASTA");
        anadirASubasta.setToolTipText("");
        anadirASubasta.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        anadirASubasta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anadirASubastaActionPerformed(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        tablaSubastas.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tablaSubastas.setModel(new ModeloTablaSubasta());
        jScrollPane1.setViewportView(tablaSubastas);

        jIncremento.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jIncremento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jIncrementoActionPerformed(evt);
            }
        });

        jLabel6.setText("INCREMENTO:");

        jSaludo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jSaludo.setText("Página del vendedor");

        vendedortxt.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        vendedortxt.setText("jLabel1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(nombreLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jIncremento, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(precioLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                                                .addComponent(anadirASubasta, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(33, 33, 33))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(160, 160, 160)
                                .addComponent(jSaludo))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(vendedortxt, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSaludo)
                .addGap(36, 36, 36)
                .addComponent(vendedortxt)
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nombreLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(precioLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(anadirASubasta, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jIncremento, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(47, 47, 47)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                .addGap(51, 51, 51))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nombreLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreLibroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreLibroActionPerformed

    private void precioLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_precioLibroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_precioLibroActionPerformed
    public void actualizarTabla(String subasta, Float precioActual, AID ganadorProvisional) {

        for (Subasta s : subastasActivas) {
            if (s.getNombreLibro().equals(subasta)) {
                s.setPrecioActual(s.getPrecioActual());
                s.setGanadorProvisional(ganadorProvisional);
                s.setPrecioActual(precioActual);
            }
        }

        ModeloTablaSubasta modelo = (ModeloTablaSubasta) tablaSubastas.getModel();
        modelo.setFilas(subastasActivas);
        tablaSubastas.setModel(modelo);
    }


    private void anadirASubastaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anadirASubastaActionPerformed
        if (nombreLibro.getText().isEmpty() || precioLibro.getText().isEmpty() || jIncremento.getText().isEmpty()) {
            VAviso aviso = new VAviso(this, "Error: No se han introducido algunos parámetros");
            aviso.setVisible(true);
        }


        Subasta subasta = new Subasta(nombreLibro.getText(), Float.parseFloat(precioLibro.getText().trim()), false, Float.parseFloat(jIncremento.getText().trim()));

        subastasActivas.add(subasta);
        ModeloTablaSubasta subastas = (ModeloTablaSubasta) tablaSubastas.getModel();
        subastas.anadirFila(subasta);
        tablaSubastas.setModel(subastas);
        vendedor.anadirLibro( nombreLibro.getText(), Float.parseFloat(precioLibro.getText().trim())); 

    }//GEN-LAST:event_anadirASubastaActionPerformed

  
    
    public void vendido(String libro) {
        for (Subasta aux : subastasActivas) {
            if (aux.getNombreLibro().equals(libro)) {
                aux.setVendido(true);
            }
        }
    }

    public Subasta getSubasta(String libro) {
        Subasta resultado = null;
        for (Subasta aux : subastasActivas) {
            if (aux.getNombreLibro().equals(libro)) {
                resultado = aux;
            }
        }
        return resultado;
    }

    public void actualizarSubastas(String nombreLibro) {
        ModeloTablaSubasta subastas = (ModeloTablaSubasta) tablaSubastas.getModel();

        int filas = subastas.getRowCount();
        for (int i = 0; i < filas; i++) {
            if (subastas.getValueAt(i, 0).equals(nombreLibro)) {
                subastas.borrarFila(i);
                break;
            }
        }
        if (subastasActivas.contains(nombreLibro)) {
            subastasActivas.remove(nombreLibro);
        }
        tablaSubastas.setModel(subastas);
    }


    private void jIncrementoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jIncrementoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jIncrementoActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param librosComprador
     * @param subasta
     * @return
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton anadirASubasta;
    private javax.swing.JTextField jIncremento;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JLabel jSaludo;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Label label1;
    private javax.swing.JTextField nombreLibro;
    private javax.swing.JTextField precioLibro;
    private javax.swing.JTable tablaSubastas;
    private javax.swing.JLabel vendedortxt;
    // End of variables declaration//GEN-END:variables
}
