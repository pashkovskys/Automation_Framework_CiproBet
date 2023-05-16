package pages.home;

import org.openqa.selenium.WebDriver;
import pages.AbstractBasePage;

public class HomePage extends AbstractBasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        openUrl(env);
    }

    public HeaderPage getHeaderPage() {
        return new HeaderPage(driver);
    }
}

