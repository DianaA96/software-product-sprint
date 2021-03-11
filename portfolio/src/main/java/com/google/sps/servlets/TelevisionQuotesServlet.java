package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Handles requests sent to the /hello URL. Try running a server and navigating to /hello! */
@WebServlet("/favoritewords")
public class TelevisionQuotesServlet extends HttpServlet {

  @Override
  
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    String quote1 = "I demand a trial by combat! - Game of Thrones";
    String quote2 = "Winter is coming. - Game of Thrones";
    String quote3 = "It'll Look Longer When It's Combed Out, Right? - Malcolm in the Middle";
    String quote4= "Scissors Cuts Paper. Paper Covers Rock. Rock Crushes Lizard. - The Big Bang Theory";
    String quote5 = "Robert Oppenheimer Was Lonely. - The Big Bang Theory";

    TheQuotes theQuotes = new TheQuotes(quote1, quote2, quote3, quote4, quote5);
    String json = convertToJsonUsingGson(theQuotes);

    response.setContentType("application/json;");
    response.getWriter().println(json);
  }

  private String convertToJsonUsingGson(TheQuotes theQuotes) {
    Gson gson = new Gson();
    String json = gson.toJson(theQuotes);
    return json;
  }
  
} 