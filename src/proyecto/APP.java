package proyecto;

import java.util.Scanner;;

public class APP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		var sc = new Scanner(System.in);
		Usuarios[] listaUsuarios = new Usuarios[100];

		int eleccion;
		do {
			eleccion = menuCRUDUsuarios();

			switch (eleccion) {
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

					if (!modificado) {
						System.out.println("No se encontró ese nickname");
					}
				}

				break;
			case 3:
				System.out.println("Elimina a un usuario");
				System.out.println("Introduce el nickname del usuario para eliminarlo");
				String nicknameborrar = sc.nextLine().toLowerCase();
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
			case 4: System.out.println("Lista de usuarios");
			
			Usuarios usuario=new Usuarios();
			usuario.ListarUsuarios(listaUsuarios);
	
				break;
			case 5: System.out.println("Saliendo del CRUD de usuarios");break;
			default:System.out.println("Elección incorrecta");break;
			
			}
			
		} while (eleccion != 5);

	}
	
	public static int menu() {
		var sc=new Scanner(System.in);
		
		int eleccion;
		
		System.out.println("------------------");
		System.out.println("1.CRUD USUARIOS");
		System.out.println("2.CRUD AUTORES");
		System.out.println("3.CRUD PUBLICACIONES");
		System.out.println("4.OPCIONES");
		System.out.println("5.Salir");
		System.out.println("------------------");
		
		System.out.println("Introduce una opción");
		
		return eleccion;
	}
	
	public static int menuCRUDUsuarios() {
		var sc = new Scanner(System.in);

		int eleccion;

		System.out.println("------------------");
		System.out.println("1.CREAR USUARIO");
		System.out.println("2.MODIFICAR USUARIOS");
		System.out.println("3.BORRAR USUSARIOS");
		System.out.println("4.LISTAR USUARIOS");
		System.out.println("5.Salir");
		System.out.println("------------------");

		System.out.println("Introduce una opcion: ");
		eleccion = sc.nextInt();
		return eleccion;
	}

}
