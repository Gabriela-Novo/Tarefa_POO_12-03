/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package web;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Gabriela-Novo
 */
@WebServlet(name = "Greetings", urlPatterns = {"/greeting.html"})
public class Greetings extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Greetings Servlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h4><a href='index.html'>Voltar</a></h4>");
            
            LocalDate DataAt = LocalDate.now();
            LocalTime HrAt = LocalTime.now();
            int Data = DataAt.getDayOfMonth();
            int Hr = HrAt.getHour();
            int Min = HrAt.getMinute();
            out.println("<h2>Hoje é dia " + Data + "</h2>");
            
            if (HrAt.isAfter(LocalTime.of(5, 59)) && HrAt.isBefore(LocalTime.of(12, 0))){
                out.println("<h2>Agora são " + Hr + ":" + Min + ". Bom dia!</h2>");
            }
            
            else if (HrAt.isAfter(LocalTime.of(11, 59)) && HrAt.isBefore(LocalTime.of(18, 0))){
                out.println("<h2>Agora são " + Hr + ":" + Min + ". Boa tarde!</h2>");
            }
            
            else if (HrAt.isAfter(LocalTime.of(17, 59)) && HrAt.isBefore(LocalTime.of(23, 0))){
                out.println("<h2>Agora são " + Hr + ":" + Min + ". Boa noite!</h2>");
            }
            
            else {
                out.println("<h2>Agora são " + Hr + ":" + Min + ". Vai dormir!");
            }
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
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
     *
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
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
