package com.aluracursos.conversor.modulos;

public class Monedas {
    private String moneda;

    public String seleccioMoneda(int numero) {

        switch (numero) {
            case 1:
                this.moneda = "USD";
                break;
            case 2:
                this.moneda = "MXN";
                break;
            case 3:
                this.moneda = "ARS";
                break;
            case 4:
                this.moneda = "COP";
                break;
            case 5:
                this.moneda = "BOB";
                break;
            case 6:
                this.moneda = "BRL";
                break;
            case 7:
                this.moneda = "CLP";
                break;
        }

        return moneda;
    }

    public void menu(){

        System.out.println("""
                1. Dolar Americano [USD]
                2. Peso Mexicano [MXN]
                3. Peso Argentino [ARS]
                4. Peso Colombiano [COP]
                5. Boliviano Boliviano [BOB]
                6. Real Brasileño [BRL]
                7. Peso Chileno [CLP]
                0. Salir\n
                *********************************\n""");
    }
}
