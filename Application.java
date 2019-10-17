
import service.Impl.RobotServiceImpl;
import service.RobotService;
import thread.Stop;
import util.YysUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Map;


/**
 * @Description: 客户端
 * @Author: zzy
 */
public class Application {

    public static void main(String[] args) throws AWTException {

        RobotService robotService = new RobotServiceImpl();

        JFrame frame = new JFrame("🦅🐏🦁-金✋☞1.0");
        frame.setResizable(false);//设置窗体是否可以改变大小
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//窗体关闭就退出
        frame.setBounds(490,270,980,540);
        JPanel panel = new JPanel();
//        panel.setBackground(Color.BLACK);
        frame.add(panel);
        frame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {

            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
        panel.setLayout(null);


        JLabel jl_x = new JLabel("x 坐标:");
        jl_x.setBounds(10,20,50,25);
        panel.add(jl_x);

        JTextField jt_x = new JTextField(20);
        jt_x.setBounds(70,20,150,25);
        panel.add(jt_x);

        JLabel jl_y = new JLabel("y 坐标:");
        jl_y.setBounds(230,20,50,25);
        panel.add(jl_y);

        JTextField jt_y = new JTextField(20);
        jt_y.setBounds(290,20,150,25);
        panel.add(jt_y);

        JLabel jl_tips_pre = new JLabel("(点击后");
        jl_tips_pre.setBounds(650,20,50,25);
        panel.add(jl_tips_pre);
        JLabel jl_tips_next = new JLabel("秒后会获得当前鼠标位置坐标)");
        jl_tips_next.setBounds(720,20,250,25);
        panel.add(jl_tips_next);
        JTextField jt_time = new JTextField("3");
        jt_time.setBounds(700,20,20,25);
        panel.add(jt_time);


        JButton jb_get = new JButton("获取鼠标当前坐标");
        jb_get.setBounds(490,20,150,25);
        panel.add(jb_get);
        jb_get.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String text = jt_time.getText();
                    int milliSecond;
                    if(text.contains(".")){
                        milliSecond = (int) (Double.parseDouble(text)*1000);
                    }else {
                        milliSecond = Integer.parseInt(text)*1000;
                    }
                    String s = robotService.getMousePosition(milliSecond);
                    String[] split = s.split(",");
                    jt_x.setText(split[0]);
                    jt_y.setText(split[1]);

                } catch (AWTException e1) {
                    e1.printStackTrace();
                }
            }
        });


        //分割线
        JSeparator sep = new JSeparator(SwingConstants.CENTER);
        sep.setBackground(new Color(153,153,153));
        sep.setBounds(5,50,960,1);
        panel.add(sep);

        JButton jb_begin = new JButton("自动魂10开启");
        jb_begin.setBounds(490,300,150,25);
        panel.add(jb_begin);

        jb_begin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                try {
//                    Stop stop = new Stop();
//                    stop.setName("魂10");
//                    stop.start();
//
//                } catch (AWTException e1) {
//                    e1.printStackTrace();
//                }

                new Thread(new Thread(){
                    @Override
                    public void run() {
                            try {
                                robotService.hun10();
                            } catch (AWTException e1) {
                                e1.printStackTrace();
                            }
                    }
                },"一直原地单点线程").start();
            }
        });
        jb_begin.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
//                    YysUtil.getThreadByName("一直原地单点线程");
                    System.exit(0);
//                    YysUtil.getThreadByName("一直原地单点线程").interrupt();
//                    try {
//                        YysUtil.getThreadByName("一直原地单点线程").join();
//                    } catch (InterruptedException e1) {
//                        e1.printStackTrace();
//                    }
//                    Map<Thread, StackTraceElement[]> maps = Thread.getAllStackTraces();
//                    System.out.println(maps.keySet());
//                    thread1.exit = true;  // 终止线程thread
                }

            }
        });



        JLabel jl_fir = new JLabel("坐标1:  (x,y)");
        jl_fir.setBounds(10,95,80,25);
        panel.add(jl_fir);

        JTextField jt_fir_x = new JTextField(4);
        jt_fir_x.setBounds(100,95,50,25);
        panel.add(jt_fir_x);

        JTextField jt_fir_y = new JTextField(4);
        jt_fir_y.setBounds(160,95,50,25);
        panel.add(jt_fir_y);


        JLabel jl_sec = new JLabel("坐标2:  (x,y)");
        jl_sec.setBounds(230,95,80,25);
        panel.add(jl_sec);

        JTextField jt_sec_x = new JTextField(4);
        jt_sec_x.setBounds(320,95,50,25);
        panel.add(jt_sec_x);

        JTextField jt_sec_y = new JTextField(4);
        jt_sec_y.setBounds(380,95,50,25);
        panel.add(jt_sec_y);




        JLabel jl_thi = new JLabel("坐标3:  (x,y)");
        jl_thi.setBounds(10,130,80,25);
        panel.add(jl_thi);

        JTextField jt_thi_x = new JTextField(4);
        jt_thi_x.setBounds(100,130,50,25);
        panel.add(jt_thi_x);

        JTextField jt_thi_y = new JTextField(4);
        jt_thi_y.setBounds(160,130,50,25);
        panel.add(jt_thi_y);


        JLabel jl_four = new JLabel("坐标4:  (x,y)");
        jl_four.setBounds(230,130,80,25);
        panel.add(jl_four);

        JTextField jt_four_x = new JTextField(4);
        jt_four_x.setBounds(320,130,50,25);
        panel.add(jt_four_x);

        JTextField jt_four_y = new JTextField(4);
        jt_four_y.setBounds(380,130,50,25);
        panel.add(jt_four_y);


        JButton jb_auto_add1 = new JButton("坐标1自动取值");
        jb_auto_add1.setBounds(490,95,140,25);
        panel.add(jb_auto_add1);
        jb_auto_add1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String s = robotService.getMousePosition(1500);
                    String[] split = s.split(",");
                    jt_fir_x.setText(split[0]);
                    jt_fir_y.setText(split[1]);
                } catch (AWTException e1) {
                    e1.printStackTrace();
                }
            }
        });
        JButton jb_auto_add2 = new JButton("坐标2自动取值");
        jb_auto_add2.setBounds(640,95,140,25);
        panel.add(jb_auto_add2);
        jb_auto_add2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String s = robotService.getMousePosition(1400);
                    String[] split = s.split(",");
                    jt_sec_x.setText(split[0]);
                    jt_sec_y.setText(split[1]);
                } catch (AWTException e1) {
                    e1.printStackTrace();
                }
            }
        });
        JButton jb_auto_add3 = new JButton("坐标3自动取值");
        jb_auto_add3.setBounds(490,130,140,25);
        panel.add(jb_auto_add3);
        jb_auto_add3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String s = robotService.getMousePosition(1450);
                    String[] split = s.split(",");
                    jt_thi_x.setText(split[0]);
                    jt_thi_y.setText(split[1]);
                } catch (AWTException e1) {
                    e1.printStackTrace();
                }
            }
        });
        JButton jb_auto_add4 = new JButton("坐标4自动取值");
        jb_auto_add4.setBounds(640,130,140,25);
        panel.add(jb_auto_add4);
        jb_auto_add4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String s = robotService.getMousePosition(1460);
                    String[] split = s.split(",");
                    jt_four_x.setText(split[0]);
                    jt_four_y.setText(split[1]);
                } catch (AWTException e1) {
                    e1.printStackTrace();
                }
            }
        });

        JButton jb_area = new JButton("开始区域循环点击功能");
        jb_area.setBounds(790,95,170,60);
        panel.add(jb_area);
        jb_area.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            robotService.clickInArea(
                                    jt_fir_x.getText(),jt_fir_y.getText(),
                                    jt_sec_x.getText(),jt_sec_y.getText(),
                                    jt_thi_x.getText(),jt_thi_y.getText(),
                                    jt_four_x.getText(),jt_four_y.getText());
                        } catch (AWTException e1) {
                            e1.printStackTrace();
                        }
                    }
                }).start();
            }
        });
        jb_area.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
                    System.exit(0);
                }
            }
        });


        frame.setVisible(true);//设置可见

    }





}
