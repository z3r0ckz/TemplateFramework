package Base.Wrappers;

import Base.BaseElement;
import org.openqa.selenium.By;

public class Label extends BaseElement {
    public Label(By locator, String name) {
        super(locator, name);
    }
}
