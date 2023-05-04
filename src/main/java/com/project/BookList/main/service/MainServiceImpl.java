package com.project.BookList.main.service;

import com.project.BookList.main.VO.MainVO;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class MainServiceImpl implements MainService{
    public String TTBKey = "ttbdasol9551442001"; //TTBKey 값
    public String requestUrl = "http://www.aladin.co.kr/ttb/api/ItemList.aspx"; //요청 Url

    @Override
    public List<MainVO> getMainList() {
        String result;

        List<MainVO> text = new ArrayList<>();
        try {
            URL url = new URL(
                    requestUrl
                    +"?ttbkey=" + TTBKey
                    +"&QueryType=Bestseller" //신간전체리스트
                    +"&MaxResults=12&start=1" //최대출력개수, 시작페이지
                    +"&SearchTarget=Book" //조회대상
                    +"&output=JS" //출력방법
                    +"&Version=20131101" //api버전
                    +"&Cover=Big" //api버전
            );

            BufferedReader bf;

            bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));

            result = bf.readLine();

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(result);

            JSONArray item = (JSONArray) jsonObject.get("item");

            for (int i=0; i<item.size(); i++){
                MainVO main = new MainVO();

                JSONObject title = (JSONObject)item.get(i);

                main.setTitle((String)title.get("title"));
                main.setAuthor((String)title.get("author"));
                main.setCover((String)title.get("cover"));

                text.add(main);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return text;
    }
}
