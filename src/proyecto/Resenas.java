package proyecto;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author Ruben
 * Implementa la interfaz Comparable para permitir la comparación entre Resenas.
 */
public class Resenas implements Comparable {
	/**
	 * Atributos de clase
	 */
	private Publicaciones publicacion;
	private Usuarios usuario;
	private String opinion;
	private int puntuacion;
	//Constructores
	/**
	 * Constructor vacio
	 */
	public Resenas() {
	}
	/**
	 * Constructor parametrizado de Resenas
	 * @param publicacion
	 * @param usuario
	 * @param opinion
	 * @param puntuacion
	 */
	public Resenas(Publicaciones publicacion, Usuarios usuario, String opinion, int puntuacion) {
		this.publicacion = publicacion;
		this.usuario = usuario;
		this.opinion = opinion;
		this.puntuacion = puntuacion;
	}
	//Metodos públicos
	/**
	 * Metodo para obtener la publicacio de la resena
	 * @return la publicacion de la resena
	 */
	public Publicaciones getPublicacion() {
		return publicacion;
	}
	/**
	 * Metodo para establecer la publicacion de la resena
	 * @param la publicacion de la resena
	 */
	public void setPublicacion(Publicaciones publicacion) {
		this.publicacion = publicacion;
	}
	/**
	 * Metodo para obtener el usuario de la resena
	 * @return el usuario de la resena
	 */
	public Usuarios getUsuario() {
		return usuario;
	}
	/**
	 * Metodo para establecer el usuario de la resena
	 * @param el usuario de la resena
	 */
	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}
	/**
	 * Metodo para obtener la opinion de la resena
	 * @return la opinion de la resna
	 */
	public String getOpinion() {
		return opinion;
	}
	/**
	 * Metodo para establcer la opinion de la resena
	 * @param la opinion de la resena
	 */
	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}
	/**
	 * Metodo para obtener la puntuacion de la resena
	 * @return la puntuacion de la resena
	 */
	public int getPuntuacion() {
		return puntuacion;
	}
	/**
	 * Metodo para establecer la puntuacion de la resena
	 * @param la puntuacion de la resena
	 */
	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}

	@Override
	/**
	 * Metodo para mostrar la informacion de la resena
	 */
	public String toString() {
		return "Resenas [publicacion=" + publicacion + ", usuario=" + usuario + ", opinion=" + opinion + ", puntuacion="
				+ puntuacion + "]";
	}
	/**
	 * Metodo para crear una resena
	 * @param se le pasa como parametro un listado de publicaciones
	 * @param se le pasa como paramero un listado de usuarios
	 * @return devuelve la resena creada
	 */
	public Resenas CrearRESENNA(Publicaciones [] listadodePublicaciones,Usuarios[] listadeUsuarios) {
		Resenas resena=new Resenas();
		var sc=new Scanner(System.in);
		
		
		boolean encontrado;
		do {
			
			System.out.println("Introduzca el isbn de la publicacion");
			int isbn=sc.nextInt();
			encontrado=false;
			for(int i=0;i<listadodePublicaciones.length && !encontrado;i++) {
				if(listadodePublicaciones[i]!=null && listadodePublicaciones[i].getISBN()==isbn) {
					resena.setPublicacion(listadodePublicaciones[i]);
					encontrado=true;
				}
			}
			if(!encontrado) {
				System.out.println("No se encuentra, introduce un isbn que exista");
			}
			
		}while(!encontrado);
		sc.nextLine();
		System.out.println("Introduce el nickname que hará la resena");
		boolean usu;
		do {
			usu=false;
			String nickname=sc.nextLine();
			nickname=nickname.toLowerCase();
			for(int j=0;j<listadeUsuarios.length && !usu;j++) {
				if(listadeUsuarios[j]!=null && listadeUsuarios[j].getNickname().equals(nickname)) {
					resena.setUsuario(listadeUsuarios[j]);
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
		resena.setOpinion(opinion);
		
		System.out.println("Elige de 1 a 5 estrellas");
		int eleccion;
		do {
			 eleccion=sc.nextInt();
			 switch(eleccion) {
			 
			 case 1: resena.setPuntuacion(1);break;
			 case 2: resena.setPuntuacion(2);break;
			 case 3: resena.setPuntuacion(3);break;
			 case 4: resena.setPuntuacion(4);break;
			 case 5: resena.setPuntuacion(5);break;
			 default:System.out.println("Error al introducir la opcion, vuelve a ponerla");
			 }
			 	 
		}while(eleccion<1 || eleccion>5);
		
		return resena;
		
	}
	/**
	 * Metodo para borrar Resenas
	 * @param se le pasa como parametro un listado de Resenas
	 * @return la resena borrada
	 */
	public Resenas BorrarResenas(Resenas[] listaResenas) {
	    Scanner sc = new Scanner(System.in);

	    System.out.println("Introduce el ISBN de la publicación de la resena que quieres borrar:");
	    int isbn = sc.nextInt();
	    sc.nextLine();

	    System.out.println("Introduce el nickname del usuario que hizo la resena:");
	    String nickname = sc.nextLine().toLowerCase();

	    Resenas resenaEliminada = null;

	    for (int i = 0; i < listaResenas.length; i++) {
	        if (listaResenas[i] != null &&
	            listaResenas[i].getPublicacion().getISBN() == isbn &&
	            listaResenas[i].getUsuario().getNickname().equalsIgnoreCase(nickname)) {
	            resenaEliminada = listaResenas[i];
	            listaResenas[i] = null;
	            System.out.println("Resena eliminada correctamente.");
	            break;
	        }
	    }

	    if (resenaEliminada == null) {
	        System.out.println("No se encontró ninguna resena con el ISBN y el usuario especificados.");
	    }

	    return resenaEliminada;
	}
	/**
	 * Metodo para listar Resenas
	 * @param se le pasa como parametro un listado de Resenas
	 */
	public void ListarResenas(Resenas[]listarResenas) {
		for(int i=0;i<listarResenas.length;i++) {
			if(listarResenas[i]!=null) {
				System.out.println(listarResenas[i]);
			}
		}
	}
	
	/**
	 * Metodo publico para calcular la puntuación media de la resena
	 * @param se le pasa el isbn de la publicacion
	 * @param se le pasa un listado de Resenas
	 * @return el valor de la puntuacion media, si es -1 no existe
	 */
	public double calcularPuntuacionMediaPorISBN(int isbn, Resenas[] listaResenas) {
	    double sumaPuntuaciones = 0;
	    int contadorResenas = 0;

	    
	    for (Resenas resena : listaResenas) {
	        if (resena != null && resena.getPublicacion().getISBN() == isbn) {
	            sumaPuntuaciones += resena.getPuntuacion();
	            contadorResenas++;
	        }
	    }

	    if (contadorResenas > 0) {
	        return sumaPuntuaciones / contadorResenas;
	    } else {
	        System.out.println("No hay Resenas de ese libro");
	        return -1;
	    }
	}
	
	@Override
	/**
	 * Metodo para mostrar la lista de menos a mas usando la interfaz comparable
	 * @return 1 si es mayor,0 si son iguales y -1 si es menor
	 */
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		Resenas c=(Resenas)o;
		return Integer.compare(this.getPuntuacion(),c.getPuntuacion());
	}
	/**
	 * Metodo para devolvler la lista de menor a mayor usando la interfaz comparator
	 */
	public static Comparator<Resenas> PuntuacionComparator = new Comparator<Resenas>() {
        @Override
        public int compare(Resenas r1, Resenas r2) {
            return Integer.compare(r2.getPuntuacion(), r1.getPuntuacion()); // 
        }
    };

}	

