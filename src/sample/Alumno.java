package sample;

import javafx.beans.property.*;

public class Alumno {
/*    public IntegerProperty idAlumno;
    public StringProperty nombre;
    public StringProperty apePaterno;
    public StringProperty apeMaterno;
    public FloatProperty calificacion;

    public Alumno(){
        this.idAlumno = new SimpleIntegerProperty();
        this.nombre = new SimpleStringProperty();
        this.apePaterno = new SimpleStringProperty();
        this.apeMaterno = new SimpleStringProperty();
        this.calificacion = new SimpleFloatProperty();
    }

    //Para el id
    public int getIdAlumno(){
        return idAlumno.get();
    }
    public void setIdAlumno(int id){
        this.idAlumno.set(id);
    }
    public IntegerProperty getIdAlumno(){
        return idAlumno;
    }*/
//:::::::::::::::::::::::::::::::::::::::::::::::::::::::
    private int idAlumno;
    private String nombre;
    private String apePaterno;
    private String apeMaterno;
    private float calificacion;
    /*public IntegerProperty idAlumno;
    public StringProperty nombre;
    public StringProperty apePaterno;
    public StringProperty apeMaterno;
    public FloatProperty calificacion;*/

    public Alumno(int idAlumno, String nombre, String apePaterno, String apeMaterno, float calificacion) {
        this.idAlumno = idAlumno;
        this.nombre = nombre;
        this.apePaterno= apePaterno;
        this.apeMaterno = apeMaterno;
        this.calificacion = calificacion;
        /*this.idAlumno = new SimpleIntegerProperty();
        this.nombre = new SimpleStringProperty();
        this.apePaterno = new SimpleStringProperty();
        this.apeMaterno = new SimpleStringProperty();
        this.calificacion = new SimpleFloatProperty();*/
    }
    /**/public int getIdAlumno(){return idAlumno;}
    //public int getIdAlumno(){return idAlumno.get();}
    //public void setIdAlumno(int id){this.idAlumno.set(id);

    /**/public String getNombre() {return nombre;}
    //public String getNombre(){return nombre.get();}
    //public void setIdAlumno(int id){this.idAlumno.set(id);

    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getApePaterno() {return apePaterno;}
    public void setApePaterno(String apePaterno) {this.apePaterno = apePaterno;}

    public String getApeMaterno() {return apeMaterno;}
    public void setApeMaterno(String apeMaterno) {this.apeMaterno = apeMaterno;}

    public float getCalificacion(){return calificacion;}
    public void setCalificacion(float calificacion){this.calificacion = calificacion;}

    @Override
    public String toString() {
        return "Alumno{" +
                "idAlumno =" + idAlumno +
                ", nombre ='" + nombre + '\'' +
                ", apellido paterno ='" + apePaterno + '\'' +
                ", apellido materno ='" + apeMaterno + '\'' +
                ", calificación ='" + calificacion + '\'' +
                '}';
    }
}
