public class Tarefa {
    private String nome;
    private String descricao;
    private StatusTarefa status;
    private Prioridade prioridade;

    public Tarefa(String nome, String descricao, Prioridade prioridade) {
        this.nome = nome;
        this.descricao = descricao;
        this.status = StatusTarefa.PENDENTE;
        this.prioridade = prioridade;
    }

    public String getNome(){
        return nome;
    }

    public String getDesc(){
        return descricao;
    }

    public StatusTarefa getStatus(){
        return status;
    }

    public Prioridade getPrioridade(){
        return prioridade;
    }

    public void setStatus(){
        if (status == StatusTarefa.PENDENTE){
            status = StatusTarefa.CONCLUIDA;
        } else {
            System.out.println("Tarefa já foi Concluida!");
        }
    }

}
