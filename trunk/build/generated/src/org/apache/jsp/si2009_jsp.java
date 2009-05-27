package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import util.Mensagens;

public final class si2009_jsp extends org.apache.jasper.runtime.HttpJspBase
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
            session.setAttribute("USU_AUTENTICADO", "");
            session.setAttribute("ID_USU_LOGADO", "0");

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
      out.write("                <tr><td height=\"153\" colspan=\"4\" align=\"right\"><br>\r\n");
      out.write("                        <br><br><br>\r\n");
      out.write("                    </td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td height=\"88\" colspan=\"2\" align=\"center\" class=\"sub_titulo\"><p><img src=\"img/logo_fornecedor.png\"></p>                    \r\n");
      out.write("                        <p>O <strong>E-Reseller</strong> propõe-se a  automatizar os serviços oferecidos pelo<br>sistema de revenda de modo a, através  de um w<em>ebservice</em>, prover informações<br>e comunicação entre a solicitações realizadas garantindo uma<br>liberação de  produtos para o sistema de transporte de modo eficiente.</p>\r\n");
      out.write("                        <p><br>\r\n");
      out.write("                    </p></td>\r\n");
      out.write("                    <td width=\"146\" colspan=\"2\" rowspan=\"3\" valign=\"top\"><form name=\"ftmAcessarSistema\" method=\"post\" action=\"acessarSistema.jsp\">\r\n");
      out.write("                            <div align=\"center\" class=\"titulo_topo\"><br>Acesso ao Sistema</div><div><br></div>\r\n");
      out.write("                            <div><label><strong>Usuário</strong>\r\n");
      out.write("                                    <input type=\"text\" name=\"txtUsuario\" id=\"txtUsuario\" maxlength=\"10\">\r\n");
      out.write("                            </label></div>\r\n");
      out.write("                            <div>\r\n");
      out.write("                                <label><strong>Senha</strong>\r\n");
      out.write("                                    <input type=\"password\" name=\"txtSenha\" id=\"txtSenha\" maxlength=\"10\">\r\n");
      out.write("                                </label>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div align=\"center\"><br><input type=\"submit\" value=\"Acessar\"></div>\r\n");
      out.write("                        </form> <br><br><br>                   \r\n");
      out.write("                        <a href=\"mailto:eresseler@eresseler.com\"><li>Suporte Técnico</li>\r\n");
      out.write("                        </a>\r\n");
      out.write("                        <a href=\"cliente.jsp\"><li>Clientes e Parceiros</li>\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td width=\"109\" valign=\"top\"><p><br>\r\n");
      out.write("                            <strong>Equipe</strong>:<br><li>Ailton Souza</li><br>\r\n");
      out.write("                            <li>Alberis Garcês</li><br>\r\n");
      out.write("                            <li>Anderson Berg</li><br>\r\n");
      out.write("                            <li>Hélio Berntzen</li><br>\r\n");
      out.write("                            <li>Robson David</li>\r\n");
      out.write("                    </p></td>\r\n");
      out.write("                    <td width=\"416\" valign=\"top\"><p><br>\r\n");
      out.write("                            <strong>Documentação</strong>:<br>\r\n");
      out.write("                            <a href=\"documentos/Documento_de_Requisitos.pdf\" target=\"blank\"><li>Documento de Requisitos</li></a><a href=\"documentos/EspecificacaodeCasodeUso.pdf\" target=\"blank\">\r\n");
      out.write("                                <li>Especificação de Casos de Uso</li><a href=\"documentos/Documento_arquitetura_software.pdf\" target=\"blank\">\r\n");
      out.write("                                <li>Arquitetura de Software</li>\r\n");
      out.write("                            </a>\r\n");
      out.write("                </p></td></tr>\r\n");
      out.write("                <tr><td align=\"center\" colspan=\"4\">");
      out.print(msn.getMn_Rodape_Site());
      out.write("</td></tr>\r\n");
      out.write("            </table>\r\n");
      out.write("            \r\n");
      out.write("        </center>    \r\n");
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
