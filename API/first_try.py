#!/usr/bin/python
# -*- coding: utf-8 -*-

################
# python简明教程 http://woodpecker.org.cn/abyteofpython_cn/chinese/

import requests

#测试百度
def baidu_func(url):
    headers = {}
    params = {}
    req = requests.get(url, headers=headers, params=params)
    print(req.text)
    return req


if __name__ == '__main__':
    url = "http://api.fxhyd.cn/UserInterface.aspx?action=login&username=jinzhouyongshi&password=jinzhouyongshi"
    url_2 = "http://api.fxhyd.cn/UserInterface.aspx?action=getmobile&token=005112943a6dc1f02b0a7e63fdcdc9bc0257bdff&itemid=2656"
    url_3 = "http://api.fxhyd.cn/UserInterface.aspx?action=getsms&token=TOKEN&itemid=2656&mobile=%s"

    #baidu_func(url)
    baidu_func(url_2)
    #baidu_func(url_3)