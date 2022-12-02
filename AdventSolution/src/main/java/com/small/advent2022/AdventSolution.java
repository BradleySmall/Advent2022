package com.small.advent2022;

import lombok.extern.log4j.Log4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

@Log4j
public class AdventSolution {
    private AdventSolution() {
    }

    public static List<String> getListFromFile(String fileName) throws IOException {
        Path path = Path.of(fileName);
        AdventSolution.log.info(path.toAbsolutePath());
        try (Stream<String> lines = Files.lines(path)) {
            return lines.toList();
        }
    }
}
