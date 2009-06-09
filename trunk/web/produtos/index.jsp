<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="util.Mensagens,produto.*,estoque.*,java.util.*,java.text.DecimalFormat" %>
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
%>

<SCRIPT language=JavaScript>

    function Redirecionar(url){
        document.frmMain.action= url;
        document.frmMain.submit();
    }
    function Redirecionar_Exclusao(url){
        if (confirm('Deseja realmente excluir este produto e todo seu histórico?')) {
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
                        <td align="center" class="titulo_topo">Manutenção de Produtos</td>
                    </tr>
                    <tr><td colspan="5">
                            <div align="left">
                                <input type="image" src="../img/staticexport.png" name="btnNovo" value="Novo" onClick="Redirecionar('cadProduto.jsp?id=0')">
                            </div>
                            <br>
                            <table width="698" border="0" class="btabela_grande">
<tr>
                                    <th width="261"  scope="col"><div align="left" class="titulo_topo">Descrição</div></th>
                            <th width="46" scope="col"><div align="center" class="titulo_topo">Editar</div></th>
                            <th width="52"  scope="col"><div align="center" class="titulo_topo">Excluir</div></th>
                            <th width="78"  scope="col"><div align="center" class="titulo_topo">Promoção</div></th>
                            <th width="239" scope="col"><div align="center" class="titulo_topo">Valor do Produto</div></th>
                                                        <th width="239" scope="col"><div align="center" class="titulo_topo">Em Estoque</div></th>
                              </tr>
                                <%
    if (!produtos.isEmpty()) {
        while (iProdutos.hasNext()) {
            Produto produto = (Produto) iProdutos.next();

                                %>
                                <tr>
                                    <td class="titulo"><%=produto.getDescricao_prod()%></td>
                                    <td><div align="center">
                                            <input type="image" src="../img/restore.png" name="btnEditar" value="Editar" onClick="Redirecionar('cadProduto.jsp?id=<%=produto.getId_prod()%>')">
                                    </div></td>
                                    <td>
                                        <div align="center">
                                            <input type="image" src="../img/removed.png" name="btnExcluir" value="Excluir" onClick="Redirecionar_Exclusao('processaExclusaoProduto.jsp?id=<%= produto.getId_prod()%>')">
                                    </div></td>
                                    <td>
                                        <div align="center">
                                            <input type="image" src="../img/added.png" name="btnGerar" value="Gerar" onClick="Redirecionar('cadPromocao.jsp?id=<%= produto.getId_prod()%>')">&nbsp;<input type="image" src="../img/preview.png" name="btnListar" value="Listar" onClick="Redirecionar('listarPromocao.jsp?id=<%= produto.getId_prod()%>')">
                                    </div></td>
                                    <td>
                                        <div align="center">
                                            <strong><%
                                            try{    
                                            estoque = cadEstoque.procurar(produto.getId_prod());
                                            String valorFormatado = vf.format(estoque.getValor_prod_est());
                                            %><a href="javascript:Redirecionar('cadEstoque.jsp?id=<%= estoque.getId_prod()%>')">R$ <%= valorFormatado%></a><%
                                            }catch(Exception e){%>
                                            (0)<%    
                                            }
                                            %>
                                            </strong>
                                    </div></td>
                                    <td>
                                        <div align="center">
                                            <strong><%
                                            try{    
                                            estoque = cadEstoque.procurar(produto.getId_prod());
                                            %><a href="javascript:Redirecionar('cadEstoque.jsp?id=<%= estoque.getId_prod()%>')"> <%= estoque.getQuantidade_est()%></a><%
                                            }catch(Exception e){%>
                                            (0)<%    
                                            }
                                            %>
                                            </strong>
                                    </div></td>
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