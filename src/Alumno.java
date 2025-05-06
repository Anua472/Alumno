public class Alumno {

    private String nombre;
    private String apellido;
    private String curso;
    private double notaMedia;
    private Materia materia;
    public static enum Materia{FISICA,
        QUIMICA,
        MATEMATICA,
        BIOLOGIA,
        LENGUA
    }
    private int idAlumno;
    private static int ultimoId;

    public Alumno() {
        this.idAlumno =++Alumno.ultimoId;
    }

    public Alumno(String nombre, String apellido, String curso, double notaMedia, Materia materia) {
        this();
        this.nombre = nombre;
        this.apellido = apellido;
        this.curso = curso;
        this.notaMedia = notaMedia;
        this.materia = materia;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public double getNotaMedia() {
        return notaMedia;
    }

    public void setNotaMedia(double notaMedia) {
        this.notaMedia = notaMedia;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public int getIdAlumno() {
        return idAlumno;
    }



    public static int getUltimoId() {
        return ultimoId;
    }



    @Override
    public String toString() {
        return "IdAlumno=" +this.idAlumno +
                "\nnombre='" + nombre + '\'' +
                "\napellido='" + apellido + '\'' +
                "\ncurso='" + curso + '\'' +
                "\nnotaMedia=" + notaMedia +
                "\nmateria=" + materia;
    }
}
