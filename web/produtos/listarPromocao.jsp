<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="util.Mensagens,promocao.Promocao,produto.Produto,fachada.Fachada,java.util.*" %>
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

            String codigoProduto = request.getParameter("id").toString();
            Fachada fachada = (Fachada) session.getAttribute("FACHADA");
            Promocao promocao = new Promocao(Integer.parseInt(codigoProduto));
            Collection promocoes = fachada.procurarPromocoes(promocao);
            Iterator iPromocoes = promocoes.iterator();

            Produto produto = fachada.procurarProduto(Integer.parseInt(codigoProduto));
%>

<SCRIPT language=JavaScript>

    function Redirecionar(url){
        document.frmMain.action= url;
        document.frmMain.submit();
    }
    function Redirecionar_Exclusao(url){
        if (confirm('Deseja realmente excluir esta Promoção?')) {
            document.frmMain.action= url;
            document.frmMain.submit();
        }
    }
</SCRIPT>

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
                        <td align="center" class="titulo_topo">Listagem de Promoções</td>
                    </tr>
                    <tr>
                        <td align="center" class="titulo_topo">&nbsp;</td>
                    </tr>
<tr>
                        <td align="center" class="titulo_topo">&nbsp;</td>
                    </tr>
                    <tr><td>Produto:<strong><%=produto.getDescricao_prod()%></strong><br>
                            <table width="417" border="0" class="btabela_grande">
                                <tr>
                                    <th scope="col"><div align="left" class="titulo_topo">Descrição</div></th>
                                    <th scope="col"><div align="center" class="titulo_topo">Desconto (%)</div></th>
                                   <!-- <th scope="col"><div align="center" class="titulo_topo">Excluir</div></th>-->
                               </tr>
                                <%
            if (!promocoes.isEmpty()) {
                while (iPromocoes.hasNext()) {
                    Promocao iPromocao = (Promocao) iPromocoes.next();

                                %>
                                <tr>
                                    <td class="titulo"><%=iPromocao.getDescricao_pro()%></td>
                                    <td align="center"><%=iPromocao.getDesconto_pro()%></td>
                                    <td>
                                        <div align="center">
                                            <!--<input type="button" name="btnExcluir" value="Excluir" onClick="Redirecionar_Exclusao('processaExclusaoProduto.jsp?id= //produto.getId_prod()')">-->
                                    </div></td>
                                 </tr>
                                
                                <%
                                    }
                                } else {
                                %>
                                <tr><td colspan="3" align="center" class="titulo">Não existem dados de Promoções cadastrados.</td>
                              </tr>                
                                
                                <%            }
                                %>
                            </table>
                            <br><br>
                            
                    </td></tr><tr><td align="center"><input type="button" name="cancelar" value="Cancelar" onClick="javascript:location.href='index.jsp'"><br><br><br></td></tr>
                    
                    <tr><td align="center"><%=msn.getMn_Rodape_Site()%></td></tr>
                </table>
        </center> </form>   
    </body>
</html>
<%}%>