package dam.prog;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Clase de la pantalla principal del programa.
 * @author RMR
 *
 */
public class principal extends JFrame {

	private JPanel contentPane;
	private static principal frame;
	private static pantallas pFrame;
	private static inicial iFrame;
	private static boolean acumulativo;
	private consultaBD consult = new consultaBD();
	private static ArrayList <ImageIcon> img = new ArrayList<ImageIcon>();
	private static ArrayList <String> texto = new ArrayList<String>();
	private static JButton boton1;
	private static JButton boton2;
	private static JButton boton3;
	private static JButton boton4;
	private static JButton boton5;
	private static JButton boton6;
	private static int idioma, reproduccion;
	private static JLabel labelFrase;
	private static JLabel label1; 
	private static JLabel label2;
	private static JLabel label3;
	private static JLabel label4;
	private static JLabel label5;
	private static JLabel label6;


	/**
	 * Método contructor de la ventana principal.
	 * @param ini
	 */
	public principal(inicial ini)
	{
		iFrame = ini;
		frame = new principal();
		frame.setVisible(true);
		//System.out.println(""+idioma);
		
	}

	/**
	 * Método constructor de la ventana principal.
	 */
	@SuppressWarnings("static-access")
	public principal() {
		leeConfig();
	
		img = consult.consultaPicto(1, reproduccion);
		
		if (idioma==0){
			
		texto = consult.consultaTextoEsp(1, reproduccion);
		}else{
		texto = consult.consultaTextoEng(1, reproduccion);
		}
		ImageIcon imagen;
		
		setResizable(false);
		setTitle("PICTO DROID");
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 200, 460, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		int n = 0;
		
		boton1 = new JButton("");
		boton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pFrame = new pantallas(consult.consultaTextoCategoria(label1.getText(), idioma), label1.getText(), frame);
				frame.setVisible(false);
			}
		});
		imagen = img.get(n);
		imagen.setImage(img.get(n).getImage().getScaledInstance(110, 110, img.get(n).getImage().SCALE_DEFAULT));
		boton1.setIcon(imagen);
		boton1.setBounds(28, 40, 110, 110);
		contentPane.add(boton1);
		
		label1 = new JLabel(texto.get(n));
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setBounds(28, 158, 110, 14);
		contentPane.add(label1);
		n++;
		
		boton2 = new JButton("");
		boton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pFrame = new pantallas(consult.consultaTextoCategoria(label2.getText(), idioma), label2.getText(), frame);
				labelFrase.setText(consult.consultaTextoCategoria(label2.getText(), idioma));
			}
		});
		imagen = img.get(n);
		imagen.setImage(img.get(n).getImage().getScaledInstance(110, 110, img.get(n).getImage().SCALE_DEFAULT));
		boton2.setIcon(img.get(n));
		boton2.setBounds(168, 40, 110, 110);
		contentPane.add(boton2);
		
		
		label2 = new JLabel(texto.get(n));
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		label2.setBounds(168, 158, 111, 14);
		contentPane.add(label2);
		n++;
		
		boton3 = new JButton("");
		boton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pFrame = new pantallas(consult.consultaTextoCategoria(label3.getText(), idioma), label3.getText(), frame);
				labelFrase.setText(consult.consultaTextoCategoria(label3.getText(), idioma));
			}
		});
		imagen = img.get(n);
		imagen.setImage(img.get(n).getImage().getScaledInstance(110, 110, img.get(n).getImage().SCALE_DEFAULT));
		boton3.setIcon(img.get(n));
		boton3.setBounds(308, 40, 110, 110);
		contentPane.add(boton3);
	
		
		label3 = new JLabel(texto.get(n));
		label3.setHorizontalAlignment(SwingConstants.CENTER);
		label3.setBounds(308, 158, 110, 14);
		contentPane.add(label3);
		n++;
		
		boton4 = new JButton("");
		boton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pFrame = new pantallas(consult.consultaTextoCategoria(label4.getText(), idioma), label4.getText(), frame);
				labelFrase.setText(consult.consultaTextoCategoria(label4.getText(), idioma));
			}
		});
		imagen = img.get(n);
		imagen.setImage(img.get(n).getImage().getScaledInstance(110, 110, img.get(n).getImage().SCALE_DEFAULT));
		boton4.setIcon(img.get(n));
		boton4.setBounds(28, 181, 110, 110);
		contentPane.add(boton4);
	
		
		label4 = new JLabel(texto.get(n));
		label4.setHorizontalAlignment(SwingConstants.CENTER);
		label4.setBounds(28, 302, 110, 14);
		contentPane.add(label4);
		n++;
		
		boton5 = new JButton("");
		boton5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pFrame = new pantallas(consult.consultaTextoCategoria(label5.getText(), idioma), label5.getText(), frame);
				labelFrase.setText(consult.consultaTextoCategoria(label5.getText(), idioma));
			}
		});
		imagen = img.get(n);
		imagen.setImage(img.get(n).getImage().getScaledInstance(110, 110, img.get(n).getImage().SCALE_DEFAULT));
		boton5.setIcon(img.get(n));
		boton5.setBounds(168, 181, 110, 110);
		contentPane.add(boton5);
	
		
		label5 = new JLabel(texto.get(n));
		label5.setHorizontalAlignment(SwingConstants.CENTER);
		label5.setBounds(168, 302, 111, 14);
		contentPane.add(label5);
		n++;
		
		boton6 = new JButton("");
		boton6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//pFrame = new pantallas(consult.consultaTextoCategoria(label6.getText(), idioma), label6.getText(), frame);
				//labelFrase.setText(consult.consultaTextoCategoria(label6.getText(), idioma));
				labelFrase.setText("Necesito ir al baño");
			}
		});
		imagen = img.get(n);
		imagen.setImage(img.get(n).getImage().getScaledInstance(110, 110, img.get(n).getImage().SCALE_DEFAULT));
		boton6.setIcon(img.get(n));
		boton6.setBounds(308, 181, 110, 110);
		contentPane.add(boton6);
		
		label6 = new JLabel(texto.get(n));
		label6.setHorizontalAlignment(SwingConstants.CENTER);
		label6.setBounds(308, 302, 110, 14);
		contentPane.add(label6);
		
		
		labelFrase = new JLabel("");
		labelFrase.setHorizontalAlignment(SwingConstants.CENTER);
		labelFrase.setBounds(28, 15, 390, 14);
		contentPane.add(labelFrase);

		
	}
	
	/**
	 * Método para leer el archivo de configuración.
	 */
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

