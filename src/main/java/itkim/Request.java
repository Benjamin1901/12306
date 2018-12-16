package itkim;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: 可以修改👇的参数来查询余票，默认只查询硬卧的，
 * 如果有硬卧票，则发马上发邮件提醒
 * 想要查询其他的票，在107行添加代码就可以
 * @author: KimJun
 * @date: 07/12/18 13:32
 */
public class Request {

    /**
     * 出发站 VBB代表哈尔滨西站
     */
    private static String From_Station = "HBB";

    /**
     * 终点站 GZQ代表广州东
     */
    private static String To_Station = "GZQ";

    /**
     * 想要乘坐的列车号
     */
    private static String TrainNo = "Z238";

    /**
     * 出发的时间
     */
    private static String Date = "2019-01-04";

    /**
     * 成人票
     */
    private static String Purpose_codes = "ADULT";
    /**
     * 发送 get请求
     */
    @org.junit.Test
    public static String doGet() {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // 创建参数队列
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("leftTicketDTO.train_date", Date));
        params.add(new BasicNameValuePair("leftTicketDTO.from_station", From_Station));
        params.add(new BasicNameValuePair("leftTicketDTO.to_station", To_Station));
        params.add(new BasicNameValuePair("purpose_codes", Purpose_codes));

        try {
            //参数转换为字符串
            String paramsStr = EntityUtils.toString(new UrlEncodedFormEntity(params, "UTF-8"));
            String url = "https://kyfw.12306.cn/otn/leftTicket/query" + "?" + paramsStr;
            System.out.println(url);
            // 创建httpget
            HttpGet httpget = new HttpGet(url);
            // 执行get请求.
            CloseableHttpResponse response = httpclient.execute(httpget);
            try {
                // 获取响应实体
                HttpEntity entity = response.getEntity();
                // 打印响应状态
                String code = response.getStatusLine().toString();
                if (entity != null) {
                    // 打印响应内容
                    String allData = EntityUtils.toString(entity);
                    JSONObject json = new JSONObject(allData);
                    String result = json.get("data").toString();
                    JSONObject json2 = new JSONObject(result);
                    String result1 = json2.get("result").toString();
                    System.out.println(result1);
//                    if (result1.contains(",")) {
                    String[] result2 = result1.split("\\,");
                    System.out.println(" ----> " + result2.length);
                    for (int i = 0; i < result2.length; i++) {
                        String[] message = result2[i].split("\\|");
                        Entity entity1 = new Entity();
                        entity1.setTrainNo(message[2]);
                        entity1.setStartStation(message[6]);
                        entity1.setDestStation(message[7]);
                        entity1.setStartTime(message[8]);
                        entity1.setStartDate(message[13]);
                        entity1.setArrTime(message[9]);
                        entity1.setNoSeat(message[26]);
                        entity1.setSolfSleep(message[23]);
                        entity1.setHardSeat(message[29]);
                        entity1.setHardSleep(message[28]);
//                            System.out.println(entity1.toString());
                        //想要乘坐的列车
                        if (entity1.getTrainNo().contains(TrainNo)) {
                            System.out.println(entity1.toString());

                            //只抢硬卧的列车，想要抢其他列车，可以改这里的代码
                            if (!entity1.getHardSleep().equals("无")) {
                                SendMail.SendMessage("<br/>" +
                                        " 车   次:" + entity1.getTrainNo() + "<br/>" +
                                        " 日   期:" + entity1.getStartDate() + "<br/>" +
                                        " 发车站:" + entity1.getStartStation() + "<br/>" +
                                        " 终点站:" + entity1.getDestStation() + "<br/>" +
                                        " 发车时间:" + entity1.getStartTime() + "<br/>" +
                                        " 到站时间:" + entity1.getArrTime() + "<br/>" +
                                        " 硬   卧:" + entity1.getHardSleep() + "<br/>" +
                                        " 硬   座:" + entity1.getHardSeat() + "<br/>" +
                                        " 软   卧:" + entity1.getSolfSleep() + "<br/>" +
                                        " 无   座:" + entity1.getNoSeat());
                            }
                        }
                    }
                }
                return code;
            } finally {
                response.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭连接,释放资源
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    public static void main(String[] args) throws Exception {
        while (1 > 0) {
            String code1 = doGet();
            Thread.sleep(6000);
            if (!code1.contains("200")) {
                //被反爬后 休眠一分钟
                Thread.sleep(60000);
                SendMail.SendMessage("爬虫被禁了");
            }
        }
    }
}

