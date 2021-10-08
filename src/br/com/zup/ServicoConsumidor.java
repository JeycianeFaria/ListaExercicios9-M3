package br.com.zup;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;

public class ServicoConsumidor {

    private static List<Consumidor> consumidores = new ArrayList<>();


    public static TipoPessoa validarTipoPessoa(int tipoSelecionado) throws Exception{

        for (TipoPessoa referencia: TipoPessoa.values()) {
            if (referencia.ordinal() == tipoSelecionado) {
                return referencia;
            }
        }

         throw new Exception("Opção selecionada inválida");

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
