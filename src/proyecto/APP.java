
package proyecto;

import java.util.Scanner;

public class APP {

	public static void main(String[] args) {
		var sc = new Scanner(System.in);

		Usuarios[] listaUsuarios = new Usuarios[100];
		Autores[] listaAutores = new Autores[100];
		Publicaciones[] listaPublicaciones=new Publicaciones[100];

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
						                modificado = true;
						            } else {
						            	 listaPublicaciones[i] = ((Ebooks) listaPublicaciones[i]).BorrarPublicacion(listaPublicaciones[i], listaPublicaciones);
							                modificado = true;
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

	public static int menu() {
		var sc = new Scanner(System.in);
		int eleccion;
		System.out.println("------------------");
		System.out.println("1.CRUD USUARIOS");
		System.out.println("2.CRUD AUTORES");
		System.out.println("3.CRUD PUBLICACIONES");
		System.out.println("4.OPCIONES");
		System.out.println("5.Salir");
		System.out.println("------------------");
		System.out.println("Introduce una opción: ");
		eleccion = sc.nextInt();
		return eleccion;
	}

	public static int menuCRUDUsuarios() {
		var sc = new Scanner(System.in);
		int eleccion;
		System.out.println("------------------");
		System.out.println("1.CREAR USUARIO");
		System.out.println("2.MODIFICAR USUARIOS");
		System.out.println("3.BORRAR USUARIOS");
		System.out.println("4.LISTAR USUARIOS");
		System.out.println("5.Salir");
		System.out.println("------------------");
		System.out.println("Introduce una opcion: ");
		eleccion = sc.nextInt();
		return eleccion;
	}

	public static int menuCRUDAutores() {
		var sc = new Scanner(System.in);
		int eleccion;
		System.out.println("------------------");
		System.out.println("1.CREAR AUTOR");
		System.out.println("2.MODIFICAR AUTOR");
		System.out.println("3.BORRAR AUTOR");
		System.out.println("4.LISTAR AUTORES");
		System.out.println("5.Salir");
		System.out.println("------------------");
		System.out.println("Introduce una opción: ");
		eleccion = sc.nextInt();
		return eleccion;
	}
	
	public static int menuCrudPublicaciones() {
		var sc = new Scanner(System.in);
		int eleccion;
		System.out.println("------------------");
		System.out.println("1.CREAR PUBLICACION");
		System.out.println("2.MODIFICAR PUBLICACION");
		System.out.println("3.BORRAR PUBLICACION");
		System.out.println("4.LISTAR PUBLICACIONES");
		System.out.println("5.Salir");
		System.out.println("------------------");
		System.out.println("Introduce una opción: ");
		eleccion = sc.nextInt();
		return eleccion;
	}

}
