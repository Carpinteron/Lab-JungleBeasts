
package lab_final_estructuras1;

import java.awt.Color;


public class PreguntaPanel extends javax.swing.JPanel {

  
    public PreguntaPanel() {
        initComponents();
       //this.setLocationRelativeTo(null); //Establece la ubicacion de la ventana en el centro de la pantalla.
        setBackground(new Color(0, 0, 0, 0)); //Le establece el color del fondo de la ventana a transparente.
       // BARRA.setBackground(new Color(0, 0, 0, 0)); 
       
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
        add(BtnEXIT);
        BtnEXIT.setBounds(1140, 10, 35, 35);
    }// </editor-fold>//GEN-END:initComponents

    private void BTNcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BTNcActionPerformed

    private void BtnEXITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEXITActionPerformed
        System.exit(0);
    }//GEN-LAST:event_BtnEXITActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNa;
    private javax.swing.JButton BTNb;
    private javax.swing.JButton BTNc;
    private javax.swing.JButton BTNd;
    private javax.swing.JButton BtnEXIT;
    private javax.swing.JLabel LabelIMG;
    private javax.swing.JLabel LabelPregunta;
    // End of variables declaration//GEN-END:variables
}
