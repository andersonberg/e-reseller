package org.apache.jsp.relatorios;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import util.Mensagens;
import produto.Produto;
import cliente.Cliente;
import fachada.Fachada;
import java.util.*;

public final class gerencial_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    Fachada fachada = (Fachada) session.getAttribute("FACHADA");
    //DADOS DE PRODUTO
    Collection produtos = fachada.procurarProdutos();
    Iterator iProdutos = produtos.iterator();

//DADOS DE CLIENTE
    Collection clientes = fachada.procurarClientes();
    Iterator iClientes = clientes.iterator();


      out.write("\r\n");
      out.write("<SCRIPT language=JavaScript>\r\n");
      out.write("    function maskIt(w,e,m,r,a){        // Cancela se o evento for Backspace   \r\n");
      out.write("        if (!e) \r\n");
      out.write("            var e = window.event    \r\n");
      out.write("        if (e.keyCode) \r\n");
      out.write("            code = e.keyCode;    \r\n");
      out.write("        else if (e.which) \r\n");
      out.write("            code = e.which;        \r\n");
      out.write("        // Variáveis da função    \r\n");
      out.write("        var txt  = (!r) ? w.value.replace(/[^\\d]+/gi,'') : w.value.replace(/[^\\d]+/gi,'').reverse();    \r\n");
      out.write("        var mask = (!r) ? m : m.reverse();    \r\n");
      out.write("        var pre  = (a ) ? a.pre : \"\";    \r\n");
      out.write("        var pos  = (a ) ? a.pos : \"\";    \r\n");
      out.write("        var ret  = \"\";    \r\n");
      out.write("        if(code == 9 || code == 8 || txt.length == mask.replace(/[^#]+/g,'').length) \r\n");
      out.write("            return false;    \r\n");
      out.write("        // Loop na máscara para aplicar os caracteres    \r\n");
      out.write("        for(var x=0,y=0, z=mask.length;x<z && y<txt.length;){        \r\n");
      out.write("            if(mask.charAt(x)!='#'){            \r\n");
      out.write("                ret += mask.charAt(x); x++;        \r\n");
      out.write("            } else{            \r\n");
      out.write("                ret += txt.charAt(y); \r\n");
      out.write("                y++; \r\n");
      out.write("                x++;        \r\n");
      out.write("            }    }        \r\n");
      out.write("        // Retorno da função    \r\n");
      out.write("        ret = (!r) ? ret : ret.reverse()        \r\n");
      out.write("        w.value = pre+ret+pos;\r\n");
      out.write("    }\r\n");
      out.write(" \r\n");
      out.write("</SCRIPT>\r\n");
      out.write("<html><head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>");
      out.print(msn.getMn_Titulo_Site());
      out.write("</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <form name=\"frmMain\" method=\"post\" action=\"vendas.jsp\">\">\r\n");
      out.write("            <input type=\"hidden\" id=\"tipo\" name=\"tipo\" value=\"3\">\r\n");
      out.write("            <center>\r\n");
      out.write("                <table>\r\n");
      out.write("                    <tr><td width=\"417\" align=\"left\"><br>\r\n");
      out.write("                    <br><br><br><br><br><br><br><br><br><a href=\"../sistema.jsp\">Home</a></td></tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td align=\"center\" class=\"titulo_topo\"> Detalhamento de Vendas</td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    \r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td align=\"right\"> <font color=\"#FF0000\">* campos Obrigatórios</font></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr><td><br>\r\n");
      out.write("                            Produto<font color=\"#FF0000\">*</font>:<br><select name=\"id\" id=\"id\">\r\n");
      out.write("                                ");

    if (!produtos.isEmpty()) {
        while (iProdutos.hasNext()) {
            Produto produto = (Produto) iProdutos.next();
                                
      out.write("<option value=\"");
      out.print(produto.getId_prod());
      out.write('"');
      out.write('>');
      out.print(produto.getDescricao_prod());
      out.write("</option>");

                                    }
                                } else {
      out.write("\r\n");
      out.write("                                <option value=\"0\">Não Existem produtos Cadastrados</option>\r\n");
      out.write("                                ");
}
      out.write("\r\n");
      out.write("                    </select></td></tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td><br>Cliente (<em>Opcional</em>):<br>\r\n");
      out.write("                            <select name=\"cmbCliente\" id=\"id\"><option value=\"0\">--- Todos os Cliente ---</option>\r\n");
      out.write("                                ");
 if (!clientes.isEmpty()) {
        while (iClientes.hasNext()) {
            Cliente cliente = (Cliente) iClientes.next();
                                
      out.write("<option value=\"");
      out.print(cliente.getId_cli());
      out.write('"');
      out.write('>');
      out.print(cliente.getNome_cli());
      out.write("</option>");

     }
 } else {
      out.write("<option value=\"\">Não existem Clientes cadastrados</option>");
}
      out.write("\r\n");
      out.write("                    </select></td></tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td><br>Período<font color=\"#FF0000\">*</font>: (<em>formato dd/mm/aaaa</em>)<br>\r\n");
      out.write("                    <input type=\"text\" name=\"dtInicial\" maxlength=\"10\" size=\"20\" onkeyup=\"maskIt(this,event,'##/##/####')\" > a <input type=\"text\" name=\"dtFinal\" maxlength=\"10\" size=\"20\" onkeyup=\"maskIt(this,event,'##/##/####')\" ></td></tr>\r\n");
      out.write("                    \r\n");
      out.write("                    <tr><td align=\"center\"><div align=\"center\"><br><br><input type=\"button\" value=\"Voltar\" onClick=\"javascript:location.href='index.jsp'\">&nbsp;&nbsp;&nbsp;<input type=\"submit\" value=\"Consultar\" ><br>\r\n");
      out.write("                            <br>\r\n");
      out.write("                            <br>\r\n");
      out.write("                            \r\n");
      out.write("                            <br>\r\n");
      out.write("                    <br></td></tr>\r\n");
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
