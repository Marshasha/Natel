package com.company;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FunWithJackson {


    @Test
    void objFromString(){

        Exception ex = null;

        String author = "Jane Doe";

        ObjectMapper om = new ObjectMapper();

        String jsonStr = "{\"author\": \"" + author + "\", \"title\": \"No such article\"," +
                " \"journal\": \"Nouvelliste\", \"url\": \"www.nouvelliste.ch\"}";


        try {
            Article art = om.readValue(jsonStr, Article.class);
            System.out.println(art);
            assertTrue(author.equals(art.getAuthor()));
        } catch (Exception e){
            ex = e;
        }

        assertNull(ex);

    }




    void objectFromString(){



    }

}
