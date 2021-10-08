package br.com.zup;

import java.util.ArrayList;
import java.util.List;

public class ServicoFatura {

    private static List<Fatura> faturas = new ArrayList<>();

    public static Fatura cadastrarFatura(Consumidor consumidor, double valorFatura, String dataVencimento){
        Fatura fatura = new Fatura(consumidor,valorFatura,dataVencimento);
        faturas.add(fatura);

        return fatura;
    }

    public static List<Fatura> pesquisarFaturaConsumidor(Consumidor consumidor){
        List<Fatura> faturasConsumidor = new ArrayList<>();
        for (Fatura referencia:faturas){
            if (referencia.getConsumidor().equals(consumidor)){
                faturasConsumidor.add(referencia);
            }
        }

        return faturasConsumidor;
    }

}
