#!/usr/bin/python
# -*- coding: utf-8 -*-

import time
import requests
import re

class Phone(object):
    def get_value(self, url):
        headers = {}
        params = {}
        req = requests.get(self, url, headers=headers, params=params)
        print(req.text)
        return req

    def get_token(self, username='jinzhouyongshi',password='jinzhouyongshi'):
        headers = {}
        params = {}
        url = "http://api.fxhyd.cn/UserInterface.aspx?action=login&username=%s&password=%s"%(username,password)
        req = requests.get(url, headers=headers, params=params)
        token = req.text.split('|')[1]
        print "the token is:\t" + str(token)
        return token

    def get_phone_num(self, token='005112943a6dc1f02b0a7e63fdcdc9bc0257bdff'):
        url_get_phonenumber = "http://api.fxhyd.cn/UserInterface.aspx?action=getmobile&token=%s&itemid=2656"%token
        headers = {}
        params = {}
        req = requests.get(url_get_phonenumber, headers=headers, params=params)
        phone_number = req.text.split('|')[1]
        print "the phone_number is:\t" + str(phone_number)
        return phone_number

    def get_message(self, token, phone_number):
        url_get_message = "http://api.fxhyd.cn/UserInterface.aspx?action=getsms&token=%s&itemid=2656&mobile=%s" % (token,phone_number)
        headers = {}
        params = {}
        wait_time = 100
        req = requests.get(url_get_message, headers=headers, params=params)
        word_has_succesed = req.text.split('|')[0]
        # print "the message is:\t" + str(req.text)
        time_start = time.time()
        time_now = time.time()
        while(time_now-time_start) < wait_time and not word_has_succesed == "success":
            req = requests.get(url_get_message, headers=headers, params=params)
            word_has_succesed = req.split('|')[0]
            time_now = time.time()

        if word_has_succesed == "success":
            text = req.text.split('|')[1]
            time_waited = time_now - time_start
            print '短信内容是:\t' + text + '\n耗费时长:\t' + str(time_waited) + 's'
            return text

    def get_verification_code(self,text):
        pat = "[0-9]+"
        IC = 0
        IC = re.search(pat, text)
        code = IC.group()
        if IC:
            print"验证码是:\n" + str(code)
        else:
            print"请重新设置表达式"
        return code

    def release_phone_num(self,token,phone_num):
        url_release = 'http://api.fxhyd.cn/UserInterface.aspx?action=release&token=%s&itemid=2656&mobile=%s'%(token, phone_number)
        headers = {}
        params = {}
        req = requests.get(url_release, headers=headers, params=params)
        if req == "success":
            print "手机号码成功释放:\t%s"%phone_number


"""
if __name__ == '__main__':
    
    url = "http://api.fxhyd.cn/UserInterface.aspx?action=login&username=jinzhouyongshi&password=jinzhouyongshi"
    url_get_phonenumber = "http://api.fxhyd.cn/UserInterface.aspx?action=getmobile&token=005112943a6dc1f02b0a7e63fdcdc9bc0257bdff&itemid=2656"


    # baidu_func(url)
    list = get_value(url_get_phonenumber)
    # list = str(list.text)
    # print list
    list = list.text.split('|')[1]
    print list
    # baidu_func(url_3)
    url_get_message = "http://api.fxhyd.cn/UserInterface.aspx?action=getsms&token=TOKEN&itemid=2656&mobile=%s"%list
    get_value(url_get_message)
"""

if __name__ == '__main__':
    phone = Phone()
    token = phone.get_token(username='jinzhouyongshi',password='jinzhouyongshi')
    phone_number = phone.get_phone_num(token)
    text_message = phone.get_message(token, phone_number)
    if text_message:
        code = phone.get_verification_code(text_message)