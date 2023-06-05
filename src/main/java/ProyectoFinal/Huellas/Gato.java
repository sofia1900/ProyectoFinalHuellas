package ProyectoFinal.Huellas;

public class Gato extends Animales{
	
	private boolean virus;
	
	public Gato() {}
	public Gato(int id, String nombre, String fechaNac, Sexo sexo, boolean virus) {
		super(id, nombre, fechaNac, sexo);
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
