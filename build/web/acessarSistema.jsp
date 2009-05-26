
<%@page import="util.Mensagens, usuario.*" %>
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
            RepositorioUsuarios repUsuario = new RepositorioUsuariosMySQL();
            CadastroUsuarios cadUsuario = new CadastroUsuarios(repUsuario);
            int codigoUsuarioLogado = cadUsuario.liberarAcesso(login, senha);
            if (codigoUsuarioLogado > 0) {
                Usuario usuario = cadUsuario.procurar(codigoUsuarioLogado,1);
                if (usuario.getId_cli() > 0) {
                    erro = "Este Usuário não é funcionário do E-reseller para utilizar o sistema.<br><a href='index.jsp'>Tentar novamente</a>";
        %>
        <jsp:forward page="inconsistenciaSistema.jsp">
            <jsp:param name="erro" value="<%=erro%>"/>
        </jsp:forward>     
        
        <%
                } else {

                    session.setAttribute("USU_AUTENTICADO", login);
                    session.setAttribute("ID_USU_LOGADO", codigoUsuarioLogado);
        %>
        <jsp:forward page="sistema.jsp"/>
        <% }
            } else {
                erro = "Usuário não habilitado para utilizar o sistema.<br><a href='index.jsp'>Tentar novamente</a>";
        %>
        <jsp:forward page="inconsistenciaSistema.jsp">
            <jsp:param name="erro" value="<%=erro%>"/>
        </jsp:forward>     
        <%
        }
    }

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