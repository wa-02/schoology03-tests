package org.example.schoology.pages.courses;

import org.example.core.ui.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JoinACourse extends AbstractPage {

    @FindBy(css = "input#edit-invite-code")
    private WebElement accessCodeTextField;

    @FindBy(css = "input#edit-submit")
    private WebElement joinButton;

    public void joinCourse(String code) {
        setAccessCode(code);
        action.click(joinButton);
    }

    public void setAccessCode(String code) {
        action.setText(accessCodeTextField, code);
    }
}
