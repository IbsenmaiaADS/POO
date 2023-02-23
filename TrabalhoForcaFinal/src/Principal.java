import java.util.Scanner;

/**
 *
 * @author 20211GR.ADS0003
 */
public class Principal {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        Forca forca = new Forca();

        do {
            System.out.print("Digite uma letra: ");
            forca.joga(leitura.nextLine().charAt(0));
            forca.desenha();
        } while (forca.verificaFim() == 0);
    }
}
