
package com.mycompany.apigoogleschoolar;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import serpapi.GoogleSearch;
import serpapi.SerpApiSearchException;

/**
 *
 * @author Armando Josué
 */
public class AuthorController {
    //VARIABLE DE ENTORNO
    private final String API_KEY;
    
    private final List<AuthorModel> model;
    //-------------------------//
    public AuthorController(){
        this.API_KEY = "9438bfe22c1d7a98139b2b0c26f9ecae7a09136932a06a385a8660c79ff02c7f";
        model = new ArrayList<>();
    }
    public List<AuthorModel> fetch(String query){
        Map<String, String> parameter = new HashMap<>();

        parameter.put("engine", "google_scholar_profiles");
        parameter.put("mauthors", query);
        parameter.put("num", "10");
        parameter.put("api_key", API_KEY);

        GoogleSearch search = new GoogleSearch(parameter);

        try {
            JsonObject results = search.getJson();
            JsonArray profiles = results.get("profiles").getAsJsonArray();
            profiles.forEach(profile ->{
                String name = profile.getAsJsonObject().get("name").toString();
                String affiliations = profile.getAsJsonObject().get("affiliations").toString();
                String link = profile.getAsJsonObject().get("link").toString();
                model.add(new AuthorModel(name, affiliations, link));
            });
            return model;
        } catch (SerpApiSearchException e) {
            return null;
        }
    }
    
    public void saveAuthors(List<AuthorModel> models){
        models.forEach(model -> {
            model.save();
        });
        System.out.println("Se guardaron correctamente los datos");
    }
    
}
