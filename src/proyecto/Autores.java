package proyecto;

import java.util.Scanner;
/**
 * @author ruben
 */
public class Autores {
	//Atributos de clase
	private int autor;
	private String nombre;
	private String biografia;

	 /** 
     * Constructor predeterminado de la clase Autores.
     * Inicializa todos los campos en sus valores predeterminados.
     */
	public Autores() {
	}

	/**
     * Constructor parametrizado de la clase Autores.
     * @param autor El identificador único del autor.
     * @param nombre El nombre del autor.
     * @param biografia La biografía del autor.
     */
	public Autores(int autor, String nombre, String biografia) {
		this.autor = autor;
		this.nombre = nombre;
		this.biografia = biografia;
	}

	/**
     * Obtiene el identificador único del autor.
     * @return El identificador único del autor.
     */
    public int getAutor() {
        return autor;
    }

    /**
     * Establece el identificador único del autor.
     * @param autor El nuevo identificador único del autor.
     */
    public void setAutor(int autor) {
        this.autor = autor;
    }

    /**
     * Obtiene el nombre del autor.
     * @return El nombre del autor.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del autor.
     * @param nombre El nuevo nombre del autor.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la biografía del autor.
     * @return La biografía del autor.
     */
    public String getBiografia() {
        return biografia;
    }

    /**
     * Establece la biografía del autor.
     * @param biografia La nueva biografía del autor.
     */
    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

	@Override
	/**
	 * Metodo para mostrar los atributos de los autores
	 */
	public String toString() {
		return "Autores [autor=" + autor + ", nombre=" + nombre + ", biografia=" + biografia + "]";
	}
	/**
	 * Metodo para crear autor
	 * @param se le pasa un listado de autores
	 * @return autor
	 */
	public Autores CrearAutor(Autores[] listaAutores) {
		var sc = new Scanner(System.in);
		Autores autor = new Autores();
		int idautor;
		do {
			System.out.println("Introduce el código del autor");
			idautor = sc.nextInt();

		} while (ComprobarAutor(idautor, listaAutores));
		autor.setAutor(idautor);

		sc.nextLine();

		System.out.println("Introduce el nombre del autor");
		String nombre = sc.nextLine();
		autor.setNombre(nombre);

		System.out.println("Intoduce una biografía del autor");
		String biografía = sc.nextLine();
		autor.setBiografia(biografía);

		return autor;

	}
	/**
	 * Metodo para modicar el autro
	 * @param se le pasa autor
	 * @param se le pasa lista de autores
	 * @return autor
	 */
	public Autores ModificarAutor(Autores autor, Autores[] listaAutores) {

		var sc = new Scanner(System.in);

		boolean salida = false;

		do {
			System.out.println("Que desea modificar del usuario (id/nombre/biografia)");
			String eleccion = sc.nextLine();
			eleccion = eleccion.toLowerCase();

			switch (eleccion) {

			case "id":
				int id;
				do {
					System.out.println("Introduce el nuevo id: ");
					id = sc.nextInt();

					if (id == autor.getAutor()) {
						System.out.println("Es el mismo");
					}

				} while (ComprobarAutor(id, listaAutores));
				autor.setAutor(id);
				sc.nextLine();
				break;

			case "nombre":
				System.out.println("Introduce el nuevo nombre");
				String nuevoNombre = sc.nextLine();
				autor.setNombre(nuevoNombre);
				break;

			case "biografia":
				System.out.println("Introduce la nueva biografia");
				String nuevabiografia = sc.nextLine();
				autor.setBiografia(nuevabiografia);
				break;
			default:
				System.out.println("Error al introducir la eleccion");
				break;
			}
			System.out.println(
					"Quieres continuar con las modificaciones (n para salir, cualquier otra tecla para continuar)");
			String opcion = sc.nextLine();
			opcion = opcion.toLowerCase();
			if (opcion.equals("n")) {
				System.out.println("Saliendo de las modificaciones");
				salida = true;
			}

		} while (!salida);

		return autor;

	}
	/**
	 * Metodo para borrar autor
	 * @param se le paasa autor
	 * @param se le pasa lista de autores
	 * @return
	 */
	public Autores BorrarAutor(Autores autor, Autores[] listaAutores) {
		autor = null;
		return autor;
	}
	/**
	 * Metodo para listar autores
	 * @param se le pasa lista de autores
	 */
	public void ListarAutores(Autores[] listaAutores) {
		int contador = 0;
		for (int i = 0; i < listaAutores.length; i++) {
			if (listaAutores[i] != null) {
				System.out.println(listaAutores[i]);
				contador++;
			}
		}
		if (contador == 0) {
			System.out.println("No hay usuarios");
		}
	}
	/**
	 * Metodo privado para saber si existe autor
	 * @param se le pasa id autor
	 * @param se le pasa listado de autores
	 * @return true o false
	 */
	private boolean ComprobarAutor(int idautor, Autores[] listaAutores) {

		boolean encontrado = false;
		for (int i = 0; i < listaAutores.length && !encontrado; i++) {
			if (listaAutores[i] != null && idautor == listaAutores[i].getAutor()) {
				System.out.println("Ese id ya existe, escribe otro");
				encontrado = true;
			}
		}
		if (!encontrado) {
			System.out.println("id introducido");
			return false;
		} else {
			return true;
		}
	}

}
