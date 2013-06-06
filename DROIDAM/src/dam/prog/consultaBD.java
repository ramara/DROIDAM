package dam.prog;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.ImageIcon;
/**
 * Clase de la consulta a la base de datos.
 * @author RMR
 *
 */
public class consultaBD {
	private Connection conexion;
	static String bd="sql28602";
	static String user="sql28602";
	static String password="yT4%vX1!";
	static String server="jdbc:mysql://sql2.freemysqlhosting.net:3306/"+bd;
	static Statement st;
	static ResultSet rdo;

	/**
	 * Método para consultar en la base de datos el texto en español que aparece debajo de los pictogramas.
	 * @param ppal
	 * @param acumul
	 * @return
	 */
	@SuppressWarnings("finally")
	public ArrayList<String> consultaTextoEsp(int ppal, int acumul){
		consultaBD p = new consultaBD();
		p.establecerConexion();
		ArrayList <String> nom_esp = new ArrayList<String>(); 
		String consulta, text_esp;

		consulta = new String("select Texto_esp from Pictograma where Picto_cat_ppal="+ppal+" and Picto_acumul="+acumul+";");

		try{

			st = p.getConexion().createStatement();
			rdo = st.executeQuery(consulta);
			while(rdo.next()){
				text_esp = rdo.getString("Texto_esp"); 
				nom_esp.add(text_esp);
			}
		}catch(SQLException ex){
			ex.printStackTrace();

		}
		finally{
			p.cerrar(rdo);
			p.cerrar(st);
			p.destruir();
			return nom_esp;
		}
	}

	/**
	 * Método para consultar en la base de datos el texto en inglés que aparece debajo de los pictogramas.
	 * @param ppal
	 * @param acumul
	 * @return
	 */
	@SuppressWarnings("finally")
	public ArrayList<String> consultaTextoEng(int ppal, int acumul){
		consultaBD p=new consultaBD();
		p.establecerConexion();
		ArrayList <String> nom_eng = new ArrayList<String>(); 
		String consulta, text_eng;


		consulta = new String("select Texto_eng from Pictograma where Picto_cat_ppal="+ppal+" and Picto_acumul="+acumul+";");

		try{

			st = p.getConexion().createStatement();
			rdo = st.executeQuery(consulta);
			while(rdo.next()){ 
				text_eng = rdo.getString("Texto_eng");
				nom_eng.add(text_eng);
			}
		}catch(SQLException ex){
			ex.printStackTrace();

		}
		finally{
			p.cerrar(rdo);
			p.cerrar(st);
			p.destruir();
			return nom_eng;
		}
	}

	/**
	 * Método para consultar en la base de datos las imágenes (pictogramas) de la base de datos.
	 * @param ppal
	 * @param acumul
	 * @return
	 */
	@SuppressWarnings("finally")
	public ArrayList<ImageIcon> consultaPicto(int ppal, int acumul){
		consultaBD p=new consultaBD();
		p.establecerConexion();
		ImageIcon i; 
		ArrayList <ImageIcon> pict = new ArrayList<ImageIcon>();
		String consulta;
		Blob blb;

		consulta = new String("select Imagen from Pictograma where Picto_cat_ppal="+ppal+" and Picto_acumul="+acumul+";");

		try{

			st = p.getConexion().createStatement();
			rdo = st.executeQuery(consulta);
			while(rdo.next()){
				if ((blb = rdo.getBlob("Imagen")) != null){
					i = new ImageIcon (blb.getBytes(1,(int)blb.length()));
					pict.add(i);
				}
			}
		}catch(SQLException ex){
			ex.printStackTrace();

		}
		finally{
			p.cerrar(rdo);
			p.cerrar(st);
			p.destruir();
			return pict;
		}
	}

	/**
	 * Método para consultar en la base de datos los pictogramas de la pantalla "pantallas".
	 * @param nomCat
	 * @return
	 */
	@SuppressWarnings("finally")
	public ArrayList<ImageIcon> consultaPictoPantallas(String nomCat, int idioma){
		consultaBD p=new consultaBD();
		p.establecerConexion();
		ImageIcon i; 
		ArrayList <ImageIcon> pict = new ArrayList<ImageIcon>();
		Blob blb;
		String consulta;
		if (idioma==0){

		}else{
			
			nomCat = consultaNombreClaseEsp(nomCat);
		}
		consulta = new String("select Imagen from Pictograma where Nom_categoria=\""+nomCat+"\";");


		try{
			st = p.getConexion().createStatement();
			rdo = st.executeQuery(consulta);
			while(rdo.next()){
				if ((blb = rdo.getBlob("Imagen")) != null){
					i = new ImageIcon (blb.getBytes(1,(int)blb.length()));
					pict.add(i);
				}
			}
		}catch(SQLException ex){
			ex.printStackTrace();

		}
		finally{
			p.cerrar(rdo);
			p.cerrar(st);
			p.destruir();
			return pict;
		}
	}

	/**
	 * Método para consultar en la base de datos de cuantos pictos consta cada categoría.
	 * @param nombre
	 * @return
	 */
	@SuppressWarnings("finally")
	public int numPictosCat(String nombre, int idioma){
		consultaBD p=new consultaBD();
		p.establecerConexion();
		int numeroPictos=-1;
		String consulta, columnaClase;
		if (idioma==0){

			columnaClase = "Nombre";
		}else{

			columnaClase = "Nombre_eng";
		}
		consulta = new String("select Num_pictos from Categoria where "+columnaClase+"=\""+nombre+"\";");

		try{

			st = p.getConexion().createStatement();
			rdo = st.executeQuery(consulta);
			rdo.next();
			numeroPictos = rdo.getInt("Num_pictos");

		}catch(SQLException ex){
			ex.printStackTrace();

		}
		finally{
			p.cerrar(rdo);
			p.cerrar(st);
			p.destruir();
			return numeroPictos;
		}
	}

	/**
	 * Método para consultar el texto en la base de datos que aparece en la parte superior de la pantalla.
	 * @param nombre
	 * @param idioma
	 * @return
	 */
	@SuppressWarnings("finally")
	public ArrayList<String> consultaTextoPantallas(String nombre, int idioma){
		consultaBD p = new consultaBD();
		p.establecerConexion();
		ArrayList <String> text = new ArrayList<String>(); 
		String nom="";
		String consulta, textoIdioma;
		if (idioma==0){

			textoIdioma = "Texto_esp";
		}else{
			textoIdioma = "Texto_eng";
			nombre = consultaNombreClaseEsp(nombre);
		}


		consulta = new String("select "+textoIdioma+" from Pictograma where Nom_categoria=\""+nombre+"\";");

		try{

			st = p.getConexion().createStatement();
			rdo = st.executeQuery(consulta);
			while(rdo.next()){ 
				nom = rdo.getString(textoIdioma);
				text.add(nom);
			}

		}catch(SQLException ex){
			ex.printStackTrace();

		}
		finally{
			p.cerrar(rdo);
			p.cerrar(st);
			p.destruir();
			return text;
		}
	}

	/**
	 * Método para consultar el texto de cada categoría.
	 * @param nombre
	 * @param idioma
	 * @return
	 */
	@SuppressWarnings("finally")
	public String consultaNombreClaseEsp(String nombre){
		consultaBD p=new consultaBD();
		p.establecerConexion();
		String nom="";
		String consulta, textoIdioma, columnaClase;

		consulta = new String("select Nombre from Categoria where Nombre_eng=\""+nombre+"\";");

		try{
			st = p.getConexion().createStatement();
			rdo = st.executeQuery(consulta);
			rdo.next();
			nom = rdo.getString("Nombre");

		}catch(SQLException ex){
			ex.printStackTrace();

		}
		finally{
			p.cerrar(rdo);
			p.cerrar(st);
			p.destruir();
			return nom;
		}
	}
	
	/**
	 * Método para consultar el texto de cada categoría.
	 * @param nombre
	 * @param idioma
	 * @return
	 */
	@SuppressWarnings("finally")
	public String consultaTextoCategoria(String nombre, int idioma){
		consultaBD p=new consultaBD();
		p.establecerConexion();
		String nom="";
		String consulta, textoIdioma, columnaClase;

		if (idioma==0){

			textoIdioma = "Texto";
			columnaClase = "Nombre";
		}else{
			textoIdioma = "Texto_eng";
			columnaClase = "Nombre_eng";
		}

		consulta = new String("select "+textoIdioma+" from Categoria where "+columnaClase+"=\""+nombre+"\";");

		try{
			st = p.getConexion().createStatement();
			rdo = st.executeQuery(consulta);
			rdo.next();
			nom = rdo.getString(textoIdioma);

		}catch(SQLException ex){
			ex.printStackTrace();

		}
		finally{
			p.cerrar(rdo);
			p.cerrar(st);
			p.destruir();
			return nom;
		}
	}

	/**
	 * Método para establecer conexiones a la base de datos.
	 */
	public void establecerConexion(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection(server,user,password);
		}
		catch(Exception e){
			System.out.println("Imposible realizar conexion con la BD");
			e.printStackTrace();
		}
	}

	/**
	 * Método que devuelve la conexión ya establecida.
	 * @return
	 */
	public Connection getConexion(){
		return conexion;
	}

	/**
	 * Método para cerrar el ResultSet.
	 * @param rs
	 */
	public void cerrar(ResultSet rs){
		if(rs !=null){
			try{
				rs.close();
			}
			catch(Exception e){
				System.out.print("No es posible cerrar la Conexion");
			}
		}
	}

	/**
	 * Método para cerrar el Statement.
	 * @param stmt
	 */
	public void cerrar(Statement stmt){
		if(stmt !=null){
			try{
				stmt.close();
			}
			catch(Exception e){}
		}
	}

	/**
	 * Método para cerrar la conexión.
	 */
	public void destruir(){

		if(conexion !=null){

			try{
				conexion.close();
			}
			catch(Exception e){}
		}
	}

}
