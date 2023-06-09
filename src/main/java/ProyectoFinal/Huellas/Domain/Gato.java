package ProyectoFinal.Huellas.Domain;

public class Gato extends Animal{
	
	private boolean virus;
	
	public Gato() {}
	public Gato(int id, String nombre, String fechaNac, String sexo, boolean adoptado,  boolean virus) {
		super(id, nombre, fechaNac, sexo, adoptado);
		this.virus=virus;
	}



	public boolean getVirus() {
		return virus;
	}
	public void setVirus(boolean virus) {
		this.virus = virus;
	}
	
	
	@Override
	public String toString() {
		return "Gato [virus=" + virus + ", id=" + id + ", nombre=" + nombre + ", fechaNac=" + fechaNac + ", sexo="
				+ sexo + "]";
	}
	
	
	

}
