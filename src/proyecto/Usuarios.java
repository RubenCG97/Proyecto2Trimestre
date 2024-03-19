package proyecto;

import java.util.Scanner;

import proyecto.Suscripciones.CUOTA;
import proyecto.Suscripciones.TIPO;

public class Usuarios {

	private String nickname;
	private String contrasenna;
	private String nombre;
	private String apellido;
	private String gmail;
	private String cuentaBancaria;
	private int edad;
	private String nacionalidad;
	private Suscripciones suscripcion;

	public Usuarios() {
	}

	public Usuarios(String nickname, String contrasenna, String nombre, String apellido, String gmail,
			String cuentaBancaria, int edad, String nacionalidad, Suscripciones suscripcion) {
		this.nickname = nickname;
		this.contrasenna = contrasenna;
		this.nombre = nombre;
		this.apellido = apellido;
		this.gmail = gmail;
		this.cuentaBancaria = cuentaBancaria;
		this.edad = edad;
		this.nacionalidad = nacionalidad;
		this.suscripcion = suscripcion;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getContrasenna() {
		return contrasenna;
	}

	public void setContrasenna(String contrasenna) {
		this.contrasenna = contrasenna;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getGmail() {
		return gmail;
	}

	public void setGmail(String gmail) {
		this.gmail = gmail;
	}

	public String getCuentaBancaria() {
		return cuentaBancaria;
	}

	public void setCuentaBancaria(String cuentaBancaria) {
		this.cuentaBancaria = cuentaBancaria;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public Suscripciones getSuscripcion() {
		return suscripcion;
	}

	public void setSuscripcion(Suscripciones suscripcion) {
		this.suscripcion = suscripcion;
	}

	@Override
	public String toString() {
		return "Usuarios [nickname=" + nickname + ", contrasenna=" + contrasenna + ", nombre=" + nombre + ", apellido="
				+ apellido + ", gmail=" + gmail + ", cuentaBancaria=" + cuentaBancaria + ", edad=" + edad
				+ ", nacionalidad=" + nacionalidad + ", suscripcion=" + suscripcion + "]";
	}

	public Usuarios CrearUsuario(Usuarios[] listaUsuarios) {
		var sc = new Scanner(System.in);

		String nickname;
		Usuarios usuario = new Usuarios();

		do {
			System.out.println("Introduce un nickname: ");
			nickname = sc.nextLine();
			nickname = nickname.toLowerCase();
		} while (ComprobarNickname(nickname, listaUsuarios));

		usuario.setNickname(nickname);

		String contrasenna, otraContrasenna;
		do {
			System.out.println("Introduce la contraña");
			contrasenna = sc.nextLine();
			System.out.println("Vuelve a introducir la contraseña");
			otraContrasenna = sc.nextLine();
		} while (!ComprobarContrasenna(contrasenna, otraContrasenna));

		usuario.setContrasenna(contrasenna);

		System.out.println("Introduce tu nombre");
		String nombre = sc.nextLine();

		usuario.setNombre(nombre);

		System.out.println("Introduce tus apellidos");
		String apellido = sc.nextLine();

		usuario.setApellido(apellido);

		System.out.println("Introduce tu edad");
		int edad = sc.nextInt();

		usuario.setEdad(edad);

		sc.nextLine();

		System.out.println("Introduce tu correo electrónico");
		String gmail = sc.nextLine();

		usuario.setGmail(gmail);

		System.out.println("Introduce tu cuenta Bancaria");
		String CB = sc.nextLine();

		usuario.setCuentaBancaria(CB);

		System.out.println("Introduce tu nacionalidad");
		String nacionalidad = sc.nextLine();

		usuario.setNacionalidad(nacionalidad);

		System.out.println("Introduce el tipo de suscripción que tendrá la cuenta");
		usuario.setSuscripcion(crearSuscripcion());

		return usuario;

	}

	public Usuarios ModificarUsuario(Usuarios usuario, Usuarios[] listaUsuario) {
		var sc = new Scanner(System.in);

		boolean salida = false;

		do {
			System.out.println(
					"Que desea modificar del usuario (nickname/contrasenna/nombre/apellido/edad/gmail/cb/nacionalidad/suscripcion)");
			String eleccion = sc.nextLine();
			eleccion = eleccion.toLowerCase();

			switch (eleccion) {

			case "nickname":
				String nicknameNuevo;
				do {
					System.out.println("Introduce el nuevo nickname: ");
					nicknameNuevo = sc.nextLine();
					nicknameNuevo = nicknameNuevo.toLowerCase();

					if (nicknameNuevo.equals(usuario.getNickname())) {
						System.out.println("Es el mismo");
					}

				} while (ComprobarNickname(nicknameNuevo, listaUsuario));
				usuario.setNickname(nicknameNuevo);
				break;
			case "contraseña":
				String contrasennaNueva, otraContrasennaNueva;
				do {
					System.out.println("Introduce la nueva contraseña");

					contrasennaNueva = sc.nextLine();
					System.out.println("Vuelve a introducirla");

					otraContrasennaNueva = sc.nextLine();

				} while (!ComprobarContrasenna(contrasennaNueva, otraContrasennaNueva));
				usuario.setContrasenna(contrasennaNueva);
				break;

			case "nombre":
				System.out.println("Introduce el nuevo nombre");
				String nuevoNombre = sc.nextLine();
				usuario.setNombre(nuevoNombre);
				break;

			case "apellido":
				System.out.println("Introduce el nuevo apellido");
				String apellidoNuevo = sc.nextLine();
				usuario.setApellido(apellidoNuevo);
				break;

			case "edad":
				System.out.println("Introduce la nueva edad");
				int edadnueva = sc.nextInt();
				sc.nextLine();
				usuario.setEdad(edadnueva);
				break;

			case "gmail":
				System.out.println("Introduce el nuevo correo");
				String nuevoCorreo = sc.nextLine();
				usuario.setGmail(nuevoCorreo);
				break;
			case "cb":
				System.out.println("Introduce la nueva cuenta bancaria");
				String cbnueva = sc.nextLine();
				usuario.setGmail(cbnueva);
				break;
			case "nacionalidad":
				System.out.println("Introduce la nueva nacionalidad");
				String nacionalidad = sc.nextLine();
				usuario.setNacionalidad(nacionalidad);
				break;
			case "suscripcion":
				System.out.println("Introduce la nueva suscripcion");
				usuario.setSuscripcion(crearSuscripcion());
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

		return usuario;

	}
	
	public Usuarios BorrarUsuario(Usuarios usuario,Usuarios[] listaUsuarios) {
		
		usuario=null;
		return usuario;
		
	}
	
	public void ListarUsuarios(Usuarios[]listaUsuarios) {
		int contador=0;
		for(int i=0;i<listaUsuarios.length;i++) {
			if(listaUsuarios[i]!=null) {
				System.out.println(listaUsuarios[i]);
				contador++;
			}
		}
		if(contador==0) {
			System.out.println("No hay usuarios");
		}
	}

	private boolean ComprobarNickname(String nickname, Usuarios[] listaUsuarios) {

		boolean encontrado = false;
		for (int i = 0; i < listaUsuarios.length && !encontrado; i++) {
			if (listaUsuarios[i] != null && nickname.equals(listaUsuarios[i].getNickname())) {
				System.out.println("Ese nickname ya existe, escribe otro");
				encontrado = true;
			}
		}
		if (!encontrado) {
			System.out.println("Nickname introducido");
			return false;
		} else {
			return true;
		}
	}

	private boolean ComprobarContrasenna(String contrasenna, String otraContrasenna) {

		if (contrasenna.equals(otraContrasenna)) {
			System.out.println("Contraseña introducida");
			return true;
		} else {
			System.out.println("No coinciden, vuelve a introducirla");
			return false;
		}
	}

	private Suscripciones crearSuscripcion() {
		var sc = new Scanner(System.in);

		Suscripciones suscripcion = new Suscripciones();

		boolean tipo;
		do {

			System.out.println("Introduce el tipo de suscripcion: (individual/duo/familiar)");
			String eleccion = sc.nextLine();
			eleccion = eleccion.toLowerCase();
			tipo = false;

			switch (eleccion) {
			case "individual":
				suscripcion.setTipo(TIPO.INDIVIDUAL);
				tipo = true;
				break;
			case "duo":
				suscripcion.setTipo(TIPO.DUO);
				tipo = true;
				break;
			case "familiar":
				suscripcion.setTipo(TIPO.FAMILIAR);
				tipo = true;
				break;
			default:
				System.out.println("Elección introducida incorrecta");
				break;

			}
		} while (!tipo);

		boolean cuota;
		do {
			System.out.println("Introduce el tipo de cuota de la suscripcion (mensual/anual)");
			String eleccion = sc.nextLine();
			eleccion = eleccion.toLowerCase();
			cuota = false;

			switch (eleccion) {
			case "mensual":
				suscripcion.setCuota(CUOTA.MENSUAL);
				cuota = true;
				break;
			case "anual":
				suscripcion.setCuota(CUOTA.ANUAL);
				cuota = true;
				break;
			default:
				System.out.println("Elección introcida incorrecta");
			}

		} while (!cuota);
		suscripcion.getPrecio();

		return suscripcion;

	}

}
