package org.apache.jsp.vendas;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import util.Mensagens;
import produto.Produto;
import estoque.Estoque;
import promocao.Promocao;
import promocao.exceptions.*;
import fachada.Fachada;
import java.util.*;
import java.text.DecimalFormat;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
        _jspx_page_context.forward("inconsistenciaProdutos.jsp" + (("inconsistenciaProdutos.jsp").indexOf('?')>0? '&': '?') + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("erro", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(erro), request.getCharacterEncoding()));
        return;
      }
      out.write("    \r\n");
 } else {
    DecimalFormat vf = new DecimalFormat("0.00");
    Fachada fachada = (Fachada) session.getAttribute("FACHADA");
//DADOS DE PRODUTO
    Collection produtos = fachada.procurarProdutos();
    Iterator iProdutos = produtos.iterator();

//DADOS DE ESTOQUE
    Estoque estoque = null;

//DADOS DE PROMOÇÃO
    Promocao promocao = null;


      out.write("\r\n");
      out.write("\r\n");
      out.write("<SCRIPT language=JavaScript>\r\n");
      out.write("\r\n");
      out.write("    function Redirecionar(url){\r\n");
      out.write("        document.frmMain.action= url;\r\n");
      out.write("        document.frmMain.submit();\r\n");
      out.write("    }\r\n");
      out.write("</SCRIPT>\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("    <style type=\"text/css\">\r\n");
      out.write("        <!--\r\n");
      out.write("        .style1 {\r\n");
      out.write("            color: #FF0000;\r\n");
      out.write("            font-weight: bold;\r\n");
      out.write("        }\r\n");
      out.write("        -->\r\n");
      out.write("    </style>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>");
      out.print(msn.getMn_Titulo_Site());
      out.write("</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <form name=\"frmMain\" method=\"post\">\r\n");
      out.write("            <center>\r\n");
      out.write("                <table>\r\n");
      out.write("                    <tr><td width=\"417\" align=\"left\"><br>\r\n");
      out.write("                    <br><br><br><br><br><br><br><br><br><a href=\"../sistema.jsp\">Home</a></td></tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td align=\"center\" class=\"titulo_topo\">Registrar Venda</td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr><td colspan=\"5\">\r\n");
      out.write("                            <br>\r\n");
      out.write("                            <table width=\"698\" border=\"0\" class=\"btabela_grande\">\r\n");
      out.write("                                <tr>\r\n");
      out.write("                                    <th width=\"261\"  scope=\"col\"><div align=\"left\" class=\"titulo_topo\">Produto</div></th>\r\n");
      out.write("                                    <th width=\"44\" scope=\"col\"  colspan=\"3\" class=\"titulo_topo\">Preço</th>\r\n");
      out.write("                                    <th width=\"84\" scope=\"col\" class=\"titulo_topo\">&nbsp;</th>\r\n");
      out.write("                                    <th width=\"139\" scope=\"col\" class=\"titulo_topo\">Vender</th>\r\n");
      out.write("                                </tr>\r\n");
      out.write("                                ");

    if (!produtos.isEmpty()) {
        while (iProdutos.hasNext()) {
            Produto produto = (Produto) iProdutos.next();
            estoque = fachada.procurarEstoqueProduto(produto.getId_prod());
            try {
                promocao = fachada.procurarProdutoPromocao(produto.getId_prod());
            } catch (PromocaoInexistenteException e) {
                promocao = null;
                e.getStackTrace();

            }
            String valorFormatado = "";
                                
      out.write("\r\n");
      out.write("                                <tr>\r\n");
      out.write("                                    <td class=\"titulo\">");
      out.print(produto.getDescricao_prod());
      out.write("</td>\r\n");
      out.write("                                    ");
 if (promocao == null) {
      out.write("\r\n");
      out.write("                                    <td colspan=\"3\">R$ ");
      out.print(vf.format(estoque.getValor_prod_est()));
      out.write("\r\n");
      out.write("                                    <input type=\"hidden\" name=\"edtValor");
      out.print(produto.getId_prod());
      out.write("\" value=\"");
      out.print(estoque.getValor_prod_est());
      out.write("\"></td>\r\n");
      out.write("                                    ");
} else {
      out.write("\r\n");
      out.write("                                    <td  colspan=\"3\"><span class=\"style1\">DE:</span> R$ ");
      out.print(vf.format(estoque.getValor_prod_est()));
      out.write(" <span class=\"style1\">POR:</span> R$ ");
valorFormatado = vf.format(estoque.getValor_prod_est() - estoque.getValor_prod_est() * (new Float(promocao.getDesconto_pro()) / new Float(100)));
                                        
      out.print(valorFormatado);
      out.write("\r\n");
      out.write("                                        \r\n");
      out.write("                                    <input type=\"hidden\" name=\"edtValor");
      out.print(produto.getId_prod());
      out.write("\" value=\"");
      out.print(valorFormatado);
      out.write("\"></td>\r\n");
      out.write("                                    ");
}
      out.write("\r\n");
      out.write("                                    \r\n");
      out.write("                                    <td>&nbsp;</td>\r\n");
      out.write("                                    <td><div align=\"center\">\r\n");
      out.write("                                            ");
if (estoque.getQuantidade_est() > 0) {
      out.write("\r\n");
      out.write("                                            <input type=\"button\" name=\"Enviar\" value=\"Vender Produto\" onClick=\"Redirecionar('cadVenda.jsp?id=");
      out.print( produto.getId_prod());
      out.write("')\">\r\n");
      out.write("                                    </div></td>\r\n");
      out.write("                                    ");
} else {
      out.write("Produto Indísponivel");
}
      out.write("\r\n");
      out.write("                                </tr>\r\n");
      out.write("                                \r\n");
      out.write("                                ");

                                    }
                                } else {
                                
      out.write("\r\n");
      out.write("                                <tr><td colspan=\"6\" align=\"center\" class=\"titulo\">Não existem dados de Produtos cadastrado.</td></tr>                \r\n");
      out.write("                                \r\n");
      out.write("                                ");
            }
                                
      out.write("\r\n");
      out.write("                            </table>\r\n");
      out.write("                            <br><br><br><br><br><br><br><br>\r\n");
      out.write("                    </td></tr>\r\n");
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
