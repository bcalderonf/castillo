package com.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import DAO.LoginDAO;
import model.Log;
import model.User;

import java.io.Serializable;
import java.util.ArrayList;

@ManagedBean
@SessionScoped
public class LogBean implements Serializable{
	
	
	//Controlador para el logeo del usuario
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	User user;
	Log log;
	LoginDAO loginDAO;
	ArrayList<User> listaUsers = new ArrayList<User>();
	
	boolean errorContra= false;
	boolean errorUser = false;
	
	
	public LogBean() {
		user = new User();
		log = new Log();
		loginDAO = new LoginDAO();
	}
	
	public String entrar(){
		boolean noEncontroUsuario = false;
		listaUsers.clear();
		listaUsers = loginDAO.getUsers();
		for (User userBase : listaUsers) {
			if(userBase.getUser().equals(log.getUser())){
				if(userBase.getPassword().equals(log.getPassword())){
					user = userBase;
					return "MainPage?faces-redirect=true.xhtml";
				}else{
					return "PasswordError?faces-redirect=true.xhtml";
				}
			}else{
				noEncontroUsuario=true;
			}
		}
		if(noEncontroUsuario==true){
			return "UserError?faces-redirect=true.xhtml";
		}
		
		return "";
	}
	
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Log getLog() {
		return log;
	}
	public void setLog(Log log) {
		this.log = log;
	}
	public LoginDAO getLoginDAO() {
		return loginDAO;
	}
	public void setLoginDAO(LoginDAO loginDAO) {
		this.loginDAO = loginDAO;
	}

	public ArrayList<User> getListaUsers() {
		return listaUsers;
	}

	public void setListaUsers(ArrayList<User> listaUsers) {
		this.listaUsers = listaUsers;
	}

	
	
	


}