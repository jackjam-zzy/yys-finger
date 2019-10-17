package util;

import java.awt.*;
import java.text.DecimalFormat;

/**
 * @Description:
 * @Author: zzy
 */
public class YysUtil {

    //通过线程名字得到线程对象
    public static Thread getThreadByName(String threadName) {
        for(Thread t : Thread.getAllStackTraces().keySet()) {
        if (t.getName().equals(threadName)) {
            System.out.println(t.getName());
            return t;
            }
        }
        return null;
    }

    public static String GetMouseXY(){
        Point point = MouseInfo.getPointerInfo().getLocation();
        return point.x + "," + point.y ;
    }

    public static String getScreen(){
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        return screen.width+","+screen.height;
    }

    public static double getScale(Robot robot){
        //获取当前屏幕的比例


        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = screen.width/2;  //中心点x坐标
        int y = screen.height/2;  //中心点y坐标

        robot.delay(100);
        robot.mouseMove(0,0);
        robot.delay(100);
        robot.mouseMove(x,y);
        robot.delay(100);
        Point point = MouseInfo.getPointerInfo().getLocation();
        int pointX = point.x;
        int pointY = point.y;

        DecimalFormat rr = new DecimalFormat("0.00");//格式化小数
//        String scale;
        String aaa = rr.format((double)pointX/x);//返回的是String类型
        double ee = Double.parseDouble(aaa);
        System.out.println(ee);
        return ee;


//        if(x>=pointX && y>=pointY){  //放大情况
//            scale = rr.format((double)pointX/x);//返回的是String类型
//            return Double.parseDouble(scale);
//        }else{  //缩小情况
//            scale = rr.format(x/(double)pointX);//返回的是String类型
//            return Double.parseDouble(scale);
//        }
    }

}
