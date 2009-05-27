<%-- 
    Document   : index
    Created on : 04/04/2009, 21:19:48
    Author     : Ailton Souza
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="util.Mensagens"%>
<link rel="stylesheet" type="text/css" href="estilo/si2009.css"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%
           
            if (session.getAttribute("USU_AUTENTICADO").equals("")) {
                String erro = "Realizar autenticação no sistema.<br><a href='index.jsp'>Tentar novamente</a>";
%>        
<jsp:forward page="inconsistenciaSistema.jsp">
    <jsp:param name="erro" value="<%=erro%>"/>
</jsp:forward>    
<% }else{
                 Mensagens msn = new Mensagens();
%>
<html><head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%=msn.getMn_Titulo_Site()%></title>
    </head>
    <body>
        <center>
            <table>
                <tr>
                    <td colspan="2"><br>
                        <br>
                        <br>
                        <br>
                        <br>
                        <br>
                        <br>
                        <br>
                    <br>                    <br>                </td>
                </tr>
                <tr>
                    
                    <td width="128" align="left" class="sub_titulo"><p><img src="img/produto/module.png" width="32" height="32"><a href="produtos/">Produtos</a></p>
                        <p>&nbsp;<img src="img/cliente/index.png" width="32" height="32"><a href="clientes/">Clientes</a></p>
                    <p><img src="img/usuario/accounts.png" width="32" height="32"><a href="usuarios/">Usuário</a></p><p><img src="img/venda.png" width="32" height="32"><a href="vendas/">Registrar Venda</a></p><p><img src="img/relatorio.png" width="32" height="32"><a href="relatorios/">Relatórios</a></p>
                  <p><img src="img/logon.png" width="32" height="32"><a href="logoffSistema.jsp">Sair do Sistema</a></p></td>
                    <td width="464" align="center" class="sub_titulo" valign="middle"><img src="img/logo_fornecedor.png" width="180" height="180"></td>
                </tr>
                <tr>
                    <td height="207" colspan="2" align="center">Bem vindo ao sistema <strong>E-Reseller</strong>.<br>
                    Realizando um fornecimento de qualidade.</td>
                </tr>
                <tr>
                    <td height="14" colspan="2" align="center"><%=msn.getMn_Rodape_Site()%></td>
                </tr>
            </table>
        </center>    
    </body>
</html><%}%>
