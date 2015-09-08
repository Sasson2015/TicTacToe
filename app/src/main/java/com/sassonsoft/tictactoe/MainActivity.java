package com.sassonsoft.tictactoe;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public ImageView iv0,iv1,iv2,iv3,iv4,iv5,iv6,iv7,iv8;
    public XY gameBoard=new XY();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeVariables();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        ImageView iv=(ImageView) view;

        if(gameBoard.getDraw()&&iv.getTag().toString().equals("empty")) {
            playGame(iv, R.drawable.x, false, "איקס", Integer.parseInt(iv.getContentDescription().toString()));

        }

        else if(!gameBoard.getDraw()&&iv.getTag().toString().equals("empty")) {
            playGame(iv,R.drawable.circle,true,"עיגול",Integer.parseInt(iv.getContentDescription().toString()));
        }

    }

    private void newGameboard() {
        gameBoard=new XY();

        iv0.setTag("empty");
        iv1.setTag("empty");
        iv2.setTag("empty");
        iv3.setTag("empty");
        iv4.setTag("empty");
        iv5.setTag("empty");
        iv6.setTag("empty");
        iv7.setTag("empty");
        iv8.setTag("empty");

        iv0.setImageResource(R.drawable.blank);
        iv1.setImageResource(R.drawable.blank);
        iv2.setImageResource(R.drawable.blank);
        iv3.setImageResource(R.drawable.blank);
        iv4.setImageResource(R.drawable.blank);
        iv5.setImageResource(R.drawable.blank);
        iv6.setImageResource(R.drawable.blank);
        iv7.setImageResource(R.drawable.blank);
        iv8.setImageResource(R.drawable.blank);
    }

    private void playGame(ImageView iv,int imageResource,boolean drawNext,String drawNow, int imagIndex) {
        iv.setImageResource(imageResource);
        iv.setTag(imageResource);
        gameBoard.setDraw(drawNext);
        gameBoard.setImageTags(imagIndex,imageResource);

        if(gameBoard.checkTie()) {
            final MediaPlayer mPlayer = MediaPlayer.create(MainActivity.this, R.raw.crowd_boo);
            mPlayer.start();
            AlertDialog.Builder builder=new AlertDialog.Builder(this);
            builder.setMessage("אף אחד לא ניצח.");
            builder.setTitle("תיקו!!!");
            builder.setIcon(R.mipmap.information_icon);
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    newGameboard();
                    mPlayer.stop();
                }
            });
            builder.create();
            builder.show();
        }

        else if(gameBoard.checkWin()) {
            final MediaPlayer mPlayer = MediaPlayer.create(MainActivity.this, R.raw.claps);
            mPlayer.start();
            AlertDialog.Builder builder=new AlertDialog.Builder(this);
            builder.setMessage("כל הכבוד מר "+drawNow + " ניצחת את המשחק.");
            builder.setTitle("ניצחון!!!");
            builder.setIcon(R.mipmap.information_icon);
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    newGameboard();
                    mPlayer.stop();
                }
            });
            builder.create();
            builder.show();
        }
    }

    private void initializeVariables() {
        iv0=(ImageView) findViewById(R.id.iv0);
        iv1=(ImageView) findViewById(R.id.iv1);
        iv2=(ImageView) findViewById(R.id.iv2);
        iv3=(ImageView) findViewById(R.id.iv3);
        iv4=(ImageView) findViewById(R.id.iv4);
        iv5=(ImageView) findViewById(R.id.iv5);
        iv6=(ImageView) findViewById(R.id.iv6);
        iv7=(ImageView) findViewById(R.id.iv7);
        iv8=(ImageView) findViewById(R.id.iv8);

        iv0.setOnClickListener(this);
        iv1.setOnClickListener(this);
        iv2.setOnClickListener(this);
        iv3.setOnClickListener(this);
        iv4.setOnClickListener(this);
        iv5.setOnClickListener(this);
        iv6.setOnClickListener(this);
        iv7.setOnClickListener(this);
        iv8.setOnClickListener(this);
    }
}
