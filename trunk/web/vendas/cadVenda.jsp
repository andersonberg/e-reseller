<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="util.Mensagens,estoque.Estoque,fachada.Fachada,produto.Produto,cliente.Cliente,java.util.*" %>
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
<% } else {
    String codigoProduto = request.getParameter("id").toString();
    String valor = request.getParameter("edtValor" + codigoProduto).toString();
    Fachada fachada = (Fachada) session.getAttribute("FACHADA");
//DADOS PRODUTO
    Produto produto = fachada.procurarProduto(Integer.parseInt(codigoProduto));

//DADOS DE CLIENTE
    Collection clientes = fachada.procurarClientes();
    Iterator iClientes = clientes.iterator();

%>
<script language="javascript">
    function validar(){
        for (i=0;i<document.frmCadastrarVenda.elements.length-1;i++){
            if ((document.frmCadastrarVenda.elements[i].value == '')&&(document.frmCadastrarVenda.elements[i].type == 'text')){
                alert('Informar todos os campos obrigatórios.');
                document.frmCadastrarVenda.elements[i].focus();
                return false;
            }
        }
        return true;
    }

    function Redirecionar(url){
        document.frmCadastrarVenda.action= url;
        document.frmCadastrarVenda.submit();
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
        <td align="center" class="titulo_topo">Rotina de Venda</td>
    </tr>
    <tr>
        <td align="center" class="titulo_topo">&nbsp;</td>
    </tr>
    <td>
        <form name="frmCadastrarVenda" method="post" action="processaManutencaoVendas.jsp">
            <table width="417" border="0" class="tabela_grande">
                <tr><td  align="center" colspan="2">&nbsp;</td>
                </tr>
                <tr><td width="129">Produto:</td>
                    <td width="278">
                    <input name="edtProduto" readonly type="text"  value="<%=produto.getDescricao_prod()%>" size="40" maxlength="150">                                                                    </td>
                </tr>
                <tr>
                    <td>Valor Unitário (R$):</td>
                    <td><input name="edtValor" readonly type="text" value="<%=valor%>"></td>
                </tr>
                <tr>
                    <td>Cliente:</td>
                    <td><select name="cmbCliente" id="id">
                            <% if (!clientes.isEmpty()) {
        while (iClientes.hasNext()) {
            Cliente cliente = (Cliente) iClientes.next();
                            %><option value="<%=cliente.getId_cli()%>"><%=cliente.getNome_cli()%></option><%
     }
 } else {%><option value="">Não existem Clientes cadastrados</option><%}%>
                    </select></td>
                </tr>
                <tr><td width="129">Quantidade:</td>
                    <td width="278">
                        <input type="hidden" name="codigoProduto" value="<%=codigoProduto%>">
                    <input name="edtQuantidade" type="text"  value="" size="10" maxlength="3"></td>
                </tr>
                <tr><td width="129">Prazo:</td>
                    <td width="278">
                    <input name="edtPrazo" type="text" readonly value="10 a 15 Dias úteis" size="30" maxlength="25"></td>
                </tr>
                
                <tr><td colspan="2">&nbsp;</td>
                </tr>
                <tr><td colspan="2" align="center"><input type="submit" name="confirmarInclusao" value="Confirmar" onClick="return validar();">&nbsp;&nbsp;&nbsp;&nbsp;                                                               <input type="button" name="cancelar" value="Cancelar" onClick="javascript:location.href='index.jsp'"></td>
                </tr>
            </table>
        </form> 
        <br><br><br>
    </td></tr>
    <tr><td align="center"><%=msn.getMn_Rodape_Site()%></td></tr>
</table>
</center>   
</body>
</html><%}%>
