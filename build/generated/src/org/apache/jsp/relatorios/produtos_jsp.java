package org.apache.jsp.relatorios;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import util.Mensagens;
import produto.Produto;
import estoque.Estoque;
import fachada.Fachada;
import java.util.*;
import java.text.DecimalFormat;

public final class produtos_jsp extends org.apache.jasper.runtime.HttpJspBase
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
DecimalFormat vf = new DecimalFormat("0.00");
Fachada fachada = (Fachada) session.getAttribute("FACHADA");
//DADOS DE PRODUTO
    Collection produtos = fachada.procurarProdutos();
    Iterator iProdutos = produtos.iterator();

//DADOS DE ESTOQUE
    Estoque estoque = null;

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
      out.write("            <input type=\"hidden\" id=\"tipo\" name=\"tipo\" value=\"1\">\r\n");
      out.write("            <center>\r\n");
      out.write("                <table>\r\n");
      out.write("                    <tr><td width=\"417\" align=\"left\"><br>\r\n");
      out.write("                    <br><br><br><br><br><br><br><br><br><a href=\"../sistema.jsp\">Home</a></td></tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td align=\"center\" class=\"titulo_topo\"> Produtos Cadastrados</td>\r\n");
      out.write("                  </tr>\r\n");
      out.write("                    <tr><td colspan=\"5\">\r\n");
      out.write("          <br>\r\n");
      out.write("                            <table width=\"834\" border=\"0\" align=\"center\" class=\"btabela_relatorio\">\r\n");
      out.write("<tr>\r\n");
      out.write("                                    <th width=\"261\" height=\"34\"  scope=\"col\" class=\"btabela_relatorio\"><div align=\"left\">Descrição</div></th>\r\n");
      out.write("              <th width=\"2\" scope=\"col\" class=\"btabela_relatorio\"><div align=\"center\">Características</div></th>\r\n");
      out.write("                            <th width=\"2\"  scope=\"col\" class=\"btabela_relatorio\"><div align=\"center\">Dimensão</div></th>\r\n");
      out.write("                            <th width=\"78\"  scope=\"col\" class=\"btabela_relatorio\"><div align=\"center\">Peso</div></th>\r\n");
      out.write("                            <th width=\"231\" scope=\"col\" class=\"btabela_relatorio\"><div align=\"center\">Valor do Produto</div></th>\r\n");
      out.write("                                                        <th width=\"234\" scope=\"col\" class=\"btabela_relatorio\"><div align=\"center\">Disponível</div></th>\r\n");
      out.write("                              </tr>\r\n");
      out.write("                                ");

    if (!produtos.isEmpty()) {
        while (iProdutos.hasNext()) {
            Produto produto = (Produto) iProdutos.next();

                                
      out.write("\r\n");
      out.write("                                <tr>\r\n");
      out.write("                                    <td class=\"titulo\"><a href=\"javascript:Redirecionar('vendas.jsp?id=");
      out.print(produto.getId_prod());
      out.write("')\">");
      out.print(produto.getDescricao_prod());
      out.write("</a></td>\r\n");
      out.write("                                    <td><div align=\"center\">");
      out.print(produto.getCaracteristicas_prod());
      out.write("</div></td>\r\n");
      out.write("                                    <td><div align=\"center\">");
      out.print(produto.getDimensao_prod());
      out.write("</div></td>\r\n");
      out.write("                                    <td><div align=\"center\">");
      out.print(produto.getPeso_prod());
      out.write("\r\n");
      out.write("                                    </div></td>\r\n");
      out.write("                                    <td>                                      \r\n");
      out.write("                                      <div align=\"center\">\r\n");
      out.write("                                      ");

                                            try{    
                                            estoque = fachada.procurarEstoqueProduto(produto.getId_prod());
                                            String valorFormatado = vf.format(estoque.getValor_prod_est());
                                            
      out.write("\r\n");
      out.write("                                      R$ ");
      out.print(valorFormatado);
      out.write("\r\n");
      out.write("                                      ");

                                            }catch(Exception e){
      out.write("\r\n");
      out.write("                                      (0)\r\n");
      out.write("                                      ");
    
                                            }
                                            
      out.write("\r\n");
      out.write("                                  </div></td>\r\n");
      out.write("                      <td>\r\n");
      out.write("                                        <div align=\"center\">\r\n");
      out.write("                                            <strong>");

                                            try{    
                                            estoque = fachada.procurarEstoqueProduto(produto.getId_prod());
                                            
      out.print( estoque.getQuantidade_est());

                                            }catch(Exception e){
      out.write("\r\n");
      out.write("                                            (0)");
    
                                            }
                                            
      out.write("\r\n");
      out.write("                                    </strong>                                    </div></td>\r\n");
      out.write("                                </tr>\r\n");
      out.write("                                \r\n");
      out.write("                                ");

                                    }
      out.write("\r\n");
      out.write("                                    <tr><td colspan=\"6\" class=\"titulo\"><br><i>Clique no nome do produto para visualizar suas vendas.</i></td></tr>\r\n");
      out.write("                                    ");

                                } else {
                                
      out.write("\r\n");
      out.write("                                <tr><td colspan=\"6\" align=\"center\" class=\"titulo\">Não existem dados de Produtos cadastrado.</td></tr>                \r\n");
      out.write("                                \r\n");
      out.write("                                ");
            }
                                
      out.write("\r\n");
      out.write("                            </table>\r\n");
      out.write("                      <div align=\"center\"><br><br><input type=\"button\" value=\"Voltar\" onClick=\"javascript:location.href='index.jsp'\">&nbsp;&nbsp;&nbsp;<input type=\"button\" value=\"Imprimir\" onClick=\"javascript:window.print()\"><br>\r\n");
      out.write("                              <br>\r\n");
      out.write("                              <br>\r\n");
      out.write("                                \r\n");
      out.write("                        <br>\r\n");
      out.write("                <br>\r\n");
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
