package org.example.schoology.hooks;

import io.cucumber.java.After;
import org.example.core.ScenarioContext;
import org.example.core.ui.DriverFactory;
import org.example.schoology.pages.DeletePopup;
import org.example.schoology.pages.Home;
import org.example.schoology.pages.SubMenu;
import org.example.schoology.pages.resources.MyResources;

import java.util.Arrays;

public class ResourceHooks {

    private ScenarioContext context;

    public ResourceHooks(final ScenarioContext context) {
        this.context = context;
    }

    @After(value = "@deleteResource")
    public void deleteResource() {
        DriverFactory.getDriver().get("https://app.schoology.com");
        new Home().clickMenu("Resources");
        Arrays.stream(context.getValue("ResourceKey").split(",")).forEach(resource -> {
            DeletePopup deletePopup = new MyResources().deleteResource(resource);
            deletePopup.clickDeleteButton();
        });
    }

}
