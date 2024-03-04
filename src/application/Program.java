package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import entities.MoedaDolar;
import entities.MoedaEuro;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		String pathEmployee = "F:\\temp\\inEmployee.txt";
		List<Employee> listEmployee = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(pathEmployee))) {

			String listEmp = br.readLine();
			while (listEmp != null) {
				String[] fields = listEmp.split(",");
				listEmployee.add(new Employee(fields[0], Integer.parseInt(fields[1])));
				listEmp = br.readLine();
			}

			for (Employee emp : listEmployee) {
				System.out.println(emp);
			}

			System.out.println("Ola, qual seu nome?");
			String nameEmployee = sc.next();
			sc.nextLine(); // Limpar o buffer do teclado

			System.out.println("Qual o codigo da sua conta?");
			int codeAcc = sc.nextInt();


			boolean found = false;
			for (Employee emp : listEmployee) {
				String[] parts = emp.getName().split(" ");
				for (String part : parts) {
					if (part.equalsIgnoreCase(nameEmployee) && codeAcc == emp.getCodeAccount()) {
						found = true;
						System.out.println(emp);
						break;
					}
				}
			}

			if (!found) {
				System.out.println("Desculpe, seu nome ou código bancário são inválidos.");
				return; 
			}
			System.out.println("Voce entrou na sua conta com sucesso.");

			System.out.println("Qual moeda você deseja converter para o real?");
			String escolhaMoeda = sc.next();

			if (escolhaMoeda.equalsIgnoreCase("Dolar")) {
				System.out.println("Quantos dólares você deseja converter para reais?");
				double ConverterDolar = sc.nextDouble();
				MoedaDolar moedaDolar = new MoedaDolar(ConverterDolar);
				double conversaoTotalDolar = moedaDolar.ConverterToReal(ConverterDolar);
				System.out.println("O valor total da conversão foi de : R$" + String.format("%.2f", conversaoTotalDolar));

						
			}

			else if(escolhaMoeda.equalsIgnoreCase("Euro")) {
				System.out.println("Quantos E você deseja converter para reais?");
				double ConverterEuro = sc.nextDouble();
				MoedaEuro moedaEuro = new MoedaEuro(ConverterEuro);
				double conversaoTotalEuro= moedaEuro.ConverterToReal(ConverterEuro);
				System.out.println("O valor total da conversão foi de : R$" + String.format("%.2f", conversaoTotalEuro));

			}

			 else {
				System.out.println("Desculpe, essa moeda e invalida.");
				return;
			}

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());

		}

		sc.close();

	}

}


