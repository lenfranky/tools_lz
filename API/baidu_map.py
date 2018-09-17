from urllib import parse
query = {
 'key' : 'f247cdb592eb43ebac6ccd27f796e2d2',
 'address': '北京市',
 'output':'json',
  }
base = 'http://api.map.baidu.com/geocoder?'
url = base+parse.urlencode(query)

import urllib.request
doc = urllib.request.urlopen(url)
s = doc.read().decode('utf-8')  #一定要解码！！！！
import json
jsonData = json.loads(s)
lat=jsonData['result']['location']['lat']
lng =jsonData['result']['location']['lng']