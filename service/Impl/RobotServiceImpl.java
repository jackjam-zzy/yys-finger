package service.Impl;

import service.RobotService;
import util.YysUtil;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.Random;

/**
 * @Description: 实现类
 * @Author: zzy
 */
public class RobotServiceImpl implements RobotService {

    private Robot robot=new Robot();
    private Random random = new Random();

    public RobotServiceImpl() throws AWTException {
    }

    @Override
    public String getMousePosition(int time) throws AWTException {
        robot = null;
        robot = new Robot();
        //延迟time毫秒开始采集数据
        robot.delay(time);
        return YysUtil.GetMouseXY();
    }

    @Override
    public void hun10() throws AWTException {
//        robot = null;
//        robot = new Robot();
        //延迟5秒种开始脚本
        robot.delay(100);
        while (true){

            robot.mousePress(InputEvent.BUTTON1_MASK);
            //按下和松开的事件间隔是0.2-0.5秒
            double v = 0.2+ random.nextDouble()*(0.5-0.2);
            int pre = (int)v*1000;
            robot.delay(pre);
            robot.mouseRelease(InputEvent.BUTTON1_MASK);
            //下次重复按的时间间隔为2-4秒
            double v1 = 2+ random.nextDouble()*(4-2);
            int next = (int)v1*1000;
            robot.delay(next);
            System.out.println("间隔："+v+" ,下次重复"+v1);

        }

    }

    @Override
    public void hun10Plus() throws AWTException {

    }

    @Override
    public void clickInArea(String first_x, String first_y, String second_x, String second_y, String third_x, String third_y, String fourth_x, String fourth_y) throws AWTException {

        robot = null;
        robot = new Robot();
        robot.delay(1000);
        //获取当前屏幕的比例
        double scale = YysUtil.getScale(robot);
        //在某个区域循环随机点击
        while (true){
            //前往第1个点
            goToSpotByRandom(robot,"0.1","0.2",first_x,first_y,scale);
            //开始点击
            clickOnSpot(robot,"0.5","2");
            //前往第2个点
            goToSpotByRandom(robot,"0.1","0.2",second_x,second_y,scale);
            //开始点击
            clickOnSpot(robot,"0.5","2");
            //前往第3个点
            goToSpotByRandom(robot,"0.1","0.2",third_x,third_y,scale);
            //开始点击
            clickOnSpot(robot,"0.5","2");
            //前往第4个点
            goToSpotByRandom(robot,"0.1","0.2",fourth_x,fourth_y,scale);
            //开始点击
            clickOnSpot(robot,"0.5","2");
        }







//        //前往某个点
//        robot.delay(5000);
//        robot.mouseMove(0,0);
//        robot.delay(100);
//        int fourthX = (int) (Integer.parseInt(fourth_x)/scale);
//        int fourthY = (int) (Integer.parseInt(fourth_y)/scale);
//        robot.mouseMove(fourthX,fourthY);
    }


    /**
     * 前往某个点
     * @param robot 机器人对象
     * @param delayTimePre
     * @param delayTimeNext
     * @param SpotX 这个点的X坐标
     * @param SpotY 这个点的Y坐标
     * @param scale 屏幕缩放比
     */
    private void goToSpotByRandom(Robot robot,
                                  String delayTimePre,
                                  String delayTimeNext,
                                  String SpotX,
                                  String SpotY,
                                  double scale){

        //参数转换
        Double pre = Double.parseDouble(delayTimePre);
        Double next = Double.parseDouble(delayTimeNext);
        //坐标归零延时
        double v = pre + random.nextDouble()*(next - pre);//秒
        int vToInt = (int) (v*1000);//毫秒
        robot.delay(vToInt);

        System.out.println("坐标归零延时"+vToInt);

        //坐标归零
        robot.mouseMove(0,0);
        //前往指定坐标延时
        double v1 = pre + random.nextDouble()*(next - pre);//秒
        int vToInt1 = (int) (v1*1000);//毫秒
        robot.delay(vToInt1);

        System.out.println("前往指定坐标延时"+vToInt1);

        //?除以比例等于原来的坐标
        int firstX = (int) (Integer.parseInt(SpotX)/scale);
        int firstY = (int) (Integer.parseInt(SpotY)/scale);
        //前往指定坐标
        robot.mouseMove(firstX,firstY);
    }

    /**
     * 在某个坐标点击
     * @param robot
     * @param delayTimePre
     * @param delayTimeNext
     */
    private void clickOnSpot(Robot robot,
                             String delayTimePre,
                             String delayTimeNext){
        //参数转换
        Double pre = Double.parseDouble(delayTimePre);
        Double next = Double.parseDouble(delayTimeNext);
        //点击延迟时间
        double v = pre + random.nextDouble()*(next - pre);//秒
        int vToInt = (int) (v*1000);//毫秒

        System.out.println("点击延迟时间"+vToInt);

        robot.delay(vToInt);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        //松开延迟时间
        double v1 = pre + random.nextDouble()*(next - pre);//秒
        int vToInt1 = (int) (v1*1000);//毫秒

        System.out.println("松开延迟时间"+vToInt1);

        robot.delay(vToInt1);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
    }

}
