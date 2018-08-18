package DAO;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.User;

import com.ConexionDB.ConexionDB;

public class LoginDAO implements Serializable {
	



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ArrayList<User> getUsers(){
		
		ArrayList<User> lista = new ArrayList<User>();
		Connection c = null;
		
		try{
			
			ConexionDB cdb = new ConexionDB();
			c = cdb.getConexion();
		
			Statement st = c.createStatement();
			ResultSet rs= st.executeQuery(" SELECT U.ID, U.USERNAME, U.PASSWORD, U.FIRST_NAME, U.LAST_NAME "
					+ " FROM DBSLOGIN.USERS U ");
			
			while(rs.next()){
				
				User user = new User();
				
				user.setId(rs.getInt(1));
				user.setUser(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setFirstName(rs.getString(4));
				user.setLastName(rs.getString(5));
		
				lista.add(user);
			}
			
			rs.close();
			st.close();
			
		}catch(Exception e){
			e.printStackTrace();
			
		}finally{
		
			try{
				c.close();
			}catch(Exception e2){
				e2.printStackTrace();
			}
		}
		
		return lista;
	}
	

	
	
	




}
