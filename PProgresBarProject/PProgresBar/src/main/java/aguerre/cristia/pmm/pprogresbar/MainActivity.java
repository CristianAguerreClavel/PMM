package aguerre.cristia.pmm.pprogresbar;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;


public class MainActivity extends Activity {

    Button btnStartProgress;
    ProgressDialog progressBar;
    private int progressBarStatus = 0;
    private Handler progressBarHandler = new Handler();
    private int timeSleep = 50;//milisegundos
    private long fileSize = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addListenerOnButton();

    }

    public void addListenerOnButton() {

        btnStartProgress = (Button) findViewById(R.id.btnStartProgress);
        btnStartProgress.setOnClickListener(
                new OnClickListener() {

                    @Override
                    public void onClick(View v) {



                        // prepare for a progress bar dialog
                        progressBar = new ProgressDialog(v.getContext());
                        progressBar.setCancelable(true);
                        progressBar.setMessage("CARGANDO");
                        progressBar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                        progressBar.setProgress(0);
                        progressBar.setMax(100);
                        progressBar.show();

                        //reset progress bar status
                        progressBarStatus = 0;

                        //reset filesize
                        fileSize = 0;

                        new Thread(new Runnable() {
                            public void run() {
                                while (progressBarStatus < 100) {

                                    // process some tasks
                                    progressBarStatus = doSomeTasks();

                                    // your computer is too fast, sleep 0.5 second
                                    try {
                                        Thread.sleep(timeSleep);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }

                                    // Update the progress bar
                                    progressBarHandler.post(new Runnable() {
                                        public void run() {
                                            progressBar.setProgress(progressBarStatus);
                                        }
                                    });
                                }

                                // ok, file is downloaded,
                                if (progressBarStatus >= 100) {

                                    // sleep 2 seconds, so that you can see the 100%
                                    try {
                                        Thread.sleep(2000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }

                                    // close the progress bar dialog
                                    progressBar.dismiss();
                                }
                            }
                        }).start();

                    }

                });

    }

    // file download simulator... a really simple
    public int doSomeTasks() {

        while (fileSize <= 1000000) {

            fileSize++;

            if (fileSize == 90000) {
                return 0;
            }else if (fileSize == 91000) {
                return 1;
            }else if (fileSize == 92000) {
                return 2;
            }else if (fileSize == 93000) {
                return 3;
            }else if (fileSize == 94000) {
                return 4;
            }else if (fileSize == 95000) {
                return 5;
            }else if (fileSize == 96000) {
                return 6;
            }else if (fileSize == 97000) {
                return 7;
            }else if (fileSize == 98000) {
                return 8;
            }else if (fileSize == 99000) {
                return 9;
            }

            if (fileSize == 100000) {
                return 10;
            }else if (fileSize == 110000) {
                return 11;
            }else if (fileSize == 120000) {
                return 12;
            }else if (fileSize == 130000) {
                return 13;
            }else if (fileSize == 140000) {
                return 14;
            }else if (fileSize == 150000) {
                return 15;
            }else if (fileSize == 160000) {
                return 16;
            }else if (fileSize == 170000) {
                return 17;
            }else if (fileSize == 180000) {
                return 18;
            }else if (fileSize == 190000) {
                return 19;
            }

            else if (fileSize == 200000) {
                return 20;
            }else if (fileSize == 210000) {
                return 21;
            }else if (fileSize == 220000) {
                return 22;
            }
            else if (fileSize == 230000) {
                return 23;
            }
            else if (fileSize == 240000) {
                return 24;
            }
            else if (fileSize == 250000) {
                return 25;
            }
            else if (fileSize == 260000) {
                return 26;
            }
            else if (fileSize == 270000) {
                return 27;
            }
            else if (fileSize == 280000) {
                return 28;
            }
            else if (fileSize == 290000) {
                return 29;
            }

            else if (fileSize == 300000) {
                return 30;
            }else if (fileSize == 310000) {
                return 31;
            }else if (fileSize == 320000) {
                return 32;
            }
            else if (fileSize == 330000) {
                return 33;
            }
            else if (fileSize == 340000) {
                return 34;
            }
            else if (fileSize == 350000) {
                return 35;
            }
            else if (fileSize == 360000) {
                return 36;
            }
            else if (fileSize == 370000) {
                return 37;
            }
            else if (fileSize == 380000) {
                return 38;
            }
            else if (fileSize == 390000) {
                return 39;
            }


            else if (fileSize == 400000){
                return 40;
            }else if (fileSize == 410000) {
                return 41;
            }else if (fileSize == 420000) {
                return 42;
            }
            else if (fileSize == 430000) {
                return 43;
            }
            else if (fileSize == 440000) {
                return 44;
            }
            else if (fileSize == 450000) {
                return 45;
            }
            else if (fileSize == 460000) {
                return 46;
            }
            else if (fileSize == 470000) {
                return 47;
            }
            else if (fileSize == 480000) {
                return 48;
            }
            else if (fileSize == 490000) {
                return 49;
            }


            else if (fileSize == 500000){
                return 50;
            }else if (fileSize == 510000) {
                return 51;
            }else if (fileSize == 520000) {
                return 52;
            }
            else if (fileSize == 530000) {
                return 53;
            }
            else if (fileSize == 540000) {
                return 54;
            }
            else if (fileSize == 550000) {
                return 55;
            }
            else if (fileSize == 560000) {
                return 56;
            }
            else if (fileSize == 570000) {
                return 57;
            }
            else if (fileSize == 580000) {
                return 58;
            }
            else if (fileSize == 590000) {
                return 59;
            }

            else if (fileSize == 600000){
                return 60;
            }else if (fileSize == 610000) {
                return 61;
            }else if (fileSize == 620000) {
                return 62;
            }
            else if (fileSize == 630000) {
                return 63;
            }
            else if (fileSize == 640000) {
                return 64;
            }
            else if (fileSize == 650000) {
                return 65;
            }
            else if (fileSize == 660000) {
                return 66;
            }
            else if (fileSize == 670000) {
                return 67;
            }
            else if (fileSize == 680000) {
                return 68;
            }
            else if (fileSize == 690000) {
                return 69;
            }


            else if (fileSize == 700000){
                return 70;
            }else if (fileSize == 710000) {
                return 71;
            }else if (fileSize == 720000) {
                return 72;
            }
            else if (fileSize == 730000) {
                return 73;
            }
            else if (fileSize == 740000) {
                return 74;
            }
            else if (fileSize == 750000) {
                return 75;
            }
            else if (fileSize == 760000) {
                return 76;
            }
            else if (fileSize == 770000) {
                return 77;
            }
            else if (fileSize == 780000) {
                return 78;
            }
            else if (fileSize == 790000) {
                return 79;
            }


            else if (fileSize == 800000){
                return 80;
            }else if (fileSize == 810000) {
                return 81;
            }else if (fileSize == 820000) {
                return 82;
            }
            else if (fileSize == 830000) {
                return 83;
            }
            else if (fileSize == 840000) {
                return 84;
            }
            else if (fileSize == 850000) {
                return 85;
            }
            else if (fileSize == 860000) {
                return 86;
            }
            else if (fileSize == 870000) {
                return 87;
            }
            else if (fileSize == 880000) {
                return 88;
            }
            else if (fileSize == 890000) {
                return 89;
            }


            else if (fileSize == 900000){
                return 90;
            }else if (fileSize == 910000) {
                return 91;
            }else if (fileSize == 920000) {
                return 92;
            }
            else if (fileSize == 930000) {
                return 93;
            }
            else if (fileSize == 940000) {
                return 94;
            }
            else if (fileSize == 950000) {
                return 95;
            }
            else if (fileSize == 960000) {
                return 96;
            }
            else if (fileSize == 970000) {
                return 97;
            }
            else if (fileSize == 980000) {
                return 98;
            }
            else if (fileSize == 990000) {
                return 99;
            }


            else if (fileSize == 1000000){
                return 100;
            }


        }

        return 100;

    }

}