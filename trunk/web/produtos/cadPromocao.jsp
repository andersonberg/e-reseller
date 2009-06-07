<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="util.Mensagens,produto.Produto,fachada.Fachada,java.util.*" %>
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
    Fachada fachada = (Fachada) session.getAttribute("FACHADA");
    String codigoProduto = request.getParameter("id").toString();
    Produto produto = fachada.procurarProduto(Integer.parseInt(codigoProduto));

%>
<script language="javascript">
    function validar(){
        for (i=0;i<document.frmCadastrarPromocao.elements.length-1;i++){
            if ((document.frmCadastrarPromocao.elements[i].value == '')&&(document.frmCadastrarPromocao.elements[i].type == 'text')){
                alert('Informar todos os campos obrigatórios.');
                document.frmCadastrarPromocao.elements[i].focus();
                return false;
            }
        }
        return true;
    }

    function Redirecionar(url){
        document.frmCadastrarPromocao.action= url;
        document.frmCadastrarPromocao.submit();
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
        <td align="center" class="titulo_topo">Cadastro de Promoção</td>
    </tr>
    <tr>
        <td align="center" class="titulo_topo">&nbsp;</td>
    </tr>
    <td>
        <form name="frmCadastrarPromocao" method="post" action="processaManutencaoPromocao.jsp">
            <table width="417" border="0" class="tabela_grande">
                <tr><td  align="center" colspan="2">&nbsp;</td>
                </tr>
                <tr><td width="110">Produto:</td>
                    <td width="297">
                    <input name="edtProduto" readonly type="text"  value="<%=produto.getDescricao_prod()%>" size="50" maxlength="150"></td>
                </tr>
                <tr><td width="110">Descrição:</td>
                    <td width="297">
                        <input type="hidden" name="codigoProduto" value="<%=codigoProduto%>">
                    <input name="edtNome" type="text"  value="" size="50" maxlength="150"></td>
                </tr>
                <tr><td width="110">Desconto <strong>(%)</strong>:</td>
                    <td width="297">
                    <input name="edtDesconto" type="text"  value="" size="5" maxlength="3"></td>
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
