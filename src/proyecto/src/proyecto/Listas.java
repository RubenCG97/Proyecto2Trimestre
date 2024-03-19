package proyecto;

import java.util.Arrays;

public class Listas {

	private Publicaciones[] publicaciones;
	private Usuarios usuario;
	private String nombre;

	public Listas() {
	}

	public Listas(Publicaciones[] publicaciones, Usuarios usuario, String nombre) {
		this.publicaciones = publicaciones;
		this.usuario = usuario;
		this.nombre = nombre;
	}

	public Publicaciones[] getPublicaciones() {
		return publicaciones;
	}

	public void setPublicaciones(Publicaciones[] publicaciones) {
		this.publicaciones = publicaciones;
	}

	public Usuarios getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Listas [publicaciones=" + Arrays.toString(publicaciones) + ", usuario=" + usuario + ", nombre=" + nombre
				+ "]";
	}

}
