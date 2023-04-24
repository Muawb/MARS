package net;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class InputStreamTest {

    @Test
    public void testAcsess() throws URISyntaxException, IOException {
        InputStream in = getClass().getResourceAsStream("/log4j.xml");
        InputStreamReader reader = new InputStreamReader(in);
        char[] buffer = new char[1024];

        Scanner scanner = new Scanner(reader);

        while (scanner.hasNextLine()){
            String s = scanner.nextLine();
            System.out.println(s);
        }
    }

}
