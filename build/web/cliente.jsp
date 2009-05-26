<%-- 
    Document   : index
    Created on : 04/04/2009, 21:19:48
    Author     : Ailton Souza
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="util.Mensagens"%>
<%@ page session="true"%>
<link rel="stylesheet" type="text/css" href="estilo/si2009.css"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%
            Mensagens msn = new Mensagens();
            session.setAttribute("login", "");
%>
<html><head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%=msn.getMn_Titulo_Site()%></title>
    </head>
    <body>
        <center>
            <table>
                <tr><td height="153" colspan="4"><br>
                        <br><br><br>
                    </td>
                </tr>
                <tr>
                  <td width="416" colspan="2" align="center" class="sub_titulo"><p><img src="img/clienteeparceiros/sonyericsson.jpg" width="150" height="113">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="img/clienteeparceiros/carrefour.jpg" width="136" height="106"><br>
                  </p>                    
                        <p><img src="img/clienteeparceiros/aoc.jpg" width="150" height="51"><br><img src="img/clienteeparceiros/toshiba.jpg"></p>
                      <p><br>
                  </p></td>
                    <td width="146" colspan="2" rowspan="3" valign="top"><img src="img/clienteeparceiros/pearson.jpg" width="130" height="94"><br> <br><br><img src="img/clienteeparceiros/xerox.jpg">   <br><br><br><img src="img/clienteeparceiros/lex.jpg">                </td>
              </tr>
                
                <tr>
                  <td align="center" colspan="4" class="menu_sup"><div align="center"><a href="">Home</a></div></td>
                </tr>
                <tr><td align="center" colspan="4"><%=msn.getMn_Rodape_Site()%></td></tr>
            </table>
     
    </center>    
    </body>
</html>
