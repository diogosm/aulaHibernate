/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logica;

import javax.servlet.http.*;

/**
 *
 * @author diogo
 */
public class RemoveContatoLogic implements Logica {

    public String executa(HttpServletRequest req,
            HttpServletResponse res)
            throws Exception {
        System.out.println("teste1...");
        Integer id = Integer.parseInt(req.getParameter("id"));
        ContatoOld contato = new ContatoOld();
        contato.setId(id);
        ContatoDAO dao = new ContatoDAO();
        System.out.println("teste2...");
        dao.remove(contato);
        System.out.println("Excluindo contato...");
        return "lista-contato.jsp";
    }
}
