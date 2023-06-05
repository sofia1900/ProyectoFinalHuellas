package ProyectoFinal.Huellas;

public class Registro {
	private int idRegistro;
	private String fechaAdopcion;
	private Adoptante adoptante;
	private Animales animal;
	
	public Registro() {}
	public Registro(int idRegistro, String fechaAdopcion, Adoptante adoptante, Animales animal) {
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
	public Animales getAnimal() {
		return animal;
	}
	public void setAnimal(Animales animal) {
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
		return "Registro [idRegistro=" + idRegistro + ", fechaAdopcion=" + fechaAdopcion + ", adoptante =" + adoptante
				+ ", animal=" + animal + "]";
	}
	
	
	

}
