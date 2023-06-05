package ProyectoFinal.Huellas;

public class Socio extends Persona {
	
	private String cuentaBancaria;
	
	public Socio() {}
	

	public Socio(int id, String nombre, String apellidos, String dni, String cuentaBancaria) {
		super(id, nombre, apellidos, dni);
		this.cuentaBancaria = cuentaBancaria;
	}



	public String getCuentaBancaria() {
		return cuentaBancaria;
	}

	public void setCuentaBancaria(String cuentaBancaria) {
		this.cuentaBancaria = cuentaBancaria;
	}


	@Override
	public String toString() {
		return "Socio [cuentaBancaria=" + cuentaBancaria + ", id=" + id + ", nombre=" + nombre + ", apellidos="
				+ apellidos + ", dni=" + dni + "]";
	}
	
	
	

}
