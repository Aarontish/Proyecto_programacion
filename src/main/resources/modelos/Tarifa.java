package modelos;

import java.time.LocalDate;

public class Tarifa {
    private int idTarifa;
    private String tipoHabitacion;
    private double precioBase;
    private double descuentoPorcentaje;
    private LocalDate fechaInicioVigencia;
    private LocalDate fechaFinVigencia;

    public Tarifa() {
    }

    public Tarifa(int idTarifa, String tipoHabitacion, double precioBase, double descuentoPorcentaje, LocalDate fechaInicioVigencia, LocalDate fechaFinVigencia) {
        this.idTarifa = idTarifa;
        this.tipoHabitacion = tipoHabitacion;
        this.precioBase = precioBase;
        this.descuentoPorcentaje = descuentoPorcentaje;
        this.fechaInicioVigencia = fechaInicioVigencia;
        this.fechaFinVigencia = fechaFinVigencia;
    }

    public int getIdTarifa() { return idTarifa; }
    public void setIdTarifa(int idTarifa) { this.idTarifa = idTarifa; }
    public String getTipoHabitacion() { return tipoHabitacion; }
    public void setTipoHabitacion(String tipoHabitacion) { this.tipoHabitacion = tipoHabitacion; }
    public double getPrecioBase() { return precioBase; }
    public void setPrecioBase(double precioBase) { this.precioBase = precioBase; }
    public double getDescuentoPorcentaje() { return descuentoPorcentaje; }
    public void setDescuentoPorcentaje(double descuentoPorcentaje) { this.descuentoPorcentaje = descuentoPorcentaje; }
    public LocalDate getFechaInicioVigencia() { return fechaInicioVigencia; }
    public void setFechaInicioVigencia(LocalDate fechaInicioVigencia) { this.fechaInicioVigencia = fechaInicioVigencia; }
    public LocalDate getFechaFinVigencia() { return fechaFinVigencia; }
    public void setFechaFinVigencia(LocalDate fechaFinVigencia) { this.fechaFinVigencia = fechaFinVigencia; }

    @Override
    public String toString() {
        return "Tarifa [id=" + idTarifa + ", tipo=" + tipoHabitacion + ", precio=" + precioBase + ", descuento=" + descuentoPorcentaje + "]";
    }
}
