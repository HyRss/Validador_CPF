package Desafios;
import java.util.Scanner;
public class Validador_cpf {

	public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

    char again = 's';
	while (again == 'S' || again == 's') {
		

    System.out.print("Digite o CPF a ser analisado: ");
	String cpf = scn.next();
	// Filtro de remoção de caracteres especiais
	cpf = cpf.replaceAll("[^0-9]", "");
	// Cal_d1
	char[] cpfArray = cpf.toCharArray();
	int soma = 0;
	for (int i = 0; i < 9; i++) {
	int digito = Character.getNumericValue(cpfArray[i]);
	soma += digito * (10 - i);
	}
	int d1 = (soma * 10) % 11;
	
	if (d1 == 10) {
	d1 = 0;
	}
	// Cal_d2
	int soma2 = 0;
	for (int i = 0; i < 10; i++) {
	int digito = Character.getNumericValue(cpfArray[i]);
	soma2 += digito * (11 - i);
	}
	int d2 = (soma2 * 10) % 11;
	
	if (d2 == 10) {
	d2 = 0;
	}
    // Verificação (válida ou inválida)
	int Pd = Character.getNumericValue(cpfArray[9]);
	int Sd = Character.getNumericValue(cpfArray[10]);
	if (d1 == Pd && d2 == Sd) {
	   System.out.println("CPF válido");
	}else 
	   System.out.println("CPF inválido");
	//Loop
	 System.out.print("Deseja verificar outro CPF? (S/N): ");
     scn.nextLine();
     again = scn.nextLine().charAt(0);
                         }
     System.out.println("Programa encerrado.");
     scn.close();
            }
}