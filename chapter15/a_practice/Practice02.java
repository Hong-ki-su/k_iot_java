package org.example.chapter15.a_practice;

// 파일 데이터에 대한 데아터 분리 & 정렬

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Practice02 {
    public static void main(String[] args) {
        List<String> fileNames = Arrays.asList(
                "a.pdf", "b.png", "c.mp4"
                ,"g.ppt", "h.js", "i.jpg"
                ,"d.ppt", "e.png", "f.jpg"
        );
        // 1. 특정 획장자 필터링
        List<String> filteredFiles = fileNames.stream()
                .filter(name -> name.endsWith(".png") || name.endsWith(".jpg"))
                .collect(Collectors.toList());

        System.out.println(filteredFiles);

        List<String> sortedFiles = fileNames.stream()
                .sorted()
                .collect(Collectors.toList());

        System.out.println(sortedFiles);

    }
}
