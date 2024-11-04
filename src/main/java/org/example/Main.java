package org.example;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Main {
    private static final String API_KEY = "TU_CLAVE_API";
    private static final String Base_URL = "https://v6.exchangerate-api.com/v6/";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Gson gson = new Gson();

        boolean continuar = true;

        while (continuar) {
            System.out.println("=== Conversor de Moneda ===");
            System.out.println("Seleccione la opción de conversión:");
            System.out.println("1. USD a CLP");
            System.out.println("2. CLP a USD");
            System.out.println("3. EUR a CLP");
            System.out.println("4. Salir");

            int opcion = scanner.nextInt();
            String fromCurrency = "";
            String toCurrency = "";

            switch (opcion) {
                case 1:
                    fromCurrency = "USD";
                    toCurrency = "CLP";
                    break;
                case 2:
                    fromCurrency = "CLP";
                    toCurrency = "USD";
                    break;
                case 3:
                    fromCurrency = "EUR";
                    toCurrency = "CLP";
                    break;
                case 4:
                    continuar = false;
                    System.out.println("Saliendo del programa.");
                    continue;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    continue;
            }

            System.out.print("Ingrese el monto a convertir: ");
            double amount = scanner.nextDouble();

            // Realizar la consulta a la API para obtener la tasa de cambio
            try {
                String urlStr = Base_URL + API_KEY + "/pair/" + fromCurrency + "/" + toCurrency;
                URL url = new URL(urlStr);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setRequestProperty("Content-Type", "application/json");

                int responseCode = connection.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    StringBuilder response = new StringBuilder();
                    String inputLine;

                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    in.close();

                    // Convertir la respuesta JSON a un objeto usando Gson
                    ExchangeRateResponse exchangeRateResponse = gson.fromJson(response.toString(), ExchangeRateResponse.class);

                    if ("success".equals(exchangeRateResponse.getResult())) {
                        double conversionRate = exchangeRateResponse.getConversionRate();
                        double convertedAmount = amount * conversionRate;
                        System.out.printf("Monto convertido: %.2f %s\n\n", convertedAmount, toCurrency);
                    } else {
                        System.out.println("Error en la respuesta de la API.");
                    }

                } else {
                    System.out.println("Error en la conexión: " + responseCode);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        scanner.close();
    }


}

