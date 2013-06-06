package dam.prog;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;



/** Aquesta classe mostra un exemple de com cridar a l'aplicació festival.exe desde el codi Java, i 
 *  com enviar-li comandos a l festival per fer-lo parlar.
 *  
 * @author RMR
 *
 */
public class festival {
	
     
	public static void fiestuqui(String fraseALeer, String idioma) {
		
		Process p=null;  //Procés que executarà el comando festival 
		BufferedWriter stdOut; //Ens permetrà enviar ordres al festival		 

	        try {
	        	// Creem un Procés (p) que arrancarà festival.exe   
	        	p = Runtime.getRuntime().exec("c:\\festival\\festival.exe");
	        	
	        	//Creem un BufferedWriter per a poder escriure ordres a eixe procés
	        	stdOut = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));
	        	
	        	// Establim la veu an Anglés Americà
	        	
	        	// if (idioma
	            stdOut.write("(voice_cstr_upc_upm_spanish_hts)");
	            stdOut.flush();
	            
	        	stdOut.write("(voice_cmu_us_slt_arctic_hts)");
	            stdOut.flush();
	            
	            // Li diem la cadena que volem que ens llegeisca
	            stdOut.write("(SayText \""+fraseALeer+"\")");
	            stdOut.flush();
	            
	            //Eixim del festival.exe
	            stdOut.write("(quit)");
	            stdOut.flush();
	                   
	            try{            	
	            	p.waitFor();  //Esperem per que el procés faça totes les coses que li hem manat fer 
	        	}catch(InterruptedException ie){
	        		ie.printStackTrace();
	        	} 
	            
	        }
	        catch (IOException ioe) {
	            ioe.printStackTrace();
	        }finally{	
	          p.destroy(); 
	        }
		
	}
		
}



