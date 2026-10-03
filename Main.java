import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Tarefa> listaTarefas = new ArrayList<>();

        boolean loop = true;

        while (loop) {
            System.out.println("1 - Criar tarefa\n" + 
                        "2 - Listar tarefas\n" + 
                        "3 - Concluir tarefa\n" +
                        "4 - Remover tarefa\n" +
                        "5 - Sair");
            int escolharMenu = 0;

            try {
                escolharMenu = scanner.nextInt();
                scanner.nextLine();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Digite algo válido");
                scanner.nextLine();
            }
            
            switch (escolharMenu) {
                case 1:
                    System.out.println("Criando uma nova Tarefa..");
                    System.out.println("Nome: ");
                    String newTarefaNome = scanner.nextLine();
                    System.out.println("Descrição: ");
                    String newTarefaDescricao = scanner.nextLine();
                    System.out.println("Prioridade: \n1 - Baixa\n2 - Média\n3 - Alta");
                    Prioridade newPrioridade;
                    try {
                        int escolharPrioridade = scanner.nextInt();
                        if (escolharPrioridade == 1){
                        newPrioridade = Prioridade.BAIXA;
                        } else if (escolharPrioridade == 2) {
                        newPrioridade = Prioridade.MEDIA;
                        } else if (escolharPrioridade == 3) {
                        newPrioridade = Prioridade.ALTA;
                        } else {
                            System.out.println("Valor inválido");
                            break;
                        }
                    } catch (java.util.InputMismatchException e) {
                        System.out.println("Digite números!");
                        scanner.nextLine();
                        break;
                    }

                    listaTarefas.add(new Tarefa(newTarefaNome, newTarefaDescricao, newPrioridade));
                    break;
                case 2:
                    if (listaTarefas.size() > 0) {
                        for (int i = 0; i < listaTarefas.size(); i++){
                            Tarefa tarefa = listaTarefas.get(i);
                            System.out.println("= = = = = =\nTarefa " + (i + 1)
                            +"\nNome: " + tarefa.getNome()
                            +"\nDescrição: " + tarefa.getDesc()
                            +"\nSTATUS: " + tarefa.getStatus()
                            +"\nPrioridade: " + tarefa.getPrioridade()
                            +"\n= = = = = =");
                        }
                        break;
                    } else {
                        System.out.println("Lista vazia!");
                        break;
                    }
                case 3:
                    if (listaTarefas.size() > 0) {
                        System.out.println("Qual deseja alterar?");
                        try {
                            int escolharConcluirTarefa = scanner.nextInt();
                            scanner.nextLine();
                            Tarefa tarefa = listaTarefas.get(escolharConcluirTarefa - 1);
                            tarefa.setStatus();
                            break;
                        } catch (java.util.InputMismatchException e) {
                            System.out.println("Digite números!");
                            break;
                        }
                        catch (IndexOutOfBoundsException e) {
                            System.out.println("Número de tarefa inválido!!");
                            break;
                        }
                    } else {
                        System.out.println("Lista vazia, não existe algo para alterar!");
                        break;
                    }

                case 4:
                    if (listaTarefas.size() > 0) {
                        System.out.println("Qual deseja remover?");
                        try {
                            int escolharRemoverTarefa = scanner.nextInt();
                            scanner.nextLine();
                            listaTarefas.remove(escolharRemoverTarefa - 1);
                            break;
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Número de tarefa inválido!");
                            break;
                        } catch (java.util.InputMismatchException e) {
                            System.out.println("Digite números!");
                            break;
                        }
                    } else {
                        System.out.println("Lista vazia, não existe algo par remover!");
                        break;
                    }
                case 5:
                    loop = false;
                    break;
                default:
                    System.out.println("Digite um valor na lista!");
            }
        }
        
        
    }
}