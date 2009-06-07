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
<jsp:forward page="inconsistenciaRelatorios.jsp">
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
</SCRIPT>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%=msn.getMn_Titulo_Site()%></title>
    </head>
    <body>
        <form name="frmMain" method="post">
        <input type="hidden" id="tipo" name="tipo" value="2">
            <center>
                <table>
                    <tr><td width="417" align="left"><br>
                    <br><br><br><br><br><br><br><br><br><a href="../sistema.jsp">Home</a></td></tr>
                    <tr>
                        <td align="center" class="titulo_topo">Clientes Cadastrados</td>
                    </tr>
                    <tr><td>
<br>
                            <table width="489" border="0" class="btabela_relatorio">
  <tr>
                                    <th width="219" scope="col" class="btabela_relatorio"><div align="left">Nome</div></th>
              <th scope="col" class="btabela_relatorio"><div align="left">Endereço</div></th>
              </tr>
                                <%
            if (!clientes.isEmpty()) {
                while (iClientes.hasNext()) {
                    Cliente cliente = (Cliente) iClientes.next();

                                %>
                                <tr>
                                    <td class="titulo"><a href="javascript:Redirecionar('vendas.jsp?id=<%=cliente.getId_cli()%>')"><%=cliente.getNome_cli()%></a></td>
                                    <td><%=cliente.getEndereco_cli()%></td>
                                </tr>
                                
                          <%
                                    }%>
                                    <tr><td colspan="2" class="titulo"><br><i>Clique no nome do cliente para visualizar suas compras.</i></td></tr>
                                    <%
                                } else {
                                %>
                                <tr><td colspan="2" align="center" class="titulo">Não existem dados de Clientes cadastrado.</td></tr>                
                                
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