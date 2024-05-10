package com.aluracursos.conversor.principal;

import com.aluracursos.conversor.modulos.JasonAObjeto;
import com.aluracursos.conversor.modulos.Monedas;
import com.google.gson.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Monedas monedaElegida = new Monedas();
        Scanner lectura = new Scanner(System.in);
        boolean menu = true;

        while (menu) {
            System.out.println("********Bienvenido al conversor de monedas********");
            System.out.println("Eliga su divisa en el siguiente menu: \n");
            monedaElegida.menu();

            var busqueda = lectura.nextInt();

            String seleccion = monedaElegida.seleccioMoneda(busqueda); //Es la Moneda que regresa el metodo SeleccionMoneda de la clase Monedas

            String direccion = "https://v6.exchangerate-api.com/v6/7d803e2b1dafedadb5cefdc3/latest/" + seleccion;
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(direccion))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();

            JasonAObjeto jasonAObjeto1 = new JasonAObjeto();
            JsonObject objetoDeJason = jasonAObjeto1.transformaJson(json);

            System.out.println("Escriba la  cantidad de [" + seleccion + "] a convertir: ");
            double primeraDivisa = lectura.nextDouble();

            System.out.println("Seleccione la divisa a la que quiere convertir:");
            monedaElegida.menu();
            int segundaDivisa = lectura.nextInt();
            String segundaMoneda = monedaElegida.seleccioMoneda(segundaDivisa);


            System.out.println(primeraDivisa + "[" + seleccion + "] " + "Equivalente a: " + objetoDeJason.get(segundaMoneda)
                    .getAsDouble() * primeraDivisa + "[" + segundaMoneda + "]\n");

        }


    }
}
