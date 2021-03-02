package com.LockedMe;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileService {

  private static final Logger logger = LogManager.getLogger(FileService.class);
  private static final Path path = FileSystems.getDefault().getPath("src/main/resources");
  private static List<String> filenames = new ArrayList<>();

  static void refreshFilenames() {

    try {
      Stream<Path> files = Files.walk(Paths.get(path.toUri()));
      filenames = files.filter(Files::isRegularFile)
          .map(x -> x.getFileName().toString())
          .collect(Collectors.toList());
      files.close();

    } catch (Exception ex) {
      logger.error("Exception: {}", ex.toString());
    }

  }

  static List<String> getFilenames() {
    return filenames;
  }

  static void addFile(final String filename) throws URISyntaxException {

    URI uri = new URI(path.toString() + File.separator + filename);
    Path newFilePath = Paths.get(uri.getPath());

    try {
      Files.createFile(newFilePath);

    } catch (FileAlreadyExistsException repeat) {
      System.out.println("File already exists! Please try again");
      LockMeFunctions.addFile();
    } catch (IOException ex) {
      logger.error("IOException: {}", ex);
    }

    refreshFilenames();

    if (Files.exists(newFilePath)) {
      System.out.println(filename + " was successfully added.");
    } else {
      logger.error("Something wrong in addFile");
    }
  }

  static void deleteFile(final String filename) {

    try {
      URI uri = new URI(path.toString() + File.separator + filename);
      Path fileToDelete = Paths.get(uri.getPath());
      Files.deleteIfExists(fileToDelete);

      if (!Files.exists(fileToDelete)) {
        System.out.println(filename + " was successfully deleted.");
      } else {
        logger.error("Something wrong in addFile");
      }

    } catch (Exception e) {
      logger.error(e.getMessage(), e);
    }

    refreshFilenames();
  }
}
