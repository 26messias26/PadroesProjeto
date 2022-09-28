import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;

public class Estacionamento {

    private LocalDateTime entrada;
    private LocalDateTime saida;
    private Veiculo veiculo;

    //BigDecimal: ponto flutuante em que é possível estipular o nível de precisão desejado
    public static BigDecimal VALOR_HORA = new BigDecimal("2.00");
    public static BigDecimal VALOR_DIARIA = new BigDecimal("26.00");
    public static BigDecimal VALOR_MENSALIDADE = new BigDecimal("300.00");

    
    public Estacionamento(LocalDateTime entrada, LocalDateTime saida, Veiculo veiculo) {
    	this.entrada = entrada;
    	this.saida = saida;
    	this.veiculo = veiculo;
    }

    public LocalDateTime getEntrada() {
		return entrada;
	}

	public void setEntrada(LocalDateTime entrada) {
		this.entrada = entrada;
	}

	public LocalDateTime getSaida() {
		return saida;
	}

	public void setSaida(LocalDateTime saida) {
		this.saida = saida;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

    public BigDecimal obterTotalAPagar() {
        assert(entrada != null && saida != null && veiculo != null);
        // duration representa um intervalo de tempo em segundos ou nanosegundos         
        long periodoHoras = Duration.between(entrada, saida).toHours();
        long periodoDias = Duration.between(entrada, saida).toDays();

        BigDecimal valor = new BigDecimal(0);
        if (periodoHoras < 12) {
            valor = VALOR_HORA.multiply(new BigDecimal(periodoHoras));
        } else if (periodoHoras > 12 && periodoDias < 15) {
            valor = VALOR_DIARIA.multiply(new BigDecimal(periodoDias));
        } else if (periodoDias > 15) {
            valor = VALOR_MENSALIDADE;
        }

        return valor;
    }

}
