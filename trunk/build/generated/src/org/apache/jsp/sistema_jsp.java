package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import util.Mensagens;

public final class sistema_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"estilo/si2009.css\"/>\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\r\n");
      out.write("\"http://www.w3.org/TR/html4/loose.dtd\">\r\n");

           
            if (session.getAttribute("USU_AUTENTICADO").equals("")) {
                String erro = "Realizar autenticação no sistema.<br><a href='index.jsp'>Tentar novamente</a>";

      out.write("        \r\n");
      if (true) {
        _jspx_page_context.forward("inconsistenciaSistema.jsp" + (("inconsistenciaSistema.jsp").indexOf('?')>0? '&': '?') + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("erro", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(erro), request.getCharacterEncoding()));
        return;
      }
      out.write("    \r\n");
 }else{
                 Mensagens msn = new Mensagens();

      out.write("\r\n");
      out.write("<html><head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>");
      out.print(msn.getMn_Titulo_Site());
      out.write("</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <center>\r\n");
      out.write("            <table>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td colspan=\"2\"><br>\r\n");
      out.write("                        <br>\r\n");
      out.write("                        <br>\r\n");
      out.write("                        <br>\r\n");
      out.write("                        <br>\r\n");
      out.write("                        <br>\r\n");
      out.write("                        <br>\r\n");
      out.write("                        <br>\r\n");
      out.write("                    <br>                    <br>                </td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    \r\n");
      out.write("                    <td width=\"128\" align=\"left\" class=\"sub_titulo\"><p><img src=\"img/produto/module.png\" width=\"32\" height=\"32\"><a href=\"produtos/\">Produtos</a></p>\r\n");
      out.write("                        <p>&nbsp;<img src=\"img/cliente/index.png\" width=\"32\" height=\"32\"><a href=\"clientes/\">Clientes</a></p>\r\n");
      out.write("                    <p><img src=\"img/usuario/accounts.png\" width=\"32\" height=\"32\"><a href=\"usuarios/\">Usuário</a></p><p><img src=\"img/venda.png\" width=\"32\" height=\"32\"><a href=\"vendas/\">Registrar Venda</a></p><p><img src=\"img/relatorio.png\" width=\"32\" height=\"32\"><a href=\"relatorios/\">Relatórios</a></p>\r\n");
      out.write("                  <p><img src=\"img/logon.png\" width=\"32\" height=\"32\"><a href=\"logoffSistema.jsp\">Sair do Sistema</a></p></td>\r\n");
      out.write("                    <td width=\"464\" align=\"center\" class=\"sub_titulo\" valign=\"middle\"><img src=\"img/logo_fornecedor.png\" width=\"180\" height=\"180\"></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td height=\"207\" colspan=\"2\" align=\"center\">Bem vindo ao sistema <strong>E-Reseller</strong>.<br>\r\n");
      out.write("                    Realizando um fornecimento de qualidade.</td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td height=\"14\" colspan=\"2\" align=\"center\">");
      out.print(msn.getMn_Rodape_Site());
      out.write("</td>\r\n");
      out.write("                </tr>\r\n");
      out.write("            </table>\r\n");
      out.write("        </center>    \r\n");
      out.write("    </body>\r\n");
      out.write("</html>");
}
      out.write('\r');
      out.write('\n');
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
