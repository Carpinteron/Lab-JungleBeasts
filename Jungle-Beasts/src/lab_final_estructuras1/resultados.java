
package lab_final_estructuras1;

/**
 *
 * @author Paula Nuñez
 */
public class resultados extends javax.swing.JFrame {

    /**
     * Creates new form resultados
     */
    public resultados() {
        initComponents();
        this.setLocationRelativeTo(null);
        //this.setUndecorated(true);
        //this.setOpacity(0.0f);
       resultado r = new resultado();
       this.add(r);
       r.setVisible(true);
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
        BtnEXIT = new javax.swing.JButton();
        reaccion = new javax.swing.JLabel();
        respuesta = new javax.swing.JLabel();
        texto = new javax.swing.JLabel();
        tabla = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel1.add(BtnEXIT, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 540, -1, -1));

        reaccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/monstruo-feliz.gif"))); // NOI18N
        reaccion.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/monstruo-triste.gif"))); // NOI18N
        reaccion.setEnabled(false);
        jPanel1.add(reaccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 270, 200, 220));

        respuesta.setFont(new java.awt.Font("Book Antiqua", 1, 18)); // NOI18N
        respuesta.setForeground(new java.awt.Color(255, 255, 255));
        respuesta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        respuesta.setText("respuesta");
        jPanel1.add(respuesta, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 510, 430, -1));

        texto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/ganaste.png"))); // NOI18N
        texto.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/perdiste.png"))); // NOI18N
        texto.setEnabled(false);
        jPanel1.add(texto, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, 580, 350));

        tabla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/tablerohojas.png"))); // NOI18N
        jPanel1.add(tabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 928, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 928, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 651, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 651, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(resultados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(resultados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(resultados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(resultados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new resultados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnEXIT;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JLabel reaccion;
    javax.swing.JLabel respuesta;
    private javax.swing.JLabel tabla;
    public javax.swing.JLabel texto;
    // End of variables declaration//GEN-END:variables
}