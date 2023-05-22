package com.project.BookList.mypage.service;

import com.project.BookList.main.VO.MainVO;
import com.project.BookList.mypage.VO.*;
import com.project.BookList.mypage.mapper.MypageMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class MypageServiceImpl implements MypageService {
    private String TTBKey = "ttbdasol9551442001"; //TTBKey 값
    private String requestUrl = "http://www.aladin.co.kr/ttb/api/ItemLookUp.aspx"; //요청 url

    @Autowired
    MypageMapper mypageMapper;

    @Override
    public List<MyLikelistResultVO> myLikelistSelect(int M_NO) {

        return mypageMapper.myLikelistSelect(M_NO);
    }

    @Override
    public MyLikelistApiVO getMyLikeList(int L_NO, String isbn) {
        String result;

        MyLikelistApiVO itemNew = new MyLikelistApiVO();

        try {
            URL url = new URL(
                    requestUrl
                            + "?ttbkey=" + TTBKey
                            + "&output=JS" //출력방법
                            + "&Version=20131101" //api버전
                            + "&Cover=Big" //api버전
                            + "&ItemId=" + isbn //api버전
            );

            BufferedReader bf;

            bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));

            result = bf.readLine();

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(result);

            JSONArray item = (JSONArray) jsonObject.get("item");

            JSONObject title = (JSONObject) item.get(0);

            itemNew.setL_NO(L_NO);
            itemNew.setTitle((String) title.get("title"));
            itemNew.setCover((String) title.get("cover"));
            itemNew.setIsbn(isbn);

        } catch (Exception e) {
            System.out.println(e);
        }
        return itemNew;
    }

    @Override
    public List<MyReviewResultVO> myReviewSelect(int M_NO) {
        return mypageMapper.myReviewSelect(M_NO);
    }

    @Override
    public MyReviewApiVO getMyReviewList(int R_NO, String isbn) {
        String result;

        MyReviewApiVO itemNew = new MyReviewApiVO();

        try {
            URL url = new URL(
                    requestUrl
                            + "?ttbkey=" + TTBKey
                            + "&output=JS" //출력방법
                            + "&Version=20131101" //api버전
                            + "&Cover=Big" //api버전
                            + "&ItemId=" + isbn //api버전
            );

            BufferedReader bf;

            bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));

            result = bf.readLine();

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(result);

            JSONArray item = (JSONArray) jsonObject.get("item");

            JSONObject title = (JSONObject) item.get(0);

            itemNew.setTitle((String) title.get("title"));
            itemNew.setCover((String) title.get("cover"));

        } catch (Exception e) {
            System.out.println(e);
        }
        return itemNew;
    }
}
