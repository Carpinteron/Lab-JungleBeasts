
import java.awt.Color;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.swing.ImageIcon;

public class Tablero extends javax.swing.JFrame {
    ClassLoader CL = getClass().getClassLoader();
//    ImageIcon A = new ImageIcon(CL.getResource("IMG/morado150.png"));//BIN =1
//    ImageIcon B = new ImageIcon(CL.getResource("IMG/rojo150.png"));//CHICA=2
//    ImageIcon C = new ImageIcon(CL.getResource("IMG/verde150.png")); //CHICO=3
    private int user;
    public Tablero(int Avatar) {
        initComponents();
        this.user=Avatar;
        setBackground(new Color(0, 0, 0, 0));
        setLocationRelativeTo(null);
        FondoAleatorio();
        GenerarCamino();
        dadoLabel.setText("");
        
     
//        switch (user) {
//            case 1:
//                USER.setIcon(A);
//                break;
//            case 2:
//                USER.setIcon(B);
//                break;
//            case 3:
//                USER.setIcon(C);
//                break;
//
//        }
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

        panelRound1.setBackground(new java.awt.Color(0, 102, 51));

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

        dadoLabel.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        dadoLabel.setText("9");

        huecoBTn2.setText("Hueco");
        huecoBTn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                huecoBTn2ActionPerformed(evt);
            }
        });

        huecoBTn1.setText("Hueco");
        huecoBTn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                huecoBTn1ActionPerformed(evt);
            }
        });

        huecoBTn.setText("Hueco");
        huecoBTn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                huecoBTnActionPerformed(evt);
            }
        });

        jButton1.setText("Tirar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        P17.setText("17");

        P16.setText("16");

        P15.setText("15");

        P14.setText("14");

        P13.setText("13");

        P12.setText("12");

        P11.setText("11");

        P10.setText("10");

        P9.setText("9");

        P8.setText("8");

        P7.setText("7");

        P6.setText("6");

        P5.setText("4");

        P4.setText("4");

        P3.setText("3");

        P2.setText("2");

        P1.setText("Pregunta 1");

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Jungle beast (5)111.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(800, 800, 800)
                .addComponent(P4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(P15, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(P14, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(P13, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(P12, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(470, 470, 470)
                .addComponent(USER, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(390, 390, 390)
                .addComponent(P11, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(480, 480, 480)
                .addComponent(huecoBTn1))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(P16, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(690, 690, 690)
                .addComponent(P8, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(820, 820, 820)
                .addComponent(P7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(P17, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(900, 900, 900)
                .addComponent(P1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(1040, 1040, 1040)
                .addComponent(P6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(950, 950, 950)
                .addComponent(huecoBTn))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(1040, 1040, 1040)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(670, 670, 670)
                .addComponent(P3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(620, 620, 620)
                .addComponent(P9, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(740, 740, 740)
                .addComponent(P2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(950, 950, 950)
                .addComponent(P5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(490, 490, 490)
                .addComponent(P10, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(1070, 1070, 1070)
                .addComponent(dadoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(huecoBTn2))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(fondo, javax.swing.GroupLayout.PREFERRED_SIZE, 1150, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(310, 310, 310)
                .addComponent(P4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(P15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(P14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(P13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(P12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(USER, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(230, 230, 230)
                .addComponent(P11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(350, 350, 350)
                .addComponent(huecoBTn1))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(340, 340, 340)
                .addComponent(P16, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(P8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(P7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(P17, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(510, 510, 510)
                .addComponent(P1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addComponent(P6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(huecoBTn))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(450, 450, 450)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(420, 420, 420)
                .addComponent(P3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addComponent(P9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(540, 540, 540)
                .addComponent(P2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(290, 290, 290)
                .addComponent(P5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(P10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(390, 390, 390)
                .addComponent(dadoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(230, 230, 230)
                .addComponent(huecoBTn2))
            .addComponent(fondo, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                // Categoria , Pregunta , "a", b, c ,d, res, nombreDeLaImagen, seHizo=trueoFalse
                //EJEMPLO
                //{"Ingles","¿what is an apple?","naranja","manzana","uva","pera","manzana","IMGmonstruo1"},
                {"Camiseta XS", "20", "Camiseta", "Conan Gray", "30000"},
                {"Camiseta S", "20", "Camiseta", "Conan Gray", "30000"},

            };

            //Agregar datos de la matriz al registro
            for (String[] fila : preguntas) {
                String categoria = fila[0];
                String pregunta = fila[1];
                String a = fila[2];
                String b = fila[3];
                String c = fila[4];
                String d= fila[5];
                String res=fila[6];
                String img=fila[7];

                // Agregar los datos al archivo
                registro.println(categoria + ";" + pregunta+ ";" + a + ";" + b+ ";" + c+";"+d+";"+img);

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
               // new Tablero(null).setVisible(true);
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
