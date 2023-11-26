package cadastrousuario.entities;

public class Endereco {
    private Integer id;
    private String rua;
    private Integer numero;
    private String bairro;
    private String cep;
    private String cidade;
    private String estado;
    private String pais;

    public Endereco() {
    }

    public Endereco(Integer id, String rua, Integer numero, String bairro, String cep, String cidade, String estado,
            String pais) {
        this.id = id;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        if (rua.length() > 0) {
            this.rua = rua;
        } else {
            System.out.println("Rua invalida");
        }
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        if (numero > 0) {
            this.numero = numero;
        } else {
            System.out.println("Numero invalido");
        }
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        if (bairro.length() > 0) {
            this.bairro = bairro;
        } else {
            System.out.println("Bairro invalido");
        }
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        if (cep.length() > 0) {
            this.cep = cep;
        } else {
            System.out.println("CEP invalido");
        }
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        if (cidade.length() > 0) {
            this.cidade = cidade;
        } else {
            System.out.println("Cidade invalida");
        }
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        if (estado.length() > 0) {
            this.estado = estado;
        } else {
            System.out.println("Estado invalido");
        }
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        if (pais.length() > 0) {
            this.pais = pais;
        } else {
            System.out.println("Pais invalido");
        }
    }

    @Override
    public String toString() {
        return "Endereco [id=" + id + ", rua=" + rua + ", numero=" + numero + ", bairro=" + bairro + ", cep=" + cep
                + ", cidade=" + cidade + ", estado=" + estado + ", pais=" + pais + "]";
    }
}
