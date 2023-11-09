package lab_final_estructuras1;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Tablero extends javax.swing.JFrame {

    ClassLoader CL = getClass().getClassLoader();
    ImageIcon A = new ImageIcon(CL.getResource("IMG/chic110.png"));//BIN =1
    ImageIcon B = new ImageIcon(CL.getResource("IMG/chica110.png"));//CHICA=2
    ImageIcon C = new ImageIcon(CL.getResource("IMG/chico110.png")); //CHICO=3
    private int user;
    private boolean started;
    int xmouse, ymouse;
    //variables para el movimiento del explorador
    private int posicionActual = 0;
    private Timer timer;
    ListaEnlazada_2 lista_casillas = new ListaEnlazada_2();

    public Tablero(int Avatar, boolean started) {
        initComponents();
        setLocationRelativeTo(null); //Establece la ubicacion de la ventana en el centro de la pantalla.
        setBackground(new Color(0, 0, 0, 0)); //Le establece el color del fondo de la ventana a transparente.
        BARRA.setBackground(new Color(0, 0, 0, 0)); // Le establece el color del fondo de la barra tranparente.
        this.user = Avatar;
        this.started = started;
        Scanner sc = new Scanner(System.in);
        if (started == true) {
            IniciarDesdeCero();
            resetearArchivo("Partida");
            switch (user) {
                case 1:
                    USER.setIcon(A);
                    break;
                case 2:
                    USER.setIcon(B);
                    break;
                case 3:
                    USER.setIcon(C);
                    break;

            }
        } else {

            RecuperarPartida();

        }
        dadoLabel.setText("");

        System.out.println("");

        Point J = USER.getLocation();
        USER.setLocation(J);

        //Se insertan los jlabels (de la casilla o posicion del explorador) a la lista enlazada 2
        lista_casillas.insertar(USER);
        lista_casillas.insertar(P1);
        lista_casillas.insertar(P2);
        lista_casillas.insertar(P3);
        lista_casillas.insertar(P4);
        lista_casillas.insertar(P5);
        lista_casillas.insertar(P6);
        lista_casillas.insertar(P7);
        lista_casillas.insertar(P8);
        lista_casillas.insertar(P9);
        lista_casillas.insertar(P10);
        lista_casillas.insertar(P11);
        lista_casillas.insertar(P12);
        lista_casillas.insertar(P13);
        lista_casillas.insertar(P14);
        lista_casillas.insertar(P15);
        lista_casillas.insertar(P16);
        lista_casillas.insertar(P17);
        lista_casillas.insertar(P18);
        lista_casillas.insertar(P19);
        lista_casillas.insertar(P20);

//        Categ.agregarAlFinal(Ingles);
//        Categ.agregarAlFinal(Matematicas);
//        Categ.agregarAlFinal(General);
//        Categ.agregarAlFinal(Abstracto);
//        Categ.agregarAlFinal(Cienciass);
        // Categ.mostrarSolounaLista(1);
    }

    //EStas listas alamecenaran las categorias 
    ListaEnlazadaDoble Camino = new ListaEnlazadaDoble();
    ListaEnlazadaDoble Casillas = new ListaEnlazadaDoble();
    ListaEnlazada PosActuales1 = new ListaEnlazada();
    ListaEnlazada PosActuales2 = new ListaEnlazada();

    //Que guarden los numero de pregunta de fora aleatoria
    ListaEnlazada Ingles = new ListaEnlazada(); //0
    ListaEnlazada Matematicas = new ListaEnlazada();//1
    ListaEnlazada General = new ListaEnlazada();//2
    ListaEnlazada Abstracto = new ListaEnlazada();//3
    ListaEnlazada Ciencias = new ListaEnlazada();//3

    // ListaEnlazadaMulti Categ = new ListaEnlazadaMulti();
    int dado;
    int CatgActual;

    public void IniciarDesdeCero() {
        FondoAleatorio();
        GenerarCamino();
        for (int i = 0; i < 20; i++) {
            int a = i + 1;
            Casillas.add_alFinal("P" + a);
        }
        Casillas.imprimir();

        generarpunto(Ingles);
        generarpunto(Matematicas);
        generarpunto(General);
        generarpunto(Abstracto);
        generarpunto(Ciencias);

    }

    public void GuardarPartida() {
        Scanner sc = new Scanner(System.in);
        GuardarPartidaenARchiv(sc, "Partida", Ingles, "Ingles");
        GuardarPartidaenARchiv(sc, "Partida", Matematicas, "Matematicas");
        GuardarPartidaenARchiv(sc, "Partida", General, "General");
        GuardarPartidaenARchiv(sc, "Partida", Abstracto, "Abstracto");
        GuardarPartidaenARchiv(sc, "Partida", Ciencias, "Ciencias");
        GuardarPartidaenARchiv(sc, "Partida", Camino, "CaminoCategorias;");
        PosActuales1.agregarAlFinal(String.valueOf(CatgActual));
        PosActuales2.agregarAlFinal(String.valueOf(posicionActual));
        GuardarPartidaenARchiv(sc, "Partida", PosActuales1, "Posicion1;"); //string
        GuardarPartidaenARchiv(sc, "Partida", PosActuales2, "Posicion2;");//int
    }

    public void GuardarPartidaenARchiv(Scanner sc, String file_name, ListaEnlazada lista, String nombre) {
        File archivoTemporal = new File(file_name + "_temp.txt");
        try {
            BufferedWriter pw = new BufferedWriter(new FileWriter(file_name, true));

            Nodo nodoActual = lista.head;
            int c = 0;
            String linea = nombre;

            while (nodoActual != null) {

                linea += nodoActual.dato;
                nodoActual = nodoActual.siguiente;

                if (nodoActual != null) {
                    linea += ";"; // Agregar un punto y coma para separar los datos
                }
            }
// Escribe el nuevo registro en el archivo
            pw.write(linea);
            pw.newLine();
            pw.close(); // Cierra el archivo

            pw.close();
        } catch (IOException ex) {
            Logger.getLogger(Tablero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void GuardarPartidaenARchiv(Scanner sc, String file_name, ListaEnlazadaDoble lista, String nombre) {
        File archivoTemporal = new File(file_name + "_temp.txt");
        try {
            BufferedWriter pw = new BufferedWriter(new FileWriter(file_name, true));

            Nodo nodoActual = lista.head;
            int c = 0;
            String linea = nombre;

            while (nodoActual != null) {

                linea += nodoActual.dato;
                nodoActual = nodoActual.siguiente;

                if (nodoActual != null) {
                    linea += ";"; // Agregar un punto y coma para separar los datos
                }
            }
// Escribe el nuevo registro en el archivo
            pw.write(linea);
            pw.newLine();
            pw.close(); // Cierra el archivo

            pw.close();
        } catch (IOException ex) {
            Logger.getLogger(Tablero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void RecuperarPartida() {
        Scanner sc = new Scanner(System.in);
        copiarRegistroALista("Partida", Ingles, "Ingles", sc);
        copiarRegistroALista("Partida", Matematicas, "Matematicas", sc);
        copiarRegistroALista("Partida", General, "General", sc);
        copiarRegistroALista("Partida", Abstracto, "Abstracto", sc);
        copiarRegistroALista("Partida", Ciencias, "Ciencias", sc);
        copiarRegistroALista("Partida", Camino, "CaminoCategorias", sc);
        posicionActual = copiarposiciones("Partida", "Posicion2", sc) + 1;
        System.out.println("o " + posicionActual);
        // copiarposiciones("Partida","Posicion;",sc);
        // CatgActual.dato=cat;

        lista_casillas.insertar(USER);
        lista_casillas.insertar(P1);
        lista_casillas.insertar(P2);
        lista_casillas.insertar(P3);
        lista_casillas.insertar(P4);
        lista_casillas.insertar(P5);
        lista_casillas.insertar(P6);
        lista_casillas.insertar(P7);
        lista_casillas.insertar(P8);
        lista_casillas.insertar(P9);
        lista_casillas.insertar(P10);
        lista_casillas.insertar(P11);
        lista_casillas.insertar(P12);
        lista_casillas.insertar(P13);
        lista_casillas.insertar(P14);
        lista_casillas.insertar(P15);
        lista_casillas.insertar(P16);
        lista_casillas.insertar(P17);
        lista_casillas.insertar(P18);
        lista_casillas.insertar(P19);
        lista_casillas.insertar(P20);
        Nodo_2 nodo0 = lista_casillas.obtenerNodoEnPosicion(0);
        nodo0.label.setIcon(null);
        SetEnPos(posicionActual);
    }
    String cat;

    public int copiarposiciones(String file_name, String nameRegistro, Scanner sc) {
        boolean hay = false;
        while (hay == false) {
            try {
                int obj;
                BufferedReader read = new BufferedReader(new FileReader(file_name));
                String line = null; //definición de line
                boolean Encontrado = false;
                while ((line = read.readLine()) != null && Encontrado == false) {
                    String[] campos = line.split(";");
                    String name = campos[0].trim();
                    System.out.println("estos son los campos 0 en pos: " + name);
                    // if (nameRegistro.equalsIgnoreCase(name1)) {
                    if (nameRegistro.equalsIgnoreCase(name.trim())) {
                        Encontrado = true;
                        System.out.println("posicion2: " + campos[1]);
                        //obj= Integer.parseInt(campos[1]);
                        //return obj;
                        //lista.mostrarLista();
                        return Integer.parseInt(campos[1]);
                    }

                }
                if (Encontrado == false) {
                    System.out.println("No se encontro el nombre copiar pos");
                }
                line = null;

                read.close();
                hay = true;
                return -1;
            } catch (IOException ex) {
                System.out.println("No se encontro archivo");
                hay = false;
                //nombre = sc.nextLine(); // Archivo
            }
        }
        return -1;
        //resetearArchivo("Partida");
    }

    public void copiarRegistroALista(String file_name, ListaEnlazada lista, String nameLista, Scanner sc) {
        boolean hay = false;

        while (hay == false) {
            try {
                BufferedReader read = new BufferedReader(new FileReader(file_name));
                String line = null; //definición de line
                boolean Encontrado = false;
                while ((line = read.readLine()) != null && Encontrado == false) {
                    String[] campos = line.split(";");
                    String name = campos[0].trim();
                    System.out.println("estos son los campos[0] enlas: " + name);
                    if (nameLista.equalsIgnoreCase(name.trim())) {
                        Encontrado = true;
                        for (int c = 1; c <= 20; c++) {
                            lista.agregarAlFinal(campos[c]);
                        }

                        System.out.println("Lista encontrada, lista copiada enlazada simple");
                        lista.mostrarLista();
                    }
                }
                if (Encontrado == false) {
                    System.out.println("No se encontro el nombre de la lista enlazada simple");
                }
                line = null;

                read.close();
                hay = true;
            } catch (IOException ex) {
                System.out.println("No se encontro archivo");
                hay = false;
                //nombre = sc.nextLine(); // Archivo
            }
        }
        //resetearArchivo("Partida");
    }

    int indice = 1;

    public void copiarRegistroALista(String file_name, ListaEnlazadaDoble lista, String nameLista, Scanner sc) {
        boolean hay = false;

        while (hay == false) {
            try {
                BufferedReader read = new BufferedReader(new FileReader(file_name));
                String line = null; //definición de line
                boolean Encontrado = false;
                while ((line = read.readLine()) != null && Encontrado == false) {
                    String[] campos = line.split(";");
                    String name = campos[0].trim();
                    System.out.println("estos son los campos[0] enlad: " + name);
                    if (nameLista.equalsIgnoreCase(name.trim())) {
                        Encontrado = true;
                        lista.add_alFinal(campos[indice]);
                        lista.imprimir();
                        indice++;
                        System.out.println("Lista encontrada, lista copiada enlazada doble");

                    }
                }
                if (Encontrado == false) {
                    System.out.println("No se encontro el nombre de la lista enlazada doble");
                }
                line = null;

                read.close();
                hay = true;
            } catch (IOException ex) {
                System.out.println("No se encontro archivo");
                hay = false;
                //nombre = sc.nextLine(); // Archivo
            }
        }
        //resetearArchivo("Partida");
    }

    public void resetearArchivo(String file_name) {
        try {
            // Abre el archivo en modo de escritura (sobrescribir)
            BufferedWriter pw = new BufferedWriter(new FileWriter(file_name));

            // No se agrega ningún contenido, por lo que el archivo se vacía
            pw.close(); // Cierra el archivo

            System.out.println("Archivo reseteado correctamente.");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        blurBackground1 = new org.example.Custom.BlurBackground();
        BARRA = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        BtnEXIT = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        dadoLabel = new javax.swing.JLabel();
        P1 = new javax.swing.JLabel();
        P2 = new javax.swing.JLabel();
        P3 = new javax.swing.JLabel();
        P4 = new javax.swing.JLabel();
        P5 = new javax.swing.JLabel();
        P6 = new javax.swing.JLabel();
        P8 = new javax.swing.JLabel();
        P9 = new javax.swing.JLabel();
        P10 = new javax.swing.JLabel();
        P11 = new javax.swing.JLabel();
        P12 = new javax.swing.JLabel();
        P14 = new javax.swing.JLabel();
        P15 = new javax.swing.JLabel();
        P16 = new javax.swing.JLabel();
        P17 = new javax.swing.JLabel();
        P18 = new javax.swing.JLabel();
        P20 = new javax.swing.JLabel();
        P13 = new javax.swing.JLabel();
        P19 = new javax.swing.JLabel();
        P7 = new javax.swing.JLabel();
        retroceder = new javax.swing.JButton();
        USER = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        blurBackground1.setImage(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/mapa imagen.png"))); // NOI18N
        blurBackground1.setRadius(55);

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

        javax.swing.GroupLayout BARRALayout = new javax.swing.GroupLayout(BARRA);
        BARRA.setLayout(BARRALayout);
        BARRALayout.setHorizontalGroup(
            BARRALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1180, Short.MAX_VALUE)
        );
        BARRALayout.setVerticalGroup(
            BARRALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 47, Short.MAX_VALUE)
        );

        blurBackground1.add(BARRA);
        BARRA.setBounds(0, 0, 1180, 47);

        jPanel1.setBackground(new java.awt.Color(0, 102, 51));
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
        jPanel1.add(BtnEXIT, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 20, 44, -1));

        jButton1.setText("Tirar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 430, 95, 40));

        dadoLabel.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        dadoLabel.setText("9");
        jPanel1.add(dadoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 380, 47, 53));
        jPanel1.add(P1, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 450, 130, 140));
        jPanel1.add(P2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 500, 130, 120));
        jPanel1.add(P3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 360, 130, 140));
        jPanel1.add(P4, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 270, 130, 130));
        jPanel1.add(P5, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 240, 130, 130));
        jPanel1.add(P6, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 130, 130, 130));
        jPanel1.add(P8, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 60, 140, 130));
        jPanel1.add(P9, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 0, 130, 130));
        jPanel1.add(P10, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 120, 140, 130));
        jPanel1.add(P11, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 70, 130, 140));
        jPanel1.add(P12, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 150, 130, 160));
        jPanel1.add(P14, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 400, 140, 140));
        jPanel1.add(P15, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 470, 130, 130));
        jPanel1.add(P16, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 490, 130, 130));
        jPanel1.add(P17, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 420, 130, 140));
        jPanel1.add(P18, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 130, 130));
        jPanel1.add(P20, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 130, 150));

        P13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                P13MouseClicked(evt);
            }
        });
        jPanel1.add(P13, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 290, 90, 110));

        P19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                P19MouseClicked(evt);
            }
        });
        jPanel1.add(P19, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 90, 110));

        P7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                P7MouseClicked(evt);
            }
        });
        jPanel1.add(P7, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 30, 90, 110));

        retroceder.setText("retroceder ");
        retroceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retrocederActionPerformed(evt);
            }
        });
        jPanel1.add(retroceder, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 340, -1, -1));
        jPanel1.add(USER, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 480, 90, 110));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/fondo 2.png"))); // NOI18N
        jPanel1.add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, 630));

        blurBackground1.add(jPanel1);
        jPanel1.setBounds(30, 10, 1130, 630);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(blurBackground1, javax.swing.GroupLayout.PREFERRED_SIZE, 1180, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(blurBackground1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 664, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

//    public void GenerarPreguntas(int categoria, int punto){
//       
//        
//        for(int i=1;i<=categoria;i++){
//            
//            for(int j=1;j<=punto;j++){
//                
//            }
//        }
//        
//    }

    private void BARRAMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BARRAMouseDragged
        int x = evt.getXOnScreen(); //Obttiene la posicion horizontal actual en pantalla.
        int y = evt.getYOnScreen(); //Obtiene la posicion vertical actual en pantalla.
        this.setLocation(x - xmouse, y - ymouse); //Establece la poscion de la ventana en funcion de la posicion original del mouse.
    }//GEN-LAST:event_BARRAMouseDragged

    private void BARRAMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BARRAMousePressed
        xmouse = evt.getX(); // Obtiene la posicion horizontal del punto donde se hizo clic.
        ymouse = evt.getY(); // Obtiene la posicion vertical del punto donde se hizo clic.
    }//GEN-LAST:event_BARRAMousePressed

    private void BtnEXITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEXITActionPerformed

        resetearArchivo("Partida");
        fin f = new fin();
        f.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtnEXITActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dado = ran.nextInt(6) + 1;
        dadoLabel.setText("");
        dadoLabel.setText(Integer.toString(dado));
        acerto = true;
        entre = false;
        entre2 = true;
        mover();//funcion para mover el explorador
        mover_2();

        System.out.println("CatgActual: " + CatgActual);

    }//GEN-LAST:event_jButton1ActionPerformed


    private void P13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_P13MouseClicked
        Send_ToAhorcado();
    }//GEN-LAST:event_P13MouseClicked

    private void P19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_P19MouseClicked
        Send_ToAhorcado();
    }//GEN-LAST:event_P19MouseClicked

    private void P7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_P7MouseClicked
       Send_ToAhorcado();
    }//GEN-LAST:event_P7MouseClicked

    boolean entre = false;
     boolean entre2 = false;
    private void retrocederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retrocederActionPerformed
        //retrocederDosCasillas();
         System.out.println("mi posicion actual antes es: " + posicionActual);
        if (posicionActual == 1) {
            System.out.println("entre soy 1");
                Nodo_2 nodoAnterior = lista_casillas.obtenerNodoEnPosicion(posicionActual);
                Camino.retroceder(1, CatgActual);
                if (nodoAnterior != null) {
                    entre2 = false;
                    mover();
                    nodoAnterior.label.setIcon(null);
                    posicionActual -= 1; // Retroceso
                    // Establecer el ícono en la nueva posición después del retroceso
                    Nodo_2 nodoEnPosicion = lista_casillas.obtenerNodoEnPosicion(posicionActual);
                    if (nodoEnPosicion != null) {
                        switch (user) {
                            case 1:
                                nodoEnPosicion.label.setIcon(A);
                                break;
                            case 2:
                                nodoEnPosicion.label.setIcon(B);
                                break;
                            case 3:
                                nodoEnPosicion.label.setIcon(C);
                                break;
                        }
                    }
                }
            }
            else if (posicionActual != 1) {
            System.out.println("entre soy diferente de 2");
            entre = true;
            entre2 = true;
            acerto = false;
            mover();
            retrocederDosCasillas();
            // Camino.retroceder(2, CatgActual);
        } 

     
    }//GEN-LAST:event_retrocederActionPerformed
    Random ran = new Random();
    int CasillaActual = 0;

    boolean acerto = true;

    public void mover() {
       if (CatgActual == 21) {
            System.out.println("Ganaste");
        } else {
            Nodo actual = Camino.buscarNodo(CatgActual);
            if (CatgActual == 0 && !acerto && entre == false && entre2 == true) {
                if (actual.prev != null && actual.prev.prev != null && actual.prev.prev.dato == null) {
                    System.out.println("Retrocediendo 1 paso");
                    System.out.println(Camino.retroceder(1, CatgActual));
                    CatgActual--;
                }
            } else if (acerto ) {
                System.out.println("Avanzando " + dado + " pasos");
                System.out.println(Camino.avanzar(dado, CatgActual));
                CatgActual += dado;
            }
            if (entre == true && entre2 == true ) {
                System.out.println("Retrocediendo 2 pasos");
                System.out.println(Camino.retroceder(2, CatgActual));
                CatgActual -= 2;
            }
            if (entre2 == false) {
                System.out.println("Retrocediendo 1 paso");
                System.out.println(Camino.retroceder(1, CatgActual));
                CatgActual -= 1;
            }
            System.out.println("Nueva posición: " + CatgActual);
        }
    }

    public void FondoAleatorio() {
        int f = ran.nextInt(4);
        switch (f) {
            case 0:
                fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/fondo 1.png")));
                break;
            case 1:
                fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/fondo 2.png")));
                break;
            case 2:
                fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/fondo 3.png")));
                break;
            case 3:
                fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/rfondo 4.png")));
                break;
        }
    }

    public void Send_ToAhorcado() {

        GuardarPartida();
        Ahorcado_1 a = new Ahorcado_1(user);
        a.setVisible(true);
        this.dispose();
    }

    public void Send_ToPreguntas() {

        GuardarPartida();
        framepreguntas p = new framepreguntas(Camino.buscarNodo1(CatgActual));
        //  framepreguntas p = new framepreguntas(user);
        p.setVisible(true);
        this.dispose();
    }

    public void GenerarCamino() {

         String[] Categorias = {"Ingles", "Conocimiento General", "Matematicas", "Ciencias", "Razonamiento Abstracto", "Sociales"};
        for (int i = 0; i < 17; i++) {
            int r = ran.nextInt(6); // numero del 0 a 5
            Camino.add_alFinal(Categorias[r]);

        }
        Camino.add_alComienzo("Inicio");
        Camino.add_afterPOS("Ahorcado", 6); //pos 7
        Camino.add_afterPOS("Ahorcado", 12);// pos 13
        Camino.add_afterPOS("Ahorcado", 18); // pos 19
        Camino.add_alFinal("Fin");
        CatgActual = 0;
        Camino.imprimir();
    }
//
//    public static void ArchivoInventario(String file_name) {
//        try {
//            FileWriter outFile = new FileWriter(file_name + ".txt", false);
//            PrintWriter registro = new PrintWriter(outFile);
//
//            // respuesta correcta enseguida: avanza 2 casillas
//            //Matriz para crear Archivo Existente 
//            String[][] preguntas = {
//                // Categoria , Pregunta , "a", b, c ,d, res, nombreDeLaImagen, seHizo=trueoFalse
//                //EJEMPLO
//                //{"Ingles","¿what is an apple?","naranja","manzana","uva","pera","manzana","IMGmonstruo1"},
//                {"Camiseta XS", "20", "Camiseta", "Conan Gray", "30000"},
//                {"Camiseta S", "20", "Camiseta", "Conan Gray", "30000"},};
//
//            //Agregar datos de la matriz al registro
//            for (String[] fila : preguntas) {
//                String categoria = fila[0];
//                String pregunta = fila[1];
//                String a = fila[2];
//                String b = fila[3];
//                String c = fila[4];
//                String d = fila[5];
//                String res = fila[6];
//                String img = fila[7];
//
//                // Agregar los datos al archivo
//                registro.println(categoria + ";" + pregunta + ";" + a + ";" + b + ";" + c + ";" + d + ";" + img);
//
//            }
//            registro.close();
//            System.out.println("Datos agregados exitosamente al archivo " + file_name);
//
//        } catch (IOException ex) {
//            System.out.println("Error al agregar datos al archivo");
//            ex.printStackTrace();
//        }
//    }

    public void generarpunto(ListaEnlazada cat) { //Esto genera los numeros para las listas de cada categoria
        int cont = 0;
        String punto;
        cat.agregarAlInicio("");
        do {

            punto = String.valueOf(ran.nextInt(20) + 1);//de 1 a 20
            while (cat.buscardato(punto)) {
                punto = String.valueOf(ran.nextInt(20) + 1);//de 1 a 20
            }

            cont++;
            cat.agregarAlFinal(punto);

        } while (cont < 20);
        cat.mostrarLista();
    }

    public boolean sonListasIguales(ListaEnlazada lista1, ListaEnlazada lista2) {
        Nodo nodo1 = lista1.head;
        Nodo nodo2 = lista2.head;

        // Compara los elementos de ambas listas uno por uno
        while (nodo1 != null && nodo2 != null) {
            if (!nodo1.dato.equals(nodo2.dato)) {
                return false; // Los elementos no son iguales
            }
            nodo1 = nodo1.siguiente;
            nodo2 = nodo2.siguiente;
        }

        // Verifica si ambas listas tienen la misma longitud
        if (nodo1 != null || nodo2 != null) {
            return false; // Las longitudes no son iguales
        }

        return true; // Las listas son iguales

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

//    static class NOdo {
//
//        ListaEnlazada lista;
//        NOdo siguiente;
//
//        public NOdo(ListaEnlazada lista) {
//            this.lista = lista;
//            this.siguiente = null;
//
//        }
//    }
//
//    class ListaEnlazadaMulti {
//
//        NOdo head; // El primer nodo de la lista
//
//        public ListaEnlazadaMulti() {
//            head = null;
//        }
//
//        public void agregarAlInicio(ListaEnlazada dato) {
//            NOdo nuevoNodo = new NOdo(dato);
//            nuevoNodo.siguiente = head;
//            head = nuevoNodo;
//        }
//
//        public void agregarAlFinal(ListaEnlazada dato) {
//            NOdo nuevoNodo = new NOdo(dato);
//
//            // Si la lista está vacía, el nuevo nodo será la cabeza
//            if (head == null) {
//                head = nuevoNodo;
//            } else {
//                NOdo nodoActual = head;
//                while (nodoActual.siguiente != null) {
//                    nodoActual = nodoActual.siguiente;
//                }
//                nodoActual.siguiente = nuevoNodo;
//            }
//        }
//
//        public boolean buscardato(ListaEnlazada dato) {
//            NOdo nodoActual = head;
//            boolean seEncontro = false;
//
//            if (head == null) {
//                return false;
//            }
//            while (nodoActual != null) {
//
//                if (sonListasIguales(nodoActual.lista, dato)) {
//                    return true;
//                }
//                nodoActual = nodoActual.siguiente;
//            }
//            return false;
//
//        }
//
//        public void insertar(ListaEnlazada dato) {
//            NOdo nuevoNodo = new NOdo(dato);
//
//            if (head == null) {
//                // Si la lista está vacía, el nuevo nodo se convierte en la cabeza
//                head = nuevoNodo;
//            } else {
//                // Si la lista no está vacía, recorremos la lista hasta el último nodo
//                // y luego enlazamos el último nodo con el nuevo nodo
//                NOdo actual = head;
//                while (actual.siguiente != null) {
//                    actual = actual.siguiente;
//                }
//                actual.siguiente = nuevoNodo;
//            }
//        }
//
//        public void mostrarLista() {
//            NOdo nodoActual = head;
//            while (nodoActual != null) {
//                ListaEnlazada lista = nodoActual.lista;
//                Nodo nodoLista = lista.head; // Obtén la cabeza de la lista interna
//
//                System.out.print("[ ");
//                while (nodoLista != null) {
//                    System.out.print(nodoLista.dato + " ");
//                    nodoLista = nodoLista.siguiente;
//                }
//                System.out.print("] || ");
//
//                nodoActual = nodoActual.siguiente;
//            }
//            System.out.println("null");
//        }
//
//        public void mostrarSolounaLista(int index) {
//            NOdo nodoActual = head;
//            int currentIndex = 0;
//
//            while (nodoActual != null) {
//                if (currentIndex == index) {
//                    ListaEnlazada lista = nodoActual.lista;
//                    Nodo nodoLista = lista.head; // Obtén la cabeza de la lista interna
//
//                    System.out.print("[ ");
//                    while (nodoLista != null) {
//                        System.out.print(nodoLista.dato + " ");
//                        nodoLista = nodoLista.siguiente;
//                    }
//                    System.out.print("]");
//                    break; // Sal del bucle una vez que se haya mostrado la lista deseada
//                }
//
//                nodoActual = nodoActual.siguiente;
//                currentIndex++;
//            }
//        }
//
//    }
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

        public String avanzar(int cant, int desde) {
            int i = 0;
            Nodo actual = buscarNodo(desde); // Encuentra el nodo correspondiente al número proporcionado
            while (actual != null && i < cant) {
                actual = actual.siguiente;
                i++;
            }
            return actual.dato;
        }

//      
        public String retroceder(int cant, int desde) {
            int i = 0;
            Nodo actual = buscarNodo(desde); // Encuentra el nodo correspondiente al número proporcionado
            while (actual != null && i < cant) {
                actual = actual.prev; // Movimiento hacia atrás (al nodo previo)
                i++;
            }
            return actual.dato;
        }

        public int buscarpos(String dato) {
            Nodo actual = head;
            int i = 0;
            while (actual != null && !actual.dato.equals(dato)) {
                actual = actual.siguiente;
                i++;
            }
            return i;
        }

        public Nodo buscarNodo(int pos) {
            if (pos < 0) {
                throw new IllegalArgumentException("La posición no puede ser negativa.");
            }

            Nodo actual = head;
            int i = 0;
            while (actual != null && i < pos) {
                actual = actual.siguiente;
                i++;
            }

            return actual;
        }
         public String buscarNodo1(int pos) {
            if (pos < 0) {
                throw new IllegalArgumentException("La posición no puede ser negativa.");
            }

            Nodo actual = head;
            int i = 0;
            while (actual != null && i < pos) {
                actual = actual.siguiente;
                i++;
            }

            return actual.dato;
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

// Clase Nodo (para las casillas-explorador)
    static class Nodo_2 {

        JLabel label;
        Nodo_2 siguiente;

        // Constructor de Nodo_2
        public Nodo_2(JLabel label) {
            this.label = label;
            this.siguiente = null;
        }
    }
// Clase ListaEnlazada (para las casillas)

    static class ListaEnlazada_2 {

        Nodo_2 cabeza;

        // Método para insertar un nuevo nodo (JLabel) en la lista enlazada
        public void insertar(JLabel label) {
            Nodo_2 nuevoNodo = new Nodo_2(label);
            if (cabeza == null) {
                cabeza = nuevoNodo;
            } else {
                Nodo_2 temp = cabeza;
                while (temp.siguiente != null) {
                    temp = temp.siguiente;
                }
                temp.siguiente = nuevoNodo;
            }
        }

        // Método para obtener el nodo (JLabel) en una posición específica de la lista enlazada
        public Nodo_2 obtenerNodoEnPosicion(int posicion) {
            if (posicion < 0 || cabeza == null) {
                return null;
            }

            Nodo_2 temp = cabeza;
            int contador = 0;
            while (temp != null && contador < posicion) {
                temp = temp.siguiente;
                contador++;
            }

            return temp;
        }
    }

    private void retrocederDosCasillas() {
        if (timer == null || !timer.isRunning()) {
            timer = new Timer(400, new ActionListener() {
                int movimientos = 0;
                int retroceso = 2;
                int aux = posicionActual + dado;

                @Override
                public void actionPerformed(ActionEvent e) {
                    if (movimientos < retroceso && posicionActual >= 3) {
                        // Eliminar el ícono del JLabel en las casillas anteriores
                        Nodo_2 nodoAnterior = lista_casillas.obtenerNodoEnPosicion(posicionActual);
                        if (nodoAnterior != null) {
                            nodoAnterior.label.setIcon(null);
                        }
                        movimientos++;

                        // Retroceder dos posiciones
                        posicionActual -= 1; // Retroceso
                        if (posicionActual >= retroceso) {
                            // Establecer el ícono en la nueva posición después del retroceso
                            Nodo_2 nodoEnPosicion = lista_casillas.obtenerNodoEnPosicion(posicionActual);
                            if (nodoEnPosicion != null) {
                                switch (user) {
                                    case 1:
                                        nodoEnPosicion.label.setIcon(A);
                                        break;
                                    case 2:
                                        nodoEnPosicion.label.setIcon(B);
                                        break;
                                    case 3:
                                        nodoEnPosicion.label.setIcon(C);
                                        break;
                                }
                            }
                        }
                    } else {
                        if (posicionActual <= 20) {
                            // Verificar si se llega a posiciones específicas (ahorcado) (7, 13, 19)
                            if (posicionActual == 7 || posicionActual == 13 || posicionActual == 19) {
                                Send_ToAhorcado();
                            }
                            if (posicionActual == 2) {
                                Nodo_2 nodoAnterior = lista_casillas.obtenerNodoEnPosicion(posicionActual);
                                if (nodoAnterior != null) {
                                    nodoAnterior.label.setIcon(null);
                                    posicionActual -= 1; // Retroceso
                                    // Establecer el ícono en la nueva posición después del retroceso
                                    Nodo_2 nodoEnPosicion = lista_casillas.obtenerNodoEnPosicion(posicionActual);
                                    if (nodoEnPosicion != null) {
                                        switch (user) {
                                            case 1:
                                                nodoEnPosicion.label.setIcon(A);
                                                break;
                                            case 2:
                                                nodoEnPosicion.label.setIcon(B);
                                                break;
                                            case 3:
                                                nodoEnPosicion.label.setIcon(C);
                                                break;
                                        }
                                    }
                                }
                            }
                        }
                        if (aux > 20) {
                            // El número del dado supera la cantidad de movimientos restantes
                            JOptionPane.showMessageDialog(null, "El número del dado es mayor que las posiciones restantes. ¡Intente de nuevo!");
                        }
                        timer.stop();

                    }
                }
            });
            timer.start();
        }
    }

    public void SetEnPos(int posicionActual) {
        Nodo_2 nodoEnPosicion = lista_casillas.obtenerNodoEnPosicion(posicionActual);
        System.out.println("label q quiero: " + posicionActual);
        if (nodoEnPosicion != null) {
            // Establecer el ícono según el jugador
            switch (user) {
                case 1:
                    nodoEnPosicion.label.setIcon(A);
                    break;
                case 2:
                    nodoEnPosicion.label.setIcon(B);
                    break;
                case 3:
                    nodoEnPosicion.label.setIcon(C);
                    break;
            }
        }
    }
// Método para mover el ícono en la lista de casillas

    private void mover_2() {
        if (timer == null || !timer.isRunning()) {
            timer = new Timer(500, new ActionListener() {
                int movimientos = 0;  // Variable para contar los movimientos
                int aux = posicionActual + dado;

                @Override
                public void actionPerformed(ActionEvent e) {
                    if (movimientos < dado && aux <= 20) {
                        // Remover el ícono del JLabel anterior
                        Nodo_2 nodoAnterior = lista_casillas.obtenerNodoEnPosicion(posicionActual);
                        if (nodoAnterior != null) {
                            nodoAnterior.label.setIcon(null);
                        }

                        // Incrementar la posición
                        posicionActual++;

                        // Establecer el ícono en el JLabel actual
                        Nodo_2 nodoEnPosicion = lista_casillas.obtenerNodoEnPosicion(posicionActual);

                        if (nodoEnPosicion != null) {
                            // Establecer el ícono según el jugador
                            switch (user) {
                                case 1:
                                    nodoEnPosicion.label.setIcon(A);
                                    break;
                                case 2:
                                    nodoEnPosicion.label.setIcon(B);
                                    break;
                                case 3:
                                    nodoEnPosicion.label.setIcon(C);
                                    break;
                            }
                            movimientos++;
                        } else {
                            // Detener el temporizador si se alcanza el final de la lista
                            timer.stop();

                        }
                    } else {
                        if (posicionActual <= 20) {
                            // Verificar si se llega a posiciones específicas (ahorcado) (7, 13, 19)
                            if (posicionActual == 7 || posicionActual == 13 || posicionActual == 19) {
                                Send_ToAhorcado();
                            }

                        }
                        if (aux > 20) {
                            // El número del dado supera la cantidad de movimientos restantes
                            JOptionPane.showMessageDialog(null, "El número del dado es mayor que las posiciones restantes. ¡Intente de nuevo!");
                        }
                        timer.stop();
                        Send_ToPreguntas();
                    }
                }
            });
            timer.start();
        }
    }

//    public class Pregunta {
//
//        private String enunciado;
//        private String respuestaCorrecta;
//        private String[] respuestasIncorrectas;
//        private boolean respondida;
//
//        public Pregunta(String enunciado, String respuestaCorrecta, String[] respuestasIncorrectas) {
//            this.enunciado = enunciado;
//            this.respuestaCorrecta = respuestaCorrecta;
//            this.respuestasIncorrectas = respuestasIncorrectas;
//            this.respondida = false;
//        }
//    }
//
//    public class Categoria {
//
//        private String nombre;
////        private ListaEnlazadaSimple preguntas = new ListaEnlazadaSimple();
//
//        public Categoria(String nombre) {
//            this.nombre = nombre;
//            this.preguntas = preguntas;
//        }
//
//        public void agregarPregunta(Pregunta pregunta) {
//            //preguntas.add(pregunta);
//        }
//
//        // Agrega otros métodos para acceder y gestionar las preguntas de la categoría
//    }
//    public class MultilistaPreguntas {
//
//      
//        private ListaEnlazadaSimple categorias = new ListaEnlazadaSimple();
//
//
//        public MultilistaPreguntas() {
//            categorias = categorias;
//        }
//
//        public void agregarCategoria(Categoria categoria) {
//          //  categorias.add(categoria);
//        }
//
//        // Agrega otros métodos para acceder y gestionar las categorías de preguntas
//    }
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
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //  new Tablero().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BARRA;
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
    private javax.swing.JLabel P18;
    private javax.swing.JLabel P19;
    private javax.swing.JLabel P2;
    private javax.swing.JLabel P20;
    private javax.swing.JLabel P3;
    private javax.swing.JLabel P4;
    private javax.swing.JLabel P5;
    private javax.swing.JLabel P6;
    private javax.swing.JLabel P7;
    private javax.swing.JLabel P8;
    private javax.swing.JLabel P9;
    private javax.swing.JLabel USER;
    private org.example.Custom.BlurBackground blurBackground1;
    private javax.swing.JLabel dadoLabel;
    private javax.swing.JLabel fondo;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton retroceder;
    // End of variables declaration//GEN-END:variables
}
