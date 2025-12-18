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
             * ENTENDENDO A LÓGICA DO FLUXO COMPLETO:
             * 1. DECLARAÇÃO E ATRIBUIÇÃO: Assim como 'String nome = "Maki"' define que a variável segue o molde da CLASSE String,
             * 'Endereco novoEndereco' reserva um espaço na memória para um objeto que segue o molde do RECORD Endereco.
             * Essa variável recebe o OBJETO RESULTANTE que o metodo 'buscaEndereco' fabricou após consultar a internet.
             *
             * 2. EXIBIÇÃO: 'System.out.println(novoEndereco)' usa o metodo interno do Record para mostrar na tela
             * os dados que foram capturados (Estado do Objeto).
             *
             * 3. COLABORAÇÃO ENTRE OBJETOS: Criamos uma nova instância 'GeradorDeArquivo gerador'. Esse objeto é um
             * "especialista" em salvar arquivos. Ao chamarmos 'gerador.salvaJson(novoEndereco)', passamos o nosso
             * objeto completo como parâmetro para que ele seja transformado em um arquivo físico (.json).
             *
             * 4. A REDE DE SEGURANÇA (TRY-CATCH): O bloco 'try' tenta realizar toda essa operação. Se a internet falhar
             * (RuntimeException) ou se o disco estiver cheio/protegido (IOException), o Java captura o erro no objeto 'e'.
             *
             * 5. FINALIZAÇÃO: Em vez do programa "quebrar", o 'catch' exibe a mensagem de erro amigável e finaliza
             * a aplicação de forma controlada.
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
