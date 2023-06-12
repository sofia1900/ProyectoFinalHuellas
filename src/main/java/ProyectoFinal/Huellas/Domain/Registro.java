package ProyectoFinal.Huellas.Domain;

public class Registro {
	private int idRegistro;
	private String fechaAdopcion;
	private Adoptante adoptante;
	private Animal animal;
	
	public Registro() {}
	public Registro(int idRegistro, String fechaAdopcion, Adoptante adoptante, Animal animal) {
		this.idRegistro = idRegistro;
		this.fechaAdopcion = fechaAdopcion;
		this.adoptante = adoptante;
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
	public Animal getAnimal() {
		return animal;
	}
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	public Adoptante getAdoptante() {
		return adoptante;
	}
	public void setAdoptante(Adoptante adoptante) {
		this.adoptante = adoptante;
	}
	
	@Override
	public String toString() {
		return "Registro Adopcion [idRegistro=" + idRegistro + ", fechaAdopcion=" + fechaAdopcion + ", " + adoptante
				+ ", " + animal + "]";
	}
	
	
	

}
