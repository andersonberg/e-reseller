<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="util.Mensagens,produto.*,venda.*,cliente.*,java.util.*,java.text.SimpleDateFormat,java.text.DecimalFormat" %>
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
    String codigo = request.getParameter("id").toString();
    String relatorio = request.getParameter("tipo").toString();
    String dtInicial="";
    String dtFinal="";
    String cli="";
    if (relatorio.equals("3")) {
        dtInicial = request.getParameter("dtInicial").toString();
        dtFinal = request.getParameter("dtFinal").toString();
        cli = request.getParameter("cmbCliente").toString();
    }
    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    DecimalFormat vf = new DecimalFormat("0.00");
//DADOS DE VENDA
    RepositorioVendas repVenda = new RepositorioVendasMySQL();
    CadastroVendas cadVenda = new CadastroVendas(repVenda);
    Collection vendas = null;
    if (relatorio.equals("3")) {
        vendas = cadVenda.procurarVendas(Integer.parseInt(codigo), Integer.parseInt(cli), dtInicial, dtFinal);
    } else {
        vendas = cadVenda.procurarVendas(Integer.parseInt(codigo), Integer.parseInt(relatorio));
    }
    Iterator iVendas = vendas.iterator();

//DADOS DE Produto
    RepositorioProdutos repProduto = new RepositorioProdutosMySQL();
    CadastroProdutos cadProduto = new CadastroProdutos(repProduto);
    Produto produto = null;
//DADOS DE CLIENTES
    RepositorioClientes repCliente = new RepositorioClientesMySQL();
    CadastroClientes cadCliente = new CadastroClientes(repCliente);
    Cliente cliente = null;

%>
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
                        <td align="center" class="titulo_topo">Vendas Registradas</td>
                    </tr>
                    <br><tr><td>
                        <table width="834" align="center" class="btabela_relatorio">
                            <tr>
                                <td width="261" height="16" class="btabela_relatorio" ><div align="left">Produto</div></td>
                                <td class="btabela_relatorio"><div align="left">Cliente</div></td>
                                <td class="btabela_relatorio"><div align="center">Quantidade</div></td>
                                <td class="btabela_relatorio"><div align="center">Valor</div></td>
                                <td class="btabela_relatorio"><div align="center">Prazo</div></td>
                                <td class="btabela_relatorio"><div align="center">Data</div></td>
                            </tr>
                            <%
    if (!vendas.isEmpty()) {
        float valorTotal = 0;
        int qtdTotal = 0;
        while (iVendas.hasNext()) {
            Venda venda = (Venda) iVendas.next();

                            %>
                            <tr>
                                <td ><div align="left"><%produto = cadProduto.procurar(venda.getId_prod());%><%=produto.getDescricao_prod()%></div></td>
                                <td><div align="left"><%cliente = cadCliente.procurar(venda.getId_cli());%><%=cliente.getNome_cli()%></div></td>
                                <td><div align="center"><%=venda.getQtd_ven()%></div></td>
                                <td><div align="center">R$ <%=vf.format(venda.getValor_ven())%></div></td>
                                <td><div align="center"><%=venda.getPrazo_ven()%></div></td>
                                <td><div align="center"><%=df.format(venda.getDthr_atualizacao())%></div></td>
                            </tr>
                            
                            <%valorTotal = valorTotal+venda.getValor_ven();
                                qtdTotal = qtdTotal+ venda.getQtd_ven();
                                }
                            %>
                            <tr><td colspan="6" class="titulo"><BR>Valor Total: R$ <strong><%=vf.format(valorTotal)%><br>Quantidade de Produtos vendidos: <strong><%=qtdTotal%></strong></td></tr>
                            <%
                            } else {
                            %>
                            <tr>
                                <td colspan="6" align="center" class="titulo">Não existem dados de Vendas Registrados.</td>
                            </tr>                
                            
                            <%            }
                            %>
                    </table></tr></td>
                    <tr><td><div align="center"><br><br><input type="button" value="Voltar" onClick="javascript:history.go(-1)">&nbsp;&nbsp;&nbsp;<input type="button" value="Imprimir" onClick="javascript:window.print()"><br>
                            <br>
                            <br>
                            
                            <br>
                            <br>
                    </div></tr></td>
                    <tr><td align="center"><%=msn.getMn_Rodape_Site()%></td></tr>
                </table>
        </center> </form>   
    </body>
</html>
<%}%>