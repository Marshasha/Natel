package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContactsValidator {

    public ContactsValidator (){

    }

    public boolean validerEmail(String email) {
        Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}$");
        Matcher matched = pattern.matcher(email.toUpperCase());
        return matched.matches();
    }


    public boolean validerTel(String phone) {
        Pattern pattern = Pattern.compile("\\d{10}");
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }

}
