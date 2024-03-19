package proyecto;

public class Ebooks extends Publicaciones {

	protected String formatoEbook;

	public Ebooks() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ebooks(int iSBN, String titulo, Autores autor, String descripcion, String editorial, int numPag,
			GENERO genero, GENERO subgenero, ESTADO estado) {
		super(iSBN, titulo, autor, descripcion, editorial, numPag, genero, subgenero, estado, descripcion);
		// TODO Auto-generated constructor stub
	}

	public String getFormatoEbook() {
		return formatoEbook;
	}

	public void setFormatoEbook(String formatoEbook) {
		this.formatoEbook = formatoEbook;
	}

	@Override
	public String toString() {
		return super.toString() + "ebook [formatoEbook=" + formatoEbook + "]";
	}

}
