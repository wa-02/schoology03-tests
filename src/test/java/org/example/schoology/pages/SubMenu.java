package org.example.schoology.pages;

import org.example.core.ui.AbstractPage;
import org.openqa.selenium.By;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SubMenu extends AbstractPage {

    Map<String, String> locatorLinkName = Stream.of(new String[][] {
            { "My Courses", "courses" }
    }).collect(Collectors.toMap(data -> data[0], data -> data[1]));


    public void clickViewListLink(final String menu) {
        action.click(By.cssSelector(String.format("a[href='/%s']", menu.toLowerCase())));
    }

    public void clickLink(final String linkName) {
        clickViewListLink(locatorLinkName.get(linkName));
    }

    public String getCourseTitle(final String courseName) {
        String xPath =  String.format("//div[text()='%s']", courseName);
        return action.getText(By.xpath(xPath));
    }
}
