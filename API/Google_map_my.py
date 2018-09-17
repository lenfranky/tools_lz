# https://maps.googleapis.com/maps/api/geocode/json?address=1600+Amphitheatre+Parkway,+Mountain+View,+CA&key=AIzaSyBQDRqUWxT1sZP1caolROGqJi7Kv3N0QoU
# https://maps.googleapis.com/maps/api/geocode/json?address=pixian&key=AIzaSyBQDRqUWxT1sZP1caolROGqJi7Kv3N0QoU

from xml.dom import minidom
import urllib2, urllib
import requests


url = 'https://maps.googleapis.com/maps/api/geocode/json?address=pixian&key=AIzaSyBQDRqUWxT1sZP1caolROGqJi7Kv3N0QoU'
# url = 'https://www.baidu.com'
headers = {}
params = {}
req = requests.get(url, headers=headers, params=params)
print(req.text)
