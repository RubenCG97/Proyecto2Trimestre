package proyecto;
import java.util.Comparator;
import java.util.Scanner;


public class Reseñas implements Comparable {

	private Publicaciones publicacion;
	private Usuarios usuario;
	private String opinion;
	private int puntuacion;

	public Reseñas() {
	}

	public Reseñas(Publicaciones publicacion, Usuarios usuario, String opinion, int puntuacion) {
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

	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}

	@Override
	public String toString() {
		return "Reseñas [publicacion=" + publicacion + ", usuario=" + usuario + ", opinion=" + opinion + ", puntuacion="
				+ puntuacion + "]";
	}
	
	public Reseñas CrearRESENNA(Publicaciones [] listadodePublicaciones,Usuarios[] listadeUsuarios) {
		Reseñas reseña=new Reseñas();
		var sc=new Scanner(System.in);
		
		
		boolean encontrado;
		do {
			
			System.out.println("Introduzca el isbn de la publicacion");
			int isbn=sc.nextInt();
			encontrado=false;
			for(int i=0;i<listadodePublicaciones.length && !encontrado;i++) {
				if(listadodePublicaciones[i]!=null && listadodePublicaciones[i].getISBN()==isbn) {
					reseña.setPublicacion(listadodePublicaciones[i]);
					encontrado=true;
				}
			}
			if(!encontrado) {
				System.out.println("No se encuentra, introduce un isbn que exista");
			}
			
		}while(!encontrado);
		sc.nextLine();
		System.out.println("Introduce el nickname que hará la reseña");
		boolean usu;
		do {
			usu=false;
			String nickname=sc.nextLine();
			nickname=nickname.toLowerCase();
			for(int j=0;j<listadeUsuarios.length && !usu;j++) {
				if(listadeUsuarios[j]!=null && listadeUsuarios[j].getNickname().equals(nickname)) {
					reseña.setUsuario(listadeUsuarios[j]);
					usu=true;
				}
			}
			if(!usu) {
				System.out.println("No se encuentra, introduce un nickname que exista");
			}
		}
		while(!usu);
		
		System.out.println("Introduce una opinion");
		String opinion=sc.nextLine();
		reseña.setOpinion(opinion);
		
		System.out.println("Elige de 1 a 5 estrellas");
		int eleccion;
		do {
			 eleccion=sc.nextInt();
			 switch(eleccion) {
			 
			 case 1: reseña.setPuntuacion(1);break;
			 case 2: reseña.setPuntuacion(2);break;
			 case 3: reseña.setPuntuacion(3);break;
			 case 4: reseña.setPuntuacion(4);break;
			 case 5: reseña.setPuntuacion(5);break;
			 default:System.out.println("Error al introducir la opcion, vuelve a ponerla");
			 }
			 	 
		}while(eleccion<1 || eleccion>5);
		
		return reseña;
		
	}
	public Reseñas BorrarReseñas(Reseñas[] listaReseñas) {
	    Scanner sc = new Scanner(System.in);

	    System.out.println("Introduce el ISBN de la publicación de la reseña que quieres borrar:");
	    int isbn = sc.nextInt();
	    sc.nextLine();

	    System.out.println("Introduce el nickname del usuario que hizo la reseña:");
	    String nickname = sc.nextLine().toLowerCase();

	    Reseñas reseñaEliminada = null;

	    for (int i = 0; i < listaReseñas.length; i++) {
	        if (listaReseñas[i] != null &&
	            listaReseñas[i].getPublicacion().getISBN() == isbn &&
	            listaReseñas[i].getUsuario().getNickname().equalsIgnoreCase(nickname)) {
	            reseñaEliminada = listaReseñas[i];
	            listaReseñas[i] = null;
	            System.out.println("Reseña eliminada correctamente.");
	            break;
	        }
	    }

	    if (reseñaEliminada == null) {
	        System.out.println("No se encontró ninguna reseña con el ISBN y el usuario especificados.");
	    }

	    return reseñaEliminada;
	}
	public void ListarReseñas(Reseñas[]listarReseñas) {
		for(int i=0;i<listarReseñas.length;i++) {
			if(listarReseñas[i]!=null) {
				System.out.println(listarReseñas[i]);
			}
		}
	}
	
	
	public double calcularPuntuacionMediaPorISBN(int isbn, Reseñas[] listaReseñas) {
	    double sumaPuntuaciones = 0;
	    int contadorReseñas = 0;

	    
	    for (Reseñas reseña : listaReseñas) {
	        if (reseña != null && reseña.getPublicacion().getISBN() == isbn) {
	            sumaPuntuaciones += reseña.getPuntuacion();
	            contadorReseñas++;
	        }
	    }

	    if (contadorReseñas > 0) {
	        return sumaPuntuaciones / contadorReseñas;
	    } else {
	        System.out.println("No hay reseñas de ese libro");
	        return -1;
	    }
	}
	
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		Reseñas c=(Reseñas)o;
		return Integer.compare(this.getPuntuacion(),c.getPuntuacion());
	}
	public static Comparator<Reseñas> PuntuacionComparator = new Comparator<Reseñas>() {
        @Override
        public int compare(Reseñas r1, Reseñas r2) {
            return Integer.compare(r2.getPuntuacion(), r1.getPuntuacion()); // 
        }
    };

}	

