package org.eugens21.user_interface.object;

import org.openqa.selenium.WebElement;

import java.util.List;

public interface Menu {

    void openElement(String element);
    List<WebElement> getList();

}
