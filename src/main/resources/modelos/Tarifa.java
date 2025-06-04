package modelos;

public class Tarifa {
    private int idTarifa;
    private String tipoHabitacion;
    private double precioBase;
    private double descuentoPorcentaje;
    private String descripcion;
    private String tipoCondicion;

    public Tarifa(int idTarifa, String tipoHabitacion, double precioBase, double descuentoPorcentaje, String descripcion, String tipoCondicion) {
        this.idTarifa = idTarifa;
        this.tipoHabitacion = tipoHabitacion;
        this.precioBase = precioBase;
        this.descuentoPorcentaje = descuentoPorcentaje;
        this.descripcion = descripcion;
        this.tipoCondicion = tipoCondicion;
    }

    public int getIdTarifa() {
        return idTarifa;
    }

    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public double getDescuentoPorcentaje() {
        return descuentoPorcentaje;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getTipoCondicion() {
        return tipoCondicion;
    }

    public void setIdTarifa(int idTarifa) {
        this.idTarifa = idTarifa;
    }

    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public void setDescuentoPorcentaje(double descuentoPorcentaje) {
        this.descuentoPorcentaje = descuentoPorcentaje;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setTipoCondicion(String tipoCondicion) {
        this.tipoCondicion = tipoCondicion;
    }
}
