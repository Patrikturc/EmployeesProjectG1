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
        logger.log(Level.INFO, "Entered main method");
        DataSanitisation.checkValidGender("L");
        DataSanitisation.checkValidGender("M");
    }
}
