package competicionDeportiva;

import java.util.ArrayList;
import java.util.List;

public class Competicion {
	
	private String codigo, descripcion, provincia;
	private int codigoInit;
	private List<Equipo> misEquipos;
	private enum niveles { BENJAMINES, MINI, JUVENILES, CADETES }
	private niveles n;
	
	public Competicion(String codigo, String descripcion, String provincia, niveles n) { 
		
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.provincia = provincia;
		codigoInit = 111; 
		this.n = n;
		misEquipos = new ArrayList<>(); 
		
	} 
	
	public String asignarCodigo(String deporte) {
	
		if(deporte != null) { 
			
			String id = deporte.substring(0, 2) + String.valueOf(codigoInit); 
			codigoInit++;
			this.codigo = id; 
			
			return codigo; 
			
		} 
		
		return null; 
		
	} 
	
	public boolean addEquipo(Equipo e) { 
		
		if(e != null && !misEquipos.contains(e)) {

			misEquipos.add(e); 
		
			return true; 
		
		} 
		
		return false; 
		
	} 
	
	public boolean removeEquipo(Equipo e) { 
		
		if(e != null && misEquipos.contains(e)) { 
			
			misEquipos.remove(e);
	
			return true; 
		
		} 
		
		return false;
		
	} 
	
	public Equipo findEquipo(String ciudad) { 
		
		if(ciudad != null) {
	
			for(Equipo e : misEquipos) { 
				
				if(e.getCiudad().equals(ciudad)) return e; 
		
			} 
			
		} 
		
		return null; 
		
	}
	
	public String listadoEquipos() { 
		
		for(Equipo e : misEquipos) { 
			
			return e.toString(); 
			
		} 
		
		return null; 
		
	} 
	
	public String getCodigo() { return codigo; }
	public String getDescripcion() { return descripcion; } 
	public String getProvincia() { return provincia; } 
	public List<Equipo> getMisEquipos() { return misEquipos; }
	public niveles getN() { return n; }

	public void setN(String option) {
		
		if(option.equals("a")) {
			
			n = niveles.BENJAMINES;
			
		}else if(option.equals("b")) {	
			
			n = niveles.MINI;
		
		}else if(option.equals("c")) {	
			
			n = niveles.JUVENILES;
		
		}else if(option.equals("d")) {	
			
			n = niveles.CADETES;
		
		}
		
	}
	
	@Override
	public String toString() {
		
	    StringBuilder sb = new StringBuilder();
	    
	    sb.append("COMPETICIÓN:\n\n Código: ").append(codigo)
	      .append(", Descripción: ").append(descripcion)
	      .append(", Provincia: ").append(provincia)
	      .append(", Nivel: ").append(n.name())
	      .append("\nEQUIPOS:\n");
	    
	    for (Equipo equipo : misEquipos) {
	    	
	        sb.append(equipo.toString()).append("\n\n");
	        
	    }
	    
	    return sb.toString();
	}

}
