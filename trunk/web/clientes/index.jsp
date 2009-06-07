<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="util.Mensagens,cliente.Cliente,fachada.Fachada,java.util.*" %>
<link rel="stylesheet" type="text/css" href="../estilo/si2009.css"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%
            Mensagens msn = new Mensagens();
            if (session.getAttribute("USU_AUTENTICADO").equals("")) {
                String erro = "Realizar autenticação no sistema.<br><a href='../index.jsp'>Tentar novamente</a>";
%>        
<jsp:forward page="inconsistenciaClientes.jsp">
    <jsp:param name="erro" value="<%=erro%>"/>
</jsp:forward>    
<% }else{
            Fachada fachada = (Fachada) session.getAttribute("FACHADA");
            Collection clientes = fachada.procurarClientes();
            Iterator iClientes = clientes.iterator();
%>

<SCRIPT language=JavaScript>

    function Redirecionar(url){
        document.frmMain.action= url;
        document.frmMain.submit();
    }
    function Redirecionar_Exclusao(url){
        if (confirm('Deseja realmente excluir este cliente?')) {
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
                        <td align="center" class="titulo_topo">Manutenção de Clientes</td>
                    </tr>
                    <tr><td>
                            <div align="left">
                                <input type="image" src="../img/staticexport.png" name="btnNovo" value="Novo" onClick="Redirecionar('cadCliente.jsp?id=0')">
                            </div>
                            <br>
                            <table width="489" border="0" class="btabela_grande">
  <tr>
                                    <th width="219" scope="col"><div align="left" class="titulo_topo">Nome</div></th>
              <th width="56" scope="col"><div align="center" class="titulo_topo">Editar</div></th>
              <th width="59" scope="col"><div align="center" class="titulo_topo">Excluir</div></th>
              <th width="137" scope="col"><div align="center" class="titulo_topo">Senha de Acesso</div></th>
                            </tr>
                                <%
            if (!clientes.isEmpty()) {
                while (iClientes.hasNext()) {
                    Cliente cliente = (Cliente) iClientes.next();

                                %>
                                <tr>
                                    <td class="titulo"><%=cliente.getNome_cli()%></td>
                                    <td><div align="center">
                                            <input type="image" src="../img/restore.png" name="btnEditar" value="Editar" onClick="Redirecionar('cadCliente.jsp?id=<%=cliente.getId_cli()%>')">
                                    </div></td>
                                  <td>
                                        <div align="center">
                                            <input type="image" src="../img/removed.png" name="btnExcluir" value="Excluir" onClick="Redirecionar_Exclusao('processaExclusaoCliente.jsp?id=<%= cliente.getId_cli()%>')">
                                  </div></td>
                                    <td><div align="center">
                                      <input type="image" src="../img/accounts.png" name="btnEditarUser" value="EditarUser" onClick="Redirecionar('cadUsuario.jsp?id=<%=cliente.getId_cli()%>')">
                                    </div></td>
                                </tr>
                                
                              <%
                                    }
                                } else {
                                %>
                                <tr><td colspan="4" align="center" class="titulo">Não existem dados de Clientes cadastrado.</td></tr>                
                                
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