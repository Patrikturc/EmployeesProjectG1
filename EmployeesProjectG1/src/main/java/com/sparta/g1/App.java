package com.sparta.g1;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.time.LocalDate;
import java.util.stream.Collectors;

//This is a comment left by kian
public class App {
    public static void main(String[] args) {
        try {
            AppWindow appWindow = new AppWindow();
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
