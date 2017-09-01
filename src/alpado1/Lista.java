/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alpado1;

import java.util.Scanner;
/**
 *
 * @author Linca
 */
public class Lista {
    
    static Scanner run = new Scanner(System.in);
        
    //criando uma funcao string para uso futuros
        static String Leitor() {
        String ler = run.next();
        return ler;
        }
    public static void mainClause(int select){
        //criando um vetor tipo string tamanho 50
        String[] listNames = criandoVetor(50);
        
        do{
            select = Menu();
            selecionarOpcao(select , listNames);
            
        } while (select != 0);
    }       
    // Iniciando o menu para interação do gerenciamento
    public static int Menu(){
        System.out.println("Sistema de Gerenciamento de Dados");
  			System.out.println("\n      =================================");
			System.out.println("      |☆ 1 - Adicionar um novo nome  |");
			System.out.println("      |☆ 2 - Apresentar os nomes     |");
			System.out.println("      |☆ 3 - Pesquisar um nome       |");
			System.out.println("      |☆ 4 - Remover um nome         |");
			System.out.println("      |☆ 0 - Sair                    |");
			System.out.println("      ================================\n");
        System.out.println("Escolha a opção desejada: ");
        int n = run.nextInt();
        return n;
        
    }
        public static String[] adicionandoNome(String[] listName) {
        boolean nomeExistente;
        System.out.println("Nome a ser adicionado: ");
        String nome = Leitor();
        nomeExistente = verificarSeExiste(listName, nome);
        if (nomeExistente) {
            return listName;
        } else if (!listName[listName.length - 1].trim().equalsIgnoreCase("")) {
            System.out.println("A lista está cheia, favor remover um nome.");
            return listName;
        } else {
            listName[listName.length - 1] = nome;
            listName = Organizando(listName);
            return listName;
        }
    }
            public static void apresentarNome(String[] listName) {
        boolean vazia = verVazia(listName);
        if (vazia) {
            System.out.println("A lista está vazia.");
        } else {
            for (String NomeNaLista : listName) {
                if (!NomeNaLista.trim().equalsIgnoreCase("")) {
                    System.out.printf("%-3s\n", NomeNaLista);
                }
            }
        }
    }
               public static void pesquisarNome(String[] listName, String nome) {
        boolean encontrou = false;
        for (int i = 0; i < listName.length; i++) {
            if (listName[i].trim().equalsIgnoreCase(nome.trim())) {
                System.out.printf("O nome \"%s\" foi encontrado.\nNa posição %d\n", nome, i + 1);
                encontrou = true;
                break;
            }
        }
        if (!encontrou) {
            System.out.printf("Nome \"%s\" não foi encontrado.\n", nome);
        }
    }
        //removendo e organizando automatico o vetor
     public static String[] removendoNome(String[] listNames) {
        System.out.print("Nome a ser removido: ");
        String nome = Leitor();
        listNames = pesquisarNomeParaRemover(listNames, nome);
        listNames = Organizando(listNames);
        return listNames;
    }
     public static String[] Organizando(String[] listName) {

        for (int i = 0; i < listName.length; i++) {
            if (listName[i].equalsIgnoreCase("") && i != (listName.length - 1)) {
                listName[i] = listName[i + 1];
                listName[i + 1] = "";
            }
        }
        return listName;
    }
    public static String[] selecionarOpcao(int selection, String[] listNames) {
        
        //criando um switch case e colocando função na opção que o usuario digitar
        
        switch (selection) {
            case 0:
                System.out.println(" Você saiu do Sistema");
                break;
            case 1:
                System.out.println(" Digite um novo nome ");
                listNames = adicionandoNome(listNames);
                return listNames;
            case 2:
                System.out.println(" Apresentando os nomes");
                apresentarNome(listNames);
                break;
            case 3:
                System.out.println(" Digite o nome á ser pesquisado");
                System.out.print("Nome: ");
                String nome = Leitor();
                pesquisarNome(listNames, nome);
                return listNames;
            case 4:
                listNames = removendoNome(listNames);
                return listNames;
            default: System.out.println("Opção Inválida!");
                break;
        }
        return listNames;
    }

    
    public static String[] retirarOsVazio(String[] listName) {
        for (int i = 0; i < listName.length; i++) {
            listName[i] = "";
        }
        return listName;
    }
    public static boolean verVazia(String[] listName) {
        boolean empty = true;
        for (String listNames : listName) {
            if (!listNames.trim().equalsIgnoreCase("")) {
                empty = false;
                break;
            }
        }
        return empty;
    }
    public static String[] pesquisarNomeParaRemover(String[] listName, String nome) {
        boolean removeu = false;
        for (int i = 0; i < listName.length; i++) {
            if (listName[i].trim().equalsIgnoreCase(nome.trim())) {
                listName[i] = "";
                removeu = true;
                break;
            }
        }
        if (!removeu) {
            System.out.printf("Nome" +nome+ " não foi encontrado.");
        }
        return listName;
    }
    public static boolean verificarSeExiste(String[] listName, String nome) {
        boolean encontrou = false;
        for (String verNome : listName) {
            if (verNome.trim().equalsIgnoreCase(nome.trim())) {
                encontrou = true;
            }
        }
        if (encontrou) {
            System.out.println("Esse nome já está na lista.");
        }
        return encontrou;
    }
}