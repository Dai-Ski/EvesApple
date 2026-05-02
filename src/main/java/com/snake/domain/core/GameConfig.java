package com.snake.domain.core;

public class GameConfig {
    public static final int COLS = 20;
    public static final int ROWS = 20;
    public static final int CELL_SIZE = 30;
    public static final int CANVAS_WIDTH = COLS * CELL_SIZE;
    public static final int CANVAS_HEIGHT = ROWS * CELL_SIZE;
    public static final long NANOS_PER_TICK = 125000000L;
    public static final String FONT_URL = "https://github.com/google/fonts/raw/main/ofl/pressstart2p/PressStart2P-Regular.ttf";
}
