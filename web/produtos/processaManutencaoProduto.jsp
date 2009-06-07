<%@page import="util.Mensagens, produto.Produto, estoque.Estoque,fachada.Fachada, produto.exceptions.*" %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="../estilo/si2009.css"/>
<%
            if (session.getAttribute("USU_AUTENTICADO").equals("")) {
                String erro = "Realizar autenticação no sistema.<br><a href='../index.jsp'>Tentar novamente</a>";
%>        
<jsp:forward page="inconsistenciaProdutos.jsp">
    <jsp:param name="erro" value="<%=erro%>"/>
</jsp:forward> 
<%}else{
            try {
                Mensagens msn = new Mensagens();
                Fachada fachada = (Fachada) session.getAttribute("FACHADA");
                String codigoTemporario = (String) request.getParameter("id").toString();
                String descricao = (String) request.getParameter("edtNome").toString();
                String caracteristicas = (String) request.getParameter("edtCaracteristicas").toString();
                String dimensao = (String) request.getParameter("edtDimensao").toString();
                String peso = (String) request.getParameter("edtPeso").toString();
                String especificacao = (String) request.getParameter("edtEspec").toString();
                String usuario =(String) session.getAttribute("ID_USU_LOGADO").toString();
                Produto produto = new Produto(Integer.parseInt(codigoTemporario),descricao,caracteristicas,dimensao,peso,especificacao,Integer.parseInt(usuario));
                String informacao = null;
                if (codigoTemporario.equals("0")){
                    String quantidade = (String) request.getParameter("edtEstoque").toString();
                    String valor = (String) request.getParameter("edtValor").toString();
                    valor = valor.replace(",", ".");
                    //INSERINDO PRODUTO
                    int codigoInserido = fachada.inserirProduto(produto);
                    informacao = "Produto <strong>cadastrado</strong> com sucesso.";
                    //INSERINDO PRODUTO NO ESTOQUE
                    Estoque estoque = new Estoque(codigoInserido,Integer.parseInt(quantidade),Float.parseFloat(valor),Integer.parseInt(usuario));

                    fachada.inserirEstoque(estoque);
                }else{
                    fachada.atualizarProduto(produto);
                    informacao = "Produto <strong>alterado</strong> com sucesso.";
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
<jsp:forward page="inconsistenciaProdutos.jsp">
    <jsp:param name="erro" value="<%=erro%>"/>
</jsp:forward> 
<%

            }
%>
</body>
</html><%}%>