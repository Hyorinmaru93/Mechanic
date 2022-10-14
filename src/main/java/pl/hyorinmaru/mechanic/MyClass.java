//package pl.hyorinmaru.mechanic;
//
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//import org.json.JSONObject;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.URL;
//
//public class MyClass {
//    public static void main(String[] args) throws Exception {
//        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd")
//                .create();
//        try {
//            URL url = new URL("https://parseapi.back4app.com/classes/Carmodels_Car_Model_List?limit=1");
//            HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
//            urlConnection.setRequestProperty("X-Parse-Application-Id", "yGwbwvjFieuAHxIY6FCNDudxE25GDKZHbYNnJ2vV"); // This is your app's application id
//            urlConnection.setRequestProperty("X-Parse-REST-API-Key", "h3Ki9O4RBxbbWdc7o0ISVOfgyuPtk3bsj6fPexLP"); // This is your app's REST API key
//            try {
//                BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
//                StringBuilder stringBuilder = new StringBuilder();
//                String line;
//                while ((line = reader.readLine()) != null) {
//                    stringBuilder.append(line);
//                    //moje **********
//                    JSONObject linia = new JSONObject(line);
//                    System.out.println(linia);
//                    System.out.println("----");
//                    SpecialCar specialCar = gson.fromJson(linia.getJSONArray("results").toString(), SpecialCar.class);
//                    System.out.println(specialCar);
//                    //moje ************
//                }
//                JSONObject data = new JSONObject(stringBuilder.toString()); // Here you have the data that you need
//                System.out.println(data.toString(2));
//            } finally {
//                urlConnection.disconnect();
//            }
//        } catch (Exception e) {
//            System.out.println("Error: " + e.toString());
//        }
//    }
//}