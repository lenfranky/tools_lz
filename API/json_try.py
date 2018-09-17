import json

result = '{"from":"en","to":"zh","trans_result":[{"src":"Have you eaten lunch?","dst":"\u4f60\u5403\u8fc7\u5348\u996d\u4e86\u5417\uff1f"}]}'
# print result
data = json.loads(result)
print type(data["trans_result"])
# print data["trans_result"][0]["dst"]