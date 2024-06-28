package com.sparta.g1;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

//This is a comment left by kian
public class App {
    public static void main(String[] args) {
        final Logger logger = AppLogger.getLogger(Level.ALL, Level.INFO, true);

        try {
            AppWindow appWindow = new AppWindow();
        }
        catch (IOException e){
            logger.log(Level.SEVERE, "Exception thrown when opening app window");
            throw new RuntimeException(e);
        }
    }
}
