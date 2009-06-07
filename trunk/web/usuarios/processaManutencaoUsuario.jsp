<%@page import="util.Mensagens, usuario.Usuario,fachada.Fachada, usuario.exceptions.*" %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="../estilo/si2009.css"/>
<%
            if (session.getAttribute("USU_AUTENTICADO").equals("")) {
                String erro = "Realizar autenticação no sistema.<br><a href='../index.jsp'>Tentar novamente</a>";
%>        
<jsp:forward page="inconsistenciaUsuarios.jsp">
    <jsp:param name="erro" value="<%=erro%>"/>
</jsp:forward> 
<%}else{
            try {
                Mensagens msn = new Mensagens();
                Fachada fachada = (Fachada) session.getAttribute("FACHADA");
                String codigoTemporario = (String) request.getParameter("id").toString();
                String nome = (String) request.getParameter("edtNome").toString();
                String login =(String) request.getParameter("edtLogin").toString();
                String senha =(String) request.getParameter("edtSenha").toString();
                String status =(String) request.getParameter("status").toString();
                Usuario usuario = new Usuario(Integer.parseInt(codigoTemporario), nome, login, senha,0, status);
                String informacao = null;
                if (codigoTemporario.equals("0")){
                    fachada.inserirUsuario(usuario);
                    informacao = "Usuário <strong>cadastrado</strong> com sucesso.";
                }else{
                    fachada.atualizarUsuario(usuario);
                    informacao = "Usuário <strong>alterado</strong> com sucesso.";
                }
                
%>
<html>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head>
</head>
<body>
<center>
<table>
<tr><td colspan="3"><br><br><br><br><br><br><br><br><br><br></td><br><br><br><br><br><br><br><br><br><br></td></tr>
<tr><td colspan="3" class="titulo_topo"><div align="center"><%=informacao%><br>
<a href="">Voltar</a></div></td></tr>
<tr><td colspan="3"><br><br><br><br><br><br><br><br><br><br></td></tr>
<tr><td align="center" colspan="3"><%=msn.getMn_Rodape_Site()%></td>
</tr>
</table>
</center>

<%
} catch (Exception e) {
    String erro = e.getMessage()+".<br><a href='index.jsp'>Tentar novamente</a>";
%>
<jsp:forward page="inconsistenciaUsuarios.jsp">
    <jsp:param name="erro" value="<%=erro%>"/>
</jsp:forward> 
<%

            }
%>
</body>
</html><%}%>