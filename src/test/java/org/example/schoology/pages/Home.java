package org.example.schoology.pages;

import org.example.core.ui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Home extends AbstractPage {

    /**
     * This only works for Courses and Groups
     * Resources and More menu has another behavior.
     *
     * @param menuName {courses or groups}
     * @return {@link SubMenu}
     */
    public SubMenu clickMenu(final String menuName) {
        By menu = By.xpath(String.format("//span[text()='%s']/parent::button", menuName));
        if (!action.isSubMenuExpanded(menu)) {
            action.click(menu);
        }

        return new SubMenu();
    }

}
