package perpus;

import java.awt.AWTException;
import java.awt.Robot;

public class uh {
    public void bot() throws AWTException, InterruptedException {
        Robot r = new Robot();
        r.keyPress(17);
        r.keyPress(76);
        r.keyRelease(17);
        r.keyRelease(76);
        Thread.sleep(500);
    }
}
