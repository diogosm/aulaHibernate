/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logica;

import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author diogo
 */
public class AdicionaContatoServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        PrintWriter out = response.getWriter();
   
        String nome = request.getParameter("nome");
        System.out.println(nome);
        String endereco = request.getParameter(""
            + "endereco");
        String email	= request.getParameter("email");
        String dataEmTexto =	request.getParameter(""
            + "dataNascimento");
        Calendar dataNascimento = null;
        try{
            Date date = new SimpleDateFormat(""
                + "dd/MM/yyyy").parse(dataEmTexto);
            dataNascimento = Calendar.getInstance();
            dataNascimento.setTime(date);
        }catch(ParseException e){
            out.println("Erro de conversão da data");
            return;		
        }
        
        ContatoOld contato = new ContatoOld();
        contato.setNome(nome);
        contato.setEndereco(endereco);
        contato.setEmail(email);
        contato.setDataCad(dataNascimento);
        ContatoDAO dao = new ContatoDAO();
        dao.adiciona(contato);

        RequestDispatcher rd = 
        request.getRequestDispatcher(""
            + "/contato-adicionado.jsp");
        rd.forward(request,response);  
    }
    
}
