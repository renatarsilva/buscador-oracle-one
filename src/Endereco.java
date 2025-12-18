public record Endereco(String cep, String logradouro, String Complemento,
                       String unidade, String Bairro, String localidade, String uf
                       ) {
    public void write(String json) {
    }

    // Record foi usado porque é uma classe que só tem atributos
}
