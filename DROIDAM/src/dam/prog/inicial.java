package dam.prog;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Window.Type;
import java.awt.Color;
import java.awt.SystemColor;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Clase de la ventana de inicio de la aplicación.
 * @author RMR
 *
 */
public class inicial extends JFrame {
	private static inicial frame = new inicial();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {				
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Método que construye la pantalla inicial.
	 */
	public inicial() {

		getContentPane().setForeground(new Color(255, 255, 255));
		getContentPane().setBackground(new Color(152, 251, 152));
		setResizable(false);
		setType(Type.UTILITY);
		setTitle("PICTO DROID");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 200, 460, 400);

		JButton configuracionBtn = new JButton("CONFIGURACI\u00D3N");
		configuracionBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				configuracion config = new configuracion(inicial.this);
				setVisible(false);

			}
		});
		configuracionBtn.setBounds(101, 340, 129, 23);

		JButton acercaDeBtn = new JButton("ACERCA DE");
		acercaDeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acercaDe acerca = new acercaDe(inicial.this);
				setVisible(false);
			}
		});
		acercaDeBtn.setBounds(240, 340, 108, 23);

		JLabel lblNewLabel = new JLabel("PULSA LA IMAGEN PARA INICIAR LA APLICACI\u00D3N");
		lblNewLabel.setBounds(68, 265, 310, 15);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().setLayout(null);

		JButton inicioBtn = new JButton("");
		inicioBtn.setIcon(new ImageIcon(getClass().getResource(".\\imagenes\\logo pictodroid.PNG")));
		inicioBtn.setBounds(126, 57, 195, 197);
		inicioBtn.setSelectedIcon(null);
		inicioBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				principal ppal = new principal(frame);
				frame.setVisible(false);

			}
		});
		getContentPane().add(inicioBtn);
		getContentPane().add(configuracionBtn);
		getContentPane().add(acercaDeBtn);
		getContentPane().add(lblNewLabel);
		aplicarConfiguracion();
	}

/**
 * Este método carga la configuración del archivo configuracion.prop y aplica todos los cambios
 * que afectan a la aplicación a nivel global.
 */
	private void aplicarConfiguracion() {
		Properties prop = new Properties();
		String colorFondo="";
		String colorTexto="";

		try{
			prop.load(new FileInputStream("configuracion.prop"));
			colorFondo = prop.getProperty("ColorFondoPaneles");
			colorTexto = prop.getProperty("ColorTexto");
			aplicarFondo(colorFondo);
			aplicarTexto(colorTexto);

		}
		catch (IOException gnye)
		{
			gnye.printStackTrace();
		}


	}
	
/**
 * Método que aplica al texto el color seleccionado en la configuración.
 * @param colorTexto
 */
	public static void aplicarTexto(String colorTexto) {
		if (colorTexto.equals("Amarillo"))
		{

			UIManager.put("Label.foreground", Color.YELLOW);
		}
		if (colorTexto.equals("Negro"))
		{

			UIManager.put("Label.foreground", Color.BLACK);

		}
		if (colorTexto.equals("Azul"))
		{

			UIManager.put("Label.foreground", Color.BLUE);

		}
		if (colorTexto.equals("Naranja"))
		{

			UIManager.put("Label.foreground", Color.ORANGE);

		}
		if (colorTexto.equals("Rosa"))
		{

			UIManager.put("Label.foreground", Color.PINK);

		}
		if (colorTexto.equals("Verde"))
		{

			UIManager.put("Label.foreground", Color.GREEN);

		}
		if (colorTexto.equals("Blanco"))
		{

			UIManager.put("Label.foreground", Color.WHITE);

		}
		if (colorTexto.equals("Rojo"))
		{

			UIManager.put("Label.foreground", Color.RED);

		}		
	}

	/**
	 * Método que aplica al fondo de las pantallas el color seleccionado en la configuración.
	 * @param colorFondo
	 */
	public static void aplicarFondo(String colorFondo) {
		if (colorFondo.equals("Amarillo"))
		{

			UIManager.put("Panel.background", Color.YELLOW);
		}
		if (colorFondo.equals("Negro"))
		{

			UIManager.put("Panel.background", Color.BLACK);

		}
		if (colorFondo.equals("Azul"))
		{

			UIManager.put("Panel.background", Color.BLUE);

		}
		if (colorFondo.equals("Naranja"))
		{

			UIManager.put("Panel.background", Color.ORANGE);

		}
		if (colorFondo.equals("Rosa"))
		{

			UIManager.put("Panel.background", Color.PINK);

		}
		if (colorFondo.equals("Verde"))
		{

			UIManager.put("Panel.background", Color.GREEN);

		}
		if (colorFondo.equals("Blanco"))
		{

			UIManager.put("Panel.background", Color.WHITE);

		}
		if (colorFondo.equals("Rojo"))
		{

			UIManager.put("Panel.background", Color.RED);

		}

	}
}
