package proyecto;

public abstract class Publicaciones {

	protected int ISBN;
	protected String titulo;
	protected Autores autor;
	protected String descripcion;
	protected String editorial;
	protected int numPag;
	protected int numPagLeidas;

	enum GENERO{
		NOVELACOMTEPORANEA,POESIA,CC_Y_FANTASIA,MISTERIO_Y_TRHILLER,LITERATURAJUVENIL,NOFICCION,TERROR,ROMANCE,CLASICOSLITERARIOS,
		CUENTOSCORTOS
	}
	protected GENERO genero;
	protected GENERO subgenero;
	enum ESTADO{
		NOLEIDO,ENPROCESO,TERMINADO
	}
	protected ESTADO estado;
	protected String idioma;


	public Publicaciones() {}

	public Publicaciones(int iSBN, String titulo, Autores autor, String descripcion, String editorial, int numPag,
			GENERO genero, GENERO subgenero, ESTADO estado, String idioma) {
		super();
		ISBN = iSBN;
		this.titulo = titulo;
		this.autor = autor;
		this.descripcion = descripcion;
		this.editorial = editorial;
		this.numPag = numPag;
		this.numPagLeidas = 0;
		this.genero = genero;
		this.subgenero = subgenero;
		this.estado = estado;
		this.idioma = idioma;
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

	public GENERO getSubgenero() {
		return subgenero;
	}

	public void setSubgenero(GENERO subgenero) {
		this.subgenero = subgenero;
	}

	public ESTADO getEstado() {
		return estado;
	}

	public void setEstado(ESTADO estado) {
		this.estado = estado;
	}
	
	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	@Override
	public String toString() {
		return "Publicaciones [ISBN=" + ISBN + ", titulo=" + titulo + ", autor=" + autor + ", descripcion="
				+ descripcion + ", editorial=" + editorial + ", numPag=" + numPag + ", genero=" + genero
				+ ", subgenero=" + subgenero + ", estado=" + estado + ", idioma=" + idioma + "]";
	}
	
	
}
