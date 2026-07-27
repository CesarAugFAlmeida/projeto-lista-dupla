package trabalhoED;

import java.util.Scanner;

public class MenuPrincipal {
		
		static Scanner scan = new Scanner(System.in);
		
		public static void main(String[] args) {
		ListaDuplaAluno listaAlunos = new ListaDuplaAluno();
		ListaDuplaAluno listaTransferidos = new ListaDuplaAluno();
		char opcao;

		do {
		opcao = menu();
		switch (opcao){
		case '1':
			System.out.println("-------ADICIONAR ALUNO-------");
			System.out.println("Digite a matricula do aluno: ");
			long matricula = scan.nextLong();
			scan.nextLine();
			System.out.println("Digite o nome do aluno: ");
			String nome = scan.nextLine();
			System.out.println("Digite o endereço do aluno: ");
			String endereco = scan.nextLine();
			System.out.println("Digite o telefone do aluno ou responsável: ");
			String telefone = scan.nextLine();
			Aluno novoAluno = new Aluno();
			novoAluno.AdicionarAluno(matricula, nome, endereco, telefone);
			listaAlunos.inserirAluno(novoAluno);
			System.out.println("Aluno adicionado com sucesso.");
			break;
		case '2':
			System.out.println("-------REMOVER ALUNO-------");
			if (listaAlunos.eVazia()) {
				System.out.println("Não há alunos para remover");
			}else {
				System.out.println("Digite a matricula do aluno que deseja remover: ");
				if (listaAlunos.removerAluno(scan.nextLong())) {
					System.out.println("Aluno removido com sucesso.");
				}else {
					System.out.println("Valor não encontrado.");
				}
			}
			break;
		case '3':
			System.out.println("-------TRANSFERIR ALUNO-------");
			if (listaAlunos.eVazia()) {
				System.out.println("Não há alunos para transferir");
			}else {
				System.out.println("Digite a matricula do aluno a ser trasferido: ");
				matricula = scan.nextLong();
				if (listaAlunos.localizarMatricula(matricula) != null) {
					listaTransferidos.transferirAluno(matricula, listaAlunos);
					System.out.println("Aluno tranferido com sucesso.");
					listaTransferidos.imprimirLista();
				}else {
					System.out.println("Aluno não encontrado. Verifique a matricula");
			}
			}
		break;
		case '4':
			System.out.println("-------LOCALIZAR ALUNO-------");
			if (listaAlunos.eVazia()) {
				System.out.println("Não há alunos para procurar na lista");
			}else {
				System.out.println("Digite o nome do aluno: ");
				scan.nextLine();
				String localizar = scan.nextLine();
				listaAlunos.localizarAluno(localizar);
			}
			break;
		case '5':
			System.out.println("FIM DO PROGRAMA");
		default:
			System.out.println("Opção inválida.");
			}
		} while (opcao != '5');
			System.exit(0);
			}
		
		public static char menu(){
			System.out.println("-------MENU PRINCIPAL-------");
			System.out.println("Escolha uma Opção:\n"+
					"1. Inserir aluno novo\n"+
					"2. Remover aluno\n"+
					"3. Transferir aluno para outra escola\n"+
					"4. Localizar aluno por nome\n"+
					"5. Sair do programa");
			return scan.next().charAt(0);
			}
	}
