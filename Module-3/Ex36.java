// HTTP Client API Example (Java 11+)
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import java.time.Duration;

public class Ex36 {
    public static void main(String[] args) {
        try {
            // Create an HTTP Client
            HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .followRedirects(HttpClient.Redirect.NORMAL)
                .connectTimeout(Duration.ofSeconds(10))
                .build();

            // Create a request to GitHub API
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.github.com/users/octocat"))
                .header("Accept", "application/json")
                .GET()
                .build();

            // Send request and get response
            System.out.println("Sending request to GitHub API...");
            HttpResponse<String> response = client.send(request, 
                HttpResponse.BodyHandlers.ofString());

            // Print response details
            System.out.println("\nResponse Details:");
            System.out.println("Status Code: " + response.statusCode());
            System.out.println("Response Headers: " + response.headers());
            System.out.println("\nResponse Body:");
            System.out.println(response.body());

            // Make another request to a different endpoint
            HttpRequest reposRequest = HttpRequest.newBuilder()
                .uri(URI.create("https://api.github.com/users/octocat/repos"))
                .header("Accept", "application/json")
                .GET()
                .build();

            System.out.println("\nFetching repository list...");
            HttpResponse<String> reposResponse = client.send(reposRequest,
                HttpResponse.BodyHandlers.ofString());

            System.out.println("\nRepositories Response:");
            System.out.println("Status Code: " + reposResponse.statusCode());
            System.out.println("Response Body (first 500 chars):");
            String truncatedBody = reposResponse.body().substring(0, 
                Math.min(500, reposResponse.body().length()));
            System.out.println(truncatedBody + "...");

        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
