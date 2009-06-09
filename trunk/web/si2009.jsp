<%-- 
    Document   : index
    Created on : 04/04/2009, 21:19:48
    Author     : Ailton Souza
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="util.Mensagens"%>
<%@ page session="true"%>
<link rel="stylesheet" type="text/css" href="estilo/si2009.css"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%
            Mensagens msn = new Mensagens();
            session.setAttribute("USU_AUTENTICADO", "");
            session.setAttribute("ID_USU_LOGADO", "0");
%>
<html><head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%=msn.getMn_Titulo_Site()%></title>
    </head>
    <body>
        <center>
            <table>
                <tr><td height="153" colspan="4" align="right"><br>
                        <br><br><br>
                    </td>
                </tr>
                <tr>
                    <td height="88" colspan="2" align="center" class="sub_titulo"><p><img src="img/logo_fornecedor.png"></p>                    
                        <p>O <strong>E-Reseller</strong> propõe-se a  automatizar os serviços oferecidos pelo<br>sistema de revenda de modo a, através  de um w<em>ebservice</em>, prover informações<br>e comunicação entre a solicitações realizadas garantindo uma<br>liberação de  produtos para o sistema de transporte de modo eficiente.</p>
                        <p><br>
                    </p></td>
                    <td width="146" colspan="2" rowspan="3" valign="top"><form name="ftmAcessarSistema" method="post" action="acessarSistema.jsp">
                            <div align="center" class="titulo_topo"><br>Acesso ao Sistema</div><div><br></div>
                            <div><label><strong>Usuário</strong>
                                    <input type="text" name="txtUsuario" id="txtUsuario" maxlength="10">
                            </label></div>
                            <div>
                                <label><strong>Senha</strong>
                                    <input type="password" name="txtSenha" id="txtSenha" maxlength="10">
                                </label>
                            </div>
                            <div align="center"><br><input type="submit" value="Acessar"></div>
                        </form> <br><br><br>                   
                        <a href="mailto:eresseler@eresseler.com"><li>Suporte Técnico</li>
                        </a>
                        <a href="cliente.jsp"><li>Clientes e Parceiros</li>
                        </a>
                    </td>
                </tr>
                <tr>
                    <td width="109" valign="top"><p><br>
                            <strong>Equipe</strong>:<br><li>Ailton Souza</li><br>
                            <li>Alberis Garcês</li><br>
                            <li>Anderson Berg</li><br>
                            <li>Hélio Berntzen</li><br>
                            <li>Robson David</li>
                    </p></td>
                    <td width="416" valign="top"><p><br>
                            <strong>Documentação</strong>:<br>
                            <a href="documentos/Documento_de_Requisitos.pdf" target="blank"><li>Documento de Requisitos</li></a><a href="documentos/EspecificacaodeCasodeUso.pdf" target="blank">
                                <li>Especificação de Casos de Uso</li><a href="documentos/Documento_arquitetura_software.pdf" target="blank">
                                <li>Arquitetura de Software</li>
                            </a>
                </p></td></tr>
                <tr><td align="center" colspan="4"><%=msn.getMn_Rodape_Site()%></td></tr>
            </table>
            
        </center>    
    </body>
</html>
