package Base.Wrappers;

import Base.BaseElement;
import org.openqa.selenium.By;

public class Button extends BaseElement {
    public Button(By locator, String name) {
        super(locator, name);
    }
}
