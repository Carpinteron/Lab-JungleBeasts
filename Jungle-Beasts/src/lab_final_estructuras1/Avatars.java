package lab_final_estructuras1;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import static lab_final_estructuras1.Jungle_parte_inicio.clip;

public class Avatars extends javax.swing.JFrame implements ActionListener {

    int xmouse, ymouse;

    public static int avatar;
    ClassLoader CL = getClass().getClassLoader();
    ImageIcon bi = new ImageIcon(CL.getResource("IMAGENES/a.png"));
    ImageIcon girl = new ImageIcon(CL.getResource("IMAGENES/b.png"));
    ImageIcon man = new ImageIcon(CL.getResource("IMAGENES/c.png"));
    ImageIcon cb = new ImageIcon(CL.getResource("IMAGENES/check.png"));

    ImageIcon bi2 = new ImageIcon(CL.getResource("IMAGENES/a1.png"));
    ImageIcon girl2 = new ImageIcon(CL.getResource("IMAGENES/b1.png"));
    ImageIcon man2 = new ImageIcon(CL.getResource("IMAGENES/c1.png"));

    ImageIcon coni = new ImageIcon(CL.getResource("IMAGENES/coni.png"));
    ImageIcon coni1 = new ImageIcon(CL.getResource("IMAGENES/coni1.png"));
    public static Clip clip2;
    private void sonido2(String cadena) {
        try {
            URL url = getClass().getResource(cadena);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
            clip2 = AudioSystem.getClip();
            clip2.open(audioIn);
            clip2.start();
            
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    private Clip clip3;
    //SUBRUTINA PARA APLICAR SONIDO
    private void sonido(String cadena) {
        try {
            Clip clip = AudioSystem.getClip();
            URL url = getClass().getResource(cadena);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
            clip.open(audioIn);
            clip.start();
        } catch (Exception e) {
            // System.err.println(e.getMessage());
        }
    }

    public void sonido3(JButton boton, String archivoSonido) {
        boton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                try {
                    clip3 = AudioSystem.getClip();
                    URL url = getClass().getResource(archivoSonido);
                    AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
                    clip3.open(audioIn);
                    clip3.start();
                    boton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    clip3.stop();
                    sonido("/Sonido/seleccion.wav");
                    

                }
            });
                } catch (Exception ex) {
                    System.err.println(ex.getMessage());
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                if (clip3 != null) {
                    clip3.stop();
                    clip3.close();
                }
            }
        });
    }
    

    public Avatars() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        setLocationRelativeTo(null);
        this.a.addActionListener(this);
        this.b.addActionListener(this);
        this.c.addActionListener(this);
        BARRA.setBackground(new Color(0, 0, 0, 0)); // Le establece el color del fondo de la barra tranparente.
        //sonido2("/Sonido/music.wav");
        //APLIOAR SONIDOS
         sonido3(a,"/Sonido/jumanji.wav");
         sonido3(b,"/Sonido/jumanji.wav");
         sonido3(c,"/Sonido/jumanji.wav");

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

        FONDO_REDONDO = new org.example.Custom.BlurBackground();
        BARRA = new javax.swing.JPanel();
        BtnEXIT = new javax.swing.JButton();
        a = new javax.swing.JButton();
        b = new javax.swing.JButton();
        c = new javax.swing.JButton();
        ok = new javax.swing.JButton();
        cb1 = new javax.swing.JButton();
        cb2 = new javax.swing.JButton();
        cb3 = new javax.swing.JButton();
        val = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        FONDO_REDONDO.setImage(new javax.swing.ImageIcon(getClass().getResource("/IMG/fondo seleccion.jpg"))); // NOI18N
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
            .addGroup(BARRALayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BtnEXIT)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        FONDO_REDONDO.add(BARRA);
        BARRA.setBounds(0, 0, 1180, 47);

        a.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/a.png"))); // NOI18N
        a.setBorderPainted(false);
        a.setContentAreaFilled(false);
        a.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/sa.png"))); // NOI18N
        a.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                aMouseClicked(evt);
            }
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
        FONDO_REDONDO.add(a);
        a.setBounds(80, 330, 246, 297);

        b.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/b.png"))); // NOI18N
        b.setBorderPainted(false);
        b.setContentAreaFilled(false);
        b.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/sb.png"))); // NOI18N
        b.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bMouseClicked(evt);
            }
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
        FONDO_REDONDO.add(b);
        b.setBounds(410, 340, 246, 297);

        c.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/c.png"))); // NOI18N
        c.setBorderPainted(false);
        c.setContentAreaFilled(false);
        c.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/sc.png"))); // NOI18N
        c.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cMouseExited(evt);
            }
        });
        FONDO_REDONDO.add(c);
        c.setBounds(740, 340, 246, 280);

        ok.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/coni.png"))); // NOI18N
        ok.setContentAreaFilled(false);
        ok.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ok.setDefaultCapable(false);
        ok.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                okMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                okMouseExited(evt);
            }
        });
        ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okActionPerformed(evt);
            }
        });
        FONDO_REDONDO.add(ok);
        ok.setBounds(1010, 590, 176, 57);

        cb1.setContentAreaFilled(false);
        cb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb1ActionPerformed(evt);
            }
        });
        FONDO_REDONDO.add(cb1);
        cb1.setBounds(150, 250, 100, 70);

        cb2.setContentAreaFilled(false);
        FONDO_REDONDO.add(cb2);
        cb2.setBounds(480, 270, 100, 60);

        cb3.setContentAreaFilled(false);
        FONDO_REDONDO.add(cb3);
        cb3.setBounds(800, 270, 110, 60);

        val.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        val.setForeground(new java.awt.Color(255, 0, 0));
        FONDO_REDONDO.add(val);
        val.setBounds(350, 220, 460, 80);

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

    private void cMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cMouseExited
        c.setIcon(man);
    }//GEN-LAST:event_cMouseExited

    private void cMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cMouseEntered
        c.setIcon(man2);
    }//GEN-LAST:event_cMouseEntered

    private void cMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cMouseClicked
        Avatar = 3;
    }//GEN-LAST:event_cMouseClicked

    private void bActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bActionPerformed

    private void bMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bMouseExited
        b.setIcon(girl);
    }//GEN-LAST:event_bMouseExited

    private void bMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bMouseEntered
        b.setIcon(girl2);
    }//GEN-LAST:event_bMouseEntered

    private void bMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bMouseClicked
        Avatar = 2;
    }//GEN-LAST:event_bMouseClicked

    private void aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_aActionPerformed

    private void aMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aMouseExited
        a.setIcon(bi);
    }//GEN-LAST:event_aMouseExited

    private void aMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aMouseEntered
        a.setIcon(bi2);
    }//GEN-LAST:event_aMouseEntered

    private void aMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aMouseClicked
        Avatar = 1;
    }//GEN-LAST:event_aMouseClicked

    private void BARRAMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BARRAMousePressed
        xmouse = evt.getX(); // Obtiene la posicion horizontal del punto donde se hizo clic.
        ymouse = evt.getY(); // Obtiene la posicion vertical del punto donde se hizo clic.
    }//GEN-LAST:event_BARRAMousePressed

    private void BARRAMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BARRAMouseDragged
        int x = evt.getXOnScreen(); //Obttiene la posicion horizontal actual en pantalla.
        int y = evt.getYOnScreen(); //Obtiene la posicion vertical actual en pantalla.
        this.setLocation(x - xmouse, y - ymouse); //Establece la poscion de la ventana en funcion de la posicion original del mouse.
    }//GEN-LAST:event_BARRAMouseDragged

    private void okMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_okMouseEntered
        ok.setIcon(coni1);
    }//GEN-LAST:event_okMouseEntered

    private void okMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_okMouseExited
        ok.setIcon(coni);
    }//GEN-LAST:event_okMouseExited
    int Avatar = 0;
    private void okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okActionPerformed
        if (AvatarJugador1.avatar != 0) {

            System.out.println("A" + Avatar);
            if (Avatar != 0) {
                clip2.stop();
                Tablero T = new Tablero(Avatar,true,true);
                T.setVisible(true);
                this.dispose();
                
            } else {
                //VALIDACION 
            }

        } else {
            sonido("/Sonido/error.wav");
            val.setText("(!) Debe escoger un avatar antes de jugar.");

        }

    }//GEN-LAST:event_okActionPerformed

    private void cb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb1ActionPerformed

    private void BtnEXITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEXITActionPerformed
       
        fin f = new fin();
        f.setVisible(true);
        this.dispose();
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
    private javax.swing.JPanel BARRA;
    private javax.swing.JButton BtnEXIT;
    private org.example.Custom.BlurBackground FONDO_REDONDO;
    private javax.swing.JButton a;
    private javax.swing.JButton b;
    private javax.swing.JButton c;
    private javax.swing.JButton cb1;
    private javax.swing.JButton cb2;
    private javax.swing.JButton cb3;
    private javax.swing.JButton ok;
    private javax.swing.JLabel val;
    // End of variables declaration//GEN-END:variables

}
