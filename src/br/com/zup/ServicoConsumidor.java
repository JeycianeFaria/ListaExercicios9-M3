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

    public static TipoPessoa validarTipoPessoa(String  tipoSelecionado) throws Exception{
       for (TipoPessoa referencia:TipoPessoa.values()){
           if (tipoSelecionado.equalsIgnoreCase(String.valueOf(referencia))){
               return referencia;
           }
       }

        throw new Exception("Opção digitada inválida");
    }

     /*public static TipoPessoa validarTipoPessoa(int tipoSelecionado) throws Exception{
        for (TipoPessoa referencia: TipoPessoa.values()){
            if (referencia.equals(exibirTiposPessoas().get(tipoSelecionado))){
                return referencia;
            }
        }

        throw new Exception("Opção selecionada inválida");
    }*/


}
