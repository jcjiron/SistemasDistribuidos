/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio4.view;

import servidor.Servidor;
import ejercicio4.controler.CategoriaDAO;
import ejercicio4.model.Categoria;
import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import servidor.Peticiones;

public class Cliente extends javax.swing.JFrame {

    public static final String RESPUESTA_RECIBIDA = "Respuesta recibida";
    public static final String PETICION_ENVIADA = "Peticion enviada";
    public static final String PROCESANDO_RESPUESTA = "Procesando respuesta";

    private String nameCategoria;
    private int idCategoria;
    private CategoriaDAO manager;
    private DefaultListModel modelo;

    private Socket socketCliente = null;

    private ObjectInputStream entradaDatos = null;
    private ObjectOutputStream salidaDatos = null;

    /**
     * Creates new form Frame
     */
    public Cliente() {
        initComponents();

        //=================================================================
        //=================================================================
        //conectando con servidor
        try {
            System.out.println("antes del socket");
            socketCliente = new Socket(Servidor.IP, Servidor.PUERTO);
            System.out.println("despues del socket");
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        //=================================================================
        //=================================================================
        try {

            salidaDatos = new ObjectOutputStream(socketCliente.getOutputStream());
            salidaDatos.writeInt(Servidor.PETICION_LISTAR);
            salidaDatos.flush();
            //salidaDatos.close();

            System.out.println(PETICION_ENVIADA);
            entradaDatos = new ObjectInputStream(socketCliente.getInputStream());
            List<Categoria> list = (List<Categoria>) entradaDatos.readObject();
            //entradaDatos.close();
            System.out.println(RESPUESTA_RECIBIDA);
            restartList(list);
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        cerrarConexion();

        
        panel.repaint();

    }

    public void restartList(List<Categoria> l) {
        System.out.println(PROCESANDO_RESPUESTA);
        modelo = new DefaultListModel();
        modelo.removeAllElements();
        for (Categoria ca : l) {
            modelo.addElement(ca.getIdCategoria() + "   " + ca.getNombreCategoria());
        }

        lista.removeAll();
        lista.setModel(modelo);
    }

    public void cerrarConexion() {
        try {
            salidaDatos.close();
            entradaDatos.close();
            socketCliente.close();

        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        lblCategoria = new javax.swing.JLabel();
        btnAlta = new javax.swing.JButton();
        btnBaja = new javax.swing.JButton();
        btnCambio = new javax.swing.JButton();
        txtCategoria = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        lista = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblCategoria.setText("Categoria");

        btnAlta.setText("Alta");
        btnAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAltaActionPerformed(evt);
            }
        });

        btnBaja.setText("Baja");
        btnBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBajaActionPerformed(evt);
            }
        });

        btnCambio.setText("Cambio");
        btnCambio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambioActionPerformed(evt);
            }
        });

        lista.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(lista);

        jLabel1.setText("id");

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCategoria)
                            .addComponent(jLabel1))
                        .addGap(27, 27, 27)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtId, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                            .addComponent(txtCategoria))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnBaja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCambio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAlta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(32, 32, 32))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(btnAlta)
                        .addGap(17, 17, 17)
                        .addComponent(btnBaja)
                        .addGap(26, 26, 26)
                        .addComponent(btnCambio))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCategoria)
                            .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAltaActionPerformed
        nameCategoria = txtCategoria.getText();
        idCategoria = Integer.parseInt(txtId.getText());

        try {
            socketCliente = new Socket(Servidor.IP, Servidor.PUERTO);
            salidaDatos=new ObjectOutputStream(socketCliente.getOutputStream());
            salidaDatos.writeInt(Peticiones.PETICION_ALTA);
            salidaDatos.writeObject(new Categoria(idCategoria, nameCategoria));
            
            entradaDatos=new ObjectInputStream(socketCliente.getInputStream());
            List<Categoria> list = (List<Categoria>) entradaDatos.readObject();
            
            cerrarConexion();
            
            restartList(list);
            panel.repaint();
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnAltaActionPerformed

    private void btnBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBajaActionPerformed
        nameCategoria = txtCategoria.getText();
        idCategoria = Integer.parseInt(txtId.getText());

        try {
            socketCliente = new Socket(Servidor.IP, Servidor.PUERTO);
            salidaDatos=new ObjectOutputStream(socketCliente.getOutputStream());
            salidaDatos.writeInt(Peticiones.PETICION_BAJA);
            salidaDatos.writeObject(new Categoria(idCategoria, nameCategoria));
            
            entradaDatos=new ObjectInputStream(socketCliente.getInputStream());
            List<Categoria> list = (List<Categoria>) entradaDatos.readObject();
            restartList(list);
            panel.repaint();
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        cerrarConexion();
    }//GEN-LAST:event_btnBajaActionPerformed

    private void btnCambioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambioActionPerformed
        nameCategoria = txtCategoria.getText();
        idCategoria = Integer.parseInt(txtId.getText());

        try {
            socketCliente = new Socket(Servidor.IP, Servidor.PUERTO);
            salidaDatos=new ObjectOutputStream(socketCliente.getOutputStream());
            salidaDatos.writeInt(Peticiones.PETICION_CAMBIO);
            salidaDatos.writeObject(new Categoria(idCategoria, nameCategoria));
            
            entradaDatos=new ObjectInputStream(socketCliente.getInputStream());
            List<Categoria> list = (List<Categoria>) entradaDatos.readObject();
            restartList(list);
            panel.repaint();
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        cerrarConexion();

    }//GEN-LAST:event_btnCambioActionPerformed

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
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Cliente frame = new Cliente();
                frame.setVisible(true);

                frame.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent evt) {
                        frame.cerrarConexion();
                        System.exit(0);
                    }
                });
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlta;
    private javax.swing.JButton btnBaja;
    private javax.swing.JButton btnCambio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JList<String> lista;
    private javax.swing.JPanel panel;
    private javax.swing.JTextField txtCategoria;
    private javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables
}
