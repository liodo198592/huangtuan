package com.tencent.wxcloudrun;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.tencent.wxcloudrun.controller.JihuoController;
import com.tencent.wxcloudrun.model.Jihuo;
import com.tencent.wxcloudrun.model.Member;
import com.tencent.wxcloudrun.service.JihuoService;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.time.LocalDateTime;
 
@Component
public class ScheduledJihuoCaller {
    final JihuoService jihuoService;
    final Logger logger;

    public ScheduledJihuoCaller(@Autowired JihuoService jihuoService) {
        this.jihuoService = jihuoService;
        this.logger = LoggerFactory.getLogger(JihuoController.class);
    }

    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    public String getAccessToken() {
        String appId = "wx6d2ef2da124dc60a";
        String appSecret = "8f7174bcff462394b91c05d441854a20";
        String result = cn.hutool.http.HttpUtil.get("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + appId + "&secret=" + appSecret);
        JSONObject jsonObject = JSONUtil.parseObj(result);
        return jsonObject.getStr("access_token");
    }
 
    //10分钟调度一次
    @Scheduled(fixedRate = 600000)
    public void reportCurrentTime() {
        System.out.println("开始检查通知调度：现在时间是：" + dateTimeFormatter.format(LocalDateTime.now()));
        //获取调度任务
        List<Jihuo> jihuo = jihuoService.getJihuoCallTask(20);
        for (Jihuo j : jihuo) {
            //获取微信access token
            String accessToken= getAccessToken();

            System.out.println("开始调用通知：" + j.getId());

            //获取人员id进行调度
            List<Member> callmember = jihuoService.getcallmember(j.getId());
            for(Member m : callmember)
            {
                System.out.println("callname=" + m.getName() + " callwxrealid=" + m.getWxrealid());
                if(m.getWxrealid() != null)
                {
                    System.out.println("begin call=" + m.getName()); 
                    JSONObject body=new JSONObject();
                    body.set("touser",m.getWxrealid());
                    body.set("template_id","bX0xY1dNsw9vzC3goYa58XQGv_IxjOwg6wRaAZZYWcY");
                    JSONObject json=new JSONObject();
                    String time1 = j.getJihuotime().truncatedTo(ChronoUnit.SECONDS).toString().replace("T"," ");
                    json.set("time1",new JSONObject().set("value",time1));
                    json.set("thing2",new JSONObject().set("value", j.getDesc()));
                    json.set("thing3",new JSONObject().set("value", m.getName()+": 人呢，准备上线集火呀！"));
                    body.set("data",json);
                    //发送
                    String post =  cn.hutool.http.HttpUtil.post("https://api.weixin.qq.com/cgi-bin/message/subscribe/send?access_token=" + accessToken, body.toString());
                    System.out.println("call return=" + post);
                }
            }
            System.out.println("call finished " + j.getId());
            j.setIscalled(1);
            jihuoService.updateJihuo(j);
        }
    }
}