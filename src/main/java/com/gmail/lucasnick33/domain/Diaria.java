package com.gmail.lucasnick33.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import javax.persistence.Embedded;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Diaria implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String email;
    private String telefone;
    @Embedded
    private String endereco;
    @OneToMany(mappedBy = "cliente")
    private Collection<Reserva> reservas;
    @OneToMany(mappedBy = "cliente")
    private Collection<DiariaAvulsa> diariasAvulsas;

    public Diaria() {

    }

    private LocalDate data;

    @ManyToMany
    @JoinTable(name = "hospedagem",
            joinColumns = @JoinColumn(name = "id_diaria"),
            inverseJoinColumns = @JoinColumn(name = "id_pessoa"))
    private Collection<PessoaFisica> hospedes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Collection<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(Collection<Reserva> reservas) {
        this.reservas = reservas;
    }

    public Collection<DiariaAvulsa> getDiariasAvulsas() {
        return diariasAvulsas;
    }

    public void setDiariasAvulsas(Collection<DiariaAvulsa> diariasAvulsas) {
        this.diariasAvulsas = diariasAvulsas;
    }

    public Collection<PessoaFisica> getHospedes() {
        return hospedes;
    }

    public void setHospedes(Collection<PessoaFisica> hospedes) {
        this.hospedes = hospedes;
    }

    public Diaria(Integer id, LocalDate data, Collection<PessoaFisica> hospedes) {
        super();
        this.id = id;
        this.data = data;
        this.hospedes = hospedes;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Diaria other = (Diaria) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        return true;
    }

}
