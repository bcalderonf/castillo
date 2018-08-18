package com.ConexionDB;

import java.io.FileInputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConexionDB implements Serializable {
	



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public static void main(String [] args){
		
		ConexionDB cdb = new ConexionDB();	
		
		Properties p = cdb.getProperties("C:/LigSysDBS/LigSys/conf/conf.properties");
		System.out.println(p.getProperty("USUARIO")+p.getProperty("CLAVE")+p.getProperty("URL")+p.getProperty("DRIVER"));
		
		
		}
		
		public Connection getConexion(){
			
			Properties p = getProperties("C:/LigSysDBS/LigSys/conf/conf.properties");
			return getConexion(p);

		}
		
		private Properties getProperties(String archivo){

			Properties p = new Properties();

			try{
			FileInputStream in = new FileInputStream( archivo );
			p.load(in);
			in.close();
			}
			
			catch(Exception e){
				e.printStackTrace();
				System.out.println("Error al momento de cargar el archivo");
			}
			
			return p;
		}
		
		private Connection getConexion(Properties p){
			
			Connection c = null;
			
			try{
				
				Class.forName( p.getProperty("DRIVER" ));
			//	c = DriverManager.getConnection(p.getProperty("URL", p.getProperty("USUARIO", p.getProperty("CLAVE"))));
				c = DriverManager.getConnection(p.getProperty("URL"),p.getProperty("USUARIO"), p.getProperty("CLAVE"));
				
			}
			
			catch(Exception e){
				e.printStackTrace();
			}
			return c;
		}
	
	




}
