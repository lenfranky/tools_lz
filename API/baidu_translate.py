# /usr/bin/env python
# coding=utf8

import httplib
import md5
import urllib
import random
import json

def translate_baidu(text='apple'):
    appid = '20180827000199175'  # 你的appid
    secretKey = 'eJoHgtPn_304EdwhyueZ'  # 你的密钥

    httpClient = None
    myurl = '/api/trans/vip/translate'
    fromLang = 'en'
    toLang = 'zh'
    salt = random.randint(32768, 65536)

    sign = appid + text + str(salt) + secretKey
    m1 = md5.new()
    m1.update(sign)
    sign = m1.hexdigest()
    myurl = myurl + '?appid=' + appid + '&q=' + urllib.quote(text) + '&from=' + fromLang + '&to=' + toLang + '&salt=' + str(
        salt) + '&sign=' + sign

    try:
        httpClient = httplib.HTTPConnection('api.fanyi.baidu.com')
        httpClient.request('GET', myurl)

        # response是HTTPResponse对象
        response = httpClient.getresponse()
        # print response.read()

        result = response.read()
        print result
        data = json.loads(result)
        return data["trans_result"][0]["dst"]

    except Exception, e:
        print e
    finally:
        if httpClient:
            httpClient.close()


if __name__ == '__main__':
    print translate_baidu('Have you eaten lunch?')
