
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

    private List<String> palavras = Arrays.asList("macaco", "caverna", "escola", "peixe"); 
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
    }

    @Override
    public void joga(char a) {
        if (!(Arrays.toString(palavraSorteada).contains(a + ""))) {
            System.out.println("A palavra não contém a letra digitada");
            
            tentativas.add(a);
            erros++;
        }

        if (Arrays.toString(palavraSorteada).contains(a + "")) {
            tentativas.add(a);

            for (int i = 0; i < palavraSorteada.length; i++) {
                if (a == palavraSorteada[i]) {
                    palavraDigitada[i] = a;
                }
            }
        }

        if (Arrays.toString(palavraDigitada).contains(a + "")) {
            System.out.println("Você já utilizou essa letra");
            
        }
    }

    @Override
    public int verificaFim() {
        if (Arrays.toString(palavraDigitada).equals(Arrays.toString(palavraSorteada))) {
            System.out.println("Feito você acertou a palavra!! Parabéns!");
            
            return 1;
        }

        if(erros == 6) {
            System.out.println("Que pena! Jogo chegou ao fim! Você atingiu o limite de tentativas!");
            
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

}
