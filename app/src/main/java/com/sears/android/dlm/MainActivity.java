package com.sears.android.dlm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.GridView;
import android.widget.ImageView;

import com.sears.android.dlm.Adapters.MainAdapter;
import com.sears.android.dlm.Models.CarouselModel;
import com.sears.android.dlm.Models.HorizontalModel;
import com.sears.android.dlm.Models.VerticalModel;
import com.sears.android.dlm.Models.GridModel;
import com.synnapps.carouselview.CarouselView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Vector;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    CarouselView carouselView;
    GridView gridView;
    //ArrayList<View> views = new ArrayList<>();
    static String a = "http://i.imgur.com/DvpvklR.png";
    static String[] sampleImages = {"http://s.shld.net/is/image/Sears/20180624_s_HP_Mobile_hero2_Mattress", "http://s.shld.net/is/image/Sears/20180624_s_HP_Mobile_hero3_CLO_v1"};
    ImageView iv;
    int bannerSize = 0;
    Vector<String> positions = new Vector<>();
    String jsonString = "{\n" +
            "\t\"component\": [{\n" +
            "\t\t\"type\": \"carousel\",\n" +
            "\t\t\"data\": [{\n" +
            "\t\t\t\"clickURL\": \"https://m.sears.com/appliances/b-1020003\",\n" +
            "\t\t\t\"image\": \"http://s.shld.net/is/image/Sears/20180624_s_HP_Mobile_hero1_HA_v1\"\n" +
            "\t\t}, {\n" +
            "\t\t\t\"clickURL\": \"https://m.sears.com/home-mattresses-accessories/b-5000611\",\n" +
            "\t\t\t\"image\": \"http://s.shld.net/is/image/Sears/20180624_s_HP_Mobile_hero2_Mattress\"\n" +
            "\t\t}, {\n" +
            "\t\t\t\"clickURL\": \"https://m.sears.com/clothing/b-5006935\",\n" +
            "\t\t\t\"image\": \"http://s.shld.net/is/image/Sears/20180624_s_HP_Mobile_hero3_CLO_v1\"\n" +
            "\t\t}, {\n" +
            "\t\t\t\"clickURL\": \"https://m.sears.com/outdoor-living-grills-outdoor-cooking/b-1024045\",\n" +
            "\t\t\t\"image\": \"http://s.shld.net/is/image/Sears/20180624_s_HP_Mobile_hero4_ODL_v2\"\n" +
            "\t\t}, {\n" +
            "\t\t\t\"clickURL\": \"https://m.sears.com/tools/b-1020000\",\n" +
            "\t\t\t\"image\": \"http://s.shld.net/is/image/Sears/20180624_s_HP_Mobile_hero5_TOOLS\"\n" +
            "\t\t}]\n" +
            "\t}, {\n" +
            "\t\t\"type\": \"banner\",\n" +
            "\t\t\"data\": [{\n" +
            "\t\t\t\"clickURL\": \"https://m.sears.com/en_us/dap/invehiclepickup.html\",\n" +
            "\t\t\t\"image\": \"https://s.shld.net/is/image/Sears/20180610_s_HP_Mobile_sec_IVPU\",\n" +
            "\t\t\t\"isTitle\": false,\n" +
            "\t\t\t\"title\": \"\"\n" +
            "\t\t}]\n" +
            "\t}, {\n" +
            "\t\t\"type\": \"banner1\",\n" +
            "\t\t\"data\": [{\n" +
            "\t\t\t\"clickURL\": \"https://m.sears.com/en_us/dap/invehiclepickup.html\",\n" +
            "\t\t\t\"image\": \"https://s.shld.net/is/image/Sears/20180610_s_HP_Mobile_sec_IVPU\",\n" +
            "\t\t\t\"isTitle\": false,\n" +
            "\t\t\t\"title\": \"sadsd\"\n" +
            "\t\t}, {\n" +
            "\t\t\t\"clickURL\": \"https://m.sears.com/en_us/dap/invehiclepickup.html\",\n" +
            "\t\t\t\"image\": \"https://s.shld.net/is/image/Sears/20180610_s_HP_Mobile_sec_IVPU\",\n" +
            "\t\t\t\"isTitle\": true,\n" +
            "\t\t\t\"title\": \"Recommended Items\"\n" +
            "\t\t}]\n" +
            "\t}, {\n" +
            "\t\t\"type\": \"recommendedProducts\",\n" +
            "\t\t\"data\": [{\n" +
            "\t\t\t\"clickURL\": \"\",\n" +
            "\t\t\t\"image\": \"\",\n" +
            "\t\t\t\"price\": \"80\",\n" +
            "\t\t\t\"isReduced\": false,\n" +
            "\t\t\t\"reducedPrice\": \"40\",\n" +
            "\t\t\t\"rating\": \"4\",\n" +
            "\t\t\t\"title\": \"Nike Shoes\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"clickURL\": \"\",\n" +
            "\t\t\t\"image\": \"\",\n" +
            "\t\t\t\"price\": \"90\",\n" +
            "\t\t\t\"isReduced\": true,\n" +
            "\t\t\t\"reducedPrice\": \"30\",\n" +
            "\t\t\t\"rating\": \"3\",\n" +
            "\t\t\t\"title\": \"Adidas Shoes\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"clickURL\": \"\",\n" +
            "\t\t\t\"image\": \"\",\n" +
            "\t\t\t\"price\": \"80\",\n" +
            "\t\t\t\"isReduced\": true,\n" +
            "\t\t\t\"reducedPrice\": \"40\",\n" +
            "\t\t\t\"rating\": \"4\",\n" +
            "\t\t\t\"title\": \"Nike Shoes\"\n" +
            "\t\t}\n" +
            "\t\t]\n" +
            "\t}, {\n" +
            "\t\t\"type\": \"sponsoredProducts\",\n" +
            "\t\t\"data\": [{\n" +
            "\t\t\t\"clickURL\": \"\",\n" +
            "\t\t\t\"image\": \"\",\n" +
            "\t\t\t\"price\": \"56\",\n" +
            "\t\t\t\"isReduced\": false,\n" +
            "\t\t\t\"reducedPrice\": \"43\",\n" +
            "\t\t\t\"title\": \"Crafstmen Hammer\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"clickURL\": \"\",\n" +
            "\t\t\t\"image\": \"\",\n" +
            "\t\t\t\"price\": \"56\",\n" +
            "\t\t\t\"isReduced\": true,\n" +
            "\t\t\t\"reducedPrice\": \"43\",\n" +
            "\t\t\t\"title\": \"Hammer\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"clickURL\": \"\",\n" +
            "\t\t\t\"image\": \"\",\n" +
            "\t\t\t\"price\": \"56\",\n" +
            "\t\t\t\"isReduced\": false,\n" +
            "\t\t\t\"reducedPrice\": \"43\",\n" +
            "\t\t\t\"title\": \"Wrench\"\n" +
            "\t\t}]\n" +
            "\t}, {\n" +
            "\n" +
            "\t\t\"type\": \"grid\",\n" +
            "\t\t\"data\": [{\n" +
            "\t\t\t\"image\": \"\",\n" +
            "\t\t\t\"title\": \"Shoes\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"image\": \"\",\n" +
            "\t\t\t\"title\": \"Furniture\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"image\": \"\",\n" +
            "\t\t\t\"title\": \"Men\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"image\": \"\",\n" +
            "\t\t\t\"title\": \"Women\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"image\": \"\",\n" +
            "\t\t\t\"title\": \"Toys\"\n" +
            "\t\t}]\n" +
            "\t}]\n" +
            "}";


    private ArrayList<Object> objects = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        getData(jsonString);
        recyclerView.setAdapter(new MainAdapter(this,getObject(),bannerSize,positions));




    }

    ArrayList<String> getCarouselImages(JSONObject object){
        ArrayList<String> imgs = new ArrayList<>();
        try {
            JSONArray imageData = object.getJSONArray("data");

            for(int i =0;i< imageData.length();i++){
                JSONObject img = (JSONObject) imageData.get(i);
                imgs.add(img.getString("image"));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return imgs;
    }
    static JSONObject bannerObject = new JSONObject();

    public static ArrayList<VerticalModel> getBannerImages(){
        ArrayList<VerticalModel> imgs1 = new ArrayList<>();
        Log.e("SIZE", String.valueOf(bannerObject));
        try {
            JSONArray imgdata = bannerObject.getJSONArray("data");
            for(int i =0;i< imgdata.length();i++){

                JSONObject img1 = (JSONObject) imgdata.get(i);
                imgs1.add(new VerticalModel(img1.getString("image"),img1.getString("title"), img1.getBoolean("isTitle")));
            }
        } catch (JSONException b) {
            b.printStackTrace();
        }
        return imgs1;
    }

    static JSONObject recommendedObject = new JSONObject();

    public static ArrayList<HorizontalModel> getRecommendedImages(){
        ArrayList<HorizontalModel> imgs2 = new ArrayList<>();
        Log.e("recommend", String.valueOf(recommendedObject));
        try {
            JSONArray imgsdata = recommendedObject.getJSONArray("data");
            for(int i = 0; i < imgsdata.length();i++){

                JSONObject img2 = (JSONObject) imgsdata.get(i);
                imgs2.add(new HorizontalModel(img2.getString("image"),img2.getString("title"), img2.getString("price"), img2.getBoolean("isReduced"), img2.getString("reducedPrice"), img2.getString("rating")));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return imgs2;
    }

    static JSONObject sponsoredObject = new JSONObject();

    public static ArrayList<HorizontalModel> getSponsoredImages(){
        ArrayList<HorizontalModel> imgs3 = new ArrayList<>();
        Log.e("sponsored", String.valueOf(sponsoredObject));
        try {
            JSONArray imagedata = sponsoredObject.getJSONArray("data");
            for(int i = 0; i < imagedata.length();i++){

                JSONObject img3 = (JSONObject) imagedata.get(i);
                imgs3.add(new HorizontalModel(img3.getString("image"),img3.getString("title"), img3.getString("price"), img3.getBoolean("isReduced"), img3.getString("reducedPrice")));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return imgs3;
    }


    ArrayList<VerticalModel> vms = new ArrayList<>();

    private ArrayList<Object> getObject() {
        objects.add(getCar().get(0));
        objects.add(getBannerImages());
        objects.add(getRecommendedImages());
        objects.add(getVert().get(0));
        objects.add(getSponsoredImages().get(0));
        objects.add(getVert1().get(0));
        objects.add(getGri().get(0));
        return objects;
    }



//    public static ArrayList<HorizontalModel> getHori() {
//        ArrayList<HorizontalModel>hori = new ArrayList<>();
//        hori.add(new HorizontalModel(a,"Shoes", "$100.00", false, "$50"));
//        hori.add(new HorizontalModel(a,"handbag", "$100.00", true, "$50"));
//        hori.add(new HorizontalModel(a,"Adidas Shoes", "$100.00", true, "$50"));
//        hori.add(new HorizontalModel(a,"Shoes", "$100.00", false, "$50"));
//
//        return hori;
//    }
//
//    public static ArrayList<HorizontalModel> getHori1() {
//        ArrayList<HorizontalModel>hori = new ArrayList<>();
//        hori.add(new HorizontalModel(a,"Jeans", "$100.00", false, "$50"));
//        hori.add(new HorizontalModel(a,"Shirts", "$100.00", true, "$50"));
//        hori.add(new HorizontalModel(a,"Long Sleeves", "$100.00", true, "$50"));
//        hori.add(new HorizontalModel(a,"Belts", "$100.00", false, "$50"));
//
//        return hori;
//    }

    static String[] values = {
            "Java",
            "C883",
            "Android",
            "jQuery",
            "PHP",
            "MySpace",
            "HTML5",
            "Javascript",
            "MySQL",

    };
    static String[] images = {
            a,
            a,
            a,
            a,
            a,
            a,
            a,
            a,
            a
    };


    public static ArrayList<GridModel> getGri() {
        ArrayList<GridModel>grid = new ArrayList<>();
        grid.add(new GridModel(images,values));



        return grid;
    }

    public static ArrayList<CarouselModel> getCar() {
        ArrayList<CarouselModel>car = new ArrayList<>();
        car.add(new CarouselModel(sampleImages));
        return car;
    }
//    public static ArrayList<VerticalModel> getVer() {
//        ArrayList<VerticalModel>vert = new ArrayList<>();
//        vert.add(new VerticalModel(b,"Recommended Items", true));
//
//        return vert;
//    }

    public static ArrayList<VerticalModel> getVert() {
        ArrayList<VerticalModel>vert = new ArrayList<>();
        vert.add(new VerticalModel(b,"", false));
        vert.add(new VerticalModel(b,"", false));
        vert.add(new VerticalModel(b,"Sponsored", true));

        return vert;
    }
    public static String b = "https://s.shld.net/is/image/Sears/20180610_s_HP_Mobile_sec_IVPU";
    public static ArrayList<VerticalModel> getVert1() {
        ArrayList<VerticalModel>vert = new ArrayList<>();
        vert.add(new VerticalModel(b,"", false));
        vert.add(new VerticalModel(b,"", false));
        vert.add(new VerticalModel(b,"Department", true));

        return vert;
    }

    JSONArray bannerObjects = new JSONArray();

    public void getData(String json) {
        try {
            Log.e("getData", String.valueOf("data1"));
            JSONObject jsonObject = new JSONObject(json);
            JSONArray objectArray = jsonObject.getJSONArray("component");
            JSONObject carouselObject = new JSONObject();


            for(int i =0; i < objectArray.length();i++)
            {
                JSONObject component = (JSONObject) objectArray.get(i);
                positions.add(component.getString("type"));
                if(component.getString("type").equals("carousel")){
                    carouselObject = (JSONObject) objectArray.get(i);
                    Log.e("JSONINSIDE", String.valueOf(component));
                }
                else if(component.getString("type").equals("banner")){
                    bannerObjects.put(objectArray.get(i));
                    bannerObject = (JSONObject) objectArray.get(i);
                    bannerSize +=1;

                    Log.e("banner", String.valueOf(component));
                }
                else if(component.getString("type").equals("recommendedProducts")){
                    recommendedObject = (JSONObject) objectArray.get(i);
                    Log.e("rec item", String.valueOf(component));
                }
                else if(component.getString("type").equals("sponsoredProducts")){
                    sponsoredObject = (JSONObject) objectArray.get(i);
                    Log.e("spon item", String.valueOf(component));
                }
            }
            String[]strs = new String[getCarouselImages(carouselObject).size()];
            strs = getCarouselImages(carouselObject).toArray(strs);


            sampleImages = strs;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return;
    }
}
