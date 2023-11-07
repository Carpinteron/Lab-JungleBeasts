/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package lab_final_estructuras1;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author almacen
 */
public class Ahorcado extends javax.swing.JFrame {

    int xmouse, ymouse;
    public ImageIcon imgs[];
    public JButton btns[];
    public String msgs[];
    public int ran;
    public int err;
    public int err2;
    public String res[];
    
    public Ahorcado() {
        initComponents();
        setLocationRelativeTo(null); //Establece la ubicacion de la ventana en el centro de la pantalla.
        setBackground(new Color(0, 0, 0, 0)); //Le establece el color del fondo de la ventana a transparente.
        BARRA.setBackground(new Color(0, 0, 0, 0)); // Le establece el color del fondo de la barra tranparente.
        
        imgs = new ImageIcon[12];
        btns = new JButton[28];
        msgs = new String[8];

        //imagen del joven que se va a ahorcar por que ella no lo ama xd xd
        imgs[0] = new ImageIcon(getClass().getResource("/IMAGENES/im1.png"));
        imgs[1] = new ImageIcon(getClass().getResource("/IMAGENES/im2.png"));
        imgs[2] = new ImageIcon(getClass().getResource("/IMAGENES/im3.png"));
        imgs[3] = new ImageIcon(getClass().getResource("/IMAGENES/im4.png"));
        imgs[4] = new ImageIcon(getClass().getResource("/IMAGENES/im5.png"));
        imgs[5] = new ImageIcon(getClass().getResource("/IMAGENES/im6.png"));

        imgs[6] = new ImageIcon(getClass().getResource("/IMAGENES/fallo0.png"));
        imgs[7] = new ImageIcon(getClass().getResource("/IMAGENES/fallo1.png"));
        imgs[8] = new ImageIcon(getClass().getResource("/IMAGENES/fallo2.png"));
        imgs[9] = new ImageIcon(getClass().getResource("/IMAGENES/fallo3.png"));
        imgs[10] = new ImageIcon(getClass().getResource("/IMAGENES/fallo4.png"));
        imgs[11] = new ImageIcon(getClass().getResource("/IMAGENES/fallo5.png"));
        //botones para las letras
        btns[1] = button_1;
        btns[2] = button_2;
        btns[3] = button_3;
        btns[4] = button_4;
        btns[5] = button_5;
        btns[6] = button_6;
        btns[7] = button_7;
        btns[8] = button_8;
        btns[9] = button_9;
        btns[10] = button_10;
        btns[11] = button_11;
        btns[12] = button_12;
        btns[13] = button_13;
        btns[14] = button_14;
        btns[15] = button_16;
        btns[16] = button_17;
        btns[17] = button_18;
        btns[18] = button_19;
        btns[19] = button_20;
        btns[20] = button_21;
        btns[21] = button_22;
        btns[22] = button_23;
        btns[23] = button_24;
        btns[24] = button_25;
        btns[25] = button_26;
        btns[26] = button_27;
        btns[27] = button_15;

        //palabras por advinar, para agregar una nueva palabra sera necesario declararla al inicio
        msgs[0] = "Ahorcado".toUpperCase();
        msgs[1] = "Supercalifragilisticoespialidoso".toUpperCase();
        msgs[2] = "Monstruo".toUpperCase();
        msgs[3] = "Marsupial".toUpperCase();
        msgs[4] = "Computadora".toUpperCase();
        msgs[5] = "Rascacielos".toUpperCase();
        msgs[6] = "Conocimiento ".toUpperCase();
        msgs[7] = "Escapar".toUpperCase();

        //se asigna un evento a cada letra para comprobar que exista en la palabra a adivinar
        for (int i = 1; i < 28; i++) {
            btns[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    checarLetra(e);
                }
            });
        }
        iniciar();
    }
    public void iniciar() {
        //ERRORES EN 0
        err = 0;
        err2 = 6;
        DIBUJO.setIcon(imgs[0]);
        TEX_PALABRA.setText("");
        errores.setIcon(imgs[6]);
        //para activar las letras del tablero
        for (int i = 1; i < 28; i++) {
            btns[i].setEnabled(true);
        }
        //para generar una palabra aleatoriamente 
        ran = (int) 0 + (int) (Math.random() * ((msgs.length - 1) + 1));
        //SEPARA EL MENSAJE POR PALABRAS
        String pal[] = msgs[ran].split(" ");

        res = new String[msgs[ran].length() + 1];
        int j = 0;
        // seran los guiones que van debajo de las letras como una separacion_
        for (String pal1 : pal) {
            for (int i = 0; i < pal1.length(); i++) {
                TEX_PALABRA.setText(TEX_PALABRA.getText() + "_ ");
                res[j++] = "_";
            }
            TEX_PALABRA.setText(TEX_PALABRA.getText() + "\n");
            res[j++] = " ";
        }
    }

    //al presionar una letra, esta se buscara si pertenece a la palabra, de lo contrario la marcara como error 
    public void checarLetra(ActionEvent e) {
        Icon cp = new ImageIcon(getClass().getResource("/IMAGENES/copa.png"));//icono de la copa
        Icon cara = new ImageIcon(getClass().getResource("/IMAGENES/cara.png"));//icono de la copa
        JButton bt = (JButton) e.getSource();
        char c[];
        //busca la letra en la palabra despues de haber sido presionada
        for (int i = 1; i < 28; i++) {
            if (bt == btns[i]) {
                //la tecla es inicializada
                c = Character.toChars(64 + i);
                //busca si la letra esta en la frase
                boolean esta = false;
                for (int j = 0; j < msgs[ran].length(); j++) {
                    if (c[0] == msgs[ran].charAt(j)) {
                        res[j] = c[0] + "";
                        esta = true;
                    }
                }
                //SI LA LETRA ESTA EN EL MENSAJE SE MUESTRA EN EL TEXTPANEL
                if (esta) {
                    TEX_PALABRA.setText("");
                    for (String re : res) {
                        if (" ".equals(re)) {
                            TEX_PALABRA.setText(TEX_PALABRA.getText() + "\n");
                        } else {
                            TEX_PALABRA.setText(TEX_PALABRA.getText() + re + " ");
                        }
                    }
                    //hace una comprobacion de las letras restantes y faltantes, en caso de que ya no haya letras sera ganador :D
                    boolean gano = true;
                    for (String re : res) {
                        if (re.equals("_")) {
                            gano = false;
                            break;
                        }
                    }
                    //al ser correcta se muestra un mensaje y se reinicia el juego

                    if (gano) {
                        JOptionPane.showMessageDialog(this, "Felicitaciones ganaste!!\n Ya puedes seguir disfrutando del juego", "Ahorcado", JOptionPane.INFORMATION_MESSAGE, cp);
                        iniciar();
                        return;
                    }
                    //SI LA LETRA NO ESTA EN EL MENSAGE, SE INCREMENTA EL ERROR Y SE CAMBIA LA IMAGEN
                } else {
                    DIBUJO.setIcon(imgs[++err]);
                    errores.setIcon(imgs[++err2]);
                    //SI SE LLEGA A LOS 5 ERRORES ENTONCES SE PIERDE EL JUEGO Y SE MANDA EL MENSAGE DE:
                    if (err == 5) {
                        JOptionPane.showMessageDialog(this, "HAS PERDIDO\n Perdiste la respuesta era: \n" + msgs[ran], "Ahorcado", JOptionPane.INFORMATION_MESSAGE, cara);
                        iniciar();
                        return;
                    }
                }
                //esta es la linea que desactiva las letras despues de ser usadas :3
                bt.setEnabled(false);
                break;
            }
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        blurBackground1 = new org.example.Custom.BlurBackground();
        BARRA = new javax.swing.JPanel();
        BtnEXIT = new javax.swing.JButton();
        PANEL_DE_FONDO = new javax.swing.JPanel();
        PARTE_DE_ATRAS_PALABRA_Y_ERROR = new javax.swing.JPanel();
        PANEL_PALABRA = new javax.swing.JPanel();
        TEX_PALABRA = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        errores = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        PANEL_DEBAJO_DE_DIBUJO = new javax.swing.JPanel();
        DIBUJO = new javax.swing.JLabel();
        PANEL_TECLADO = new javax.swing.JPanel();
        button_2 = new javax.swing.JButton();
        button_1 = new javax.swing.JButton();
        button_3 = new javax.swing.JButton();
        button_4 = new javax.swing.JButton();
        button_5 = new javax.swing.JButton();
        button_6 = new javax.swing.JButton();
        button_7 = new javax.swing.JButton();
        button_8 = new javax.swing.JButton();
        button_9 = new javax.swing.JButton();
        button_10 = new javax.swing.JButton();
        button_11 = new javax.swing.JButton();
        button_12 = new javax.swing.JButton();
        button_13 = new javax.swing.JButton();
        button_14 = new javax.swing.JButton();
        button_16 = new javax.swing.JButton();
        button_17 = new javax.swing.JButton();
        button_18 = new javax.swing.JButton();
        button_19 = new javax.swing.JButton();
        button_20 = new javax.swing.JButton();
        button_21 = new javax.swing.JButton();
        button_22 = new javax.swing.JButton();
        button_23 = new javax.swing.JButton();
        button_24 = new javax.swing.JButton();
        button_25 = new javax.swing.JButton();
        button_26 = new javax.swing.JButton();
        button_27 = new javax.swing.JButton();
        button_15 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        blurBackground1.add(BARRA);
        BARRA.setBounds(0, 0, 1180, 40);

        PANEL_DE_FONDO.setBackground(new java.awt.Color(51, 102, 0));

        PARTE_DE_ATRAS_PALABRA_Y_ERROR.setBackground(new java.awt.Color(51, 102, 0));

        PANEL_PALABRA.setBackground(new java.awt.Color(51, 102, 0));

        TEX_PALABRA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TEX_PALABRAActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PANEL_PALABRALayout = new javax.swing.GroupLayout(PANEL_PALABRA);
        PANEL_PALABRA.setLayout(PANEL_PALABRALayout);
        PANEL_PALABRALayout.setHorizontalGroup(
            PANEL_PALABRALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANEL_PALABRALayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TEX_PALABRA, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
                .addGap(32, 32, 32))
        );
        PANEL_PALABRALayout.setVerticalGroup(
            PANEL_PALABRALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TEX_PALABRA, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(51, 102, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(errores, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                .addGap(50, 50, 50))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(errores, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addGap(29, 29, 29))
        );

        jLabel2.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Palabra oculta");

        jLabel1.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Errores");

        javax.swing.GroupLayout PARTE_DE_ATRAS_PALABRA_Y_ERRORLayout = new javax.swing.GroupLayout(PARTE_DE_ATRAS_PALABRA_Y_ERROR);
        PARTE_DE_ATRAS_PALABRA_Y_ERROR.setLayout(PARTE_DE_ATRAS_PALABRA_Y_ERRORLayout);
        PARTE_DE_ATRAS_PALABRA_Y_ERRORLayout.setHorizontalGroup(
            PARTE_DE_ATRAS_PALABRA_Y_ERRORLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PARTE_DE_ATRAS_PALABRA_Y_ERRORLayout.createSequentialGroup()
                .addGap(0, 48, Short.MAX_VALUE)
                .addComponent(PANEL_PALABRA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
            .addGroup(PARTE_DE_ATRAS_PALABRA_Y_ERRORLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(PARTE_DE_ATRAS_PALABRA_Y_ERRORLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PARTE_DE_ATRAS_PALABRA_Y_ERRORLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PARTE_DE_ATRAS_PALABRA_Y_ERRORLayout.setVerticalGroup(
            PARTE_DE_ATRAS_PALABRA_Y_ERRORLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PARTE_DE_ATRAS_PALABRA_Y_ERRORLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PANEL_PALABRA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        PANEL_DEBAJO_DE_DIBUJO.setBackground(new java.awt.Color(51, 102, 0));

        javax.swing.GroupLayout PANEL_DEBAJO_DE_DIBUJOLayout = new javax.swing.GroupLayout(PANEL_DEBAJO_DE_DIBUJO);
        PANEL_DEBAJO_DE_DIBUJO.setLayout(PANEL_DEBAJO_DE_DIBUJOLayout);
        PANEL_DEBAJO_DE_DIBUJOLayout.setHorizontalGroup(
            PANEL_DEBAJO_DE_DIBUJOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PANEL_DEBAJO_DE_DIBUJOLayout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(DIBUJO, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        PANEL_DEBAJO_DE_DIBUJOLayout.setVerticalGroup(
            PANEL_DEBAJO_DE_DIBUJOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANEL_DEBAJO_DE_DIBUJOLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DIBUJO, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PANEL_TECLADO.setBackground(new java.awt.Color(51, 102, 0));

        button_2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button_2.setText("B");
        button_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_2ActionPerformed(evt);
            }
        });

        button_1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button_1.setText("A");
        button_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_1ActionPerformed(evt);
            }
        });

        button_3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button_3.setText("C");
        button_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_3ActionPerformed(evt);
            }
        });

        button_4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button_4.setText("D");
        button_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_4ActionPerformed(evt);
            }
        });

        button_5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button_5.setText("E");
        button_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_5ActionPerformed(evt);
            }
        });

        button_6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button_6.setText("F");
        button_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_6ActionPerformed(evt);
            }
        });

        button_7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button_7.setText("G");
        button_7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_7ActionPerformed(evt);
            }
        });

        button_8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button_8.setText("H");
        button_8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_8ActionPerformed(evt);
            }
        });

        button_9.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button_9.setText("I");
        button_9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_9ActionPerformed(evt);
            }
        });

        button_10.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button_10.setText("J");
        button_10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_10ActionPerformed(evt);
            }
        });

        button_11.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button_11.setText("K");
        button_11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_11ActionPerformed(evt);
            }
        });

        button_12.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button_12.setText("L");
        button_12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_12ActionPerformed(evt);
            }
        });

        button_13.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button_13.setText("M");
        button_13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_13ActionPerformed(evt);
            }
        });

        button_14.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button_14.setText("N");
        button_14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_14ActionPerformed(evt);
            }
        });

        button_16.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button_16.setText("O");

        button_17.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button_17.setText("P");
        button_17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_17ActionPerformed(evt);
            }
        });

        button_18.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button_18.setText("Q");
        button_18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_18ActionPerformed(evt);
            }
        });

        button_19.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button_19.setText("R");
        button_19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_19ActionPerformed(evt);
            }
        });

        button_20.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button_20.setText("S");
        button_20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_20ActionPerformed(evt);
            }
        });

        button_21.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button_21.setText("T");
        button_21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_21ActionPerformed(evt);
            }
        });

        button_22.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button_22.setText("U");
        button_22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_22ActionPerformed(evt);
            }
        });

        button_23.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button_23.setText("V");
        button_23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_23ActionPerformed(evt);
            }
        });

        button_24.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button_24.setText("W");
        button_24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_24ActionPerformed(evt);
            }
        });

        button_25.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button_25.setText("X");
        button_25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_25ActionPerformed(evt);
            }
        });

        button_26.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button_26.setText("Y");
        button_26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_26ActionPerformed(evt);
            }
        });

        button_27.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button_27.setText("Z");
        button_27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_27ActionPerformed(evt);
            }
        });

        button_15.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button_15.setText("Ñ");
        button_15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_15ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PANEL_TECLADOLayout = new javax.swing.GroupLayout(PANEL_TECLADO);
        PANEL_TECLADO.setLayout(PANEL_TECLADOLayout);
        PANEL_TECLADOLayout.setHorizontalGroup(
            PANEL_TECLADOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANEL_TECLADOLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PANEL_TECLADOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(button_19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button_25, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button_1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button_13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PANEL_TECLADOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PANEL_TECLADOLayout.createSequentialGroup()
                        .addGroup(PANEL_TECLADOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(button_8, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PANEL_TECLADOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(button_3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PANEL_TECLADOLayout.createSequentialGroup()
                        .addGroup(PANEL_TECLADOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(button_20, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                            .addComponent(button_14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button_26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(PANEL_TECLADOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(PANEL_TECLADOLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(button_21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(PANEL_TECLADOLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PANEL_TECLADOLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(button_27, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(29, 29, 29)
                .addGroup(PANEL_TECLADOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PANEL_TECLADOLayout.createSequentialGroup()
                        .addGroup(PANEL_TECLADOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PANEL_TECLADOLayout.createSequentialGroup()
                                .addComponent(button_10, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_11, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_12, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PANEL_TECLADOLayout.createSequentialGroup()
                                .addComponent(button_4, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_5, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_6, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(PANEL_TECLADOLayout.createSequentialGroup()
                        .addGroup(PANEL_TECLADOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(button_22, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_16, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(PANEL_TECLADOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(button_17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_23, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PANEL_TECLADOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(button_18, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                            .addComponent(button_24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(435, 435, 435))))
        );
        PANEL_TECLADOLayout.setVerticalGroup(
            PANEL_TECLADOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANEL_TECLADOLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PANEL_TECLADOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_1)
                    .addComponent(button_2)
                    .addComponent(button_5)
                    .addComponent(button_4)
                    .addComponent(button_3)
                    .addComponent(button_6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PANEL_TECLADOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_7)
                    .addComponent(button_8)
                    .addComponent(button_11)
                    .addComponent(button_10)
                    .addComponent(button_9)
                    .addComponent(button_12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PANEL_TECLADOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(button_18)
                    .addGroup(PANEL_TECLADOLayout.createSequentialGroup()
                        .addGroup(PANEL_TECLADOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(button_13)
                            .addComponent(button_14)
                            .addComponent(button_16)
                            .addComponent(button_17)
                            .addComponent(button_15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PANEL_TECLADOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(button_20)
                            .addComponent(button_19)
                            .addComponent(button_21)
                            .addComponent(button_22)
                            .addComponent(button_23)
                            .addComponent(button_24))))
                .addGap(12, 12, 12)
                .addGroup(PANEL_TECLADOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_26)
                    .addComponent(button_25)
                    .addComponent(button_27))
                .addGap(11, 11, 11))
        );

        javax.swing.GroupLayout PANEL_DE_FONDOLayout = new javax.swing.GroupLayout(PANEL_DE_FONDO);
        PANEL_DE_FONDO.setLayout(PANEL_DE_FONDOLayout);
        PANEL_DE_FONDOLayout.setHorizontalGroup(
            PANEL_DE_FONDOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANEL_DE_FONDOLayout.createSequentialGroup()
                .addGroup(PANEL_DE_FONDOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PANEL_DE_FONDOLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(PANEL_DEBAJO_DE_DIBUJO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(193, 193, 193)
                        .addComponent(PARTE_DE_ATRAS_PALABRA_Y_ERROR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PANEL_DE_FONDOLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(PANEL_TECLADO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        PANEL_DE_FONDOLayout.setVerticalGroup(
            PANEL_DE_FONDOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANEL_DE_FONDOLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(PANEL_DE_FONDOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PANEL_DE_FONDOLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(PARTE_DE_ATRAS_PALABRA_Y_ERROR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(PANEL_DE_FONDOLayout.createSequentialGroup()
                        .addComponent(PANEL_DEBAJO_DE_DIBUJO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)))
                .addComponent(PANEL_TECLADO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );

        blurBackground1.add(PANEL_DE_FONDO);
        PANEL_DE_FONDO.setBounds(10, 10, 1160, 640);

        getContentPane().add(blurBackground1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1180, 664));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
        System.exit(0);
    }//GEN-LAST:event_BtnEXITActionPerformed

    private void TEX_PALABRAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TEX_PALABRAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TEX_PALABRAActionPerformed

    private void button_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_2ActionPerformed

    }//GEN-LAST:event_button_2ActionPerformed

    private void button_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_1ActionPerformed

    }//GEN-LAST:event_button_1ActionPerformed

    private void button_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_3ActionPerformed

    }//GEN-LAST:event_button_3ActionPerformed

    private void button_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_4ActionPerformed

    }//GEN-LAST:event_button_4ActionPerformed

    private void button_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_5ActionPerformed

    }//GEN-LAST:event_button_5ActionPerformed

    private void button_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_6ActionPerformed

    }//GEN-LAST:event_button_6ActionPerformed

    private void button_7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_7ActionPerformed

    }//GEN-LAST:event_button_7ActionPerformed

    private void button_8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_8ActionPerformed

    }//GEN-LAST:event_button_8ActionPerformed

    private void button_9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_9ActionPerformed

    }//GEN-LAST:event_button_9ActionPerformed

    private void button_10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_10ActionPerformed

    }//GEN-LAST:event_button_10ActionPerformed

    private void button_11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_11ActionPerformed

    }//GEN-LAST:event_button_11ActionPerformed

    private void button_12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_12ActionPerformed

    }//GEN-LAST:event_button_12ActionPerformed

    private void button_13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_13ActionPerformed

    }//GEN-LAST:event_button_13ActionPerformed

    private void button_14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_14ActionPerformed

    }//GEN-LAST:event_button_14ActionPerformed

    private void button_17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_17ActionPerformed

    }//GEN-LAST:event_button_17ActionPerformed

    private void button_18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_18ActionPerformed

    }//GEN-LAST:event_button_18ActionPerformed

    private void button_19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_19ActionPerformed

    }//GEN-LAST:event_button_19ActionPerformed

    private void button_20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_20ActionPerformed

    }//GEN-LAST:event_button_20ActionPerformed

    private void button_21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_21ActionPerformed

    }//GEN-LAST:event_button_21ActionPerformed

    private void button_22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_22ActionPerformed

    }//GEN-LAST:event_button_22ActionPerformed

    private void button_23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_23ActionPerformed

    }//GEN-LAST:event_button_23ActionPerformed

    private void button_24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_24ActionPerformed

    }//GEN-LAST:event_button_24ActionPerformed

    private void button_25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_25ActionPerformed

    }//GEN-LAST:event_button_25ActionPerformed

    private void button_26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_26ActionPerformed

    }//GEN-LAST:event_button_26ActionPerformed

    private void button_27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_27ActionPerformed

    }//GEN-LAST:event_button_27ActionPerformed

    private void button_15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_15ActionPerformed

    }//GEN-LAST:event_button_15ActionPerformed

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
            java.util.logging.Logger.getLogger(Ahorcado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ahorcado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ahorcado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ahorcado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ahorcado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BARRA;
    private javax.swing.JButton BtnEXIT;
    private javax.swing.JLabel DIBUJO;
    private javax.swing.JPanel PANEL_DEBAJO_DE_DIBUJO;
    private javax.swing.JPanel PANEL_DE_FONDO;
    private javax.swing.JPanel PANEL_PALABRA;
    private javax.swing.JPanel PANEL_TECLADO;
    private javax.swing.JPanel PARTE_DE_ATRAS_PALABRA_Y_ERROR;
    private javax.swing.JTextField TEX_PALABRA;
    private org.example.Custom.BlurBackground blurBackground1;
    private javax.swing.JButton button_1;
    private javax.swing.JButton button_10;
    private javax.swing.JButton button_11;
    private javax.swing.JButton button_12;
    private javax.swing.JButton button_13;
    private javax.swing.JButton button_14;
    private javax.swing.JButton button_15;
    private javax.swing.JButton button_16;
    private javax.swing.JButton button_17;
    private javax.swing.JButton button_18;
    private javax.swing.JButton button_19;
    private javax.swing.JButton button_2;
    private javax.swing.JButton button_20;
    private javax.swing.JButton button_21;
    private javax.swing.JButton button_22;
    private javax.swing.JButton button_23;
    private javax.swing.JButton button_24;
    private javax.swing.JButton button_25;
    private javax.swing.JButton button_26;
    private javax.swing.JButton button_27;
    private javax.swing.JButton button_3;
    private javax.swing.JButton button_4;
    private javax.swing.JButton button_5;
    private javax.swing.JButton button_6;
    private javax.swing.JButton button_7;
    private javax.swing.JButton button_8;
    private javax.swing.JButton button_9;
    private javax.swing.JLabel errores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
