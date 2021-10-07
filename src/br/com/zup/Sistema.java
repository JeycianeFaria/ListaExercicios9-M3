package br.com.zup;

import java.util.List;
import java.util.Scanner;

public class Sistema {

    public static Scanner capturaDeDados(String mensagem){
        System.out.println(mensagem);
        return new Scanner(System.in);
    }

    public static void menu(){
        System.out.println("\n======Bem Vindo=======");
        System.out.println("Digite 1 - para cadastrar um consumidor.");
        System.out.println("Digite 2 - para cadastrar uma fatura.");
        System.out.println("Digite 3 - para sair.");
    }

    public  static void menuTipoPessoa(){

        List<TipoPessoa> tipoPessoas = ServicoConsumidor.exibirTiposPessoas();

        System.out.println("======Tipos de Pessoas======");
        for (int contador = 0; contador < tipoPessoas.size();contador++){
            //System.out.println("Digite " + contador + " para: " + tipoPessoas.get(contador));
            System.out.println(tipoPessoas.get(contador));
        }

    }

}
