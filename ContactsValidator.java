package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Luyet Thomas
 * <p>La classe ContactsValidator va servir a verifier les JTextField pour le numero de tel et l'email
 *    De cette maniere on s'assure qu'ils correspondent a un certain type.</p>
 */

public class ContactsValidator {



    public ContactsValidator (){

    }

    /**
     * <p>Permet de s'assurer que le mail comporte un @ puis à la fin un . et quelque chose par apres </p>
     * @param email
     * @return true ou false
     */

        //
    public boolean validerEmail(String email) {
        Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}$");
        Matcher matched = pattern.matcher(email.toUpperCase());
        return matched.matches();
    }


    /**
     * <p>Permet de verifier que l'on a 10 chiffres qui composent le numéro de tel.</p>
     * @param phone
     * @return true ou false
     */


    public boolean validerTel(String phone) {
        Pattern pattern = Pattern.compile("\\d{10}");
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }

}
