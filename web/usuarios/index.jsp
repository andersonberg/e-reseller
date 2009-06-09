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
<jsp:forward page="inconsistenciaUsuarios.jsp">
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

<SCRIPT language=JavaScript>

    function Redirecionar(url){
        document.frmMain.action= url;
        document.frmMain.submit();
    }
    function Redirecionar_Exclusao(url){
        if (confirm('Deseja realmente bloquear este usuário?')) {
            document.frmMain.action= url;
            document.frmMain.submit();
        }
    }
</SCRIPT>

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
                        <td align="center" class="titulo_topo">Manutenção de Usuários</td>
                    </tr>
                    <tr><td>
                            <div align="left">
                                <input type="image" src="../img/staticexport.png" name="btnNovo" value="Novo" onClick="Redirecionar('cadUsuario.jsp?id=0')">
                            </div>
                            <br>
                            <table width="417" border="0" class="btabela_grande">
                                <tr>
                                    <th width="266" scope="col"><div align="left" class="titulo_topo">Nome</div></th>
                                    <th width="69" scope="col"><div align="center" class="titulo_topo">Editar</div></th>
                                    <th width="68" scope="col"><div align="center" class="titulo_topo">Bloquear</div></th>
                                </tr>
                                <%
    if (!usuarios.isEmpty()) {
        while (iUsuarios.hasNext()) {
            Usuario usuario = (Usuario) iUsuarios.next();

                                %>
                                <tr>
                                    <td class="titulo"><%=usuario.getNome_usu()%>
<%
if (usuario.getId_cli()>0){
    cliente = cadCliente.procurar(usuario.getId_cli());
    nomeCliente = "("+cliente.getNome_cli()+")";
}else{
     nomeCliente = ""; 
}%><i><font color="#FF0000"><%=nomeCliente%></font></i>                                    
</td>
                                    <td><div align="center">
                                            <input type="image" src="../img/restore.png" name="btnEditar" value="Editar" onClick="Redirecionar('cadUsuario.jsp?id=<%=usuario.getId_usu()%>')">
                                    </div></td>
                                    <td>
                                        <div align="center">
                                            <%if (usuario.getStatus_usu().equals("I")){%>
                                            <input type="image" readonly src="../img/unchanged.png" name="btnExcluir" value="Excluir" >
                                            <%}else{%>
                                            <input type="image" src="../img/bloq.png" name="btnExcluir" value="Excluir"onClick="Redirecionar_Exclusao('processaExclusaoUsuario.jsp?id=<%= usuario.getId_usu()%>')">
                                            <%}%>
                                    </div></td>
                                </tr>
                                
                                <%
                                    }
                                } else {
                                %>
                                <tr><td colspan="3" align="center" class="titulo">Não existem dados de usuários cadastrado.</td></tr>                
                                
                                <%            }
                                %>
                            </table>
                            <br><br><br><br><br><br><br><br>
                    </td></tr>
                    <tr><td align="center"><%=msn.getMn_Rodape_Site()%></td></tr>
                </table>
        </center> </form>   
    </body>
</html>
<%}%>