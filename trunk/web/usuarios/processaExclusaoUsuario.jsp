<%@page import="util.Mensagens, usuario.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="../estilo/si2009.css"/>
<%
            if (session.getAttribute("USU_AUTENTICADO").equals("")) {
                String erro = "Realizar autenticação no sistema.<br><a href='index.jsp'>Tentar novamente</a>";
%>        
<jsp:forward page="inconsistenciaUsuarios.jsp">
    <jsp:param name="erro" value="<%=erro%>"/>
</jsp:forward> 
<%}else{
            try {
                Mensagens msn = new Mensagens();
                String codigoUsu = request.getParameter("id").toString();
                RepositorioUsuarios repUsuario = new RepositorioUsuariosMySQL();
                CadastroUsuarios cadUsuario = new CadastroUsuarios(repUsuario);
                Usuario usuario = cadUsuario.procurar(Integer.parseInt(codigoUsu),1);
                usuario.setStatus_usu("I");
                cadUsuario.atualizar(usuario);
%>
<html>
<head>
</head>
<body>
<center>
<table>
<tr><td colspan="3"><br><br><br><br><br><br><br><br><br><br></td><br><br><br><br><br><br><br><br><br><br></td></tr>
<tr><td colspan="3" class="titulo_topo"><div align="center">Usuário bloqueado com sucesso.<br>
<a href="">Voltar</a></div></td></tr>
<tr><td colspan="3"><br><br><br><br><br><br><br><br><br><br></td></tr>
<tr><td align="center" colspan="3"><%=msn.getMn_Rodape_Site()%></td>
</tr>
</table>
</center>

<%

} catch (Exception e) {
    String erro = "Erro Localizado ao processar dados.<br><a href='index.jsp'>Tentar novamente</a>";
%>
<jsp:forward page="inconsistenciaUsuarios.jsp">
    <jsp:param name="erro" value="<%=erro%>"/>
</jsp:forward> 
<%

            }
%>
</body>
</html><%}%>