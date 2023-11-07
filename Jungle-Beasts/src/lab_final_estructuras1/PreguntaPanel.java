
package lab_final_estructuras1;

import java.awt.Color;


public class PreguntaPanel extends javax.swing.JPanel {

  
    public PreguntaPanel() {
        initComponents();
        //this.setLocationRelativeTo(null); //Establece la ubicacion de la ventana en el centro de la pantalla.
        setBackground(new Color(0, 0, 0, 0)); //Le establece el color del fondo de la ventana a transparente.
      //  BARRA.setBackground(new Color(0, 0, 0, 0));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LabelPregunta = new javax.swing.JLabel();
        BTNc = new javax.swing.JButton();
        BTNd = new javax.swing.JButton();
        BTNa = new javax.swing.JButton();
        BTNb = new javax.swing.JButton();
        LabelIMG = new javax.swing.JLabel();
        BARRA = new javax.swing.JPanel();
        BtnEXIT = new javax.swing.JButton();

        setLayout(null);

        LabelPregunta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelPregunta.setText("jLabel1");
        LabelPregunta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(LabelPregunta);
        LabelPregunta.setBounds(26, 60, 660, 280);

        BTNc.setText("jButton1");
        BTNc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNcActionPerformed(evt);
            }
        });
        add(BTNc);
        BTNc.setBounds(23, 511, 548, 134);

        BTNd.setText("jButton2");
        add(BTNd);
        BTNd.setBounds(600, 510, 548, 134);

        BTNa.setText("jButton2");
        add(BTNa);
        BTNa.setBounds(23, 359, 548, 134);

        BTNb.setText("jButton2");
        add(BTNb);
        BTNb.setBounds(600, 360, 548, 134);

        LabelIMG.setText("jLabel2");
        add(LabelIMG);
        LabelIMG.setBounds(710, 60, 440, 270);

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        add(BARRA);
        BARRA.setBounds(0, 0, 1180, 47);
    }// </editor-fold>//GEN-END:initComponents

    private void BTNcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BTNcActionPerformed

    private void BtnEXITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEXITActionPerformed
        System.exit(0);
    }//GEN-LAST:event_BtnEXITActionPerformed

    private void BARRAMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BARRAMouseDragged
        int x = evt.getXOnScreen(); //Obttiene la posicion horizontal actual en pantalla.
        int y = evt.getYOnScreen(); //Obtiene la posicion vertical actual en pantalla.
        this.setLocation(x - xmouse, y - ymouse); //Establece la poscion de la ventana en funcion de la posicion original del mouse.
    }//GEN-LAST:event_BARRAMouseDragged

    private void BARRAMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BARRAMousePressed
        xmouse = evt.getX(); // Obtiene la posicion horizontal del punto donde se hizo clic.
        ymouse = evt.getY(); // Obtiene la posicion vertical del punto donde se hizo clic.
    }//GEN-LAST:event_BARRAMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BARRA;
    private javax.swing.JButton BTNa;
    private javax.swing.JButton BTNb;
    private javax.swing.JButton BTNc;
    private javax.swing.JButton BTNd;
    private javax.swing.JButton BtnEXIT;
    private javax.swing.JLabel LabelIMG;
    private javax.swing.JLabel LabelPregunta;
    // End of variables declaration//GEN-END:variables
}
