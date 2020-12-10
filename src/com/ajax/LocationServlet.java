package com.ajax;

import com.alibaba.fastjson.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/location")
public class LocationServlet extends HttpServlet {
    private static Map<String, List<String>> cityMap;
    private static Map<String, List<String>> provinceMap;

    static {
        cityMap = new HashMap<>();
        List<String> areas = new ArrayList<>();
        areas.add("雁塔区");
        areas.add("莲湖区");
        areas.add("新城区");
        cityMap.put("西安市", areas);
        areas = new ArrayList<>();
        areas.add("陈仓区");
        areas.add("渭滨区");
        areas.add("新城区");
        cityMap.put("宝鸡市", areas);
        areas = new ArrayList<>();
        areas.add("临渭区");
        areas.add("高新区");
        cityMap.put("渭南市", areas);
        areas = new ArrayList<>();
        areas.add("郑州A区");
        areas.add("郑州B区");
        areas.add("郑州C区");
        cityMap.put("郑州市", areas);
        areas = new ArrayList<>();
        areas.add("洛阳A区");
        areas.add("洛阳B区");
        areas.add("洛阳C区");
        cityMap.put("洛阳市", areas);
        areas = new ArrayList<>();
        areas.add("开封A区");
        areas.add("开封B区");
        areas.add("开封C区");
        cityMap.put("开封市", areas);
        areas = new ArrayList<>();
        areas.add("南京A区");
        cityMap.put("南京市", areas);
        areas = new ArrayList<>();
        areas.add("苏州A区");
        cityMap.put("苏州市", areas);
        areas = new ArrayList<>();
        areas.add("点军区");
        cityMap.put("宜昌市", areas);
        areas = new ArrayList<>();
        areas.add("武汉a区");
        cityMap.put("武汉市", areas);
        areas = new ArrayList<>();
        areas.add("长沙a区");
        cityMap.put("长沙市", areas);
        areas = new ArrayList<>();
        areas.add("娄底a区");
        cityMap.put("娄底市", areas);

        provinceMap = new HashMap<>();
        areas = new ArrayList<>();
        areas.add("西安市");
        areas.add("宝鸡市");
        areas.add("渭南市");
        provinceMap.put("陕西省", areas);
        areas = new ArrayList<>();
        areas.add("郑州市");
        areas.add("洛阳市");
        areas.add("开封市");
        provinceMap.put("河南省", areas);
        areas = new ArrayList<>();
        areas.add("南京市");
        areas.add("苏州市");
        provinceMap.put("江苏省", areas);
        areas = new ArrayList<>();
        areas.add("宜昌市");
        areas.add("武汉市");
        provinceMap.put("湖北省", areas);
        areas = new ArrayList<>();
        areas.add("长沙市");
        areas.add("娄底市");
        provinceMap.put("湖南省", areas);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        String id = req.getParameter("id");
        String type = req.getParameter("type");
        List<String> result = new ArrayList<>();
        switch (type) {
            case "province":
                List<String> cities = provinceMap.get(id);
                String city = cities.get(0);
                List<String> areas = cityMap.get(city);
                for (String city_ : cities) {
                    result.add(city_);
                }
                result.add("");
                for (String area_ : areas) {
                    result.add(area_);
                }
                break;
            case "city":
                result = cityMap.get(id);
        }
        System.out.println(result);
        Object jsonArray = JSONArray.toJSON(result);
        resp.getWriter().write(jsonArray.toString());

    }
}
