package competicionDeportiva;

import java.util.HashMap;
import java.util.Map;

public class Equipo {
	
	private String codigo, descripcion, nombreResponsable, apellidosResponsable, ciudad, mail, tlf;
	private boolean vacio;
	private Map<String, Jugador> misJugadores;
	
	public Equipo(String codigo, String descripcion, String nombreResponsable, String apellidosResponsable, String ciudad, String mail, String tlf) {
		
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.nombreResponsable = nombreResponsable;
		this.apellidosResponsable = apellidosResponsable;
		this.ciudad = ciudad;
		this.mail = mail;
		this.tlf = tlf;
		this.vacio = true;
		misJugadores = new HashMap<>();
		
	} 
	
	public boolean addJugador(Jugador j) { 
		
		if(j != null && !findJugador(j.getDni())) { 
			
			misJugadores.put(j.getDni(), j);
			return true;
		
		} 
		
		return false;
		
	} 
	
	public boolean removeJugador(Jugador j) {
		
		if(j != null && findJugador(j.getDni())) {
			
			misJugadores.remove(j.getDni());
			
			return true;
			
		} 
		
		return false;
		
	}
	
	public boolean findJugador(String dni) {
	
		if(dni != null) {
			
			if(misJugadores.containsKey(dni)) return true; 
			
		} 
		
		return false; 
		
	} 
	
	public boolean cambiarDisponibilidad(String dni, boolean disponible) { 
		
		if(dni != null && misJugadores.containsKey(dni)) { misJugadores.get(dni).setDisponible(disponible); 
		
		return true; 
		
		}
		
		return false; 
		
	} 
	
	public String getCodigo() { return codigo; }
	public String getDescripcion() { return descripcion; }
	public String getNombreResponsable() { return nombreResponsable; }
	public String getApellidosResponsable() { return apellidosResponsable; }
	public String getCiudad() { return ciudad; }
	public String getMail() { return mail; }
	public String getTlf() { return tlf; }
	public boolean isVacio() { return vacio; }
	public Map<String, Jugador> getMisJugadores() { return misJugadores; } 
	
	public void setCodigo(String codigo) { this.codigo = codigo; }
	public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
	public void setNombreResponsable(String nombreResponsable) { this.nombreResponsable = nombreResponsable; }
	public void setApellidosResponsable(String apellidosResponsable) { this.apellidosResponsable =
	apellidosResponsable; }
	public void setCiudad(String ciudad) { this.ciudad = ciudad; }
	public void setMail(String mail) { this.mail = mail; } 
	public void setTlf(String tlf) { this.tlf = tlf; }
	public void setVacio(boolean vacio) { this.vacio = vacio; } 
	
	@Override 
	public String toString() {
		
	    StringBuilder sB = new StringBuilder();
	    
	    sB.append("EQUIPO:\n\n Código: ").append(codigo)
	      .append(", Descripción: ").append(descripcion)
	      .append(", Nombre del responsable:").append(nombreResponsable)
	      .append(", Apellidos del responsable:").append(apellidosResponsable)
	      .append(", Ciudad: ").append(ciudad)
	      .append(", Email: ").append(mail)
	      .append(", Teléfono: ").append(tlf)
	      .append("\nJUGADORES:\n");
	    
	    for (Jugador j : misJugadores.values()) sB.append(j.toString()).append("\n");
	    
	    return sB.toString();
	    
	}


}
