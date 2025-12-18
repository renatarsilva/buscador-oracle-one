import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ConsultaCEP consultaCEP = new ConsultaCEP();

        System.out.println("Digite o CEP (sem hífen)");
        var cep = sc.nextLine();
        sc.close();

        try{
            /*
             * ENTENDENDO A LÓGICA DO FLUXO:
             * 1. Assim como 'String nome = "Maki"' define que a variável 'nome' segue o molde da CLASSE String,
             * 'Endereco novoEndereco' define que a variável 'novoEndereco' (um espaço na memória)
             * segue o molde da CLASSE Endereco.
             * * 2. A variável 'novoEndereco' recebe o OBJETO RESULTANTE do metodo 'buscaEndereco',
             * que pertence à instância 'consultaCEP'.
             * * 3. O metodo 'buscaEndereco' utiliza o parâmetro 'cep', que foi capturado
             * pelo Scanner através da digitação do usuário.
             * * 4. EM RESUMO: O Java cria a classe (molde), define atributos/métodos, instancia objetos
             * e faz esses objetos colaborarem entre si para executar a tarefa.
             */

            Endereco novoEndereco = consultaCEP.buscaEndereco(cep);
            System.out.println(novoEndereco);
            GeradorDeArquivo gerador = new GeradorDeArquivo();
            gerador.salvaJson(novoEndereco);
        } catch (RuntimeException | IOException e){
            System.out.println(e.getMessage());
            System.out.println("Finalizando a aplicação");
        }


    }
}
