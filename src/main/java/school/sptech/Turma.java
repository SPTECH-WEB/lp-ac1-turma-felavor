package school.sptech;

public class Turma {

    private String nome;
    private Double mensalidade;
    private Integer qtdAluno;
    private Boolean ativa;

    public Turma(String nome, Double mensalidade) {
        this.nome = nome;
        this.mensalidade = mensalidade;
        this.qtdAluno = 0;
        this.ativa = true;
    }

    public void matricular(Integer qtd) {
        if(qtd != null && ativa && qtd > 0) {
            this.qtdAluno += qtd;
        }
    }

    public Integer cancelar(Integer qtd) {

        if(qtd != null && qtd > 0 && qtd <= qtdAluno && ativa) {
            this.qtdAluno -= qtd;
            return qtd;

        } else {
            return null;
        }
    }

    public Integer desativar() {

        if(!ativa) {
            return null;
        } else {
            this.ativa = false;
            Integer alunosPresentes = this.qtdAluno;
            this.qtdAluno = 0;
            return alunosPresentes;
        }
    }

    public void transferir(Turma destino, Integer qtdATransferir) {

        if(destino != null && destino.ativa && qtdATransferir != null && qtdATransferir > 0 && qtdAluno > qtdATransferir && ativa) {
            this.qtdAluno -= qtdATransferir;
            destino.qtdAluno += qtdATransferir;
        }
    }

    public Boolean reajustarMensalidade(Double reajuste) {

        if(reajuste == null || reajuste <= 0) {
            return false;
        } else {
            this.mensalidade += this.mensalidade * reajuste;
            return true;
        }
    }

    public String getNome() {
        return this.nome;
    }

    public Double getMensalidade() {
        return this.mensalidade;
    }

    public Integer getQtdAluno() {
        return this.qtdAluno;
    }

    public Boolean getAtiva() {
        return this.ativa;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
