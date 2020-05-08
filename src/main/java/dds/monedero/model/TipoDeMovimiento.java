package dds.monedero.model;

public enum TipoDeMovimiento {

    DEPOSITO{
        @Override
        public double calcularValor(double saldoDeCuenta, double montoDelMovimiento) {
            return saldoDeCuenta + montoDelMovimiento;
        }
    },
    EXTRACCION{
        @Override
        public double calcularValor(double saldoDeCuenta, double montoDelMovimiento) {
            return saldoDeCuenta - montoDelMovimiento;
        }
    };

    abstract public double calcularValor(double saldoDeCuenta, double montoDelMovimiento);

}
