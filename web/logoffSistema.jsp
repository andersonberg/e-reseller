
<%@page import="util.Mensagens" %>
<%@ page session="true"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="estilo/si2009.css"/>
<%
            try {
                Mensagens msn = new Mensagens();
                session.setAttribute("USU_AUTENTICADO", "");
                session.setAttribute("ID_USU_LOGADO", "0");
                session.setAttribute("FACHADA", "");
%>
<html>
    <head>
    </head>
    <body>
        <center>
            <table>
                <tr><td colspan="3"><br><br><br><br><br><br><br><br><br><br></td></tr>
                <tr><td colspan="3" class="titulo_topo">Processando dados. Aguarde...</td></tr>
                <tr><td colspan="3"><br><br><br><br><br><br><br><br><br><br></td></tr>
                <tr><td align="center" colspan="3"><%=msn.getMn_Rodape_Site()%></td>
                </tr>
        </table></center>
        <jsp:forward page="index.jsp"/>
        <%
} catch (Exception e) {
    String erro = "Erro Localizado ao processar dados.<br><a href='index.jsp'>Tentar novamente</a>";
        %>
        <jsp:forward page="inconsistenciaSistema.jsp">
            <jsp:param name="erro" value="<%=erro%>"/>
        </jsp:forward> 
        <%

            }
        %>
    </body>
</html>