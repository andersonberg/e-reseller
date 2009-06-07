package org.apache.jsp.vendas;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import util.Mensagens;
import venda.Venda;
import venda.exceptions.*;
import estoque.Estoque;
import estoque.exceptions.*;
import fachada.Fachada;

public final class processaManutencaoVendas_jsp extends org.apache.jasper.runtime.HttpJspBase
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

            if (session.getAttribute("USU_AUTENTICADO").equals("")) {
                String erro = "Realizar autenticação no sistema.<br><a href='../index.jsp'>Tentar novamente</a>";

      out.write("        \r\n");
      if (true) {
        _jspx_page_context.forward("inconsistenciaVendas.jsp" + (("inconsistenciaVendas.jsp").indexOf('?')>0? '&': '?') + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("erro", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(erro), request.getCharacterEncoding()));
        return;
      }
      out.write(' ');
      out.write('\r');
      out.write('\n');
} else {
    try {
        Mensagens msn = new Mensagens();
        Fachada fachada = (Fachada) session.getAttribute("FACHADA");
        String codigoProduto = (String) request.getParameter("codigoProduto").toString();
        String quantidade = (String) request.getParameter("edtQuantidade").toString();
        String valor = (String) request.getParameter("edtValor").toString();
        String prazo = (String) request.getParameter("edtPrazo").toString();
        String cliente = (String) request.getParameter("cmbCliente").toString();

        valor = valor.replace(",", ".");
        String usuario = (String) session.getAttribute("ID_USU_LOGADO").toString();

        //DADOS ESTOQUE
        Estoque estoque = fachada.procurarEstoqueProduto(Integer.parseInt(codigoProduto));

        if (estoque.getQuantidade_est() < Integer.parseInt(quantidade)) {
            String erro = "Estoque não possui quantidade suficiente para realizar venda.<br><a href='index.jsp'>Tentar novamente</a>";

      out.write('\r');
      out.write('\n');
      if (true) {
        _jspx_page_context.forward("inconsistenciaVendas.jsp" + (("inconsistenciaVendas.jsp").indexOf('?')>0? '&': '?') + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("erro", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(erro), request.getCharacterEncoding()));
        return;
      }
      out.write(' ');
      out.write('\r');
      out.write('\n');

    }
                
    float valorTotal = new Float(valor) * new Float(quantidade);

    Venda venda = new Venda(0, Integer.parseInt(codigoProduto), Integer.parseInt(cliente), Integer.parseInt(quantidade), valorTotal, prazo, Integer.parseInt(usuario));

    String informacao = null;
    fachada.inserirVenda(venda);
    fachada.alterarEstoque(Integer.parseInt(codigoProduto), Integer.parseInt(quantidade), 1);
    informacao = "Venda <strong>registrada</strong> com sucesso.";


      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<head>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<center>\r\n");
      out.write("<table>\r\n");
      out.write("<tr><td colspan=\"3\"><br><br><br><br><br><br><br><br><br><br></td><br><br><br><br><br><br><br><br><br><br></td></tr>\r\n");
      out.write("<tr><td colspan=\"3\" class=\"titulo_topo\"><div align=\"center\">");
      out.print(informacao);
      out.write("<br>\r\n");
      out.write("<a href=\"\">Voltar</a></div></td></tr>\r\n");
      out.write("<tr><td colspan=\"3\"><br><br><br><br><br><br><br><br><br><br></td></tr>\r\n");
      out.write("<tr><td align=\"center\" colspan=\"3\">");
      out.print(msn.getMn_Rodape_Site());
      out.write("</td>\r\n");
      out.write("</tr>\r\n");
      out.write("</table>\r\n");
      out.write("</center>\r\n");
      out.write("\r\n");

} catch (Exception e) {
    String erro = e.getMessage() + ".<br><a href='index.jsp'>Tentar novamente</a>";

      out.write('\r');
      out.write('\n');
      if (true) {
        _jspx_page_context.forward("inconsistenciaVendas.jsp" + (("inconsistenciaVendas.jsp").indexOf('?')>0? '&': '?') + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("erro", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(erro), request.getCharacterEncoding()));
        return;
      }
      out.write(' ');
      out.write('\r');
      out.write('\n');


    }

      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
