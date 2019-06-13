package sample;

import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class OperacionesAlumnos {

    Connection connection;

    public OperacionesAlumnos(Connection conn) {
        this.connection = conn;
    }

    public Alumno getLista(ObservableList<Alumno> datos){
        datos.clear();
        int idAlumno = 0;
        String nombre = "", apePaterno = "", apeMaterno = "";
        float calificacion = 0;

        String query = "SELECT  idAlumno, nombre, apePaterno, apeMaterno, Calificacion " +
                "FROM alumno ";

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                datos.add(
                        new Alumno(idAlumno = rs.getInt("idAlumno"),
                                nombre = rs.getString("nombre"),
                                apePaterno = rs.getString("apePaterno"),
                                apeMaterno = rs.getString("apeMaterno"),
                                calificacion = rs.getFloat("calificacion"))
                );

            }
            return new Alumno(idAlumno,nombre,apePaterno,apeMaterno,calificacion);
        }
        catch (java.sql.SQLException ex){
            ex.printStackTrace();
            System.out.println("SQLException:␣" + ex.getMessage());
            System.out.println("SQLState:␣" + ex.getSQLState());
            System.out.println("VendorError:␣" + ex.getErrorCode());

            return null;
        }
    }

    public Alumno getAlumno(int id) {
        int idAlumno = 0;
        String nombre = "", apePaterno = "", apeMaterno = "";
        float calificacion = 0;

        String query = "SELECT  idAlumno, nombre, apePaterno, apeMaterno, Calificacion " +
                "FROM alumno " +
                "WHERE alumno.idAlumno = " + id;

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
                idAlumno = rs.getInt("idAlumno");
                nombre = rs.getString("nombre");
                apePaterno = rs.getString("apePaterno");
                apeMaterno = rs.getString("apeMaterno");
                calificacion = rs.getFloat("Calificacion");
            }


            return new Alumno(idAlumno, nombre, apePaterno, apeMaterno, calificacion);
        } catch (java.sql.SQLException ex) {
            ex.printStackTrace();
            System.out.println("SQLException:␣" + ex.getMessage());
            System.out.println("SQLState:␣" + ex.getSQLState());
            System.out.println("VendorError:␣" + ex.getErrorCode());

            return null;
        }
    }

    public int deleteAlumno(int id) {
        int idAlumno;
        String nombre, apePaterno, apeMaterno;
        float calificacion;

        String query = "delete from alumno where idAlumno = " + id;

        int numRegs = 0;
        try {
            Statement stmt = connection.createStatement();
            numRegs = stmt.executeUpdate(query);

            System.out.println("Cantidad de registros afectados: " + numRegs);
        } catch (java.sql.SQLException ex) {
            ex.printStackTrace();
            System.out.println("SQLException:␣" + ex.getMessage());
            System.out.println("SQLState:␣" + ex.getSQLState());
            System.out.println("VendorError:␣" + ex.getErrorCode());
        }

        return numRegs;
    }

    public int insertAlumno(int id, String nombre, String apePaterno, String apeMaterno, float calificacion) {

        String query = "insert into alumno(idAlumno, nombre, apePaterno, apeMaterno, calificacion) " +
                "values ('" + id + "','" + nombre + "', '" + apePaterno + "', '" + apeMaterno + "', '" + calificacion + "')";

        int numRegs = 0;
        try {
            Statement stmt = connection.createStatement();
            numRegs = stmt.executeUpdate(query);

            System.out.println("Cantidad de registros afectados: " + numRegs);

        } catch (java.sql.SQLException ex) {
            ex.printStackTrace();
            System.out.println("SQLException:␣" + ex.getMessage());
            System.out.println("SQLState:␣" + ex.getSQLState());
            System.out.println("VendorError:␣" + ex.getErrorCode());
        }

        return numRegs;
    }

    public int updateAlumno (int id, String nombre, String apePaterno, String apeMaterno, float calificacion){
        String query = "UPDATE alumno Set nombre = '"+nombre+"', apePaterno = '"+apePaterno+"', apeMaterno = '" +
                ""+apeMaterno+"'" +", Calificacion = '"+calificacion+"' WHERE alumno.idAlumno = "+id;

        int numRegs = 0;
        try {
            Statement stmt = connection.createStatement();
            numRegs = stmt.executeUpdate(query);

            System.out.println("Cantidad de registros afectados: " + numRegs);

        } catch (java.sql.SQLException ex) {
            ex.printStackTrace();
            System.out.println("SQLException:␣" + ex.getMessage());
            System.out.println("SQLState:␣" + ex.getSQLState());
            System.out.println("VendorError:␣" + ex.getErrorCode());
        }

        return numRegs;
    }


}
