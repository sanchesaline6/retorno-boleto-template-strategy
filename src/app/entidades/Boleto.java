package app.entidades;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Boleto {

    private int id;
    private String codBanco;
    private LocalDate dataVencimento;
    private LocalDate dataPagamento;
    private String cpfCliente;
    private double valor;
    private double multa;
    private double juros;
    private String agencia;
    private String contaBancaria;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodBanco() {
        return codBanco;
    }

    public void setCodBanco(String codBanco) {
        this.codBanco = codBanco;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getMulta() {
        return multa;
    }

    public void setMulta(double multa) {
        this.multa = multa;
    }

    public double getJuros() {
        return juros;
    }

    public void setJuros(double juros) {
        this.juros = juros;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getContaBancaria() {
        return contaBancaria;
    }

    public void setContaBancaria(String contaBancaria) {
        this.contaBancaria = contaBancaria;
    }

    @Override
    public String toString() {
        String str = String.format("ID: %10d Banco: %3s", id, codBanco);
        String ag = "";
        if(agencia != null && !agencia.isEmpty() && contaBancaria != null && !contaBancaria.isEmpty()){
            ag = String.format(" Ag: %6s CC: %10s", agencia, contaBancaria);
        }

        str += ag + String.format(
                " Venc: %s Pag: %s Valor: %10.2f",
                ProcessadorBoletos.FORMATO_DATA.format(dataVencimento),
                ProcessadorBoletos.FORMATO_DATA_HORA.format(dataPagamento), valor);

                if(multa > 0) {
                    str += String.format(" Multa: %10.2f", multa);
                }

                if(juros > 0){
                    str += String.format(" Juros: %10.2f", juros);
                }

                return str;
    }
}
