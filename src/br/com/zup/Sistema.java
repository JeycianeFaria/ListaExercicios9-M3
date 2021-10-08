package br.com.zup;

import java.util.EnumMap;
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


    public static Consumidor cadastrarConsumidor() throws Exception{
        String nome = capturaDeDados("Digite o nome do consumidor: ").nextLine();
        String email = capturaDeDados("Digite o email do consumidor: ").nextLine();
        ServicoConsumidor.validarEmail(email);
        menuTipoPessoa();
        String tipoPessoa = capturaDeDados("Digite o tipo de pessoa: ").nextLine();
        ServicoConsumidor.validarTipoPessoa(tipoPessoa);
        Consumidor consumidor = ServicoConsumidor.cadastrarConsumidor(nome,email,tipoPessoa);

        return consumidor;

    }

    public static Fatura cadastrarFatura() throws Exception{
        String email = capturaDeDados("Digite o email do consumidor ao qual  deseja cadastrar a fatura: ").nextLine();
        ServicoConsumidor.validarEmail(email);
        Consumidor consumidor = ServicoConsumidor.buscarConsumidor(email);
        double valorFatura = capturaDeDados("Digite o valor da fatura: ").nextDouble();
        String dataVencimento = capturaDeDados("Digite a data de vencimento da fatura: ").nextLine();
        Fatura fatura = ServicoFatura.cadastrarFatura(consumidor,valorFatura,dataVencimento);

        return  fatura;
    }


    public static boolean executar() throws Exception{
        boolean executarMenu = true;

        while (executarMenu){

            menu();
            int opcaoSelecionado = capturaDeDados("Digite a opção desejada: ").nextInt();

            if (opcaoSelecionado == 1){
                //cadastrar consumidor
                Consumidor consumidor = cadastrarConsumidor();
                System.out.println(consumidor);

            }else if(opcaoSelecionado == 2){
                //cadastrar Fatura
                Fatura fatura =  cadastrarFatura();
                System.out.println(fatura);

            }else if (opcaoSelecionado == 3){
                //sair
                executarMenu = false;
                System.out.println("Até a Proxima");

            }else{
                System.out.println("Opção selecionada inválida!");
            }

        }

       return executarMenu;

    }

}
