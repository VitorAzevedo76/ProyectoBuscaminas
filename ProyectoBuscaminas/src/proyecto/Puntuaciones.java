package proyecto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import javax.swing.JDialog;

import vistas.vistaPontuaciones;



public class Puntuaciones {
	//Atributos
	private Jugador[] lista;
	private static Puntuaciones misPuntuaciones;
	private String dirActual;
	private String pRuta;
	
	//Constructora
	
	private Puntuaciones() {

		//lista=new Jugador[10]();
		dirActual = System.getProperty("user.dir");
		pRuta = dirActual + File.separator+"RANK.txt";
		lista=new Jugador[10];
	

	}
	public void imprimir() {
		int cont=0;
		boolean enc=false;
		System.out.println("IMPRIMIENDO");
		while (cont<10 && !enc) {
			if(lista[cont]==null) {
				enc=true;
			}
			else {
			System.out.println((cont+1)+"-"+lista[cont].getNombre()+lista[cont].getValor());
			cont++;
		}}
		

	}
	public static Puntuaciones getMisPuntuaciones() {
		if(misPuntuaciones==null) {
			misPuntuaciones= new Puntuaciones();
		}
		return misPuntuaciones;
	}
	
	//METODOS
	public ArrayList<String> getRank() {
		int cont=0;
		boolean enc=false;
		ArrayList<String> l= new ArrayList<String>();
	
		while (cont<10 && !enc) {
			if(lista[cont]==null) {
				enc=true;
			}
			else {
				l.add((cont+1)+"-"+lista[cont].getNombre()+": "+lista[cont].getValor());
			}
			cont++;
		}
		
		return l;
	}
	public void insertar(Jugador pJug) {
		//Insercion ordenada
		Jugador[] l=new Jugador[10];
		 int cont=0;
		 boolean enc=false;
		
		 while(!enc && cont < 10) {
			if( lista[cont]	==null || lista[cont].getValor() <= pJug.getValor()) {
				enc=true;
				 l[cont]=pJug;
			}
			
			else {
				 l[cont]=lista[cont];
					System.out.println("INSERTAR2");
			 }
			 
			
			 cont++;
		 }
		
		 if(enc){
			 while (cont<10) {
				 l[cont]=lista[cont-1];
				 cont++; 
			 }
			 
		 }
		lista=l;
		
	}
	
	
	public void cargarDatos() {
		File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
		      
		      try {
		    	  	 archivo = new File (pRuta);
		    	  	System.out.println(	archivo.getPath());
		    	  
			         fr = new FileReader (archivo);
			        
			         br = new BufferedReader(fr);
			         
			         
			         // Lectura del fichero
			         String linea=" ";
			         Jugador jug;
			         int punt;
			         int cont=0;
			         
			         while(linea!=null && cont<10){
			        	 
				        	linea=br.readLine();
				        	//System.out.println(linea);
				        	String x=linea;
				        	String []pos=x.split("-->");		
				        	jug=new Jugador(pos[0]);
				        	
				        	punt=Integer.parseInt(pos[1]);
				        	
				        	jug.setPunt(punt);
				        	lista[cont]=jug;
				        	cont++;
				        	System.out.println(jug.getNombre()+"-"+punt);
				        	
				        				
				         }
	
		      }
		      
		      catch(Exception NullPointerException) {
		    	  System.out.println("READY");
		      }
		      finally{
			         // En el finally cerramos el fichero, para asegurarnos
			         // que se cierra tanto si todo va bien como si salta 
			         // una excepcion.
			         try{                    
			            if( null != fr ){   
			               fr.close();     
			            }                  
			         }catch (Exception e2){ 
			            e2.printStackTrace();
			         }
			      }
	//Cargar Fichero de texto	
	}
	
	public void guardarDatosEnFich(){
		File archivo = null;
		System.out.println("Guardando");
	
		
	    File f = new File (pRuta);
	    FileWriter fw = null;
	    int i;
	    
		try {
			
			fw = new FileWriter(f);
			BufferedWriter escritura = new BufferedWriter(fw);
			int cont=0;
			boolean enc=false;
			
		while (cont<10 && !enc) {
			if(lista[cont]==null) {
				enc=true;
			}
			else {
			    escritura.write(lista[cont].getNombre()+"-->"+lista[cont].getValor());
			     System.out.println(lista[cont].getNombre()+"-->"+lista[cont].getValor());
		        escritura.newLine();
		        cont++;
			}
			
		
	    
		} 

	    System.out.println("La lista se ha guardado correctamente.");
	    escritura.close();
	    
		} catch(Exception NullPointerException){
	         System.out.println("LISTO"); 
	      }finally{
	         try{                    
	            if( null != fw ){   
	               fw.close();    
	            }                  
	         }catch (Exception e2){ 
	            e2.printStackTrace();
	         }
	      }
	   
	}
}
