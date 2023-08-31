package com.cushon.steps;

import com.google.inject.Inject;
import com.cushon.cushon.contracts.TabBar;
import io.cucumber.java8.En;

import static org.junit.Assert.*;

public class TabBarSteps implements En {

    @Inject
    private TabBar tabBar;

    public TabBarSteps() {
        When("^user selects contributions on Tab Bar$", () -> {
            tabBar.selectTabItem("contributions")
        });
    }

}
