package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import util.Mensagens;
import usuario.*;

public final class acessarSistema_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"estilo/si2009.css\"/>\r\n");

            try {
                Mensagens msn = new Mensagens();
                String login = (String) request.getParameter("txtUsuario");
                String senha = (String) request.getParameter("txtSenha");

      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <center>\r\n");
      out.write("            <table>\r\n");
      out.write("                <tr><td colspan=\"3\"><br><br><br><br><br><br><br><br><br><br></td></tr>\r\n");
      out.write("                <tr><td colspan=\"3\" class=\"titulo_topo\">Processando dados. Aguarde...</td></tr>\r\n");
      out.write("                <tr><td colspan=\"3\"><br><br><br><br><br><br><br><br><br><br></td></tr>\r\n");
      out.write("                <tr><td align=\"center\" colspan=\"3\">");
      out.print(msn.getMn_Rodape_Site());
      out.write("</td>\r\n");
      out.write("                </tr>\r\n");
      out.write("        </table></center>\r\n");
      out.write("        ");

    String erro = "";
    if (login.equals("")) {
        erro = "Informe um usuário para proceder com o acesso.<br><a href='index.jsp'>Tentar novamente</a>";
        
      out.write("\r\n");
      out.write("        ");
      if (true) {
        _jspx_page_context.forward("inconsistenciaSistema.jsp" + (("inconsistenciaSistema.jsp").indexOf('?')>0? '&': '?') + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("erro", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(erro), request.getCharacterEncoding()));
        return;
      }
      out.write("\r\n");
      out.write("        ");

        } else if (senha.equals("")) {
            erro = "Informe uma senha para proceder com o acesso.<br><a href='index.jsp'>Tentar novamente</a>";
        
      out.write("\r\n");
      out.write("        ");
      if (true) {
        _jspx_page_context.forward("inconsistenciaSistema.jsp" + (("inconsistenciaSistema.jsp").indexOf('?')>0? '&': '?') + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("erro", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(erro), request.getCharacterEncoding()));
        return;
      }
      out.write("\r\n");
      out.write("        ");

        } else {
            RepositorioUsuarios repUsuario = new RepositorioUsuariosMySQL();
            CadastroUsuarios cadUsuario = new CadastroUsuarios(repUsuario);
            int codigoUsuarioLogado = cadUsuario.liberarAcesso(login, senha);
            if (codigoUsuarioLogado > 0) {
                Usuario usuario = cadUsuario.procurar(codigoUsuarioLogado,1);
                if (usuario.getId_cli() > 0) {
                    erro = "Este Usuário não é funcionário do E-reseller para utilizar o sistema.<br><a href='index.jsp'>Tentar novamente</a>";
        
      out.write("\r\n");
      out.write("        ");
      if (true) {
        _jspx_page_context.forward("inconsistenciaSistema.jsp" + (("inconsistenciaSistema.jsp").indexOf('?')>0? '&': '?') + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("erro", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(erro), request.getCharacterEncoding()));
        return;
      }
      out.write("     \r\n");
      out.write("        \r\n");
      out.write("        ");

                } else {

                    session.setAttribute("USU_AUTENTICADO", login);
                    session.setAttribute("ID_USU_LOGADO", codigoUsuarioLogado);
        
      out.write("\r\n");
      out.write("        ");
      if (true) {
        _jspx_page_context.forward("sistema.jsp");
        return;
      }
      out.write("\r\n");
      out.write("        ");
 }
            } else {
                erro = "Usuário não habilitado para utilizar o sistema.<br><a href='index.jsp'>Tentar novamente</a>";
        
      out.write("\r\n");
      out.write("        ");
      if (true) {
        _jspx_page_context.forward("inconsistenciaSistema.jsp" + (("inconsistenciaSistema.jsp").indexOf('?')>0? '&': '?') + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("erro", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(erro), request.getCharacterEncoding()));
        return;
      }
      out.write("     \r\n");
      out.write("        ");

        }
    }

} catch (Exception e) {
    String erro = "Erro Localizado ao processar dados.<br><a href='index.jsp'>Tentar novamente</a>";
        
      out.write("\r\n");
      out.write("        ");
      if (true) {
        _jspx_page_context.forward("inconsistenciaSistema.jsp" + (("inconsistenciaSistema.jsp").indexOf('?')>0? '&': '?') + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("erro", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(erro), request.getCharacterEncoding()));
        return;
      }
      out.write(" \r\n");
      out.write("        ");


            }
        
      out.write("\r\n");
      out.write("    </body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
