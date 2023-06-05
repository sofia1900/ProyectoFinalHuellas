package ProyectoFinal.Huellas;

public class Registro {
	private int idRegistro;
	private String fechaAdopcion;
	private Persona persona;
	private Animales animal;
	
	public Registro() {}
	public Registro(int idRegistro, String fechaAdopcion, Persona persona, Animales animal) {
		this.idRegistro = idRegistro;
		this.fechaAdopcion = fechaAdopcion;
		this.persona = persona;
		this.animal = animal;
	}



	public int getIdRegistro() {
		return idRegistro;
	}
	public void setIdRegistro(int idRegistro) {
		this.idRegistro = idRegistro;
	}
	public String getFechaAdopcion() {
		return fechaAdopcion;
	}
	public void setFechaAdopcion(String fechaAdopcion) {
		this.fechaAdopcion = fechaAdopcion;
	}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	public Animales getAnimal() {
		return animal;
	}
	public void setAnimal(Animales animal) {
		this.animal = animal;
	}
	
	
	@Override
	public String toString() {
		return "Registro [idRegistro=" + idRegistro + ", fechaAdopcion=" + fechaAdopcion + ", persona=" + persona
				+ ", animal=" + animal + "]";
	}
	
	
	

}
