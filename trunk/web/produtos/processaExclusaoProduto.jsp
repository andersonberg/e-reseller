<%@page import="util.Mensagens, produto.Produto, estoque.Estoque,estoque.exceptions.*,promocao.exceptions.*,venda.exceptions.*, venda.Venda,promocao.Promocao,fachada.Fachada" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="../estilo/si2009.css"/>
<%
            if (session.getAttribute("USU_AUTENTICADO").equals("")) {
                String erro = "Realizar autenticação no sistema.<br><a href='index.jsp'>Tentar novamente</a>";
%>        
<jsp:forward page="inconsistenciaProdutos.jsp">
    <jsp:param name="erro" value="<%=erro%>"/>
</jsp:forward> 
<%} else {
    try {
        Mensagens msn = new Mensagens();
        String codigoProduto = request.getParameter("id").toString();
        Fachada fachada = (Fachada) session.getAttribute("FACHADA");
        //DADOS DE VENDA
        try {
            fachada.procurarVenda(Integer.parseInt(codigoProduto), 1);
            String erro = "Não é possível excluir produto. Registro de Venda Localizado.<br><a href='index.jsp'>Tentar novamente</a>";
%>
<jsp:forward page="inconsistenciaProdutos.jsp">
    <jsp:param name="erro" value="<%=erro%>"/>
</jsp:forward> 
<%

    } catch (VendaInexistenteException e) {
        //Não localizado PRODUTO permite a exclusão
        }

//DADOS DE PRODUTO
    Produto produto = fachada.procurarProduto(Integer.parseInt(codigoProduto));

//DADOS DE ESTOQUE
    try {
        fachada.removerEstoque(produto.getId_prod());
    } catch (EstoqueInexistenteException e) {
        //Não localizado estoque de produto para exclusão
    }

//DADOS DE PROMOCAO
    Promocao promocao = new Promocao(produto.getId_prod());
    try {
        fachada.removerPromocao(promocao);
    } catch (PromocaoInexistenteException e) {
        //Não localizado promocao de produto para exclusão
    }
    fachada.removerProduto(produto);

%>
<html>
<head>
</head>
<body>
<center>
<table>
<tr><td colspan="3"><br><br><br><br><br><br><br><br><br><br></td><br><br><br><br><br><br><br><br><br><br></td></tr>
<tr><td colspan="3" class="titulo_topo"><div align="center">Produto excluído com sucesso.<br>
<a href="">Voltar</a></div></td></tr>
<tr><td colspan="3"><br><br><br><br><br><br><br><br><br><br></td></tr>
<tr><td align="center" colspan="3"><%=msn.getMn_Rodape_Site()%></td>
</tr>
</table>
</center>

<%
} catch (Exception e) {
    String erro = "Erro Localizado ao processar dados (" + e.getMessage() + ").<br><a href='index.jsp'>Tentar novamente</a>";
%>
<jsp:forward page="inconsistenciaProdutos.jsp">
    <jsp:param name="erro" value="<%=erro%>"/>
</jsp:forward> 
<%

    }
%>
</body>
</html><%}%>