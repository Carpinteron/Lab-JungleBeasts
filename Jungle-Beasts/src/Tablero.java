
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
        GenerarCamino();
    }
    //EStas listas alamecenaran las categorias 
    ListaEnlazadaDoble Camino = new ListaEnlazadaDoble();

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound1 = new custom.PanelRound();
        panelRound2 = new custom.PanelRound();
        BtnEXIT = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

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
                .addContainerGap(1130, Short.MAX_VALUE)
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

        jButton1.setText("jButton1");

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelRound1Layout.createSequentialGroup()
                    .addGap(552, 552, 552)
                    .addComponent(jButton1)
                    .addContainerGap(553, Short.MAX_VALUE)))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(617, Short.MAX_VALUE))
            .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelRound1Layout.createSequentialGroup()
                    .addGap(321, 321, 321)
                    .addComponent(jButton1)
                    .addContainerGap(321, Short.MAX_VALUE)))
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

    public void GenerarCamino() {
         Random ran = new Random();
       
        String []Categorias={"Ingles","Conocimiento General","Matematicas","Ciencia","Razonamiento Abstracto","Sociales"};
        for(int i=0;i<=20;i++){
            int r=ran.nextInt(6);
            Camino.add_alFinal(Categorias[r]);
        }
        Camino.imprimir();
    }
 public static void ArchivoInventario(String file_name) {
        try {
            FileWriter outFile = new FileWriter(file_name + ".txt", false);
            PrintWriter registro = new PrintWriter(outFile);

            //Matriz para crear Archivo Existente 
            String[][] inventario = {
                //Seccion CONAN
                {"Camiseta XS", "20", "Camiseta", "Conan Gray", "30000"},
                {"Camiseta S", "20", "Camiseta", "Conan Gray", "30000"},
               

            };

            //Agregar datos de la matriz al registro
            for (String[] fila : inventario) {
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
    private javax.swing.JButton jButton1;
    private custom.PanelRound panelRound1;
    private custom.PanelRound panelRound2;
    // End of variables declaration//GEN-END:variables
}
