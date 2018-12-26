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
public class Locatario_Fisico {
@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
private Integer id;

    private String Nome, Sexo, LocalNascimento, RG, CPF, Profissao, NomeMae, EstadoCivil, Conjuge, Logradouro, Bairro,
                   Cidade, UF, CEP, Complemento, Telefone, Celular, Email, NumeroCasa;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getNome() {
            return Nome;
        }

        public void setNome(String Nome) {
            this.Nome = Nome;
        }

        public String getSexo() {
            return Sexo;
        }

        public void setSexo(String Sexo) {
            this.Sexo = Sexo;
        }

        public String getLocalNascimento() {
            return LocalNascimento;
        }

        public void setLocalNascimento(String LocalNascimento) {
            this.LocalNascimento = LocalNascimento;
        }

        public String getRG() {
            return RG;
        }

        public void setRG(String RG) {
            this.RG = RG;
        }

        public String getCPF() {
            return CPF;
        }

        public void setCPF(String CPF) {
            this.CPF = CPF;
        }

        public String getProfissao() {
            return Profissao;
        }

        public void setProfissao(String Profissao) {
            this.Profissao = Profissao;
        }

        public String getNomeMae() {
            return NomeMae;
        }

        public void setNomeMae(String NomeMae) {
            this.NomeMae = NomeMae;
        }

        public String getEstadoCivil() {
            return EstadoCivil;
        }

        public void setEstadoCivil(String EstadoCivil) {
            this.EstadoCivil = EstadoCivil;
        }

        public String getConjuge() {
            return Conjuge;
        }

        public void setConjuge(String Conjuge) {
            this.Conjuge = Conjuge;
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

        public String getUF() {
            return UF;
        }

        public void setUF(String UF) {
            this.UF = UF;
        }

        public String getCEP() {
            return CEP;
        }

        public void setCEP(String CEP) {
            this.CEP = CEP;
        }

        public String getComplemento() {
            return Complemento;
        }

        public void setComplemento(String Complemento) {
            this.Complemento = Complemento;
        }

        public String getTelefone() {
            return Telefone;
        }

        public void setTelefone(String Telefone) {
            this.Telefone = Telefone;
        }

        public String getCelular() {
            return Celular;
        }

        public void setCelular(String Celular) {
            this.Celular = Celular;
        }

        public String getEmail() {
            return Email;
        }

        public void setEmail(String Email) {
            this.Email = Email;
        }
        
        public String getNumeroCasa() {
        return NumeroCasa;
    }

        public void setNumeroCasa(String NumeroCasa) {
        this.NumeroCasa = NumeroCasa;
    }

    }
