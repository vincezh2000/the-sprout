package com.example.final_app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import android.util.Log;

public class sendClass {
    //public static HttpClient httpClient=new DefaultHttpClient();
    public static String url="http://10.101.155.65/mySql3/registerServlet";

    @SuppressWarnings({ "null", "unused" })
    public static String send1(final Map<String,String>rawParams){
        //public static String send1(String action,final String course,final String id,final String teacher,final String classroom){
        String result = "";
        HttpResponse httpResponse = null;
        //用HttpClient发送请求，分为五步
        //第一步：创建HttpClient对象
        HttpClient httpCient = new DefaultHttpClient();
        if(httpCient==null){
            Log.i("nameText","httpClient is  null");
        }
        //第二步：创建代表请求的对象,参数是访问的服务器地址
        HttpPost httpPost = new HttpPost(url);//post方式
        if(httpPost==null){
            Log.i("提示","httpPost is  null");
        }
        //将要传递的参数保存到List集合中
        Log.i("nameText","1");//调试程序用，下同
        List<NameValuePair>params=new ArrayList<NameValuePair>();
        /*返回值类型Set<k>    方法是： keySet()   :返回此映射中包含的键的 Set 视图
                           将map中所有的键存入到Set集合，因为set具备迭代器，所有迭代方式取出所有的键
                            再根据get()方法  ，获取每一个键对应的值*/
        for(String key:rawParams.keySet()){//通过循环，把参数加入list
            //封装请求参数
            params.add(new BasicNameValuePair(key, rawParams.get(key)));
        }
        Log.i("nameText","2");
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(params,"UTF-8"));//setEntity
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //第三步：执行请求，获取服务器返回的信息
        Log.i("nameText","22");
        try {
            httpResponse = httpCient.execute(httpPost);
            if(httpResponse==null){
                Log.i("nameText","httpResponse is  null");
            }
        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Log.i("nameText","3");
        //第四步：检查相应的状态是否正常：检查状态码的值是200表示正常
        Log.i("nameText40",String.valueOf(httpResponse.getStatusLine().getStatusCode()));
        if (httpResponse.getStatusLine().getStatusCode() == 200) {
            //第五步：得到服务器返回对象，放到entity当中
            Log.i("nameText","4");
            HttpEntity entity=httpResponse.getEntity();
            Log.i("nameText","5");
            if(entity!=null){
                BufferedReader br = null;
                try {//返回数据放到br中
                    br = new BufferedReader(new InputStreamReader(entity.getContent()));
                    Log.i("nameText","6");
                } catch (IllegalStateException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                String line=null;

                Log.i("nameText","7");
                try {//一行行读取br中的内容，放到字符串result中
                    while((line=br.readLine())!=null){
                        result=result+line;
                        Log.i("nameText","8");
                        Log.i("line",line);}
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }}}
        Log.i("result=",result);
        return result;
    }
}



