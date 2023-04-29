package com.codenfast.developersuniverse.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.swing.text.MaskFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class StringProcess {

    public static String linkAddContextUrl(String contextUrl, String url) {
        if(url.startsWith("http")) {
            return url;
        }
        StringBuilder sb = new StringBuilder();
        if(!contextUrl.endsWith("/") && !url.startsWith("/")) {
            sb.append(contextUrl).append('/').append(url);
        } else if(contextUrl.endsWith("/") && url.startsWith("/")) {
            sb.append(contextUrl).append(url.substring(1));
        } else {
            sb.append(contextUrl).append(url);
        }
        return sb.toString();
    }

    public static String formatSize(long v) {
        if (v < 1024) return v + " B";
        int z = (63 - Long.numberOfLeadingZeros(v)) / 10;
        return String.format("%.1f %sB", (double)v / (1L << (z*10)), " KMGTPE".charAt(z));
    }

    public static String convertTurkishToEnglishCharacters(String value) {
        return value.replace("ğ", "g")
                .replace("ü", "u").replace("ş", "s")
                .replace("ö", "o").replace("ç", "c")
                .replace("Ğ", "G").replace("Ü", "U")
                .replace("Ş", "S").replace("İ", "I")
                .replace("ı", "i")
                .replace("Ö", "O").replace("Ç", "C");
    }

    public static String allUpperCase(String source) {
        return source;
    }

    public static MaskFormatter createFormatter(String s) {
        MaskFormatter formatter = null;
        try {
            formatter = new MaskFormatter(s);
        } catch (java.text.ParseException exc) {
            log.error("formatter is bad: " + exc.getMessage());
        }
        return formatter;
    }


    public static String deleteTabsAndLines(String source) {
        while (source.matches(".*([\t\r\n])|([ ]{2,}).*")) {
            source = source.replaceAll(".*([\t\n\r])|([ ]{2,}).*", " ");
        }
        return source;
    }

    public static int getCount(String text, String searchedText) {
        int lengthOfText = text.length();
        int lengthOfSearchedText = searchedText.length();
        return (lengthOfText - text.replace(searchedText,"").length()) / lengthOfSearchedText;
    }

    public static String htmlToString(String string) {
        Pattern removeTagPattern = Pattern.compile("<.+?>");
        if (StringUtils.isBlank(string)) {
            return string;
        }
        Matcher m = removeTagPattern.matcher(string);
        return m.replaceAll("");
    }
}
