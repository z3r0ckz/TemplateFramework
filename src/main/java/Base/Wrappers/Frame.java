package Base.Wrappers;

import Base.BaseElement;
import org.openqa.selenium.By;

public class Frame extends BaseElement {
    public Frame(By locator, String name) {
        super(locator, name);
    }
}
