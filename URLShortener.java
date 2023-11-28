import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class URLShortener {
    private HashMap<String, String> urlMap;
    private MessageDigest md;

    public URLShortener() {
        this.urlMap = new HashMap<>();
        try {
            this.md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public String shortenURL(String originalURL) {
        String hash = generateHash(originalURL);
        String shortURL = "https://shorturl/" + hash.substring(0, 8); // Using the first 8 characters of the hash
        urlMap.put(shortURL, originalURL);
        return shortURL;
    }

    public String getOriginalURL(String shortURL) {
        return urlMap.get(shortURL);
    }

    private String generateHash(String input) {
        byte[] hashBytes = md.digest(input.getBytes());
        StringBuilder hashStringBuilder = new StringBuilder();

        for (byte b : hashBytes) {
            hashStringBuilder.append(String.format("%02x", b));
        }

        return hashStringBuilder.toString();
    }

    public static void main(String[] args) {
        URLShortener urlShortener = new URLShortener();

        String originalURL = "https://www.google.com";
        String shortURL = urlShortener.shortenURL(originalURL);

        System.out.println("Original URL: " + originalURL);
        System.out.println("Shortened URL: " + shortURL);

        String retrievedURL = urlShortener.getOriginalURL(shortURL);
        System.out.println("Retrieved Original URL: " + retrievedURL);
    }
}
