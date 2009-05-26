package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import util.Mensagens;

public final class cliente_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\r\n");
      out.write("\"http://www.w3.org/TR/html4/loose.dtd\">\r\n");

            Mensagens msn = new Mensagens();
            session.setAttribute("login", "");

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
      out.write("                <tr><td height=\"153\" colspan=\"4\"><br>\r\n");
      out.write("                        <br><br><br>\r\n");
      out.write("                    </td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                  <td width=\"416\" colspan=\"2\" align=\"center\" class=\"sub_titulo\"><p><img src=\"img/clienteeparceiros/sonyericsson.jpg\" width=\"150\" height=\"113\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src=\"img/clienteeparceiros/carrefour.jpg\" width=\"136\" height=\"106\"><br>\r\n");
      out.write("                  </p>                    \r\n");
      out.write("                        <p><img src=\"img/clienteeparceiros/aoc.jpg\" width=\"150\" height=\"51\"><br><img src=\"img/clienteeparceiros/toshiba.jpg\"></p>\r\n");
      out.write("                      <p><br>\r\n");
      out.write("                  </p></td>\r\n");
      out.write("                    <td width=\"146\" colspan=\"2\" rowspan=\"3\" valign=\"top\"><img src=\"img/clienteeparceiros/pearson.jpg\" width=\"130\" height=\"94\"><br> <br><br><img src=\"img/clienteeparceiros/xerox.jpg\">   <br><br><br><img src=\"img/clienteeparceiros/lex.jpg\">                </td>\r\n");
      out.write("              </tr>\r\n");
      out.write("                \r\n");
      out.write("                <tr>\r\n");
      out.write("                  <td align=\"center\" colspan=\"4\" class=\"menu_sup\"><div align=\"center\"><a href=\"\">Home</a></div></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr><td align=\"center\" colspan=\"4\">");
      out.print(msn.getMn_Rodape_Site());
      out.write("</td></tr>\r\n");
      out.write("            </table>\r\n");
      out.write("     \r\n");
      out.write("    </center>    \r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
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
