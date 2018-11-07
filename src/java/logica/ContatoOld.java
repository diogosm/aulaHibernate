/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logica;

import java.util.Calendar;
import javax.persistence.*;

/**
 *
 * @author diogo
 */
@Entity
public class ContatoOld {

    @Id
    @GeneratedValue
    Integer id;
    String nome;
    String email;
    String endereco;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "datacadastro", nullable = false)
    Calendar dataCadastro;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer sId) {
        this.id = sId;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String snome) {
        this.nome = snome;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String semail) {
        this.email = semail;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String sendereco) {
        this.endereco = sendereco;
    }

    public Calendar getDataCad() {
        return this.dataCadastro;
    }

    public void setDataCad(Calendar dataCad) {
        this.dataCadastro = dataCad;
    }
}
