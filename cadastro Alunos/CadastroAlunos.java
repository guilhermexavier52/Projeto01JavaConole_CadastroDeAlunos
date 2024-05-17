package exemplo;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CadastroAlunos {
	 private static ArrayList<AtributosAluno> alunos = new ArrayList<>();
	    private static Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) {
	        while (true) {
	            showMenu();
	            int opcao = getOption();
	            switch (opcao) {
	                case 1:
	                    cadastrarAluno();
	                    break;
	                case 2:
	                    mostrarAlunos();
	                    break;
	                case 3:
	                    excluirAluno();
	                    break;
	                case 4:
	                    System.out.println("Saindo...");
	                    return;
	                default:
	                    System.out.println("Opção inválida. Tente novamente.");
	            }
	        }
	    }

	    private static void showMenu() {
	        System.out.println("Menu:");
	        System.out.println("1. Cadastrar aluno");
	        System.out.println("2. Mostrar todos os alunos cadastrados");
	        System.out.println("3. Excluir aluno");
	        System.out.println("4. Sair");
	        System.out.print("Escolha uma opção: ");
	    }

	    private static int getOption() {
	        int opcao = -1;
	        try {
	            opcao = scanner.nextInt();
	        } catch (InputMismatchException e) {
	            System.out.println("Entrada inválida. Por favor, insira um número.");
	            scanner.next(); // clear the invalid input
	        }
	        return opcao;
	    }

	    private static void cadastrarAluno() {
	        scanner.nextLine(); // Consume newline left-over
	        System.out.print("Digite o nome do aluno: ");
	        String nome = scanner.nextLine();
	        System.out.print("Digite a idade do aluno: ");
	        int idade = getIntInput();
	        System.out.print("Digite a nota do aluno: ");
	        double nota = getDoubleInput();

	        if (idade != -1 && nota != -1) {
	            AtributosAluno aluno = new AtributosAluno(nome, idade, nota);
	            alunos.add(aluno);
	            System.out.println("Aluno cadastrado com sucesso!");
	        } else {
	            System.out.println("Cadastro falhou devido a entrada inválida.");
	        }
	    }

	    private static int getIntInput() {
	        try {
	            return scanner.nextInt();
	        } catch (InputMismatchException e) {
	            System.out.println("Idade inválida. Deve ser um número inteiro.");
	            scanner.next(); // clear the invalid input
	            return -1;
	        }
	    }

	    private static double getDoubleInput() {
	        try {
	            return scanner.nextDouble();
	        } catch (InputMismatchException e) {
	            System.out.println("Nota inválida. Deve ser um número.");
	            scanner.next(); // clear the invalid input
	            return -1;
	        }
	    }

	    private static void mostrarAlunos() {
	        if (alunos.isEmpty()) {
	            System.out.println("Nenhum aluno cadastrado.");
	        } else {
	            System.out.println("Alunos cadastrados:");
	            for (int i = 0; i < alunos.size(); i++) {
	                System.out.println((i + 1) + ". " + alunos.get(i));
	            }
	        }
	    }

	    private static void excluirAluno() {
	        mostrarAlunos();
	        if (!alunos.isEmpty()) {
	            System.out.print("Digite o número do aluno que deseja excluir: ");
	            int index = getIntInput();
	            if (index > 0 && index <= alunos.size()) {
	                alunos.remove(index - 1);
	                System.out.println("Aluno excluído com sucesso!");
	            } else {
	                System.out.println("Número inválido. Nenhum aluno excluído.");
	            }
	        }
	    }
	}
