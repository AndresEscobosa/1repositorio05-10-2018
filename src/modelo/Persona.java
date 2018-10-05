package modelo;
import java.io.Serializable;

public class Persona implements Serializable{
	//todos los objetos dentro de aqui, deben implementar Serializable también
	//al igual que las clases que hayamos creado y queramos Serializar
	//la palabra reservada "transient" es para elegir qué variable o parámetro no se Serializará
	//private
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private int edad;
	
	public Persona(String nombre, int edad) {
		super();
		this.nombre = nombre;
		this.edad = edad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", edad=" + edad + "]";
	}
	

}
