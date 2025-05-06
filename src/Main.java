import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Creaos una clase Alumno con atributos:
 * nombre
 * apellido
 * curso
 * nota promedio
 * enum tipoMateria
 */
import java.util.List;

public class Main {
    public static void main(String[] args) {

        menu();
        //creamos la coleccion de manera global para que todos los metodos puedan accerder la ella

    }

    /**
     * Creamos un  menu con las opciones
     * alta
     * baja
     * modidicacion
     * mostrarTodos
     */
    static List<Alumno> grupoAlumnos = new ArrayList<>();


    public static void menu() {
        int opcion;
        String opcionString = JOptionPane.showInputDialog(null, "Ingrese una opcion:\n1.Alta" +
                "\n2.Baja"
                + "\n3.Modificar"
                + "\n4.Mostrar"
                + "\n5.Salir");


        try {
            opcion = Integer.parseInt(opcionString);
            switch (opcion) {
                case 1, 3 -> altaModificacion(opcion);
                case 2 -> eliminar();

                case 4 -> mostrar();
                case 5 -> JOptionPane.showMessageDialog(null, "Saliendo del sistema...");
                default -> JOptionPane.showMessageDialog(null, "Opcion no valida");

            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingrese un numero valido");
        }


    }

    public static void altaModificacion(int opcion) {
        String nombre = "";
        String apellido = "";
        String curso = "";
        Alumno.Materia materiaAlumno = null;
        double notaMedia = 0;
        if (opcion == 1) {
            nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del alumno");
            apellido = JOptionPane.showInputDialog(null, "Ingrese el apellido");
            curso = JOptionPane.showInputDialog(null, "Ingrese el curso");
            notaMedia = leerNota();


            Alumno nuevo = new Alumno(nombre, apellido, curso, notaMedia, materiaAlumno);
            if (nuevo != null) {
                grupoAlumnos.add(nuevo);
                menu();
            }

        }
        if (opcion == 3) {
            String salida = mostrarAlumnos();
            String modificarId = JOptionPane.showInputDialog(null, salida + "\nIngrese el id del alumno");
            String queModificar = JOptionPane.showInputDialog(null, modificarId + "1->Nombre\n2->Apellido\n3->Curso\n4->Nota Media\n5->Materia");
            int opcionModificar = 0;
            int idAlumnoModificar = 0;

            try {
                idAlumnoModificar = Integer.parseInt(modificarId);
                opcionModificar = Integer.parseInt(queModificar);
                Iterator<Alumno> iterator = grupoAlumnos.iterator();
                while (iterator.hasNext()) {
                    Alumno alumno = iterator.next();
                    if (alumno.getIdAlumno() == opcionModificar) {
                        switch (opcionModificar) {
                            case 1 ->{
                                    nombre = JOptionPane.showInputDialog(null, nombre + "Ingrese el nombre del alumno");
                                    alumno.setNombre(nombre);
                            }
                            case 2 ->{
                                apellido = JOptionPane.showInputDialog(null, "Ingrese el apellido del alumno");
                                alumno.setApellido(apellido);
                            }
                            case 3 ->{
                                curso = JOptionPane.showInputDialog(null, "Ingrese el curso");
                                alumno.setCurso(curso);
                            }
                            case 4 -> {
                                notaMedia = leerNota();
                                alumno.setNotaMedia(notaMedia);

                            }
                            case 5 -> {
                                materiaAlumno = leerMateria();
                                alumno.setMateria(materiaAlumno);

                            }
                        }
                    }
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese un numero valido");
            }
            mostrar();


        }

    }

    public static void eliminar() {
        if (!grupoAlumnos.isEmpty()) {

            String salida = mostrarAlumnos();
            String idEliminar = JOptionPane.showInputDialog(null, salida + "\nIngrese el id del alumno a eliminar");
            /**iterator***buscando el id y lo eliminamos**/
            int id;
            boolean eliminado = false;
            try {
                id = Integer.parseInt(idEliminar);
                Iterator<Alumno> it = grupoAlumnos.iterator();
                while (it.hasNext()) {
                    Alumno alumno = it.next();
                    if (alumno.getIdAlumno() == id) {
                        it.remove();
                        eliminado = true;
                    }
                }
                if (!eliminado) {
                    JOptionPane.showMessageDialog(null, "El id del alumno no existe");
                }
                mostrar();

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Inrese un numero valido");
            }
        } else {
            mostrar();
        }

    }

    public static void mostrar() {
        String salida = mostrarAlumnos();

        JOptionPane.showMessageDialog(null, salida);
        menu();
    }

    public static String mostrarAlumnos() {
        String salida = "";
        if (!grupoAlumnos.isEmpty()) {
            for (Alumno alumno : grupoAlumnos) {
                salida = alumno.toString() + "\n";
            }
        } else {
            salida = "No existe alumno que mostrar";
        }
        return salida;


    }

    public static double leerNota() {
        boolean notaMediaCorrecta = false;
        double notaMedia = 0;
        do {
            String notaMediaString = JOptionPane.showInputDialog(null, "Ingrese el nota del materia");
            try {
                notaMedia = Integer.parseInt(notaMediaString);
                notaMediaCorrecta = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese una nota del alumno");
            }


        } while (!notaMediaCorrecta);

        return notaMedia;

    }

    public static Alumno.Materia leerMateria() {
        Alumno.Materia[] materias = {Alumno.Materia.BIOLOGIA, Alumno.Materia.FISICA, Alumno.Materia.LENGUA, Alumno.Materia.MATEMATICA, Alumno.Materia.QUIMICA};
        int materiaSeleccionada = JOptionPane.showOptionDialog(
                null,
                "Ingrese la materia del alumno",
                "Materia",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                materias,
                materias[0]);//puede establecer una opcion por defecto, como materias[0]

        Alumno.Materia materiaAlumno = materias[materiaSeleccionada];

        return materiaAlumno;


    }

}