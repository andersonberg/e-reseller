<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="util.Mensagens,produto.*,cliente.*,java.util.*" %>
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
//DADOS DE PRODUTO
    RepositorioProdutos repProduto = new RepositorioProdutosMySQL();
    CadastroProdutos cadProduto = new CadastroProdutos(repProduto);
    Collection produtos = cadProduto.procurarProdutos();
    Iterator iProdutos = produtos.iterator();

//DADOS DE CLIENTE
    RepositorioClientes repCliente = new RepositorioClientesMySQL();
    CadastroClientes cadCliente = new CadastroClientes(repCliente);
    Collection clientes = cadCliente.procurarClientes();
    Iterator iClientes = clientes.iterator();

%>
<SCRIPT language=JavaScript>
function maskIt(w,e,m,r,a){        // Cancela se o evento for Backspace   
 if (!e) 
 var e = window.event    
 if (e.keyCode) 
 code = e.keyCode;    
 else if (e.which) 
 code = e.which;        
 // Variáveis da função    
 var txt  = (!r) ? w.value.replace(/[^\d]+/gi,'') : w.value.replace(/[^\d]+/gi,'').reverse();    
 var mask = (!r) ? m : m.reverse();    
 var pre  = (a ) ? a.pre : "";    
 var pos  = (a ) ? a.pos : "";    
 var ret  = "";    
 if(code == 9 || code == 8 || txt.length == mask.replace(/[^#]+/g,'').length) 
 return false;    
 // Loop na máscara para aplicar os caracteres    
 for(var x=0,y=0, z=mask.length;x<z && y<txt.length;){        
 if(mask.charAt(x)!='#'){            
 ret += mask.charAt(x); x++;        
 } else{            
 ret += txt.charAt(y); 
 y++; 
 x++;        
 }    }        
 // Retorno da função    
 ret = (!r) ? ret : ret.reverse()        
 w.value = pre+ret+pos;
 }
 
</SCRIPT>
<html><head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%=msn.getMn_Titulo_Site()%></title>
    </head>
    <body>
        <form name="frmMain" method="post" action="vendas.jsp">">
            <input type="hidden" id="tipo" name="tipo" value="3">
            <center>
                <table>
                    <tr><td width="417" align="left"><br>
                    <br><br><br><br><br><br><br><br><br><a href="../sistema.jsp">Home</a></td></tr>
                    <tr>
                        <td align="center" class="titulo_topo"> Detalhamento de Vendas</td>
                    </tr>
                    
                    <tr>
                        <td align="right"> <font color="#FF0000">* campos Obrigatórios</font></td>
                    </tr>
                    <tr><td><br>
                    Produto<font color="#FF0000">*</font>:<br><select name="id" id="id">
                                <%
    if (!produtos.isEmpty()) {
        while (iProdutos.hasNext()) {
            Produto produto = (Produto) iProdutos.next();
                                %><option value="<%=produto.getId_prod()%>"><%=produto.getDescricao_prod()%></option><%
        }
    }else{%>
	<option value="0">Não Existem produtos Cadastrados</option>
	<%}%>
                    </select></td></tr>
                    <tr>
                      <td><br>Cliente (<em>Opcional</em>):<br>
<select name="cmbCliente" id="id"><option value="0">--- Todos os Cliente ---</option>
                               <% if (!clientes.isEmpty()) {
                                while (iClientes.hasNext()) {
                                Cliente cliente = (Cliente) iClientes.next();
                                %><option value="<%=cliente.getId_cli()%>"><%=cliente.getNome_cli()%></option><%
        }
    } else {%><option value="">Não existem Clientes cadastrados</option><%}%>
                    </select></td></tr>
                    <tr>
                      <td><br>Período<font color="#FF0000">*</font>: (<em>formato dd/mm/aaaa</em>)<br>
                  <input type="text" name="dtInicial" maxlength="10" size="20" onkeyup="maskIt(this,event,'##/##/####')" > a <input type="text" name="dtFinal" maxlength="10" size="20" onkeyup="maskIt(this,event,'##/##/####')" ></td></tr>
                    
                    <tr><td align="center"><div align="center"><br><br><input type="button" value="Voltar" onClick="javascript:location.href='index.jsp'">&nbsp;&nbsp;&nbsp;<input type="submit" value="Consultar" ><br>
                            <br>
                            <br>
                            
                            <br>
                    <br></td></tr>
                    <tr><td align="center"><%=msn.getMn_Rodape_Site()%></td></tr>
                </table>
        </center> </form>   
    </body>
</html>
<%}%>