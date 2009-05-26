package org.apache.jsp.clientes;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import util.Mensagens;
import cliente.*;
import java.util.*;

public final class cadCliente_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=UTF-8");
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
        _jspx_page_context.forward("inconsistenciaProdutos.jsp" + (("inconsistenciaProdutos.jsp").indexOf('?')>0? '&': '?') + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("erro", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(erro), request.getCharacterEncoding()));
        return;
      }
      out.write("    \r\n");
 }else{
String codigoCliente = request.getParameter("id").toString();
RepositorioClientes repCliente = new RepositorioClientesMySQL();
CadastroClientes cadCliente = new CadastroClientes(repCliente);
Cliente clienteManutencao = null;
try{
if (codigoCliente.equals("0")){
    clienteManutencao = new Cliente(0, "","", 0);
}else{
    clienteManutencao = cadCliente.procurar(Integer.parseInt(codigoCliente));
}}catch(Exception e){
    
}

      out.write("\r\n");
      out.write("<script language=\"javascript\">\r\n");
      out.write("function validar(){\r\n");
      out.write("\tfor (i=0;i<document.frmCadastrarCliente.elements.length-1;i++){\r\n");
      out.write("\t\tif ((document.frmCadastrarCliente.elements[i].value == '')&&(document.frmCadastrarCliente.elements[i].type == 'text')){\r\n");
      out.write("\t\t\talert('Informar todos os campos obrigatórios.');\r\n");
      out.write("\t\t\tdocument.frmCadastrarCliente.elements[i].focus();\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("                if ((document.frmCadastrarCliente.elements[i].value == '')&&(document.frmCadastrarCliente.elements[i].type == 'password')){\r\n");
      out.write("\t\t\talert('Informar todos os campos obrigatórios.');\r\n");
      out.write("\t\t\tdocument.frmCadastrarCliente.elements[i].focus();\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\treturn true;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>");
      out.print(msn.getMn_Titulo_Site());
      out.write("</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("              <center>\r\n");
      out.write("                <table>\r\n");
      out.write("                    <tr><td width=\"417\" align=\"left\"><br>\r\n");
      out.write("                    <br><br><br><br><br><br><br><br><br><a href=\"../sistema.jsp\">Home</a></td></tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td align=\"center\" class=\"titulo_topo\">Cadastro de Clientes</td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr> <td>\r\n");
      out.write("                            <div align=\"left\"></div>\r\n");
      out.write("                <br><form name=\"frmCadastrarCliente\" method=\"post\" action=\"processaManutencaoCliente.jsp\">\r\n");
      out.write("                            <table width=\"417\" border=\"0\" class=\"btabela_grande\">\r\n");
      out.write("                                <tr><td width=\"110\">Nome:</td>\r\n");
      out.write("                                  <td width=\"297\">\r\n");
      out.write("                                  <input name=\"edtNome\" type=\"text\"  value=\"");
      out.print(clienteManutencao.getNome_cli());
      out.write("\" size=\"50\" maxlength=\"150\"></td>\r\n");
      out.write("                                  <input type=\"hidden\" name=\"id\" value=\"");
      out.print(clienteManutencao.getId_cli());
      out.write("\">\r\n");
      out.write("                                </tr\r\n");
      out.write("                                <tr><td width=\"110\">Endereço:</td>\r\n");
      out.write("                                  <td width=\"297\">\r\n");
      out.write("                                  <input name=\"edtEndereco\" type=\"text\"  value=\"");
      out.print(clienteManutencao.getEndereco_cli());
      out.write("\" size=\"50\" maxlength=\"150\"></td>\r\n");
      out.write("                                  \r\n");
      out.write("                                </tr>\r\n");
      out.write("                                                             </tr>\r\n");
      out.write("                                                             <tr><td colspan=\"2\">&nbsp;</td>\r\n");
      out.write("                                                             </tr>\r\n");
      out.write("                                                             <tr><td></td><td><input type=\"submit\" name=\"confirmarInclusao\" value=\"Confirmar\" onClick=\"return validar();\">&nbsp;&nbsp;&nbsp;&nbsp;<input type=\"button\" name=\"cancelar\" value=\"Cancelar\" onClick=\"javascript:location.href='index.jsp'\"></td>\r\n");
      out.write("                                                             </tr>\r\n");
      out.write("                           </table></form> \r\n");
      out.write("                      <br><br><br>\r\n");
      out.write("                    </td></tr>\r\n");
      out.write("                    <tr><td align=\"center\">");
      out.print(msn.getMn_Rodape_Site());
      out.write("</td></tr>\r\n");
      out.write("                </table>\r\n");
      out.write("        </center>   \r\n");
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
