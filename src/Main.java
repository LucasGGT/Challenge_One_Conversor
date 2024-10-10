import br.com.alura.conversor.modelos.Conversao;
import br.com.alura.conversor.modelos.ConversaoAPI;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int opcao = 0;
        String menu = """
                Conversor de Moeda:
                
                1 - Dólar -> Peso Argentino
                2 - Peso Argentino -> Dólar
                3 - Dólar -> Real Brasileiro
                4 - Real Brasileiro -> Dólar
                5 - Dólar -> Peso Colombiano
                6 - Peso Colombiano -> Dólar
                7 - Sair
                
                Escolha a conversão que deseja fazer: """;

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        var api_key = "API_KEY_AQUI";
        double valor = 0.0;

        while (opcao < 7) {
            System.out.print(menu);
            opcao = scanner.nextInt();

            if (opcao < 7) {
                System.out.println("\nDigite o valor a ser convertido: ");
                valor = scanner.nextDouble();
            }
            var url = "";

            switch (opcao) {
                case 1:
                    url = "https://v6.exchangerate-api.com/v6/" + api_key + "/latest/USD";

                    try {
                        HttpClient client = HttpClient.newHttpClient();
                        HttpRequest request = HttpRequest.newBuilder()
                                .uri(URI.create(url))
                                .build();
                        HttpResponse<String> response = client
                                .send(request, HttpResponse.BodyHandlers.ofString());

                        String json = response.body();
                        ConversaoAPI conversaoAPI = gson.fromJson(json, ConversaoAPI.class);
                        Conversao conversao = new Conversao(conversaoAPI);

                        System.out.println("\n" + conversao.getUsd() * valor +
                                " Dólar(es) corresponde a " + conversao.getArs() * valor + " Peso(s) Argentino(s).\n");
                    } catch (IllegalArgumentException | IOException | InterruptedException e) {
                        System.out.println("Aconteceu um erro: " + e.getMessage());
                    }
                    break;
                case 2:
                    url = "https://v6.exchangerate-api.com/v6/" + api_key + "/latest/ARS";

                    try {
                        HttpClient client = HttpClient.newHttpClient();
                        HttpRequest request = HttpRequest.newBuilder()
                                .uri(URI.create(url))
                                .build();
                        HttpResponse<String> response = client
                                .send(request, HttpResponse.BodyHandlers.ofString());

                        String json = response.body();
                        ConversaoAPI conversaoAPI = gson.fromJson(json, ConversaoAPI.class);
                        Conversao conversao = new Conversao(conversaoAPI);

                        System.out.println("\n" + conversao.getArs() * valor +
                                " Peso(s) Argentino(s) corresponde a " + conversao.getUsd() * valor + " Dólar(es).\n");
                    } catch (IllegalArgumentException | IOException | InterruptedException e) {
                        System.out.println("Aconteceu um erro: " + e.getMessage());
                    }
                    break;
                case 3:
                    url = "https://v6.exchangerate-api.com/v6/" + api_key + "/latest/USD";

                    try {
                        HttpClient client = HttpClient.newHttpClient();
                        HttpRequest request = HttpRequest.newBuilder()
                                .uri(URI.create(url))
                                .build();
                        HttpResponse<String> response = client
                                .send(request, HttpResponse.BodyHandlers.ofString());

                        String json = response.body();
                        ConversaoAPI conversaoAPI = gson.fromJson(json, ConversaoAPI.class);
                        Conversao conversao = new Conversao(conversaoAPI);

                        System.out.println("\n" + conversao.getUsd() * valor +
                                " Dólar(es) corresponde a " + conversao.getBrl() * valor + " Real(is).\n");
                    } catch (IllegalArgumentException | IOException | InterruptedException e) {
                        System.out.println("Aconteceu um erro: " + e.getMessage());
                    }
                    break;
                case 4:
                    url = "https://v6.exchangerate-api.com/v6/" + api_key + "/latest/BRL";

                    try {
                        HttpClient client = HttpClient.newHttpClient();
                        HttpRequest request = HttpRequest.newBuilder()
                                .uri(URI.create(url))
                                .build();
                        HttpResponse<String> response = client
                                .send(request, HttpResponse.BodyHandlers.ofString());

                        String json = response.body();
                        ConversaoAPI conversaoAPI = gson.fromJson(json, ConversaoAPI.class);
                        Conversao conversao = new Conversao(conversaoAPI);

                        System.out.println("\n" + conversao.getBrl() * valor +
                                " Real(is) corresponde a " + conversao.getUsd() * valor + " Dólar(es).\n");
                    } catch (IllegalArgumentException | IOException | InterruptedException e) {
                        System.out.println("Aconteceu um erro: " + e.getMessage());
                    }
                    break;
                case 5:
                    url = "https://v6.exchangerate-api.com/v6/" + api_key + "/latest/USD";

                    try {
                        HttpClient client = HttpClient.newHttpClient();
                        HttpRequest request = HttpRequest.newBuilder()
                                .uri(URI.create(url))
                                .build();
                        HttpResponse<String> response = client
                                .send(request, HttpResponse.BodyHandlers.ofString());

                        String json = response.body();
                        ConversaoAPI conversaoAPI = gson.fromJson(json, ConversaoAPI.class);
                        Conversao conversao = new Conversao(conversaoAPI);

                        System.out.println("\n" + conversao.getUsd() * valor +
                                " Dólar(es) corresponde a " + conversao.getCop() * valor + " Peso(s) Colombiano(s).\n");
                    } catch (IllegalArgumentException | IOException | InterruptedException e) {
                        System.out.println("Aconteceu um erro: " + e.getMessage());
                    }
                    break;
                case 6:
                    url = "https://v6.exchangerate-api.com/v6/" + api_key + "/latest/COP";

                    try {
                        HttpClient client = HttpClient.newHttpClient();
                        HttpRequest request = HttpRequest.newBuilder()
                                .uri(URI.create(url))
                                .build();
                        HttpResponse<String> response = client
                                .send(request, HttpResponse.BodyHandlers.ofString());

                        String json = response.body();
                        ConversaoAPI conversaoAPI = gson.fromJson(json, ConversaoAPI.class);
                        Conversao conversao = new Conversao(conversaoAPI);

                        System.out.println("\n" + conversao.getCop() * valor +
                                " Peso(s) Colombiano(s) corresponde a " + conversao.getUsd() * valor + " Dólar(es).\n");
                    } catch (IllegalArgumentException | IOException | InterruptedException e) {
                        System.out.println("Aconteceu um erro: " + e.getMessage());
                    }
                    break;
            }
        }
    }
}
