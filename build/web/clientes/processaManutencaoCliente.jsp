<%@page import="util.Mensagens, cliente.*, cliente.exceptions.*" %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="../estilo/si2009.css"/>
<%
            if (session.getAttribute("USU_AUTENTICADO").equals("")) {
                String erro = "Realizar autenticação no sistema.<br><a href='../index.jsp'>Tentar novamente</a>";
%>        
<jsp:forward page="inconsistenciaClientes.jsp">
    <jsp:param name="erro" value="<%=erro%>"/>
</jsp:forward> 
<%}else{
            try {
                Mensagens msn = new Mensagens();
                String codigoTemporario = (String) request.getParameter("id").toString();
                String nome = (String) request.getParameter("edtNome").toString();
                String endereco = (String) request.getParameter("edtEndereco").toString();
                String usuario =(String) session.getAttribute("ID_USU_LOGADO").toString();
                RepositorioClientes repCliente = new RepositorioClientesMySQL();
                CadastroClientes cadCliente = new CadastroClientes(repCliente);
                Cliente cliente = new Cliente(Integer.parseInt(codigoTemporario), nome, endereco, Integer.parseInt(usuario));
                String informacao = null;
                if (codigoTemporario.equals("0")){
                    cadCliente.inserir(cliente);
                    informacao = "Cliente <strong>cadastrado</strong> com sucesso.";
                }else{
                    cadCliente.atualizar(cliente);
                    informacao = "Cliente <strong>alterado</strong> com sucesso.";
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
<jsp:forward page="inconsistenciaClientes.jsp">
    <jsp:param name="erro" value="<%=erro%>"/>
</jsp:forward> 
<%

            }
%>
</body>
</html><%}%>