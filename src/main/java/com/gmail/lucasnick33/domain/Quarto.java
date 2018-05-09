package com.gmail.lucasnick33.domain;

import com.gmail.lucasnick33.domain.enums.TipoDeQuarto;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Quarto implements Serializable {
    
    private static final long serialVersionUID = 1l;
    
    private int id;
    private String numero;
    private TipoDeQuarto tipo;
    private Collection<Diaria> diarias;

    @Id
    @GeneratedValue(generator = "genquarto")
    @SequenceGenerator(name = "genquarto", sequenceName = "quarto_id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Enumerated(EnumType.STRING)
    public TipoDeQuarto getTipo() {
        return tipo;
    }

    public void setTipo(TipoDeQuarto tipo) {
        this.tipo = tipo;
    }

    @OneToMany(mappedBy = "quarto")
    public Collection<Diaria> getDiarias() {
        return diarias;
    }

    public void setDiarias(Collection<Diaria> diarias) {
        this.diarias = diarias;
    }
    
}
