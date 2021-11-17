package com.viktor.minesweeper.exceptions;

public class NoBlocksThereException extends RuntimeException{
    public NoBlocksThereException(String s) {
        super(s);
    }
}
