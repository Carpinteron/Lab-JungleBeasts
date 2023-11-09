/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package lab_final_estructuras1;

import java.awt.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import lab_final_estructuras1.ListaEnlazada;

/**
 *
 * @author Paula Nuñez
 */
public class framepreguntas extends javax.swing.JFrame {
    
    private String Categoria;
    /**
     * Creates new form framepreguntas
     */
   // private int user;
    public framepreguntas(String Categoria) {
         //public framepreguntas(int Avatar) {
        initComponents();
        Ingles.mostrarLista();
        Ingles.copiarRegistroALista("Partida", Ingles, "Ingles", sc);
        Matematicas.copiarRegistroALista("Partida", Matematicas, "Matematicas", sc);
        General.copiarRegistroALista("Partida", General, "General", sc);
        Abstracto.copiarRegistroALista("Partida", Abstracto, "Abstracto", sc);
        Ciencias.copiarRegistroALista("Partida", Ciencias, "Ciencias", sc);
        this.Categoria = Categoria;
        
        
        

        
        
     //   this.user = Avatar;
    }

   
    ListaEnlazada Ingles = new ListaEnlazada(); // 0 
    Scanner sc = new Scanner(System.in);
    ListaEnlazada Matematicas = new ListaEnlazada(); // 1
    ListaEnlazada General = new ListaEnlazada(); // 2
    ListaEnlazada Abstracto = new ListaEnlazada(); // 3
    ListaEnlazada Ciencias = new ListaEnlazada(); // 4
   

    private framepreguntas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
        pre = new javax.swing.JLabel();
        r2 = new javax.swing.JButton();
        r4 = new javax.swing.JButton();
        r1 = new javax.swing.JButton();
        r3 = new javax.swing.JButton();
        LabelIMG = new javax.swing.JLabel();
        BtnEXIT = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        LabelPregunta1 = new javax.swing.JLabel();
        BTNc1 = new javax.swing.JButton();
        BTNd1 = new javax.swing.JButton();
        BTNa1 = new javax.swing.JButton();
        BTNb1 = new javax.swing.JButton();
        LabelIMG1 = new javax.swing.JLabel();
        BtnEXIT1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        pre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pre.setText("jLabel1");
        pre.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(pre);
        pre.setBounds(26, 60, 660, 280);

        r2.setText("jButton1");
        r2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r2ActionPerformed(evt);
            }
        });
        jPanel1.add(r2);
        r2.setBounds(23, 511, 548, 134);

        r4.setText("jButton2");
        jPanel1.add(r4);
        r4.setBounds(600, 510, 548, 134);

        r1.setText("jButton2");
        r1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r1ActionPerformed(evt);
            }
        });
        jPanel1.add(r1);
        r1.setBounds(30, 360, 548, 134);

        r3.setText("jButton2");
        r3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r3ActionPerformed(evt);
            }
        });
        jPanel1.add(r3);
        r3.setBounds(600, 360, 548, 134);

        LabelIMG.setText("jLabel2");
        jPanel1.add(LabelIMG);
        LabelIMG.setBounds(710, 60, 440, 270);

        BtnEXIT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-cerca-35.png"))); // NOI18N
        BtnEXIT.setBorder(null);
        BtnEXIT.setBorderPainted(false);
        BtnEXIT.setContentAreaFilled(false);
        BtnEXIT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnEXIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEXITActionPerformed(evt);
            }
        });
        jPanel1.add(BtnEXIT);
        BtnEXIT.setBounds(1140, 10, 35, 35);

        jPanel2.setLayout(null);

        LabelPregunta1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelPregunta1.setText("jLabel1");
        LabelPregunta1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel2.add(LabelPregunta1);
        LabelPregunta1.setBounds(26, 60, 660, 280);

        BTNc1.setText("jButton1");
        BTNc1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNc1ActionPerformed(evt);
            }
        });
        jPanel2.add(BTNc1);
        BTNc1.setBounds(23, 511, 548, 134);

        BTNd1.setText("jButton2");
        jPanel2.add(BTNd1);
        BTNd1.setBounds(600, 510, 548, 134);

        BTNa1.setText("jButton2");
        jPanel2.add(BTNa1);
        BTNa1.setBounds(30, 360, 548, 134);

        BTNb1.setText("jButton2");
        jPanel2.add(BTNb1);
        BTNb1.setBounds(600, 360, 548, 134);

        LabelIMG1.setText("jLabel2");
        jPanel2.add(LabelIMG1);
        LabelIMG1.setBounds(710, 60, 440, 270);

        BtnEXIT1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-cerca-35.png"))); // NOI18N
        BtnEXIT1.setBorder(null);
        BtnEXIT1.setBorderPainted(false);
        BtnEXIT1.setContentAreaFilled(false);
        BtnEXIT1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnEXIT1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEXIT1ActionPerformed(evt);
            }
        });
        jPanel2.add(BtnEXIT1);
        BtnEXIT1.setBounds(1140, 10, 35, 35);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 0, 0);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1186, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1186, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 662, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void r2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_r2ActionPerformed

    private void BtnEXITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEXITActionPerformed
       // resetearArchivo("Partida");
       fin f = new fin();
        f.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtnEXITActionPerformed

    private void BTNc1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNc1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BTNc1ActionPerformed

    private void BtnEXIT1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEXIT1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnEXIT1ActionPerformed

    private void r1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_r1ActionPerformed

    private void r3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r3ActionPerformed
        Matematicas();
    }//GEN-LAST:event_r3ActionPerformed
     int num = 0;
    public void Matematicas() {
       
        int Numero = Matematicas.obtenerValor(num);
        int cont = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader("BP_Matematicas.txt"));
            String line = null;
            while ((line = br.readLine()) != null) {
                String temp[] = line.split("\t");

                String a ,b,c,d,e,f;
                
              if (cont == Numero )  {
                
              a = temp[0];
              b = temp[1];   
              c = temp[2];       
              d = temp[3];       
              e = temp[4];       
              f = temp[5];    
              
              pre.setText(a);
              r1.setText(b);
              r2.setText(c);     
              r3.setText(d);
              r4.setText(e); 
              
              
                num += 1;  
              }  else {
                  cont += 1;
              }
              
     

              
            }

            br.close();

        } catch (IOException ex) {
        }
    }
    
     
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        

//            switch () {
//
//                case 1:
//                    Matematicas();
//                    break;
//                case 2:
//                   
//                    break;
//                case 3:
//                    
//                    break;
//                case 4:
//                   
//                    break;
//
//            }

        
        
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
            java.util.logging.Logger.getLogger(framepreguntas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(framepreguntas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(framepreguntas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(framepreguntas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new framepreguntas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNa1;
    private javax.swing.JButton BTNb1;
    private javax.swing.JButton BTNc1;
    private javax.swing.JButton BTNd1;
    private javax.swing.JButton BtnEXIT;
    private javax.swing.JButton BtnEXIT1;
    private javax.swing.JLabel LabelIMG;
    private javax.swing.JLabel LabelIMG1;
    private javax.swing.JLabel LabelPregunta1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel pre;
    private javax.swing.JButton r1;
    private javax.swing.JButton r2;
    private javax.swing.JButton r3;
    private javax.swing.JButton r4;
    // End of variables declaration//GEN-END:variables
}
