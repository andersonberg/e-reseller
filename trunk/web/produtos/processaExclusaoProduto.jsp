<%@page import="util.Mensagens, produto.*, estoque.*,estoque.exceptions.*,promocao.exceptions.*,venda.exceptions.*, venda.*,promocao.*" %>
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

        //DADOS DE VENDA
        RepositorioVendas repVenda = new RepositorioVendasMySQL();
        CadastroVendas cadVenda = new CadastroVendas(repVenda);
        try {
            cadVenda.procurar(Integer.parseInt(codigoProduto), 1);
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
    RepositorioProdutos repProduto = new RepositorioProdutosMySQL();
    CadastroProdutos cadProduto = new CadastroProdutos(repProduto);
    Produto produto = cadProduto.procurar(Integer.parseInt(codigoProduto));

//DADOS DE ESTOQUE
    RepositorioEstoques repEstoque = new RepositorioEstoquesMySQL();
    CadastroEstoques cadEstoque = new CadastroEstoques(repEstoque);
    try {
        cadEstoque.remover(produto.getId_prod());
    } catch (EstoqueInexistenteException e) {
        //Não localizado estoque de produto para exclusão
    }

//DADOS DE PROMOCAO
    RepositorioPromocoes repPromocao = new RepositorioPromocoesMySQL();
    CadastroPromocoes cadPromocao = new CadastroPromocoes(repPromocao);
    Promocao promocao = new Promocao(produto.getId_prod());
    try {
        cadPromocao.remover(promocao);
    } catch (PromocaoInexistenteException e) {
        //Não localizado promocao de produto para exclusão
    }
    cadProduto.remover(produto);

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