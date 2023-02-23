
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 20211GR.ADS0003
 */
public class Forca implements Desenhavel, Jogavel {

     private List<String> palavras = Arrays.asList("banana", "alfazema", "monstros", "gaivota", "lula");
    private List<Character> tentativas = new ArrayList<>();
    private char[] palavraSorteada = palavras.get(new Random().nextInt(palavras.size())).toCharArray();
    private char[] palavraDigitada;
    private int erros;

    public Forca() {
        palavraDigitada = new char[palavraSorteada.length];
        for (int i = 0; i < palavraSorteada.length; i++) {
            palavraDigitada[i] = '-';
        }
        
    }

    @Override
    public void desenha() {
         System.out.println("=======================================");

        if(erros == 1) {
            System.out.println("    o");
        }
        if (erros == 2) {
            System.out.println("    o");
            System.out.println("  /");
        }
        if(erros == 3) {
            System.out.println("    o");
            System.out.println("  / |");
        }
        if (erros == 4) {
            System.out.println("    o");
            System.out.println("  / | \\ ");
        }
        if (erros == 5) {
            System.out.println("    o");
            System.out.println("  / | \\ ");
            System.out.println("   /");
        }
        if (erros == 6) {
            System.out.println("    o");
            System.out.println("  / | \\ ");
            System.out.println("   / \\ ");
        }

        System.out.println("Letras digitadas: " + getTentativas());
        System.out.println("Palavra digitada: " + Arrays.toString(palavraDigitada));
        System.out.println("Digite uma letra: ");

        System.out.println("=======================================");

    }

    public void jogar(char letra) {
        if (!(Arrays.toString(palavraSorteada).contains(letra + ""))) {
            System.out.println("Letra não encontrada");
            tentativas.add(letra);
            erros++;
        }

        if (Arrays.toString(palavraSorteada).contains(letra + "")) {
            tentativas.add(letra);

            for (int i = 0; i < palavraSorteada.length; i++) {
                if (letra == palavraSorteada[i]) {
                    palavraDigitada[i] = letra;
                }
            }
        }

        if (Arrays.toString(palavraDigitada).contains(letra + "")) {
            System.out.println("Letra já utilizada");
        }
    }

    public int verificaFim() {
        if (Arrays.toString(palavraDigitada).equals(Arrays.toString(palavraSorteada))) {
            System.out.println("Você acertou a palavra! Parabéns!");
            return 1;
        }

        if(erros == 6) {
            System.out.println("Ops! Jogo chegou ao fim! Você atingiu o limite de erros!");
            return 2;
        }

        return 0;
    }

    public List<Character> getTentativas() {
        return tentativas;
    }

    public char[] getPalavraDigitada() {
        return palavraDigitada;
    }

    public int getErros() {
        return erros;
    }

    @Override
    public void joga(char a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int veificaFim() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
