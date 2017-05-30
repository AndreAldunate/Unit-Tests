import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;

public class Main {

	public static void main(String[] args) {
	System.out.println(edad("04/12/1996"));
	}

	public static Persona aplica(Persona a, Persona b, String p) {
		if (a.profesion.equals(p) && b.profesion.equals(p)) {
			return a.edad >= b.edad ? a : b;
		} else if (a.profesion.equals(p)) {
			return a;
		} else if (b.profesion.equals(p)) {
			return b;
		} else {
			return null;
		}
	}

	public static String edad(String fech_nac) {
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fechaNac = LocalDate.parse(fech_nac, fmt);
		LocalDate ahora = LocalDate.now();

		Period periodo = Period.between(fechaNac, ahora);

		String respuesta = "La edad es: " + periodo.getYears() + " años,"
				+ periodo.getMonths() + " meses, " + periodo.getDays()
				+ " días";

		return respuesta;

	}

	public static boolean primo(int numero) {
		if (numero > 1) {
			boolean[] criba = new boolean[numero + 1];
			Arrays.fill(criba, true);
			for (int i = 2; i < numero; i++) {
				if (criba[i]) {
					for (int j = i + i; j <= numero; j += i) {
						criba[j] = false;
					}
				}
			}
			return criba[numero];
		} else {
			return false;
		}
	}

}

class Persona {

	public String nombre;
	public String profesion;
	public int edad;

	public Persona(String n, String p, int e) {
		nombre = n;
		profesion = p;
		edad = e;
	}
	@Override
	public String toString(){
		return nombre;
	}
}
