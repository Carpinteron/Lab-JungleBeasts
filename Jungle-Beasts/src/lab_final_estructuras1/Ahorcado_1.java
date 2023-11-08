
package lab_final_estructuras1;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Ahorcado_1 extends javax.swing.JFrame {

    int xmouse, ymouse;
    public ImageIcon imgs[];
    public JButton btns[];
    public String msgs[];
    public int ran;
    public int err;
    public int err2;
    public String res[];
    private int user;

    public Ahorcado_1(int Avatar) {
        initComponents();
        setLocationRelativeTo(null); //Establece la ubicacion de la ventana en el centro de la pantalla.
        setBackground(new Color(0, 0, 0, 0)); //Le establece el color del fondo de la ventana a transparente.
        //setUndecorated(true);
        BARRA.setBackground(new Color(0, 0, 0, 0)); // Le establece el color del fondo de la barra tranparente.

        imgs = new ImageIcon[12];
        btns = new JButton[28];
        msgs = new String[8];

        this.user = Avatar;

        //imagen del joven que se va a ahorcar por que ella no lo ama xd xd
        imgs[0] = new ImageIcon(getClass().getResource("/IMAGENES/im1.png"));
        imgs[1] = new ImageIcon(getClass().getResource("/IMAGENES/im2" + String.valueOf(user) + ".png"));
        imgs[2] = new ImageIcon(getClass().getResource("/IMAGENES/im3" + String.valueOf(user) + ".png"));
        imgs[3] = new ImageIcon(getClass().getResource("/IMAGENES/im4" + String.valueOf(user) + ".png"));
        imgs[4] = new ImageIcon(getClass().getResource("/IMAGENES/im5" + String.valueOf(user) + ".png"));
        imgs[5] = new ImageIcon(getClass().getResource("/IMAGENES/im6" + String.valueOf(user) + ".png"));

        imgs[6] = new ImageIcon(getClass().getResource("/IMAGENES/5vidas.png"));
        imgs[7] = new ImageIcon(getClass().getResource("/IMAGENES/4vidas.png"));
        imgs[8] = new ImageIcon(getClass().getResource("/IMAGENES/3vidas.png"));
        imgs[9] = new ImageIcon(getClass().getResource("/IMAGENES/2vidas.png"));
        imgs[10] = new ImageIcon(getClass().getResource("/IMAGENES/1vida.png"));
        imgs[11] = new ImageIcon(getClass().getResource("/IMAGENES/0vidas.png"));
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
        msgs[6] = "Conocimiento".toUpperCase();
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
                        //iniciar();
                        try {
                            // Pausa de 3 segundos (3000 milisegundos)
                            Thread.sleep(3000);
                        } catch (InterruptedException ex) {
                            // Manejo de excepciones si se interrumpe el hilo
                            ex.printStackTrace();
                        }

                        Tablero a = new Tablero(user,false);
                        a.setVisible(true);
                        this.dispose();
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

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        blurBackground1 = new org.example.Custom.BlurBackground();
        BARRA = new javax.swing.JPanel();
        BtnEXIT = new javax.swing.JButton();
        TEX_PALABRA = new javax.swing.JTextField();
        button_1 = new javax.swing.JButton();
        button_2 = new javax.swing.JButton();
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
        button_15 = new javax.swing.JButton();
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
        errores = new javax.swing.JLabel();
        DIBUJO = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        blurBackground1.setImage(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/simple.png"))); // NOI18N
        blurBackground1.setRadius(55);

        BARRA.setBackground(new java.awt.Color(255, 255, 255));
        BARRA.setForeground(new java.awt.Color(255, 255, 255));
        BARRA.setOpaque(false);
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
                .addComponent(BtnEXIT)
                .addGap(0, 5, Short.MAX_VALUE))
        );

        blurBackground1.add(BARRA);
        BARRA.setBounds(0, 0, 1180, 40);

        TEX_PALABRA.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        TEX_PALABRA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TEX_PALABRAActionPerformed(evt);
            }
        });
        blurBackground1.add(TEX_PALABRA);
        TEX_PALABRA.setBounds(440, 110, 700, 60);

        button_1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button_1.setBorderPainted(false);
        button_1.setContentAreaFilled(false);
        button_1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button_1.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/hoja-abc.png"))); // NOI18N
        button_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_1ActionPerformed(evt);
            }
        });
        blurBackground1.add(button_1);
        button_1.setBounds(70, 400, 70, 70);

        button_2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button_2.setBorderPainted(false);
        button_2.setContentAreaFilled(false);
        button_2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button_2.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/hoja-abc.png"))); // NOI18N
        button_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_2ActionPerformed(evt);
            }
        });
        blurBackground1.add(button_2);
        button_2.setBounds(156, 400, 70, 70);

        button_3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button_3.setBorderPainted(false);
        button_3.setContentAreaFilled(false);
        button_3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button_3.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/hoja-abc.png"))); // NOI18N
        button_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_3ActionPerformed(evt);
            }
        });
        blurBackground1.add(button_3);
        button_3.setBounds(240, 400, 66, 70);

        button_4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button_4.setBorderPainted(false);
        button_4.setContentAreaFilled(false);
        button_4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button_4.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/hoja-abc.png"))); // NOI18N
        button_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_4ActionPerformed(evt);
            }
        });
        blurBackground1.add(button_4);
        button_4.setBounds(320, 400, 66, 70);

        button_5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button_5.setBorderPainted(false);
        button_5.setContentAreaFilled(false);
        button_5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button_5.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/hoja-abc.png"))); // NOI18N
        button_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_5ActionPerformed(evt);
            }
        });
        blurBackground1.add(button_5);
        button_5.setBounds(400, 400, 69, 70);

        button_6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button_6.setBorderPainted(false);
        button_6.setContentAreaFilled(false);
        button_6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button_6.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/hoja-abc.png"))); // NOI18N
        button_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_6ActionPerformed(evt);
            }
        });
        blurBackground1.add(button_6);
        button_6.setBounds(490, 400, 66, 70);

        button_7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button_7.setBorderPainted(false);
        button_7.setContentAreaFilled(false);
        button_7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button_7.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/hoja-abc.png"))); // NOI18N
        button_7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_7ActionPerformed(evt);
            }
        });
        blurBackground1.add(button_7);
        button_7.setBounds(570, 400, 60, 70);

        button_8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button_8.setBorderPainted(false);
        button_8.setContentAreaFilled(false);
        button_8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button_8.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/hoja-abc.png"))); // NOI18N
        button_8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_8ActionPerformed(evt);
            }
        });
        blurBackground1.add(button_8);
        button_8.setBounds(650, 400, 66, 60);

        button_9.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button_9.setBorderPainted(false);
        button_9.setContentAreaFilled(false);
        button_9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button_9.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/hoja-abc.png"))); // NOI18N
        button_9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_9ActionPerformed(evt);
            }
        });
        blurBackground1.add(button_9);
        button_9.setBounds(730, 400, 66, 70);

        button_10.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button_10.setBorderPainted(false);
        button_10.setContentAreaFilled(false);
        button_10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button_10.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/hoja-abc.png"))); // NOI18N
        button_10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_10ActionPerformed(evt);
            }
        });
        blurBackground1.add(button_10);
        button_10.setBounds(70, 480, 70, 70);

        button_11.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button_11.setBorderPainted(false);
        button_11.setContentAreaFilled(false);
        button_11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button_11.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/hoja-abc.png"))); // NOI18N
        button_11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_11ActionPerformed(evt);
            }
        });
        blurBackground1.add(button_11);
        button_11.setBounds(150, 480, 80, 70);

        button_12.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button_12.setBorderPainted(false);
        button_12.setContentAreaFilled(false);
        button_12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button_12.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/hoja-abc.png"))); // NOI18N
        button_12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_12ActionPerformed(evt);
            }
        });
        blurBackground1.add(button_12);
        button_12.setBounds(240, 480, 66, 70);

        button_13.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button_13.setBorderPainted(false);
        button_13.setContentAreaFilled(false);
        button_13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button_13.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/hoja-abc.png"))); // NOI18N
        button_13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_13ActionPerformed(evt);
            }
        });
        blurBackground1.add(button_13);
        button_13.setBounds(320, 480, 70, 70);

        button_14.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button_14.setBorderPainted(false);
        button_14.setContentAreaFilled(false);
        button_14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button_14.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/hoja-abc.png"))); // NOI18N
        button_14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_14ActionPerformed(evt);
            }
        });
        blurBackground1.add(button_14);
        button_14.setBounds(400, 480, 66, 70);

        button_15.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button_15.setBorderPainted(false);
        button_15.setContentAreaFilled(false);
        button_15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button_15.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/hoja-abc.png"))); // NOI18N
        button_15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_15ActionPerformed(evt);
            }
        });
        blurBackground1.add(button_15);
        button_15.setBounds(486, 480, 70, 70);

        button_16.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button_16.setBorderPainted(false);
        button_16.setContentAreaFilled(false);
        button_16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button_16.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/hoja-abc.png"))); // NOI18N
        blurBackground1.add(button_16);
        button_16.setBounds(570, 480, 66, 70);

        button_17.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button_17.setBorderPainted(false);
        button_17.setContentAreaFilled(false);
        button_17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button_17.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/hoja-abc.png"))); // NOI18N
        button_17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_17ActionPerformed(evt);
            }
        });
        blurBackground1.add(button_17);
        button_17.setBounds(650, 480, 69, 70);

        button_18.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button_18.setBorderPainted(false);
        button_18.setContentAreaFilled(false);
        button_18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button_18.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/hoja-abc.png"))); // NOI18N
        button_18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_18ActionPerformed(evt);
            }
        });
        blurBackground1.add(button_18);
        button_18.setBounds(730, 480, 66, 70);

        button_19.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button_19.setBorderPainted(false);
        button_19.setContentAreaFilled(false);
        button_19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button_19.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/hoja-abc.png"))); // NOI18N
        button_19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_19ActionPerformed(evt);
            }
        });
        blurBackground1.add(button_19);
        button_19.setBounds(70, 560, 70, 80);

        button_20.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button_20.setBorderPainted(false);
        button_20.setContentAreaFilled(false);
        button_20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button_20.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/hoja-abc.png"))); // NOI18N
        button_20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_20ActionPerformed(evt);
            }
        });
        blurBackground1.add(button_20);
        button_20.setBounds(160, 560, 66, 70);

        button_21.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button_21.setBorderPainted(false);
        button_21.setContentAreaFilled(false);
        button_21.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button_21.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/hoja-abc.png"))); // NOI18N
        button_21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_21ActionPerformed(evt);
            }
        });
        blurBackground1.add(button_21);
        button_21.setBounds(240, 560, 66, 70);

        button_22.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button_22.setBorderPainted(false);
        button_22.setContentAreaFilled(false);
        button_22.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button_22.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/hoja-abc.png"))); // NOI18N
        button_22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_22ActionPerformed(evt);
            }
        });
        blurBackground1.add(button_22);
        button_22.setBounds(320, 560, 70, 70);

        button_23.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button_23.setBorderPainted(false);
        button_23.setContentAreaFilled(false);
        button_23.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button_23.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/hoja-abc.png"))); // NOI18N
        button_23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_23ActionPerformed(evt);
            }
        });
        blurBackground1.add(button_23);
        button_23.setBounds(399, 560, 80, 70);

        button_24.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button_24.setBorderPainted(false);
        button_24.setContentAreaFilled(false);
        button_24.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button_24.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/hoja-abc.png"))); // NOI18N
        button_24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_24ActionPerformed(evt);
            }
        });
        blurBackground1.add(button_24);
        button_24.setBounds(490, 560, 66, 70);

        button_25.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button_25.setBorderPainted(false);
        button_25.setContentAreaFilled(false);
        button_25.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button_25.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/hoja-abc.png"))); // NOI18N
        button_25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_25ActionPerformed(evt);
            }
        });
        blurBackground1.add(button_25);
        button_25.setBounds(570, 560, 60, 70);

        button_26.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button_26.setBorderPainted(false);
        button_26.setContentAreaFilled(false);
        button_26.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button_26.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/hoja-abc.png"))); // NOI18N
        button_26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_26ActionPerformed(evt);
            }
        });
        blurBackground1.add(button_26);
        button_26.setBounds(650, 560, 66, 70);

        button_27.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button_27.setBorderPainted(false);
        button_27.setContentAreaFilled(false);
        button_27.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button_27.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/hoja-abc.png"))); // NOI18N
        button_27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_27ActionPerformed(evt);
            }
        });
        blurBackground1.add(button_27);
        button_27.setBounds(730, 560, 66, 70);
        blurBackground1.add(errores);
        errores.setBounds(440, 240, 270, 110);
        blurBackground1.add(DIBUJO);
        DIBUJO.setBounds(70, 30, 290, 340);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/gifahorcado.gif"))); // NOI18N
        blurBackground1.add(jLabel1);
        jLabel1.setBounds(0, 30, 1180, 610);

        getContentPane().add(blurBackground1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1180, 664));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnEXITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEXITActionPerformed

        resetearArchivo("Partida");
        System.exit(0);
    }//GEN-LAST:event_BtnEXITActionPerformed

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
    private void BARRAMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BARRAMouseDragged
        int x = evt.getXOnScreen(); //Obttiene la posicion horizontal actual en pantalla.
        int y = evt.getYOnScreen(); //Obtiene la posicion vertical actual en pantalla.
        this.setLocation(x - xmouse, y - ymouse); //Establece la poscion de la ventana en funcion de la posicion original del mouse.
    }//GEN-LAST:event_BARRAMouseDragged

    private void BARRAMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BARRAMousePressed
        xmouse = evt.getX(); // Obtiene la posicion horizontal del punto donde se hizo clic.
        ymouse = evt.getY(); // Obtiene la posicion vertical del punto donde se hizo clic.
    }//GEN-LAST:event_BARRAMousePressed

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

    private void TEX_PALABRAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TEX_PALABRAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TEX_PALABRAActionPerformed

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
            java.util.logging.Logger.getLogger(Ahorcado_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ahorcado_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ahorcado_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ahorcado_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BARRA;
    private javax.swing.JButton BtnEXIT;
    private javax.swing.JLabel DIBUJO;
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
    // End of variables declaration//GEN-END:variables
}
