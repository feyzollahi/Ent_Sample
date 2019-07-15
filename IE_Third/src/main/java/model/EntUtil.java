package model;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class EntUtil {
    public static Object getHTML(String urlToRead) throws Exception {
        StringBuilder result = new StringBuilder();
        URL url = new URL(urlToRead);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        rd.close();
        JSONParser parser = new JSONParser();
        Object object = parser.parse(result.toString());
        return object;
    }
    public static EntUtil entUtil = null;
    public static EntUtil getInstatnce(){
        return entUtil;
    }
    public static void setEntUtil(JSONObject config){
        entUtil = new EntUtil(config);
    }
    String firstDescription;
    String firstQuest;
    String ifYesResp;
    String ifNoResp;
    ArrayList<String> ifYesQuests = new ArrayList<String>();
    String ifNoQuest;
    public class MakeYourPhone{
        String header;
        ArrayList<Double> screenSize = new ArrayList<Double>();
        ArrayList<Integer> ramSize = new ArrayList<Integer>();
        ArrayList<Integer> frontCamera = new ArrayList<Integer>();
        ArrayList<String> color = new ArrayList<String>();
        ArrayList<BackCamera> backCameras = new ArrayList<>();

        String priceDescription;

        public MakeYourPhone(JSONObject makeCameraConfig) {
            this.priceDescription = (String) makeCameraConfig.get("priceDescription");
            this.header = (String) makeCameraConfig.get("header");
            JSONArray jsonArray = (JSONArray) makeCameraConfig.get("screenSize");
            for(int i = 0; i < jsonArray.size(); i++){
                this.screenSize.add(((Double) jsonArray.get(i)));
            }
            jsonArray = (JSONArray) makeCameraConfig.get("RamSize");
            for(int i = 0; i < jsonArray.size(); i++){
                this.ramSize.add(Math.toIntExact((Long)jsonArray.get(i)));
            }
            jsonArray = (JSONArray) makeCameraConfig.get("frontCamera");
            for(int i = 0; i < jsonArray.size(); i++){
                this.frontCamera.add(Math.toIntExact((Long)jsonArray.get(i)));
            }
            jsonArray = (JSONArray) makeCameraConfig.get("color");
            for(int i = 0; i < jsonArray.size(); i++){
                this.color.add((String) jsonArray.get(i));
            }
            jsonArray = (JSONArray) makeCameraConfig.get("backCamera");
            for(int i = 0; i < jsonArray.size(); i++){
                this.backCameras.add(new BackCamera((Long)((JSONObject) jsonArray.get(i)).get("num"), (Long)((JSONObject) jsonArray.get(i)).get("res")));
            }

        }

        public class BackCamera {
            long cameraNum;
            long res;

            public BackCamera(long cameraNum, long res) {
                this.cameraNum = cameraNum;
                this.res = res;
            }

            public long getCameraNum() {
                return cameraNum;
            }


            public long getRes() {
                return res;
            }

        }

        public String getHeader() {
            return header;
        }

        public void setHeader(String header) {
            this.header = header;
        }

        public ArrayList<Double> getScreenSize() {
            return screenSize;
        }

        public void setScreenSize(ArrayList<Double> screenSize) {
            this.screenSize = screenSize;
        }

        public ArrayList<Integer> getRamSize() {
            return ramSize;
        }

        public void setRamSize(ArrayList<Integer> ramSize) {
            this.ramSize = ramSize;
        }

        public ArrayList<Integer> getFrontCamera() {
            return frontCamera;
        }

        public void setFrontCamera(ArrayList<Integer> frontCamera) {
            this.frontCamera = frontCamera;
        }

        public ArrayList<String> getColor() {
            return color;
        }

        public void setColor(ArrayList<String> color) {
            this.color = color;
        }

        public String getPriceDescription() {
            return priceDescription;
        }

        public void setPriceDescription(String priceDescription) {
            this.priceDescription = priceDescription;
        }

        public ArrayList<BackCamera> getBackCameras() {
            return backCameras;
        }

        public void setBackCameras(ArrayList<BackCamera> backCameras) {
            this.backCameras = backCameras;
        }
    }
    MakeYourPhone makeYourPhone;

    public EntUtil(JSONObject config) {

        this.firstDescription = config.get("first").toString();
        this.firstQuest = config.get("firstQuest").toString();
        this.ifYesResp = config.get("ifyes").toString();
        this.ifNoQuest = config.get("ifno").toString();
        JSONArray jsonArray = new JSONArray();
        jsonArray = (JSONArray) config.get("ifyesQuest");
        for(int i = 0; i < jsonArray.size(); i++){
            this.ifYesQuests.add((String)((JSONObject)jsonArray.get(i)).get("name"));
        }
        this.ifNoQuest = (String) config.get("ifnoQuest");
        this.makeYourPhone = new MakeYourPhone((JSONObject) config.get("makeYourPhone"));


    }

    public String getFirstDescription() {
        return firstDescription;
    }

    public void setFirstDescription(String firstDescription) {
        this.firstDescription = firstDescription;
    }

    public String getFirstQuest() {
        return firstQuest;
    }

    public void setFirstQuest(String firstQuest) {
        this.firstQuest = firstQuest;
    }

    public String getIfYesResp() {
        return ifYesResp;
    }

    public void setIfYesResp(String ifYesResp) {
        this.ifYesResp = ifYesResp;
    }

    public String getIfNoResp() {
        return ifNoResp;
    }

    public void setIfNoResp(String ifNoResp) {
        this.ifNoResp = ifNoResp;
    }

    public ArrayList<String> getIfYesQuests() {
        return ifYesQuests;
    }

    public void setIfYesQuests(ArrayList<String> ifYesQuests) {
        this.ifYesQuests = ifYesQuests;
    }

    public String getIfNoQuest() {
        return ifNoQuest;
    }

    public void setIfNoQuest(String ifNoQuest) {
        this.ifNoQuest = ifNoQuest;
    }

    public MakeYourPhone getMakeYourPhone() {
        return makeYourPhone;
    }

    public void setMakeYourPhone(MakeYourPhone makeYourPhone) {
        this.makeYourPhone = makeYourPhone;
    }
}
