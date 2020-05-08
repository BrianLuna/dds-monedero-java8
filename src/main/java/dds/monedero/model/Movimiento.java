package dds.monedero.model;

import java.time.LocalDate;

public class Movimiento {
  final private LocalDate fecha;
  final private double monto;
  final private TipoDeMovimiento tipoDeMovimiento;

  public Movimiento(LocalDate fecha, double monto, TipoDeMovimiento tipoDeMovimiento) {
    this.fecha = fecha;
    this.monto = monto;
    this.tipoDeMovimiento = tipoDeMovimiento;
  }

  public double getMonto() {
    return tipoDeMovimiento.calcularMonto(monto);
  }

  public LocalDate getFecha() {
    return fecha;
  }

  public boolean isDeposito() {
    return this.tipoDeMovimiento == TipoDeMovimiento.DEPOSITO;
  }
}