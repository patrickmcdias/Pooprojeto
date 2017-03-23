package main;

import java.util.Scanner;

import classesprojeto.*;

public class MainProjeto {

	public static void main(String[] args) {

		ColecaoVendas ven = new ColecaoVendas();
		ColecaoFuncionario fun = new ColecaoFuncionario();
		ColecaoCliente cli = new ColecaoCliente();
		ColecaoEquipamentos equi = new ColecaoEquipamentos();

//ven.carregarDados();
//fun.carregarDados();
//cli.carregarDados();
//equi.carregarDados();
		int op = 0,op2 = 0;
		Scanner io = new Scanner(System.in);
		do {
			io.nextLine();
			System.out.println(" 1 - Parte dos Clientes");
			System.out.println(" 2 - Parte dos Funcionários");
			System.out.println(" 3 - Parte dos Equipamentos");
			System.out.println(" 4 - Parte das Vendas");
			System.out.println(" 5 - Sair");
			System.out.println("Digite a opção desejada: ");
			op = io.nextInt();
			switch (op) {
			case 1:
				System.out.println(" 1 - Cadastrar Cliente");
				System.out.println(" 2 - Pesquisar Cliente pelo CPF");
				System.out.println(" 3 - Remover Cliente pelo CPF");
				System.out.println(" 4 - Salvar Lista de Cliente");
				System.out.println(" 5 - Fazer Backup da Lista");
				System.out.println("Digite a opção desejada: ");
				op2 = io.nextInt();
				switch (op2) {
				case 1:
					String n,
					c;
					Scanner clien = new Scanner(System.in);
					System.out.println(" Digite o nome do Cliente: ");
					n = clien.nextLine();
					clien.nextLine();
					System.out.println(" Digite o CPF: ");
					c = clien.nextLine();
					Cliente cl = new Cliente(n, c);
					cli.adicionarCliente(cl);
					break;
				case 2:
					Scanner clien2 = new Scanner(System.in);
					String qw;
					System.out
							.println(" Digite o CPF  do cliente que deseja pesquisar: ");
					qw = clien2.nextLine();
					cli.pesquisarPeloCPF(qw);
					break;
				case 3:
					Scanner clien3 = new Scanner(System.in);
					String qy;
					System.out
							.println(" Digite o CPF do cliente que deseja remover: ");
					qy = clien3.nextLine();
					cli.pesquisarPeloCPF(qy);
					break;
				case 4:
					cli.salvarDados();
					break;
				case 5: break;
		//break; 
				}
			case 2 :
			}
			System.out.println(" 1 - Cadastrar Cliente");
			System.out.println(" 2 - Pesquisar Cliente");
			System.out.println(" 3 - Remover Cliente");
			System.out.println(" 4 - Salvar Lista de Cliente");
			System.out.println(" 5 - Fazer backup dos Clientes");
			System.out.println(" 6 - Cadastrar Funcionário");
			System.out.println(" 7 - Pesquisar Funcionário");
			System.out.println(" 8 - Remover Funcionário");
			System.out.println(" 9 - Fazer backup dos Funcionários");
			System.out.println("10 - Cadastrar equipamento");
			System.out.println("11 - Pesquisar Equipamentos pelo ");
			System.out.println("12 - Cadastrar Cliente");
			System.out.println("13 - Cadastrar Cliente");
			System.out.println("Digite a opção desejada: ");
			op = io.nextInt();
			
		} while (op != 5 && op > 5);
		

		io.close();
	}

}