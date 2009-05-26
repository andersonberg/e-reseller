package org.apache.jsp.relatorios;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import util.Mensagens;
import produto.*;
import venda.*;
import cliente.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.text.DecimalFormat;

public final class vendas_jsp extends org.apache.jasper.runtime.HttpJspBase
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
 } else {
    String codigo = request.getParameter("id").toString();
    String relatorio = request.getParameter("tipo").toString();
    String dtInicial="";
    String dtFinal="";
    String cli="";
    if (relatorio.equals("3")) {
        dtInicial = request.getParameter("dtInicial").toString();
        dtFinal = request.getParameter("dtFinal").toString();
        cli = request.getParameter("cmbCliente").toString();
    }
    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    DecimalFormat vf = new DecimalFormat("0.00");
//DADOS DE VENDA
    RepositorioVendas repVenda = new RepositorioVendasMySQL();
    CadastroVendas cadVenda = new CadastroVendas(repVenda);
    Collection vendas = null;
    if (relatorio.equals("3")) {
        vendas = cadVenda.procurarVendas(Integer.parseInt(codigo), Integer.parseInt(cli), dtInicial, dtFinal);
    } else {
        vendas = cadVenda.procurarVendas(Integer.parseInt(codigo), Integer.parseInt(relatorio));
    }
    Iterator iVendas = vendas.iterator();

//DADOS DE Produto
    RepositorioProdutos repProduto = new RepositorioProdutosMySQL();
    CadastroProdutos cadProduto = new CadastroProdutos(repProduto);
    Produto produto = null;
//DADOS DE CLIENTES
    RepositorioClientes repCliente = new RepositorioClientesMySQL();
    CadastroClientes cadCliente = new CadastroClientes(repCliente);
    Cliente cliente = null;


      out.write("\r\n");
      out.write("<html>\r\n");
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
      out.write("                        <td align=\"center\" class=\"titulo_topo\">Vendas Registradas</td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <br><tr><td>\r\n");
      out.write("                        <table width=\"834\" align=\"center\" class=\"btabela_relatorio\">\r\n");
      out.write("                            <tr>\r\n");
      out.write("                                <td width=\"261\" height=\"16\" class=\"btabela_relatorio\" ><div align=\"left\">Produto</div></td>\r\n");
      out.write("                                <td class=\"btabela_relatorio\"><div align=\"left\">Cliente</div></td>\r\n");
      out.write("                                <td class=\"btabela_relatorio\"><div align=\"center\">Quantidade</div></td>\r\n");
      out.write("                                <td class=\"btabela_relatorio\"><div align=\"center\">Valor</div></td>\r\n");
      out.write("                                <td class=\"btabela_relatorio\"><div align=\"center\">Prazo</div></td>\r\n");
      out.write("                                <td class=\"btabela_relatorio\"><div align=\"center\">Data</div></td>\r\n");
      out.write("                            </tr>\r\n");
      out.write("                            ");

    if (!vendas.isEmpty()) {
        float valorTotal = 0;
        int qtdTotal = 0;
        while (iVendas.hasNext()) {
            Venda venda = (Venda) iVendas.next();

                            
      out.write("\r\n");
      out.write("                            <tr>\r\n");
      out.write("                                <td ><div align=\"left\">");
produto = cadProduto.procurar(venda.getId_prod());
      out.print(produto.getDescricao_prod());
      out.write("</div></td>\r\n");
      out.write("                                <td><div align=\"left\">");
cliente = cadCliente.procurar(venda.getId_cli());
      out.print(cliente.getNome_cli());
      out.write("</div></td>\r\n");
      out.write("                                <td><div align=\"center\">");
      out.print(venda.getQtd_ven());
      out.write("</div></td>\r\n");
      out.write("                                <td><div align=\"center\">R$ ");
      out.print(vf.format(venda.getValor_ven()));
      out.write("</div></td>\r\n");
      out.write("                                <td><div align=\"center\">");
      out.print(venda.getPrazo_ven());
      out.write("</div></td>\r\n");
      out.write("                                <td><div align=\"center\">");
      out.print(df.format(venda.getDthr_atualizacao()));
      out.write("</div></td>\r\n");
      out.write("                            </tr>\r\n");
      out.write("                            \r\n");
      out.write("                            ");
valorTotal = valorTotal+venda.getValor_ven();
                                qtdTotal = qtdTotal+ venda.getQtd_ven();
                                }
                            
      out.write("\r\n");
      out.write("                            <tr><td colspan=\"6\" class=\"titulo\"><BR>Valor Total: R$ <strong>");
      out.print(vf.format(valorTotal));
      out.write("<br>Quantidade de Produtos vendidos: <strong>");
      out.print(qtdTotal);
      out.write("</strong></td></tr>\r\n");
      out.write("                            ");

                            } else {
                            
      out.write("\r\n");
      out.write("                            <tr>\r\n");
      out.write("                                <td colspan=\"6\" align=\"center\" class=\"titulo\">Não existem dados de Vendas Registrados.</td>\r\n");
      out.write("                            </tr>                \r\n");
      out.write("                            \r\n");
      out.write("                            ");
            }
                            
      out.write("\r\n");
      out.write("                    </table></tr></td>\r\n");
      out.write("                    <tr><td><div align=\"center\"><br><br><input type=\"button\" value=\"Voltar\" onClick=\"javascript:history.go(-1)\">&nbsp;&nbsp;&nbsp;<input type=\"button\" value=\"Imprimir\" onClick=\"javascript:window.print()\"><br>\r\n");
      out.write("                            <br>\r\n");
      out.write("                            <br>\r\n");
      out.write("                            \r\n");
      out.write("                            <br>\r\n");
      out.write("                            <br>\r\n");
      out.write("                    </div></tr></td>\r\n");
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
