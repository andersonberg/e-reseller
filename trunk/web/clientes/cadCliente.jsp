<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="util.Mensagens,cliente.Cliente, fachada.Fachada,java.util.*" %>
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
<% }else{
String codigoCliente = request.getParameter("id").toString();
Fachada fachada = (Fachada) session.getAttribute("FACHADA");
Cliente clienteManutencao = null;
try{
if (codigoCliente.equals("0")){
    clienteManutencao = new Cliente(0, "","", 0);
}else{
    clienteManutencao = fachada.procurarCliente(Integer.parseInt(codigoCliente));
}}catch(Exception e){
    
}
%>
<script language="javascript">
function validar(){
	for (i=0;i<document.frmCadastrarCliente.elements.length-1;i++){
		if ((document.frmCadastrarCliente.elements[i].value == '')&&(document.frmCadastrarCliente.elements[i].type == 'text')){
			alert('Informar todos os campos obrigatórios.');
			document.frmCadastrarCliente.elements[i].focus();
			return false;
		}
                if ((document.frmCadastrarCliente.elements[i].value == '')&&(document.frmCadastrarCliente.elements[i].type == 'password')){
			alert('Informar todos os campos obrigatórios.');
			document.frmCadastrarCliente.elements[i].focus();
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
                        <td align="center" class="titulo_topo">Cadastro de Clientes</td>
                    </tr>
                    <tr> <td>
                            <div align="left"></div>
                <br><form name="frmCadastrarCliente" method="post" action="processaManutencaoCliente.jsp">
                            <table width="417" border="0" class="btabela_grande">
                                <tr><td width="110">Nome:</td>
                                  <td width="297">
                                  <input name="edtNome" type="text"  value="<%=clienteManutencao.getNome_cli()%>" size="50" maxlength="150"></td>
                                  <input type="hidden" name="id" value="<%=clienteManutencao.getId_cli()%>">
                                </tr
                                <tr><td width="110">Endereço:</td>
                                  <td width="297">
                                  <input name="edtEndereco" type="text"  value="<%=clienteManutencao.getEndereco_cli()%>" size="50" maxlength="150"></td>
                                  
                                </tr>
                                                             </tr>
                                                             <tr><td colspan="2">&nbsp;</td>
                                                             </tr>
                                                             <tr><td></td><td><input type="submit" name="confirmarInclusao" value="Confirmar" onClick="return validar();">&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" name="cancelar" value="Cancelar" onClick="javascript:location.href='index.jsp'"></td>
                                                             </tr>
                           </table></form> 
                      <br><br><br>
                    </td></tr>
                    <tr><td align="center"><%=msn.getMn_Rodape_Site()%></td></tr>
                </table>
        </center>   
    </body>
</html><%}%>
