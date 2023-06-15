import javax.swing.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.io.*;

public class Main extends JFrame implements ActionListener { //форма

    public static int i = 0;
    public static boolean svobod;


    static JFrame rv; //выбор зарегаться или войти
    static JFrame rf; //окошко регистрации
    static JButton vrf; //кнопка регистрацию
    static JButton vfv; //кнопка вход
    static JFrame vf; //окошко входа
    static JTextField rtl; //поле для логина при регистрации
    static JTextField rtp; //поле для пароля при регистрации
    static JTextField vtl; //поле для логина при регистрации
    static JTextField vtp; //поле для пароля при регистрации
    static JButton rb; //кнопка принять при регистрации
    static JButton vb; //кнопка принять при входе
    static JButton rg; //кнопка авто генерации пароля
    static String vibor;

    static String passv = "";

    public static void main(String[] args) {
        Main listen = new Main();

//Окошко выбора действия

        rv = new JFrame ("Выбор");
        vrf = new JButton ("Регистрация");
        vfv = new JButton ("Вход");


        vrf.addActionListener(listen);
        vfv.addActionListener(listen);

        vrf.setBounds(100, 130, 200, 20);
        vfv.setBounds(100, 155, 200, 20);

        rv.add(vrf);
        rv.add(vfv);

        rv.setSize(400, 400);
        rv.setLayout(null);
        rv.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Main lis = new Main();
        vibor = e.getActionCommand();
        if (vibor == "Регистрация")
        {
            rf = new JFrame("Регистрация");
            rtl = new JTextField("Логин");
            rtp = new JTextField("Пароль");
            rg = new JButton("Сгенерировать пароль");
            rb = new JButton("Зарегистрироваться");


            rg.addActionListener(lis);
            rb.addActionListener(lis);

            rtl.setBounds(100, 130, 200, 20);
            rtp.setBounds(100, 155, 200, 20);
            rg.setBounds(100, 180, 200, 20);
            rb.setBounds(100, 215, 200, 20);

            rf.add(rg);
            rf.add(rb);
            rf.add(rtl);
            rf.add(rtp);


            rf.setSize(400, 400);
            rf.setLayout(null);
            rf.setVisible(true);
        }

        if (vibor == "Сгенерировать пароль") {
            String porr = null;
            try {
                porr = password.bazpassrandom();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (NoSuchAlgorithmException ex) {
                throw new RuntimeException(ex);
            }
            rtp.setText(porr);
        }

        if (vibor=="Зарегистрироваться")
        {
            svobod = false;
            String log = null;
            if (svobod == false) // свобода заходит с фолс, меняетс на тру, и если нет совпадение выходит с тру
            {
                log = rtl.getText();
                try {
                    login.baztruelog(log);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }

            if (svobod == true) {
                try {
                    login.bazlog(log);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                svobod = false;
                if (svobod == false)
                {
                    String pass = rtp.getText();
                    try {
                        password.bazpass(pass);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    } catch (NoSuchAlgorithmException ex) {
                        throw new RuntimeException(ex);
                    }
                    if (svobod == true)
                    {
                        rf.setVisible(false);
                    }
                }
            }
        }
        if (vibor == "Вход")
        {
            vf = new JFrame("Вход");
            vtl = new JTextField("Логин");
            vtp = new JTextField("Пароль");
            vb = new JButton("Войти");

            vb.addActionListener(lis);

            vtl.setBounds(100, 130, 200, 20);
            vtp.setBounds(100, 155, 200, 20);
            vb.setBounds(100, 180, 200, 20);

            vf.add(vb);
            vf.add(vtl);
            vf.add(vtp);


            vf.setSize(400, 400);
            vf.setLayout(null);
            vf.setVisible(true);
        }

        passv = ""; //не инициализируем тут чтобы не кидало ошибку повторной инициализации
        if (vibor=="Войти")
        {
            String logv = vtl.getText();
            try {
                i = login.vhodl(logv);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

            passv = vtp.getText();
            try {
                if (password.vhodp(passv) == true) {
                    System.out.println("Вход выполнен успешно");
                } else {
                    System.out.println("неверный логин или пароль");
                }
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (NoSuchAlgorithmException ex) {
                throw new RuntimeException(ex);
            }
            svobod = true;
            loger.savetime();
            if (svobod == false)
            {
                vf.setVisible(false);
            }
        }
    }
}
