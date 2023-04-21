package com.example.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class CustomTag extends SimpleTagSupport {

    private boolean loggedIn;

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();

        if (loggedIn) {
            out.write("Welcome back, user!");
        } else {
            out.write("Please log in to continue.");
        }
    }
}
