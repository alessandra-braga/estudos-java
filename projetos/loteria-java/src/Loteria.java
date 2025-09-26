import java.util.Scanner;
import java.util.Arrays;

public class Loteria {
    public static void main(String[] args) {
        
        // Cria vetor de 6 posições
        int sorteio[] = new int[6];

        // O número sorteado em cada rodada
        int numSorteado;

        // Preenche vetor de 6 posições
        for(int c=0; c<6; c++) {
            boolean repetido;

            do {
                // Gera um novo número aleatório
                // Formula para obter número aleatório entre menorValor e maiorValor:
                // (int) (menorValor + Math.random() * (maiorValor - menorValor))
                numSorteado = (int) (1 + Math.random() * (61 - 1));

                // Assume que o número NÃO é repetido antes de verificar
                repetido = false;

                // Verifica se no vetor já contém o número sorteado
                for(int i=0; i<6;i++) {
                    if (sorteio[i] == numSorteado) {
                        repetido = true;
                        break; // sai do for se já houver o número no vetor
                    }
                }

            } while (repetido == true);

            sorteio[c] = numSorteado;
        }

        // Ordena os números do sorteio
        Arrays.sort(sorteio);

        // Armazena números sorteados
        String numerosSorteados = "";

        for (int cc=0; cc<6;cc++) {
            numerosSorteados += sorteio[cc] + " ";
        }

        System.out.println("=========== SORTEIO MEGA SENA ===========");
        System.out.println("============ Faça sua aposta! ===========");
        System.out.println("     (Digite 6 números entre 1 e 60)     ");
        System.out.println("-----------------------------------------");

        // Cria um novo objeto para receber entrada do usuário
        Scanner teclado = new Scanner(System.in);

        // Cria vetor de 6 posições
        int aposta[] = new int[6];

        for(int a=0; a<6; a++) {
            System.out.print("Digite o " + (a + 1) + "º número: ");
            aposta[a] = teclado.nextInt();
        }

        // Armazena números da aposta
        String numerosApostados = "";

        for(int aa=0; aa<6; aa++) {
            numerosApostados += aposta[aa] + " ";
        }

        // Verifica número de acertos
        int qtdeAcertos = 0;
        String acertos = "";

        for(int j=0; j<6; j++){
            for(int k=0; k<6; k++) {
                if (aposta[k] == sorteio[j]) {
                    qtdeAcertos++;
                    acertos += aposta[k] + " ";
                }
            }
        }

        // Verificação dos resultados
        System.out.println("=========================================");
        System.out.println("Números sorteados: " + numerosSorteados);
        System.out.println("Você apostou os números: " + numerosApostados);
        System.out.println("-----------------------------------------");
        System.out.println("Quantidade de acertos: " + qtdeAcertos);
        System.out.println("Você acertou o(s) número(s): " + acertos);
        System.out.println("-----------------------------------------");
        if (qtdeAcertos == 6) {
            System.out.println("Parabéns, você é o mais novo milionário!");
            System.out.println("Você ganhou o prêmio no valor de R$200.000.00!");
        } else if (qtdeAcertos == 5) {
            System.out.println("Parabéns, você acertou a Quina milionária!");
            System.out.println("Você ganhou o prêmio no valor de R$10.000.00!");
        } else if (qtdeAcertos == 4) {
            System.out.println("Parabéns, você acertou a Quadra!");
            System.out.println("Você ganhou o prêmio no valor de R$50.000!");
        } else {
            System.out.println("Não foi dessa vez! Boa sorte na próxima!");
        }
        System.out.println("-----------------------------------------");

    }
}
