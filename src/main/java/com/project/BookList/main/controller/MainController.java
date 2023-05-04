package com.project.BookList.main.controller;

;
import com.project.BookList.main.VO.MainVO;
import com.project.BookList.main.service.MainService;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    MainService mainService;


    @RequestMapping("/main")
    public String Main(Model model){
        //신간
        List<MainVO> itemNew = new ArrayList<>();
        itemNew = mainService.getNewList();
        model.addAttribute("itemNew",itemNew);

        //System.out.println(itemNew);

        //베스트셀러
        List<MainVO> bestSeller = new ArrayList<>();
        bestSeller = mainService.getBestList();
        model.addAttribute("bestSeller",bestSeller);

        System.out.println(bestSeller);

        return "main";

    }






    @RequestMapping("/test")
    public String MainApi() {
        String result;

        String text = null;
        try {
            URL url = new URL("http://www.aladin.co.kr/ttb/api/ItemList.aspx?ttbkey=ttbdasol9551442001&QueryType=ItemNewAll&MaxResults=1&start=1&SearchTarget=Book&output=JS&Version=20131101");

            BufferedReader bf;

            bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));

            result = bf.readLine();

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(result);


            JSONArray item = (JSONArray) jsonObject.get("item");

            JSONObject title = (JSONObject)item.get(0);
            text = (String)title.get("title");


        } catch (Exception e) {
            System.out.println(e);


        }
        return text;




        /*
        StringBuffer result = new StringBuffer();

        try {
            String apiUrl = "http://www.aladin.co.kr/ttb/api/ItemList.aspx?ttbkey=ttbdasol9551442001&QueryType=ItemNewAll&MaxResults=1&start=1&SearchTarget=Book&output=xml&Version=20131101";
            URL url = new URL(apiUrl);

            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");

            BufferedReader br;

            br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(),"UTF-8"));

            String returnLine;


            while ((returnLine = br.readLine()) != null){
                result.append(returnLine+"\n\r");
            }

            urlConnection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //System.out.println(result.toString());
        return result.toString();
        */

    }
}
