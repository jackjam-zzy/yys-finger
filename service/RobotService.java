package service;

import java.awt.*;

/**
 * @Description: 接口
 * @Author: zzy
 */
public interface RobotService {

//    /**
//     *专门用来测试的方法
//    * */
//    void test();

    /**
     * 循环获取当前鼠标位置的像素值（位置）
     * @param time 获得坐标的延迟时间（毫秒），如果设为2000，则延迟2秒后获得当前鼠标位置坐标
     * @return
     * @throws AWTException
     */
    String getMousePosition(int time) throws AWTException;

    /**
     * 魂十单刷，原地单点
     * */
    void hun10() throws AWTException;

    void hun10Plus() throws AWTException;

    /**
     *在某个范围随机重复点击
    * */
    void clickInArea(String first_x,String first_y,String second_x,String second_y,String third_x,String third_y,String fourth_x,String fourth_y) throws AWTException;
}
