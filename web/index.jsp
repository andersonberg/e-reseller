<%-- 
    Document   : index
    Created on : 04/04/2009, 21:19:48
    Author     : Ailton Souza
--%>
<html>
    <%
        //Liberando vari�veis para n�o liberar acesso ao sistema
            session.setAttribute("USU_AUTENTICADO", "");
            session.setAttribute("ID_USU_LOGADO", "0");
            session.setAttribute("FACHADA", "");
%>
<head>
<title>E-Reseller�</title>
</head>
<frameset rows="0,*" frameborder="NO" border="0" framespacing="0">
	<frame src="" name="topFrame" scrolling="NO" noresize>    
	<frame src="si2009.jsp" name="mainFrame">
</frameset>
<noframes><body marginheight="0" marginwidth="0" leftmargin="0" rightmargin="0" topmargin="0">
</body></noframes>
</html>
