package com.maxhome.europa;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class EuropaMain {

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(EuropaMain.class);

    static List<Robot> robots = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read plateau dimensions
        if (!scanner.hasNextLine()) {
            log.error("Plateau dimensions are missing.");
            return;
        }
        String[] plateauDimensions = scanner.nextLine().trim().split(" ");
        if (plateauDimensions.length != 2) {
            log.error("Invalid plateau dimensions format. Expected: 'maxX maxY'.");
            return;
        }

        int maxX, maxY;
        try {
            maxX = Integer.parseInt(plateauDimensions[0]);
            maxY = Integer.parseInt(plateauDimensions[1]);
        } catch (NumberFormatException e) {
            log.error("Plateau dimensions must be integers.");
            return;
        }

        Plateau plateau = new Plateau(maxX, maxY);
        String nextLine = "";
        try {
            nextLine = scanner.nextLine().trim();
        } catch (NoSuchElementException ex) {
            log.error("No input provided for robot initial positions.");
            return;
        }

        while (!nextLine.isEmpty()) {
            // Read robot's initial position
            String[] robotPosition = nextLine.split(" ");

            if (robotPosition.length == 0) {
                log.info("Empty line encountered. Stopping input processing.");
                break;
            }
            if (robotPosition.length != 3) {
                log.error("Invalid robot position format. Expected: 'x y direction'.");
                continue;
            }

            int x, y;
            char direction;
            try {
                x = Integer.parseInt(robotPosition[0]);
                y = Integer.parseInt(robotPosition[1]);
                direction = robotPosition[2].charAt(0);
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                log.error("Invalid robot position values.");
                continue;
            }

            Robot robot = new Robot(x, y, direction);


            try {
                nextLine = scanner.nextLine().trim();
            } catch (NoSuchElementException ex) {
                log.error("Movement instructions are missing for robot at position: {} {} {}", x, y, direction);
                break;
            }

            String instructions = nextLine;


            for (char command : instructions.toCharArray()) {
                switch (command) {
                    case 'L' -> robot.rotateLeft();
                    case 'R' -> robot.rotateRight();
                    case 'M' -> robot.moveForward(plateau);
                    default -> log.warn("Invalid command '{}' ignored.", command);
                }
            }

            robots.add(robot);
            try {
                nextLine = scanner.nextLine().trim();
            } catch (NoSuchElementException ex) {
                log.error("No more input provided after robot instructions.");
                break;
            }
        }
        // Output final position
        log.info("Final positions of robots: {}", robots);
    }
}