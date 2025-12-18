import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * LÓGICA DA CLASSE E DO METODO DE CONSULTA:
 * * 1. A classe 'ConsultaCEP' funciona como uma classe de serviço: não possui atributos,
 * apenas o metodo público 'buscaEndereco'.
 * 2. O metodo retorna um objeto do tipo 'Endereco', o que significa que o resultado
 * final deve seguir obrigatoriamente o "molde" definido no Record Endereco.
 * 3. O metodo recebe o parâmetro 'String cep', que é o ingrediente necessário para a busca.
 * 4. Internamente, utiliza a classe 'URI' para criar o endereço web da API através
 * do metodo estático 'URI.create'.
 * 5. Para a comunicação, utiliza o objeto 'HttpRequest' da biblioteca padrão do Java.
 * A construção da requisição utiliza 'Method Chaining' (.newBuilder().uri().build()),
 * onde cada metodo configura uma parte do objeto e o entrega pronto no final.
 */

public class ConsultaCEP {


    public Endereco buscaEndereco(String cep){

        URI endereco = URI.create("https://viacep.com.br/ws/"+cep+"/json/");

        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();

        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(),Endereco.class);
        } catch (Exception e) {
            throw new RuntimeException("Não consegui obter o endereço a partir desse CEP.");
        }

    }
}
