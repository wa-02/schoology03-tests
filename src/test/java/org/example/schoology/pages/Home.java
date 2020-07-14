package org.example.schoology.pages;

import org.example.core.ui.AbstractPage;
import org.openqa.selenium.By;

public class Home extends AbstractPage {

    /**
     * This only works for Courses and Groups
     * Resources and More menu has another behavior.
     *
     * @param menuName {courses or groups}
     * @return {@link SubMenu}
     */
    public SubMenu clickDropdownMenu(final String menuName) {
        By menu = By.xpath(String.format("//span[text()='%s']/parent::button", menuName));
        if (!action.isSubMenuExpanded(menu)) {
            action.click(menu);
        }
        return new SubMenu();
    }

    public SubMenu clickMenu(final String menuName) {
        if (menuName.equals("Courses") || menuName.equals("Groups")) {
            clickDropdownMenu(menuName);
        } else {
            action.click(By.xpath(String.format("//a[text()='%s']", menuName)));
        }

        return new SubMenu();
    }

}
