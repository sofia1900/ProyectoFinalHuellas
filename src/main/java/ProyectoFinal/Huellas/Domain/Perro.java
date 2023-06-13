package ProyectoFinal.Huellas.Domain;

public class Perro extends Animal {
	private String raza;
	private boolean amigable;
	
	public Perro() {}
	public Perro(int id, String nombre, String fechaNac, String sexo, boolean adoptado, String raza, boolean amigable) {
		super(id, nombre, fechaNac, sexo, adoptado);
		this.raza=raza;
		this.amigable=amigable;
	}
	
	public String getRaza() {
		return raza;
	}
	public void setRaza(String raza) {
		this.raza = raza;
	}
	public boolean getAmigable() {
		return amigable;
	}
	public void setAmigable(boolean amigable) {
		this.amigable = amigable;
	}
	
	
	@Override
	public String toString() {
		return "Perro [ id= " + id + ", nombre= " + nombre + ", fechaNac= "
				+ fechaNac + ", sexo= " + sexo + ", raza= " + raza + ", amigable=" + amigable + " ]";
	}
	
	
	

}
