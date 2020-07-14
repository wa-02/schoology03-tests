package org.example.schoology.pages.profile;

import org.example.schoology.pages.ViewList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Map;

public class Notifications extends ViewList {

    @FindBy(css = ".clickable.reset-default")
    private WebElement turnOfAllNotificationsLink;

    private static final String NOTIFICATION_DROPDOWN_MENU = "//th[text()='%s']/ancestor::table//th[text()='%s']/ancestor::tr//a";
    private static final By NOTIFICATION_DROPDOWN_ICON = By.xpath("span[contains(@class, 'ui-selectmenu-icon')]");
    private static final By NOTIFICATION_DROPDOWN_STATUS = By.xpath("span[contains(@class, 'ui-selectmenu-status')]");

    public static final String NOTIFICATION_OPTION = "//ul[@id='%s']/li[contains(.,'%s')]";

    private Notifications setNotification(final Map<String, String> notification) {
        WebElement notificationDropDrownMenu = driver.findElement(
                By.xpath(String.format(NOTIFICATION_DROPDOWN_MENU, notification.get("section"),
                        notification.get("notification"))));
        action.scrollToElement(notificationDropDrownMenu);
        action.click(notificationDropDrownMenu.findElement(NOTIFICATION_DROPDOWN_ICON));
        String idMenu = notificationDropDrownMenu.getAttribute("id").replace("button", "menu");
        action.click(By.xpath(String.format(NOTIFICATION_OPTION, idMenu, notification.get("option"))));
        return this;
    }

    public Notifications setNotifications(final List<Map<String, String>> notifications) {
        notifications.forEach(this::setNotification);
        action.click(submitButton);
        return this;
    }

    public Notifications resetNotifications(){
        action.click(turnOfAllNotificationsLink);
        action.click(submitButton);
        return this;
    }

    public String getNotificationOptionSelected(final Map<String, String> notification) {
        WebElement notificationDropDrownMenu = driver.findElement(By.xpath(String.format(
                NOTIFICATION_DROPDOWN_MENU, notification.get("section"), notification.get("notification"))));
        return notificationDropDrownMenu.findElement(NOTIFICATION_DROPDOWN_STATUS).getText();
    }
}
