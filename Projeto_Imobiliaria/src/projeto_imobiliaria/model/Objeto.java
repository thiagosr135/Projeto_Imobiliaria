/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_imobiliaria.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author thiag
 */
public class Objeto {
@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
private Integer id;

    private String Descricao, Logradouro, Bairro, Cidade, CodigoUnico, CEP, UF, Numero;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getDescricao() {
            return Descricao;
        }

        public void setDescricao(String Descricao) {
            this.Descricao = Descricao;
        }

        public String getLogradouro() {
            return Logradouro;
        }

        public void setLogradouro(String Logradouro) {
            this.Logradouro = Logradouro;
        }

        public String getBairro() {
            return Bairro;
        }

        public void setBairro(String Bairro) {
            this.Bairro = Bairro;
        }

        public String getCidade() {
            return Cidade;
        }

        public void setCidade(String Cidade) {
            this.Cidade = Cidade;
        }

        public String getCodigoUnico() {
            return CodigoUnico;
        }

        public void setCodigoUnico(String CodigoUnico) {
            this.CodigoUnico = CodigoUnico;
        }

        public String getCEP() {
            return CEP;
        }

        public void setCEP(String CEP) {
            this.CEP = CEP;
        }

        public String getUF() {
            return UF;
        }

        public void setUF(String UF) {
            this.UF = UF;
        }

        public String getNumero() {
            return Numero;
        }

        public void setNumero(String Numero) {
            this.Numero = Numero;
        }
}
