package org.apache.jsp.produtos;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import util.Mensagens;
import produto.*;
import estoque.*;
import produto.exceptions.*;

public final class processaManutencaoProduto_jsp extends org.apache.jasper.runtime.HttpJspBase
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
        _jspx_page_context.forward("inconsistenciaProdutos.jsp" + (("inconsistenciaProdutos.jsp").indexOf('?')>0? '&': '?') + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("erro", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(erro), request.getCharacterEncoding()));
        return;
      }
      out.write(' ');
      out.write('\r');
      out.write('\n');
}else{
            try {
                Mensagens msn = new Mensagens();
                String codigoTemporario = (String) request.getParameter("id").toString();
                String descricao = (String) request.getParameter("edtNome").toString();
                String caracteristicas = (String) request.getParameter("edtCaracteristicas").toString();
                String dimensao = (String) request.getParameter("edtDimensao").toString();
                String peso = (String) request.getParameter("edtPeso").toString();
                String especificacao = (String) request.getParameter("edtEspec").toString();
                String usuario =(String) session.getAttribute("ID_USU_LOGADO").toString();
                RepositorioProdutos repProduto = new RepositorioProdutosMySQL();
                CadastroProdutos cadProduto = new CadastroProdutos(repProduto);
                Produto produto = new Produto(Integer.parseInt(codigoTemporario),descricao,caracteristicas,dimensao,peso,especificacao,Integer.parseInt(usuario));
                String informacao = null;
                if (codigoTemporario.equals("0")){
                    String quantidade = (String) request.getParameter("edtEstoque").toString();
                    String valor = (String) request.getParameter("edtValor").toString();
                    valor = valor.replace(",", ".");
                    //INSERINDO PRODUTO
                    int codigoInserido = cadProduto.inserir(produto);
                    informacao = "Produto <strong>cadastrado</strong> com sucesso.";
                    //INSERINDO PRODUTO NO ESTOQUE
                    Estoque estoque = new Estoque(codigoInserido,Integer.parseInt(quantidade),Float.parseFloat(valor),Integer.parseInt(usuario));
                    RepositorioEstoques repEstoque = new RepositorioEstoquesMySQL();
                    CadastroEstoques cadEstoque = new CadastroEstoques(repEstoque);
                    cadEstoque.inserir(estoque);
                }else{
                    cadProduto.atualizar(produto);
                    informacao = "Produto <strong>alterado</strong> com sucesso.";
                }
                

      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
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
    String erro = e.getMessage()+".<br><a href='index.jsp'>Tentar novamente</a>";

      out.write('\r');
      out.write('\n');
      if (true) {
        _jspx_page_context.forward("inconsistenciaProdutos.jsp" + (("inconsistenciaProdutos.jsp").indexOf('?')>0? '&': '?') + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("erro", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(erro), request.getCharacterEncoding()));
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
