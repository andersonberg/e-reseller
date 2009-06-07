
<%@page import="util.Mensagens, usuario.Usuario, fachada.*, controladores.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page session="true"%>
<link rel="stylesheet" type="text/css" href="estilo/si2009.css"/>
<%
            try {
                Mensagens msn = new Mensagens();
                String login = (String) request.getParameter("txtUsuario");
                String senha = (String) request.getParameter("txtSenha");
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
        <%
    String erro = "";
    if (login.equals("")) {
        erro = "Informe um usuário para proceder com o acesso.<br><a href='index.jsp'>Tentar novamente</a>";
        %>
        <jsp:forward page="inconsistenciaSistema.jsp">
            <jsp:param name="erro" value="<%=erro%>"/>
        </jsp:forward>
        <%
        } else if (senha.equals("")) {
            erro = "Informe uma senha para proceder com o acesso.<br><a href='index.jsp'>Tentar novamente</a>";
        %>
        <jsp:forward page="inconsistenciaSistema.jsp">
            <jsp:param name="erro" value="<%=erro%>"/>
        </jsp:forward>
        <%
        } else {
            Fachada fachada;
            if (session.getAttribute("FACHADA").equals("")) {
                fachada = new Fachada();
            } else {
                fachada = (Fachada) session.getAttribute("FACHADA");
            }
            Controladores controladores = new Controladores(fachada);
            Usuario usuario = controladores.LiberarAcesso(login, senha);

            session.setAttribute("USU_AUTENTICADO", usuario.getLogin_usu());
            session.setAttribute("ID_USU_LOGADO", usuario.getId_usu());
            session.setAttribute("FACHADA", fachada);
        %>
        <jsp:forward page="sistema.jsp"/>
        <%
    }
} catch (Exception e) {
        %>
        <jsp:forward page="inconsistenciaSistema.jsp">
            <jsp:param name="erro" value="<%=e.getMessage()%>"/>
        </jsp:forward> 
        <%            }
        %>
    </body>
</html>