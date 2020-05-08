package dds.monedero.model;

import java.time.LocalDate;

public class Movimiento {
  private LocalDate fecha;
  //En ningún lenguaje de programación usen jamás doubles para modelar dinero en el mundo real
  //siempre usen numeros de precision arbitraria, como BigDecimal en Java y similares
  private double monto;

  //Primitive obsession -> Como la operación a realizar al agregar un movimiento a la cuenta varía si es depósito o no,
  //es una opción modelar el tipo de movimiento con otra abstracción.
  //Modifiqué el boolean por un enum.
  private TipoDeMovimiento tipoDeMovimiento;

  public Movimiento(LocalDate fecha, double monto, TipoDeMovimiento tipoDeMovimiento) {
    this.fecha = fecha;
    this.monto = monto;
    this.tipoDeMovimiento = tipoDeMovimiento;
  }

  public double getMonto() {
    return monto;
  }

  public LocalDate getFecha() {
    return fecha;
  }

  public boolean fueDepositado(LocalDate fecha) {
    return isDeposito() && esDeLaFecha(fecha);
  }

  public boolean fueExtraido(LocalDate fecha) {
    return isExtraccion() && esDeLaFecha(fecha);
  }

  public boolean esDeLaFecha(LocalDate fecha) {
    return this.fecha.equals(fecha);
  }

  public boolean isDeposito() {
    return this.tipoDeMovimiento == TipoDeMovimiento.DEPOSITO;
  }

  public boolean isExtraccion() {
    return this.tipoDeMovimiento == TipoDeMovimiento.EXTRACCION;
  }

  //Feature envy -> Por qué Movimiento tiene que setearle el saldo a Cuenta y agregarse en Cuenta?
  //Se elimina el método y se modifican los métodos sacar y poner.

  //Type test -> Está chequeando si el movimiento es o no un depósito para saber qué hacer.
  //Modifiqué el switch statement por delegación.
  public double calcularValor(Cuenta cuenta) {
    return this.tipoDeMovimiento.calcularValor(cuenta.getSaldo(), this.monto);
  }
}
