/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package simple.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LuanTNKSE184059
 */
@WebServlet(name="RequestServlet", urlPatterns={"/RequestServlet"})
public class RequestServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RequestServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>HTTP Servlet Request Demo</h1>");
            Enumeration parNames = request.getParameterNames();
            int count = 0;
            while(parNames.hasMoreElements()) {
                ++count;
                String parName = (String) parNames.nextElement();
                out.print("parName " + count + " is " + parName);
                
                String parVal = request.getParameter(parName);
                out.println(" and value is " + parVal + "<br/>");
            }
            
            String strServer = request.getServerName();
            out.println("Server Name: " + strServer + "<br/>");
            int length = request.getContentLength();
            out.println("Length in bytes " + length + "<br/>" );
            
            String strHost = request.getHeader("host");
            out.println("Header - host: " + strHost + "<br/>");
            String strMethod = request.getMethod();
            out.println("Request Method " + strMethod + "<br/>");
            String qs = request.getQueryString();
            out.println("Query String " + qs + "<br/><br/>");
            
            String username = request.getParameter("txtUser");
            String password = request.getParameter("txtPass");
            
            out.println("Your input is <br/>");
            out.println("Username: " + username + " and " + password);
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
