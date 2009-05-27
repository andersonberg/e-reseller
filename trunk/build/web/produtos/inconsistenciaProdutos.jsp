<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="util.Mensagens" %>
<link rel="stylesheet" type="text/css" href="../estilo/si2009.css"/>

<%
            Mensagens msn = new Mensagens();
            String erro = request.getParameter("erro");
%>
<html>
    <head>
    </head>
    <body>
        <center>
            <table height="530">
<tr><td colspan="3"><br><br><br><br><br><br><br><br><br><br><br><br></td></tr>
                <tr><td colspan="3" class="titulo_topo" align="center"><%=erro%></td></tr>
                <tr><td colspan="3"><br><br><br><br><br><br><br><br><br><br></td></tr>
                <tr><td align="center" colspan="3"><%=msn.getMn_Rodape_Site()%></td>
                </tr>
        </table></center>
   </body>
</html>