



import javax.swing.*;

import java.awt.*;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.text.SimpleDateFormat;

import java.util.Date;



public class Clock extends JLabel implements ActionListener {





    private String type;

    private SimpleDateFormat sdf;



    public Clock(String type) {

        this.type = type;

        setForeground(Color.MAGENTA);



        switch (type) {

            case "date" : sdf = new SimpleDateFormat("  dd MMMM yyyy");

                setFont(new Font("sans-serif", Font.PLAIN, 16));

                setHorizontalAlignment(SwingConstants.LEFT);

                break;

            case "time" : sdf = new SimpleDateFormat("hh:mm:ss a");

                setFont(new Font("sans-serif", Font.PLAIN, 35));

                setHorizontalAlignment(SwingConstants.CENTER);

                break;

            case "day"  : sdf = new SimpleDateFormat("EEEE  ");

                setFont(new Font("sans-serif", Font.PLAIN, 16));

                setHorizontalAlignment(SwingConstants.RIGHT);

                break;

            default     : sdf = new SimpleDateFormat();

                break;

        }



        Timer t = new Timer(1000, this);

        t.start();

    }



    public void actionPerformed(ActionEvent ae) {
        Date d = new Date();

        setText(sdf.format(d));

    }

}