/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author PUTRITOP
 */
public  abstract class Boundary extends HttpServlet {
       private HttpServletRequest request;
    
    private HttpServletResponse response;

    private String message;

    private String template;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    protected void initVars(HttpServletRequest request, HttpServletResponse response){
        this.request = request;

        this.response = response;

        message = "";
    
}
      public void display(){
        try {
            if (this.template == null) {
                this.template = "/WEB-INF/jsps/" + this.getClass().getName() + ".jsp";
            }
            request.setAttribute("message", message);
            RequestDispatcher requestDispatcher = this.request.getRequestDispatcher(this.template);
            requestDispatcher.include(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(Boundary.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Boundary.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    abstract protected void process();
 }
