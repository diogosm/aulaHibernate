<%-- 
    Document   : adicionar
    Created on : 03/11/2018, 23:38:00
    Author     : diogo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Formulário de contato</title>
        <style type="text/css">
            h3{font-family: Calibri; font-size: 22pt; font-style: normal; font-weight: bold; color:SlateBlue;
               text-align: center; text-decoration: underline }
            table{font-family: Calibri; color:white; font-size: 11pt; font-style: normal;width: 50%;
                  background-color: SlateBlue; border-collapse: collapse; border: 2px solid navy}
            table.inner{border: 0px}
        </style>
    </head>
    <body>
        <h3>Formulário de Contatos</h3>
        <form action="ContatoAdicionarController" method="POST">
            <table align="center" cellpadding = "10">
                <tr>
                    <td>Nome</td>
                    <td><input type="text" name="nome" maxlength="30"/>
                    </td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td><input type="text" name="email" maxlength="30"/>
                    </td>
                </tr>
                <tr>
                    <td>Endereço</td>
                    <td><input type="text" name="endereco" maxlength="30"/>
                    </td>
                </tr>
                <tr>
                    <td>Data de nascimento</td>
                    <td><input type="text" name="datanascimento" maxlength="100" /></td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Submit">
                        <input type="reset" value="Reset">
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>