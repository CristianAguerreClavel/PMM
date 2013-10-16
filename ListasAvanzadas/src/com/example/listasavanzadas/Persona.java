package com.example.listasavanzadas;

public class Persona {
	
	private String nombre;
	private String apellido;
	//private int edad;
    int imagen;
	
	public Persona (String nom, String ape)
	{
		nombre = nom;
		apellido = ape;
		//this.edad = edad;

	}
    public Persona (String nom, String ape,int imagen)
    {
        nombre = nom;
        apellido = ape;
        //this.edad = edad;
        this.imagen=imagen;
    }
	
	public String getNombre()
	{
		return nombre;
	}
	
	public String getApellido()
	{
		return apellido;
	}

    public int getImagen()
    {
        return imagen;
    }
	
	/*public int getEdad(){
		return edad;
	}*/
}
