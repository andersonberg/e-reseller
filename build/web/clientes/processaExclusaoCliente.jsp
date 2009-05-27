<%@page import="util.Mensagens, cliente.*,usuario.*,usuario.exceptions.*,venda.*,venda.exceptions.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="../estilo/si2009.css"/>
<%
            if (session.getAttribute("USU_AUTENTICADO").equals("")) {
                String erro = "Realizar autenticação no sistema.<br><a href='../index.jsp'>Tentar novamente</a>";
%>        
<jsp:forward page="inconsistenciaUsuarios.jsp">
    <jsp:param name="erro" value="<%=erro%>"/>
</jsp:forward> 
<%} else {
    try {
        Mensagens msn = new Mensagens();
        String codigoCliente = request.getParameter("id").toString();
        
               //DADOS DE VENDA
        RepositorioVendas repVenda = new RepositorioVendasMySQL();
        CadastroVendas cadVenda = new CadastroVendas(repVenda);
        try {
            cadVenda.procurar(Integer.parseInt(codigoCliente), 2);
            String erro = "Não é possível excluir produto. Registro de Venda Localizado.<br><a href='index.jsp'>Tentar novamente</a>";
%>
<jsp:forward page="inconsistenciaClientes.jsp">
    <jsp:param name="erro" value="<%=erro%>"/>
</jsp:forward> 
<%

    } catch (VendaInexistenteException e) {
        //Não localizado PRODUTO permite a exclusão
        }
        //DADOS CLIENTE
        RepositorioClientes repCliente = new RepositorioClientesMySQL();
        CadastroClientes cadCliente = new CadastroClientes(repCliente);
        Cliente cliente = cadCliente.procurar(Integer.parseInt(codigoCliente));
        cadCliente.remover(cliente);
        //DADOS USUARIO
        RepositorioUsuarios repUsuario = new RepositorioUsuariosMySQL();
        CadastroUsuarios cadUsuario = new CadastroUsuarios(repUsuario);
        try {
            cadUsuario.remover(Integer.parseInt(codigoCliente));
        } catch (Exception e) {
        }

%>
<html>
<head>
</head>
<body>
<center>
<table>
<tr><td colspan="3"><br><br><br><br><br><br><br><br><br><br></td><br><br><br><br><br><br><br><br><br><br></td></tr>
<tr><td colspan="3" class="titulo_topo"><div align="center">Cliente excluído com sucesso.<br>
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
<jsp:forward page="inconsistenciaClientes.jsp">
    <jsp:param name="erro" value="<%=erro%>"/>
</jsp:forward> 
<%

    }
%>
</body>
</html><%}%>