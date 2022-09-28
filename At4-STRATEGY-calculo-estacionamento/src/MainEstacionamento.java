

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

class MainEstacionamento {

	public static void main(String[] args) {
		
        Veiculo veiculo = new Veiculo("ABC-123",  "Chevrolet Onix", "Azul");
		// Calculo do total a pagar por Hora
        LocalDateTime entrada = LocalDateTime.of(2022, 8, 1, 11, 0, 0);
        LocalDateTime saida = LocalDateTime.of(2022,8, 1, 12, 10, 0);
        Estacionamento estacionamento = new Estacionamento(entrada, saida, veiculo);

       
        
        System.out.println("Pagamento por Hora");
        System.out.println("-------------------");
        System.out.println(estacionamento.obterTotalAPagar());
        
        // Calculo do total a pagar por Diaria
        entrada = LocalDateTime.of(2022, 8, 1, 0, 0, 0);
        saida = LocalDateTime.of(2022,8, 5, 0, 0, 0);
        estacionamento.setEntrada(entrada);
        estacionamento.setSaida(saida);
        estacionamento.setVeiculo(veiculo);

        System.out.println("\nPagamento por Diaria");
        System.out.println("---------------------");
        System.out.println(estacionamento.obterTotalAPagar());
        
        // Calculo do total a pagar por mensalidade
        entrada = LocalDateTime.of(2022, 7, 1, 0, 0, 0);
        saida = LocalDateTime.of(2022,8, 5, 0, 0, 0);
        estacionamento.setEntrada(entrada);
        estacionamento.setSaida(saida);
        estacionamento.setVeiculo(veiculo);

        System.out.println("\nPagamento por Mensalidade");
        System.out.println("---------------------");
        System.out.println(estacionamento.obterTotalAPagar());

	}
}
