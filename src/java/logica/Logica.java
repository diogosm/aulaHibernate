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
public interface Logica {

    String executa(HttpServletRequest req,
            HttpServletResponse res) throws Exception;
}
