
package proyecto;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import proyecto.Publicaciones.GENERO;
import proyecto.Suscripciones.CUOTA;
import proyecto.Suscripciones.TIPO;

public class APP {

	public static void main(String[] args) {
		var sc = new Scanner(System.in);

		Usuarios[] listaUsuarios = new Usuarios[100];
		listaUsuarios[0] = new Usuarios("user1", "password1", "John", "Doe", "john.doe@example.com", "1234567890", 30, "USA", new Suscripciones(TIPO.INDIVIDUAL, CUOTA.MENSUAL));
		listaUsuarios[1]= new Usuarios("user2", "password2", "Alice", "Smith", "alice.smith@example.com", "0987654321", 25, "UK", new Suscripciones(TIPO.DUO, CUOTA.ANUAL));
		listaUsuarios[2] = new Usuarios("user3", "password3", "Bob", "Johnson", "bob.johnson@example.com", "1357924680", 40, "Canada", new Suscripciones(TIPO.FAMILIAR, CUOTA.MENSUAL));
		Autores[] listaAutores = new Autores[100];
		listaAutores[0] = new Autores(1, "J.K. Rowling", "British author, best known for writing the Harry Potter fantasy series.");
		listaAutores[1] = new Autores(2, "George R.R. Martin", "American novelist and short story writer, best known for his series of epic fantasy novels A Song of Ice and Fire.");
		listaAutores[2] = new Autores(3, "Stephen King", "American author of horror, supernatural fiction, suspense, crime, science-fiction, and fantasy novels.");
		Publicaciones[] listaPublicaciones=new Publicaciones[100];
		listaPublicaciones[0]= new Comics(1, "Harry Potter and the Philosopher's Stone", listaAutores[0], "First book in the Harry Potter series.", "Bloomsbury Publishing", 223, GENERO.CC_Y_FANTASIA, Comics.COLOR.NO);
		listaPublicaciones[1] = new Ebooks(2, "A Game of Thrones",listaAutores[1], "First book in the A Song of Ice and Fire series.", "Bantam Spectra", 694, GENERO.CC_Y_FANTASIA, "9780553573404");
		listaPublicaciones[2] = new Ebooks(3, "Entertainment Weekly",listaAutores[2], "American magazine covering film, television, music, theater, books, and popular culture.", "Meredith Corporation", 112, GENERO.NOVELACOMTEPORANEA,"123");
		Resenas[] listaResenas=new Resenas[10];
		listaResenas[0] = new Resenas(listaPublicaciones[0], listaUsuarios[0], "Una obra maestra, ¡me encantó!", 5);
		listaResenas[1] = new Resenas(listaPublicaciones[1], listaUsuarios[1], "Interesante historia, pero un poco lenta al principio.", 4);
		listaResenas[2] = new Resenas(listaPublicaciones[2], listaUsuarios[2], "No me gustó mucho, esperaba más.", 3);
		listaResenas[3] = new Resenas(listaPublicaciones[0], listaUsuarios[2], "Increíble, definitivamente lo recomendaría a todos.", 5);
		listaResenas[4] = new Resenas(listaPublicaciones[1], listaUsuarios[0], "Una historia fascinante, no podía dejar de leer.", 5);
		listaResenas[5] = new Resenas(listaPublicaciones[2], listaUsuarios[1], "Me pareció aburrido y predecible.", 2);
		listaResenas[6] = new Resenas(listaPublicaciones[0], listaUsuarios[2], "Buen libro, pero un poco sobrevalorado en mi opinión.", 4);
		listaResenas[7] = new Resenas(listaPublicaciones[1], listaUsuarios[2], "Me encantó, lo leería de nuevo.", 5);
		listaResenas[8] = new Resenas(listaPublicaciones[2], listaUsuarios[0], "No fue lo que esperaba, algo decepcionante.", 3);
		listaResenas[9] = new Resenas(listaPublicaciones[0], listaUsuarios[1], "Lo disfruté mucho, lo recomendaría a cualquier fanático de la fantasía.", 5);


		int eleccion;
		do {
			eleccion = menu();
			switch (eleccion) {
			case 1:
				System.out.println("CRUD USUARIOS");
				int eleccionCrudUsu;
				do {
					eleccionCrudUsu = menuCRUDUsuarios();
					switch (eleccionCrudUsu) {
					case 1:
						System.out.println("Creando usuario");
						boolean creado = false;
						for (int i = 0; i < listaUsuarios.length && !creado; i++) {
							if (listaUsuarios[i] == null) {
								Usuarios usuario = new Usuarios();
								listaUsuarios[i] = usuario.CrearUsuario(listaUsuarios);
								creado = true;
							}
						}
						break;
					case 2:
						System.out.println("Modifica usuario");
						System.out.println("Introduce el nickname del usuario a modificar");
						String nickname = sc.nextLine();
						nickname = nickname.toLowerCase();
						boolean modificado = false;
						for (int i = 0; i < listaUsuarios.length && !modificado; i++) {
							if (listaUsuarios[i] != null && nickname.equals(listaUsuarios[i].getNickname())) {
								listaUsuarios[i] = listaUsuarios[i].ModificarUsuario(listaUsuarios[i], listaUsuarios);
								modificado = true;
							}

							
						}
						if (!modificado) {
							System.out.println("No se encontró ese nickname");
						}
						break;
					case 3:
						System.out.println("Elimina a un usuario");
						System.out.println("Introduce el nickname del usuario para eliminarlo");
						String nicknameborrar = sc.nextLine();
						nicknameborrar = nicknameborrar.toLowerCase();
						boolean borrar = false;
						for (int i = 0; i < listaUsuarios.length && !borrar; i++) {
							if (listaUsuarios[i] != null && nicknameborrar.equals(listaUsuarios[i].getNickname())) {
								listaUsuarios[i] = listaUsuarios[i].BorrarUsuario(listaUsuarios[i], listaUsuarios);
								borrar = true;
							}
						}
						if (!borrar) {
							System.out.println("No se encontró ese nickname");
						}
						break;
					case 4:
						System.out.println("Lista de usuarios");
						Usuarios usuario = new Usuarios();
						usuario.ListarUsuarios(listaUsuarios);
						break;
					case 5:
						System.out.println("Saliendo del CRUD de usuarios");
						break;
					default:
						System.out.println("Elección incorrecta");
						break;
					}
				} while (eleccionCrudUsu != 5);
				break;
			case 2:
				int eleccionCrudAutor;
				do {
					System.out.println("CRUD AUTORES");
					eleccionCrudAutor = menuCRUDAutores();
					switch (eleccionCrudAutor) {
					case 1:
						System.out.println("Creando autor");
						boolean creado = false;
						for (int i = 0; i < listaAutores.length && !creado; i++) {
							if (listaAutores[i] == null) {
								Autores autor = new Autores();
								listaAutores[i] = autor.CrearAutor(listaAutores);
								creado = true;
							}
						}
						break;
					case 2:
						System.out.println("Modificando autor");
						System.out.println("Introduce el id del autor a modificar");
						int id = sc.nextInt();
						boolean modificado = false;
						for (int i = 0; i < listaAutores.length && !modificado; i++) {
							if (listaAutores[i] != null && listaAutores[i].getAutor() == id) {
								listaAutores[i] = listaAutores[i].ModificarAutor(listaAutores[i], listaAutores);
								modificado = true;
							}

						}
						if (!modificado) {
							System.out.println("No se encontró ese id");
						}
						break;
					case 3:
						System.out.println("Elimina a un Autor");
						System.out.println("Introduce el id del autor para eliminarlo");
						int idborrar = sc.nextInt();
						boolean borrar = false;
						for (int i = 0; i < listaAutores.length && !borrar; i++) {
							if (listaAutores[i] != null && idborrar == listaAutores[i].getAutor()) {
								listaAutores[i] = listaAutores[i].BorrarAutor(listaAutores[i], listaAutores);
								borrar = true;
							}
						}
						if (!borrar) {
							System.out.println("No se encontró ese id");
						}
						break;
					case 4:
						System.out.println("Lista de Autores");
						Autores autor = new Autores();
						autor.ListarAutores(listaAutores);
						break;
					case 5:
						System.out.println("Saliendo del CRUD de autores");
						break;
					default:
						System.out.println("Elección incorrecta");
						break;
					}
				} while (eleccionCrudAutor != 5);
				break;
			case 3:
				int eleccionCrudPublicaciones;
				do {
					System.out.println("CRUD PUBLICACIONES");
					eleccionCrudPublicaciones=menuCrudPublicaciones();
					
					switch(eleccionCrudPublicaciones) {
					
					case 1:
						System.out.println("Creando publicacion");
						System.out.println("Introduce ebooks o  comics");
						String eleccionPublicacion=sc.nextLine();
						eleccionPublicacion=eleccionPublicacion.toLowerCase();
						switch(eleccionPublicacion) {
						case "ebooks":
							boolean creado = false;
							for (int i = 0; i < listaPublicaciones.length && !creado; i++) {
								if (listaPublicaciones[i] == null) {
									Ebooks ebook = new Ebooks();
									listaPublicaciones[i] = ebook.CrearPublicacion(listaPublicaciones,listaAutores);
									creado = true;
								}
							}
							break;
						case "comics":
							boolean creadocomic = false;
							for (int i = 0; i < listaPublicaciones.length && !creadocomic; i++) {
								if (listaPublicaciones[i] == null) {
									Comics comic = new Comics();
									listaPublicaciones[i] = comic.CrearPublicacion(listaPublicaciones,listaAutores);
									creadocomic = true;
								}
							}
							break;
							
						default:System.out.println("Error al introducir la opcion");break;
						
						}
					break;	
					case 2:
					    System.out.println("Modificando publicacion");
					    System.out.println("Introduce el isbn de la publicacion");
					    int isbn = sc.nextInt();
					    boolean modificado = false;
					    for (int i = 0; i < listaPublicaciones.length && !modificado; i++) {
					        if (listaPublicaciones[i] != null && listaPublicaciones[i].getISBN() == isbn) {
					            if (listaPublicaciones[i] instanceof Comics) {
					                listaPublicaciones[i] = ((Comics) listaPublicaciones[i]).ModificarPublicacion(listaPublicaciones[i],listaAutores, listaPublicaciones);
					                modificado = true;
					            } else {
					            	 listaPublicaciones[i] = ((Ebooks) listaPublicaciones[i]).ModificarPublicacion(listaPublicaciones[i],listaAutores, listaPublicaciones);
						                modificado = true;
					            }
					        }
					    }
					    if (!modificado) {
					        System.out.println("No se encontró ese isbn");
					    }
					    break;
					case 3:
						System.out.println("Borrando Publicaciones");
						 System.out.println("Introduce el isbn de la publicacion");
						    int isbnBorrar = sc.nextInt();
						    boolean Borrar = false;
						    for (int i = 0; i < listaPublicaciones.length && !Borrar; i++) {
						        if (listaPublicaciones[i] != null && listaPublicaciones[i].getISBN() == isbnBorrar) {
						            if (listaPublicaciones[i] instanceof Comics) {
						                listaPublicaciones[i] = ((Comics) listaPublicaciones[i]).BorrarPublicacion(listaPublicaciones[i], listaPublicaciones);
						                Borrar = true;
						            } else {
						            	 listaPublicaciones[i] = ((Ebooks) listaPublicaciones[i]).BorrarPublicacion(listaPublicaciones[i], listaPublicaciones);
						            	 Borrar = true;
						            }
						        }
						    }
						    if (!Borrar) {
						        System.out.println("No se encontró ese isbn");
						    }
						
						break;
					case 4:
						System.out.println("Mostrar Publicaciones");
						int contador = 0;
						for (int i = 0; i < listaPublicaciones.length; i++) {
							if (listaPublicaciones[i] != null) {
								System.out.println(listaPublicaciones[i]);
								contador++;
							}
						}
						if (contador == 0) {
							System.out.println("No hay Publicaciones");
						}
						
					}
					
				}while(eleccionCrudPublicaciones!=5);

				break;
			case 4:
				int eleccionUsu;
				do {
					eleccionUsu=menuUsuario();
					
					switch(eleccionUsu){
					
					case 1:
						boolean creado = false;
					for(int i=0;i<listaResenas.length && !creado;i++) {
						if(listaResenas[i]==null) {
							Resenas resena=new Resenas();
							listaResenas[i]=resena.CrearRESENNA(listaPublicaciones, listaUsuarios);
							creado=true;
						}
					}
						
					break;
					case 2:
						Resenas resena=new Resenas();
						resena.BorrarResenas(listaResenas);
						
					break;
					case 3:
						Resenas listarresena=new Resenas();
						listarresena.ListarResenas(listaResenas);
					break;
					case 4:
						Arrays.sort(listaResenas);
						for ( Resenas resenas : listaResenas) {
							System.out.println(resenas);
						}
					break;
					case 5:
						Arrays.sort(listaResenas, Resenas.PuntuacionComparator); 

				        for (Resenas resenas : listaResenas) {
				            System.out.println(resenas);
				        }
					break;
					case 6:
						System.out.println("Introduzca el isbn del libro");
						Resenas resenas = new Resenas();
						int isbn=sc.nextInt();
						double puntuacionMedia =resenas.calcularPuntuacionMediaPorISBN( isbn, listaResenas);
						System.out.println(puntuacionMedia);
					break;
					}
				}
				while(eleccionUsu!=8);
				break;
			case 5:
				System.out.println("Saliendo del programa");
				break;
			default:
				System.out.println("Elección incorrecta");
				break;
			}
		} while (eleccion != 5);
	}


	/**
	 * Menu principal
	 * @return el numero elegido del menu
	 */
	public static int menu() {
	    var sc = new Scanner(System.in);
	    int eleccion = 0;
	    boolean inputValido = false;

	    do {
	        try {
	            System.out.println("------------------");
	            System.out.println("1.CRUD USUARIOS");
	            System.out.println("2.CRUD AUTORES");
	            System.out.println("3.CRUD PUBLICACIONES");
	            System.out.println("4.OPCIONES USUARIOS");
	            System.out.println("5.Salir");
	            System.out.println("------------------");
	            System.out.println("Introduce una opción: ");
	            eleccion = sc.nextInt();
	            inputValido = true;
	        } catch (InputMismatchException e) {
	            System.out.println("Error: Debes introducir un número entero.");
	            sc.nextLine(); // Limpiar el buffer del scanner
	        }
	    } while (!inputValido);

	    return eleccion;
	}
	/**
	 * Menu de usuario
	 * @return el numero elegido del menu
	 */
	public static int menuCRUDUsuarios() {
	    var sc = new Scanner(System.in);
	    int eleccion = 0;
	    boolean inputValido = false;

	    do {
	        try {
	            System.out.println("------------------");
	            System.out.println("1.CREAR USUARIO");
	            System.out.println("2.MODIFICAR USUARIOS");
	            System.out.println("3.BORRAR USUARIOS");
	            System.out.println("4.LISTAR USUARIOS");
	            System.out.println("5.Salir");
	            System.out.println("------------------");
	            System.out.println("Introduce una opción: ");
	            eleccion = sc.nextInt();
	            inputValido = true;
	        } catch (InputMismatchException e) {
	            System.out.println("Error: Debes introducir un número entero.");
	            sc.nextLine(); 
	        }
	    } while (!inputValido);

	    return eleccion;
	}
	/**
	 * Menu de autores
	 * @return el numero elegido del menu
	 */
	public static int menuCRUDAutores() {
	    var sc = new Scanner(System.in);
	    int eleccion = 0;
	    boolean inputValido = false;

	    do {
	        try {
	        	System.out.println("CRUD AUTORES");
	            System.out.println("------------------");
	            System.out.println("1.CREAR AUTOR");
	            System.out.println("2.MODIFICAR AUTOR");
	            System.out.println("3.BORRAR AUTOR");
	            System.out.println("4.LISTAR AUTORES");
	            System.out.println("5.Salir");
	            System.out.println("------------------");
	            System.out.println("Introduce una opción: ");
	            eleccion = sc.nextInt();
	            inputValido = true;
	        } catch (InputMismatchException e) {
	            System.out.println("Error: Debes introducir un número entero.");
	            sc.nextLine(); // Limpiar el buffer del scanner
	        }
	    } while (!inputValido);

	    return eleccion;
	}
	/**
	 * Menu de publicaciones
	 * @return el numero elegido del menu
	 */
	public static int menuCrudPublicaciones() {
	    var sc = new Scanner(System.in);
	    int eleccion = 0;
	    boolean inputValido = false;

	    do {
	        try {
	        	System.out.println("CRUD PUBLICACIONES");
	            System.out.println("------------------");
	            System.out.println("1.CREAR PUBLICACION");
	            System.out.println("2.MODIFICAR PUBLICACION");
	            System.out.println("3.BORRAR PUBLICACION");
	            System.out.println("4.LISTAR PUBLICACIONES");
	            System.out.println("5.SALIR");
	            System.out.println("------------------");
	            System.out.println("Introduce una opción: ");
	            eleccion = sc.nextInt();
	            inputValido = true;
	        } catch (InputMismatchException e) {
	            System.out.println("Error: Debes introducir un número entero.");
	            sc.nextLine(); // Limpiar el buffer del scanner
	        }
	    } while (!inputValido);

	    return eleccion;
	}
	/**
	 * Menu de usuarios
	 * @return el numero del menu
	 */
	public static int menuUsuario() {
	    var sc = new Scanner(System.in);
	    int eleccion = 0;
	    boolean inputValido = false;

	    do {
	        try {
	        	System.out.println("MENU USUARIO");
	            System.out.println("------------------");
	            System.out.println("1.HACER RESEnA");
	            System.out.println("2.BORRAR RESEnA");
	            System.out.println("3.LISTAR TODAS LAS RESEnAS");
	            System.out.println("4.LISTAR DE PEOR A MEJOR RESEnA");
	            System.out.println("5.LISTAR DE MEJOR A PEOR RESEnA");
	            System.out.println("6.PUNTUNACION MEDIA SEGUN PUBLICACION");
	            System.out.println("7.SALIR");
	            System.out.println("------------------");
	            System.out.println("Introduce una opción: ");
	            eleccion = sc.nextInt();
	            inputValido = true;
	        } catch (InputMismatchException e) {
	            System.out.println("Error: Debes introducir un número entero.");
	            sc.nextLine(); 
	        }
	    } while (!inputValido);

	    return eleccion;
	}

}
