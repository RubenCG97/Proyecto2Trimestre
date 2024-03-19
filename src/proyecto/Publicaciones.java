package proyecto;

import java.util.Scanner;

public abstract class Publicaciones {

	protected int ISBN;
	protected String titulo;
	protected Autores autor;
	protected String descripcion;
	protected String editorial;
	protected int numPag;

	enum GENERO {
		NOVELACOMTEPORANEA, POESIA, CC_Y_FANTASIA, MISTERIO_Y_TRHILLER, LITERATURAJUVENIL, NOFICCION, TERROR, ROMANCE,
		CLASICOSLITERARIOS, CUENTOSCORTOS
	}

	protected GENERO genero;

	public Publicaciones() {
	}

	public Publicaciones(int iSBN, String titulo, Autores autor, String descripcion, String editorial, int numPag,
			GENERO genero) {
		super();
		ISBN = iSBN;
		this.titulo = titulo;
		this.autor = autor;
		this.descripcion = descripcion;
		this.editorial = editorial;
		this.numPag = numPag;
		this.genero = genero;
	}

	public int getISBN() {
		return ISBN;
	}

	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Autores getAutor() {
		return autor;
	}

	public void setAutor(Autores autor) {
		this.autor = autor;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public int getNumPag() {
		return numPag;
	}

	public void setNumPag(int numPag) {
		this.numPag = numPag;
	}

	public GENERO getGenero() {
		return genero;
	}

	public void setGenero(GENERO genero) {
		this.genero = genero;
	}

	@Override
	public String toString() {
		return "Publicaciones [ISBN=" + ISBN + ", titulo=" + titulo + ", autor=" + autor + ", descripcion="
				+ descripcion + ", editorial=" + editorial + ", numPag=" + numPag + ", genero=" + genero + "]";
	}

	public Publicaciones CrearPublicacion(Publicaciones[] listaPublicaciones, Autores[] listaAutores) {
		return null;
		
	}

	public Publicaciones ModificarPublicacion(Publicaciones publivacion ,Autores[] listaAutores, Publicaciones[] listaPublicaciones) {
		
		return null;
	}
	public Publicaciones BorrarPublicacion(Publicaciones publicacion, Publicaciones[] listaPublicaciones) {

		return null;

	}
	
	
}
