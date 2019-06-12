package com.company;


/**
 * @author Luyet Thomas
 * <p>La classe ContactsData va permettre de definir les composants de chaque contact.</p>
 */


public class ContactsData {

    private String nom;
    private String prenom;
    private String email;
    private String numTel;
    private String adresse;
    private String npa;
    private String image;


    /**
     * <p>Pour les images, il s'agira uniquement de recuperer le chemin d'acces
     * pour la photo du contact</p>
     */

    public ContactsData(){

        nom="";
        prenom="";
        email="";
        numTel="";
        adresse="";
        npa="";
        image="";

    }

    public ContactsData(String nom,String prenom,String email,String numTel,String adresse, String npa,String image){

        this.nom=nom;
        this.prenom=prenom;
        this.email=email;
        this.numTel=numTel;
        this.adresse=adresse;
        this.npa=npa;
        this.image=image;

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


    public String getImage() { return image; }

    public void setImage(String image) { this.image = image; }


    /**
     * <p>Cette méthode va nous retourner un toString restreint à savoir uniquement
     *      nom + prenom
     *      On va l'utiliser pour afficher la référence personnelle de chaque contact
     *      dans la classe FrameContacts</p>
     *
     * @return nom + prenom
     */

    public String NameInfoAsString(){

        return nom + " " + prenom;
    }


}
