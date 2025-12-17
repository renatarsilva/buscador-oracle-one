public class Principal {
    public static void main(String[] args) {
        ConsultaCEP consultaCEP = new ConsultaCEP();
        Endereco novoEndereco = consultaCEP.buscaEndereco("01001000");
        System.out.println(novoEndereco);
    }
}
