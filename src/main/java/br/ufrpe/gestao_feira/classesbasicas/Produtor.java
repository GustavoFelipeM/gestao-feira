package br.ufrpe.gestao_feira.classesbasicas;

public class Produtor {
    private String nome;
    private String cpfCnpj;
    private String telefone;
    private String email;
    private String categoria;

    public Produtor(String nome, String cpfCnpj, String telefone, String email, String categoria) {
        this.nome = nome;
        this.cpfCnpj = cpfCnpj;
        this.telefone = telefone;
        this.email = email;
        this.categoria = categoria;
    }

    // getters and setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Produtor other = (Produtor) obj;
        if (cpfCnpj == null) {
            return other.cpfCnpj == null;
        } else {
            return cpfCnpj.equals(other.cpfCnpj);
        }

    }
}


