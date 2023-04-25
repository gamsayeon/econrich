package com.example.econrich.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@RestController
@RequestMapping("/subway")
public class SubwayController {

    @GetMapping(value = "/delay", params = {"lineNum"})
    @Operation(summary = "서울 도시철도 실시간 지연정보", description = "lineNum(호선번호)으로 서울 도시철도 실시간 지연정보를 조회합니다.")
    @Parameter(name = "lineNum", description = "조회할 호선번호의 lineNum", example = "7")
    public ResponseEntity<String> getSubwayDelay(@PathVariable("lineNum") Integer lineNum) throws IOException {
        String urlStr = "http://apis.data.go.kr/B553766/smt-delay/delay?serviceKey=fzzdYmysW%2FQc6K9FzTMP%2FFhRtzOABrMwumMEuiAO1TCa8s%2FMN5Kq6MpfB2Uc98%2BwYS8c9fpXxSJEKpGLb%2BPTGQ%3D%3D" +
                "&numOfRows=10" +
                "&pageNo=1" +
                "&lineNum=" + lineNum;
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");

        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        return ResponseEntity.ok(sb.toString());
    }
}
