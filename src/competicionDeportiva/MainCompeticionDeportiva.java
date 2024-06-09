package competicionDeportiva;

import java.util.Scanner;

public class MainCompeticionDeportiva {

	static Scanner miScan = new Scanner(System.in);
	static String sOption = "";
	static boolean bOption = true, bOption2 = true;
	static Equipo e = null;
	static Competicion c = null;
	static Jugador j = null;

	public static void main(String args[]) {

		do {

			System.out.println("BIENVENIDO\n\n¿Qué desea hacer?\na. Empezar\nb. About\nc. Salir");

			sOption = miScan.nextLine();

			if (sOption.compareTo("a") == 0) {

				do {

					System.out.println("Elija la opción:\n\n" + "a. Proporcionar datos de la competición\n"
							+ "b. Añadir un nuevo equipo\n" + "c. Eliminar un equipo existente\n"
							+ "d. Buscar equipos de una localidad\n" + "e. Listar todos los equipos\n"
							+ "f. Dar de alta a un nuevo jugador en un equipo\n"
							+ "g. Eliminar un jugador en un equipo\n"
							+ "h. Cambiar estado/disponibilidad de un jugador de un equipo\n"
							+ "(CUALQUIER OTRA TECLA) Salir");

					sOption = miScan.nextLine();

					if (sOption.equalsIgnoreCase("a")) {

						c = crearCompeticion();

					} else if (sOption.equalsIgnoreCase("b")) {

						if (c != null) {

							e = crearEquipo();
							c.addEquipo(e);

						}

					} else if (sOption.equalsIgnoreCase("c")) {

						if (c != null) c.removeEquipo(e);

					} else if (sOption.equalsIgnoreCase("d")) {

						if (c != null) {
							System.out.println("Introduzca la ciudad: ");

							String ciudad = miScan.nextLine();
							c.findEquipo(ciudad);

						}

					} else if (sOption.equalsIgnoreCase("e")) {

						if (c != null)
							System.out.println(c.listadoEquipos());

					} else if (sOption.equalsIgnoreCase("f")) {

						if (c != null) {

							j = crearJugador();
							e.addJugador(j);

						}

					} else if (sOption.equalsIgnoreCase("g")) {

						if (c != null) e.removeJugador(j);

					} else if (sOption.equalsIgnoreCase("h")) {

						if (c != null) {

							boolean disponible = false;

							System.out.println("Introduzca el dni: ");
							String dni = miScan.nextLine();

							System.out.println("Introduzca la disponibilidad: \na. Disponible\nb. No disponible");
							String disponibilidad = miScan.next();

							if (disponibilidad.equalsIgnoreCase("a")) disponible = true;
								else disponible = false;

							e.cambiarDisponibilidad(dni, disponible);

						}

					}

				} while (bOption2);

			} else if (sOption.compareTo("b") == 0) {

				System.out.println("@author MrPró");

			} else {

				System.out.println("Adiós");
				bOption = false;

			}

		} while (bOption);

	}

	private static Competicion crearCompeticion() {

		c = new Competicion("", "", "", null);
		System.out.println("Introduzca la descripción: ");
		String descripcion = miScan.nextLine();
		System.out.println("Introduzca la provincia: ");
		String provincia = miScan.nextLine();
		boolean bOption3 = true;
		String nivel = "";

		do {

			System.out.println("Elija la categoría: \n\na. Benjamines\nb. Mini\nc. Juveniles\nd. Cadetes");
			nivel = miScan.nextLine();

			if (nivel.equals("a") || nivel.equals("b") || nivel.equals("c") || nivel.equals("d")) bOption3 = false;

		} while (bOption3);

		c = new Competicion(c.getCodigo(), descripcion, provincia, null);
		c.setN(nivel);

		return c;

	}

	private static Equipo crearEquipo() {

		System.out.println("Introduzca la descripción: ");
		String descripcion = miScan.nextLine();
		System.out.println("Introduzca el nombre del responsable: ");
		String nombreResponsable = miScan.nextLine();
		System.out.println("Introduzca los apellidos del responsable: ");
		String apellidosResponsable = miScan.nextLine();
		System.out.println("Introduzca la ciudad: ");
		String ciudad = miScan.nextLine();
		System.out.println("Introduzca el email: ");
		String mail = miScan.nextLine();
		System.out.println("Introduzca el teléfono: ");
		String tlf = miScan.nextLine();
		System.out.println("Indique el deporte: ");
		String deporte = miScan.nextLine();
		String codigo = c.asignarCodigo(deporte);

		e = new Equipo(codigo, descripcion, nombreResponsable, apellidosResponsable, ciudad, mail, tlf);

		return e;

	}

	private static Jugador crearJugador() {

		System.out.println("Introduzca el nombre: ");
		String nombre = miScan.nextLine();
		System.out.println("Introduzca los apellidos: ");
		String apellidos = miScan.nextLine();
		System.out.println("Introduzca el dorsal: ");
		String dorsal = miScan.nextLine();
		System.out.println("Introduzca DNI: ");
		String dni = miScan.nextLine();
		System.out.println("Introduzca el email: ");
		String mail = miScan.nextLine();
		System.out.println("Introduzca el teléfono: ");
		String tlf = miScan.nextLine();

		j = new Jugador(nombre, apellidos, dorsal, dni, mail, tlf, true);
		boolean disponible = j.isDisponible();
		j.setDisponible(disponible);

		return null;

	}

}
