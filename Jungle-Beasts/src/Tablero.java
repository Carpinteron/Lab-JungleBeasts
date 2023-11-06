
import java.awt.Color;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class Tablero extends javax.swing.JFrame {

    public Tablero() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        setLocationRelativeTo(null);
        FondoAleatorio();
        GenerarCamino();
        dadoLabel.setText("");
    }
    //EStas listas alamecenaran las categorias 
    ListaEnlazadaDoble Camino = new ListaEnlazadaDoble();
    int dado;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound1 = new custom.PanelRound();
        panelRound2 = new custom.PanelRound();
        BtnEXIT = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        USER = new javax.swing.JLabel();
        dadoLabel = new javax.swing.JLabel();
        huecoBTn2 = new javax.swing.JButton();
        huecoBTn1 = new javax.swing.JButton();
        huecoBTn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        P17 = new javax.swing.JLabel();
        P16 = new javax.swing.JLabel();
        P15 = new javax.swing.JLabel();
        P14 = new javax.swing.JLabel();
        P13 = new javax.swing.JLabel();
        P12 = new javax.swing.JLabel();
        P11 = new javax.swing.JLabel();
        P10 = new javax.swing.JLabel();
        P9 = new javax.swing.JLabel();
        P8 = new javax.swing.JLabel();
        P7 = new javax.swing.JLabel();
        P6 = new javax.swing.JLabel();
        P5 = new javax.swing.JLabel();
        P4 = new javax.swing.JLabel();
        P3 = new javax.swing.JLabel();
        P2 = new javax.swing.JLabel();
        P1 = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelRound2.setBackground(new java.awt.Color(29, 91, 49));

        BtnEXIT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-cerca-35.png"))); // NOI18N
        BtnEXIT.setBorder(null);
        BtnEXIT.setBorderPainted(false);
        BtnEXIT.setContentAreaFilled(false);
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

        jPanel1.setBackground(new java.awt.Color(0, 102, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(USER, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 500, 80, 110));

        dadoLabel.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        dadoLabel.setText("9");
        jPanel1.add(dadoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 390, 47, 53));

        huecoBTn2.setText("Hueco");
        huecoBTn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                huecoBTn2ActionPerformed(evt);
            }
        });
        jPanel1.add(huecoBTn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, -1, -1));

        huecoBTn1.setText("Hueco");
        huecoBTn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                huecoBTn1ActionPerformed(evt);
            }
        });
        jPanel1.add(huecoBTn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 350, -1, -1));

        huecoBTn.setText("Hueco");
        huecoBTn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                huecoBTnActionPerformed(evt);
            }
        });
        jPanel1.add(huecoBTn, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 100, -1, -1));

        jButton1.setText("Tirar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 450, 95, 40));

        P17.setText("17");
        jPanel1.add(P17, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 70, 50));

        P16.setText("16");
        jPanel1.add(P16, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 340, 70, 50));

        P15.setText("15");
        jPanel1.add(P15, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 470, 70, 50));

        P14.setText("14");
        jPanel1.add(P14, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 540, 70, 50));

        P13.setText("13");
        jPanel1.add(P13, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 530, 70, 50));

        P12.setText("12");
        jPanel1.add(P12, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 460, 70, 50));

        P11.setText("11");
        jPanel1.add(P11, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 230, 70, 50));

        P10.setText("10");
        jPanel1.add(P10, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 130, 70, 50));

        P9.setText("9");
        jPanel1.add(P9, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 180, 70, 50));

        P8.setText("8");
        jPanel1.add(P8, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 50, 70, 50));

        P7.setText("7");
        jPanel1.add(P7, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 120, 70, 50));

        P6.setText("6");
        jPanel1.add(P6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 190, 70, 50));

        P5.setText("4");
        jPanel1.add(P5, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 290, 70, 50));

        P4.setText("4");
        jPanel1.add(P4, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 310, 70, 50));

        P3.setText("3");
        jPanel1.add(P3, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 420, 70, 50));

        P2.setText("2");
        jPanel1.add(P2, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 540, 70, 50));

        P1.setText("Pregunta 1");
        jPanel1.add(P1, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 510, 70, 50));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Jungle beast (5)111.png"))); // NOI18N
        jPanel1.add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 1150, 650));

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 659, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnEXITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEXITActionPerformed
        System.exit(0);
    }//GEN-LAST:event_BtnEXITActionPerformed
    Random ran = new Random();
       
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dado=ran.nextInt(6)+1;
        dadoLabel.setText("");
        dadoLabel.setText(Integer.toString(dado));
    }//GEN-LAST:event_jButton1ActionPerformed

    private void huecoBTnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_huecoBTnActionPerformed
        Send_ToAhorcado();
    }//GEN-LAST:event_huecoBTnActionPerformed

    private void huecoBTn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_huecoBTn1ActionPerformed
        Send_ToAhorcado();
    }//GEN-LAST:event_huecoBTn1ActionPerformed

    private void huecoBTn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_huecoBTn2ActionPerformed
        Send_ToAhorcado();
    }//GEN-LAST:event_huecoBTn2ActionPerformed

    public void FondoAleatorio(){
       int  f=ran.nextInt(4);
        switch(f){
            case 0:
                fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Jungle beast (5)111.png")));
                break;
            case 1:
                fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Jungle beast (1).png")));
                break;
            case 2:
                fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Jungle beast (2).png")));
                break;
            case 3:
                fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Jungle beast (3).png")));
                break;
        }
    }
    public void Send_ToAhorcado(){
         Ahorcado a = new Ahorcado();
        a.setVisible(true);
        this.dispose();
    }
    public void GenerarCamino() {
        
        String []Categorias={"Ingles","Conocimiento General","Matematicas","Ciencia","Razonamiento Abstracto","Sociales"};
        for(int i=0;i<17;i++){
            int r=ran.nextInt(6); // numero del 0 a 5
            Camino.add_alFinal(Categorias[r]);
        }
        Camino.add_afterPOS("Ahorcado", 5); //pos 6
        Camino.add_afterPOS("Ahorcado", 11);// pos 12
        Camino.add_afterPOS("Ahorcado", 17); // pos 18
        
        Camino.imprimir();
    }
 public static void ArchivoInventario(String file_name) {
        try {
            FileWriter outFile = new FileWriter(file_name + ".txt", false);
            PrintWriter registro = new PrintWriter(outFile);

            // respuesta correcta enseguida: avanza 2 casillas
            
            //Matriz para crear Archivo Existente 
            String[][] preguntas = {
                // Categoria , Pregunta , "a", b, c ,d, res, nombreDeLaImagen
                //EJEMPLO
                //{"Ingles","¿what is an apple?","naranja","manzana","uva","pera","manzana","IMGmonstruo1"},
                {"Camiseta XS", "20", "Camiseta", "Conan Gray", "30000"},
                {"Camiseta S", "20", "Camiseta", "Conan Gray", "30000"},
               

            };

            //Agregar datos de la matriz al registro
            for (String[] fila : preguntas) {
                String NombreProducto = fila[0];
                String Cantidad = fila[1];
                String Categoria = fila[2];
                String Artista = fila[3];
                String Precio = fila[4];

                // Agregar los datos al archivo
                registro.println(NombreProducto + ";" + Cantidad + ";" + Categoria + ";" + Artista + ";" + Precio);

            }

            registro.close();
            System.out.println("Datos agregados exitosamente al archivo " + file_name);

        } catch (IOException ex) {
            System.out.println("Error al agregar datos al archivo");
            ex.printStackTrace();
        }
    }

    //Listas 
    static class Nodo {

        String dato;
        Nodo siguiente;
        Nodo prev;

        public Nodo(String dato) {
            this.dato = dato;
            this.siguiente = null;
            this.prev = null;
        }
    }

    static class ListaEnlazadaDoble {

        Nodo head; // El primer nodo de la lista

        public ListaEnlazadaDoble() {
            head = null;
        }

        public void add_alFinal(String dato) {
            Nodo nuevoNodo = new Nodo(dato);
            if (head == null) {
                head = nuevoNodo;
            } else {
                Nodo actual = head;
                while (actual.siguiente != null) {
                    actual = actual.siguiente;
                }
                actual.siguiente = nuevoNodo;
                nuevoNodo.prev = actual;
            }
        }

        public void add_alComienzo(String dato) {
            Nodo nuevoNodo = new Nodo(dato);
            if (head == null) {
                head = nuevoNodo;
            } else {
                Nodo actual = head;
                actual.prev = nuevoNodo;
                nuevoNodo.siguiente = actual;
                head = nuevoNodo;

            }
        }

        public void add_afterPOS(String dato, int pos) {
            Nodo nuevoNodo = new Nodo(dato);
            if (head == null) {
                head = nuevoNodo;
            } else {
                Nodo actual = head;
                int i = 0;
                while (actual.siguiente != null & i < pos) {
                    actual = actual.siguiente;
                    i++;
                }

                // Verificar si se encontró el nodo en la posición pos
                if (actual != null) {
                    nuevoNodo.prev = actual;
                    nuevoNodo.siguiente = actual.siguiente;

                    // Actualizar los punteros del nodo actual y del siguiente nodo
                    if (actual.siguiente != null) {
                        actual.siguiente.prev = nuevoNodo;
                    }
                    actual.siguiente = nuevoNodo;
                } else {
                    // Si no se encontró la posición pos, agrega el nuevo nodo al final
                    Nodo ultimo = head;
                    while (ultimo.siguiente != null) {
                        ultimo = ultimo.siguiente;
                    }
                    ultimo.siguiente = nuevoNodo;
                    nuevoNodo.prev = ultimo;
                }

            }

        }

        public void imprimir() {
            Nodo actual = head;
            while (actual != null) {
                System.out.print(actual.dato + " | ");
                actual = actual.siguiente;
            }
            System.out.println();
        }
    }

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
            java.util.logging.Logger.getLogger(Tablero.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tablero.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tablero.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tablero.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tablero().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnEXIT;
    private javax.swing.JLabel P1;
    private javax.swing.JLabel P10;
    private javax.swing.JLabel P11;
    private javax.swing.JLabel P12;
    private javax.swing.JLabel P13;
    private javax.swing.JLabel P14;
    private javax.swing.JLabel P15;
    private javax.swing.JLabel P16;
    private javax.swing.JLabel P17;
    private javax.swing.JLabel P2;
    private javax.swing.JLabel P3;
    private javax.swing.JLabel P4;
    private javax.swing.JLabel P5;
    private javax.swing.JLabel P6;
    private javax.swing.JLabel P7;
    private javax.swing.JLabel P8;
    private javax.swing.JLabel P9;
    private javax.swing.JLabel USER;
    private javax.swing.JLabel dadoLabel;
    private javax.swing.JLabel fondo;
    private javax.swing.JButton huecoBTn;
    private javax.swing.JButton huecoBTn1;
    private javax.swing.JButton huecoBTn2;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private custom.PanelRound panelRound1;
    private custom.PanelRound panelRound2;
    // End of variables declaration//GEN-END:variables
}
