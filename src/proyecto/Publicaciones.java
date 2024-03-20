package proyecto;

import java.util.Scanner;

/**
 * @author ruben
 */
public abstract class Publicaciones {

    protected int ISBN; // El ISBN de la publicación
    protected String titulo; // El título de la publicación
    protected Autores autor; // El autor de la publicación
    protected String descripcion; // La descripción de la publicación
    protected String editorial; // La editorial de la publicación
    protected int numPag; // El número de páginas de la publicación

    /**
     * Enumeración que representa los géneros de las publicaciones.
     */
    enum GENERO {
        NOVELACOMTEPORANEA, POESIA, CC_Y_FANTASIA, MISTERIO_Y_TRHILLER, LITERATURAJUVENIL, NOFICCION, TERROR, ROMANCE,
        CLASICOSLITERARIOS, CUENTOSCORTOS
    }

    protected GENERO genero; // El género de la publicación

    /**
     * Constructor por defecto de la clase Publicaciones.
     */
    public Publicaciones() {
    }

    /**
     * Constructor de la clase Publicaciones.
     * @param iSBN El ISBN de la publicación.
     * @param titulo El título de la publicación.
     * @param autor El autor de la publicación.
     * @param descripcion La descripción de la publicación.
     * @param editorial La editorial de la publicación.
     * @param numPag El número de páginas de la publicación.
     * @param genero El género de la publicación.
     */
    public Publicaciones(int iSBN, String titulo, Autores autor, String descripcion, String editorial, int numPag,
            GENERO genero) {
        this.ISBN = iSBN;
        this.titulo = titulo;
        this.autor = autor;
        this.descripcion = descripcion;
        this.editorial = editorial;
        this.numPag = numPag;
        this.genero = genero;
    }

    /**
     * Método para obtener el ISBN de la publicación.
     * @return El ISBN de la publicación.
     */
    public int getISBN() {
        return ISBN;
    }

    /**
     * Método para establecer el ISBN de la publicación.
     * @param iSBN El ISBN de la publicación.
     */
    public void setISBN(int iSBN) {
        ISBN = iSBN;
    }

    /**
     * Método para obtener el título de la publicación.
     * @return El título de la publicación.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Método para establecer el título de la publicación.
     * @param titulo El título de la publicación.
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Método para obtener el autor de la publicación.
     * @return El autor de la publicación.
     */
    public Autores getAutor() {
        return autor;
    }

    /**
     * Método para establecer el autor de la publicación.
     * @param autor El autor de la publicación.
     */
    public void setAutor(Autores autor) {
        this.autor = autor;
    }

    /**
     * Método para obtener la descripción de la publicación.
     * @return La descripción de la publicación.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Método para establecer la descripción de la publicación.
     * @param descripcion La descripción de la publicación.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Método para obtener la editorial de la publicación.
     * @return La editorial de la publicación.
     */
    public String getEditorial() {
        return editorial;
    }

    /**
     * Método para establecer la editorial de la publicación.
     * @param editorial La editorial de la publicación.
     */
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    /**
     * Método para obtener el número de páginas de la publicación.
     * @return El número de páginas de la publicación.
     */
    public int getNumPag() {
        return numPag;
    }

    /**
     * Método para establecer el número de páginas de la publicación.
     * @param numPag El número de páginas de la publicación.
     */
    public void setNumPag(int numPag) {
        this.numPag = numPag;
    }

    /**
     * Método para obtener el género de la publicación.
     * @return El género de la publicación.
     */
    public GENERO getGenero() {
        return genero;
    }

    /**
     * Método para establecer el género de la publicación.
     * @param genero El género de la publicación.
     */
    public void setGenero(GENERO genero) {
        this.genero = genero;
    }

	@Override
	/**
	 * Metodo para mostrar al informacion de las publicaciones
	 */
	public String toString() {
		return "Publicaciones [ISBN=" + ISBN + ", titulo=" + titulo + ", autor=" + autor + ", descripcion="
				+ descripcion + ", editorial=" + editorial + ", numPag=" + numPag + ", genero=" + genero + "]";
	}
	 /**
     * Método abstracto para crear una nueva publicación.
     * @param listaPublicaciones El listado de publicaciones disponibles.
     * @param listaAutores El listado de autores asociados a las publicaciones.
     * @return La nueva publicación creada.
     */
	public Publicaciones CrearPublicacion(Publicaciones[] listaPublicaciones, Autores[] listaAutores) {
		return null;
		
	}

	/**
     * Método abstracto para modificar una publicación existente.
     * @param publicacion La publicación a modificar.
     * @param listaAutores El listado de autores asociados a las publicaciones.
     * @param listaPublicaciones El listado de publicaciones disponibles.
     * @return La publicación modificada.
     */
	public Publicaciones ModificarPublicacion(Publicaciones publivacion ,Autores[] listaAutores, Publicaciones[] listaPublicaciones) {
		
		return null;
	}
	/**
     * Método abstracto para borrar una publicación.
     * @param publicacion La publicación a borrar.
     * @param listaPublicaciones El listado de publicaciones disponibles.
     * @return La publicación borrada.
     */
	public Publicaciones BorrarPublicacion(Publicaciones publicacion, Publicaciones[] listaPublicaciones) {

		return null;

	}
	
	
}