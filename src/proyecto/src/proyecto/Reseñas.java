package proyecto;

public class Reseñas {

	private Publicaciones publicacion;
	private Usuarios usuario;
	private String opinion;

	enum PUNTUACION {
		UNO, DOS, TRES, CUATRO, CINCO
	}

	private PUNTUACION puntuacion;

	public Reseñas() {
	}

	public Reseñas(Publicaciones publicacion, Usuarios usuario, String opinion, PUNTUACION puntuacion) {
		super();
		this.publicacion = publicacion;
		this.usuario = usuario;
		this.opinion = opinion;
		this.puntuacion = puntuacion;
	}

	public Publicaciones getPublicacion() {
		return publicacion;
	}

	public void setPublicacion(Publicaciones publicacion) {
		this.publicacion = publicacion;
	}

	public Usuarios getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}

	public String getOpinion() {
		return opinion;
	}

	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}

	public PUNTUACION getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(PUNTUACION puntuacion) {
		this.puntuacion = puntuacion;
	}

	@Override
	public String toString() {
		return "Reseñas [publicacion=" + publicacion + ", usuario=" + usuario + ", opinion=" + opinion + ", puntuacion="
				+ puntuacion + "]";
	}

}
