
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Avatars extends javax.swing.JFrame implements ActionListener {

    public static int avatar;
    ClassLoader CL = getClass().getClassLoader();
    ImageIcon bi = new ImageIcon(CL.getResource("IMAGENES/a.png"));
    ImageIcon girl = new ImageIcon(CL.getResource("IMAGENES/b.png"));
    ImageIcon man = new ImageIcon(CL.getResource("IMAGENES/c.png"));
    ImageIcon cb = new ImageIcon(CL.getResource("IMAGENES/check.png"));
    
    ImageIcon bi2 = new ImageIcon(CL.getResource("IMAGENES/a1.png"));
    ImageIcon girl2 = new ImageIcon(CL.getResource("IMAGENES/b1.png"));
    ImageIcon man2 = new ImageIcon(CL.getResource("IMAGENES/c1.png"));

    public Avatars() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        setLocationRelativeTo(null);
        this.a.addActionListener(this);
        this.b.addActionListener(this);
        this.c.addActionListener(this);

    }
    JButton btn;

    public void actionPerformed(ActionEvent e) {
        btn = (JButton) e.getSource();
        if (e.getSource() == c) {//3
            AvatarJugador1.avatar = 1;
            cb1.setIcon(null);//1
            cb2.setIcon(null);//2
            cb3.setIcon(cb);//3
            c.setEnabled(false);//3
            a.setEnabled(true);//1
            b.setEnabled(true);//2
            a.setIcon(bi);//1
            b.setIcon(girl);//2
            val.setText("");

        } else if (e.getSource() == a) {
            AvatarJugador1.avatar = 2;
             cb2.setIcon(null);
            cb1.setIcon(cb);
            cb3.setIcon(null);
             a.setEnabled(false);
             c.setEnabled(true);
             b.setEnabled(true);
            c.setIcon(man);
            b.setIcon(girl);
            val.setText("");
        } else if (e.getSource() == b) {
            AvatarJugador1.avatar = 3;
            cb1.setIcon(null);
            cb3.setIcon(null);
            cb2.setIcon(cb);
           // AverdeBTN.setIcon(sverde);
            b.setEnabled(false);
            c.setEnabled(true);
             a.setEnabled(true);
           a.setIcon(bi);
            c.setIcon(man);
            val.setText("");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound1 = new custom.PanelRound();
        panelRound2 = new custom.PanelRound();
        BtnEXIT = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        val = new javax.swing.JLabel();
        c = new javax.swing.JButton();
        a = new javax.swing.JButton();
        b = new javax.swing.JButton();
        cb3 = new javax.swing.JButton();
        cb1 = new javax.swing.JButton();
        cb2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound2.setBackground(new java.awt.Color(29, 91, 49));

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

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnEXIT, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BtnEXIT)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelRound1.add(panelRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 3, 1180, 50));

        jButton1.setText("ok");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panelRound1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 630, -1, -1));

        val.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        val.setForeground(new java.awt.Color(255, 0, 0));
        panelRound1.add(val, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 280, 560, -1));

        c.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/c.png"))); // NOI18N
        c.setBorderPainted(false);
        c.setContentAreaFilled(false);
        c.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/sc.png"))); // NOI18N
        c.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cMouseExited(evt);
            }
        });
        panelRound1.add(c, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 320, 240, 290));

        a.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/a.png"))); // NOI18N
        a.setBorderPainted(false);
        a.setContentAreaFilled(false);
        a.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/sa.png"))); // NOI18N
        a.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                aMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                aMouseExited(evt);
            }
        });
        a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aActionPerformed(evt);
            }
        });
        panelRound1.add(a, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 320, 240, 290));

        b.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/b.png"))); // NOI18N
        b.setBorderPainted(false);
        b.setContentAreaFilled(false);
        b.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/sb.png"))); // NOI18N
        b.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bMouseExited(evt);
            }
        });
        b.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bActionPerformed(evt);
            }
        });
        panelRound1.add(b, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 330, 240, 290));

        cb3.setContentAreaFilled(false);
        panelRound1.add(cb3, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 250, 80, 60));

        cb1.setContentAreaFilled(false);
        panelRound1.add(cb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, 80, 60));

        cb2.setContentAreaFilled(false);
        panelRound1.add(cb2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 270, 80, 60));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/seleccion (2).png"))); // NOI18N
        panelRound1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 1180, 620));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnEXITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEXITActionPerformed
        System.exit(0);
    }//GEN-LAST:event_BtnEXITActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (AvatarJugador1.avatar != 0) {
            Tablero T = new Tablero();
        T.setVisible(true);
        this.dispose();
        
        } else {
            //sonido("/Sonidos/error.wav");
            val.setText("(!) Debe escoger un avatar antes de jugar.");

        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void bActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bActionPerformed

    private void aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_aActionPerformed

    private void aMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aMouseEntered
        a.setIcon(bi2);
    }//GEN-LAST:event_aMouseEntered

    private void aMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aMouseExited
       a.setIcon(bi);
    }//GEN-LAST:event_aMouseExited

    private void bMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bMouseExited
        b.setIcon(girl);
    }//GEN-LAST:event_bMouseExited

    private void cMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cMouseEntered
        c.setIcon(man2);
    }//GEN-LAST:event_cMouseEntered

    private void cMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cMouseExited
       c.setIcon(man);
    }//GEN-LAST:event_cMouseExited

    private void bMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bMouseEntered
        b.setIcon(girl2);
    }//GEN-LAST:event_bMouseEntered

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
            java.util.logging.Logger.getLogger(Avatars.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Avatars.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Avatars.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Avatars.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Avatars().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnEXIT;
    private javax.swing.JButton a;
    private javax.swing.JButton b;
    private javax.swing.JButton c;
    private javax.swing.JButton cb1;
    private javax.swing.JButton cb2;
    private javax.swing.JButton cb3;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private custom.PanelRound panelRound1;
    private custom.PanelRound panelRound2;
    private javax.swing.JLabel val;
    // End of variables declaration//GEN-END:variables
}
