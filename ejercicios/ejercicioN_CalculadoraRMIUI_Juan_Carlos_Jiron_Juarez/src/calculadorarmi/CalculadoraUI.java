/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadorarmi;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juan
 */
public class CalculadoraUI extends javax.swing.JFrame {

    /**
     * Creates new form CalculadoraUI
     */
    
    public static Operaciones testRemote;
    public CalculadoraUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtSuma = new javax.swing.JTextField();
        txtResta = new javax.swing.JTextField();
        txtMulti = new javax.swing.JTextField();
        txtDiv = new javax.swing.JTextField();
        txtMedia = new javax.swing.JTextField();
        txtVar = new javax.swing.JTextField();
        txtDesv = new javax.swing.JTextField();
        txtResSum = new javax.swing.JTextField();
        btnCalc = new javax.swing.JButton();
        txtResResta = new javax.swing.JTextField();
        txtResDiv = new javax.swing.JTextField();
        txtResMult = new javax.swing.JTextField();
        txtResMed = new javax.swing.JTextField();
        txtResVar = new javax.swing.JTextField();
        txtResDesv = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("suma");

        jLabel2.setText("resta");

        jLabel3.setText("multiplicacion");

        jLabel4.setText("division");

        jLabel5.setText("media");

        jLabel6.setText("varianza");

        jLabel7.setText("desviacion");

        txtResta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRestaActionPerformed(evt);
            }
        });

        txtDesv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDesvActionPerformed(evt);
            }
        });

        btnCalc.setText("Calcular");
        btnCalc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(90, 90, 90)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtDesv, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                        .addComponent(txtMedia)
                        .addComponent(txtDiv)
                        .addComponent(txtMulti)
                        .addComponent(txtResta)
                        .addComponent(txtVar))
                    .addComponent(txtSuma, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtResDiv, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtResResta, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtResSum, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtResMed, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtResVar, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtResDesv, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtResMult, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(113, 113, 113))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCalc, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(291, 291, 291))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSuma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtResSum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtResta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtResResta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMulti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtResMult, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtDiv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtResDiv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtMedia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtResMed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtVar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtResVar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtDesv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtResDesv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnCalc)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(44, 44, 44))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDesvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDesvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDesvActionPerformed

    private void txtRestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRestaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRestaActionPerformed

    private void btnCalcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcActionPerformed
        // TODO add your handling code here:
        String REGEX =",";
        //===============================================================================
        //===============================================================================
        int suma[] = parseIntArray(txtSuma.getText().split(REGEX));
        if(suma.length > 0){
            try {
                txtResSum.setText(""+testRemote.suma(suma));
            } catch (RemoteException ex) {
                Logger.getLogger(CalculadoraUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //===============================================================================
        //===============================================================================
        int resta[] = parseIntArray(txtResta.getText().split(REGEX));
        if(resta.length > 0){
            try {
                txtResResta.setText(""+testRemote.resta(resta[0],resta[1]));
            } catch (RemoteException ex) {
                Logger.getLogger(CalculadoraUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //===============================================================================
        //===============================================================================
        int div[] = parseIntArray(txtDiv.getText().split(REGEX));
        if(div.length > 0){
            try {
                txtResDiv.setText(""+testRemote.division(div[0],div[1]));
            } catch (RemoteException ex) {
                Logger.getLogger(CalculadoraUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //===============================================================================
        //===============================================================================
        int multi[] = parseIntArray(txtMulti.getText().split(REGEX));
        if(multi.length > 0){
            try {
                txtResMult.setText(""+testRemote.multiplicacion(multi[0],multi[1]));
            } catch (RemoteException ex) {
                Logger.getLogger(CalculadoraUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //===============================================================================
        //===============================================================================
        int desv[] = parseIntArray(txtDesv.getText().split(REGEX));
        if(desv.length > 0){
            try {
                txtResDesv.setText(""+testRemote.desvStd(desv));
            } catch (RemoteException ex) {
                Logger.getLogger(CalculadoraUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //===============================================================================
        //===============================================================================
        int media[] = parseIntArray(txtMedia.getText().split(REGEX));
        if(media.length > 0){
            try {
                txtResMed.setText(""+testRemote.media(media));
            } catch (RemoteException ex) {
                Logger.getLogger(CalculadoraUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //===============================================================================
        //===============================================================================
        int varian[] = parseIntArray(txtVar.getText().split(REGEX));
        if(varian.length > 0){
            try {
                txtResVar.setText(""+testRemote.varianza(varian));
            } catch (RemoteException ex) {
                Logger.getLogger(CalculadoraUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //===============================================================================
        //===============================================================================
        
    }//GEN-LAST:event_btnCalcActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws RemoteException, NotBoundException {
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
            java.util.logging.Logger.getLogger(CalculadoraUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CalculadoraUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CalculadoraUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CalculadoraUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CalculadoraUI().setVisible(true);
            }
        });
        
     String IP_SERVER="localhost";
     String PUERTO_SERVER = "5050";
     String REGISTRY_NAME = "MY_REGISTRY";
     String PAH_REGISTRY = IP_SERVER+":"+PUERTO_SERVER+"/"+REGISTRY_NAME;
     
     
        Registry registry = LocateRegistry.getRegistry();
        testRemote = (Operaciones) registry.lookup(PAH_REGISTRY);
        //int[] x = {1,2,3,4,5,6,7,8,9}; 
        //System.out.println(testRemote.suma(x));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtDesv;
    private javax.swing.JTextField txtDiv;
    private javax.swing.JTextField txtMedia;
    private javax.swing.JTextField txtMulti;
    private javax.swing.JTextField txtResDesv;
    private javax.swing.JTextField txtResDiv;
    private javax.swing.JTextField txtResMed;
    private javax.swing.JTextField txtResMult;
    private javax.swing.JTextField txtResResta;
    private javax.swing.JTextField txtResSum;
    private javax.swing.JTextField txtResVar;
    private javax.swing.JTextField txtResta;
    private javax.swing.JTextField txtSuma;
    private javax.swing.JTextField txtVar;
    // End of variables declaration//GEN-END:variables

    private int[] parseIntArray(String[] split) {
        int [] x = new int[split.length];
        for(int i = 0; i< split.length; i++){
            x[i] = Integer.parseInt(split[i]);
        }
        return x;
    }
}
