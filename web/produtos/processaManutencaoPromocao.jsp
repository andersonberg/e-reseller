<%@page import="util.Mensagens, promocao.Promocao,fachada.Fachada, produto.exceptions.*" %>
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
                String codigoProduto = (String) request.getParameter("codigoProduto").toString();
                String descricao = (String) request.getParameter("edtNome").toString();
                String desconto = (String) request.getParameter("edtDesconto").toString();
                String usuario =(String) session.getAttribute("ID_USU_LOGADO").toString();
                Promocao promocao = null;
                promocao = new Promocao(0,Integer.parseInt(codigoProduto), descricao,Integer.parseInt(desconto), Integer.parseInt(usuario));
                String informacao = null;
                fachada.inserirPromocao(promocao);
                informacao = "Promoção <strong>cadastrada</strong> com sucesso.";
                
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