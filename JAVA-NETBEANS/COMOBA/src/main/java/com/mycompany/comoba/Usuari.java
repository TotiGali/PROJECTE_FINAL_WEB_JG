/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.comoba;

/**
 *
 * @author jordi
 */
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Usuari")
public class Usuari {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsuari")
    private int idUsuari;

    @Column(name = "Nom")
    private String nom;

    @Column(name = "Cognom")
    private String cognom;

    @Column(name = "Correu")
    private String correu;

    @Column(name = "Telèfon")
    private Integer telefon;

    @Column(name = "Data_alta")
    @Temporal(TemporalType.DATE)
    private Date dataAlta;

    @Column(name = "Rol")
    private String rol;

    @Column(name = "Contrasenya")
    private String contrasenya;

    @Column(name = "Categoria_client")
    private String categoriaClient;

    @Column(name = "Entitat")
    private String entitat;

    @Lob
    @Column(name = "Doc_client_logo")
    private byte[] docClientLogo;

    // Getters and Setters

    public int getIdUsuari() {
        return idUsuari;
    }

    public void setIdUsuari(int idUsuari) {
        this.idUsuari = idUsuari;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognom() {
        return cognom;
    }

    public void setCognom(String cognom) {
        this.cognom = cognom;
    }

    public String getCorreu() {
        return correu;
    }

    public void setCorreu(String correu) {
        this.correu = correu;
    }

    public Integer getTelefon() {
        return telefon;
    }

    public void setTelefon(Integer telefon) {
        this.telefon = telefon;
    }

    public Date getDataAlta() {
        return dataAlta;
    }

    public void setDataAlta(Date dataAlta) {
        this.dataAlta = dataAlta;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    public String getCategoriaClient() {
        return categoriaClient;
    }

    public void setCategoriaClient(String categoriaClient) {
        this.categoriaClient = categoriaClient;
    }

    public String getEntitat() {
        return entitat;
    }

    public void setEntitat(String entitat) {
        this.entitat = entitat;
    }

    public byte[] getDocClientLogo() {
        return docClientLogo;
    }

    public void setDocClientLogo(byte[] docClientLogo) {
        this.docClientLogo = docClientLogo;
    }
}
