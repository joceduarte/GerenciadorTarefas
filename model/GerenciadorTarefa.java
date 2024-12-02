package br.edu.unisep.gerenciadortarefa.model;


import java.util.ArrayList;

public class GerenciadorTarefa {
    private final ArrayList<Tarefa> tarefas;

    public GerenciadorTarefa() {
        this.tarefas = new ArrayList<>();
    }

    public void adicionarTarefa(String descricao) {
        tarefas.add(new Tarefa(descricao));
    }

    public boolean marcarTarefaComoConcluida(int indice) {
        if (indice >= 0 && indice < tarefas.size()) {
            tarefas.get(indice).setConcluida(true);
            return true;
        }
        return false;
    }

    public boolean removerTarefa(int indice) {
        if (indice >= 0 && indice < tarefas.size()) {
            tarefas.remove(indice);
            return true;
        }
        return false;
    }

    public ArrayList<Tarefa> getTarefas() {
        return tarefas;
    }
}