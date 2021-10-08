package br.com.zup;

import java.util.ArrayList;
import java.util.List;

public class ServicoConsumidor {

    private static List<Consumidor> consumidores = new ArrayList<>();

    public static List<TipoPessoa> exibirTiposPessoas() {
        List<TipoPessoa> tiposPessoas = new ArrayList<>();

        for (TipoPessoa referencia : TipoPessoa.values()) {
            tiposPessoas.add(referencia);
        }

        return tiposPessoas;

    }


     public static TipoPessoa validarTipoPessoa(int tipoSelecionado) throws ArrayIndexOutOfBoundsException{
        for (TipoPessoa referencia: exibirTiposPessoas()){
            if (referencia.equals(exibirTiposPessoas().get(tipoSelecionado))){
                return referencia;
            }
        }

        throw new ArrayIndexOutOfBoundsException("Opção selecionada inválida");

    }

    public static void validarEmail(String email) throws Exception{
        if (!email.contains("@")) {
            throw new Exception("Email digitado inválido");
        }
    }

    public static void verificarEmail(String email) throws Exception{
        for (Consumidor referencia:consumidores){
            if (referencia.getEmail().equals(email)){
                throw new Exception("Email já cadastrado, digite novamente!");
            }
        }
    }


    public static Consumidor cadastrarConsumidor(String nome, String email, int tipoSelecionado) throws Exception {

        TipoPessoa tipoPessoa = validarTipoPessoa(tipoSelecionado);
        Consumidor consumidor = new Consumidor(nome, email, tipoPessoa);
        consumidores.add(consumidor);

        return consumidor;

    }

    public static Consumidor buscarConsumidor(String email) throws Exception {
        for (Consumidor referencia : consumidores) {
            if (referencia.getEmail().equals(email)) {
                return referencia;
            }
        }

        throw new Exception("Email não encontrado!");
    }


}
