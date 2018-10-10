package practica2;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ejercicio2 {

    public static void main(String[] args) throws Exception {

        Persona persona = getPersona(args);

        if (persona == null) {
            System.exit(0);
        }
        if (!persona.comprobarDni()) {
            System.out.println("DNI incorrecto");
            System.exit(0);
        }
        if (!Persona.esFechaCorrecta(persona.getFechaNacimiento().get(Calendar.DATE), persona.getFechaNacimiento().get(Calendar.MONTH), persona.getFechaNacimiento().get(Calendar.YEAR))) {
            System.out.println("Fecha incorrecta");
            System.exit(0);
        }

        System.out.println("DNI: " + persona.getDni());
        System.out.println("Nombre: " + persona.getNombreCorregido());
        System.out.println("Apellido: " + persona.getApellidosCorregido());
        System.out.println("Fecha de nacimiento: " + persona.getFechaNacimientoCorregida());
        if (persona.getObservaciones() != null || !persona.getObservaciones().isEmpty())
            System.out.println("Obervaciones: " + persona.getObservacionesCorregidas());
    }


    private static Persona getPersona(String[] args) throws Exception {

        if (args == null || args.length == 0) {
            return null;
        }

        String dni = args[0];
        String nombre = args[1];
        String apellidos = args[2];
        Calendar fechaNacimiento = Calendar.getInstance();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        fechaNacimiento.setTime(sdf.parse(args[3]));

        String observaciones = null;
        if (args.length >= 5) {
            observaciones = args[4];
        }

        return new Persona(dni, nombre, apellidos, fechaNacimiento, observaciones);
    }

}

class Persona {

    private String   dni;
    private String   nombre;
    private String   apellidos;
    private Calendar fechaNacimiento;
    private String   observaciones;


    public Persona() {
        // TODO Auto-generated constructor stub
    }


    public Persona(String dni, String nombre, String apellidos, Calendar fechaNacimiento) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
    }


    public Persona(String dni, String nombre, String apellidos, Calendar fechaNacimiento, String observaciones) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.observaciones = observaciones;
    }


    public boolean comprobarDni() {
        if (this.dni.matches("\\d{8}[a-zA-Z]"))
            return true;
        return false;
    }


    public static boolean esFechaCorrecta(int dia, int mes, int ano) {

        Calendar fecha = Calendar.getInstance();

        if (!fecha.isLenient()) {
            fecha.setLenient(true);
        }

        fecha.set(ano, mes - 1, dia);

        if (fecha.get(Calendar.YEAR) == ano && fecha.get(Calendar.MONTH) == mes - 1 && fecha.get(Calendar.DATE) == dia) {
            return true;
        } else {
            return false;
        }
    }


    public String getDni() {
        return dni;
    }


    public void setDni(String dni) {
        this.dni = dni;
    }


    public String getNombre() {
        return nombre;
    }


    public String getNombreCorregido() {
        String[] nombres = this.nombre.split("\\s+");
        String resultado = "";
        for (String n : nombres) {
            if (!n.isEmpty()) {
                resultado += n + " ";
            }
        }

        return resultado.substring(0, resultado.length() - 1).toUpperCase(); // quita el espacio final
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getApellidos() {
        return apellidos;
    }


    public String getApellidosCorregido() {
        String[] apellido = this.apellidos.split("\\s+");
        String resultado = "";
        for (String n : apellido) {
            if (!n.isEmpty()) {
                resultado += n + " ";
            }
        }

        return resultado.substring(0, resultado.length() - 1).toUpperCase(); // quita el espacio final
    }


    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }


    public Calendar getFechaNacimiento() {
        return fechaNacimiento;
    }


    public String getFechaNacimientoCorregida() {

        return new SimpleDateFormat("yyyy/MM/dd").format(this.fechaNacimiento.getTime());
    }


    public void setFechaNacimiento(Calendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }


    public String getObservaciones() {
        return observaciones;
    }


    public String getObservacionesCorregidas() {
        if (observaciones == null || observaciones.isEmpty())
            return "";
        String[] observaciones = this.observaciones.split("\\s+");
        String resultado = "";
        for (String n : observaciones) {
            if (!n.isEmpty()) {
                resultado += n + " ";
            }
        }

        return resultado.substring(0, resultado.length() - 1); // quita el espacio final
    }


    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

}