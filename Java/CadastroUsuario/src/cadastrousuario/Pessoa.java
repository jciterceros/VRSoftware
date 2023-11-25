package cadastrousuario;

public class Pessoa {

    private Integer id;
    private String nome;
    private Integer idade;
    private char sexo;
    private String cidade;
    private Double altura;

    public Pessoa() {
    }

    public Pessoa(Integer id, String nome, Integer idade, char sexo, String cidade, Double altura) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.cidade = cidade;
        this.altura = altura;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public String mostrarDados() {
        return String.format("Id: %d\nNome: %s\nIdade: %d\nSexo: %c\nCidade: %s\nAltura: %.2f", id, nome, idade, sexo,
                cidade,
                altura);
    }

    @Override
    public String toString() {
        return "Pessoa [id=" + id + ", nome=" + nome + ", idade=" + idade + ", sexo=" + sexo + ", cidade=" + cidade
                + ", altura=" + altura + "]";
    }

}
