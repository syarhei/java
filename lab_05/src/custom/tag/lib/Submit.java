package custom.tag.lib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class Submit extends TagSupport {
    @Override
    public int doStartTag() throws JspException {
        try {
            pageContext.getOut().write("<input type='submit' value='Ok' />");
            pageContext.getOut().write("<input type='reset' value='Cancel' /> <br />");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {
        return EVAL_PAGE;
    }
}
