package br.com.zup;

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

}
