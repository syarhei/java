package custom.tag.lib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class Name extends TagSupport {
    private String id;
    @Override
    public void setId(String id) {
        this.id = id;
    }

    private String value;
    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public int doStartTag() throws JspException {

        try {
            pageContext.getOut().write(String.format("<input type='text' name='%s' value='%s' /> <br />", id, value));
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
