package modelo.datos;

/**
 * Created by Jeison on 03/03/2018.
 */
public class Cliente {

    private int idCliente;
    private String nombre;
    private boolean isEstudiante;
    private double credito;


    public Cliente(int idCliente, String nombre, boolean isEstudiante) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.isEstudiante = isEstudiante;
        this.credito = 0;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isEstudiante() {
        return isEstudiante;
    }

    public void setEstudiante(boolean estudiante) {
        isEstudiante = estudiante;
    }

    public double getCredito() {
        return credito;
    }

    public void setCredito(double credito) {
        this.credito = credito;
    }
}
