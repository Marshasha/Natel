package com.company;

import java.io.Serializable;

public class ContactsData implements Serializable {

    private String nom;
    private String prenom;
    private String email;
    private String numTel;
    private String adresse;
    private String npa;



    public ContactsData(){

        nom="";
        prenom="";
        email="";
        numTel="";
        adresse="";
        npa="";


    }

    public ContactsData(String nom,String prenom,String email,String numTel,String adresse, String npa){

        this.nom=nom;
        this.prenom=prenom;
        this.email=email;
        this.numTel=numTel;
        this.adresse=adresse;
        this.npa=npa;


    }



    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNpa() {
        return npa;
    }

    public void setNpa(String npa) {
        this.npa = npa;
    }


}
