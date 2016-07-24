package org.bella.fanclub.activity.services.impl;

import java.util.ArrayList;
import java.util.List;

public class FileRepositoryUtils {
    
    public static final int NUM_SEGMENTS_PER_PATH = 6;
    public static final int SEGMENT_LENGTH = 3;
    
    private static final char[] EMPTY_CHARS = new char[NUM_SEGMENTS_PER_PATH * SEGMENT_LENGTH];
    static {
        for (int i = 0; i < EMPTY_CHARS.length; ++i) {
            EMPTY_CHARS[i] = '0';
        }
    }
    
    public static String buildPath(List<String> segments, char delimiter, boolean leadingDelimiter, boolean trailingDelimiter) {
        StringBuilder builder = new StringBuilder();
        
        if (leadingDelimiter) {
            builder.append(delimiter);
        }
        
        for (int i = 0; i < segments.size(); ++i) {
            if (i > 0) {
                builder.append(delimiter);
            }
            builder.append(segments.get(i));
        }
        
        if (trailingDelimiter) {
            builder.append(delimiter);
        }
        
        return builder.toString();
    }
    
    public static String getPathForId(long id, char delimiter, boolean leadingDelimiter, boolean trailingDelimiter) {
        return buildPath(getPathSegmentsForId(id), delimiter, leadingDelimiter, trailingDelimiter);
    }
    
    public static List<String> getPathSegmentsForId(long id) {
        char[] chars = Long.toString(id, 16).toCharArray();
        char[] allChars = new char[EMPTY_CHARS.length];

        int numGeneratedChars = EMPTY_CHARS.length - chars.length;
        
        System.arraycopy(EMPTY_CHARS, 0, allChars, 0, numGeneratedChars);
        System.arraycopy(chars, 0, allChars, numGeneratedChars, chars.length);
        
        List<String> segments = new ArrayList<String>(NUM_SEGMENTS_PER_PATH);
        for (int i = 0; i < NUM_SEGMENTS_PER_PATH; ++i) {
            segments.add(new String(allChars, i * SEGMENT_LENGTH, SEGMENT_LENGTH));
        }
        
        return segments;
    }
}
