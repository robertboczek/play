package controllers;

import static play.libs.Json.toJson;

import java.util.List;

import models.Bar;
import play.*;
import play.data.Form;
import play.db.ebean.Model;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Hello world!"));
    }

    public static Result addBar() {
    	Bar bar = Form.form(Bar.class).bindFromRequest().get();
    	
    	bar.save();
    	return redirect(routes.Application.index());
    }
    
    public static Result listBars() {
    	List<Bar> bars = new Model.Finder<>(String.class, Bar.class).all();
    	
    	return ok(toJson(bars));
    }
}
