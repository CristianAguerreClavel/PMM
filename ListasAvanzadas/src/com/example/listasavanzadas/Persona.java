package com.example.listasavanzadas;

public class Persona {
	
	private String nombre;
	private String apellido;
	//private int edad;
	
	public Persona (String nom, String ape)
	{
		nombre = nom;
		apellido = ape;
		//this.edad = edad;
	}
	
	public String getNombre()
	{
		return nombre;
	}
	
	public String getApellido()
	{
		return apellido;
	}
	
	/*public int getEdad(){
		return edad;
	}*/
}
