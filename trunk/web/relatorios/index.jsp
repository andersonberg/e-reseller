<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="util.Mensagens,usuario.*,cliente.*,java.util.*" %>
<link rel="stylesheet" type="text/css" href="../estilo/si2009.css"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%
            Mensagens msn = new Mensagens();
            if (session.getAttribute("USU_AUTENTICADO").equals("")) {
                String erro = "Realizar autenticação no sistema.<br><a href='../index.jsp'>Tentar novamente</a>";
%>        
<jsp:forward page="inconsistenciaRelatorios.jsp">
    <jsp:param name="erro" value="<%=erro%>"/>
</jsp:forward>    
<% } else {

//DADOS USUARIO
    RepositorioUsuarios repUsuario = new RepositorioUsuariosMySQL();
    CadastroUsuarios cadUsuario = new CadastroUsuarios(repUsuario);
    Collection usuarios = cadUsuario.procurarUsuarios();
    Iterator iUsuarios = usuarios.iterator();

//DADOS CLIENTE
    RepositorioClientes repCliente = new RepositorioClientesMySQL();
    CadastroClientes cadCliente = new CadastroClientes(repCliente);
    Cliente cliente = null;
    
    String nomeCliente ="";
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%=msn.getMn_Titulo_Site()%></title>
    </head>
    <body>
        <form name="frmMain" method="post">
            <center>
                <table>
                    <tr><td width="417" align="left"><br>
                    <br><br><br><br><br><br><br><br><br><a href="../sistema.jsp">Home</a></td></tr>
                    <tr>
                        <td align="center" class="titulo_topo">Relatórios do Sistema</td>
                    </tr>
                    <tr>
                      <td class="titulo"><div align="center"><img src="../img/resseler.JPG" width="307" height="70"><BR>
                    Todas as informações a partir de simples relatórios.
                        <br>
                        <br>
					  </div>
                        <br><li> <a href="produtos.jsp">Produtos cadastrados</a></li><br>
                     <li> <a href="clientes.jsp">Clientes cadastrados</a></li><br>
                    <li> <a href="usuarios.jsp">Usuários cadastrados</a></li>
                    <br>
                      <br>
                          <li> <a href="gerencial.jsp">Detalhamento de Vendas</a></li><br><br>
                      <br>
                    </td></tr>
                    <tr><td align="center"><%=msn.getMn_Rodape_Site()%></td></tr>
                </table>
        </center> </form>   
    </body>
</html>
<%}%>