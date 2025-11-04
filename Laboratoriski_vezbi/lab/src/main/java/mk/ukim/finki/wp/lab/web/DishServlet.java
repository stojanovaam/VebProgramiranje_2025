package mk.ukim.finki.wp.lab.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import jakarta.servlet.annotation.WebServlet;
import mk.ukim.finki.wp.lab.model.Chef;
import mk.ukim.finki.wp.lab.model.Dish;
import mk.ukim.finki.wp.lab.service.ChefService;
import mk.ukim.finki.wp.lab.service.DishService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@WebServlet(name="DishServlet",urlPatterns="/dish")
public class DishServlet extends HttpServlet {

    private final DishService dishService;
    private final ChefService chefService;
    private final SpringTemplateEngine engine;

    //otkako kje se izbere gotvach, se isprakja baranje do tuka Post
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);

        WebContext webContext=new WebContext(webExchange);

        Long chefId=Long.valueOf(req.getParameter("chefId")); //se zima id na gotvach
        //vrati gi site jadenja za da mozhe Gotvach da izbere jadenja
        //zemi go celiot chef objekt spored chef Id, za da mozhe da se prikazhat podatoci za nego
        //i da se ispratat site ovie podatoci do sledniot servlet

        List<Dish> dishes=dishService.listDishes(); //gji zima site jadenja
        Chef chef=chefService.findById(chefId); //zemen e chefot
        webContext.setVariable("dishes",dishes);
        webContext.setVariable("chef",chef);

        engine.process("dishesList.html",webContext,resp.getWriter());

    }
}
