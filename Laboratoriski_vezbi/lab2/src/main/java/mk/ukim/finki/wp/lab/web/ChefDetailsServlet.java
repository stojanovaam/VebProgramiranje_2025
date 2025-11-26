/*
package mk.ukim.finki.wp.lab.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import mk.ukim.finki.wp.lab.model.Chef;
import mk.ukim.finki.wp.lab.service.ChefService;
import mk.ukim.finki.wp.lab.service.DishService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@WebServlet(name="ChefDetailsServlet",urlPatterns="/chefDetails")
@RequiredArgsConstructor
public class ChefDetailsServlet extends HttpServlet {

    private final ChefService chefService;
    private final DishService dishService;
    private final SpringTemplateEngine engine;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange exchange= JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);

        WebContext context=new WebContext(exchange);

        Long chefId= Long.valueOf(req.getParameter("id-toooNaChef"));
        String dishId=req.getParameter("id-tooooNaDish");
        Chef dodadenChef=chefService.addDishToChef(chefId,dishId);

        context.setVariable("dodadenChef",dodadenChef);

        engine.process("chefDetails.html",context,resp.getWriter());
    }
}
*/
