package com.sassonsoft.tictactoe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sasson on 20/08/2015.
 */
public class XY {
    private List<Integer> imageTags=new ArrayList<>();
    private boolean draw=true;
    private int gameBoard[]=new int[9];

    public XY() {
        for(int i=0;i<9;i++) {
            imageTags.add(i,i);
            gameBoard[i]=i;
        }
    }


    public boolean getDraw() {
        return draw;
    }

    public void setDraw(boolean draw) {
        this.draw = draw;
    }

    public void setImageTags(int index,Integer tag) {
        imageTags.set(index,tag);
    }

    public boolean checkWin() {


        for(int i=0;i<9;i++) {
            gameBoard[i]=imageTags.get(i);
        }

        if((gameBoard[0]==gameBoard[1]&&gameBoard[1]==gameBoard[2])||
                (gameBoard[3]==gameBoard[4]&&gameBoard[4]==gameBoard[5])||
                (gameBoard[6]==gameBoard[7]&&gameBoard[7]==gameBoard[8])||
                (gameBoard[0]==gameBoard[3]&&gameBoard[3]==gameBoard[6])||
                (gameBoard[1]==gameBoard[4]&&gameBoard[4]==gameBoard[7])||
                (gameBoard[2]==gameBoard[5]&&gameBoard[5]==gameBoard[8])||
                (gameBoard[0]==gameBoard[4]&&gameBoard[4]==gameBoard[8])||
                (gameBoard[2]==gameBoard[4]&&gameBoard[4]==gameBoard[6]))
            return true;
        return false;
    }

    public boolean checkTie() {
        int count=0;
        for(int i=0;i<9;i++) {
            if(imageTags.get(i)!=i)
                count++;
        }
        if(count==9)
            return true;
        else
            return false;
    }

}
