package modelos;


public class Tarifa {
    private int idTarifa;
    private String tipoHabitacion;
    private double precioBase;
    private double descuentoPorcentaje;
    private String descripcion; 

    public Tarifa() {
    }

    public Tarifa(int idTarifa, String tipoHabitacion, double precioBase, double descuentoPorcentaje, String descripcion) {
        this.idTarifa = idTarifa;
        this.tipoHabitacion = tipoHabitacion;
        this.precioBase = precioBase;
        this.descuentoPorcentaje = descuentoPorcentaje;
        this.descripcion = descripcion; 
    }

    // Getters y Setters
    public int getIdTarifa() {
        return idTarifa;
    }

    public void setIdTarifa(int idTarifa) {
        this.idTarifa = idTarifa;
    }

    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public double getDescuentoPorcentaje() {
        return descuentoPorcentaje;
    }

    public void setDescuentoPorcentaje(double descuentoPorcentaje) {
        this.descuentoPorcentaje = descuentoPorcentaje;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Tarifa{" +
               "idTarifa=" + idTarifa +
               ", tipoHabitacion='" + tipoHabitacion + '\'' +
               ", precioBase=" + precioBase +
               ", descuentoPorcentaje=" + descuentoPorcentaje +
               ", descripcion='" + descripcion + '\'' + 
               '}';
    }
}