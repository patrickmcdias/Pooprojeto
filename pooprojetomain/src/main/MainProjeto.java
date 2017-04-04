package main;

import java.net.*;
import java.io.*;
import java.util.Scanner;

import classesprojeto.*;

/**
 * 
 * @author Patrick Muller e Neudson José 
 *
 */

/**
 * 
 * Classe main do projeto herda todas as classes que estão dentro do pacote
 * classesprojeto
 * 
 */
public class MainProjeto {

	public static void main(String[] args) {

		ColecaoVendas ven = new ColecaoVendas();
		ColecaoFuncionario fun = new ColecaoFuncionario();
		ColecaoCliente cli = new ColecaoCliente();
		ColecaoEquipamentos equi = new ColecaoEquipamentos();

		ven.carregarDados();
		fun.carregarDados();
		cli.carregarDados();
		equi.carregarDados();
		int op = 0, op2 = 0, op3 = 0, op4 = 0;
		Scanner io = new Scanner(System.in);
		do {
			System.out.println("------------Menu Principal------------");
			System.out.println(" 1 - Ir menu dos clientes");
			System.out.println(" 2 - Ir menu dos funcionários");
			System.out.println(" 3 - Ir menu dos equipamentos");
			System.out.println(" 4 - Ir menu das vendas");
			System.out.println(" 5 - Sair");
			System.out.println("Digite a opção desejada: ");
			op = io.nextInt();
			switch (op) {
			case 1://Cliente
				System.out.println("------------Menu Cliente------------");
				System.out.println(" 1 - Cadastrar cliente");
				System.out.println(" 2 - Pesquisar cliente pelo CPF");
				System.out.println(" 3 - Remover cliente pelo CPF");
				System.out.println(" 4 - Salvar lista de cliente");
				System.out.println(" 5 - Fazer backup da lista");
				System.out.println("Digite a opção desejada: ");
				op2 = io.nextInt();
				switch (op2) {
				case 1://Adicionar cliente
					String n,
					c;
					Scanner clien = new Scanner(System.in);
					System.out.println(" Digite o nome do cliente: ");
					n = clien.nextLine();
					// clien.nextLine();
					System.out.println(" Digite o CPF: ");
					c = clien.nextLine();
					Cliente cl = new Cliente(n, c);
					cli.adicionarCliente(cl);
					break;
				case 2://Pesquisar cliente
					Scanner clien2 = new Scanner(System.in);
					String qw;
					System.out
							.println(" Digite o CPF  do cliente que deseja pesquisar: ");
					qw = clien2.nextLine();
					cli.pesquisarPeloCPF(qw);
					break;
				case 3://Remover cliente 
					Scanner clien3 = new Scanner(System.in);
					String qy;
					System.out
							.println(" Digite o CPF do cliente que deseja remover: ");
					qy = clien3.nextLine();
					cli.pesquisarPeloCPF(qy);
					break;
				case 4://Salvar no arquivo
					cli.salvarDados();
					break;
				case 5://Fazer backup no servidor
					File fi = new File("cliente.dat");
					try {
						Socket so = new Socket("10.0.4.223", 1515);
						ObjectOutputStream out = new ObjectOutputStream(
								so.getOutputStream());
						out.writeUTF(fi.getName());
						FileInputStream in = new FileInputStream(fi);
						byte[] b = new byte[8192];
						while (true) {
							int l = in.read(b);
							if (l == -1)
								break;
							out.write(b, 0, l);
						}
						out.close();
						so.close();
						in.close();
						System.out.println("Feito!!");
					} catch (UnknownHostException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}

					break;
				}
				break;
			case 2:
				System.out.println("------------Menu Funcionário------------");
				System.out.println(" 1 - Cadastrar funcionário");
				System.out.println(" 2 - Pesquisar funcionário");
				System.out.println(" 3 - Remover funcionário");
				System.out.println(" 4 - Salvar lista de funcionários");
				System.out.println(" 5 - Fazer backup dos funcionários");
				System.out.println("Digite a opção desejada: ");
				op3 = io.nextInt();
				switch (op3) {
				case 1://Adicionar Funcionario
					String m,
					d,
					ca;
					Scanner func = new Scanner(System.in);
					System.out.println(" Digite o nome do funcionário: ");
					m = func.nextLine();
					// clien.nextLine();
					System.out.println(" Digite a matrícula: ");
					d = func.nextLine();
					System.out.println(" Digite o cargo: ");
					ca = func.nextLine();
					if (ca.equals("Gerente") || ca.equals("gerente")) {
						Funcionario g = new Gerente(m, d);
						fun.adicionarFuncionario(g);
					}
					if (ca.equals("vendedor") || ca.equals("Vendedor")) {
						Funcionario v = new Vendedor(m, d);
						fun.adicionarFuncionario(v);
					}
					break;
				case 2://Pesquisar funcionario
					Scanner func2 = new Scanner(System.in);
					String tu;
					System.out
							.println(" Digite a matricula do Funcionario que deseja pesquisar: ");
					tu = func2.nextLine();
					fun.pesquisarPelaMatricula(tu);
					break;
				case 3://Remover funcionario
					Scanner func3 = new Scanner(System.in);
					String lo;
					System.out
							.println(" Digite a matrícula do funcionário que deseja remover: ");
					lo = func3.nextLine();
					fun.removerPelaMatricula(lo);
					break;
				case 4://Salvar no arquivo 
					fun.salvarDados();
					break;
				case 5://Salvar backup no servidor
					File fi = new File("funcionario.dat");
					try {
						Socket so = new Socket("10.0.4.223", 1515);
						ObjectOutputStream out = new ObjectOutputStream(
								so.getOutputStream());
						out.writeUTF(fi.getName());
						FileInputStream in = new FileInputStream(fi);
						byte[] b = new byte[8192];
						while (true) {
							int l = in.read(b);
							if (l == -1)
								break;
							out.write(b, 0, l);
						}
						out.close();
						so.close();
						in.close();
						System.out.println("Feito!!");
					} catch (UnknownHostException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				}
				break;
			case 3:
				System.out.println("------------Menu Equipamentos------------");
				System.out.println(" 1 - Cadastrar equipamento");
				System.out
						.println(" 2 - Pesquisar equipamento pelo número de série");
				System.out.println(" 3 - Pesquisar equipamento pelo modelo");
				System.out
						.println(" 4 - Remover equipamento pelo número de série");
				System.out.println(" 5 - Remover todo equipamento pelo modelo");
				System.out.println(" 6 - Salvar lista de equipamento");
				System.out
						.println(" 7 - Fazer backup da lista de equipamentos");
				System.out.println("Digite a opção desejada: ");
				op3 = io.nextInt();
				switch (op3) {
				case 1://Adicionar equipamento 
					String po,
					hy,
					iu;
					int qtd = 0;
					Scanner equi1 = new Scanner(System.in);
					System.out.println(" Digite o modelo do equipamento: ");
					po = equi1.nextLine();
					// clien.nextLine();
					System.out
							.println(" Digite o número de série do equipamento: ");
					hy = equi1.nextLine();
					System.out.println(" Digite o tipo do equipamento: ");
					iu = equi1.nextLine();
					System.out
							.println(" Digite a quantidade de portas ethernet do equipamento: ");
					qtd = equi1.nextInt();
					if (iu.equals("Switch") || iu.equals("switch")) {
						Equipamentos sw = new Switch(po, hy, qtd);
						equi.adicionarEquipamento(sw);
					}
					if (iu.equals("roteador") || iu.equals("Roteador")) {
						int se = 0;
						System.out
								.println(" Digite a quantidade de portas serial: ");
						se = equi1.nextInt();
						Equipamentos rt = new Roteador(po, hy, se, qtd);
						equi.adicionarEquipamento(rt);
					}
					if (iu.equals("AP") || iu.equals("ap")) {
						int si = 0;
						System.out.println(" Digite a quantidade de antenas: ");
						si = equi1.nextInt();
						Equipamentos ap = new AccessPoint(po, hy, qtd, si);
						equi.adicionarEquipamento(ap);
					}
					break;
				case 2://Pesquisar pelo numero de serie 
					Scanner equi2 = new Scanner(System.in);
					String ti;
					System.out
							.println(" Digite o número de série do equipamento que deseja pesquisar: ");
					ti = equi2.nextLine();
					equi.pesquisarPeloNumSerie(ti);
					break;
				case 3://Pesquisar pelo modelo 
					Scanner equi3 = new Scanner(System.in);
					String to;
					System.out
							.println(" Digite o modelo do equipamento que deseja pesquisar: ");
					to = equi3.nextLine();
					equi.pesquisarPeloModelo(to);
					break;
				case 4://Remover pelo numero de serie 
					Scanner equi4 = new Scanner(System.in);
					String li;
					System.out
							.println(" Digite o número de série do equipamento que deseja remover: ");
					li = equi4.nextLine();
					equi.removerPeloNumSerie(li);
					break;
				case 5://Remover pelo modelo
					Scanner equi5 = new Scanner(System.in);
					String lu;
					System.out
							.println(" Digite o modelo do equipamento que deseja remover: ");
					lu = equi5.nextLine();
					equi.removerTodoModelo(lu);
					break;
				case 6://Salvar no arquivo
					equi.salvarDados();
					break;
				case 7://Salvar backup no servidor 
					File fi = new File("equipamentos.dat");
					try {
						Socket so = new Socket("10.0.4.223", 1515);
						ObjectOutputStream out = new ObjectOutputStream(
								so.getOutputStream());
						out.writeUTF(fi.getName());
						FileInputStream in = new FileInputStream(fi);
						byte[] b = new byte[8192];
						while (true) {
							int l = in.read(b);
							if (l == -1)
								break;
							out.write(b, 0, l);
						}
						out.close();
						so.close();
						in.close();
						System.out.println("Feito!!");
					} catch (UnknownHostException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				}
				break;
			case 4:
				System.out.println("------------Menu Venda------------");
				System.out.println(" 1 - Cadastrar venda");
				System.out.println(" 2 - Pesquisar compra do cliente");
				System.out.println(" 3 - Pesquisar venda do vendedor ");
				System.out.println(" 4 - Remover compra do cliente");
				System.out.println(" 5 - Remover venda do vendedor");
				System.out.println(" 6 - Salvar lista de vendas");
				System.out.println(" 7 - Fazer backup da lista");
				System.out.println("Digite a opção desejada: ");
				op4 = io.nextInt();
				switch (op4) {
				case 1://Adicionar venda 
					String put,
					hyu,
					iua;
					double qtde;
					Equipamentos eqp;
					Cliente clien;
					Funcionario vend;
					Scanner ven1 = new Scanner(System.in);
					System.out.println(" Digite o CPF do cliente");
					put = ven1.nextLine();
					clien = cli.pesquisarPeloCPF(put);
					System.out.println(" Digite a matricula do vendedor: ");
					hyu = ven1.nextLine();
					vend = fun.pesquisarPelaMatricula(hyu);
					System.out
							.println(" Digite o número de série do produto: ");
					iua = ven1.nextLine();
					eqp = equi.pesquisarPeloNumSerie(iua);
					System.out.println(" Digite o valor do produto: ");
					qtde = ven1.nextDouble();
					Vendas vil = new Vendas(eqp, vend, qtde, clien);
					ven.adicionarVenda(vil);
					equi.removerPeloNumSerie(iua);
					break;
				case 2://Pesquisar compra
					Scanner ven2 = new Scanner(System.in);
					String kj,
					ki;
					System.out
							.println(" Digite o CPF do cliente que deseja pesquisar: ");
					kj = ven2.nextLine();
					System.out
							.println(" Digite o número de série do equipamento que deseja pesquisar: ");
					ki = ven2.nextLine();
					ven.pesquisarCompraDoCliente(kj, ki);
					break;
				case 3://Pesquisar venda
					Scanner ven3 = new Scanner(System.in);
					String ke,
					ko;
					System.out
							.println(" Digite a matrícula do vendedor que deseja pesquisar: ");
					ke = ven3.nextLine();
					System.out
							.println(" Digite o número de série do equipamento que deseja pesquisar: ");
					ko = ven3.nextLine();
					ven.pesquisarVendaDoVendedor(ke, ko);
					break;
				case 4://Remover compra
					Scanner ven4 = new Scanner(System.in);
					String kp,
					kl;
					System.out
							.println(" Digite o CPF do cliente que deseja remover: ");
					kp = ven4.nextLine();
					System.out
							.println(" Digite o número de série do equipamento que deseja remover: ");
					kl = ven4.nextLine();
					ven.removerCompra(kp, kl);
					break;
				case 5://Remover venda
					Scanner ven5 = new Scanner(System.in);
					String kq,
					kd;
					System.out
							.println(" Digite a matrícula do vendedor que deseja remover: ");
					kq = ven5.nextLine();
					System.out
							.println(" Digite o número de série do equipamento que deseja remover: ");
					kd = ven5.nextLine();
					ven.removerVenda(kq, kd);
					break;
				case 6://Salvar no arquivo 
					ven.salvarDados();
					break;
				case 7://Salvar backup no servidor 
					File fi = new File("vendas.dat");
					try {
						Socket so = new Socket("10.0.4.223", 1515);
						ObjectOutputStream out = new ObjectOutputStream(
								so.getOutputStream());
						out.writeUTF(fi.getName());
						FileInputStream in = new FileInputStream(fi);
						byte[] b = new byte[8192];
						while (true) {
							int l = in.read(b);
							if (l == -1)
								break;
							out.write(b, 0, l);
						}
						out.close();
						so.close();
						in.close();
						System.out.println("Feito!!");
					} catch (UnknownHostException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				}
				break;
			}

		} while (op != 5 && op < 5);

		io.close();
		System.out.println("Programa encerrado.");
	}
}