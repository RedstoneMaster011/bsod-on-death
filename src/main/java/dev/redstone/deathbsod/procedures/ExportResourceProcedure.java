package dev.redstone.deathbsod.procedures;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ExportResourceProcedure {
    public static void exportResource(String resourcePath, String destinationPath) {
        try (InputStream stream = ExportResourceProcedure.class.getClassLoader().getResourceAsStream(resourcePath)) {
            if (stream == null) {
                System.out.println("Resource not found: " + resourcePath);
                return;
            }
            byte[] buffer = stream.readAllBytes();
            Files.write(Paths.get(destinationPath), buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}