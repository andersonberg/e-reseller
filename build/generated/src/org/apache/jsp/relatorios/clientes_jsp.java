package org.apache.jsp.relatorios;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import util.Mensagens;
import cliente.Cliente;
import fachada.Fachada;
import java.util.*;

public final class clientes_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"../estilo/si2009.css\"/>\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\r\n");
      out.write("\"http://www.w3.org/TR/html4/loose.dtd\">\r\n");

            Mensagens msn = new Mensagens();
            if (session.getAttribute("USU_AUTENTICADO").equals("")) {
                String erro = "Realizar autenticação no sistema.<br><a href='../index.jsp'>Tentar novamente</a>";

      out.write("        \r\n");
      if (true) {
        _jspx_page_context.forward("inconsistenciaRelatorios.jsp" + (("inconsistenciaRelatorios.jsp").indexOf('?')>0? '&': '?') + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("erro", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(erro), request.getCharacterEncoding()));
        return;
      }
      out.write("    \r\n");
 }else{


            Fachada fachada = (Fachada) session.getAttribute("FACHADA");
            Collection clientes = fachada.procurarClientes();
            Iterator iClientes = clientes.iterator();

      out.write("\r\n");
      out.write("<SCRIPT language=JavaScript>\r\n");
      out.write("\r\n");
      out.write("    function Redirecionar(url){\r\n");
      out.write("        document.frmMain.action= url;\r\n");
      out.write("        document.frmMain.submit();\r\n");
      out.write("    }\r\n");
      out.write("</SCRIPT>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>");
      out.print(msn.getMn_Titulo_Site());
      out.write("</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <form name=\"frmMain\" method=\"post\">\r\n");
      out.write("        <input type=\"hidden\" id=\"tipo\" name=\"tipo\" value=\"2\">\r\n");
      out.write("            <center>\r\n");
      out.write("                <table>\r\n");
      out.write("                    <tr><td width=\"417\" align=\"left\"><br>\r\n");
      out.write("                    <br><br><br><br><br><br><br><br><br><a href=\"../sistema.jsp\">Home</a></td></tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td align=\"center\" class=\"titulo_topo\">Clientes Cadastrados</td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr><td>\r\n");
      out.write("<br>\r\n");
      out.write("                            <table width=\"489\" border=\"0\" class=\"btabela_relatorio\">\r\n");
      out.write("  <tr>\r\n");
      out.write("                                    <th width=\"219\" scope=\"col\" class=\"btabela_relatorio\"><div align=\"left\">Nome</div></th>\r\n");
      out.write("              <th scope=\"col\" class=\"btabela_relatorio\"><div align=\"left\">Endereço</div></th>\r\n");
      out.write("              </tr>\r\n");
      out.write("                                ");

            if (!clientes.isEmpty()) {
                while (iClientes.hasNext()) {
                    Cliente cliente = (Cliente) iClientes.next();

                                
      out.write("\r\n");
      out.write("                                <tr>\r\n");
      out.write("                                    <td class=\"titulo\"><a href=\"javascript:Redirecionar('vendas.jsp?id=");
      out.print(cliente.getId_cli());
      out.write("')\">");
      out.print(cliente.getNome_cli());
      out.write("</a></td>\r\n");
      out.write("                                    <td>");
      out.print(cliente.getEndereco_cli());
      out.write("</td>\r\n");
      out.write("                                </tr>\r\n");
      out.write("                                \r\n");
      out.write("                          ");

                                    }
      out.write("\r\n");
      out.write("                                    <tr><td colspan=\"2\" class=\"titulo\"><br><i>Clique no nome do cliente para visualizar suas compras.</i></td></tr>\r\n");
      out.write("                                    ");

                                } else {
                                
      out.write("\r\n");
      out.write("                                <tr><td colspan=\"2\" align=\"center\" class=\"titulo\">Não existem dados de Clientes cadastrado.</td></tr>                \r\n");
      out.write("                                \r\n");
      out.write("                                ");
            }
                                
      out.write("\r\n");
      out.write("                            </table>\r\n");
      out.write("                            <div align=\"center\"><br>\r\n");
      out.write("                              <br>\r\n");
      out.write("                              <input type=\"button\" value=\"Voltar\" onClick=\"javascript:location.href='index.jsp'\">\r\n");
      out.write("                              &nbsp;&nbsp;&nbsp;\r\n");
      out.write("                              <input type=\"button\" value=\"Imprimir\" onClick=\"javascript:window.print()\">\r\n");
      out.write("                              <br>\r\n");
      out.write("                              <br>\r\n");
      out.write("                              <br>\r\n");
      out.write("                              <br>\r\n");
      out.write("                              <br>\r\n");
      out.write("                              <br>\r\n");
      out.write("                              <br>\r\n");
      out.write("                              <br>\r\n");
      out.write("                                    </div></td></tr>\r\n");
      out.write("                    <tr><td align=\"center\">");
      out.print(msn.getMn_Rodape_Site());
      out.write("</td></tr>\r\n");
      out.write("                </table>\r\n");
      out.write("        </center> </form>   \r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
}
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
