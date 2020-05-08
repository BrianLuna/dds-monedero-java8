package dds.monedero.model;

public enum TipoDeMovimiento {

    DEPOSITO{
        @Override
        public double calcularMonto(double montoDelMovimiento) {
            return montoDelMovimiento;
        }
    },
    EXTRACCION{
        @Override
        public double calcularMonto(double montoDelMovimiento) {
            return -montoDelMovimiento;
        }
    };

    abstract public double calcularMonto(double montoDelMovimiento);

}
