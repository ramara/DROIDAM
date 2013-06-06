package dam.prog;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 * Clase de la pantalla "configuración".
 * @author RMR
 *
 */
public class configuracion extends JFrame {

	private JPanel contentPane;
	private static JFrame pantallaAnterior;
	private static JComboBox<String> sintetizadorCombo;
	private static JComboBox<String> idiomaCombo;
	private static JComboBox<String> reproduccionCombo;
	private JComboBox<String> colorTextoCombo;
	private JComboBox<String> colorFondoCombo;

	/**
	 * Launch the application.
	 */

	/* public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					configuracion frame = new configuracion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	 */
	public configuracion(JFrame anterior)
	{
		initComponents();
		setVisible(true);
		pantallaAnterior = anterior;
		leeConfig();
	}

	/**
	 * Método que contruye la ventana de configuración.
	 */
	public void initComponents() {
		setType(Type.UTILITY);
		setResizable(false);
		setTitle("PICTO DROID");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 200, 460, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		sintetizadorCombo = new JComboBox<String>();
		sintetizadorCombo.setToolTipText("Activar o desactivar");
		sintetizadorCombo.setMaximumRowCount(2);
		sintetizadorCombo.setBounds(17, 53, 183, 22);
		sintetizadorCombo.setModel(new DefaultComboBoxModel<String>(new String[] {"CON Sintetizador de voz", "SIN Sintetizador de voz"}));
		sintetizadorCombo.setSelectedIndex(0);

		idiomaCombo = new JComboBox<String>();
		idiomaCombo.setToolTipText("Idioma");
		idiomaCombo.setBounds(17, 104, 183, 20);
		idiomaCombo.setModel(new DefaultComboBoxModel<String>(new String[] {"Espa\u00F1ol", "English"}));
		idiomaCombo.setSelectedIndex(0);
		//Como recibir lo seleccionado en el combobox ---> int az = comboBox_1.getSelectedIndex();

		reproduccionCombo = new JComboBox<String>();
		reproduccionCombo.setToolTipText("Modo de reproducci\u00F3n");
		reproduccionCombo.setBounds(17, 156, 183, 20);
		reproduccionCombo.setModel(new DefaultComboBoxModel<String>(new String[] {"Acumulativo", "Puntual"}));
		reproduccionCombo.setSelectedIndex(1);

		JLabel audioIdiomaTexto = new JLabel("Audio e idioma");
		audioIdiomaTexto.setBounds(17, 12, 183, 15);
		audioIdiomaTexto.setFont(new Font("Tahoma", Font.BOLD, 12));
		audioIdiomaTexto.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel actDesactTexto = new JLabel("Activar o desactivar");
		actDesactTexto.setToolTipText("Activar o desactivar");
		actDesactTexto.setBounds(17, 39, 154, 14);
		actDesactTexto.setHorizontalAlignment(SwingConstants.LEFT);

		JLabel lblSeleccioneElIdioma = new JLabel("Idioma");
		lblSeleccioneElIdioma.setBounds(17, 88, 154, 17);
		lblSeleccioneElIdioma.setHorizontalAlignment(SwingConstants.LEFT);

		JLabel lblSeleccioneElModo = new JLabel("Modo de reproducci\u00F3n");
		lblSeleccioneElModo.setBounds(17, 141, 139, 14);
		lblSeleccioneElModo.setHorizontalAlignment(SwingConstants.LEFT);

		JLabel lblColumnasYFilas = new JLabel("Columnas y filas");
		lblColumnasYFilas.setBounds(254, 12, 183, 15);
		lblColumnasYFilas.setHorizontalAlignment(SwingConstants.CENTER);
		lblColumnasYFilas.setFont(new Font("Tahoma", Font.BOLD, 12));

		JLabel lblNmeroDeColumnas = new JLabel("N\u00FAmero de columnas de pictos");
		lblNmeroDeColumnas.setBounds(254, 38, 178, 14);
		lblNmeroDeColumnas.setHorizontalAlignment(SwingConstants.LEFT);

		JComboBox columnasCombo = new JComboBox();
		columnasCombo.setToolTipText("N\u00FAmero de columnas de pictos");
		columnasCombo.setBounds(254, 60, 183, 20);
		columnasCombo.setModel(new DefaultComboBoxModel(new String[] {"2", "3", "4"}));
		columnasCombo.setSelectedIndex(1);

		JLabel lblNmeroDeFilas = new JLabel("N\u00FAmero de filas de pictos");
		lblNmeroDeFilas.setToolTipText("");
		lblNmeroDeFilas.setBounds(254, 100, 171, 14);

		JComboBox filasCombo = new JComboBox();
		filasCombo.setToolTipText("N\u00FAmero de filas de pictos");
		filasCombo.setBounds(254, 120, 183, 20);
		filasCombo.setModel(new DefaultComboBoxModel(new String[] {"2", "3", "4"}));
		filasCombo.setSelectedIndex(0);

		JLabel personalizacinTexto = new JLabel("Personalizaci\u00F3n");
		personalizacinTexto.setBounds(17, 187, 183, 15);
		personalizacinTexto.setFont(new Font("Tahoma", Font.BOLD, 12));
		personalizacinTexto.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblColoresYTamaos = new JLabel("Colores y tama\u00F1os");
		lblColoresYTamaos.setBounds(254, 158, 177, 15);
		lblColoresYTamaos.setHorizontalAlignment(SwingConstants.CENTER);
		lblColoresYTamaos.setFont(new Font("Tahoma", Font.BOLD, 12));

		JLabel mayminTexto = new JLabel("May\u00FAsculas o min\u00FAsculas");
		mayminTexto.setBounds(17, 213, 154, 14);

		JComboBox mayminCombo = new JComboBox();
		mayminCombo.setToolTipText("May\u00FAsculas o Min\u00FAsculas");
		mayminCombo.setBounds(17, 227, 183, 20);
		mayminCombo.setModel(new DefaultComboBoxModel(new String[] {"May\u00FAsculas", "Min\u00FAsculas"}));
		mayminCombo.setSelectedIndex(1);

		JLabel marcoTexto = new JLabel("Picto con o sin marco");
		marcoTexto.setBounds(17, 263, 171, 14);

		JComboBox marcoCombo = new JComboBox();
		marcoCombo.setToolTipText("Picto con o sin marco");
		marcoCombo.setBounds(17, 277, 183, 20);
		marcoCombo.setModel(new DefaultComboBoxModel(new String[] {"CON Marco", "SIN Marco"}));
		marcoCombo.setSelectedIndex(1);

		JLabel pulsacionTexto = new JLabel("Tipo de pulsaci\u00F3n");
		pulsacionTexto.setBounds(17, 317, 158, 14);

		JComboBox pulsacionCombo = new JComboBox();
		pulsacionCombo.setToolTipText("Tipo de pulsaci\u00F3n");
		pulsacionCombo.setBounds(17, 332, 183, 20);
		pulsacionCombo.setModel(new DefaultComboBoxModel(new String[] {"Pulsar", "Pulsar y soltar"}));
		pulsacionCombo.setSelectedIndex(0);

		JLabel colorFondoTexto = new JLabel("Color del fondo");
		colorFondoTexto.setBounds(254, 185, 171, 14);

		colorFondoCombo = new JComboBox();
		colorFondoCombo.setToolTipText("Color del fondo");
		colorFondoCombo.setBounds(254, 200, 183, 20);
		colorFondoCombo.setModel(new DefaultComboBoxModel(new String[] {"Blanco", "Negro", "Amarillo", "Azul", "Naranja", "Rojo", "Rosa", "Verde"}));
		colorFondoCombo.setSelectedIndex(0);

		JLabel colorTextoTexto = new JLabel("Color del texto");
		colorTextoTexto.setBounds(254, 235, 171, 14);

		colorTextoCombo = new JComboBox();
		colorTextoCombo.setToolTipText("Color del texto");
		colorTextoCombo.setBounds(254, 250, 183, 20);
		colorTextoCombo.setModel(new DefaultComboBoxModel(new String[] {"Negro", "Blanco", "Amarillo", "Azul", "Naranja", "Rojo", "Rosa", "Verde"}));
		colorTextoCombo.setSelectedIndex(0);

		JSpinner tamanhoSpinner = new JSpinner();
		tamanhoSpinner.setToolTipText("Tama\u00F1o del texto");
		tamanhoSpinner.setBounds(367, 291, 70, 20);
		tamanhoSpinner.setModel(new SpinnerNumberModel(5, 5, 20, 1));
		// Recibir datos del spinner ---> spinner.getModel().getValue();

		contentPane.setLayout(null);
		contentPane.add(marcoTexto);
		contentPane.add(pulsacionCombo);
		contentPane.add(marcoCombo);
		contentPane.add(pulsacionTexto);
		contentPane.add(tamanhoSpinner);
		contentPane.add(colorTextoCombo);
		contentPane.add(colorTextoTexto);
		contentPane.add(audioIdiomaTexto);
		contentPane.add(lblSeleccioneElModo);
		contentPane.add(idiomaCombo);
		contentPane.add(lblSeleccioneElIdioma);
		contentPane.add(actDesactTexto);
		contentPane.add(sintetizadorCombo);
		contentPane.add(personalizacinTexto);
		contentPane.add(reproduccionCombo);
		contentPane.add(mayminTexto);
		contentPane.add(mayminCombo);
		contentPane.add(colorFondoCombo);
		contentPane.add(lblNmeroDeColumnas);
		contentPane.add(columnasCombo);
		contentPane.add(lblNmeroDeFilas);
		contentPane.add(lblColumnasYFilas);
		contentPane.add(colorFondoTexto);
		contentPane.add(filasCombo);
		contentPane.add(lblColoresYTamaos);

		JLabel tamanhoTexto = new JLabel("Tama\u00F1o del texto");
		tamanhoTexto.setBounds(254, 294, 115, 14);
		contentPane.add(tamanhoTexto);

		JButton aplicarBtn = new JButton("Aplicar");
		aplicarBtn.setToolTipText("Aplicar");
		aplicarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardaConfig();

				try {
					pantallaAnterior.setVisible(true);
					dispose();
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});

		aplicarBtn.setBounds(220, 331, 77, 23);
		contentPane.add(aplicarBtn);

		JButton volverBtn = new JButton("Volver sin guardar");
		volverBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					pantallaAnterior.setVisible(true);
					dispose();
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}

		});
		volverBtn.setToolTipText("Volver sin guardar");
		volverBtn.setBounds(298, 331, 139, 23);
		contentPane.add(volverBtn);
	}

	/**
	 * Método que guarda la configuración.
	 */
	public void guardaConfig(){
		Properties prop = new Properties();
		prop.setProperty("Sintetizador", ""+sintetizadorCombo.getSelectedIndex());
		String colorFondo = (String) colorFondoCombo.getSelectedItem();
		prop.setProperty("ColorFondoPaneles", ""+colorFondo);
		String colorTexto = (String) colorTextoCombo.getSelectedItem();
		prop.setProperty("ColorTexto", ""+colorTexto);
		prop.setProperty("Idioma", ""+idiomaCombo.getSelectedItem());
		prop.setProperty("ModoReproduccion", ""+reproduccionCombo.getSelectedIndex());
		//System.out.println(reproduccionCombo.getSelectedIndex());

		inicial.aplicarFondo(colorFondo);
		inicial.aplicarTexto(colorTexto);


		FileOutputStream fos = null;

		try{
			fos = new FileOutputStream("configuracion.prop");
			prop.store(fos,"Datos de configuración");

		}
		catch (IOException gnye)
		{
			gnye.printStackTrace();
		}
	}

	/**
	 * Método que lee la configuración.
	 */
	public void leeConfig(){
		Properties prop = new Properties();

		int sintetizador;
		String colorFondo="";
		String colorTexto="";
		String idioma;
		int reproduccion;


		try{
			prop.load(new FileInputStream("configuracion.prop"));

			sintetizador = Integer.parseInt(prop.getProperty("Sintetizador"));
			sintetizadorCombo.setSelectedItem(sintetizador);
			colorFondo = prop.getProperty("ColorFondoPaneles");
			colorTexto = prop.getProperty("ColorTexto");
			colorFondoCombo.setSelectedItem(colorFondo);
			colorTextoCombo.setSelectedItem(colorTexto);
			idioma = prop.getProperty("Idioma");
			idiomaCombo.setSelectedItem(idioma);
			reproduccion = Integer.parseInt(prop.getProperty("ModoReproduccion"));
			reproduccionCombo.setSelectedItem(reproduccion);


		}
		catch (IOException gnye)
		{
			gnye.printStackTrace();
		}

	}

}

