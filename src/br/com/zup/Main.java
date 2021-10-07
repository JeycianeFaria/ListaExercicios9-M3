package br.com.zup;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try{
            Sistema.cadastrarConsumidor();
        }catch (Exception erro){
            System.out.println(erro.getMessage());
        }
    }
}
