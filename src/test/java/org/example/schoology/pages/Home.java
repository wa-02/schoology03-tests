package org.example.schoology.pages;

import org.example.core.ui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home extends AbstractPage {

    @FindBy(css = "[data-sgy-sitenav='header-my-account-menu'] button")
    private WebElement myAccountMenuButton;

    /**
     * This only works for Courses and Groups
     * Resources and More menu has another behavior.
     *
     * @param menuName {courses or groups}
     * @return {@link SubMenu}
     */
    public SubMenu clickMenu(final String menuName) {
        action.click(By.xpath(String.format("//a[text()='%s']", menuName)));
        return new SubMenu();
    }

    public SubMenu clickProfileMenu() {
        action.click(myAccountMenuButton);
        return new SubMenu();
    }
}
