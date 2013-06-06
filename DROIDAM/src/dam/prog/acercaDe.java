package dam.prog;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import java.awt.Scrollbar;
import javax.swing.ImageIcon;
import java.awt.Font;

/**
 * Clase de la pantalla "acerca de"
 * @author RMR
 *
 */
public class acercaDe extends JFrame {

	private JPanel contentPane;
	private static JFrame frame;
	private static JFrame pantallaAnterior;
	

	/**
	 * Launch the application.
	 */
	/* public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					acercaDe frame = new acercaDe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/

	public acercaDe(JFrame anterior){
		frame = new acercaDe();
		frame.setVisible(true);
		pantallaAnterior = anterior;
	}
	/**
	 * Método que construye la ventana  "acerca de".
	 */
	public acercaDe() {
		setResizable(false);
		setType(Type.UTILITY);
		setTitle("ACERCA DE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 533, 572);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton atras = new JButton("ATR\u00C1S");
		atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				pantallaAnterior.setVisible(true);
				frame.dispose();
				}
			catch (Exception e1){
			}
				
				
			}
		});
		atras.setToolTipText("ATR\u00C1S");
		atras.setBounds(224, 514, 89, 23);
		contentPane.add(atras);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(75, 210, -4, 14);
		contentPane.add(textPane);
		
		
		JTextPane txtpnVersionSoftware = new JTextPane();
		txtpnVersionSoftware.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		txtpnVersionSoftware.setEditable(false);
		txtpnVersionSoftware.setText("PictoDroid Lite es un aplicaci\u00F3n que permite a los usuarios comunicarse a trav\u00E9s del uso de pictogramas o pictos (signos que representan esquem\u00E1ticamente un s\u00EDmbolo, objeto real o figura). Esta versi\u00F3n Lite \u00FAnicamente permite expresar acciones muy concretas, sin la posibilidad de crear oraciones complejas.\r\n\r\nEn la actualidad se pueden realizar oraciones iniciadas por:\r\n- vamos a...\r\n- quiero jugar...\r\n- quiero ir al ba\u00F1o...\r\n- quiero beber...\r\n- quiero comer...\r\n- estoy...\r\n\r\nAl completar la selecci\u00F3n de pictos el sistema proceder\u00E1 a la lectura de la frase formada.\r\n\r\nTodos los pictos pueden ser modificados o eliminados y es posible a\u00F1adir tantos como sea necesario.\r\nEl proceso se encuentra explicado en el manual de aplicaci\u00F3n disponible en http://www.accegal.org.\r\nSi tiene alguna duda o dificultad en la configuraci\u00F3n de PictoDroid Lite puede ponerse en contacto con nosotros en el email \"contacto@accegal.org\" y trataremos de ayudarle.\r\n\r\nLa aplicaci\u00F3n utiliza los pictos de ARASAAC (http://arasaac.org), creado por Sergio Palao y \r\ndistribuidos con licencia Creative Commons (BY-NC-SA), aunque es posible configurarla para utilizar otros pictos e incluso im\u00E1genes reales.");
		txtpnVersionSoftware.setBounds(10, 121, 507, 382);
		contentPane.add(txtpnVersionSoftware);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(getClass().getResource(".\\imagenes\\accegal_peque.jpg")));
		lblNewLabel.setBounds(10, 11, 166, 78);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(getClass().getResource(".\\imagenes\\florida_peque.png")));
		lblNewLabel_1.setBounds(186, 11, 166, 78);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(getClass().getResource(".\\imagenes\\Picto_peque.jpg")));
		lblNewLabel_2.setBounds(372, 11, 127, 99);
		contentPane.add(lblNewLabel_2);
		
	}
}
