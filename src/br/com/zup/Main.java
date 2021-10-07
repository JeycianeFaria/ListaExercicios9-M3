package br.com.zup;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        String tipoSelecionado;
        Sistema.menuTipoPessoa();
        System.out.println("Digite a opção:");
        tipoSelecionado = leitor.nextLine();

        try{
            System.out.println(ServicoConsumidor.validarTipoPessoa(tipoSelecionado));
        }catch (Exception erro){
            System.out.println(erro.getMessage());
        }


    }
}
