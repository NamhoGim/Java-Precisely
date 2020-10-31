// Example 171 from page 137 of Java Precisely third edition (The MIT Press 2016)
// Author: Peter Sestoft (sestoft@itu.dk)

import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

class Example171 {
    public static void main(String[] args) {
        getAndPrintLinks();
    }

    public static void getAndPrintLinks() {
        Stream<String> urls = Stream.of(allUrls);
        Stream<Webpage> pages = urls.map(url -> getPage(url, 200));
        Stream<Link> links = pages.flatMap(page -> scanLinks(page));
        Stream<Link> uniqueLinks = links.distinct();
        uniqueLinks.forEach(System.out::println);  // Calls Link.toString()
    }

    private static final String[] allUrls =
            {"http://www.itu.dk", "http://www.di.ku.dk", "http://www.miele.de",
                    "http://www.microsoft.com", "http://www.amazon.com", "http://www.dr.dk",
                    "http://www.vg.no", "http://www.tv2.dk", "http://www.google.com",
                    "http://www.ing.dk", "http://www.dtu.dk", "http://www.bbc.co.uk"
            };

    public static Stream<String> getPageLines(String url) {
        try {
            InputStreamReader isr = new InputStreamReader(new URL(url).openStream());
            BufferedReader reader = new BufferedReader(isr);
            return reader.lines();
        } catch (IOException exn) {
            return Stream.empty();
        }
    }

    public static Webpage getPage(String url, int maxLines) {
        String contents =
                getPageLines(url).limit(maxLines).collect(Collectors.joining());
        return new Webpage(url, contents);
    }

    private final static Pattern urlPattern
            = Pattern.compile("a href=\"(\\p{Graph}*)\"");

    public static Stream<Link> scanLinks(Webpage page) {
        Matcher urlMatcher = urlPattern.matcher(page.contents);
        Stream.Builder<Link> links = Stream.builder();
        while (urlMatcher.find()) {
            String link = urlMatcher.group(1);
            links.accept(new Link(page.url, link));
        }
        return links.build();
    }
}


class Webpage {
    public final String url, contents;

    public Webpage(String url, String contents) {
        this.url = url;
        this.contents = contents;
    }
}

class Link {
    public final String from, to;

    public Link(String from, String to) {
        this.from = from;
        this.to = to;
    }

    public int hashCode() {
        return (from == null ? 0 : from.hashCode()) * 37
                + (to == null ? 0 : to.hashCode());
    }

    public boolean equals(Object obj) {
        Link that = obj instanceof Link ? (Link) obj : null;
        return that != null
                && (from == null ? that.from == null : from.equals(that.from))
                && (to == null ? that.to == null : to.equals(that.to));
    }

    public String toString() {
        return String.format("%s links to %s", from, to);
    }
}




