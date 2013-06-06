package dam.prog;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Window.Type;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Clase de la ventana "pantallas".
 * @author RMR
 *
 */
public class pantallas extends JFrame {

	private static int idioma, reproduccion;
	private consultaBD consult = new consultaBD();
	private static ArrayList <ImageIcon> img = new ArrayList<ImageIcon>();
	private static ArrayList <String> texto = new ArrayList<String>();
	private static JButton VolverBtn;
	private static pantallas frame;
	private static principal princip;
	private static JButton btn1;
	private static JButton btn2;
	private static JButton btn3;
	private static JButton btn4;
	private static JButton btn5;
	private static JButton btn6;
	private static JButton btn7;
	private static JButton btn8;
	private static JButton btn9;
	private static JButton btn10;
	private static JButton btn11;
	private static JButton btn12;
	private static JButton btn13;
	private static JButton btn14;
	private static JButton btn15;
	private static JButton btn16;
	private static JButton btn17;
	private static JButton btn18;
	private static JButton btn19;
	private static JButton btn20;
	private static JButton btn21;
	private static JLabel labelFrase;;
	private static JLabel label1;
	private static JLabel label2;
	private static JLabel label3;
	private static JLabel label4;
	private static JLabel label5;
	private static JLabel label6;
	private static JLabel label7;
	private static JLabel label8;
	private static JLabel label9;
	private static JLabel label10;
	private static JLabel label11;
	private static JLabel label12;
	private static JLabel label13;
	private static JLabel label14;
	private static JLabel label15;
	private static JLabel label16;
	private static JLabel label17;
	private static JLabel label18;
	private static JLabel label19;
	private static JLabel label20;
	private static JLabel label21;
	private static String frase;
	private static String nombreClase;
	private static int numPictos;

	private JPanel contentPane;

	/**
	 * Método constructor genérico de la pantalla "pantallas".
	 * @param frasePulsada
	 * @param nomClase
	 * @param prin
	 */
	public pantallas(String frasePulsada, String nomClase, principal prin)
	{
		frase = frasePulsada;
		princip = prin;
		nombreClase = nomClase;
		leeConfig();
		numPictos = consult.numPictosCat(nombreClase, idioma);
		img = consult.consultaPictoPantallas(nombreClase, idioma);
		texto = consult.consultaTextoPantallas(nombreClase, idioma);
		/*
		 for(int i = 0; i<img.size();i++)
		
		{
			System.out.println();
			System.out.println("numero de pictos: "+numPictos);
			System.out.println("Cantidad img: "+img.size());
			System.out.println("Cantidad texto: "+texto.size());
			System.out.println("Orden: "+i);
			System.out.println("clase:"+nombreClase);
			System.out.println("Imagen: "+img.get(i));
			System.out.println("Texto: "+texto.get(i));
			System.out.println("--------------------");
		}
		*/
		 
		frame = new pantallas();
		frame.setVisible(true);

	}
	/**
	 * Método constructor de la pantalla "pantallas" que contruye la pantalla.
	 */
	@SuppressWarnings("static-access")
	public pantallas() {
		ImageIcon imagen;
		setResizable(false);
		setTitle("PICTO DROID");
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 200, 830, 532);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		int n = 0;

		labelFrase = new JLabel(frase);
		labelFrase.setHorizontalAlignment(SwingConstants.CENTER);
		labelFrase.setBounds(28, 11, 770, 18);
		contentPane.add(labelFrase);

		VolverBtn = new JButton("VOLVER");
		VolverBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				princip.setVisible(true);
				frame.dispose();
			}
		});
		VolverBtn.setBounds(358, 474, 110, 23);
		contentPane.add(VolverBtn);

		btn1 = new JButton("");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				labelFrase.setText(labelFrase.getText()+" "+label1.getText());
			}
		});
		imagen = img.get(n);
		imagen.setImage(img.get(n).getImage().getScaledInstance(110, 110, img.get(n).getImage().SCALE_DEFAULT));
		btn1.setIcon(imagen);
		btn1.setBounds(28, 40, 110, 110);
		contentPane.add(btn1);

		label1 = new JLabel(texto.get(n));
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setBounds(29, 157, 109, 14);
		contentPane.add(label1);

		JButton btnReproducir = new JButton("");
		btnReproducir.setIcon(new ImageIcon(getClass().getResource(".\\imagenes\\Reproducir.png")));
		btnReproducir.setSelectedIcon(null);
		btnReproducir.setBounds(10, 452, 45, 45);
		contentPane.add(btnReproducir);
		n++;

		if (n < numPictos){
			btn2 = new JButton("");
			btn2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					labelFrase.setText(labelFrase.getText()+" "+label2.getText());
				}
			});
			imagen = img.get(n);
			imagen.setImage(img.get(n).getImage().getScaledInstance(110, 110, img.get(n).getImage().SCALE_DEFAULT));
			btn2.setIcon(imagen);
			btn2.setBounds(138, 40, 110, 110);
			contentPane.add(btn2);

			label2 = new JLabel(texto.get(n));
			label2.setHorizontalAlignment(SwingConstants.CENTER);
			label2.setBounds(137, 156, 112, 14);
			contentPane.add(label2);
			n++;
		}

		if (n < numPictos){
			btn3 = new JButton("");
			btn3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					labelFrase.setText(labelFrase.getText()+" "+label3.getText());
				}
			});
			imagen = img.get(n);
			imagen.setImage(img.get(n).getImage().getScaledInstance(110, 110, img.get(n).getImage().SCALE_DEFAULT));
			btn3.setIcon(imagen);
			btn3.setBounds(248, 40, 110, 110);
			contentPane.add(btn3);

			label3 = new JLabel(texto.get(n));
			label3.setHorizontalAlignment(SwingConstants.CENTER);
			label3.setBounds(245, 156, 110, 14);
			contentPane.add(label3);
			n++;
		}

		if (n < numPictos){
			btn4 = new JButton("");
			btn4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					labelFrase.setText(labelFrase.getText()+" "+label4.getText());
				}
			});
			imagen = img.get(n);
			imagen.setImage(img.get(n).getImage().getScaledInstance(110, 110, img.get(n).getImage().SCALE_DEFAULT));
			btn4.setIcon(imagen);
			btn4.setBounds(358, 40, 110, 110);
			contentPane.add(btn4);

			label4 = new JLabel(texto.get(n));
			label4.setHorizontalAlignment(SwingConstants.CENTER);
			label4.setBounds(358, 156, 110, 14);
			contentPane.add(label4);
			n++;
		}

		if (n < numPictos){
			btn5 = new JButton("");
			btn5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					labelFrase.setText(labelFrase.getText()+" "+label5.getText());
				}
			});
			imagen = img.get(n);
			imagen.setImage(img.get(n).getImage().getScaledInstance(110, 110, img.get(n).getImage().SCALE_DEFAULT));
			btn5.setIcon(imagen);
			btn5.setBounds(468, 40, 110, 110);
			contentPane.add(btn5);

			label5 = new JLabel(texto.get(n));
			label5.setHorizontalAlignment(SwingConstants.CENTER);
			label5.setBounds(468, 157, 110, 14);
			contentPane.add(label5);
			n++;
		}

		if (n < numPictos){
			btn6 = new JButton("");
			btn6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					labelFrase.setText(labelFrase.getText()+" "+label6.getText());
				}
			});
			imagen = img.get(n);
			imagen.setImage(img.get(n).getImage().getScaledInstance(110, 110, img.get(n).getImage().SCALE_DEFAULT));
			btn6.setIcon(imagen);
			btn6.setBounds(578, 40, 110, 110);
			contentPane.add(btn6);

			label6 = new JLabel(texto.get(n));
			label6.setHorizontalAlignment(SwingConstants.CENTER);
			label6.setBounds(578, 157, 110, 14);
			contentPane.add(label6);
			n++;
		}

		if (n < numPictos){
			btn7 = new JButton("");
			btn7.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					labelFrase.setText(labelFrase.getText()+" "+label7.getText());
				}
			});
			imagen = img.get(n);
			imagen.setImage(img.get(n).getImage().getScaledInstance(110, 110, img.get(n).getImage().SCALE_DEFAULT));
			btn7.setIcon(imagen);
			btn7.setBounds(688, 40, 110, 110);
			contentPane.add(btn7);

			label7 = new JLabel(texto.get(n));
			label7.setHorizontalAlignment(SwingConstants.CENTER);
			label7.setBounds(688, 157, 110, 14);
			contentPane.add(label7);
			n++;
		}

		if (n < numPictos){
			btn8 = new JButton("");
			btn8.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					labelFrase.setText(labelFrase.getText()+" "+label8.getText());
				}
			});
			imagen = img.get(n);
			imagen.setImage(img.get(n).getImage().getScaledInstance(110, 110, img.get(n).getImage().SCALE_DEFAULT));
			btn8.setIcon(imagen);
			btn8.setBounds(28, 181, 110, 110);
			contentPane.add(btn8);

			label8 = new JLabel(texto.get(n));
			label8.setHorizontalAlignment(SwingConstants.CENTER);
			label8.setBounds(28, 302, 110, 14);
			contentPane.add(label8);
			n++;
		}

		if (n < numPictos){
			btn9 = new JButton("");
			btn9.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					labelFrase.setText(labelFrase.getText()+" "+label9.getText());
				}
			});
			imagen = img.get(n);
			imagen.setImage(img.get(n).getImage().getScaledInstance(110, 110, img.get(n).getImage().SCALE_DEFAULT));
			btn9.setIcon(imagen);
			btn9.setBounds(138, 181, 110, 110);
			contentPane.add(btn9);

			label9 = new JLabel(texto.get(n));
			label9.setHorizontalAlignment(SwingConstants.CENTER);
			label9.setBounds(137, 302, 110, 14);
			contentPane.add(label9);
			n++;
		}

		if (n < numPictos){
			btn10 = new JButton("");
			btn10.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					labelFrase.setText(labelFrase.getText()+" "+label10.getText());
				}
			});
			imagen = img.get(n);
			imagen.setImage(img.get(n).getImage().getScaledInstance(110, 110, img.get(n).getImage().SCALE_DEFAULT));
			btn10.setIcon(imagen);
			btn10.setBounds(248, 181, 110, 110);
			contentPane.add(btn10);

			label10 = new JLabel(texto.get(n));
			label10.setHorizontalAlignment(SwingConstants.CENTER);
			label10.setBounds(245, 302, 110, 14);
			contentPane.add(label10);
			n++;
		}

		if (n < numPictos){
			btn11 = new JButton("");
			btn11.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					labelFrase.setText(labelFrase.getText()+" "+label11.getText());
				}
			});
			imagen = img.get(n);
			imagen.setImage(img.get(n).getImage().getScaledInstance(110, 110, img.get(n).getImage().SCALE_DEFAULT));
			btn11.setIcon(imagen);
			btn11.setBounds(358, 181, 110, 110);
			contentPane.add(btn11);

			label11 = new JLabel(texto.get(n));
			label11.setHorizontalAlignment(SwingConstants.CENTER);
			label11.setBounds(354, 302, 110, 14);
			contentPane.add(label11);
			n++;
		}

		if (n < numPictos){
			btn12 = new JButton("");
			btn12.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					labelFrase.setText(labelFrase.getText()+" "+label12.getText());
				}
			});
			imagen = img.get(n);
			imagen.setImage(img.get(n).getImage().getScaledInstance(110, 110, img.get(n).getImage().SCALE_DEFAULT));
			btn12.setIcon(imagen);
			btn12.setBounds(468, 181, 110, 110);
			contentPane.add(btn12);

			label12 = new JLabel(texto.get(n));
			label12.setHorizontalAlignment(SwingConstants.CENTER);
			label12.setBounds(464, 302, 110, 14);
			contentPane.add(label12);
			n++;
		}

		if (n < numPictos){
			btn13 = new JButton("");
			btn13.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					labelFrase.setText(labelFrase.getText()+" "+label13.getText());
				}
			});
			imagen = img.get(n);
			imagen.setImage(img.get(n).getImage().getScaledInstance(110, 110, img.get(n).getImage().SCALE_DEFAULT));
			btn13.setIcon(imagen);
			btn13.setBounds(578, 181, 110, 110);
			contentPane.add(btn13);

			label13 = new JLabel(texto.get(n));
			label13.setHorizontalAlignment(SwingConstants.CENTER);
			label13.setBounds(578, 302, 110, 14);
			contentPane.add(label13);
			n++;
		}

		if (n < numPictos){
			btn14 = new JButton("");
			btn14.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					labelFrase.setText(labelFrase.getText()+" "+label14.getText());
				}
			});
			imagen = img.get(n);
			imagen.setImage(img.get(n).getImage().getScaledInstance(110, 110, img.get(n).getImage().SCALE_DEFAULT));
			btn14.setIcon(imagen);
			btn14.setBounds(688, 181, 110, 110);
			contentPane.add(btn14);

			label14 = new JLabel(texto.get(n));
			label14.setHorizontalAlignment(SwingConstants.CENTER);
			label14.setBounds(688, 302, 110, 14);
			contentPane.add(label14);
			n++;
		}

		if (n < numPictos){
			btn15 = new JButton("");
			btn15.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					labelFrase.setText(labelFrase.getText()+" "+label15.getText());
				}
			});
			imagen = img.get(n);
			imagen.setImage(img.get(n).getImage().getScaledInstance(110, 110, img.get(n).getImage().SCALE_DEFAULT));
			btn15.setIcon(imagen);
			btn15.setBounds(28, 327, 110, 110);
			contentPane.add(btn15);

			label15 = new JLabel(texto.get(n));
			label15.setHorizontalAlignment(SwingConstants.CENTER);
			label15.setBounds(28, 443, 110, 14);
			contentPane.add(label15);
			n++;
		}

		if (n < numPictos){
			btn16 = new JButton("");
			btn16.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					labelFrase.setText(labelFrase.getText()+" "+label16.getText());
				}
			});
			imagen = img.get(n);
			imagen.setImage(img.get(n).getImage().getScaledInstance(110, 110, img.get(n).getImage().SCALE_DEFAULT));
			btn16.setIcon(imagen);
			btn16.setBounds(138, 327, 110, 110);
			contentPane.add(btn16);

			label16 = new JLabel(texto.get(n));
			label16.setHorizontalAlignment(SwingConstants.CENTER);
			label16.setBounds(137, 443, 110, 14);
			contentPane.add(label16);
			n++;
		}

		if (n < numPictos){
			btn17 = new JButton("");
			btn17.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					labelFrase.setText(labelFrase.getText()+" "+label17.getText());
				}
			});
			imagen = img.get(n);
			imagen.setImage(img.get(n).getImage().getScaledInstance(110, 110, img.get(n).getImage().SCALE_DEFAULT));
			btn17.setIcon(imagen);
			btn17.setBounds(248, 327, 110, 110);
			contentPane.add(btn17);

			label17 = new JLabel(texto.get(n));
			label17.setHorizontalAlignment(SwingConstants.CENTER);
			label17.setBounds(245, 443, 110, 14);
			contentPane.add(label17);
			n++;
		}

		if (n < numPictos){
			btn18 = new JButton("");
			btn18.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					labelFrase.setText(labelFrase.getText()+" "+label18.getText());
				}
			});
			imagen = img.get(n);
			imagen.setImage(img.get(n).getImage().getScaledInstance(110, 110, img.get(n).getImage().SCALE_DEFAULT));
			btn18.setIcon(imagen);
			btn18.setBounds(358, 327, 110, 110);
			contentPane.add(btn18);

			label18 = new JLabel(texto.get(n));
			label18.setHorizontalAlignment(SwingConstants.CENTER);
			label18.setBounds(354, 443, 110, 14);
			contentPane.add(label18);
			n++;
		}

		if (n < numPictos){
			btn19 = new JButton("");
			btn19.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					labelFrase.setText(labelFrase.getText()+" "+label19.getText());
				}
			});
			imagen = img.get(n);
			imagen.setImage(img.get(n).getImage().getScaledInstance(110, 110, img.get(n).getImage().SCALE_DEFAULT));
			btn19.setIcon(imagen);
			btn19.setBounds(468, 327, 110, 110);
			contentPane.add(btn19);

			label19 = new JLabel(texto.get(n));
			label19.setHorizontalAlignment(SwingConstants.CENTER);
			label19.setBounds(464, 443, 110, 14);
			contentPane.add(label19);
			n++;
		}

		if (n < numPictos){
			btn20 = new JButton("");
			btn20.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					labelFrase.setText(labelFrase.getText()+" "+label20.getText());
				}
			});
			imagen = img.get(n);
			imagen.setImage(img.get(n).getImage().getScaledInstance(110, 110, img.get(n).getImage().SCALE_DEFAULT));
			btn20.setIcon(imagen);
			btn20.setBounds(578, 327, 110, 110);
			contentPane.add(btn20);

			label20 = new JLabel(texto.get(n));
			label20.setHorizontalAlignment(SwingConstants.CENTER);
			label20.setBounds(578, 443, 110, 14);
			contentPane.add(label20);
			n++;
		}

		if (n < numPictos){
			btn21 = new JButton("");
			btn21.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					labelFrase.setText(labelFrase.getText()+" "+label21.getText());
				}
			});
			imagen = img.get(n);
			imagen.setImage(img.get(n).getImage().getScaledInstance(110, 110, img.get(n).getImage().SCALE_DEFAULT));
			btn21.setIcon(imagen);
			btn21.setBounds(688, 327, 110, 110);
			contentPane.add(btn21);

			label21 = new JLabel(texto.get(n));
			label21.setHorizontalAlignment(SwingConstants.CENTER);
			label21.setBounds(688, 443, 110, 14);
			contentPane.add(label21);
		}

		/**
		 * Método que lee la configuración.
		 */	
	}
	public void leeConfig(){
		Properties prop = new Properties();


		try{
			prop.load(new FileInputStream("configuracion.prop"));
			if ((prop.getProperty("Idioma")).compareTo("Español")==0)
			{
				idioma = 0;
			}
			else{
				idioma=1;
			}

			reproduccion = Integer.parseInt(prop.getProperty("ModoReproduccion"));


		}
		catch (IOException gnye)
		{
			gnye.printStackTrace();
		}

	}
}
