package com.viktor.minesweeper.data;


import java.util.ArrayList;
import java.util.List;

public class Block {
    private int x;
    private int y;
    private boolean bomb = false;
    private boolean flag = false;
    private boolean open = false;
    private Integer number;
    private static Integer MAX_NUMBER = 3;


    public static Block forStart(int x, int y) {
        Block block = new Block();
        block.setX(x);
        block.setY(y);
        return block;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;

    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isBomb() {
        return bomb;
    }

    public void setBomb(boolean bomb) {
        this.bomb = bomb;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }


    @Override
    public String toString() {
        return "Block{" +
                "x=" + x +
                ", y=" + y +
                ", bomb=" + bomb +
                ", flag=" + flag +
                ", number=" + number +
                '}';
    }
}
