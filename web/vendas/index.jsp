<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="util.Mensagens,produto.*,estoque.*,promocao.*,promocao.exceptions.*,java.util.*,java.text.DecimalFormat" %>
<link rel="stylesheet" type="text/css" href="../estilo/si2009.css"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%
            Mensagens msn = new Mensagens();
            if (session.getAttribute("USU_AUTENTICADO").equals("")) {
                String erro = "Realizar autenticação no sistema.<br><a href='../index.jsp'>Tentar novamente</a>";
%>        
<jsp:forward page="inconsistenciaProdutos.jsp">
    <jsp:param name="erro" value="<%=erro%>"/>
</jsp:forward>    
<% } else {
DecimalFormat vf = new DecimalFormat("0.00"); 
//DADOS DE PRODUTO
    RepositorioProdutos repProduto = new RepositorioProdutosMySQL();
    CadastroProdutos cadProduto = new CadastroProdutos(repProduto);
    Collection produtos = cadProduto.procurarProdutos();
    Iterator iProdutos = produtos.iterator();

//DADOS DE ESTOQUE
    RepositorioEstoques repEstoque = new RepositorioEstoquesMySQL();
    CadastroEstoques cadEstoque = new CadastroEstoques(repEstoque);
    Estoque estoque = null;
    
//DADOS DE PROMOÇÃO
    RepositorioPromocoes repPromocao = new RepositorioPromocoesMySQL();
    CadastroPromocoes cadPromocao = new CadastroPromocoes(repPromocao);
    Promocao promocao = null;    
    
%>

<SCRIPT language=JavaScript>

    function Redirecionar(url){
        document.frmMain.action= url;
        document.frmMain.submit();
    }
</SCRIPT>

<html>
    <style type="text/css">
<!--
.style1 {
	color: #FF0000;
	font-weight: bold;
}
-->
    </style>
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
                        <td align="center" class="titulo_topo">Registrar Venda</td>
                    </tr>
                    <tr><td colspan="5">
                            <br>
                            <table width="698" border="0" class="btabela_grande">
<tr>
                                    <th width="261"  scope="col"><div align="left" class="titulo_topo">Produto</div></th>
                                    <th width="44" scope="col"  colspan="3" class="titulo_topo">Preço</th>
              <th width="84" scope="col" class="titulo_topo">&nbsp;</th>
              <th width="139" scope="col" class="titulo_topo">Vender</th>
</tr>
                                <%
    if (!produtos.isEmpty()) {
        while (iProdutos.hasNext()) {
            Produto produto = (Produto) iProdutos.next();
            estoque = cadEstoque.procurar(produto.getId_prod());
            try{
            promocao = cadPromocao.procurar(produto.getId_prod());
            }catch(PromocaoInexistenteException e){
                promocao = null;
                e.getStackTrace();
                
            }
            String valorFormatado = "";
                               %>
                                <tr>
                                    <td class="titulo"><%=produto.getDescricao_prod()%></td>
                                    <% if(promocao==null){%>
                                  <td colspan="3">R$ <%=vf.format(estoque.getValor_prod_est())%>
                                  <input type="hidden" name="edtValor<%=produto.getId_prod()%>" value="<%=estoque.getValor_prod_est()%>"></td>
                                    <%}else{%>
                                    <td  colspan="3"><span class="style1">DE:</span> R$ <%=vf.format(estoque.getValor_prod_est())%> <span class="style1">POR:</span> R$ <%valorFormatado = vf.format(estoque.getValor_prod_est()-estoque.getValor_prod_est()*(new Float(promocao.getDesconto_pro())/new Float(100)));
                                    %><%=valorFormatado%>
                                    
                                  <input type="hidden" name="edtValor<%=produto.getId_prod()%>" value="<%=valorFormatado%>"></td>
                                    <%}%>
   
                                  <td>&nbsp;</td>
                                  <td><div align="center">
                                    <%if (estoque.getQuantidade_est()>0){%>
                                    <input type="button" name="Enviar" value="Vender Produto" onClick="Redirecionar('cadVenda.jsp?id=<%= produto.getId_prod()%>')">
                                  </div></td>
                                      <%}else{%>Produto Indísponivel<%}%>
                                  </tr>
                                
                                <%
                                    }
                                } else {
                                %>
                                <tr><td colspan="6" align="center" class="titulo">Não existem dados de Produtos cadastrado.</td></tr>                
                                
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