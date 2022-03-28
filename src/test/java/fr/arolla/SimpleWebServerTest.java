package fr.arolla;

import com.sun.net.httpserver.SimpleFileServer;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

public class SimpleWebServerTest {

    // Will only work with Java 18
    @Test
    void should_start_web_server() throws IOException, InterruptedException {
        var classLoader = SimpleWebServerTest.class.getClassLoader();
        var resourceFolder = classLoader
                .getResource(".")
                .getPath();
        var fileName = "simpleText.txt";
        var fileContent = Files.lines(Path.of(classLoader.getResource(fileName).getPath()))
                .findFirst()
                .orElse("");

        var server = SimpleFileServer.createFileServer(new InetSocketAddress(8080), Path.of(resourceFolder), SimpleFileServer.OutputLevel.VERBOSE);
        server.start();
        var httpRequest = HttpRequest.newBuilder().GET()
                .uri(URI.create("http://127.0.0.1:8080/" + fileName))
                .build();

        var result = HttpClient.newHttpClient().send(httpRequest, HttpResponse.BodyHandlers.ofString());

        assertThat(result).isNotNull();
        assertThat(result.statusCode()).isEqualTo(200);
        assertThat(result.body()).isEqualTo(fileContent);

        server.stop(2);
    }
}
