# -*- coding: utf-8 -*-

import requests.sessions
import json

# 请求必应在线翻译首页，通过在浏览器中访问抓包请求头
headers_1 = {
    'Host': 'www.bing.com',
    'Connection': 'keep-alive',
    'Cache-Control': 'max-age=0',
    'User-Agent': 'Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.84 Safari/537.36',
    'Upgrade-Insecure-Requests': '1',
    'Accept': 'text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8',
    'Accept-Encoding': 'gzip, deflate',
    'Accept-Language': 'zh-CN,zh;q=0.9',
}

# 必应在线翻译的地址
url_str = 'http://www.bing.com/translator/?mkt=zh-CN'

# 通过session对象发起请求
sess = requests.session()
res = sess.get(url=url_str, headers=headers_1)
# print(res.status_code)
# print(res.cookies)

# 在线翻译API请求头，通过在浏览器中访问抓包获得
headers_2= {
    'Host': 'www.bing.com',
    'Connection': 'keep-alive',
    # 'Content-Length': '31',
    'Accept': 'application/json, text/javascript, */*; q=0.01',
    'Origin': 'http://www.bing.com',
    'X-Requested-With': 'XMLHttpRequest',
    'User-Agent': 'Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.84 Safari/537.36',
    'Content-Type': 'application/json; charset=UTF-8',
    'Referer': 'http://www.bing.com/translator/?mkt=zh-CN',
    'Accept-Encoding': 'gzip, deflate',
    'Accept-Language': 'zh-CN,zh;q=0.9',
}

# 在线翻译API请求地址，这是一个POST请求，必须由访问首页的会话发起，否则无法获得服务
url_str = 'http://www.bing.com/translator/api/Translate/TranslateArray?from=-&to=en'

# 请求携带的参数，由页面控制台或抓包获知其格式
# info = [{"id":652829,"text":"你好"}]
info = json.dumps([{"id": 652829, "text": "汽车"}])
print(info)

# 由访问首页的会话session发起POST请求
# response = requests.post(url=url_str, data=info, headers=header_base)
response = sess.post(url=url_str, data=info, headers=headers_2)

# 打印结果
print(response.status_code)
print(response.text)