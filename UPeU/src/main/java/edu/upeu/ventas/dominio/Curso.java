package edu.upeu.ventas.dominio;

public class Curso {

	private String id;
	private String nombre;
	private int nroHoras;
	private int nroCreditos;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getNroHoras() {
		return nroHoras;
	}
	public void setNroHoras(int nroHoras) {
		this.nroHoras = nroHoras;
	}
	public int getNroCreditos() {
		return nroCreditos;
	}
	public void setNroCreditos(int nroCreditos) {
		this.nroCreditos = nroCreditos;
	}
	
}
