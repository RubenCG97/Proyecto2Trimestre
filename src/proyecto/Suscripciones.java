package proyecto;
/**
 * @author Ruben
 */
public class Suscripciones {
	
	/**
	 * Enumeracion de los tipos de suscripciones
	 */
	enum TIPO {
		INDIVIDUAL, DUO, FAMILIAR;
	}
	/**
	 * Atributo de clase
	 */
	private TIPO tipo;
	/**
	 * Enumeracion de las cuotas de suscripciones
	 */
	enum CUOTA {
		MENSUAL, ANUAL;
	}
	/**
	 * Atributo de clase
	 */
	private CUOTA cuota;
	/**
	 * Atributo de clase
	 */
	private double precio;
	//Constructores
	/**
	 * Constructor vacio
	 */
	public Suscripciones() {
	}
	/**
	 * Constructor Parametrizado de suscripciones
	 * @param tipo de suscripcion
	 * @param cuota de suscripcion
	 * El precio se calculará con un metodo privado
	 */
	public Suscripciones(TIPO tipo, CUOTA cuota) {
		this.tipo = tipo;
		this.cuota = cuota;
		this.precio = CalculoPrecio();

	}
	// Metodos publicos
	/**
	 * Metodo para obtener el tipo de suscripcion
	 * @return el tipo de suscripcion
	 */
	public TIPO getTipo() {
		return tipo;
	}
	/**
	 * Metodo para establecer el tipo de suscripcion
	 * @param el tipo de sucripcion
	 */
	public void setTipo(TIPO tipo) {
		this.tipo = tipo;
	}
	/**
	 * Metodo para obtener el tipo de cuota de suscripcion
	 * @return el tipo de cuota
	 */
	public CUOTA getCuota() {
		return cuota;
	}
	/**
	 * Metodo para establecer el tipo de cuota de suscripcion
	 * @param el tipo de cuota
	 */
	public void setCuota(CUOTA cuota) {
		this.cuota = cuota;
	}
	/**
	 * Metodo para obtener el precio de la suscripcion
	 * @return el resultado del metodo privado CalculoPrecio()
	 */
	public double getPrecio() {
		return CalculoPrecio();
	}

	@Override
	/**
	 * Metodo para mostrar la informacion de suscripciones
	 */
	public String toString() {
		return "Suscripciones [tipo=" + tipo + ", cuota=" + cuota + ", precio=" + precio + "]";
	}
	/**
	 * Metodo privado para calcular precio segun el tipo y la cuota
	 * @return el precio 
	 */
	private double CalculoPrecio() {

		if (this.tipo == TIPO.INDIVIDUAL && this.cuota == CUOTA.MENSUAL) {
			this.precio = 8.99;
		} else if (this.tipo == TIPO.INDIVIDUAL && this.cuota == CUOTA.ANUAL) {
			this.precio = 89.99;
		} else if (this.tipo == TIPO.DUO && this.cuota == CUOTA.MENSUAL) {
			this.precio = 14.99;
		} else if (this.tipo == TIPO.DUO && this.cuota == CUOTA.ANUAL) {
			this.precio = 169.99;
		} else if (this.tipo == TIPO.FAMILIAR && this.cuota == CUOTA.MENSUAL) {
			this.precio = 17.99;
		} else {
			this.precio = 199.99;
		}

		return this.precio;
	}

}
