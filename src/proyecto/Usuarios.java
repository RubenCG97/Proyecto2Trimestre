package proyecto;

import java.util.Scanner;

import proyecto.Suscripciones.CUOTA;
import proyecto.Suscripciones.TIPO;
/**
 * @author Ruben
 */
public class Usuarios {
	//Atributos de las clases del usuario
	private String nickname;
	private String contrasenna;
	private String nombre;
	private String apellido;
	private String gmail;
	private String cuentaBancaria;
	private int edad;
	private String nacionalidad;
	private Suscripciones suscripcion;

	// Constructores
    /**
     * Constructor vacío de Usuarios.
     */
	public Usuarios() {
	}
	/**
     * Constructor parametrizado de Usuarios.
     * @param nickname El nombre de usuario.
     * @param contrasenna La contraseña del usuario.
     * @param nombre El nombre del usuario.
     * @param apellido El apellido del usuario.
     * @param gmail El correo electrónico del usuario.
     * @param cuentaBancaria La cuenta bancaria del usuario.
     * @param edad La edad del usuario.
     * @param nacionalidad La nacionalidad del usuario.
     * @param suscripcion La suscripción del usuario.
     */
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
	//Metodos públicos
	/**
	 * Metodo para obtener el nickname del usuario
	 * @return el nickname del usuario
	 */
	public String getNickname() {
		return nickname;
	}
	/**
	 * Metodo para establecer el nickname del usuario
	 * @param nickname el nickname del usuario
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	/**
	 * Metodo para obtener la contraseña
	 * @return	la contraseña del usuario
	 */

	public String getContrasenna() {
		return contrasenna;
	}
	/**
	 * Metodo para establecer la contraseña del usuario
	 * @param la contraseña del usuario
	 */

	public void setContrasenna(String contrasenna) {
		this.contrasenna = contrasenna;
	}
	/**
	 * Metodo para obtener el nombre del usuario
	 * @return el nombre del usuario
	 */

	public String getNombre() {
		return nombre;
	}
	/**
	 * Metodo para establecer el nombre del usuario
	 * @param el nombre del usuario
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Metodo para obtener el apellido del usuario
	 * @return el apellido del usuario
	 */
	public String getApellido() {
		return apellido;
	}
	/**
	 * Metodo para establecer el apellido del usuario
	 * @param el apellido del usuario
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	/**
	 * Metodo para obtener el gmail del usuario
	 * @return el gmail del usuario
	 */
	public String getGmail() {
		return gmail;
	}
	/**
	 * Metodo para establecer el gmail del usuario
	 * @param el gmail del usuario
	 */
	public void setGmail(String gmail) {
		this.gmail = gmail;
	}
	/**
	 * Metodo para obtener la cuenta bancaria del usuario
	 * @return la cuenta bancaria del usuario
	 */
	public String getCuentaBancaria() {
		return cuentaBancaria;
	}
	/**
	 * Metodo para establecer la cuenta bancaria del usuario
	 * @param la cuentaBancaria del usuario
	 */
	public void setCuentaBancaria(String cuentaBancaria) {
		this.cuentaBancaria = cuentaBancaria;
	}
	/**
	 * Metodo para obtener la edad del usuario
	 * @return la edad del usuario
	 */
	public int getEdad() {
		return edad;
	}
	/**
	 * Metodo para establecer la edad del usuario
	 * @param la edad del usuario
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}

	/**
	 * Metodo para obtener la nacionalidad del usuario
	 * @return la nacionalidad del usuario
	 */
	public String getNacionalidad() {
		return nacionalidad;
	}
	/**
	 * Metodo para establecer la nacionalidad del usuario
	 * @param la nacionalidad del usuario
	 */
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	/**
	 * Metodo para obtener la suscripcion del usuario
	 * @return la suscripcion del usuario
	 */
	public Suscripciones getSuscripcion() {
		return suscripcion;
	}
	/**
	 * Metodo para establecer la suscripcion del usuario
	 * @param la suscripcion del usuario
	 */
	public void setSuscripcion(Suscripciones suscripcion) {
		this.suscripcion = suscripcion;
	}
	
	@Override
	/**
	 * Metodo para mostrar la informacion del usuario
	 */
	public String toString() {
		return "Usuarios [nickname=" + nickname + ", contrasenna=" + contrasenna + ", nombre=" + nombre + ", apellido="
				+ apellido + ", gmail=" + gmail + ", cuentaBancaria=" + cuentaBancaria + ", edad=" + edad
				+ ", nacionalidad=" + nacionalidad + ", suscripcion=" + suscripcion + "]";
	}
	/**
	 * Metodo para crear el usuario
	 * @param Se le pasa como parametra un array de la lista de usuarios 
	 * @return devuelve una instancia de usuario y se guarda en la lista de usuarios
	 */
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
	/**
	 * Metodo para modificar atributos del usuario
	 * @param usuario
	 * @param listaUsuario
	 * @return devuelve el usuario actualizado
	 */
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
	/**
	 * Metodo para borrar usuario
	 * @param usuario
	 * @param listaUsuarios
	 * @return devuelve el usuario vacio
	 */
	public Usuarios BorrarUsuario(Usuarios usuario, Usuarios[] listaUsuarios) {

		usuario = null;
		return usuario;

	}
	/**
	 * Metodo para mostrar todos los usuarios creados
	 * @param listaUsuarios
	 */
	public void ListarUsuarios(Usuarios[] listaUsuarios) {
		int contador = 0;
		for (int i = 0; i < listaUsuarios.length; i++) {
			if (listaUsuarios[i] != null) {
				System.out.println(listaUsuarios[i]);
				contador++;
			}
		}
		if (contador == 0) {
			System.out.println("No hay usuarios");
		}
	}
	/**
	 * Metodo privado para asegurar que el nickname es unico
	 * @param nickname
	 * @param listaUsuarios
	 * @return boolean
	 */
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
	/**
	 * Metodo privado para crear suscripcion
	 * @return la suscripcion escogida
	 */
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
