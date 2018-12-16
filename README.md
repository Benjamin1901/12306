# 12306
    爬取12306余票信息，通过邮件📧发送信息。
    可以修改参数来查询余票，默认只查询硬卧的，
    如果有硬卧票，则发马上发邮件提醒,
    想要查询其他的票，在107行添加代码就可以,
    后续继续更新代码。
    
## 12306响应的数据解析
```
{"result":["%2Fesh419EZVAhpQlsUp%2BeLZGoNONL%2BgzxeyWA%2FX4NBspwUfRWe0Pm2iavKRkJhCeyfXsMiEOSA3CU%0ABbBqXPqF1DEP1aMGnGHROs25uL1Gb1JsWvLWZALSHBHM74SApzpjg%2FxAHOrkVZnf3%2FwKpQhocxcN%0AT0789seX3FPTGhtl17BgZGs4VI7RGGuFkYAOa%2BSp%2FzvXzGE1DNAnTizYBu4aun0s8adI9A7RUIXd%0A%2FzZ4vGtY1q3ALRvpVtUTCfEw39nGFlr%2FPhU5e4MSDXtu
|预订
|0h0000Z11402     #列车编号
|Z114             #车次
|VAB
|VUQ
|VAB              #出发站
|GZQ              #终点站
|11:10            #发车时间
|21:10            #到达时间
|34:00            #路程时间
|Y                #当前车次是否可购票Y是可以N是不可以
|XP2fHeGBBlak1At9ZP74cvfgtqwGtzaDqMygR%2F8gmAhgc5to4cupJvVXoiU%3D    #随机字符串，买票的时候需要加上这串数据
|20190105         #火车始发站日期
|3
|B2
|01
|21
|0
|0
| 
| 
| 
|无   #软卧
| 
| 
|有   #无座 
|     
|无   #硬卧
|无   #硬座
|     #二等座
|     #一等座
|     #商务座特等座
|      
|10401030
|1413
|0"
],"flag":"1","map":{"GGQ":"广州东","VAB":"哈尔滨西","GZQ":"广州"}}
```
