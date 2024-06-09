package competicionDeportiva;

public class Jugador {
	
	private String nombre, apellidos, dorsal, dni, mail, tlf;
	
	private boolean disponible; 
	
	public Jugador(String nombre, String apellidos, String dorsal, String dni, String mail, String tlf, boolean disponible) {
		
	this.nombre = nombre;
	this.apellidos = apellidos;
	this.dorsal = dorsal;
	this.dni = dni;
	this.mail = mail;
	this.tlf = tlf;
	this.disponible = disponible;
	
	}
	
	public String getNombre() { return nombre; }
	public String getApellidos() { return apellidos; }
	public String getDorsal() { return dorsal; }
	public String getDni() { return dni; }
	public String getMail() { return mail; }
	public String getTlf() { return tlf; }
	public boolean isDisponible() { return disponible; }
	
	public void setNombre(String nombre) { this.nombre = nombre; }
	public void setApellidos(String apellidos) { this.apellidos = apellidos; }
	public void setDorsal(String dorsal) { this.dorsal = dorsal; }
	public void setDni(String dni) { this.dni = dni; }
	public void setMail(String mail) { this.mail = mail; }
	public void setTlf(String tlf) { this.tlf = tlf; }
	public void setDisponible(boolean disponible) { this.disponible = disponible; }

	@Override
	public String toString() {
		
		return "JUGADOR:\nNombre: " + nombre 
				+ "\nApellidos: " + apellidos 
				+ "\nDorsal: " + dorsal 
				+ "\nDNI: " + dni 
				+ "\nEmail: " + mail 
				+ "\nTeléfono: " + tlf 
				+ "\nDisponible: " + disponible;
		
	}

}
