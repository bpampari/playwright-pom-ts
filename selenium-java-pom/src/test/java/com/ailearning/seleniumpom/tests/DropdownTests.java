package com.ailearning.seleniumpom.tests;

import com.ailearning.seleniumpom.base.BaseTest;
import com.ailearning.seleniumpom.data.TestData;
import com.ailearning.seleniumpom.pages.DropdownPage;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DropdownTests extends BaseTest {
    @Test
    void tc003_shouldDisplayAllOptionsAndAllowSelectingOption1() {
        DropdownPage dropdownPage = new DropdownPage(driver);
        dropdownPage.gotoPage();

        List<String> allOptions = dropdownPage.getAllOptions();
        Assertions.assertTrue(allOptions.contains(TestData.DROPDOWN_PLACEHOLDER));
        Assertions.assertTrue(allOptions.contains(TestData.DROPDOWN_OPTION_1));
        Assertions.assertTrue(allOptions.contains(TestData.DROPDOWN_OPTION_2));

        dropdownPage.selectOption(TestData.DROPDOWN_OPTION_1);
        Assertions.assertEquals(TestData.DROPDOWN_OPTION_1, dropdownPage.getSelectedOption());
    }

    @Test
    void tc003b_shouldAllowSwitchingBetweenOptions() {
        DropdownPage dropdownPage = new DropdownPage(driver);
        dropdownPage.gotoPage();

        dropdownPage.selectOption(TestData.DROPDOWN_OPTION_1);
        Assertions.assertEquals(TestData.DROPDOWN_OPTION_1, dropdownPage.getSelectedOption());

        dropdownPage.selectOption(TestData.DROPDOWN_OPTION_2);
        Assertions.assertEquals(TestData.DROPDOWN_OPTION_2, dropdownPage.getSelectedOption());
    }
}
