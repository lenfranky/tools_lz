import codecs
import qrcode

file_path = 'F:\lz_data\event detection\my_test\qr\evaluate.txt'
file_read = codecs.open(file_path)

total_len = 0
text = ""
count = 0

for line in file_read:
    text_temp = line.replace("\r\n", "")
    print text_temp
    total_len += len(text_temp)
    print len(text_temp)
    text += text_temp + "\n"
    if total_len > 2000:
        img = qrcode.make(text)
        img.save('test_%d.png' %count)
        count += 1
        text = ""
        total_len = 0

img = qrcode.make(text)
img.save('test_%d.png' %count)


print total_len
