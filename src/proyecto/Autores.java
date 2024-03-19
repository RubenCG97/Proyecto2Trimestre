package proyecto;

public class Autores {

	private int autor;
	private String nombre;
	private String biografia;
	
	public Autores() {}
	
	public Autores(int autor, String nombre, String biografia) {
		this.autor = autor;
		this.nombre = nombre;
		this.biografia = biografia;
	}

	public int getAutor() {
		return autor;
	}

	public void setAutor(int autor) {
		this.autor = autor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getBiografia() {
		return biografia;
	}

	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}

	@Override
	public String toString() {
		return "Autores [autor=" + autor + ", nombre=" + nombre + ", biografia=" + biografia + "]";
	}
	
	
}
