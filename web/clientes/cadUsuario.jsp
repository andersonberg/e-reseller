<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="util.Mensagens,usuario.*,cliente.*,java.util.*" %>
<link rel="stylesheet" type="text/css" href="../estilo/si2009.css"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%
            Mensagens msn = new Mensagens();
            if (session.getAttribute("USU_AUTENTICADO").equals("")) {
                String erro = "Realizar autenticação no sistema.<br><a href='../index.jsp'>Tentar novamente</a>";
%>        
<jsp:forward page="inconsistenciaClientes.jsp">
    <jsp:param name="erro" value="<%=erro%>"/>
</jsp:forward>    
<% }else{
//VARIÁVEL RECUPERADA
String codigoCli = request.getParameter("id").toString();
//DADOS CLIENTE
RepositorioClientes repCliente = new RepositorioClientesMySQL();
CadastroClientes cadCliente = new CadastroClientes(repCliente);
Cliente cliente = cadCliente.procurar(Integer.parseInt(codigoCli));
//DADOS USUARIO
RepositorioUsuarios repUsuario = new RepositorioUsuariosMySQL();
CadastroUsuarios cadUsuario = new CadastroUsuarios(repUsuario);
Usuario usuarioManutencao = null;
try{
    usuarioManutencao = cadUsuario.procurar(Integer.parseInt(codigoCli),2);
}catch(Exception e){
    usuarioManutencao = new Usuario(0,"","","",Integer.parseInt(codigoCli),"A");
}
%>
<script language="javascript">
function validar(){
	for (i=0;i<document.frmCadastrarUsuario.elements.length-1;i++){
		if ((document.frmCadastrarUsuario.elements[i].value == '')&&(document.frmCadastrarUsuario.elements[i].type == 'text')){
			alert('Informar todos os campos obrigatórios.');
			document.frmCadastrarUsuario.elements[i].focus();
			return false;
		}
                if ((document.frmCadastrarUsuario.elements[i].value == '')&&(document.frmCadastrarUsuario.elements[i].type == 'password')){
			alert('Informar todos os campos obrigatórios.');
			document.frmCadastrarUsuario.elements[i].focus();
			return false;
		}
	}
	return true;
}
function setarCombo(objCombo,valorProcurado){
	indice = 0;
	//se for em branco ou nulo, nao entrar no loop.
	if (valorProcurado == '' || valorProcurado == 'null' ) {
		return false;
	}
	while(indice < objCombo.length) {
		if (objCombo.options[indice].value == valorProcurado ) {
			objCombo.options[indice].selected = true ;
			break;
		}
		indice = indice + 1;
	}
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
                        <td align="center" class="titulo_topo">Cadastro de Usuários</td>
                    </tr>
                    <tr><td>
                            <div align="left"></div>
                <br><form name="frmCadastrarUsuario" method="post" action="processaManutencaoUsuario.jsp">
                            <table width="417" border="0" class="btabela_grande">
                                <tr><td width="110">Nome Completo:</td>
                                  <td width="297">
                                  <input type="text" name="edtNome" readonly maxlength="50" value="<%=cliente.getNome_cli()%>"></td>
                                  <input type="hidden" name="id" value="<%=usuarioManutencao.getId_usu()%>">
                                  <input type="hidden" name="idCli" value="<%=codigoCli%>">
                                </tr>
                                                             <tr><td>Login:</td><td> <input type="text" name="edtLogin" maxlength="10" value="<%=usuarioManutencao.getLogin_usu()%>"></td>
                                                             </tr>
                                                             <tr><td>Senha:</td><td> <input type="password" name="edtSenha" maxlength="10" value="<%=usuarioManutencao.getSenha_usu()%>"></td>
                                                             </tr>
                                                             <tr><td>Status:</td><td><select name=status>
                                                               <option value="A">Ativo</option>
                                                               <option value="I">Inativo</option>
                                                             </select>
                                                             <script>setarCombo(document.frmCadastrarUsuario.status,'<%=usuarioManutencao.getStatus_usu()%>')</script>
                                                             </td>
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
