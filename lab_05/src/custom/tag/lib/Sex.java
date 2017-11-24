package custom.tag.lib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class Sex extends TagSupport {
    @Override
    public int doStartTag() throws JspException {
        try {
            pageContext.getOut().write(String.format("<input type='radio' name='%s' value='male'> MALE </input><br />", id));
            pageContext.getOut().write(String.format("<input type='radio' name='%s' value='female'> FEMALE </input><br />", id));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return SKIP_BODY;
    }
}
