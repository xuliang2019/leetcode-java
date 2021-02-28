import java.util.*;

//public class Crawler {
//    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
//        // use bfs
//        Set<String> set = new HashSet<>();
//        Queue<String> queue = new LinkedList<>();
//        String hostName = getHostName(startUrl);
//        queue.offer(startUrl);
//        set.add(startUrl);
//
//
//        while (!queue.isEmpty()) {
//            String currUrl = queue.poll();
//            List<String> parsedUrls = htmlParser.getUrls(currUrl);
//            for (String url: parsedUrls) {
//                if (url.contains(hostName) && !set.contains(url)) {
//                    queue.offer(url);
//                    set.add(url);
//                }
//            }
//        }
//        return new ArrayList<>(set);
//    }
//
//    private String getHostName(String url) {
//        String[] names = url.split("/");
//        return names[2];
//    }
//}