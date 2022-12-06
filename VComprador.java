/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica7;

import java.util.HashMap;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pablo
 */
public class VComprador extends javax.swing.JFrame {

    private HashMap<String, Float> misLibros;
    private HashMap<String, Float> misSubastasActivas;
    private VVendedor vendedor;
    private Float precio;
    private String libro;
    private AgenteComprador myAgent;
    private DefaultListModel<String> info;

    public HashMap<String, Float> getMisLibros() {
        return misLibros;
    }

    public Float getPrecio() {
        return precio;
    }

    public String getLibro() {
        return libro;
    }

    /**
     * Creates new form vendedor
     *
     * @param nombreComprador
     * @param myAgent
     */
    public VComprador(String nombreComprador, AgenteComprador myAgent) {
        initComponents();
        jSaludo.setText(nombreComprador.toUpperCase());
        this.misLibros = new HashMap<>();
        this.misSubastasActivas = new HashMap<>();
        quitarLibro.setEnabled(false);
        this.vendedor = new VVendedor();
        this.myAgent = myAgent;
        this.info = new DefaultListModel<>();
        jListaLibros.setModel(info);
    }

    public void desactivarBoton() {
        quitarLibro.setEnabled(false);
    }

    public void activarBoton() {
        quitarLibro.setEnabled(true);
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
        anadirLibro = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        scroll = new javax.swing.JScrollPane();
        jTablaSubastas = new javax.swing.JTable();
        nombreLibro = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        precioLibro = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jListaLibros = new javax.swing.JList<>();
        quitarLibro = new javax.swing.JButton();
        jSaludo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        notificaciones = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        label1.setText("label1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(238, 238, 255));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Lista de deseos");

        anadirLibro.setBackground(new java.awt.Color(244, 244, 255));
        anadirLibro.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        anadirLibro.setText("AÑADIR");
        anadirLibro.setToolTipText("");
        anadirLibro.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        anadirLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anadirLibroActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Subastas activas");

        jTablaSubastas.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTablaSubastas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Libro", "Precio Actual"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scroll.setViewportView(jTablaSubastas);

        nombreLibro.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nombreLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreLibroActionPerformed(evt);
            }
        });

        jLabel4.setText("LIBRO:");

        jLabel5.setText("PRECIO:");

        precioLibro.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        precioLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                precioLibroActionPerformed(evt);
            }
        });

        jListaLibros.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jListaLibros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListaLibrosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jListaLibros);

        quitarLibro.setBackground(new java.awt.Color(244, 244, 255));
        quitarLibro.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        quitarLibro.setText("QUITAR");
        quitarLibro.setToolTipText("");
        quitarLibro.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        quitarLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitarLibroActionPerformed(evt);
            }
        });

        jSaludo.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jSaludo.setText("Comprador");

        notificaciones.setColumns(20);
        notificaciones.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        notificaciones.setRows(5);
        jScrollPane1.setViewportView(notificaciones);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Notifiaciones:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Página del Comprador");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(161, 161, 161)
                                .addComponent(quitarLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nombreLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(precioLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jSaludo, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(anadirLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(37, 37, 37))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(191, 191, 191)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jSaludo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nombreLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(precioLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(quitarLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(anadirLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void anadirLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anadirLibroActionPerformed
        // TODO add your handling code here:
        if (nombreLibro.getText().isEmpty() || precioLibro.getText().isEmpty()) {
            VAviso aviso = new VAviso(this, "Introduce los parámetros");
            aviso.setVisible(true);
        } else {
            anadirLibro.setEnabled(true);
            this.misLibros.put(nombreLibro.getText().trim(), Float.parseFloat(precioLibro.getText().trim()));
            info = (DefaultListModel) jListaLibros.getModel();
            info.clear();
            for (String nombre : misLibros.keySet()) {
                info.addElement(nombre + " --- " + misLibros.get(nombre));
            }
            jListaLibros.setModel(info);

            this.libro = nombreLibro.getText();
            this.precio = Float.parseFloat(precioLibro.getText().trim());
            myAgent.anadirListaDeseos(libro, precio);
        }


    }//GEN-LAST:event_anadirLibroActionPerformed

    public void anadirSubasta(String nombre, Float precio) {
        DefaultTableModel modelo = (DefaultTableModel) jTablaSubastas.getModel();
        misSubastasActivas.put(nombre, precio);
        int filas = modelo.getRowCount();
        for (int i = 0; i < filas; i++) {
            if (modelo.getValueAt(i, 0).equals(nombre)) {
                modelo.removeRow(i);
                break;
            }
        }

        modelo.addRow(new Object[]{nombre, precio});
        jTablaSubastas.setModel(modelo);
    }

    public Float precioSubasta(String libro) {
        return misLibros.get(libro);
    }

    public void eliminarSubasta(String nombre) {
        DefaultTableModel modelo = (DefaultTableModel) jTablaSubastas.getModel();

        int filas = modelo.getRowCount();
        for (int i = 0; i < filas; i++) {
            if (modelo.getValueAt(i, 0).equals(nombre)) {
                modelo.removeRow(i);
                break;
            }
        }
        if (misSubastasActivas.containsKey(nombre)) {
            misSubastasActivas.remove(nombre);
        }
        jTablaSubastas.setModel(modelo);
    }

    public void eliminarLibro(String nombre) {
        eliminarSubasta(nombre);
        misLibros.remove(nombre);
        info = (DefaultListModel) jListaLibros.getModel();
        int numElementosLista = info.getSize();

        for (int i = 0; i < numElementosLista; i++) {
            String[] mensajeCompleto = info.get(i).split(" --- ");
            String nombreLibro1 = mensajeCompleto[0];
            if (nombreLibro1.equals(nombre)) {
                info.remove(i);
                break;
            }
        }

        jListaLibros.setModel(info);
    }

    public void crearNotificacion(String mensaje) {
        notificaciones.append("  "+mensaje+"\n");
    }
    private void nombreLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreLibroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreLibroActionPerformed

    private void precioLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_precioLibroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_precioLibroActionPerformed

    private void quitarLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitarLibroActionPerformed
        // TODO add your handling code here:

        info = (DefaultListModel) jListaLibros.getModel();
        String[] contenido = info.getElementAt(jListaLibros.getSelectedIndex()).split(" --- ");
        String libroBorrar = contenido[0];
        myAgent.eliminarListaDeseos(libroBorrar);
        jListaLibros.setModel(info);
        quitarLibro.setEnabled(false);
        eliminarLibro(libroBorrar);
        misLibros.remove(libroBorrar);


    }//GEN-LAST:event_quitarLibroActionPerformed

    private void jListaLibrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListaLibrosMouseClicked
        // TODO add your handling code here:
        quitarLibro.setEnabled(true);
    }//GEN-LAST:event_jListaLibrosMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        myAgent.doDelete();
        this.dispose();

    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton anadirLibro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JList<String> jListaLibros;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JLabel jSaludo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTablaSubastas;
    private java.awt.Label label1;
    private javax.swing.JTextField nombreLibro;
    private javax.swing.JTextArea notificaciones;
    private javax.swing.JTextField precioLibro;
    private javax.swing.JButton quitarLibro;
    private javax.swing.JScrollPane scroll;
    // End of variables declaration//GEN-END:variables
}