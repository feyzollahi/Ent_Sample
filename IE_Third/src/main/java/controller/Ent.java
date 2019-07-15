package controller;

import model.EntUtil;
import org.json.simple.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ent", urlPatterns = "/")
public class Ent extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            JSONObject jsonObject = (JSONObject) EntUtil.getHTML("https://api.myjson.com/bins/e2udt");
            EntUtil entUtil = new EntUtil(jsonObject);
            System.out.println("good");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
