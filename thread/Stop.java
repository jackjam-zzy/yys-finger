package thread;

import service.Impl.RobotServiceImpl;
import service.RobotService;

import java.awt.*;

/**
 * @Description:
 * @Author: zzy
 */
public class Stop extends Thread {

    private RobotService robotService = new RobotServiceImpl();

    private volatile boolean stopFlag = false;

    public Stop() throws AWTException {
    }

    public boolean isStopFlag() {
        return stopFlag;
    }

    public void setStopFlag(boolean stopFlag) {
        this.stopFlag = stopFlag;
    }

    @Override
    public void run() {
        while (!stopFlag) {
            try {
                robotService.hun10();
            } catch (AWTException e) {
                e.printStackTrace();
            }
        }
    }
}
