package com.develogical;
// import org.junit.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
// import java.util.Arrays;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;
// import static org.junit.Assert.fail;

import java.lang.Math;

public class QueryProcessor {

    public String process(String query) {
        if (query.toLowerCase().contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        }
        if (query.toLowerCase().contains("test")) {
            return "Testing text";
        }
        if (query.toLowerCase().contains("what is your name")) {
            return "Team LY";
        }
        if (query.toLowerCase().contains("which of the following numbers is the largest")) {
            Pattern regex = Pattern.compile(".*?[:](.*)");
            Matcher matcher = regex.matcher(query);
            assertTrue(matcher.matches());
            assertThat(matcher.group(1), is("1 2 4 3"));
            String[] nums = (matcher.group(1)).split(" ");
            // System.out.println(Arrays.toString(nums));
            int maxN = 0;
            for (int i = 0; i < nums.length; i++){
                maxN = Math.max(maxN, Integer.parseInt(nums[i]));
            }
            return String.valueOf(maxN);
        }
        return "";
    }
}
