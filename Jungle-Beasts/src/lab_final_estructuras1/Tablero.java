package lab_final_estructuras1;

import java.awt.Color;
import java.awt.Point;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.swing.ImageIcon;

public class Tablero extends javax.swing.JFrame {

    ClassLoader CL = getClass().getClassLoader();
    ImageIcon A = new ImageIcon(CL.getResource("IMG/chic110.png"));//BIN =1
    ImageIcon B = new ImageIcon(CL.getResource("IMG/chica110.png"));//CHICA=2
    ImageIcon C = new ImageIcon(CL.getResource("IMG/chico110.png")); //CHICO=3
    private int user;

    int xmouse, ymouse;

    public Tablero(int Avatar) {
        initComponents();
        setLocationRelativeTo(null); //Establece la ubicacion de la ventana en el centro de la pantalla.
        setBackground(new Color(0, 0, 0, 0)); //Le establece el color del fondo de la ventana a transparente.
        BARRA.setBackground(new Color(0, 0, 0, 0)); // Le establece el color del fondo de la barra tranparente.
        this.user = Avatar;
        FondoAleatorio();
        GenerarCamino();
        dadoLabel.setText("");

        System.out.println("");
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

        for (int i = 0; i < 20; i++) {
            int a = i + 1;
            Casillas.add_alFinal("P" + a);
        }
        Casillas.imprimir();

        Point J = USER.getLocation();
        USER.setLocation(J);
        generarpunto(Ingles);
        generarpunto(Matematicas);
        generarpunto(General);
        generarpunto(Abstracto);
        generarpunto(Ciencias);

//        Categ.agregarAlFinal(Ingles);
//        Categ.agregarAlFinal(Matematicas);
//        Categ.agregarAlFinal(General);
//        Categ.agregarAlFinal(Abstracto);
//        Categ.agregarAlFinal(Ciencias);
        
       // Categ.mostrarSolounaLista(1);

    }

    //EStas listas alamecenaran las categorias 
    ListaEnlazadaDoble Camino = new ListaEnlazadaDoble();
    ListaEnlazadaDoble Casillas = new ListaEnlazadaDoble();

    //Que guarden los numero de pregunta de fora aleatoria
    ListaEnlazada Ingles = new ListaEnlazada(); //0
    ListaEnlazada Matematicas = new ListaEnlazada();//1
    ListaEnlazada General = new ListaEnlazada();//2
    ListaEnlazada Abstracto = new ListaEnlazada();//3
    ListaEnlazada Ciencias = new ListaEnlazada();//3

   // ListaEnlazadaMulti Categ = new ListaEnlazadaMulti();

    int dado;
    Nodo CatgActual;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        blurBackground1 = new org.example.Custom.BlurBackground();
        BARRA = new javax.swing.JPanel();
        BtnEXIT = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
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
        USER = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        blurBackground1.setImage(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/FONDO_VERDE.png"))); // NOI18N
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

        blurBackground1.add(BARRA);
        BARRA.setBounds(0, 0, 1180, 47);

        jPanel1.setBackground(new java.awt.Color(0, 102, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        P1.setText("Pregunta 1");
        jPanel1.add(P1, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 500, 70, 50));

        P2.setText("2");
        jPanel1.add(P2, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 530, 70, 50));

        P3.setText("3");
        jPanel1.add(P3, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 400, 70, 50));

        P4.setText("4");
        jPanel1.add(P4, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 300, 70, 50));

        P5.setText("5");
        jPanel1.add(P5, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 290, 70, 50));

        P6.setText("6");
        jPanel1.add(P6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 180, 70, 50));

        P8.setText("7");
        jPanel1.add(P8, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 100, 70, 50));

        P9.setText("8");
        jPanel1.add(P9, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 40, 70, 50));

        P10.setText("9");
        jPanel1.add(P10, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 170, 70, 50));

        P11.setText("10");
        jPanel1.add(P11, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 110, 70, 50));

        P12.setText("11");
        jPanel1.add(P12, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 220, 70, 50));

        P14.setText("12");
        jPanel1.add(P14, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 440, 70, 50));

        P15.setText("13");
        jPanel1.add(P15, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 520, 70, 50));

        P16.setText("14");
        jPanel1.add(P16, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 530, 70, 50));

        P17.setText("15");
        jPanel1.add(P17, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 460, 70, 50));

        P18.setText("16");
        jPanel1.add(P18, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 330, 70, 50));

        P20.setText("17");
        jPanel1.add(P20, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 70, 50));

        P13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                P13MouseClicked(evt);
            }
        });
        jPanel1.add(P13, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 310, 80, 70));

        P19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                P19MouseClicked(evt);
            }
        });
        jPanel1.add(P19, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 80, 60));

        P7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                P7MouseClicked(evt);
            }
        });
        jPanel1.add(P7, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 50, 70, 70));
        jPanel1.add(USER, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 480, 90, 110));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Jungle beast (5)111.png"))); // NOI18N
        jPanel1.add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -20, 1190, 630));

        blurBackground1.add(jPanel1);
        jPanel1.setBounds(30, 50, 1130, 600);

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dado = ran.nextInt(6) + 1;
        dadoLabel.setText("");
        dadoLabel.setText(Integer.toString(dado));

        mover();

        System.out.println("CatgActual: " + CatgActual.dato);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void BtnEXITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEXITActionPerformed
        System.exit(0);
    }//GEN-LAST:event_BtnEXITActionPerformed

    private void P13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_P13MouseClicked
        Send_ToAhorcado();
    }//GEN-LAST:event_P13MouseClicked

    private void P19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_P19MouseClicked
        Send_ToAhorcado();
    }//GEN-LAST:event_P19MouseClicked

    private void P7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_P7MouseClicked
        Send_ToAhorcado();
    }//GEN-LAST:event_P7MouseClicked
    Random ran = new Random();
    int CasillaActual = 0;

    boolean acerto = true;

    public void mover() {
        if (CatgActual.dato.equalsIgnoreCase("fin")) {
            System.out.println("Gano");
        } else {
            if (CatgActual.dato.equalsIgnoreCase("inicio")) {
                if (!acerto) {
                    if (CatgActual.prev != null && CatgActual.prev.prev != null && CatgActual.prev.prev.dato == null) {
                        CatgActual = Camino.retroceder(1, CatgActual);
                    }
                } else {
                    CatgActual = Camino.avanzar(dado, CatgActual);
                }
            } else {
                if (acerto) {
                    CatgActual = Camino.avanzar(dado, CatgActual);
                } else {
                    CatgActual = Camino.retroceder(2, CatgActual);
                }
            }
        }
    }

    public void FondoAleatorio() {
        int f = ran.nextInt(4);
        switch (f) {
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

    public void Send_ToAhorcado() {
        Ahorcado_1 a = new Ahorcado_1(user);
        a.setVisible(true);
        this.dispose();
    }

    public void GenerarCamino() {

        String[] Categorias = {"Ingles", "Conocimiento General", "Matematicas", "Ciencia", "Razonamiento Abstracto", "Sociales"};
        for (int i = 0; i < 17; i++) {
            int r = ran.nextInt(6); // numero del 0 a 5
            Camino.add_alFinal(Categorias[r]);

        }
        Camino.add_alComienzo("Inicio");
        Camino.add_afterPOS("Ahorcado", 6); //pos 7
        Camino.add_afterPOS("Ahorcado", 12);// pos 13
        Camino.add_afterPOS("Ahorcado", 18); // pos 19
        Camino.add_alFinal("Fin");
        CatgActual = Camino.head;
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

    class ListaEnlazada {

        Nodo head; // El primer nodo de la lista

        public ListaEnlazada() {
            head = null;
        }

        public void agregarAlInicio(String dato) {
            Nodo nuevoNodo = new Nodo(dato);
            nuevoNodo.siguiente = head;
            head = nuevoNodo;
        }

        public void agregarAlFinal(String dato) {
            Nodo nuevoNodo = new Nodo(dato);

            // Si la lista está vacía, el nuevo nodo será la cabeza
            if (head == null) {
                head = nuevoNodo;
            } else {
                Nodo nodoActual = head;
                while (nodoActual.siguiente != null) {
                    nodoActual = nodoActual.siguiente;
                }
                nodoActual.siguiente = nuevoNodo;
            }
        }

        public boolean buscardato(String dato) {
            Nodo nodoActual = head;
            boolean seEncontro = false;

            if (head == null) {
                return false;
            }
            while (nodoActual != null) {

                if (nodoActual.dato.equalsIgnoreCase(dato)) {
                    return true;
                }
                nodoActual = nodoActual.siguiente;
            }
            return false;

        }

        public void insertar(String dato) {
            Nodo nuevoNodo = new Nodo(dato);

            if (head == null) {
                // Si la lista está vacía, el nuevo nodo se convierte en la cabeza
                head = nuevoNodo;
            } else {
                // Si la lista no está vacía, recorremos la lista hasta el último nodo
                // y luego enlazamos el último nodo con el nuevo nodo
                Nodo actual = head;
                while (actual.siguiente != null) {
                    actual = actual.siguiente;
                }
                actual.siguiente = nuevoNodo;
            }
        }

        public void mostrarLista() {
            Nodo nodoActual = head;
            while (nodoActual != null) {
                System.out.print(nodoActual.dato + " -> ");
                nodoActual = nodoActual.siguiente;
            }
            System.out.println("null");
        }

        public int buscarPosicionporDato(String dato) {
            Nodo nodoActual = head;
            int indice = 0;

            while (nodoActual != null) {
                if (nodoActual.dato.equals(dato)) {
                    return indice; // Se encontró el dato en esta posición
                }
                nodoActual = nodoActual.siguiente;
                indice++;
            }

            return -1; // El dato no se encontró en la lista
        }

        public int contarRepeticiones(String elemento) {
            int contador = 0;
            Nodo actual = head;
            while (actual != null) {
                if (actual.dato.equals(elemento)) {
                    contador++;
                }
                actual = actual.siguiente;
            }
            return contador;
        }

        public boolean modificarDatoEnPosicion(int posicion, String nuevoDato) {
            if (posicion < 0) {
                return false; // Posición inválida
            }

            Nodo nodoActual = head;
            int indice = 0;

            while (nodoActual != null) {
                if (indice == posicion) {
                    nodoActual.dato = nuevoDato; // Modifica el dato del nodo en la posición deseada
                    return true; // Nodo encontrado y modificado
                }
                nodoActual = nodoActual.siguiente;
                indice++;
            }

            return false; // La posición está más allá del final de la lista
        }

        public String buscarPorPosicion(int posicion) {
            if (posicion < 0) {
                return null; // Posición inválida
            }

            Nodo nodoActual = head;
            int indice = 0;

            while (nodoActual != null) {
                if (indice == posicion) {
                    return nodoActual.dato; // Encontramos el nodo en la posición deseada
                }
                nodoActual = nodoActual.siguiente;
                indice++;
            }

            return null; // La posición está más allá del final de la lista
        }

        public void eliminarNodo(String valor) {
            Nodo temp = head;
            Nodo previo = null;

            // Si el nodo a eliminar es la cabeza
            if (temp != null && temp.dato.equals(valor)) {
                head = temp.siguiente;
                return;
            }

            // Buscar el nodo a eliminar
            while (temp != null && !temp.dato.equals(valor)) {
                previo = temp;
                temp = temp.siguiente;
            }

            // Si no se encuentra el valor en la lista
            if (temp == null) {
                System.out.println("El valor no se encontró en la lista enlazada.");
                return;
            }

            // Eliminar el nodo encontrado
            previo.siguiente = temp.siguiente;
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

        public Nodo avanzar(int cant, Nodo desde) {

            int i = 0;
            Nodo actual = desde;
            // Avanza "cant" nodos desde la posición "desde"
            while (actual.siguiente != null & actual != null & i < cant) {
                actual = actual.siguiente;
                i++;
            }
            return actual;
        }

//      
        public Nodo retroceder(int c, Nodo desde) {
            int i = 0;
            Nodo actual = desde;
            // Avanza "cant" nodos desde la posición "desde"
            while (actual.prev != null & actual != null & i < c) {
                actual = actual.prev;
                i++;
            }
            return actual;
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
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    // End of variables declaration//GEN-END:variables
}
