package com.google.sps.servlets;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import com.google.gson.Gson;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/awesomefood")
public final class MyFavoriteFood extends HttpServlet {

    public class EasyDish implements Serializable{
        private String dishName;
        private String origin;

        public String getDishName() {
            return dishName;
        }
        public String getOrigin() {
            return origin;
        }
        public void setDishName(String nombre) {
            this.dishName = nombre;
        }
        public void setOrigin(String origen) {
            this.origin = origen;
        }
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    
        EasyDish platillo = new EasyDish();
        platillo.setDishName("enchiladas verdes");
        platillo.setOrigin("Mexico");

        EasyDish platillo2 = new EasyDish();
        platillo2.setDishName("hamburgers");
        platillo2.setOrigin("the United States");

        ArrayList<EasyDish> dishesArray = new ArrayList<EasyDish>();
        dishesArray.add(platillo);
        dishesArray.add(platillo2);
    
        String json = convertToJsonUsingGson(dishesArray);

        response.setContentType("application/json;");
        response.getWriter().println(json);
    }

    private String convertToJsonUsingGson(ArrayList<EasyDish> arrayFavDishes) {
    Gson gson = new Gson();
    String json = gson.toJson(arrayFavDishes);
    return json;
    }
}