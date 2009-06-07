<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="util.Mensagens,usuario.Usuario,cliente.Cliente,fachada.Fachada,java.util.*" %>
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
    Fachada fachada = (Fachada) session.getAttribute("FACHADA");
//DADOS USUARIO
    Collection usuarios = fachada.procurarUsuarios();
    Iterator iUsuarios = usuarios.iterator();

//DADOS CLIENTE
    Cliente cliente = null;

    String nomeCliente = "";
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
                        <td align="center" class="titulo_topo">Usuários Cadastrados</td>
                    </tr>
                    <tr><td>
                            
                            <br>
                            <table width="417" border="0" class="btabela_relatorio">
                                <tr>
                                    <th width="266" scope="col" class="btabela_relatorio"><div align="left" class="titulo_topo">Nome</div></th>
                                    <th width="69" scope="col" class="btabela_relatorio"><div align="center" class="titulo_topo">Login</div></th>
                                    <th width="68" scope="col" class="btabela_relatorio"><div align="center" class="titulo_topo">Status</div></th>
                                </tr>
                                <%
    if (!usuarios.isEmpty()) {
        while (iUsuarios.hasNext()) {
            Usuario usuario = (Usuario) iUsuarios.next();

                                %>
                                <tr>
                                    <td class="titulo"><%=usuario.getNome_usu()%>
                                        <%
                                        if (usuario.getId_cli() > 0) {
                                            cliente = fachada.procurarCliente(usuario.getId_cli());
                                            nomeCliente = "(" + cliente.getNome_cli() + ")";
                                        } else {
                                            nomeCliente = "";
                                        }%><i><font color="#FF0000"><%=nomeCliente%></font></i>                                    
                                    </td>
                                    <td><div align="center"><%=usuario.getLogin_usu()%></div></td>
                                    <td>
                                        <div align="center"><% String status = "";
                                        if (usuario.getStatus_usu().equals("A")) {
                                            status = "ATIVO";
                                        } else {
                                            status = "INATIVO";
                                        }%><%=status%></div></td>
                                </tr>
                                
                                <%
                                    }
                                } else {
                                %>
                                <tr><td colspan="3" align="center" class="titulo">Não existem dados de usuários cadastrado.</td></tr>                
                                
                                <%            }
                                %>
                            </table>
                            <div align="center"><br>
                                <br>
                                <input type="button" value="Voltar" onClick="javascript:location.href='index.jsp'">
                                &nbsp;&nbsp;&nbsp;
                                <input type="button" value="Imprimir" onClick="javascript:window.print()">
                                <br>
                                <br>
                                <br>
                                <br>
                                <br>
                                <br>
                                <br>
                                <br>
                    </div></td></tr>
                    <tr><td align="center"><%=msn.getMn_Rodape_Site()%></td></tr>
                </table>
        </center> </form>   
    </body>
</html>
<%}%>