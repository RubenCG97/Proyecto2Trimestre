package proyecto;

public class Comics extends Publicaciones {
	
	enum COLOR{
		SI,NO
	}
	protected COLOR color;
	
	public Comics() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Comics(int iSBN, String titulo, Autores autor, String descripcion, String editorial, int numPag,
			GENERO genero, GENERO subgenero, ESTADO estado) {
		super(iSBN, titulo, autor, descripcion, editorial, numPag, genero, subgenero, estado, descripcion);
		// TODO Auto-generated constructor stub
	}
	public COLOR getColor() {
		return color;
	}
	public void setColor(COLOR color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return super.toString() + "Comics [color=" + color + "]";
	}
	
	
	
}
