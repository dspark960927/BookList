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
    public String requestSearchUrl = "http://www.aladin.co.kr/ttb/api/ItemSearch.aspx"; //검색 요청 url

    @Override
    public List<MainVO> getNewList() {
        String result;

        List<MainVO> text = new ArrayList<>();
        try {
            URL url = new URL(
                    requestUrl
                            +"?ttbkey=" + TTBKey
                            +"&QueryType=ItemNewSpecial" //주목할 만한 신간
                            +"&MaxResults=9&start=1" //최대출력개수, 시작페이지
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
                MainVO itemNew = new MainVO();

                JSONObject title = (JSONObject)item.get(i);

                itemNew.setTitle((String)title.get("title"));
                itemNew.setAuthor((String)title.get("author"));
                itemNew.setCover((String)title.get("cover"));
                itemNew.setIsbn((String)title.get("isbn"));

                text.add(itemNew);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return text;
    }

    @Override
    public List<MainVO> getBestList() {
        String result;

        List<MainVO> text = new ArrayList<>();
        try {
            URL url = new URL(
                    requestUrl
                    +"?ttbkey=" + TTBKey
                    +"&QueryType=Bestseller" //베스트샐러
                    +"&MaxResults=9&start=1" //최대출력개수, 시작페이지
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
                MainVO bestSeller = new MainVO();

                JSONObject title = (JSONObject)item.get(i);

                bestSeller.setTitle((String)title.get("title"));
                bestSeller.setAuthor((String)title.get("author"));
                bestSeller.setCover((String)title.get("cover"));
                bestSeller.setIsbn((String)title.get("isbn"));

                text.add(bestSeller);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return text;
    }

    @Override
    public List<MainVO> getSearchList(String keyword) {
        String result;

        List<MainVO> text = new ArrayList<>();

        try {
            URL url = new URL(
                    requestSearchUrl
                            +"?ttbkey=" + TTBKey
                            +"&Query=" + keyword //베스트샐러
                            +"&QueryType=Keyword" //검색어 종류
                            +"SearchTarget=Book"
                            +"&MaxResults=8&start=1" //최대출력개수, 시작페이지
                            +"&output=JS" //출력방법
                            +"&Version=20131101" //api버전
                            +"&Cover=Big" //이미지 크기
            );

            System.out.println(url);

            BufferedReader bf;

            bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));

            result = bf.readLine();

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(result);

            JSONArray item = (JSONArray) jsonObject.get("item");

            for (int i=0; i<item.size(); i++){
                MainVO search = new MainVO();

                JSONObject title = (JSONObject)item.get(i);

                search.setTitle((String)title.get("title"));
                search.setAuthor((String)title.get("author"));
                search.setCover((String)title.get("cover"));
                search.setIsbn((String)title.get("isbn"));

                text.add(search);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return text;
    }
}
