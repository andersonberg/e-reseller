<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="util.Mensagens,produto.Produto,estoque.Estoque,fachada.Fachada,java.util.*,java.text.DecimalFormat" %>
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
DecimalFormat vf = new DecimalFormat("0.00");
Fachada fachada = (Fachada) session.getAttribute("FACHADA");
//DADOS DE PRODUTO
    Collection produtos = fachada.procurarProdutos();
    Iterator iProdutos = produtos.iterator();

//DADOS DE ESTOQUE
    Estoque estoque = null;
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
            <input type="hidden" id="tipo" name="tipo" value="1">
            <center>
                <table>
                    <tr><td width="417" align="left"><br>
                    <br><br><br><br><br><br><br><br><br><a href="../sistema.jsp">Home</a></td></tr>
                    <tr>
                        <td align="center" class="titulo_topo"> Produtos Cadastrados</td>
                  </tr>
                    <tr><td colspan="5">
          <br>
                            <table width="834" border="0" align="center" class="btabela_relatorio">
<tr>
                                    <th width="261" height="34"  scope="col" class="btabela_relatorio"><div align="left">Descrição</div></th>
              <th width="2" scope="col" class="btabela_relatorio"><div align="center">Características</div></th>
                            <th width="2"  scope="col" class="btabela_relatorio"><div align="center">Dimensão</div></th>
                            <th width="78"  scope="col" class="btabela_relatorio"><div align="center">Peso</div></th>
                            <th width="231" scope="col" class="btabela_relatorio"><div align="center">Valor do Produto</div></th>
                                                        <th width="234" scope="col" class="btabela_relatorio"><div align="center">Disponível</div></th>
                              </tr>
                                <%
    if (!produtos.isEmpty()) {
        while (iProdutos.hasNext()) {
            Produto produto = (Produto) iProdutos.next();

                                %>
                                <tr>
                                    <td class="titulo"><a href="javascript:Redirecionar('vendas.jsp?id=<%=produto.getId_prod()%>')"><%=produto.getDescricao_prod()%></a></td>
                                    <td><div align="center"><%=produto.getCaracteristicas_prod()%></div></td>
                                    <td><div align="center"><%=produto.getDimensao_prod()%></div></td>
                                    <td><div align="center"><%=produto.getPeso_prod()%>
                                    </div></td>
                                    <td>                                      
                                      <div align="center">
                                      <%
                                            try{    
                                            estoque = fachada.procurarEstoqueProduto(produto.getId_prod());
                                            String valorFormatado = vf.format(estoque.getValor_prod_est());
                                            %>
                                      R$ <%=valorFormatado%>
                                      <%
                                            }catch(Exception e){%>
                                      (0)
                                      <%    
                                            }
                                            %>
                                  </div></td>
                      <td>
                                        <div align="center">
                                            <strong><%
                                            try{    
                                            estoque = fachada.procurarEstoqueProduto(produto.getId_prod());
                                            %><%= estoque.getQuantidade_est()%><%
                                            }catch(Exception e){%>
                                            (0)<%    
                                            }
                                            %>
                                    </strong>                                    </div></td>
                                </tr>
                                
                                <%
                                    }%>
                                    <tr><td colspan="6" class="titulo"><br><i>Clique no nome do produto para visualizar suas vendas.</i></td></tr>
                                    <%
                                } else {
                                %>
                                <tr><td colspan="6" align="center" class="titulo">Não existem dados de Produtos cadastrado.</td></tr>                
                                
                                <%            }
                                %>
                            </table>
                      <div align="center"><br><br><input type="button" value="Voltar" onClick="javascript:location.href='index.jsp'">&nbsp;&nbsp;&nbsp;<input type="button" value="Imprimir" onClick="javascript:window.print()"><br>
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