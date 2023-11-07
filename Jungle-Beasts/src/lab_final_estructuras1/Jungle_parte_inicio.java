/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package lab_final_estructuras1;

import java.awt.Color;
import javax.swing.ImageIcon;

/**
 *
 * @author almacen
 */
public class Jungle_parte_inicio extends javax.swing.JFrame {
    ClassLoader CL = getClass().getClassLoader();
    ImageIcon j = new ImageIcon(CL.getResource("IMAGENES/j.png"));
    ImageIcon j1 = new ImageIcon(CL.getResource("IMAGENES/j1.png"));
    ImageIcon cj = new ImageIcon(CL.getResource("IMAGENES/cj.png"));
    ImageIcon cj1 = new ImageIcon(CL.getResource("IMAGENES/cj1.png"));
    ImageIcon cr = new ImageIcon(CL.getResource("IMAGENES/cr.png"));
    ImageIcon cr1 = new ImageIcon(CL.getResource("IMAGENES/cr1.png"));

    int xmouse, ymouse;
    
    public Jungle_parte_inicio() {
        initComponents();
        setLocationRelativeTo(null); //Establece la ubicacion de la ventana en el centro de la pantalla.
        setBackground(new Color(0, 0, 0, 0)); //Le establece el color del fondo de la ventana a transparente.
        BARRA.setBackground(new Color(0, 0, 0, 0)); // Le establece el color del fondo de la barra tranparente.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FONDO_REDONDO = new org.example.Custom.BlurBackground();
        BARRA = new javax.swing.JPanel();
        BtnEXIT = new javax.swing.JButton();
        inicio = new javax.swing.JButton();
        info = new javax.swing.JButton();
        cred = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        FONDO_REDONDO.setImage(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/inicio2.png"))); // NOI18N
        FONDO_REDONDO.setRadius(55);

        BARRA.setBackground(new java.awt.Color(255, 255, 255));
        BARRA.setForeground(new java.awt.Color(255, 255, 255));
        BARRA.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                BARRAMouseDragged(evt);
            }
        });
        BARRA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BARRAMousePressed(evt);
            }
        });

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

        javax.swing.GroupLayout BARRALayout = new javax.swing.GroupLayout(BARRA);
        BARRA.setLayout(BARRALayout);
        BARRALayout.setHorizontalGroup(
            BARRALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BARRALayout.createSequentialGroup()
                .addContainerGap(1130, Short.MAX_VALUE)
                .addComponent(BtnEXIT, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        BARRALayout.setVerticalGroup(
            BARRALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BARRALayout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addComponent(BtnEXIT))
        );

        FONDO_REDONDO.add(BARRA);
        BARRA.setBounds(0, 0, 1180, 41);

        inicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/j.png"))); // NOI18N
        inicio.setBorderPainted(false);
        inicio.setContentAreaFilled(false);
        inicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        inicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                inicioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                inicioMouseExited(evt);
            }
        });
        inicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicioActionPerformed(evt);
            }
        });
        FONDO_REDONDO.add(inicio);
        inicio.setBounds(10, 390, 216, 78);

        info.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/cj.png"))); // NOI18N
        info.setBorderPainted(false);
        info.setContentAreaFilled(false);
        info.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        info.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                infoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                infoMouseExited(evt);
            }
        });
        info.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infoActionPerformed(evt);
            }
        });
        FONDO_REDONDO.add(info);
        info.setBounds(0, 470, 216, 78);

        cred.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/cr.png"))); // NOI18N
        cred.setBorderPainted(false);
        cred.setContentAreaFilled(false);
        cred.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cred.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                credMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                credMouseExited(evt);
            }
        });
        cred.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                credActionPerformed(evt);
            }
        });
        FONDO_REDONDO.add(cred);
        cred.setBounds(0, 550, 216, 78);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FONDO_REDONDO, javax.swing.GroupLayout.DEFAULT_SIZE, 1180, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FONDO_REDONDO, javax.swing.GroupLayout.DEFAULT_SIZE, 664, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void credActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_credActionPerformed

    }//GEN-LAST:event_credActionPerformed

    private void credMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_credMouseExited
        cred.setIcon(cr);
    }//GEN-LAST:event_credMouseExited

    private void credMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_credMouseEntered
        cred.setIcon(cr1);
    }//GEN-LAST:event_credMouseEntered

    private void infoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_infoActionPerformed

    private void infoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_infoMouseExited
        info.setIcon(cj);
    }//GEN-LAST:event_infoMouseExited

    private void infoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_infoMouseEntered
        info.setIcon(cj1);
    }//GEN-LAST:event_infoMouseEntered

    private void inicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicioActionPerformed
        Avatars A = new Avatars();
        A.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_inicioActionPerformed

    private void inicioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inicioMouseExited
        inicio.setIcon(j);
    }//GEN-LAST:event_inicioMouseExited

    private void inicioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inicioMouseEntered
        inicio.setIcon(j1);
    }//GEN-LAST:event_inicioMouseEntered

    private void BARRAMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BARRAMousePressed
        xmouse = evt.getX(); // Obtiene la posicion horizontal del punto donde se hizo clic.
        ymouse = evt.getY(); // Obtiene la posicion vertical del punto donde se hizo clic.
    }//GEN-LAST:event_BARRAMousePressed

    private void BARRAMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BARRAMouseDragged
        int x = evt.getXOnScreen(); //Obttiene la posicion horizontal actual en pantalla.
        int y = evt.getYOnScreen(); //Obtiene la posicion vertical actual en pantalla.
        this.setLocation(x - xmouse, y - ymouse); //Establece la poscion de la ventana en funcion de la posicion original del mouse.
    }//GEN-LAST:event_BARRAMouseDragged

    private void BtnEXITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEXITActionPerformed
        System.exit(0);
    }//GEN-LAST:event_BtnEXITActionPerformed

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
            java.util.logging.Logger.getLogger(Jungle_parte_inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Jungle_parte_inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Jungle_parte_inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Jungle_parte_inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Jungle_parte_inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BARRA;
    private javax.swing.JButton BtnEXIT;
    private org.example.Custom.BlurBackground FONDO_REDONDO;
    private javax.swing.JButton cred;
    private javax.swing.JButton info;
    private javax.swing.JButton inicio;
    // End of variables declaration//GEN-END:variables
}
