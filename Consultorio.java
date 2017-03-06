package pooteste1;

import java.util.Scanner;

public class Consultorio {
	public static void main(String[] args) {
		String[] nome = new String[3];
		String[] sexo = new String[3];
		int[] idade = new int[3];
		int op;
		final int QUANTIDADE = 3;
		double[] valor = new double[3];
		Scanner io = new Scanner(System.in);
		for(int i = 0; i<QUANTIDADE;i++){
		nome[i]=adcNome(nome[i]);
		sexo[i]=adcSexo(sexo[i]);
		idade[i]=adcIdade(idade[i]);
		valor[i]=adcValor(valor[i]);
		}
		do{
			System.out.print("1 – Imprimir na tela os dados armazenados \n");
			System.out.print("2 – Imprimir a média do valor das consultas realizadas\n");
			System.out.print("3 – Imprimir os dados das pessoas do sexo masculino \n");
			System.out.print("4 – Imprimir o maior valor de consulta realizado por uma pessoa do sexo feminino\n");
			System.out.print("0 ou maior que 5 - Sair \n");
			System.out.print("Digite a opção desejada: \n");
			op=io.nextInt();
			io.nextLine();
			switch(op){
			case 1 : imprimeTudo(nome,sexo,idade,valor,QUANTIDADE);break;
			case 2 : mediaValores(valor,QUANTIDADE);break;
			case 3 : imprimeMasculino(nome,sexo,idade,valor,QUANTIDADE);break;
			case 4 : imprimeMaiorFeminino(nome,sexo,idade,valor,QUANTIDADE);break;
			}
		}while(op<5 && op!=0);
	}
	public static String adcNome(String n) {
			Scanner in = new Scanner(System.in);
			System.out.print("Digite o nome do paciente: ");
			n=in.nextLine();
			return n;
	}
		public static String adcSexo(String s) {
			//s=s.toUpperCase();
			Scanner in = new Scanner(System.in);
			do{
				System.out.print("Digite o sexo do paciente: ");
				s=in.nextLine();
				
			}while(!s.toUpperCase().equals("MASCULINO") && !s.toUpperCase().equals("FEMININO"));
			return s;
		}
		public static int adcIdade(int i) {
			Scanner in = new Scanner(System.in);
			System.out.print("Digite a idade do paciente: ");
			while(!in.hasNextInt()){
	            in.nextLine();
	            System.out.print("Tipo de dado inválido. Digite um inteiro: ");
			}
			i=in.nextInt();
			return i;
			}
		public static double adcValor(double v) {
			Scanner in = new Scanner(System.in);
			System.out.print("Digite o valor da consulta do paciente: ");
			while(!in.hasNextDouble()){
	            in.nextLine();
	            System.out.print("Tipo de dado inválido. Digite um double: ");
	        }
			v=in.nextDouble();
			return v;
			}
		public static void imprimeTudo(String[] n, String [] s,int[] i,double[] v,int q){
			for(int cont=0;cont<q;cont++){
				System.out.print(" Nome do paciente: " + n[cont] + "; Sexo: "+ s[cont] +"; Idade: " +i[cont] +"; Valor da consulta: " + v[cont] +"  \n ");
			}
		}
		public static void mediaValores(double[] v,int q){
			double total=0;
			for(int cont=0;cont<q;cont++){
				total=v[cont]+total;
			}
			total=total/q;
			System.out.print(" Foram feitas " + q +" consultas com valor médio de " + total  + "\n ");
		}
		public static void imprimeMasculino(String[] n, String [] s,int[] i,double[] v,int q){
			for(int cont=0;cont<q;cont++){
				if(s[cont].toUpperCase().equals("MASCULINO"))
				System.out.print(" Nome do paciente: " + n[cont] + "; Sexo: "+ s[cont] +"; Idade: " +i[cont] +"; Valor da consulta: " + v[cont] +"  \n ");
			}
			}
		public static void imprimeMaiorFeminino(String[] n, String [] s,int[] i,double[] v,int q){
			int m=0;
			for(int cont=0;cont<q;cont++){
				if(s[cont].toUpperCase().equals("FEMININO")){
				if(v[m]<v[cont]){
					m=cont;
				}
				}
				}
			System.out.print(" Nome do paciente: " + n[m] + "; Sexo: "+ s[m] +"; Idade: " +i[m] +"; Valor da consulta: " + v[m] +"  \n ");
		}
}
