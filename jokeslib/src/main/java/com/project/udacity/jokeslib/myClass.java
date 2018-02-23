package com.project.udacity.jokeslib;

import java.util.Random;

public class myClass {
    public String tellAJoke(){
        Random rand = new Random();
        int value = rand.nextInt(3);
        String[] jokes = {"Why do java programmers have to wear glasses?\n"
                + "Because they don't c#." , "How many programmers does it take to change a light bulb?\n" +
                "None – It’s a hardware problem", "Eight bytes walk into a bar.  The bartender asks, “Can I get you anything?”\n" +
                "“Yeah,” reply the bytes.  “Make us a double.”"};
        return jokes[value];
    }
}
