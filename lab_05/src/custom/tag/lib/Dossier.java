package custom.tag.lib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class Dossier extends TagSupport {
    @Override
    public int doStartTag() throws JspException {
        try {
            pageContext.getOut().write("<form action='ttt' method='POST'>");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return EVAL_BODY_INCLUDE;
    }

    @Override
    public int doEndTag() throws JspException {
        try {
            pageContext.getOut().write("</form>");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return EVAL_PAGE;
    }
}
