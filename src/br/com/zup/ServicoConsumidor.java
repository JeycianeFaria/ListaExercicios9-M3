package br.com.zup;

import java.util.ArrayList;
import java.util.List;

public class ServicoConsumidor {

    private static List<Consumidor> consumidores = new ArrayList<>();

    public  static List<TipoPessoa> exibirTiposPessoas(){
        List<TipoPessoa> tiposPessoas = new ArrayList<>();

        for (TipoPessoa referencia: TipoPessoa.values()){
            tiposPessoas.add(referencia);
        }

        return tiposPessoas;

    }

}
