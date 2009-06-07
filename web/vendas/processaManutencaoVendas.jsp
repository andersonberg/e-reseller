<%@page import="util.Mensagens, venda.Venda, venda.exceptions.*,estoque.Estoque,estoque.exceptions.*,fachada.Fachada" %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="../estilo/si2009.css"/>
<%
            if (session.getAttribute("USU_AUTENTICADO").equals("")) {
                String erro = "Realizar autenticação no sistema.<br><a href='../index.jsp'>Tentar novamente</a>";
%>        
<jsp:forward page="inconsistenciaVendas.jsp">
    <jsp:param name="erro" value="<%=erro%>"/>
</jsp:forward> 
<%} else {
    try {
        Mensagens msn = new Mensagens();
        Fachada fachada = (Fachada) session.getAttribute("FACHADA");
        String codigoProduto = (String) request.getParameter("codigoProduto").toString();
        String quantidade = (String) request.getParameter("edtQuantidade").toString();
        String valor = (String) request.getParameter("edtValor").toString();
        String prazo = (String) request.getParameter("edtPrazo").toString();
        String cliente = (String) request.getParameter("cmbCliente").toString();

        valor = valor.replace(",", ".");
        String usuario = (String) session.getAttribute("ID_USU_LOGADO").toString();

        //DADOS ESTOQUE
        Estoque estoque = fachada.procurarEstoqueProduto(Integer.parseInt(codigoProduto));

        if (estoque.getQuantidade_est() < Integer.parseInt(quantidade)) {
            String erro = "Estoque não possui quantidade suficiente para realizar venda.<br><a href='index.jsp'>Tentar novamente</a>";
%>
<jsp:forward page="inconsistenciaVendas.jsp">
    <jsp:param name="erro" value="<%=erro%>"/>
</jsp:forward> 
<%
    }
                
    float valorTotal = new Float(valor) * new Float(quantidade);

    Venda venda = new Venda(0, Integer.parseInt(codigoProduto), Integer.parseInt(cliente), Integer.parseInt(quantidade), valorTotal, prazo, Integer.parseInt(usuario));

    String informacao = null;
    fachada.inserirVenda(venda);
    fachada.alterarEstoque(Integer.parseInt(codigoProduto), Integer.parseInt(quantidade), 1);
    informacao = "Venda <strong>registrada</strong> com sucesso.";

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
    String erro = e.getMessage() + ".<br><a href='index.jsp'>Tentar novamente</a>";
%>
<jsp:forward page="inconsistenciaVendas.jsp">
    <jsp:param name="erro" value="<%=erro%>"/>
</jsp:forward> 
<%

    }
%>
</body>
</html><%}%>