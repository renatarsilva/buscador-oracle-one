import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

/*
 * LÓGICA DA CLASSE GERADOR DE ARQUIVO:
 * 1. A classe 'GeradorDeArquivo' não possui atributos, servindo apenas para abrigar
 * o metodo 'salvaJson', que é 'void' (não retorna valor, apenas executa uma ação).
 * 2. O parâmetro 'endereco' é do tipo 'Endereco', exigindo que o objeto passado
 * cumpra todos os requisitos e possua os dados definidos no Record Endereco.
 * 3. 'throws IOException': Indica que o metodo pode gerar um erro de entrada/saída
 * (como falta de espaço no disco) e avisa quem o chama para estar preparado.
 * 4. Instancia o objeto 'gson' via 'GsonBuilder' com 'Method Chaining'
 * (.setPrettyPrinting().create()) para garantir que o JSON seja gerado de forma organizada.
 * 5. Cria o objeto 'escrita' (FileWriter), que abre o arquivo físico usando o
 * nome 'cep() + .json'.
 * 6. O metodo 'write' converte o objeto 'endereco' em texto JSON e o grava no arquivo.
 * 7. 'escrita.close()' encerra a conexão com o arquivo, garantindo que os dados sejam salvos.
 */

public class GeradorDeArquivo {

    public void salvaJson(Endereco endereco) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter escrita = new FileWriter(endereco.cep() + ".json");
        escrita.write(gson.toJson(endereco));
        escrita.close();
    }
}
