package com.udacity.gradle.builditbigger.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.project.udacity.jokeslib.myClass;

import javax.inject.Named;

import sun.rmi.runtime.Log;

/** An endpoint class we are exposing */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.gradle.udacity.com",
                ownerName = "backend.builditbigger.gradle.udacity.com",
                packagePath = ""
        )
)
public class MyEndpoint {
    /** A simple endpoint method that takes a name and says Hi back */
    @ApiMethod(name = "returnJoke")
    public MyBean returnJoke() {
        myClass myClass = new myClass() ;
        String Joke = myClass.tellAJoke();
        MyBean response = new MyBean();
        response.setData(Joke);
        return response ;
    }


}
