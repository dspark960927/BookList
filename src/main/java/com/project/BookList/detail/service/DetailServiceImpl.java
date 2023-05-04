package com.project.BookList.detail.service;

import com.project.BookList.detail.VO.DetailVO;
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
public class DetailServiceImpl implements DetailService {
    public String TTBKey = "ttbdasol9551442001"; //TTBKey 값
    public String requestUrl = "http://www.aladin.co.kr/ttb/api/ItemLookUp.aspx"; //요청 Url

    @Override
    public List<DetailVO> getDetailList(String isbn) {
        String result;

        List<DetailVO> text = new ArrayList<>();
        try {
            URL url = new URL(
                    requestUrl
                            +"?ttbkey=" + TTBKey
                            +"&itemIdType=ISBN" //검색 타입
                            +"&ItemId="+isbn
                            +"&output=JS" //출력방법
                            +"&Version=20131101" //api버전
                            +"&Cover=Big" //이미지크기
            );

            System.out.println(url);

            BufferedReader bf;

            bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));

            result = bf.readLine();

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(result);

            JSONArray item = (JSONArray) jsonObject.get("item");


                DetailVO detail = new DetailVO();

                JSONObject title = (JSONObject)item.get(0);

                detail.setTitle((String)title.get("title"));
                detail.setAuthor((String)title.get("author"));
                detail.setCover((String)title.get("cover"));
                detail.setIsbn((String)title.get("isbn"));
                detail.setPubdate((String)title.get("pubDate"));
                detail.setDescription((String)title.get("description"));

                int page = Integer.valueOf(title.get("priceStandard").toString());
                detail.setPricestandard(page);

                detail.setPublisher((String)title.get("publisher"));

                text.add(detail);

        } catch (Exception e) {
            System.out.println(e);
        }
        return text;
    }
}
