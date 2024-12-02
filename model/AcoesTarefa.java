package br.edu.unisep.gerenciadortarefa.model;

import javax.swing.JOptionPane;
public class AcoesTarefa {
    public static void adicionarTarefa(GerenciadorTarefa gerenciador) {
        String descricao = JOptionPane.showInputDialog("Digite a tarefa:");
        if (descricao != null && !descricao.trim().isEmpty()) {
            gerenciador.adicionarTarefa(descricao.trim());
            JOptionPane.showMessageDialog(null, "Tarefa adicionada!");
        } else {
            JOptionPane.showMessageDialog(null, "Opção invalida!");
        }
    }

    public static void marcarTarefaComoConcluida(GerenciadorTarefa gerenciador) {
        String listaTarefas = construirListaDeTarefas(gerenciador, false);
        if (listaTarefas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Tarefa indisponivel!");
            return;
        }

        String entrada = JOptionPane.showInputDialog("Selecione o numero para a tarefa ser concluida:\n\n" + listaTarefas);
        try {
            int indice = Integer.parseInt(entrada) - 1;
            if (gerenciador.marcarTarefaComoConcluida(indice)) {
                JOptionPane.showMessageDialog(null, "Tarefa concluida!");
            } else {
                JOptionPane.showMessageDialog(null, "Tarefa invalida!");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Entrada invalida!");
        }
    }

    public static void removerTarefa(GerenciadorTarefa gerenciador) {
        String listaTarefas = construirListaDeTarefas(gerenciador, false);
        if (listaTarefas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Sem tarefa disponivel!");
            return;
        }

        String entrada = JOptionPane.showInputDialog("Selecione o número da tarefa :\n\n" + listaTarefas);
        try {
            int indice = Integer.parseInt(entrada) - 1;
            if (gerenciador.removerTarefa(indice)) {
                JOptionPane.showMessageDialog(null, "Tarefa removida!");
            } else {
                JOptionPane.showMessageDialog(null, "Tarefa invalida!");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Opção invalida!");
        }
    }

    public static void exibirTarefas(GerenciadorTarefa gerenciador) {
        String listaTarefas = construirListaDeTarefas(gerenciador, true);
        if (listaTarefas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhuma tarefa cadastrada!");
        } else {
            JOptionPane.showMessageDialog(null, "Tarefas:\n\n" + listaTarefas);
        }
    }

    private static String construirListaDeTarefas(GerenciadorTarefa gerenciador, boolean exibirTodas) {
        StringBuilder listaTarefas = new StringBuilder();
        int indice = 1;
        for (Tarefa tarefa : gerenciador.getTarefas()) {
            if (exibirTodas || !tarefa.isConcluida()) {
                listaTarefas.append(indice).append(". ").append(tarefa).append("\n");
            }
            indice++;
        }
        return listaTarefas.toString();
    }
}