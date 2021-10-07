package br.com.zup;

public class Fatura {

    private Consumidor consumidor;
    private double valorASerPago;
    private String dataVencimento;


    public Fatura() {
    }

    public Fatura(Consumidor consumidor, double valorASerPago, String dataVencimento) {
        this.consumidor = consumidor;
        this.valorASerPago = valorASerPago;
        this.dataVencimento = dataVencimento;
    }


    public Consumidor getConsumidor() {
        return consumidor;
    }

    public void setConsumidor(Consumidor consumidor) {
        this.consumidor = consumidor;
    }

    public double getValorASerPago() {
        return valorASerPago;
    }

    public void setValorASerPago(double valorASerPago) {
        this.valorASerPago = valorASerPago;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    @Override
    public String toString() {
        StringBuilder exibir = new StringBuilder();
        exibir.append("\n======Fatura======");
        exibir.append("\nConsumidor: " + consumidor);
        exibir.append("\nValor da Fatura: " + valorASerPago);
        exibir.append("\nData de Vencimento: " + dataVencimento);
        exibir.append("\n==================");
        return exibir.toString();
    }

}
