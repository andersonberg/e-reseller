<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="util.Mensagens,produto.*,java.util.*" %>
<link rel="stylesheet" type="text/css" href="../estilo/si2009.css"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%
            Mensagens msn = new Mensagens();
            if (session.getAttribute("USU_AUTENTICADO").equals(null)) {
                String erro = "Realizar autenticação no sistema.<br><a href='../index.jsp'>Tentar novamente</a>";
%>        
<jsp:forward page="inconsistenciaProdutos.jsp">
    <jsp:param name="erro" value="<%=erro%>"/>
</jsp:forward>    
<% }else{
String codigoProd = request.getParameter("id").toString();
//DADOS DE PRODUTO
RepositorioProdutos repProd = new RepositorioProdutosMySQL();
CadastroProdutos cadProd = new CadastroProdutos(repProd);
Produto produtoManutencao = null;
try{
if (codigoProd.equals("0")){
    produtoManutencao = new Produto(0, "","","","","", 0);
}else{
    produtoManutencao = cadProd.procurar(Integer.parseInt(codigoProd));
}}catch(Exception e){
    
}
%>
<script language="javascript">
function validar(){
	for (i=0;i<document.frmCadastrarProduto.elements.length-1;i++){
		if ((document.frmCadastrarProduto.elements[i].value == '')&&(document.frmCadastrarProduto.elements[i].type == 'text')){
			alert('Informar todos os campos obrigatórios.');
			document.frmCadastrarProduto.elements[i].focus();
			return false;
		}
                if ((document.frmCadastrarProduto.elements[i].value == '')&&(document.frmCadastrarProduto.elements[i].type == 'password')){
			alert('Informar todos os campos obrigatórios.');
			document.frmCadastrarProduto.elements[i].focus();
			return false;
		}
	}
	return true;
}

</script>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%=msn.getMn_Titulo_Site()%></title>
    </head>
    <body>
              <center>
                <table>
                    <tr><td width="417" align="left"><br>
                    <br><br><br><br><br><br><br><br><br><a href="../sistema.jsp">Home</a></td></tr>
                    <tr>
                        <td align="center" class="titulo_topo">Cadastro de Produtos</td>
                    </tr><tr></tr>
                    <td>
                            <div align="left"></div>
                <br><form name="frmCadastrarProduto" method="post" action="processaManutencaoProduto.jsp">
                            <table width="417" border="0" class="btabela_grande">
                                <tr><td width="110">Descrição:</td>
                                  <td width="297">
                                  <input name="edtNome" type="text"  value="<%=produtoManutencao.getDescricao_prod()%>" size="50" maxlength="150"><input type="hidden" name="id" value="<%=produtoManutencao.getId_prod()%>"></td>
                                </tr>
                                <tr><td width="110">Características:</td>
                                  <td width="297">
                                  <input name="edtCaracteristicas" type="text"  value="<%=produtoManutencao.getCaracteristicas_prod()%>" size="50" maxlength="150"></td>
                                </tr>
                                <tr>
                                  <td width="110">Dimensão:</td>
                                  <td width="297">
                                  <input name="edtDimensao" type="text"  value="<%=produtoManutencao.getDimensao_prod()%>" size="25" maxlength="20"></td>
                                </tr>
                                <tr>
                                  <td width="110">Peso:</td>
                                  <td width="297">
                                  <input name="edtPeso" type="text"  value="<%=produtoManutencao.getPeso_prod()%>" size="10" maxlength="15"></td>
                                </tr>
                                <tr>
                                  <td width="110">Especificação:</td>
                                  <td width="297">
                                  <input name="edtEspec" type="text"  value="<%=produtoManutencao.getEspec_tecnicas_prod()%>" size="50" maxlength="150"></td>
                              </tr>
                              <% if (codigoProd.equals("0")){%>
                              <tr>
                                  <td width="110">Estoque Inicial:</td>
                                  <td width="297">
                                  <input name="edtEstoque" type="text"  value="" size="10" maxlength="10"></td>
                              </tr>
                              <tr>
                                  <td width="110">Valor <strong>(R$)</strong>:</td>
                                  <td width="297">
                                  <input name="edtValor" type="text"  value="" size="15" maxlength="10"> <i>Formato: 120.00</i></td>
                              </tr>
                              
                              <%}%>
                                                             
                                                             <tr><td colspan="2">&nbsp;</td>
                                                             </tr>
                              <tr><td colspan="2" align="center"><input type="submit" name="confirmarInclusao" value="Confirmar" onClick="return validar();">&nbsp;&nbsp;&nbsp;&nbsp;                                                               <input type="button" name="cancelar" value="Cancelar" onClick="javascript:location.href='index.jsp'"></td>                                                             
                           </table>
                </form> 
                      <br><br><br>
                    </td></tr>
                    <tr><td align="center"><%=msn.getMn_Rodape_Site()%></td></tr>
                </table>
        </center>   
    </body>
</html><%}%>
