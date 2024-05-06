package coinconverter.request;

import coinconverter.model.Coin;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Request {
    String key = "API KEY AQUI";



    public void fazerRequisicao(String from, String to, double amount) {
        URI address = URI.create("https://v6.exchangerate-api.com/v6/" + key + "/pair/" + from + "/" + to);
        HttpRequest request = HttpRequest.newBuilder().uri(address).build();

        try {
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            Gson gson = new GsonBuilder().setLenient().setPrettyPrinting().create();
            var coin = gson.fromJson(json, Coin.class);
            double result = coin.conversionrate() * amount;
            String formatedResult = String.format("%.5f", result);
            System.out.println("Convertendo " + amount + " " + coin.basecode() + " para " + coin.targetcode() + " = " + formatedResult);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Aconteceu um erro: " + e);
        }
    }
}
