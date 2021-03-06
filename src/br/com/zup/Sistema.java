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
        System.out.println("Digite 3 - para pesquisar as faturas do consumidor.");
        System.out.println("Digite 4 - para sair.");
    }

    public  static void menuTipoPessoa(){
        System.out.println("======Tipos de Pessoas======");
        for(TipoPessoa referencia: TipoPessoa.values()){
            System.out.println("Digite " + referencia.ordinal() +  " para: " + referencia);
        }
    }


    public static Consumidor cadastrarConsumidor() throws Exception{
        String nome = capturaDeDados("Digite o nome do consumidor: ").nextLine();
        String email = capturaDeDados("Digite o email do consumidor: ").nextLine();
        ServicoConsumidor.validarEmail(email);
        ServicoConsumidor.verificarEmail(email);
        menuTipoPessoa();
        int tipoPessoa = capturaDeDados("Digite o tipo de pessoa: ").nextInt();
        TipoPessoa tipoSelecionado = ServicoConsumidor.validarTipoPessoa(tipoPessoa);
        Consumidor consumidor = ServicoConsumidor.cadastrarConsumidor(nome,email,tipoSelecionado);

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

    public static List<Fatura> pesquisarFaturaConsumidor() throws Exception{
        String email = capturaDeDados("Digite o email do consumidor ao qual  deseja pesquisar as faturas: ").nextLine();
        ServicoConsumidor.validarEmail(email);
        Consumidor consumidor = ServicoConsumidor.buscarConsumidor(email);
        List<Fatura> faturasConsumidor = ServicoFatura.pesquisarFaturaConsumidor(consumidor);

        return faturasConsumidor;
    }


    public static boolean executar() throws Exception{
        boolean executarMenu = true;

        while (executarMenu){

            menu();
            int opcaoSelecionado = capturaDeDados("Digite a op????o desejada: ").nextInt();

            if (opcaoSelecionado == 1){
                //cadastrar consumidor
                Consumidor consumidor = cadastrarConsumidor();
                System.out.println(consumidor);

            }else if(opcaoSelecionado == 2){
                //cadastrar Fatura
                Fatura fatura =  cadastrarFatura();
                System.out.println(fatura);

            }else if (opcaoSelecionado == 3){
               //pesquisar faturas
                List<Fatura> faturas = pesquisarFaturaConsumidor();
                System.out.println(faturas);

            }else if (opcaoSelecionado == 4){
                //sair
                executarMenu = false;
                System.out.println("At?? a Proxima");
            }
            else{
                System.out.println("Op????o selecionada inv??lida!");
            }

        }

       return executarMenu;

    }

}
