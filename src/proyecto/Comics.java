package proyecto;

import java.util.Scanner;



public class Comics extends Publicaciones {

	enum COLOR {
		SI, NO
	}

	protected COLOR color;

	public Comics() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Comics(int iSBN, String titulo, Autores autor, String descripcion, String editorial, int numPag,
			GENERO genero, GENERO subgenero,COLOR color) {
		super(iSBN, titulo, autor, descripcion, editorial, numPag, genero);
		this.color=color;
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

	public Comics CrearPublicacion(Publicaciones[] listaPublicaciones, Autores[] listaAutores) {
		var sc=new Scanner(System.in);
		Comics comic=new Comics();
	
		int isbn;
        do {
            System.out.println("Introduce el ISBN:");
            isbn = sc.nextInt();
        } while (ComprobarISBN(isbn, listaPublicaciones));
        comic.setISBN(isbn);
		
		sc.nextLine();
		System.out.println("Introduce el titulo de la obra");
		String titulo = sc.nextLine();
		
		comic.setTitulo(titulo);
		
		int id;
		boolean encontrado;
		Autores autor = new Autores();
		do {
			encontrado = false;
			System.out.println("Introduce el id del autor de la obra");
			id = sc.nextInt();
			for (int i = 0; i < listaAutores.length && !encontrado; i++) {
				if (listaAutores[i] != null && listaAutores[i].getAutor() == id) {
					autor = listaAutores[i];
					encontrado = true;
				}
			}
			if (!encontrado) {
				System.out.println("No se encontró ese id de autor");
				System.out.println("No se puede crear una obra sin autor,volviendo al menu");
				return null;
			}
		} while (!encontrado);
		
		comic.setAutor(autor);
		
		sc.nextLine();
		System.out.println("Introduce una descripción de la obra");
		String descripcion = sc.nextLine();
		
		comic.setDescripcion(descripcion);
		System.out.println("Introduce el número de paginas de la obra");
		
		int numPag;
		do {
			numPag = sc.nextInt();
		} while (!(numPag > 0));
		
		sc.nextLine();
		comic.setNumPag(numPag);
		boolean encontradoGenero;
		do {
			encontradoGenero=false;
			System.out.println(
					"Introduce el género de la obra (Novela contemporanea/Poesia/Ciencia ficcion y fantasia/Misterio y triller/Literatura Juvenil/No ficcion/Terror/Romance/Clasicos literarios/Cuentos Cortos )");
			String eleccion = sc.nextLine();
			eleccion = eleccion.toLowerCase();
			GENERO genero = null;
			switch (eleccion) {

			case "novela comteporanea":
				genero = GENERO.NOVELACOMTEPORANEA;
				encontradoGenero=true;
				break;
			case "poesia":
				genero = GENERO.POESIA;
				encontradoGenero=true;
				break;
			case "ciencia ficcion Y fantasia":
				genero = GENERO.CC_Y_FANTASIA;
				encontradoGenero=true;
				break;
			case "misterio y thriller":
				genero = GENERO.MISTERIO_Y_TRHILLER;
				encontradoGenero=true;
				break;
			case "literatura juvenil":
				genero = GENERO.LITERATURAJUVENIL;
				encontradoGenero=true;
				break;
			case "no ficcion":
				genero = GENERO.NOFICCION;
				encontradoGenero=true;
				break;
			case "terror":
				genero = GENERO.TERROR;
				encontradoGenero=true;
				break;
			case "romance":
				genero = GENERO.ROMANCE;
				encontradoGenero=true;
				break;
			case "clasicos literarios":
				genero = GENERO.CLASICOSLITERARIOS;
				encontradoGenero=true;
				break;
			case "cuentos cortos":
				genero = GENERO.CUENTOSCORTOS;
				encontradoGenero=true;
				break;
			default:
				System.out.println("No se encontró el género");
				break;
			}
			comic.setGenero(genero);
		}while(!encontradoGenero);
		
		
		boolean color;
		
		do {
			
			color=false;
			System.out.println("Introduce si tiene color o no el comic (s/n)");
			String elecColor=sc.nextLine();
			elecColor=elecColor.toLowerCase();
			switch(elecColor) {
			
			case "s":
				comic.setColor(COLOR.SI);
				color=true;
			break;
			case "n":
				comic.setColor(COLOR.NO);
				color=true;
			break;
			default:System.out.println("Error de elección");
			break;
			}
		
		}while(!color);
		

		return comic;
	}
	
	public Comics ModificarPublicacion(Publicaciones listaPublicaciones, Autores[] listaAutores, Publicaciones[] listaPublicaciones2) {
	    var sc = new Scanner(System.in);

	    boolean salida = false;

	    do {
	    	System.out.println("Que desea modificar de la publicacion (isbn/titulo/autor/descripcion/numpag/genero/color)");
	        String opcion = sc.nextLine().toLowerCase();

	        switch (opcion) {
	            case "isbn":
	                int nuevoISBN;
	                do {
	                    System.out.println("Introduce el nuevo ISBN:");
	                    nuevoISBN = sc.nextInt();
	                    sc.nextLine(); 
	                } while (ComprobarISBN(nuevoISBN, listaPublicaciones2));
	                listaPublicaciones.setISBN(nuevoISBN);
	                break;
	            case "titulo":
	                System.out.println("Introduce el nuevo título:");
	                String nuevoTitulo = sc.nextLine();
	                listaPublicaciones.setTitulo(nuevoTitulo);
	                break;
	            case "autor":
	                System.out.println("Introduce el nuevo ID del autor:");
	                int idAutor = sc.nextInt();
	                sc.nextLine(); 
	                boolean encontrado = false;
	                for (Autores autor : listaAutores) {
	                    if (autor != null && autor.getAutor() == idAutor) {
	                    	listaPublicaciones.setAutor(autor);
	                        encontrado = true;
	                        break;
	                    }
	                }
	                if (!encontrado) {
	                    System.out.println("No se encontró ese ID de autor.");
	                }
	                break;
	            case "descripcion":
	                System.out.println("Introduce la nueva descripción:");
	                String nuevaDescripcion = sc.nextLine();
	                listaPublicaciones.setDescripcion(nuevaDescripcion);
	                break;
	            case "numpag":
	                System.out.println("Introduce el nuevo número de páginas:");
	                int nuevasPaginas = sc.nextInt();
	                sc.nextLine();
	                listaPublicaciones.setNumPag(nuevasPaginas);
	                break;
	            case "genero":
	                System.out.println("Introduce el nuevo género:");
	                String nuevoGeneroStr = sc.nextLine().toLowerCase();
	                GENERO nuevoGenero = null;
	                switch (nuevoGeneroStr) {
	                    case "novela contemporanea":
	                        nuevoGenero = GENERO.NOVELACOMTEPORANEA;
	                        break;
	                    case "poesia":
	                        nuevoGenero = GENERO.POESIA;
	                        break;
	                    case "ciencia ficcion y fantasia":
	                        nuevoGenero = GENERO.CC_Y_FANTASIA;
	                        break;
	                    case "misterio y thriller":
	                        nuevoGenero = GENERO.MISTERIO_Y_TRHILLER;
	                        break;
	                    case "literatura juvenil":
	                        nuevoGenero = GENERO.LITERATURAJUVENIL;
	                        break;
	                    case "no ficcion":
	                        nuevoGenero = GENERO.NOFICCION;
	                        break;
	                    case "terror":
	                        nuevoGenero = GENERO.TERROR;
	                        break;
	                    case "romance":
	                        nuevoGenero = GENERO.ROMANCE;
	                        break;
	                    case "clasicos literarios":
	                        nuevoGenero = GENERO.CLASICOSLITERARIOS;
	                        break;
	                    case "cuentos cortos":
	                        nuevoGenero = GENERO.CUENTOSCORTOS;
	                        break;
	                    default:
	                        System.out.println("Género no válido.");
	                        break;
	                }
	                break;
	            case "color":
	                System.out.println("Introduce el nuevo color ('si' o 'no'):");
	                String nuevoColorStr = sc.nextLine().toLowerCase();
	                COLOR nuevoColor = null;
	                switch (nuevoColorStr) {
	                    case "si":
	                        nuevoColor = COLOR.SI;
	                        break;
	                    case "no":
	                        nuevoColor = COLOR.NO;
	                        break;
	                    default:
	                        System.out.println("Color no válido.");
	                        break;
	                }
	                break;
	            case "salir":
	                System.out.println("Saliendo de las modificaciones.");
	                salida = true;
	                break;
	            default:
	                System.out.println("Opción no válida.");
	                break;
	        }
	        System.out.println(
					"Quieres continuar con las modificaciones (n para salir, cualquier otra tecla para continuar)");
			String opcionMod = sc.nextLine();
			opcionMod = opcionMod.toLowerCase();
			if (opcionMod.equals("n")) {
				System.out.println("Saliendo de las modificaciones");
				salida = true;
			}
	    } while (!salida);

	    return (Comics) listaPublicaciones;
	}
	
	public Comics BorrarPublicacion(Comics comic, Publicaciones[] listaPublicaciones) {

		comic = null;
		return comic;

	}
	
	private boolean ComprobarISBN(int isbn, Publicaciones[] listaPublicaciones) {

		boolean encontrado = false;
		for (int i = 0; i < listaPublicaciones.length && !encontrado; i++) {
			if (listaPublicaciones[i] != null && isbn == listaPublicaciones[i].getISBN()) {
				System.out.println("Ese isbn ya existe, escribe otro");
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
