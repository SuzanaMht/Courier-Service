/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.css.form;
import com.css.dao.FeedbackDao;
import com.css.form.FeedbackForm;
import com.css.dao.FeedbackDaoImpl;
import com.css.dao.ProfileDaoImpl;
import com.css.dao.ViewProfile;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.reflect.Array.set;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hp
 */
public class FeedbackTable extends javax.swing.JFrame {

    static void setModel(DefaultTableModel dtm) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Creates new form FeedbackTable
     */
    public FeedbackTable() {
        initComponents();
        loadData();
        showFeedbackTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        FeedbackTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        setText = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        FeedbackTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Parcel NO.", "Address", "Contact", "Products", "Date", "CustomerName", "Message"
            }
        ));
        FeedbackTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FeedbackTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(FeedbackTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 95, 636, 275));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel1.setText("Customer Feedback Table");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(252, 56, -1, -1));

        jButton1.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jButton1.setText("Back");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(557, 11, -1, -1));

        btnDelete.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 382, -1, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel2.setText("Courier Service System");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(252, 15, -1, -1));

        setText.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        setText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setTextActionPerformed(evt);
            }
        });
        getContentPane().add(setText, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 383, 232, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/css/form/java pic/java1Background.jpg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-31, -9, 690, 440));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void loadData(){
        ArrayList datalist;
        FeedbackDao fb=new FeedbackDaoImpl();
        try {
            datalist=fb.getAllFeedback();
            DefaultTableModel dtm=new DefaultTableModel(new String[]{"Parcelno","Address","Contact","Products","Date","CustomerName","Message"},0);
            Object[] tableLines=datalist.toArray();
            for(int i=0;i<tableLines.length;i++){
                String lines=tableLines[i].toString();
                String[] row=lines.split(",");
                dtm.addRow(row);
            }
            FeedbackTable.setModel(dtm);
        } catch (IOException ex) {
            Logger.getLogger(FeedbackForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    private void showFeedbackTable()
    {
        String filePath = "Feedback.txt";
        File file = new File(filePath);
        
        DefaultTableModel model = (DefaultTableModel) FeedbackTable.getModel();
                try{
            BufferedReader br = new BufferedReader(new FileReader(file));            
            Object[] tableLines = br.lines().toArray();
            for (Object tableLine : tableLines) {
                String line = tableLine.toString().trim();
                String[] dataRow = line.split(",");
                model.addRow(dataRow);
            }
        }catch (IOException ex){
            Logger.getLogger(ViewProfile.class.getName()).log(Level.SEVERE, null,ex);
        }
        
    }
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        
  DefaultTableModel model =(DefaultTableModel)FeedbackTable.getModel();
           if(FeedbackTable.getSelectedRow() == -1)
           {
       }else{
               model.removeRow(FeedbackTable.getSelectedRow());
               FeedbackDaoImpl f = new FeedbackDaoImpl();
           }            
// TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
    this.setVisible(false);
    Admin a=new Admin();
    a.setVisible(true);
// TODO add your handling code here:
    }//GEN-LAST:event_jButton1MouseClicked

    private void setTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_setTextActionPerformed

    private void FeedbackTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FeedbackTableMouseClicked
DefaultTableModel dtm = (DefaultTableModel) FeedbackTable.getModel();
        int selectedRowIndex = FeedbackTable.getSelectedRow();
                // TODO add your handling code here:
                                           

        // TODO add your handling code here:
    }//GEN-LAST:event_FeedbackTableMouseClicked

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
            java.util.logging.Logger.getLogger(FeedbackTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FeedbackTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FeedbackTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FeedbackTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FeedbackTable().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable FeedbackTable;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField setText;
    // End of variables declaration//GEN-END:variables
}
